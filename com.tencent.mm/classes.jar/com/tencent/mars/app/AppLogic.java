package com.tencent.mars.app;

public class AppLogic
{
  private static final String TAG = "mars.app.NativeAppJni$C2Java";
  private static ICallBack callBack = null;
  
  private static AccountInfo getAccountInfo()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getAccountInfo();
  }
  
  public static String getAppFilePath()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getAppFilePath();
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
  
  private static DeviceInfo getDeviceType()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getDeviceType();
  }
  
  public static void setCallBack(ICallBack paramICallBack)
  {
    callBack = paramICallBack;
  }
  
  public static class AccountInfo
  {
    public long uin = 0L;
    public String userName = "";
    
    public AccountInfo() {}
    
    public AccountInfo(long paramLong, String paramString)
    {
      this.uin = paramLong;
      this.userName = paramString;
    }
  }
  
  public static class DeviceInfo
  {
    public String devicename = "";
    public String devicetype = "";
    
    public DeviceInfo(String paramString1, String paramString2)
    {
      this.devicename = paramString1;
      this.devicetype = paramString2;
    }
  }
  
  public static abstract interface ICallBack
  {
    public abstract AppLogic.AccountInfo getAccountInfo();
    
    public abstract String getAppFilePath();
    
    public abstract int getClientVersion();
    
    public abstract String getCurLanguage();
    
    public abstract AppLogic.DeviceInfo getDeviceType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.app.AppLogic
 * JD-Core Version:    0.7.0.1
 */