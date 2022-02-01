package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs
  implements Runnable
{
  zzs(WearableListenerService.zzd paramzzd, zzi paramzzi) {}
  
  public final void run()
  {
    AppMethodBeat.i(101472);
    this.zzao.zzak.onEntityUpdate(this.zzau);
    AppMethodBeat.o(101472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.zzs
 * JD-Core Version:    0.7.0.1
 */