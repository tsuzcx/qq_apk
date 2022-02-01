package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SmartServer
{
  static a khw;
  
  public static Object[] a(a parama)
  {
    AppMethodBeat.i(243993);
    khw = parama;
    parama = Java2C.access$000();
    AppMethodBeat.o(243993);
    return parama;
  }
  
  public static void addFileInfo(ServerFileInfo paramServerFileInfo)
  {
    AppMethodBeat.i(243995);
    Java2C.addFileInfo(paramServerFileInfo);
    AppMethodBeat.o(243995);
  }
  
  public static int removeFileInfo(String paramString)
  {
    AppMethodBeat.i(243996);
    int i = Java2C.removeFileInfo(paramString);
    AppMethodBeat.o(243996);
    return i;
  }
  
  public static void stopSmartServer()
  {
    AppMethodBeat.i(243994);
    Java2C.stopSmartServer();
    AppMethodBeat.o(243994);
  }
  
  public static class C2Java
  {
    public static void onSendFail(String paramString, int paramInt)
    {
      AppMethodBeat.i(244142);
      if (SmartServer.khw != null) {
        SmartServer.khw.onSendFail(paramString, paramInt);
      }
      AppMethodBeat.o(244142);
    }
    
    public static void onSendProgressChange(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(244140);
      if (SmartServer.khw != null) {
        SmartServer.khw.onSendProgressChange(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(244140);
    }
    
    public static void onSendSucc(String paramString)
    {
      AppMethodBeat.i(244141);
      if (SmartServer.khw != null) {
        SmartServer.khw.onSendSucc(paramString);
      }
      AppMethodBeat.o(244141);
    }
  }
  
  public static class Java2C
  {
    public static native void addFileInfo(SmartServer.ServerFileInfo paramServerFileInfo);
    
    public static native int removeFileInfo(String paramString);
    
    private static native Object[] startSmartServer();
    
    public static native void stopSmartServer();
  }
  
  public static class ServerFileInfo
  {
    public int betweenRequestTimeoutMs = -1;
    public String cgi = null;
    public String cryptKey = null;
    public String filePath = null;
    public int fileType = 0;
    public int idleTimeoutMs = -1;
    public int totalSendTimeoutMs = -1;
  }
  
  public static abstract interface a
  {
    public abstract void onSendFail(String paramString, int paramInt);
    
    public abstract void onSendProgressChange(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onSendSucc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.lan_cs.SmartServer
 * JD-Core Version:    0.7.0.1
 */