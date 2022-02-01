package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgd
  implements Runnable
{
  zzgd(zzgb paramzzgb, zzgl paramzzgl, long paramLong, Bundle paramBundle, Context paramContext, zzfg paramzzfg, BroadcastReceiver.PendingResult paramPendingResult) {}
  
  public final void run()
  {
    AppMethodBeat.i(1508);
    long l3 = this.zzalb.zzgf().zzajz.get();
    long l2 = this.zzald;
    long l1 = l2;
    if (l3 > 0L) {
      if (l2 < l3)
      {
        l1 = l2;
        if (l2 > 0L) {}
      }
      else
      {
        l1 = l3 - 1L;
      }
    }
    if (l1 > 0L) {
      this.zzale.putLong("click_timestamp", l1);
    }
    this.zzale.putString("_cis", "referrer broadcast");
    AppMeasurement.getInstance(this.val$context).logEventInternal("auto", "_cmp", this.zzale);
    this.zzalc.zzit().log("Install campaign recorded");
    if (this.zzqu != null) {
      this.zzqu.finish();
    }
    AppMethodBeat.o(1508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgd
 * JD-Core Version:    0.7.0.1
 */