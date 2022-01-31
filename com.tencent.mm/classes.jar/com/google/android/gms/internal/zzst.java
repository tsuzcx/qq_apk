package com.google.android.gms.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;

public class zzst
  extends zzsa
{
  private boolean zzafg;
  private boolean zzafh;
  private AlarmManager zzafi = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzst(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  private PendingIntent zzpE()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    localIntent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zzob();
    this.zzafh = false;
    this.zzafi.cancel(zzpE());
  }
  
  public void schedule()
  {
    zzob();
    zzac.zza(zzpD(), "Receiver not registered");
    long l1 = zznT().zzpe();
    if (l1 > 0L)
    {
      cancel();
      long l2 = zznR().elapsedRealtime();
      this.zzafh = true;
      this.zzafi.setInexactRepeating(2, l2 + l1, 0L, zzpE());
    }
  }
  
  public boolean zzcy()
  {
    return this.zzafh;
  }
  
  protected void zzmS()
  {
    try
    {
      this.zzafi.cancel(zzpE());
      if (zznT().zzpe() > 0L)
      {
        ActivityInfo localActivityInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
        if ((localActivityInfo != null) && (localActivityInfo.enabled))
        {
          zzbP("Receiver registered. Using alarm for local dispatch.");
          this.zzafg = true;
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  public boolean zzpD()
  {
    return this.zzafg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzst
 * JD-Core Version:    0.7.0.1
 */