package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgs
  implements Runnable
{
  zzgs(zzgn paramzzgn, zzed paramzzed) {}
  
  public final void run()
  {
    AppMethodBeat.i(1637);
    zzgn.zza(this.zzanf).zzkx();
    zzjr localzzjr = zzgn.zza(this.zzanf);
    zzed localzzed = this.zzang;
    zzdz localzzdz = localzzjr.zzcb(localzzed.packageName);
    if (localzzdz != null) {
      localzzjr.zzb(localzzed, localzzdz);
    }
    AppMethodBeat.o(1637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgs
 * JD-Core Version:    0.7.0.1
 */