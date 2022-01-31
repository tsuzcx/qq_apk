package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;

class zzcx$zzb
{
  private zzce<zzak.zza> zzbHW;
  private zzak.zza zzbHX;
  
  public zzcx$zzb(zzce<zzak.zza> paramzzce, zzak.zza paramzza)
  {
    this.zzbHW = paramzzce;
    this.zzbHX = paramzza;
  }
  
  public int getSize()
  {
    int j = ((zzak.zza)this.zzbHW.getObject()).zzaeR();
    if (this.zzbHX == null) {}
    for (int i = 0;; i = this.zzbHX.zzaeR()) {
      return i + j;
    }
  }
  
  public zzce<zzak.zza> zzRp()
  {
    return this.zzbHW;
  }
  
  public zzak.zza zzRq()
  {
    return this.zzbHX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcx.zzb
 * JD-Core Version:    0.7.0.1
 */