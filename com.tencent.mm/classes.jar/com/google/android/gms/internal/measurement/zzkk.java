package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkk
  extends zzaby<zzkk>
{
  public String zzadm;
  public Long zzasp;
  private Integer zzasq;
  public zzkl[] zzasr;
  public zzkj[] zzass;
  public zzkd[] zzast;
  
  public zzkk()
  {
    AppMethodBeat.i(2212);
    this.zzasp = null;
    this.zzadm = null;
    this.zzasq = null;
    this.zzasr = zzkl.zzlj();
    this.zzass = zzkj.zzli();
    this.zzast = zzkd.zzle();
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2212);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2213);
    if (paramObject == this)
    {
      AppMethodBeat.o(2213);
      return true;
    }
    if (!(paramObject instanceof zzkk))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    paramObject = (zzkk)paramObject;
    if (this.zzasp == null)
    {
      if (paramObject.zzasp != null)
      {
        AppMethodBeat.o(2213);
        return false;
      }
    }
    else if (!this.zzasp.equals(paramObject.zzasp))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    if (this.zzadm == null)
    {
      if (paramObject.zzadm != null)
      {
        AppMethodBeat.o(2213);
        return false;
      }
    }
    else if (!this.zzadm.equals(paramObject.zzadm))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    if (this.zzasq == null)
    {
      if (paramObject.zzasq != null)
      {
        AppMethodBeat.o(2213);
        return false;
      }
    }
    else if (!this.zzasq.equals(paramObject.zzasq))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    if (!zzacc.equals(this.zzasr, paramObject.zzasr))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    if (!zzacc.equals(this.zzass, paramObject.zzass))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    if (!zzacc.equals(this.zzast, paramObject.zzast))
    {
      AppMethodBeat.o(2213);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2213);
        return true;
      }
      AppMethodBeat.o(2213);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2213);
    return bool;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(2214);
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    int k;
    label48:
    int i2;
    int i3;
    int i4;
    if (this.zzasp == null)
    {
      i = 0;
      if (this.zzadm != null) {
        break label163;
      }
      j = 0;
      if (this.zzasq != null) {
        break label174;
      }
      k = 0;
      i2 = zzacc.hashCode(this.zzasr);
      i3 = zzacc.hashCode(this.zzass);
      i4 = zzacc.hashCode(this.zzast);
      m = n;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label185;
        }
      }
    }
    label163:
    label174:
    label185:
    for (int m = n;; m = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2214);
      return ((((k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + m;
      i = this.zzasp.hashCode();
      break;
      j = this.zzadm.hashCode();
      break label39;
      k = this.zzasq.hashCode();
      break label48;
    }
  }
  
  protected final int zza()
  {
    int m = 0;
    AppMethodBeat.i(2216);
    int j = super.zza();
    int i = j;
    if (this.zzasp != null) {
      i = j + zzabw.zzc(1, this.zzasp.longValue());
    }
    j = i;
    if (this.zzadm != null) {
      j = i + zzabw.zzc(2, this.zzadm);
    }
    i = j;
    if (this.zzasq != null) {
      i = j + zzabw.zzf(3, this.zzasq.intValue());
    }
    j = i;
    Object localObject;
    if (this.zzasr != null)
    {
      j = i;
      if (this.zzasr.length > 0)
      {
        j = 0;
        while (j < this.zzasr.length)
        {
          localObject = this.zzasr[j];
          k = i;
          if (localObject != null) {
            k = i + zzabw.zzb(4, (zzace)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.zzass != null)
    {
      i = j;
      if (this.zzass.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.zzass.length)
        {
          localObject = this.zzass[j];
          k = i;
          if (localObject != null) {
            k = i + zzabw.zzb(5, (zzace)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (this.zzast != null)
    {
      k = i;
      if (this.zzast.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.zzast.length) {
            break;
          }
          localObject = this.zzast[j];
          k = i;
          if (localObject != null) {
            k = i + zzabw.zzb(6, (zzace)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    AppMethodBeat.o(2216);
    return k;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    int j = 0;
    AppMethodBeat.i(2215);
    if (this.zzasp != null) {
      paramzzabw.zzb(1, this.zzasp.longValue());
    }
    if (this.zzadm != null) {
      paramzzabw.zzb(2, this.zzadm);
    }
    if (this.zzasq != null) {
      paramzzabw.zze(3, this.zzasq.intValue());
    }
    int i;
    Object localObject;
    if ((this.zzasr != null) && (this.zzasr.length > 0))
    {
      i = 0;
      while (i < this.zzasr.length)
      {
        localObject = this.zzasr[i];
        if (localObject != null) {
          paramzzabw.zza(4, (zzace)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzass != null) && (this.zzass.length > 0))
    {
      i = 0;
      while (i < this.zzass.length)
      {
        localObject = this.zzass[i];
        if (localObject != null) {
          paramzzabw.zza(5, (zzace)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzast != null) && (this.zzast.length > 0))
    {
      i = j;
      while (i < this.zzast.length)
      {
        localObject = this.zzast[i];
        if (localObject != null) {
          paramzzabw.zza(6, (zzace)localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkk
 * JD-Core Version:    0.7.0.1
 */