package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzaw;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzt
  implements Runnable
{
  zzt(WearableListenerService.zzd paramzzd, zzaw paramzzaw) {}
  
  public final void run()
  {
    AppMethodBeat.i(101473);
    this.zzav.zza(this.zzao.zzak);
    this.zzav.zza(WearableListenerService.zzc(this.zzao.zzak));
    AppMethodBeat.o(101473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.zzt
 * JD-Core Version:    0.7.0.1
 */