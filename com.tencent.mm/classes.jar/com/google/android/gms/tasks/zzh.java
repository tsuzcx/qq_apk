package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh
  implements Runnable
{
  zzh(zzg paramzzg) {}
  
  public final void run()
  {
    AppMethodBeat.i(13391);
    synchronized (zzg.zza(this.zzafr))
    {
      if (zzg.zzb(this.zzafr) != null) {
        zzg.zzb(this.zzafr).onCanceled();
      }
      AppMethodBeat.o(13391);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.zzh
 * JD-Core Version:    0.7.0.1
 */