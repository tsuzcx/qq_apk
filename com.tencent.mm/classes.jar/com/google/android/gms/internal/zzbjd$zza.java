package com.google.android.gms.internal;

public final class zzbjd$zza
  extends zzbxn<zza>
{
  public long zzbNi;
  public zzaj.zzj zzbNj;
  public zzaj.zzf zzlr;
  
  public zzbjd$zza()
  {
    zzTu();
  }
  
  public static zza zzQ(byte[] paramArrayOfByte)
  {
    return (zza)zzbxt.zza(new zza(), paramArrayOfByte);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      if (this.zzbNi != paramObject.zzbNi) {
        return false;
      }
      if (this.zzlr == null)
      {
        if (paramObject.zzlr != null) {
          return false;
        }
      }
      else if (!this.zzlr.equals(paramObject.zzlr)) {
        return false;
      }
      if (this.zzbNj == null)
      {
        if (paramObject.zzbNj != null) {
          return false;
        }
      }
      else if (!this.zzbNj.equals(paramObject.zzbNj)) {
        return false;
      }
      if ((this.zzcuA != null) && (!this.zzcuA.isEmpty())) {
        break;
      }
    } while ((paramObject.zzcuA == null) || (paramObject.zzcuA.isEmpty()));
    return false;
    return this.zzcuA.equals(paramObject.zzcuA);
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = (int)(this.zzbNi ^ this.zzbNi >>> 32);
    int i;
    int j;
    if (this.zzlr == null)
    {
      i = 0;
      if (this.zzbNj != null) {
        break label110;
      }
      j = 0;
      label48:
      k = m;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label121;
        }
      }
    }
    label110:
    label121:
    for (int k = m;; k = this.zzcuA.hashCode())
    {
      return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      i = this.zzlr.hashCode();
      break;
      j = this.zzbNj.hashCode();
      break label48;
    }
  }
  
  public final zza zzTu()
  {
    this.zzbNi = 0L;
    this.zzlr = null;
    this.zzbNj = null;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final zza zzW(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.zzbNi = paramzzbxl.zzaeq();
        break;
      case 18: 
        if (this.zzlr == null) {
          this.zzlr = new zzaj.zzf();
        }
        paramzzbxl.zza(this.zzlr);
        break;
      }
      if (this.zzbNj == null) {
        this.zzbNj = new zzaj.zzj();
      }
      paramzzbxl.zza(this.zzbNj);
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    paramzzbxm.zzb(1, this.zzbNi);
    if (this.zzlr != null) {
      paramzzbxm.zza(2, this.zzlr);
    }
    if (this.zzbNj != null) {
      paramzzbxm.zza(3, this.zzbNj);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int j = super.zzu() + zzbxm.zzf(1, this.zzbNi);
    int i = j;
    if (this.zzlr != null) {
      i = j + zzbxm.zzc(2, this.zzlr);
    }
    j = i;
    if (this.zzbNj != null) {
      j = i + zzbxm.zzc(3, this.zzbNj);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjd.zza
 * JD-Core Version:    0.7.0.1
 */