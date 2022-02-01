package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.jsapi.n;

public abstract class CustomBackgroundRunningNotificationLogic
  implements n
{
  @Keep
  public CustomBackgroundRunningNotificationLogic(String paramString) {}
  
  public abstract Notification byP();
  
  public abstract void byQ();
  
  public abstract int getNotificationId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
 * JD-Core Version:    0.7.0.1
 */