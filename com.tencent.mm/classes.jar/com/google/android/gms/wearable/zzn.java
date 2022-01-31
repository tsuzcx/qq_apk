package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn
  implements Runnable
{
  zzn(WearableListenerService.zzd paramzzd, zzfo paramzzfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(71484);
    this.zzao.zzak.onPeerConnected(this.zzaq);
    AppMethodBeat.o(71484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.zzn
 * JD-Core Version:    0.7.0.1
 */