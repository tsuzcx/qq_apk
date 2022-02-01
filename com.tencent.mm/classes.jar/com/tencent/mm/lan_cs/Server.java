package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Server
{
  public static a gIC;
  
  public static class C2Java
  {
    public static void onConnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(133661);
      if (Server.gIC != null) {
        Server.gIC.onConnect(paramString, paramInt);
      }
      AppMethodBeat.o(133661);
    }
    
    public static void onDisconnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(133662);
      if (Server.gIC != null) {
        Server.gIC.alf();
      }
      AppMethodBeat.o(133662);
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133660);
      if (Server.gIC != null) {
        Server.gIC.onRecv(paramString, paramInt, paramArrayOfByte);
      }
      AppMethodBeat.o(133660);
    }
    
    public static void onSend(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(133659);
      if (Server.gIC != null) {
        Server.gIC.mY(paramInt2);
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
    public abstract void alf();
    
    public abstract void mY(int paramInt);
    
    public abstract void onConnect(String paramString, int paramInt);
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Server
 * JD-Core Version:    0.7.0.1
 */