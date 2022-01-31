package com.google.android.gms.internal;

public final class zzae$zza
  extends zzbxn<zza>
{
  public zzae.zzb zzaK;
  public zzae.zzc zzaL;
  
  public zzae$zza()
  {
    this.zzcuJ = -1;
  }
  
  public static zza zzc(byte[] paramArrayOfByte)
  {
    return (zza)zzbxt.zza(new zza(), paramArrayOfByte);
  }
  
  public final zza zza(zzbxl paramzzbxl)
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
      case 10: 
        if (this.zzaK == null) {
          this.zzaK = new zzae.zzb();
        }
        paramzzbxl.zza(this.zzaK);
        break;
      }
      if (this.zzaL == null) {
        this.zzaL = new zzae.zzc();
      }
      paramzzbxl.zza(this.zzaL);
    }
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzaK != null) {
      paramzzbxm.zza(1, this.zzaK);
    }
    if (this.zzaL != null) {
      paramzzbxm.zza(2, this.zzaL);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzaK != null) {
      i = j + zzbxm.zzc(1, this.zzaK);
    }
    j = i;
    if (this.zzaL != null) {
      j = i + zzbxm.zzc(2, this.zzaL);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzae.zza
 * JD-Core Version:    0.7.0.1
 */