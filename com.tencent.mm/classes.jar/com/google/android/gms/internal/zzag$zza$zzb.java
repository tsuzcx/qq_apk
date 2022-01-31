package com.google.android.gms.internal;

public final class zzag$zza$zzb
  extends zzbxn<zzb>
{
  public Long zzbP = null;
  public Long zzbQ = null;
  public Long zzcn = null;
  
  public zzag$zza$zzb()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzbP != null) {
      paramzzbxm.zzb(1, this.zzbP.longValue());
    }
    if (this.zzbQ != null) {
      paramzzbxm.zzb(2, this.zzbQ.longValue());
    }
    if (this.zzcn != null) {
      paramzzbxm.zzb(3, this.zzcn.longValue());
    }
    super.zza(paramzzbxm);
  }
  
  public final zzb zzh(zzbxl paramzzbxl)
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
        this.zzbP = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 16: 
        this.zzbQ = Long.valueOf(paramzzbxl.zzaeq());
        break;
      }
      this.zzcn = Long.valueOf(paramzzbxl.zzaeq());
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzbP != null) {
      i = j + zzbxm.zzf(1, this.zzbP.longValue());
    }
    j = i;
    if (this.zzbQ != null) {
      j = i + zzbxm.zzf(2, this.zzbQ.longValue());
    }
    i = j;
    if (this.zzcn != null) {
      i = j + zzbxm.zzf(3, this.zzcn.longValue());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzag.zza.zzb
 * JD-Core Version:    0.7.0.1
 */