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
    AppMethodBeat.i(87678);
    BroadcastReceiver.PendingResult localPendingResult = goAsync();
    AppMethodBeat.o(87678);
    return localPendingResult;
  }
  
  public final void doStartService(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(87677);
    startWakefulService(paramContext, paramIntent);
    AppMethodBeat.o(87677);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(87676);
    if (this.zzadd == null) {
      this.zzadd = new zzgb(this);
    }
    this.zzadd.onReceive(paramContext, paramIntent);
    AppMethodBeat.o(87676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementReceiver
 * JD-Core Version:    0.7.0.1
 */