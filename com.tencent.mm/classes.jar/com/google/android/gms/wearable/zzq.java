package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzah;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzq
  implements Runnable
{
  zzq(WearableListenerService.zzd paramzzd, zzah paramzzah) {}
  
  public final void run()
  {
    AppMethodBeat.i(71487);
    this.zzao.zzak.onCapabilityChanged(this.zzas);
    AppMethodBeat.o(71487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.zzq
 * JD-Core Version:    0.7.0.1
 */