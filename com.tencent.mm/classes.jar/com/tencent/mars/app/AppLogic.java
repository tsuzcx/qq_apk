package com.tencent.mars.app;

public class AppLogic
{
  private static final String TAG = "mars.app.NativeAppJni$C2Java";
  private static AppLogic.ICallBack callBack = null;
  
  private static AppLogic.AccountInfo getAccountInfo()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getAccountInfo();
  }
  
  public static String getAppFilePath()
  {
    String str = null;
    if (callBack != null) {
      str = callBack.getAppFilePath();
    }
    return str;
  }
  
  private static int getClientVersion()
  {
    if (callBack == null) {
      return 0;
    }
    return callBack.getClientVersion();
  }
  
  private static String getCurLanguage()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getCurLanguage();
  }
  
  private static AppLogic.DeviceInfo getDeviceType()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getDeviceType();
  }
  
  public static void setCallBack(AppLogic.ICallBack paramICallBack)
  {
    callBack = paramICallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.app.AppLogic
 * JD-Core Version:    0.7.0.1
 */