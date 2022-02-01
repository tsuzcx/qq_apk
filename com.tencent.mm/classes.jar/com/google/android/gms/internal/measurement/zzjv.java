package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class zzjv
  implements zzek
{
  zzkq zzaqv;
  List<Long> zzaqw;
  List<zzkn> zzaqx;
  private long zzaqy;
  
  private zzjv(zzjr paramzzjr) {}
  
  private static long zza(zzkn paramzzkn)
  {
    AppMethodBeat.i(2014);
    long l = paramzzkn.zzatb.longValue() / 1000L / 60L / 60L;
    AppMethodBeat.o(2014);
    return l;
  }
  
  public final boolean zza(long paramLong, zzkn paramzzkn)
  {
    AppMethodBeat.i(2013);
    Preconditions.checkNotNull(paramzzkn);
    if (this.zzaqx == null) {
      this.zzaqx = new ArrayList();
    }
    if (this.zzaqw == null) {
      this.zzaqw = new ArrayList();
    }
    if ((this.zzaqx.size() > 0) && (zza((zzkn)this.zzaqx.get(0)) != zza(paramzzkn)))
    {
      AppMethodBeat.o(2013);
      return false;
    }
    long l = this.zzaqy + paramzzkn.zzvm();
    if (l >= Math.max(0, ((Integer)zzew.zzagq.get()).intValue()))
    {
      AppMethodBeat.o(2013);
      return false;
    }
    this.zzaqy = l;
    this.zzaqx.add(paramzzkn);
    this.zzaqw.add(Long.valueOf(paramLong));
    if (this.zzaqx.size() >= Math.max(1, ((Integer)zzew.zzagr.get()).intValue()))
    {
      AppMethodBeat.o(2013);
      return false;
    }
    AppMethodBeat.o(2013);
    return true;
  }
  
  public final void zzb(zzkq paramzzkq)
  {
    AppMethodBeat.i(2012);
    Preconditions.checkNotNull(paramzzkq);
    this.zzaqv = paramzzkq;
    AppMethodBeat.o(2012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjv
 * JD-Core Version:    0.7.0.1
 */