package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfe;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm
  implements Runnable
{
  zzm(WearableListenerService.zzd paramzzd, zzfe paramzzfe) {}
  
  public final void run()
  {
    AppMethodBeat.i(71483);
    this.zzao.zzak.onMessageReceived(this.zzap);
    AppMethodBeat.o(71483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.zzm
 * JD-Core Version:    0.7.0.1
 */