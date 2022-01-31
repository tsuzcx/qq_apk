package com.google.android.gms.internal;

public final class zzag$zze
  extends zzbxn<zze>
{
  public Long zzco = null;
  public String zzcy = null;
  public byte[] zzcz = null;
  
  public zzag$zze()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzco != null) {
      paramzzbxm.zzb(1, this.zzco.longValue());
    }
    if (this.zzcy != null) {
      paramzzbxm.zzq(3, this.zzcy);
    }
    if (this.zzcz != null) {
      paramzzbxm.zzb(4, this.zzcz);
    }
    super.zza(paramzzbxm);
  }
  
  public final zze zzl(zzbxl paramzzbxl)
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
        this.zzco = Long.valueOf(paramzzbxl.zzaeq());
        break;
      case 26: 
        this.zzcy = paramzzbxl.readString();
        break;
      }
      this.zzcz = paramzzbxl.readBytes();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzco != null) {
      i = j + zzbxm.zzf(1, this.zzco.longValue());
    }
    j = i;
    if (this.zzcy != null) {
      j = i + zzbxm.zzr(3, this.zzcy);
    }
    i = j;
    if (this.zzcz != null) {
      i = j + zzbxm.zzc(4, this.zzcz);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzag.zze
 * JD-Core Version:    0.7.0.1
 */