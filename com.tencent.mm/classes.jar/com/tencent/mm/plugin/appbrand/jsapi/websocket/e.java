package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.ah.e.a;
import com.tencent.mm.plugin.appbrand.ah.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

public abstract interface e
{
  public static final String ppa = null;
  
  public abstract void a(a parama);
  
  public abstract void a(Timer paramTimer);
  
  public abstract void acu(String paramString);
  
  public abstract void acv(String paramString);
  
  public abstract void b(Socket paramSocket);
  
  public abstract String bQs();
  
  public abstract void cN(String paramString, int paramInt);
  
  public abstract void close();
  
  public abstract void connect();
  
  public abstract Socket cxA();
  
  public abstract Timer cxz();
  
  public abstract boolean isOpen();
  
  public abstract void r(ByteBuffer paramByteBuffer);
  
  public abstract void setTcpNoDelay(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void Yf(String paramString);
    
    public abstract void a(a parama);
    
    public abstract void a(h paramh, Map<String, String> paramMap);
    
    public abstract void abg(String paramString);
    
    public abstract void ap(int paramInt, String paramString);
    
    public abstract void n(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.e
 * JD-Core Version:    0.7.0.1
 */