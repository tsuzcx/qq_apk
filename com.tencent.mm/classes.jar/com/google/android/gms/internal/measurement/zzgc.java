package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgc
  implements Runnable
{
  zzgc(zzgb paramzzgb, zzgl paramzzgl, zzfg paramzzfg) {}
  
  public final void run()
  {
    AppMethodBeat.i(1507);
    if (this.zzalb.zzjp() == null)
    {
      this.zzalc.zzim().log("Install Referrer Reporter is null");
      AppMethodBeat.o(1507);
      return;
    }
    this.zzalb.zzjp().zzjh();
    AppMethodBeat.o(1507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgc
 * JD-Core Version:    0.7.0.1
 */