package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Server
{
  public static a khv;
  
  public static class C2Java
  {
    public static void onConnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(133661);
      if (Server.khv != null) {
        Server.khv.onConnect(paramString, paramInt);
      }
      AppMethodBeat.o(133661);
    }
    
    public static void onDisconnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(133662);
      if (Server.khv != null) {
        Server.khv.aJb();
      }
      AppMethodBeat.o(133662);
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133660);
      if (Server.khv != null) {
        Server.khv.onRecv(paramString, paramInt, paramArrayOfByte);
      }
      AppMethodBeat.o(133660);
    }
    
    public static void onSend(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(133659);
      if (Server.khv != null) {
        Server.khv.sM(paramInt2);
      }
      AppMethodBeat.o(133659);
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
    public abstract void aJb();
    
    public abstract void onConnect(String paramString, int paramInt);
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
    
    public abstract void sM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Server
 * JD-Core Version:    0.7.0.1
 */