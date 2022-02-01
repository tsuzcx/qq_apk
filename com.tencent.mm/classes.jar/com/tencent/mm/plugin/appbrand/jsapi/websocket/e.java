package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.af.e.a;
import com.tencent.mm.plugin.appbrand.af.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

public abstract interface e
{
  public static final String mvB = null;
  
  public abstract void a(a parama);
  
  public abstract void a(Timer paramTimer);
  
  public abstract void ajt(String paramString);
  
  public abstract void aju(String paramString);
  
  public abstract void b(Socket paramSocket);
  
  public abstract Timer bXn();
  
  public abstract Socket bXo();
  
  public abstract String bsL();
  
  public abstract void close();
  
  public abstract void cn(String paramString, int paramInt);
  
  public abstract void connect();
  
  public abstract boolean isOpen();
  
  public abstract void l(ByteBuffer paramByteBuffer);
  
  public abstract void setTcpNoDelay(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(h paramh, Map<String, Long> paramMap);
    
    public abstract void afG(String paramString);
    
    public abstract void ag(int paramInt, String paramString);
    
    public abstract void aii(String paramString);
    
    public abstract void h(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.e
 * JD-Core Version:    0.7.0.1
 */