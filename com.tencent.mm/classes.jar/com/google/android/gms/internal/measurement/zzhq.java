package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhq
  implements Runnable
{
  zzhq(zzhk paramzzhk, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = true;
    AppMethodBeat.i(1745);
    zzhk localzzhk = this.zzanw;
    long l = this.zzaoa;
    localzzhk.zzab();
    localzzhk.zzch();
    localzzhk.zzge().zzis().log("Resetting analytics data (FE)");
    localzzhk.zzgc().zzkj();
    if (localzzhk.zzgg().zzba(localzzhk.zzfv().zzah())) {
      localzzhk.zzgf().zzajz.set(l);
    }
    boolean bool3 = localzzhk.zzacw.isEnabled();
    if (!localzzhk.zzgg().zzhg())
    {
      zzfr localzzfr = localzzhk.zzgf();
      if (!bool3)
      {
        bool1 = true;
        localzzfr.zzh(bool1);
      }
    }
    else
    {
      localzzhk.zzfx().resetAnalyticsData();
      if (bool3) {
        break label154;
      }
    }
    label154:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localzzhk.zzanu = bool1;
      AppMethodBeat.o(1745);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhq
 * JD-Core Version:    0.7.0.1
 */