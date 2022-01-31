package com.tencent.mm.lan_cs;

public final class Client
{
  public static a dOH;
  
  public static class C2Java
  {
    public static void onDisconnect(String paramString, int paramInt)
    {
      if (Client.dOH != null) {
        Client.dOH.EL();
      }
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      if (Client.dOH != null) {
        Client.dOH.onRecv(paramString, paramInt, paramArrayOfByte);
      }
    }
  }
  
  public static class Java2C
  {
    public static native void disconnect();
    
    public static native int send(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface a
  {
    public abstract void EL();
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Client
 * JD-Core Version:    0.7.0.1
 */