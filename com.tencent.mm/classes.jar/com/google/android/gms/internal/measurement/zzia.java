package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzia
  implements Runnable
{
  zzia(zzhk paramzzhk, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(1755);
    this.zzanw.zzgf().zzaki.set(this.zzaod);
    this.zzanw.zzge().zzis().zzg("Minimum session duration set", Long.valueOf(this.zzaod));
    AppMethodBeat.o(1755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzia
 * JD-Core Version:    0.7.0.1
 */