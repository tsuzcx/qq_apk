package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzge;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementReceiver
  extends WakefulBroadcastReceiver
  implements zzge
{
  private zzgb zzadd;
  
  public final BroadcastReceiver.PendingResult doGoAsync()
  {
    AppMethodBeat.i(77173);
    BroadcastReceiver.PendingResult localPendingResult = goAsync();
    AppMethodBeat.o(77173);
    return localPendingResult;
  }
  
  public final void doStartService(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(77172);
    startWakefulService(paramContext, paramIntent);
    AppMethodBeat.o(77172);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(77171);
    if (this.zzadd == null) {
      this.zzadd = new zzgb(this);
    }
    this.zzadd.onReceive(paramContext, paramIntent);
    AppMethodBeat.o(77171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementReceiver
 * JD-Core Version:    0.7.0.1
 */