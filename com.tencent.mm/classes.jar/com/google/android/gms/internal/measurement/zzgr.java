package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgr
  implements Runnable
{
  zzgr(zzgn paramzzgn, zzed paramzzed) {}
  
  public final void run()
  {
    AppMethodBeat.i(1636);
    zzgn.zza(this.zzanf).zzkx();
    zzjr localzzjr = zzgn.zza(this.zzanf);
    zzed localzzed = this.zzang;
    zzdz localzzdz = localzzjr.zzcb(localzzed.packageName);
    if (localzzdz != null) {
      localzzjr.zzc(localzzed, localzzdz);
    }
    AppMethodBeat.o(1636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgr
 * JD-Core Version:    0.7.0.1
 */