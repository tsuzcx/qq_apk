package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzge;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementInstallReferrerReceiver
  extends BroadcastReceiver
  implements zzge
{
  private zzgb zzadd;
  
  public final BroadcastReceiver.PendingResult doGoAsync()
  {
    AppMethodBeat.i(87667);
    BroadcastReceiver.PendingResult localPendingResult = goAsync();
    AppMethodBeat.o(87667);
    return localPendingResult;
  }
  
  public final void doStartService(Context paramContext, Intent paramIntent) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(87666);
    if (this.zzadd == null) {
      this.zzadd = new zzgb(this);
    }
    this.zzadd.onReceive(paramContext, paramIntent);
    AppMethodBeat.o(87666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementInstallReferrerReceiver
 * JD-Core Version:    0.7.0.1
 */