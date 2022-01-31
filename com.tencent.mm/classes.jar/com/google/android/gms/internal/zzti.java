package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.gms.common.internal.zzac;

public final class zzti
{
  private static Boolean zzaby;
  private final Context mContext;
  private final Handler mHandler;
  private final zzti.zza zzagJ;
  
  public zzti(zzti.zza paramzza)
  {
    this.mContext = paramzza.getContext();
    zzac.zzw(this.mContext);
    this.zzagJ = paramzza;
    this.mHandler = new Handler();
  }
  
  public static boolean zzal(Context paramContext)
  {
    zzac.zzw(paramContext);
    if (zzaby != null) {
      return zzaby.booleanValue();
    }
    boolean bool = zztm.zzy(paramContext, "com.google.android.gms.analytics.AnalyticsService");
    zzaby = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzmt()
  {
    try
    {
      synchronized (zzth.zztX)
      {
        zzbay localzzbay = zzth.zzabw;
        if ((localzzbay != null) && (localzzbay.isHeld())) {
          localzzbay.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public final void onCreate()
  {
    zzsc.zzan(this.mContext).zznS().zzbP("Local AnalyticsService is starting up");
  }
  
  public final void onDestroy()
  {
    zzsc.zzan(this.mContext).zznS().zzbP("Local AnalyticsService is shutting down");
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzmt();
    zzsc localzzsc = zzsc.zzan(this.mContext);
    zztd localzztd = localzzsc.zznS();
    if (paramIntent == null) {
      localzztd.zzbS("AnalyticsService started with null intent");
    }
    do
    {
      return 2;
      paramIntent = paramIntent.getAction();
      localzztd.zza("Local AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    } while (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent));
    localzzsc.zzmA().zza(new zzti.1(this, paramInt2, localzzsc, localzztd));
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzti
 * JD-Core Version:    0.7.0.1
 */