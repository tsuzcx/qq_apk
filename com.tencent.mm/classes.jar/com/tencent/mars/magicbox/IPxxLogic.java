package com.tencent.mars.magicbox;

public class IPxxLogic
{
  private static IPxxLogic.ICallBack callBack = null;
  
  private static String getCrashFilePath(int paramInt)
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getCrashFilePath(paramInt);
  }
  
  private static String getUplodLogExtrasInfo()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getUplodLogExtrasInfo();
  }
  
  public static native void onIPxx(String paramString, int paramInt);
  
  public static void recoverLinkAddrs()
  {
    if (callBack == null) {
      return;
    }
    callBack.recoverLinkAddrs();
  }
  
  public static void setCallBack(IPxxLogic.ICallBack paramICallBack)
  {
    callBack = paramICallBack;
  }
  
  public static native void setHost(String paramString);
  
  private static void setNewDnsDebugHostInfo(String paramString, int paramInt)
  {
    if (callBack == null) {
      return;
    }
    callBack.setNewDnsDebugHostInfo(paramString, paramInt);
  }
  
  public static native void uploadFile(String paramString1, int paramInt, long paramLong, String paramString2);
  
  public static native void uploadLog(int paramInt, int[] paramArrayOfInt, boolean paramBoolean, long paramLong, String paramString);
  
  public static void uploadLogFail()
  {
    if (callBack == null) {
      return;
    }
    callBack.uploadLogFail();
  }
  
  public static void uploadLogResponse(long paramLong1, long paramLong2)
  {
    if (callBack == null) {
      return;
    }
    callBack.uploadLogResponse(paramLong1, paramLong2);
  }
  
  public static void uploadLogSuccess()
  {
    if (callBack == null) {
      return;
    }
    callBack.uploadLogSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.magicbox.IPxxLogic
 * JD-Core Version:    0.7.0.1
 */