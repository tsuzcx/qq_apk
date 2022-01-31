package com.tencent.mars.app;

public abstract interface AppLogic$ICallBack
{
  public abstract AppLogic.AccountInfo getAccountInfo();
  
  public abstract String getAppFilePath();
  
  public abstract int getClientVersion();
  
  public abstract String getCurLanguage();
  
  public abstract AppLogic.DeviceInfo getDeviceType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.app.AppLogic.ICallBack
 * JD-Core Version:    0.7.0.1
 */