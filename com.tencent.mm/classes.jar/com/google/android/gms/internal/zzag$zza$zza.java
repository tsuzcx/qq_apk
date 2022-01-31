package com.google.android.gms.internal;

public final class zzag$zza$zza
  extends zzbxn<zza>
{
  private static volatile zza[] zzcc;
  public Long zzbn = null;
  public Long zzbo = null;
  public Long zzcd = null;
  public Long zzce = null;
  public Long zzcf = null;
  public Long zzcg = null;
  public Integer zzch = null;
  public Long zzci = null;
  public Long zzcj = null;
  public Long zzck = null;
  public Integer zzcl = null;
  public Long zzcm = null;
  
  public zzag$zza$zza()
  {
    this.zzcuJ = -1;
  }
  
  public static zza[] zzv()
  {
    if (zzcc == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzcc == null) {
        zzcc = new zza[0];
      }
      return zzcc;
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzbn != null) {
      paramzzbxm.zzb(1, this.zzbn.longValue());
    }
    if (this.zzbo != null) {
      paramzzbxm.zzb(2, this.zzbo.longValue());
    }
    if (this.zzcd != null) {
      paramzzbxm.zzb(3, this.zzcd.longValue());
    }
    if (this.zzce != null) {
      paramzzbxm.zzb(4, this.zzce.longValue());
    }
    if (this.zzcf != null) {
      paramzzbxm.zzb(5, this.zzcf.longValue());
    }
    if (this.zzcg != null) {
      paramzzbxm.zzb(6, this.zzcg.longValue());
    }
    if (this.zzch != null) {
      paramzzbxm.zzJ(7, this.zzch.intValue());
    }
    if (this.zzci != null) {
      paramzzbxm.zzb(8, this.zzci.longValue());
    }
    if (this.zzcj != null) {
      paramzzbxm.zzb(9, this.zzcj.longValue());
    }
    if (this.zzck != null) {
      paramzzbxm.zzb(10, this.zzck.longValue());
    }
    if (this.zzcl != null) {
      paramzzbxm.zzJ(11, this.zzcl.intValue());
    }
    if (this.zzcm != null) {
      paramzzbxm.zzb(12, this.zzcm.longValue());
    }
    super.zza(paramzzbxm);
  }
  
  public final zza zzg(zzbxl paramzzbxl)
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
        this.zzbn = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 16: 
        this.zzbo = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 24: 
        this.zzcd = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 32: 
        this.zzce = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 40: 
        this.zzcf = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 48: 
        this.zzcg = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 56: 
        i = paramzzbxl.zzaer();
        switch (i)
        {
        default: 
          break;
        }
        this.zzch = Integer.valueOf(i);
        break;
      case 64: 
        this.zzci = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 72: 
        this.zzcj = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 80: 
        this.zzck = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 88: 
        i = paramzzbxl.zzaer();
        switch (i)
        {
        default: 
          break;
        }
        this.zzcl = Integer.valueOf(i);
        break;
      }
      this.zzcm = Long.valueOf(paramzzbxl.zzaeq());
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzbn != null) {
      i = j + zzbxm.zzf(1, this.zzbn.longValue());
    }
    j = i;
    if (this.zzbo != null) {
      j = i + zzbxm.zzf(2, this.zzbo.longValue());
    }
    i = j;
    if (this.zzcd != null) {
      i = j + zzbxm.zzf(3, this.zzcd.longValue());
    }
    j = i;
    if (this.zzce != null) {
      j = i + zzbxm.zzf(4, this.zzce.longValue());
    }
    i = j;
    if (this.zzcf != null) {
      i = j + zzbxm.zzf(5, this.zzcf.longValue());
    }
    j = i;
    if (this.zzcg != null) {
      j = i + zzbxm.zzf(6, this.zzcg.longValue());
    }
    i = j;
    if (this.zzch != null) {
      i = j + zzbxm.zzL(7, this.zzch.intValue());
    }
    j = i;
    if (this.zzci != null) {
      j = i + zzbxm.zzf(8, this.zzci.longValue());
    }
    i = j;
    if (this.zzcj != null) {
      i = j + zzbxm.zzf(9, this.zzcj.longValue());
    }
    j = i;
    if (this.zzck != null) {
      j = i + zzbxm.zzf(10, this.zzck.longValue());
    }
    i = j;
    if (this.zzcl != null) {
      i = j + zzbxm.zzL(11, this.zzcl.intValue());
    }
    j = i;
    if (this.zzcm != null) {
      j = i + zzbxm.zzf(12, this.zzcm.longValue());
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzag.zza.zza
 * JD-Core Version:    0.7.0.1
 */