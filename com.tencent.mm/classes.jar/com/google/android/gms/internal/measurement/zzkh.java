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
    AppMethodBeat.i(69670);
    this.zzarp = null;
    this.zzasf = null;
    this.zzasg = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69670);
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
    AppMethodBeat.i(69671);
    if (paramObject == this)
    {
      AppMethodBeat.o(69671);
      return true;
    }
    if (!(paramObject instanceof zzkh))
    {
      AppMethodBeat.o(69671);
      return false;
    }
    paramObject = (zzkh)paramObject;
    if (this.zzarp == null)
    {
      if (paramObject.zzarp != null)
      {
        AppMethodBeat.o(69671);
        return false;
      }
    }
    else if (!this.zzarp.equals(paramObject.zzarp))
    {
      AppMethodBeat.o(69671);
      return false;
    }
    if (this.zzasf == null)
    {
      if (paramObject.zzasf != null)
      {
        AppMethodBeat.o(69671);
        return false;
      }
    }
    else if (!this.zzasf.equals(paramObject.zzasf))
    {
      AppMethodBeat.o(69671);
      return false;
    }
    if (this.zzasg == null)
    {
      if (paramObject.zzasg != null)
      {
        AppMethodBeat.o(69671);
        return false;
      }
    }
    else if (!this.zzasg.equals(paramObject.zzasg))
    {
      AppMethodBeat.o(69671);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69671);
        return true;
      }
      AppMethodBeat.o(69671);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69671);
    return bool;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(69672);
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label38:
    zzkf localzzkf;
    int k;
    if (this.zzarp == null)
    {
      i = 0;
      if (this.zzasf != null) {
        break label120;
      }
      j = 0;
      localzzkf = this.zzasg;
      if (localzzkf != null) {
        break label131;
      }
      k = 0;
      label51:
      m = n;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label140;
        }
      }
    }
    label131:
    label140:
    for (int m = n;; m = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69672);
      return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
      i = this.zzarp.hashCode();
      break;
      label120:
      j = this.zzasf.hashCode();
      break label38;
      k = localzzkf.hashCode();
      break label51;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69674);
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
    AppMethodBeat.o(69674);
    return i;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69673);
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
    AppMethodBeat.o(69673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkh
 * JD-Core Version:    0.7.0.1
 */