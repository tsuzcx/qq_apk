package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.u.e.a;
import com.tencent.mm.plugin.appbrand.u.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Timer;

public abstract interface e
{
  public static final String hwp = null;
  
  public abstract void CY(String paramString);
  
  public abstract void CZ(String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(Socket paramSocket);
  
  public abstract void a(Timer paramTimer);
  
  public abstract String aAR();
  
  public abstract Timer aGh();
  
  public abstract void bj(String paramString, int paramInt);
  
  public abstract void close();
  
  public abstract void connect();
  
  public abstract Socket getSocket();
  
  public abstract boolean isOpen();
  
  public abstract void l(ByteBuffer paramByteBuffer);
  
  public abstract void setTcpNoDelay(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void AM(String paramString);
    
    public abstract void CD(String paramString);
    
    public abstract void N(int paramInt, String paramString);
    
    public abstract void a(a parama);
    
    public abstract void b(h paramh);
    
    public abstract void h(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.e
 * JD-Core Version:    0.7.0.1
 */