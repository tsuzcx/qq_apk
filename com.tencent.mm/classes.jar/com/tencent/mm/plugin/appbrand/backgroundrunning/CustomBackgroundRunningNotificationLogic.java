package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public abstract class CustomBackgroundRunningNotificationLogic
  implements k
{
  @Keep
  public CustomBackgroundRunningNotificationLogic(String paramString) {}
  
  public abstract Notification aZu();
  
  public abstract int aZv();
  
  public abstract void aZw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
 * JD-Core Version:    0.7.0.1
 */