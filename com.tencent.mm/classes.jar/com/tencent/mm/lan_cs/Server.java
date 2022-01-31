package com.tencent.mm.lan_cs;

public final class Server
{
  public static a dOI;
  
  public static class C2Java
  {
    public static void onConnect(String paramString, int paramInt)
    {
      if (Server.dOI != null) {
        Server.dOI.onConnect(paramString, paramInt);
      }
    }
    
    public static void onDisconnect(String paramString, int paramInt)
    {
      if (Server.dOI != null) {
        Server.dOI.EL();
      }
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      if (Server.dOI != null) {
        Server.dOI.onRecv(paramString, paramInt, paramArrayOfByte);
      }
    }
    
    public static void onSend(String paramString, int paramInt1, int paramInt2)
    {
      if (Server.dOI != null) {
        Server.dOI.hC(paramInt2);
      }
    }
  }
  
  public static class Java2C
  {
    public static native int send(String paramString, int paramInt, byte[] paramArrayOfByte);
    
    private static native Object[] start();
    
    public static native void stop();
  }
  
  public static abstract interface a
  {
    public abstract void EL();
    
    public abstract void hC(int paramInt);
    
    public abstract void onConnect(String paramString, int paramInt);
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Server
 * JD-Core Version:    0.7.0.1
 */