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
    AppMethodBeat.i(69737);
    this.zzaun = null;
    this.name = null;
    this.zzajf = null;
    this.zzate = null;
    this.zzarb = null;
    this.zzarc = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69737);
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
    AppMethodBeat.i(69738);
    if (paramObject == this)
    {
      AppMethodBeat.o(69738);
      return true;
    }
    if (!(paramObject instanceof zzks))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    paramObject = (zzks)paramObject;
    if (this.zzaun == null)
    {
      if (paramObject.zzaun != null)
      {
        AppMethodBeat.o(69738);
        return false;
      }
    }
    else if (!this.zzaun.equals(paramObject.zzaun))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(69738);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    if (this.zzajf == null)
    {
      if (paramObject.zzajf != null)
      {
        AppMethodBeat.o(69738);
        return false;
      }
    }
    else if (!this.zzajf.equals(paramObject.zzajf))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    if (this.zzate == null)
    {
      if (paramObject.zzate != null)
      {
        AppMethodBeat.o(69738);
        return false;
      }
    }
    else if (!this.zzate.equals(paramObject.zzate))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    if (this.zzarb == null)
    {
      if (paramObject.zzarb != null)
      {
        AppMethodBeat.o(69738);
        return false;
      }
    }
    else if (!this.zzarb.equals(paramObject.zzarb))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    if (this.zzarc == null)
    {
      if (paramObject.zzarc != null)
      {
        AppMethodBeat.o(69738);
        return false;
      }
    }
    else if (!this.zzarc.equals(paramObject.zzarc))
    {
      AppMethodBeat.o(69738);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69738);
        return true;
      }
      AppMethodBeat.o(69738);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69738);
    return bool;
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    AppMethodBeat.i(69739);
    int i4 = getClass().getName().hashCode();
    int i;
    int j;
    label38:
    int k;
    label47:
    int m;
    label57:
    int n;
    label67:
    int i1;
    if (this.zzaun == null)
    {
      i = 0;
      if (this.name != null) {
        break label164;
      }
      j = 0;
      if (this.zzajf != null) {
        break label175;
      }
      k = 0;
      if (this.zzate != null) {
        break label186;
      }
      m = 0;
      if (this.zzarb != null) {
        break label198;
      }
      n = 0;
      if (this.zzarc != null) {
        break label210;
      }
      i1 = 0;
      label77:
      i2 = i3;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label222;
        }
      }
    }
    label164:
    label175:
    label186:
    label198:
    label210:
    label222:
    for (int i2 = i3;; i2 = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69739);
      return (i1 + (n + (m + (k + (j + (i + (i4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = this.zzaun.hashCode();
      break;
      j = this.name.hashCode();
      break label38;
      k = this.zzajf.hashCode();
      break label47;
      m = this.zzate.hashCode();
      break label57;
      n = this.zzarb.hashCode();
      break label67;
      i1 = this.zzarc.hashCode();
      break label77;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69741);
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
    AppMethodBeat.o(69741);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69740);
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
    AppMethodBeat.o(69740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzks
 * JD-Core Version:    0.7.0.1
 */