package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkh
  extends zzaby<zzkh>
{
  private static volatile zzkh[] zzase;
  public Integer zzarp;
  public String zzasf;
  public zzkf zzasg;
  
  public zzkh()
  {
    AppMethodBeat.i(2193);
    this.zzarp = null;
    this.zzasf = null;
    this.zzasg = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2193);
  }
  
  public static zzkh[] zzlh()
  {
    if (zzase == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzase == null) {
        zzase = new zzkh[0];
      }
      return zzase;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2194);
    if (paramObject == this)
    {
      AppMethodBeat.o(2194);
      return true;
    }
    if (!(paramObject instanceof zzkh))
    {
      AppMethodBeat.o(2194);
      return false;
    }
    paramObject = (zzkh)paramObject;
    if (this.zzarp == null)
    {
      if (paramObject.zzarp != null)
      {
        AppMethodBeat.o(2194);
        return false;
      }
    }
    else if (!this.zzarp.equals(paramObject.zzarp))
    {
      AppMethodBeat.o(2194);
      return false;
    }
    if (this.zzasf == null)
    {
      if (paramObject.zzasf != null)
      {
        AppMethodBeat.o(2194);
        return false;
      }
    }
    else if (!this.zzasf.equals(paramObject.zzasf))
    {
      AppMethodBeat.o(2194);
      return false;
    }
    if (this.zzasg == null)
    {
      if (paramObject.zzasg != null)
      {
        AppMethodBeat.o(2194);
        return false;
      }
    }
    else if (!this.zzasg.equals(paramObject.zzasg))
    {
      AppMethodBeat.o(2194);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2194);
        return true;
      }
      AppMethodBeat.o(2194);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2194);
    return bool;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(2195);
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    zzkf localzzkf;
    int k;
    if (this.zzarp == null)
    {
      i = 0;
      if (this.zzasf != null) {
        break label122;
      }
      j = 0;
      localzzkf = this.zzasg;
      if (localzzkf != null) {
        break label133;
      }
      k = 0;
      label52:
      m = n;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label142;
        }
      }
    }
    label133:
    label142:
    for (int m = n;; m = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2195);
      return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
      i = this.zzarp.hashCode();
      break;
      label122:
      j = this.zzasf.hashCode();
      break label39;
      k = localzzkf.hashCode();
      break label52;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2197);
    int j = super.zza();
    int i = j;
    if (this.zzarp != null) {
      i = j + zzabw.zzf(1, this.zzarp.intValue());
    }
    j = i;
    if (this.zzasf != null) {
      j = i + zzabw.zzc(2, this.zzasf);
    }
    i = j;
    if (this.zzasg != null) {
      i = j + zzabw.zzb(3, this.zzasg);
    }
    AppMethodBeat.o(2197);
    return i;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2196);
    if (this.zzarp != null) {
      paramzzabw.zze(1, this.zzarp.intValue());
    }
    if (this.zzasf != null) {
      paramzzabw.zzb(2, this.zzasf);
    }
    if (this.zzasg != null) {
      paramzzabw.zza(3, this.zzasg);
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkh
 * JD-Core Version:    0.7.0.1
 */