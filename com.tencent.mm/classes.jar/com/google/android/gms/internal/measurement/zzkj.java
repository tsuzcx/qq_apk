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
    AppMethodBeat.i(69683);
    this.name = null;
    this.zzasm = null;
    this.zzasn = null;
    this.zzaso = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69683);
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
    AppMethodBeat.i(69684);
    if (paramObject == this)
    {
      AppMethodBeat.o(69684);
      return true;
    }
    if (!(paramObject instanceof zzkj))
    {
      AppMethodBeat.o(69684);
      return false;
    }
    paramObject = (zzkj)paramObject;
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(69684);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(69684);
      return false;
    }
    if (this.zzasm == null)
    {
      if (paramObject.zzasm != null)
      {
        AppMethodBeat.o(69684);
        return false;
      }
    }
    else if (!this.zzasm.equals(paramObject.zzasm))
    {
      AppMethodBeat.o(69684);
      return false;
    }
    if (this.zzasn == null)
    {
      if (paramObject.zzasn != null)
      {
        AppMethodBeat.o(69684);
        return false;
      }
    }
    else if (!this.zzasn.equals(paramObject.zzasn))
    {
      AppMethodBeat.o(69684);
      return false;
    }
    if (this.zzaso == null)
    {
      if (paramObject.zzaso != null)
      {
        AppMethodBeat.o(69684);
        return false;
      }
    }
    else if (!this.zzaso.equals(paramObject.zzaso))
    {
      AppMethodBeat.o(69684);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69684);
        return true;
      }
      AppMethodBeat.o(69684);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69684);
    return bool;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(69685);
    int i2 = getClass().getName().hashCode();
    int i;
    int j;
    label38:
    int k;
    label47:
    int m;
    if (this.name == null)
    {
      i = 0;
      if (this.zzasm != null) {
        break label132;
      }
      j = 0;
      if (this.zzasn != null) {
        break label143;
      }
      k = 0;
      if (this.zzaso != null) {
        break label154;
      }
      m = 0;
      label57:
      n = i1;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label166;
        }
      }
    }
    label132:
    label143:
    label154:
    label166:
    for (int n = i1;; n = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69685);
      return (m + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = this.name.hashCode();
      break;
      j = this.zzasm.hashCode();
      break label38;
      k = this.zzasn.hashCode();
      break label47;
      m = this.zzaso.hashCode();
      break label57;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69687);
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
    AppMethodBeat.o(69687);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69686);
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
    AppMethodBeat.o(69686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkj
 * JD-Core Version:    0.7.0.1
 */