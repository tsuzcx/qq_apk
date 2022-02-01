package com.tencent.midas.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;

public abstract interface IAPPluginBroadcastReceiver
{
  public abstract void IInit(String paramString1, String paramString2, BroadcastReceiver paramBroadcastReceiver, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean);
  
  public abstract void IOnReceive(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.IAPPluginBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */