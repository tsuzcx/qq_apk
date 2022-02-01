package com.tencent.midas.plugin;

import android.app.Dialog;
import android.content.Intent;

public class APPluginParams
{
  public String mApkFilePath;
  public String mConponentName;
  public Dialog mDialog;
  public boolean mDialogDismissBySDK = true;
  public Intent mIntent;
  public String mPluginName;
  int mPluginType = 0;
  public String mProgressTips;
  public Class<?> mProxyActivityClass;
  public int mRequestCode = -1;
  public int mTimeOut = 10000;
  
  public APPluginParams(int paramInt)
  {
    this.mPluginType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginParams
 * JD-Core Version:    0.7.0.1
 */