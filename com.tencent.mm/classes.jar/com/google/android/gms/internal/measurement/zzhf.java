package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhf
  implements Runnable
{
  zzhf(zzgn paramzzgn, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(1650);
    if (this.zzanm == null)
    {
      zzgn.zza(this.zzanf).zzla().zzfy().zza(this.zzanj, null);
      AppMethodBeat.o(1650);
      return;
    }
    zzie localzzie = new zzie(this.zzann, this.zzanm, this.zzano);
    zzgn.zza(this.zzanf).zzla().zzfy().zza(this.zzanj, localzzie);
    AppMethodBeat.o(1650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhf
 * JD-Core Version:    0.7.0.1
 */