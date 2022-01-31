package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Server
{
  public static a eMv;
  
  public static class C2Java
  {
    public static void onConnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(114648);
      if (Server.eMv != null) {
        Server.eMv.onConnect(paramString, paramInt);
      }
      AppMethodBeat.o(114648);
    }
    
    public static void onDisconnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(114649);
      if (Server.eMv != null) {
        Server.eMv.ST();
      }
      AppMethodBeat.o(114649);
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(114647);
      if (Server.eMv != null) {
        Server.eMv.onRecv(paramString, paramInt, paramArrayOfByte);
      }
      AppMethodBeat.o(114647);
    }
    
    public static void onSend(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(114646);
      if (Server.eMv != null) {
        Server.eMv.jT(paramInt2);
      }
      AppMethodBeat.o(114646);
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
    public abstract void ST();
    
    public abstract void jT(int paramInt);
    
    public abstract void onConnect(String paramString, int paramInt);
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Server
 * JD-Core Version:    0.7.0.1
 */