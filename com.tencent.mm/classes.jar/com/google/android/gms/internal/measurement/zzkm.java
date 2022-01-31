package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkm
  extends zzaby<zzkm>
{
  private static volatile zzkm[] zzasv;
  public Integer zzarl;
  public zzkr zzasw;
  public zzkr zzasx;
  public Boolean zzasy;
  
  public zzkm()
  {
    AppMethodBeat.i(69701);
    this.zzarl = null;
    this.zzasw = null;
    this.zzasx = null;
    this.zzasy = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69701);
  }
  
  public static zzkm[] zzlk()
  {
    if (zzasv == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzasv == null) {
        zzasv = new zzkm[0];
      }
      return zzasv;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(69702);
    if (paramObject == this)
    {
      AppMethodBeat.o(69702);
      return true;
    }
    if (!(paramObject instanceof zzkm))
    {
      AppMethodBeat.o(69702);
      return false;
    }
    paramObject = (zzkm)paramObject;
    if (this.zzarl == null)
    {
      if (paramObject.zzarl != null)
      {
        AppMethodBeat.o(69702);
        return false;
      }
    }
    else if (!this.zzarl.equals(paramObject.zzarl))
    {
      AppMethodBeat.o(69702);
      return false;
    }
    if (this.zzasw == null)
    {
      if (paramObject.zzasw != null)
      {
        AppMethodBeat.o(69702);
        return false;
      }
    }
    else if (!this.zzasw.equals(paramObject.zzasw))
    {
      AppMethodBeat.o(69702);
      return false;
    }
    if (this.zzasx == null)
    {
      if (paramObject.zzasx != null)
      {
        AppMethodBeat.o(69702);
        return false;
      }
    }
    else if (!this.zzasx.equals(paramObject.zzasx))
    {
      AppMethodBeat.o(69702);
      return false;
    }
    if (this.zzasy == null)
    {
      if (paramObject.zzasy != null)
      {
        AppMethodBeat.o(69702);
        return false;
      }
    }
    else if (!this.zzasy.equals(paramObject.zzasy))
    {
      AppMethodBeat.o(69702);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69702);
        return true;
      }
      AppMethodBeat.o(69702);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69702);
    return bool;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(69703);
    int i2 = getClass().getName().hashCode();
    int i;
    zzkr localzzkr;
    int j;
    label42:
    int k;
    label55:
    int m;
    if (this.zzarl == null)
    {
      i = 0;
      localzzkr = this.zzasw;
      if (localzzkr != null) {
        break label140;
      }
      j = 0;
      localzzkr = this.zzasx;
      if (localzzkr != null) {
        break label149;
      }
      k = 0;
      if (this.zzasy != null) {
        break label158;
      }
      m = 0;
      label65:
      n = i1;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label170;
        }
      }
    }
    label140:
    label149:
    label158:
    label170:
    for (int n = i1;; n = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69703);
      return (m + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = this.zzarl.hashCode();
      break;
      j = localzzkr.hashCode();
      break label42;
      k = localzzkr.hashCode();
      break label55;
      m = this.zzasy.hashCode();
      break label65;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69705);
    int j = super.zza();
    int i = j;
    if (this.zzarl != null) {
      i = j + zzabw.zzf(1, this.zzarl.intValue());
    }
    j = i;
    if (this.zzasw != null) {
      j = i + zzabw.zzb(2, this.zzasw);
    }
    i = j;
    if (this.zzasx != null) {
      i = j + zzabw.zzb(3, this.zzasx);
    }
    j = i;
    if (this.zzasy != null)
    {
      this.zzasy.booleanValue();
      j = i + (zzabw.zzaq(4) + 1);
    }
    AppMethodBeat.o(69705);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69704);
    if (this.zzarl != null) {
      paramzzabw.zze(1, this.zzarl.intValue());
    }
    if (this.zzasw != null) {
      paramzzabw.zza(2, this.zzasw);
    }
    if (this.zzasx != null) {
      paramzzabw.zza(3, this.zzasx);
    }
    if (this.zzasy != null) {
      paramzzabw.zza(4, this.zzasy.booleanValue());
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(69704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkm
 * JD-Core Version:    0.7.0.1
 */