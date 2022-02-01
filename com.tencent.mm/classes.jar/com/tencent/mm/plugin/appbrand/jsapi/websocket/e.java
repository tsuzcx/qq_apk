package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.aa.e.a;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

public abstract interface e
{
  public static final String iFB = null;
  
  public abstract void Rl(String paramString);
  
  public abstract void Rm(String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(Socket paramSocket);
  
  public abstract void a(Timer paramTimer);
  
  public abstract String aOC();
  
  public abstract void bI(String paramString, int paramInt);
  
  public abstract Timer boX();
  
  public abstract void close();
  
  public abstract void connect();
  
  public abstract Socket getSocket();
  
  public abstract boolean isOpen();
  
  public abstract void o(ByteBuffer paramByteBuffer);
  
  public abstract void setTcpNoDelay(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void Ob(String paramString);
    
    public abstract void Qh(String paramString);
    
    public abstract void a(a parama);
    
    public abstract void a(h paramh, Map<String, Long> paramMap);
    
    public abstract void aa(int paramInt, String paramString);
    
    public abstract void k(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.e
 * JD-Core Version:    0.7.0.1
 */