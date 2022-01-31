package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzr
  implements Runnable
{
  zzr(WearableListenerService.zzd paramzzd, zzl paramzzl) {}
  
  public final void run()
  {
    AppMethodBeat.i(71488);
    this.zzao.zzak.onNotificationReceived(this.zzat);
    AppMethodBeat.o(71488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.zzr
 * JD-Core Version:    0.7.0.1
 */