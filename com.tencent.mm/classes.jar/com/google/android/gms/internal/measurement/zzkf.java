package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkf
  extends zzaby<zzkf>
{
  private static volatile zzkf[] zzaru;
  public zzki zzarv;
  public zzkg zzarw;
  public Boolean zzarx;
  public String zzary;
  
  public zzkf()
  {
    AppMethodBeat.i(2180);
    this.zzarv = null;
    this.zzarw = null;
    this.zzarx = null;
    this.zzary = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2180);
  }
  
  public static zzkf[] zzlg()
  {
    if (zzaru == null) {}
    synchronized (zzacc.zzbxg)
    {
      if (zzaru == null) {
        zzaru = new zzkf[0];
      }
      return zzaru;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2181);
    if (paramObject == this)
    {
      AppMethodBeat.o(2181);
      return true;
    }
    if (!(paramObject instanceof zzkf))
    {
      AppMethodBeat.o(2181);
      return false;
    }
    paramObject = (zzkf)paramObject;
    if (this.zzarv == null)
    {
      if (paramObject.zzarv != null)
      {
        AppMethodBeat.o(2181);
        return false;
      }
    }
    else if (!this.zzarv.equals(paramObject.zzarv))
    {
      AppMethodBeat.o(2181);
      return false;
    }
    if (this.zzarw == null)
    {
      if (paramObject.zzarw != null)
      {
        AppMethodBeat.o(2181);
        return false;
      }
    }
    else if (!this.zzarw.equals(paramObject.zzarw))
    {
      AppMethodBeat.o(2181);
      return false;
    }
    if (this.zzarx == null)
    {
      if (paramObject.zzarx != null)
      {
        AppMethodBeat.o(2181);
        return false;
      }
    }
    else if (!this.zzarx.equals(paramObject.zzarx))
    {
      AppMethodBeat.o(2181);
      return false;
    }
    if (this.zzary == null)
    {
      if (paramObject.zzary != null)
      {
        AppMethodBeat.o(2181);
        return false;
      }
    }
    else if (!this.zzary.equals(paramObject.zzary))
    {
      AppMethodBeat.o(2181);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2181);
        return true;
      }
      AppMethodBeat.o(2181);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2181);
    return bool;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(2182);
    int i2 = getClass().getName().hashCode();
    Object localObject = this.zzarv;
    int i;
    int j;
    label47:
    int k;
    label56:
    int m;
    if (localObject == null)
    {
      i = 0;
      localObject = this.zzarw;
      if (localObject != null) {
        break label140;
      }
      j = 0;
      if (this.zzarx != null) {
        break label149;
      }
      k = 0;
      if (this.zzary != null) {
        break label160;
      }
      m = 0;
      label66:
      n = i1;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label172;
        }
      }
    }
    label140:
    label149:
    label160:
    label172:
    for (int n = i1;; n = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2182);
      return (m + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = ((zzki)localObject).hashCode();
      break;
      j = ((zzkg)localObject).hashCode();
      break label47;
      k = this.zzarx.hashCode();
      break label56;
      m = this.zzary.hashCode();
      break label66;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2184);
    int j = super.zza();
    int i = j;
    if (this.zzarv != null) {
      i = j + zzabw.zzb(1, this.zzarv);
    }
    j = i;
    if (this.zzarw != null) {
      j = i + zzabw.zzb(2, this.zzarw);
    }
    i = j;
    if (this.zzarx != null)
    {
      this.zzarx.booleanValue();
      i = j + (zzabw.zzaq(3) + 1);
    }
    j = i;
    if (this.zzary != null) {
      j = i + zzabw.zzc(4, this.zzary);
    }
    AppMethodBeat.o(2184);
    return j;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2183);
    if (this.zzarv != null) {
      paramzzabw.zza(1, this.zzarv);
    }
    if (this.zzarw != null) {
      paramzzabw.zza(2, this.zzarw);
    }
    if (this.zzarx != null) {
      paramzzabw.zza(3, this.zzarx.booleanValue());
    }
    if (this.zzary != null) {
      paramzzabw.zzb(4, this.zzary);
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkf
 * JD-Core Version:    0.7.0.1
 */