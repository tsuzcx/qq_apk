package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.zzti;
import com.google.android.gms.internal.zzti.zza;

public final class AnalyticsService
  extends Service
  implements zzti.zza
{
  private zzti zzabq;
  
  private zzti zzmq()
  {
    if (this.zzabq == null) {
      this.zzabq = new zzti(this);
    }
    return this.zzabq;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  public final Context getContext()
  {
    return this;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    zzmq();
    return null;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    zzmq().onCreate();
  }
  
  public final void onDestroy()
  {
    zzmq().onDestroy();
    super.onDestroy();
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return zzmq().onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.analytics.AnalyticsService
 * JD-Core Version:    0.7.0.1
 */