package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkd
  extends zzaby<zzkd>
{
  private static volatile zzkd[] zzark;
  public Integer zzarl;
  public zzkh[] zzarm;
  public zzke[] zzarn;
  
  public zzkd()
  {
    AppMethodBeat.i(2168);
    this.zzarl = null;
    this.zzarm = zzkh.zzlh();
    this.zzarn = zzke.zzlf();
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2168);
  }
  
  public static zzkd[] zzle()
  {
    if (zzark == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzark == null) {
        zzark = new zzkd[0];
      }
      return zzark;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2169);
    if (paramObject == this)
    {
      AppMethodBeat.o(2169);
      return true;
    }
    if (!(paramObject instanceof zzkd))
    {
      AppMethodBeat.o(2169);
      return false;
    }
    paramObject = (zzkd)paramObject;
    if (this.zzarl == null)
    {
      if (paramObject.zzarl != null)
      {
        AppMethodBeat.o(2169);
        return false;
      }
    }
    else if (!this.zzarl.equals(paramObject.zzarl))
    {
      AppMethodBeat.o(2169);
      return false;
    }
    if (!zzacc.equals(this.zzarm, paramObject.zzarm))
    {
      AppMethodBeat.o(2169);
      return false;
    }
    if (!zzacc.equals(this.zzarn, paramObject.zzarn))
    {
      AppMethodBeat.o(2169);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2169);
        return true;
      }
      AppMethodBeat.o(2169);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2169);
    return bool;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(2170);
    int m = getClass().getName().hashCode();
    int i;
    int n;
    int i1;
    if (this.zzarl == null)
    {
      i = 0;
      n = zzacc.hashCode(this.zzarm);
      i1 = zzacc.hashCode(this.zzarn);
      j = k;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label114;
        }
      }
    }
    label114:
    for (int j = k;; j = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2170);
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
      i = this.zzarl.hashCode();
      break;
    }
  }
  
  protected final int zza()
  {
    int m = 0;
    AppMethodBeat.i(2172);
    int j = super.zza();
    int i = j;
    if (this.zzarl != null) {
      i = j + zzabw.zzf(1, this.zzarl.intValue());
    }
    j = i;
    Object localObject;
    if (this.zzarm != null)
    {
      j = i;
      if (this.zzarm.length > 0)
      {
        j = 0;
        while (j < this.zzarm.length)
        {
          localObject = this.zzarm[j];
          k = i;
          if (localObject != null) {
            k = i + zzabw.zzb(2, (zzace)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.zzarn != null)
    {
      k = j;
      if (this.zzarn.length > 0)
      {
        i = m;
        for (;;)
        {
          k = j;
          if (i >= this.zzarn.length) {
            break;
          }
          localObject = this.zzarn[i];
          k = j;
          if (localObject != null) {
            k = j + zzabw.zzb(3, (zzace)localObject);
          }
          i += 1;
          j = k;
        }
      }
    }
    AppMethodBeat.o(2172);
    return k;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    int j = 0;
    AppMethodBeat.i(2171);
    if (this.zzarl != null) {
      paramzzabw.zze(1, this.zzarl.intValue());
    }
    int i;
    Object localObject;
    if ((this.zzarm != null) && (this.zzarm.length > 0))
    {
      i = 0;
      while (i < this.zzarm.length)
      {
        localObject = this.zzarm[i];
        if (localObject != null) {
          paramzzabw.zza(2, (zzace)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzarn != null) && (this.zzarn.length > 0))
    {
      i = j;
      while (i < this.zzarn.length)
      {
        localObject = this.zzarn[i];
        if (localObject != null) {
          paramzzabw.zza(3, (zzace)localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkd
 * JD-Core Version:    0.7.0.1
 */