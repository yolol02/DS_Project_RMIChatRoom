package com.remote.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.remote.client.InterfaceClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public interface InterfaceServer extends Remote{    
    //This feature is used to distribute messages to all connected clients
    void broadcastMessage(String message,List<String> list) throws RemoteException;
    
    //This feature is used to distribute shared files to all connected clients
    void broadcastMessage(ArrayList<Integer> inc,List<String> list,String filename) throws RemoteException;
    
    //This function retrieves the name of the connected client
    Vector<String> getListClientByName(String name) throws RemoteException;
    
    //This function adds a connected client to the list of connected clients
    void addClient(InterfaceClient client) throws RemoteException;
    
    //This function is used to prevent clients from sending messages, but can receive messages
    void blockClient(List<String> clients) throws RemoteException;
    
    //This function can completely delete the list of chat clients (kick out)
    void removeClient(List<String> clients) throws RemoteException;
    
    //This function can completely delete the list of chat clients (kick out)
    void removeClient(String clients) throws RemoteException;
    
    //This function is used to activate the client in the chat room, for example, in the case of "block"
    void reactiveClient(List<String> clients) throws RemoteException;
    
    //This function verifies is whether username already exists in the server, because username is an identifier in the chat room
    boolean checkUsername(String username) throws RemoteException;
}