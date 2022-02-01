package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkr
  extends zzaby<zzkr>
{
  public long[] zzauk;
  public long[] zzaul;
  
  public zzkr()
  {
    AppMethodBeat.i(2254);
    this.zzauk = zzach.zzbxm;
    this.zzaul = zzach.zzbxm;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2254);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2255);
    if (paramObject == this)
    {
      AppMethodBeat.o(2255);
      return true;
    }
    if (!(paramObject instanceof zzkr))
    {
      AppMethodBeat.o(2255);
      return false;
    }
    paramObject = (zzkr)paramObject;
    if (!zzacc.equals(this.zzauk, paramObject.zzauk))
    {
      AppMethodBeat.o(2255);
      return false;
    }
    if (!zzacc.equals(this.zzaul, paramObject.zzaul))
    {
      AppMethodBeat.o(2255);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2255);
        return true;
      }
      AppMethodBeat.o(2255);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2255);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(2256);
    int j = getClass().getName().hashCode();
    int k = zzacc.hashCode(this.zzauk);
    int m = zzacc.hashCode(this.zzaul);
    if ((this.zzbww == null) || (this.zzbww.isEmpty())) {}
    for (int i = 0;; i = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2256);
      return i + (((j + 527) * 31 + k) * 31 + m) * 31;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2258);
    int k = super.zza();
    int j;
    if ((this.zzauk != null) && (this.zzauk.length > 0))
    {
      i = 0;
      j = 0;
      while (i < this.zzauk.length)
      {
        j += zzabw.zzao(this.zzauk[i]);
        i += 1;
      }
    }
    for (int i = k + j + this.zzauk.length * 1;; i = k)
    {
      j = i;
      if (this.zzaul != null)
      {
        j = i;
        if (this.zzaul.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.zzaul.length)
          {
            k += zzabw.zzao(this.zzaul[j]);
            j += 1;
          }
          j = i + k + this.zzaul.length * 1;
        }
      }
      AppMethodBeat.o(2258);
      return j;
    }
  }
  
  public final void zza(zzabw paramzzabw)
  {
    int j = 0;
    AppMethodBeat.i(2257);
    int i;
    if ((this.zzauk != null) && (this.zzauk.length > 0))
    {
      i = 0;
      while (i < this.zzauk.length)
      {
        paramzzabw.zza(1, this.zzauk[i]);
        i += 1;
      }
    }
    if ((this.zzaul != null) && (this.zzaul.length > 0))
    {
      i = j;
      while (i < this.zzaul.length)
      {
        paramzzabw.zza(2, this.zzaul[i]);
        i += 1;
      }
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkr
 * JD-Core Version:    0.7.0.1
 */