package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzib
  implements Runnable
{
  zzib(zzhk paramzzhk, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(1756);
    this.zzanw.zzgf().zzakj.set(this.zzaod);
    this.zzanw.zzge().zzis().zzg("Session timeout duration set", Long.valueOf(this.zzaod));
    AppMethodBeat.o(1756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzib
 * JD-Core Version:    0.7.0.1
 */