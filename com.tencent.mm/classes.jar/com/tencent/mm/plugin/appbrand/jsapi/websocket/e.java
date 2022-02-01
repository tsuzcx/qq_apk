package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.z.e.a;
import com.tencent.mm.plugin.appbrand.z.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

public abstract interface e
{
  public static final String iIu = null;
  
  public abstract void RU(String paramString);
  
  public abstract void RV(String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(Socket paramSocket);
  
  public abstract void a(Timer paramTimer);
  
  public abstract String aOZ();
  
  public abstract void bL(String paramString, int paramInt);
  
  public abstract Timer bpH();
  
  public abstract void close();
  
  public abstract void connect();
  
  public abstract Socket getSocket();
  
  public abstract boolean isOpen();
  
  public abstract void o(ByteBuffer paramByteBuffer);
  
  public abstract void setTcpNoDelay(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void OI(String paramString);
    
    public abstract void QQ(String paramString);
    
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