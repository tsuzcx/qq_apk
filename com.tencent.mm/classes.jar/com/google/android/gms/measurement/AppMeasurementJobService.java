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
    AppMethodBeat.i(87668);
    if (this.zzade == null) {
      this.zzade = new zzjc(this);
    }
    zzjc localzzjc = this.zzade;
    AppMethodBeat.o(87668);
    return localzzjc;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    AppMethodBeat.i(87674);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(87674);
    throw localUnsupportedOperationException;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(87669);
    super.onCreate();
    zzfq().onCreate();
    AppMethodBeat.o(87669);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(87670);
    zzfq().onDestroy();
    super.onDestroy();
    AppMethodBeat.o(87670);
  }
  
  public final void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(87673);
    zzfq().onRebind(paramIntent);
    AppMethodBeat.o(87673);
  }
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(87671);
    boolean bool = zzfq().onStartJob(paramJobParameters);
    AppMethodBeat.o(87671);
    return bool;
  }
  
  public final boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(87672);
    boolean bool = zzfq().onUnbind(paramIntent);
    AppMethodBeat.o(87672);
    return bool;
  }
  
  @TargetApi(24)
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(87675);
    jobFinished(paramJobParameters, false);
    AppMethodBeat.o(87675);
  }
  
  public final void zzb(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementJobService
 * JD-Core Version:    0.7.0.1
 */