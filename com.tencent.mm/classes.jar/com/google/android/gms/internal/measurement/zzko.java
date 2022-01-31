package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzko
  extends zzaby<zzko>
{
  private static volatile zzko[] zzatd;
  public String name;
  public String zzajf;
  private Float zzarb;
  public Double zzarc;
  public Long zzate;
  
  public zzko()
  {
    AppMethodBeat.i(69713);
    this.name = null;
    this.zzajf = null;
    this.zzate = null;
    this.zzarb = null;
    this.zzarc = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(69713);
  }
  
  public static zzko[] zzlm()
  {
    if (zzatd == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzatd == null) {
        zzatd = new zzko[0];
      }
      return zzatd;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(69714);
    if (paramObject == this)
    {
      AppMethodBeat.o(69714);
      return true;
    }
    if (!(paramObject instanceof zzko))
    {
      AppMethodBeat.o(69714);
      return false;
    }
    paramObject = (zzko)paramObject;
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(69714);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(69714);
      return false;
    }
    if (this.zzajf == null)
    {
      if (paramObject.zzajf != null)
      {
        AppMethodBeat.o(69714);
        return false;
      }
    }
    else if (!this.zzajf.equals(paramObject.zzajf))
    {
      AppMethodBeat.o(69714);
      return false;
    }
    if (this.zzate == null)
    {
      if (paramObject.zzate != null)
      {
        AppMethodBeat.o(69714);
        return false;
      }
    }
    else if (!this.zzate.equals(paramObject.zzate))
    {
      AppMethodBeat.o(69714);
      return false;
    }
    if (this.zzarb == null)
    {
      if (paramObject.zzarb != null)
      {
        AppMethodBeat.o(69714);
        return false;
      }
    }
    else if (!this.zzarb.equals(paramObject.zzarb))
    {
      AppMethodBeat.o(69714);
      return false;
    }
    if (this.zzarc == null)
    {
      if (paramObject.zzarc != null)
      {
        AppMethodBeat.o(69714);
        return false;
      }
    }
    else if (!this.zzarc.equals(paramObject.zzarc))
    {
      AppMethodBeat.o(69714);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(69714);
        return true;
      }
      AppMethodBeat.o(69714);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(69714);
    return bool;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(69715);
    int i3 = getClass().getName().hashCode();
    int i;
    int j;
    label38:
    int k;
    label47:
    int m;
    label57:
    int n;
    if (this.name == null)
    {
      i = 0;
      if (this.zzajf != null) {
        break label148;
      }
      j = 0;
      if (this.zzate != null) {
        break label159;
      }
      k = 0;
      if (this.zzarb != null) {
        break label170;
      }
      m = 0;
      if (this.zzarc != null) {
        break label182;
      }
      n = 0;
      label67:
      i1 = i2;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label194;
        }
      }
    }
    label148:
    label159:
    label170:
    label182:
    label194:
    for (int i1 = i2;; i1 = this.zzbww.hashCode())
    {
      AppMethodBeat.o(69715);
      return (n + (m + (k + (j + (i + (i3 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i1;
      i = this.name.hashCode();
      break;
      j = this.zzajf.hashCode();
      break label38;
      k = this.zzate.hashCode();
      break label47;
      m = this.zzarb.hashCode();
      break label57;
      n = this.zzarc.hashCode();
      break label67;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(69717);
    int j = super.zza();
    int i = j;
    if (this.name != null) {
      i = j + zzabw.zzc(1, this.name);
    }
    j = i;
    if (this.zzajf != null) {
      j = i + zzabw.zzc(2, this.zzajf);
    }
    i = j;
    if (this.zzate != null) {
      i = j + zzabw.zzc(3, this.zzate.longValue());
    }
    j = i;
    if (this.zzarb != null)
    {
      this.zzarb.floatValue();
      j = i + (zzabw.zzaq(4) + 4);
    }
    i = j;
    if (this.zzarc != null)
    {
      this.zzarc.doubleValue();
      i = j + (zzabw.zzaq(5) + 8);
    }
    AppMethodBeat.o(69717);
    return i;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(69716);
    if (this.name != null) {
      paramzzabw.zzb(1, this.name);
    }
    if (this.zzajf != null) {
      paramzzabw.zzb(2, this.zzajf);
    }
    if (this.zzate != null) {
      paramzzabw.zzb(3, this.zzate.longValue());
    }
    if (this.zzarb != null) {
      paramzzabw.zza(4, this.zzarb.floatValue());
    }
    if (this.zzarc != null) {
      paramzzabw.zza(5, this.zzarc.doubleValue());
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(69716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzko
 * JD-Core Version:    0.7.0.1
 */