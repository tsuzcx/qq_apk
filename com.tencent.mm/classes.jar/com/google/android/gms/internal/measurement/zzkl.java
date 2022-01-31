package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkl
  extends zzaby<zzkl>
{
  private static volatile zzkl[] zzasu;
  public String value;
  public String zzny;
  
  public zzkl()
  {
    AppMethodBeat.i(69695);
    this.zzny = null;
    this.value = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69695);
  }
  
  public static zzkl[] zzlj()
  {
    if (zzasu == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzasu == null) {
        zzasu = new zzkl[0];
      }
      return zzasu;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(69696);
    if (paramObject == this)
    {
      AppMethodBeat.o(69696);
      return true;
    }
    if (!(paramObject instanceof zzkl))
    {
      AppMethodBeat.o(69696);
      return false;
    }
    paramObject = (zzkl)paramObject;
    if (this.zzny == null)
    {
      if (paramObject.zzny != null)
      {
        AppMethodBeat.o(69696);
        return false;
      }
    }
    else if (!this.zzny.equals(paramObject.zzny))
    {
      AppMethodBeat.o(69696);
      return false;
    }
    if (this.value == null)
    {
      if (paramObject.value != null)
      {
        AppMethodBeat.o(69696);
        return false;
      }
    }
    else if (!this.value.equals(paramObject.value))
    {
      AppMethodBeat.o(69696);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69696);
        return true;
      }
      AppMethodBeat.o(69696);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69696);
    return bool;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(69697);
    int n = getClass().getName().hashCode();
    int i;
    int j;
    if (this.zzny == null)
    {
      i = 0;
      if (this.value != null) {
        break label99;
      }
      j = 0;
      label38:
      k = m;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label110;
        }
      }
    }
    label99:
    label110:
    for (int k = m;; k = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69697);
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.zzny.hashCode();
      break;
      j = this.value.hashCode();
      break label38;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69699);
    int j = super.zza();
    int i = j;
    if (this.zzny != null) {
      i = j + zzabw.zzc(1, this.zzny);
    }
    j = i;
    if (this.value != null) {
      j = i + zzabw.zzc(2, this.value);
    }
    AppMethodBeat.o(69699);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69698);
    if (this.zzny != null) {
      paramzzabw.zzb(1, this.zzny);
    }
    if (this.value != null) {
      paramzzabw.zzb(2, this.value);
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(69698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkl
 * JD-Core Version:    0.7.0.1
 */