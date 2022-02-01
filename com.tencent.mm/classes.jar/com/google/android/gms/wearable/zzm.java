package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfe;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm
  implements Runnable
{
  zzm(WearableListenerService.zzd paramzzd, zzfe paramzzfe) {}
  
  public final void run()
  {
    AppMethodBeat.i(101466);
    this.zzao.zzak.onMessageReceived(this.zzap);
    AppMethodBeat.o(101466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.zzm
 * JD-Core Version:    0.7.0.1
 */