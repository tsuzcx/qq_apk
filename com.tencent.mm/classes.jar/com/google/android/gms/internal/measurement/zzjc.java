package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjc<T extends Context,  extends zzjg>
{
  private final T zzabm;
  
  public zzjc(T paramT)
  {
    AppMethodBeat.i(1870);
    Preconditions.checkNotNull(paramT);
    this.zzabm = paramT;
    AppMethodBeat.o(1870);
  }
  
  public static boolean zza(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(1871);
    Preconditions.checkNotNull(paramContext);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramBoolean = zzka.zzc(paramContext, "com.google.android.gms.measurement.AppMeasurementJobService");
      AppMethodBeat.o(1871);
      return paramBoolean;
    }
    paramBoolean = zzka.zzc(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
    AppMethodBeat.o(1871);
    return paramBoolean;
  }
  
  private final void zzb(Runnable paramRunnable)
  {
    AppMethodBeat.i(1875);
    zzgl localzzgl = zzgl.zzg(this.zzabm);
    localzzgl.zzgd().zzc(new zzjf(this, localzzgl, paramRunnable));
    AppMethodBeat.o(1875);
  }
  
  private final zzfg zzge()
  {
    AppMethodBeat.i(1880);
    zzfg localzzfg = zzgl.zzg(this.zzabm).zzge();
    AppMethodBeat.o(1880);
    return localzzfg;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(1876);
    if (paramIntent == null)
    {
      zzge().zzim().log("onBind called with null intent");
      AppMethodBeat.o(1876);
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent))
    {
      paramIntent = new zzgn(zzgl.zzg(this.zzabm));
      AppMethodBeat.o(1876);
      return paramIntent;
    }
    zzge().zzip().zzg("onBind received unknown action", paramIntent);
    AppMethodBeat.o(1876);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(1872);
    zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is starting up");
    AppMethodBeat.o(1872);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(1873);
    zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is shutting down");
    AppMethodBeat.o(1873);
  }
  
  public final void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(1879);
    if (paramIntent == null)
    {
      zzge().zzim().log("onRebind called with null intent");
      AppMethodBeat.o(1879);
      return;
    }
    paramIntent = paramIntent.getAction();
    zzge().zzit().zzg("onRebind called. action", paramIntent);
    AppMethodBeat.o(1879);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1874);
    zzfg localzzfg = zzgl.zzg(this.zzabm).zzge();
    if (paramIntent == null)
    {
      localzzfg.zzip().log("AppMeasurementService started with null intent");
      AppMethodBeat.o(1874);
      return 2;
    }
    String str = paramIntent.getAction();
    localzzfg.zzit().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      zzb(new zzjd(this, paramInt2, localzzfg, paramIntent));
    }
    AppMethodBeat.o(1874);
    return 2;
  }
  
  @TargetApi(24)
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(1878);
    zzfg localzzfg = zzgl.zzg(this.zzabm).zzge();
    String str = paramJobParameters.getExtras().getString("action");
    localzzfg.zzit().zzg("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      zzb(new zzje(this, localzzfg, paramJobParameters));
    }
    AppMethodBeat.o(1878);
    return true;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(1877);
    if (paramIntent == null)
    {
      zzge().zzim().log("onUnbind called with null intent");
      AppMethodBeat.o(1877);
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzge().zzit().zzg("onUnbind called for intent. action", paramIntent);
    AppMethodBeat.o(1877);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjc
 * JD-Core Version:    0.7.0.1
 */