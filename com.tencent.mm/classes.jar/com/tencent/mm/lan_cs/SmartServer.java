package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SmartServer
{
  public static a mHU;
  
  public static class C2Java
  {
    public static void onSendFail(String paramString, int paramInt)
    {
      AppMethodBeat.i(235651);
      if (SmartServer.mHU != null) {
        SmartServer.mHU.onSendFail(paramString, paramInt);
      }
      AppMethodBeat.o(235651);
    }
    
    public static void onSendProgressChange(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(235648);
      if (SmartServer.mHU != null) {
        SmartServer.mHU.onSendProgressChange(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(235648);
    }
    
    public static void onSendSucc(String paramString)
    {
      AppMethodBeat.i(235649);
      if (SmartServer.mHU != null) {
        SmartServer.mHU.onSendSucc(paramString);
      }
      AppMethodBeat.o(235649);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.lan_cs.SmartServer
 * JD-Core Version:    0.7.0.1
 */