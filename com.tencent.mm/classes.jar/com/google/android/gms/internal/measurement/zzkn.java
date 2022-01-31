package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkn
  extends zzaby<zzkn>
{
  private static volatile zzkn[] zzasz;
  public Integer count;
  public String name;
  public zzko[] zzata;
  public Long zzatb;
  public Long zzatc;
  
  public zzkn()
  {
    AppMethodBeat.i(69707);
    this.zzata = zzko.zzlm();
    this.name = null;
    this.zzatb = null;
    this.zzatc = null;
    this.count = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69707);
  }
  
  public static zzkn[] zzll()
  {
    if (zzasz == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzasz == null) {
        zzasz = new zzkn[0];
      }
      return zzasz;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(69708);
    if (paramObject == this)
    {
      AppMethodBeat.o(69708);
      return true;
    }
    if (!(paramObject instanceof zzkn))
    {
      AppMethodBeat.o(69708);
      return false;
    }
    paramObject = (zzkn)paramObject;
    if (!zzacc.equals(this.zzata, paramObject.zzata))
    {
      AppMethodBeat.o(69708);
      return false;
    }
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(69708);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(69708);
      return false;
    }
    if (this.zzatb == null)
    {
      if (paramObject.zzatb != null)
      {
        AppMethodBeat.o(69708);
        return false;
      }
    }
    else if (!this.zzatb.equals(paramObject.zzatb))
    {
      AppMethodBeat.o(69708);
      return false;
    }
    if (this.zzatc == null)
    {
      if (paramObject.zzatc != null)
      {
        AppMethodBeat.o(69708);
        return false;
      }
    }
    else if (!this.zzatc.equals(paramObject.zzatc))
    {
      AppMethodBeat.o(69708);
      return false;
    }
    if (this.count == null)
    {
      if (paramObject.count != null)
      {
        AppMethodBeat.o(69708);
        return false;
      }
    }
    else if (!this.count.equals(paramObject.count))
    {
      AppMethodBeat.o(69708);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69708);
        return true;
      }
      AppMethodBeat.o(69708);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69708);
    return bool;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(69709);
    int i2 = getClass().getName().hashCode();
    int i3 = zzacc.hashCode(this.zzata);
    int i;
    int j;
    label47:
    int k;
    label56:
    int m;
    if (this.name == null)
    {
      i = 0;
      if (this.zzatb != null) {
        break label147;
      }
      j = 0;
      if (this.zzatc != null) {
        break label158;
      }
      k = 0;
      if (this.count != null) {
        break label169;
      }
      m = 0;
      label66:
      n = i1;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label181;
        }
      }
    }
    label147:
    label158:
    label169:
    label181:
    for (int n = i1;; n = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69709);
      return (m + (k + (j + (i + ((i2 + 527) * 31 + i3) * 31) * 31) * 31) * 31) * 31 + n;
      i = this.name.hashCode();
      break;
      j = this.zzatb.hashCode();
      break label47;
      k = this.zzatc.hashCode();
      break label56;
      m = this.count.hashCode();
      break label66;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69711);
    int i = super.zza();
    int j = i;
    if (this.zzata != null)
    {
      j = i;
      if (this.zzata.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.zzata.length) {
            break;
          }
          zzko localzzko = this.zzata[k];
          j = i;
          if (localzzko != null) {
            j = i + zzabw.zzb(1, localzzko);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.name != null) {
      i = j + zzabw.zzc(2, this.name);
    }
    j = i;
    if (this.zzatb != null) {
      j = i + zzabw.zzc(3, this.zzatb.longValue());
    }
    i = j;
    if (this.zzatc != null) {
      i = j + zzabw.zzc(4, this.zzatc.longValue());
    }
    j = i;
    if (this.count != null) {
      j = i + zzabw.zzf(5, this.count.intValue());
    }
    AppMethodBeat.o(69711);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69710);
    if ((this.zzata != null) && (this.zzata.length > 0))
    {
      int i = 0;
      while (i < this.zzata.length)
      {
        zzko localzzko = this.zzata[i];
        if (localzzko != null) {
          paramzzabw.zza(1, localzzko);
        }
        i += 1;
      }
    }
    if (this.name != null) {
      paramzzabw.zzb(2, this.name);
    }
    if (this.zzatb != null) {
      paramzzabw.zzb(3, this.zzatb.longValue());
    }
    if (this.zzatc != null) {
      paramzzabw.zzb(4, this.zzatc.longValue());
    }
    if (this.count != null) {
      paramzzabw.zze(5, this.count.intValue());
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(69710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkn
 * JD-Core Version:    0.7.0.1
 */