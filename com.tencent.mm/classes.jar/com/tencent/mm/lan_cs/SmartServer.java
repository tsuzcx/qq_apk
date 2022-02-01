package com.tencent.mm.lan_cs;

public final class SmartServer
{
  public static class C2Java
  {
    public static void onSendFail(String paramString, int paramInt) {}
    
    public static void onSendProgressChange(String paramString, long paramLong1, long paramLong2) {}
    
    public static void onSendSucc(String paramString) {}
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
    public String filePath = null;
    public int fileType = 0;
    public int idleTimeoutMs = -1;
    public int totalSendTimeoutMs = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.lan_cs.SmartServer
 * JD-Core Version:    0.7.0.1
 */