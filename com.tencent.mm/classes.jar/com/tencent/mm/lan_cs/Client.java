package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Client
{
  public static a eMu;
  
  public static class C2Java
  {
    public static void onDisconnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(114645);
      if (Client.eMu != null) {
        Client.eMu.ST();
      }
      AppMethodBeat.o(114645);
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(114644);
      if (Client.eMu != null) {
        Client.eMu.onRecv(paramString, paramInt, paramArrayOfByte);
      }
      AppMethodBeat.o(114644);
    }
  }
  
  public static class Java2C
  {
    public static native void disconnect();
    
    public static native int send(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface a
  {
    public abstract void ST();
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Client
 * JD-Core Version:    0.7.0.1
 */