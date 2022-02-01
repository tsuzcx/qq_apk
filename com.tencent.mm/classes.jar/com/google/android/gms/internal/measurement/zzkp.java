package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkp
  extends zzaby<zzkp>
{
  public zzkq[] zzatf;
  
  public zzkp()
  {
    AppMethodBeat.i(2242);
    this.zzatf = zzkq.zzln();
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2242);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2243);
    if (paramObject == this)
    {
      AppMethodBeat.o(2243);
      return true;
    }
    if (!(paramObject instanceof zzkp))
    {
      AppMethodBeat.o(2243);
      return false;
    }
    paramObject = (zzkp)paramObject;
    if (!zzacc.equals(this.zzatf, paramObject.zzatf))
    {
      AppMethodBeat.o(2243);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2243);
        return true;
      }
      AppMethodBeat.o(2243);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2243);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(2244);
    int j = getClass().getName().hashCode();
    int k = zzacc.hashCode(this.zzatf);
    if ((this.zzbww == null) || (this.zzbww.isEmpty())) {}
    for (int i = 0;; i = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2244);
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2246);
    int i = super.zza();
    int k = i;
    if (this.zzatf != null)
    {
      k = i;
      if (this.zzatf.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.zzatf.length) {
            break;
          }
          zzkq localzzkq = this.zzatf[j];
          k = i;
          if (localzzkq != null) {
            k = i + zzabw.zzb(1, localzzkq);
          }
          j += 1;
          i = k;
        }
      }
    }
    AppMethodBeat.o(2246);
    return k;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2245);
    if ((this.zzatf != null) && (this.zzatf.length > 0))
    {
      int i = 0;
      while (i < this.zzatf.length)
      {
        zzkq localzzkq = this.zzatf[i];
        if (localzzkq != null) {
          paramzzabw.zza(1, localzzkq);
        }
        i += 1;
      }
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkp
 * JD-Core Version:    0.7.0.1
 */