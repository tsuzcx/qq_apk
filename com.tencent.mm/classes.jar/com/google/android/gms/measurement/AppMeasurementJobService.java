package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjg;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(24)
public final class AppMeasurementJobService
  extends JobService
  implements zzjg
{
  private zzjc<AppMeasurementJobService> zzade;
  
  private final zzjc<AppMeasurementJobService> zzfq()
  {
    AppMethodBeat.i(77163);
    if (this.zzade == null) {
      this.zzade = new zzjc(this);
    }
    zzjc localzzjc = this.zzade;
    AppMethodBeat.o(77163);
    return localzzjc;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    AppMethodBeat.i(77169);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(77169);
    throw localUnsupportedOperationException;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(77164);
    super.onCreate();
    zzfq().onCreate();
    AppMethodBeat.o(77164);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(77165);
    zzfq().onDestroy();
    super.onDestroy();
    AppMethodBeat.o(77165);
  }
  
  public final void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(77168);
    zzfq().onRebind(paramIntent);
    AppMethodBeat.o(77168);
  }
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(77166);
    boolean bool = zzfq().onStartJob(paramJobParameters);
    AppMethodBeat.o(77166);
    return bool;
  }
  
  public final boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(77167);
    boolean bool = zzfq().onUnbind(paramIntent);
    AppMethodBeat.o(77167);
    return bool;
  }
  
  @TargetApi(24)
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(77170);
    jobFinished(paramJobParameters, false);
    AppMethodBeat.o(77170);
  }
  
  public final void zzb(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementJobService
 * JD-Core Version:    0.7.0.1
 */