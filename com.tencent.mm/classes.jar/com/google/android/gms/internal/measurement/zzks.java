package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzks
  extends zzaby<zzks>
{
  private static volatile zzks[] zzaum;
  public String name;
  public String zzajf;
  private Float zzarb;
  public Double zzarc;
  public Long zzate;
  public Long zzaun;
  
  public zzks()
  {
    AppMethodBeat.i(2260);
    this.zzaun = null;
    this.name = null;
    this.zzajf = null;
    this.zzate = null;
    this.zzarb = null;
    this.zzarc = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2260);
  }
  
  public static zzks[] zzlo()
  {
    if (zzaum == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzaum == null) {
        zzaum = new zzks[0];
      }
      return zzaum;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2261);
    if (paramObject == this)
    {
      AppMethodBeat.o(2261);
      return true;
    }
    if (!(paramObject instanceof zzks))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    paramObject = (zzks)paramObject;
    if (this.zzaun == null)
    {
      if (paramObject.zzaun != null)
      {
        AppMethodBeat.o(2261);
        return false;
      }
    }
    else if (!this.zzaun.equals(paramObject.zzaun))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(2261);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    if (this.zzajf == null)
    {
      if (paramObject.zzajf != null)
      {
        AppMethodBeat.o(2261);
        return false;
      }
    }
    else if (!this.zzajf.equals(paramObject.zzajf))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    if (this.zzate == null)
    {
      if (paramObject.zzate != null)
      {
        AppMethodBeat.o(2261);
        return false;
      }
    }
    else if (!this.zzate.equals(paramObject.zzate))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    if (this.zzarb == null)
    {
      if (paramObject.zzarb != null)
      {
        AppMethodBeat.o(2261);
        return false;
      }
    }
    else if (!this.zzarb.equals(paramObject.zzarb))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    if (this.zzarc == null)
    {
      if (paramObject.zzarc != null)
      {
        AppMethodBeat.o(2261);
        return false;
      }
    }
    else if (!this.zzarc.equals(paramObject.zzarc))
    {
      AppMethodBeat.o(2261);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2261);
        return true;
      }
      AppMethodBeat.o(2261);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2261);
    return bool;
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    AppMethodBeat.i(2262);
    int i4 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    int k;
    label48:
    int m;
    label58:
    int n;
    label68:
    int i1;
    if (this.zzaun == null)
    {
      i = 0;
      if (this.name != null) {
        break label166;
      }
      j = 0;
      if (this.zzajf != null) {
        break label177;
      }
      k = 0;
      if (this.zzate != null) {
        break label188;
      }
      m = 0;
      if (this.zzarb != null) {
        break label200;
      }
      n = 0;
      if (this.zzarc != null) {
        break label212;
      }
      i1 = 0;
      label78:
      i2 = i3;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label224;
        }
      }
    }
    label166:
    label177:
    label188:
    label200:
    label212:
    label224:
    for (int i2 = i3;; i2 = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2262);
      return (i1 + (n + (m + (k + (j + (i + (i4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = this.zzaun.hashCode();
      break;
      j = this.name.hashCode();
      break label39;
      k = this.zzajf.hashCode();
      break label48;
      m = this.zzate.hashCode();
      break label58;
      n = this.zzarb.hashCode();
      break label68;
      i1 = this.zzarc.hashCode();
      break label78;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2264);
    int j = super.zza();
    int i = j;
    if (this.zzaun != null) {
      i = j + zzabw.zzc(1, this.zzaun.longValue());
    }
    j = i;
    if (this.name != null) {
      j = i + zzabw.zzc(2, this.name);
    }
    i = j;
    if (this.zzajf != null) {
      i = j + zzabw.zzc(3, this.zzajf);
    }
    j = i;
    if (this.zzate != null) {
      j = i + zzabw.zzc(4, this.zzate.longValue());
    }
    i = j;
    if (this.zzarb != null)
    {
      this.zzarb.floatValue();
      i = j + (zzabw.zzaq(5) + 4);
    }
    j = i;
    if (this.zzarc != null)
    {
      this.zzarc.doubleValue();
      j = i + (zzabw.zzaq(6) + 8);
    }
    AppMethodBeat.o(2264);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2263);
    if (this.zzaun != null) {
      paramzzabw.zzb(1, this.zzaun.longValue());
    }
    if (this.name != null) {
      paramzzabw.zzb(2, this.name);
    }
    if (this.zzajf != null) {
      paramzzabw.zzb(3, this.zzajf);
    }
    if (this.zzate != null) {
      paramzzabw.zzb(4, this.zzate.longValue());
    }
    if (this.zzarb != null) {
      paramzzabw.zza(5, this.zzarb.floatValue());
    }
    if (this.zzarc != null) {
      paramzzabw.zza(6, this.zzarc.doubleValue());
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzks
 * JD-Core Version:    0.7.0.1
 */