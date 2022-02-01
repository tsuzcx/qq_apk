package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public abstract class CustomBackgroundRunningNotificationLogic
  implements k
{
  @Keep
  public CustomBackgroundRunningNotificationLogic(String paramString) {}
  
  public abstract Notification aSx();
  
  public abstract int aSy();
  
  public abstract void aSz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
 * JD-Core Version:    0.7.0.1
 */