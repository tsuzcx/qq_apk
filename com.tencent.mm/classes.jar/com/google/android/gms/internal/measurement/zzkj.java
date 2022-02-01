package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkj
  extends zzaby<zzkj>
{
  private static volatile zzkj[] zzasl;
  public String name;
  public Boolean zzasm;
  public Boolean zzasn;
  public Integer zzaso;
  
  public zzkj()
  {
    AppMethodBeat.i(2206);
    this.name = null;
    this.zzasm = null;
    this.zzasn = null;
    this.zzaso = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2206);
  }
  
  public static zzkj[] zzli()
  {
    if (zzasl == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzasl == null) {
        zzasl = new zzkj[0];
      }
      return zzasl;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2207);
    if (paramObject == this)
    {
      AppMethodBeat.o(2207);
      return true;
    }
    if (!(paramObject instanceof zzkj))
    {
      AppMethodBeat.o(2207);
      return false;
    }
    paramObject = (zzkj)paramObject;
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(2207);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(2207);
      return false;
    }
    if (this.zzasm == null)
    {
      if (paramObject.zzasm != null)
      {
        AppMethodBeat.o(2207);
        return false;
      }
    }
    else if (!this.zzasm.equals(paramObject.zzasm))
    {
      AppMethodBeat.o(2207);
      return false;
    }
    if (this.zzasn == null)
    {
      if (paramObject.zzasn != null)
      {
        AppMethodBeat.o(2207);
        return false;
      }
    }
    else if (!this.zzasn.equals(paramObject.zzasn))
    {
      AppMethodBeat.o(2207);
      return false;
    }
    if (this.zzaso == null)
    {
      if (paramObject.zzaso != null)
      {
        AppMethodBeat.o(2207);
        return false;
      }
    }
    else if (!this.zzaso.equals(paramObject.zzaso))
    {
      AppMethodBeat.o(2207);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2207);
        return true;
      }
      AppMethodBeat.o(2207);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2207);
    return bool;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(2208);
    int i2 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    int k;
    label48:
    int m;
    if (this.name == null)
    {
      i = 0;
      if (this.zzasm != null) {
        break label134;
      }
      j = 0;
      if (this.zzasn != null) {
        break label145;
      }
      k = 0;
      if (this.zzaso != null) {
        break label156;
      }
      m = 0;
      label58:
      n = i1;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label168;
        }
      }
    }
    label134:
    label145:
    label156:
    label168:
    for (int n = i1;; n = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2208);
      return (m + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = this.name.hashCode();
      break;
      j = this.zzasm.hashCode();
      break label39;
      k = this.zzasn.hashCode();
      break label48;
      m = this.zzaso.hashCode();
      break label58;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2210);
    int j = super.zza();
    int i = j;
    if (this.name != null) {
      i = j + zzabw.zzc(1, this.name);
    }
    j = i;
    if (this.zzasm != null)
    {
      this.zzasm.booleanValue();
      j = i + (zzabw.zzaq(2) + 1);
    }
    i = j;
    if (this.zzasn != null)
    {
      this.zzasn.booleanValue();
      i = j + (zzabw.zzaq(3) + 1);
    }
    j = i;
    if (this.zzaso != null) {
      j = i + zzabw.zzf(4, this.zzaso.intValue());
    }
    AppMethodBeat.o(2210);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2209);
    if (this.name != null) {
      paramzzabw.zzb(1, this.name);
    }
    if (this.zzasm != null) {
      paramzzabw.zza(2, this.zzasm.booleanValue());
    }
    if (this.zzasn != null) {
      paramzzabw.zza(3, this.zzasn.booleanValue());
    }
    if (this.zzaso != null) {
      paramzzabw.zze(4, this.zzaso.intValue());
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkj
 * JD-Core Version:    0.7.0.1
 */