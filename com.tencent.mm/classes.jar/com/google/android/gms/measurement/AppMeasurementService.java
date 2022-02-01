package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjg;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementService
  extends Service
  implements zzjg
{
  private zzjc<AppMeasurementService> zzade;
  
  private final zzjc<AppMeasurementService> zzfq()
  {
    AppMethodBeat.i(87679);
    if (this.zzade == null) {
      this.zzade = new zzjc(this);
    }
    zzjc localzzjc = this.zzade;
    AppMethodBeat.o(87679);
    return localzzjc;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    AppMethodBeat.i(87686);
    boolean bool = stopSelfResult(paramInt);
    AppMethodBeat.o(87686);
    return bool;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(87683);
    paramIntent = zzfq().onBind(paramIntent);
    AppMethodBeat.o(87683);
    return paramIntent;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(87680);
    super.onCreate();
    zzfq().onCreate();
    AppMethodBeat.o(87680);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(87681);
    zzfq().onDestroy();
    super.onDestroy();
    AppMethodBeat.o(87681);
  }
  
  public final void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(87685);
    zzfq().onRebind(paramIntent);
    AppMethodBeat.o(87685);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87682);
    paramInt1 = zzfq().onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(87682);
    return paramInt1;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(87684);
    boolean bool = zzfq().onUnbind(paramIntent);
    AppMethodBeat.o(87684);
    return bool;
  }
  
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(87687);
    paramJobParameters = new UnsupportedOperationException();
    AppMethodBeat.o(87687);
    throw paramJobParameters;
  }
  
  public final void zzb(Intent paramIntent)
  {
    AppMethodBeat.i(87688);
    AppMeasurementReceiver.completeWakefulIntent(paramIntent);
    AppMethodBeat.o(87688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService
 * JD-Core Version:    0.7.0.1
 */