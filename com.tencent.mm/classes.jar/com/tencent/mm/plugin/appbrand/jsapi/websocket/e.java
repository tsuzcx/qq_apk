package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.ae.e.a;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

public abstract interface e
{
  public static final String jEY = null;
  
  public abstract void a(a parama);
  
  public abstract void a(Socket paramSocket);
  
  public abstract void a(Timer paramTimer);
  
  public abstract void abA(String paramString);
  
  public abstract void abz(String paramString);
  
  public abstract Timer bLn();
  
  public abstract void bQ(String paramString, int paramInt);
  
  public abstract String bjl();
  
  public abstract void close();
  
  public abstract void connect();
  
  public abstract Socket getSocket();
  
  public abstract boolean isOpen();
  
  public abstract void o(ByteBuffer paramByteBuffer);
  
  public abstract void setTcpNoDelay(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void XT(String paramString);
    
    public abstract void a(a parama);
    
    public abstract void a(h paramh, Map<String, Long> paramMap);
    
    public abstract void aar(String paramString);
    
    public abstract void ae(int paramInt, String paramString);
    
    public abstract void k(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.e
 * JD-Core Version:    0.7.0.1
 */