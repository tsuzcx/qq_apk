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
    AppMethodBeat.i(77174);
    if (this.zzade == null) {
      this.zzade = new zzjc(this);
    }
    zzjc localzzjc = this.zzade;
    AppMethodBeat.o(77174);
    return localzzjc;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    AppMethodBeat.i(77181);
    boolean bool = stopSelfResult(paramInt);
    AppMethodBeat.o(77181);
    return bool;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(77178);
    paramIntent = zzfq().onBind(paramIntent);
    AppMethodBeat.o(77178);
    return paramIntent;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(77175);
    super.onCreate();
    zzfq().onCreate();
    AppMethodBeat.o(77175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(77176);
    zzfq().onDestroy();
    super.onDestroy();
    AppMethodBeat.o(77176);
  }
  
  public final void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(77180);
    zzfq().onRebind(paramIntent);
    AppMethodBeat.o(77180);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77177);
    paramInt1 = zzfq().onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(77177);
    return paramInt1;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(77179);
    boolean bool = zzfq().onUnbind(paramIntent);
    AppMethodBeat.o(77179);
    return bool;
  }
  
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(77182);
    paramJobParameters = new UnsupportedOperationException();
    AppMethodBeat.o(77182);
    throw paramJobParameters;
  }
  
  public final void zzb(Intent paramIntent)
  {
    AppMethodBeat.i(77183);
    AppMeasurementReceiver.completeWakefulIntent(paramIntent);
    AppMethodBeat.o(77183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService
 * JD-Core Version:    0.7.0.1
 */