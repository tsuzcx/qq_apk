package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import androidx.annotation.Keep;
import com.tencent.mm.plugin.appbrand.jsapi.m;

public abstract class CustomBackgroundRunningNotificationLogic
  implements m
{
  @Keep
  public CustomBackgroundRunningNotificationLogic(String paramString) {}
  
  public abstract Notification bKd();
  
  public abstract int bKe();
  
  public abstract void bKf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
 * JD-Core Version:    0.7.0.1
 */