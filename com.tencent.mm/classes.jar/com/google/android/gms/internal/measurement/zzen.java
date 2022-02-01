package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzen
  implements Runnable
{
  zzen(zzem paramzzem, zzhi paramzzhi) {}
  
  public final void run()
  {
    AppMethodBeat.i(1220);
    this.zzafk.zzgd();
    if (zzgg.isMainThread())
    {
      this.zzafk.zzgd().zzc(this);
      AppMethodBeat.o(1220);
      return;
    }
    boolean bool = this.zzafl.zzef();
    zzem.zza(this.zzafl, 0L);
    if (bool) {
      this.zzafl.run();
    }
    AppMethodBeat.o(1220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzen
 * JD-Core Version:    0.7.0.1
 */