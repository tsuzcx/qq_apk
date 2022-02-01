package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Client
{
  public static a gIB;
  
  public static class C2Java
  {
    public static void onDisconnect(String paramString, int paramInt)
    {
      AppMethodBeat.i(133658);
      if (Client.gIB != null) {
        Client.gIB.alf();
      }
      AppMethodBeat.o(133658);
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133657);
      if (Client.gIB != null) {
        Client.gIB.onRecv(paramString, paramInt, paramArrayOfByte);
      }
      AppMethodBeat.o(133657);
    }
  }
  
  public static class Java2C
  {
    public static native void disconnect();
    
    public static native int send(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface a
  {
    public abstract void alf();
    
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.lan_cs.Client
 * JD-Core Version:    0.7.0.1
 */