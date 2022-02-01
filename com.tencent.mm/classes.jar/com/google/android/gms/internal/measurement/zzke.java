package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzke
  extends zzaby<zzke>
{
  private static volatile zzke[] zzaro;
  public Integer zzarp;
  public String zzarq;
  public zzkf[] zzarr;
  private Boolean zzars;
  public zzkg zzart;
  
  public zzke()
  {
    AppMethodBeat.i(2174);
    this.zzarp = null;
    this.zzarq = null;
    this.zzarr = zzkf.zzlg();
    this.zzars = null;
    this.zzart = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2174);
  }
  
  public static zzke[] zzlf()
  {
    if (zzaro == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzaro == null) {
        zzaro = new zzke[0];
      }
      return zzaro;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2175);
    if (paramObject == this)
    {
      AppMethodBeat.o(2175);
      return true;
    }
    if (!(paramObject instanceof zzke))
    {
      AppMethodBeat.o(2175);
      return false;
    }
    paramObject = (zzke)paramObject;
    if (this.zzarp == null)
    {
      if (paramObject.zzarp != null)
      {
        AppMethodBeat.o(2175);
        return false;
      }
    }
    else if (!this.zzarp.equals(paramObject.zzarp))
    {
      AppMethodBeat.o(2175);
      return false;
    }
    if (this.zzarq == null)
    {
      if (paramObject.zzarq != null)
      {
        AppMethodBeat.o(2175);
        return false;
      }
    }
    else if (!this.zzarq.equals(paramObject.zzarq))
    {
      AppMethodBeat.o(2175);
      return false;
    }
    if (!zzacc.equals(this.zzarr, paramObject.zzarr))
    {
      AppMethodBeat.o(2175);
      return false;
    }
    if (this.zzars == null)
    {
      if (paramObject.zzars != null)
      {
        AppMethodBeat.o(2175);
        return false;
      }
    }
    else if (!this.zzars.equals(paramObject.zzars))
    {
      AppMethodBeat.o(2175);
      return false;
    }
    if (this.zzart == null)
    {
      if (paramObject.zzart != null)
      {
        AppMethodBeat.o(2175);
        return false;
      }
    }
    else if (!this.zzart.equals(paramObject.zzart))
    {
      AppMethodBeat.o(2175);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2175);
        return true;
      }
      AppMethodBeat.o(2175);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2175);
    return bool;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(2176);
    int i2 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    int i3;
    int k;
    label57:
    zzkg localzzkg;
    int m;
    if (this.zzarp == null)
    {
      i = 0;
      if (this.zzarq != null) {
        break label153;
      }
      j = 0;
      i3 = zzacc.hashCode(this.zzarr);
      if (this.zzars != null) {
        break label164;
      }
      k = 0;
      localzzkg = this.zzart;
      if (localzzkg != null) {
        break label175;
      }
      m = 0;
      label71:
      n = i1;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label185;
        }
      }
    }
    label153:
    label164:
    label175:
    label185:
    for (int n = i1;; n = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2176);
      return (m + (k + ((j + (i + (i2 + 527) * 31) * 31) * 31 + i3) * 31) * 31) * 31 + n;
      i = this.zzarp.hashCode();
      break;
      j = this.zzarq.hashCode();
      break label39;
      k = this.zzars.hashCode();
      break label57;
      m = localzzkg.hashCode();
      break label71;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2178);
    int i = super.zza();
    int j = i;
    if (this.zzarp != null) {
      j = i + zzabw.zzf(1, this.zzarp.intValue());
    }
    i = j;
    if (this.zzarq != null) {
      i = j + zzabw.zzc(2, this.zzarq);
    }
    j = i;
    if (this.zzarr != null)
    {
      j = i;
      if (this.zzarr.length > 0)
      {
        j = 0;
        while (j < this.zzarr.length)
        {
          zzkf localzzkf = this.zzarr[j];
          int k = i;
          if (localzzkf != null) {
            k = i + zzabw.zzb(3, localzzkf);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.zzars != null)
    {
      this.zzars.booleanValue();
      i = j + (zzabw.zzaq(4) + 1);
    }
    j = i;
    if (this.zzart != null) {
      j = i + zzabw.zzb(5, this.zzart);
    }
    AppMethodBeat.o(2178);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2177);
    if (this.zzarp != null) {
      paramzzabw.zze(1, this.zzarp.intValue());
    }
    if (this.zzarq != null) {
      paramzzabw.zzb(2, this.zzarq);
    }
    if ((this.zzarr != null) && (this.zzarr.length > 0))
    {
      int i = 0;
      while (i < this.zzarr.length)
      {
        zzkf localzzkf = this.zzarr[i];
        if (localzzkf != null) {
          paramzzabw.zza(3, localzzkf);
        }
        i += 1;
      }
    }
    if (this.zzars != null) {
      paramzzabw.zza(4, this.zzars.booleanValue());
    }
    if (this.zzart != null) {
      paramzzabw.zza(5, this.zzart);
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzke
 * JD-Core Version:    0.7.0.1
 */