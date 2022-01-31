package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzac;

public final class zzth
{
  static zzbay zzabw;
  static Boolean zzabx;
  static Object zztX = new Object();
  
  public static boolean zzak(Context paramContext)
  {
    zzac.zzw(paramContext);
    if (zzabx != null) {
      return zzabx.booleanValue();
    }
    boolean bool = zztm.zza(paramContext, "com.google.android.gms.analytics.AnalyticsReceiver", false);
    zzabx = Boolean.valueOf(bool);
    return bool;
  }
  
  public final void onReceive(Context paramContext, Intent arg2)
  {
    localzztd = zzsc.zzan(paramContext).zznS();
    if (??? == null) {
      localzztd.zzbS("AnalyticsReceiver called with null intent");
    }
    do
    {
      return;
      ??? = ???.getAction();
      localzztd.zza("Local AnalyticsReceiver got", ???);
    } while (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(???));
    boolean bool = zzti.zzal(paramContext);
    Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    localIntent.setComponent(new ComponentName(paramContext, "com.google.android.gms.analytics.AnalyticsService"));
    localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    synchronized (zztX)
    {
      paramContext.startService(localIntent);
      if (!bool) {
        return;
      }
    }
    try
    {
      if (zzabw == null)
      {
        paramContext = new zzbay(paramContext, 1, "Analytics WakeLock");
        zzabw = paramContext;
        paramContext.setReferenceCounted(false);
      }
      zzabw.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzztd.zzbS("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzth
 * JD-Core Version:    0.7.0.1
 */