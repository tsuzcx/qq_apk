package com.google.android.gms.internal;

public final class zzag$zzd
  extends zzbxn<zzd>
{
  public byte[] data = null;
  public byte[] zzcv = null;
  public byte[] zzcw = null;
  public byte[] zzcx = null;
  
  public zzag$zzd()
  {
    this.zzcuJ = -1;
  }
  
  public static zzd zze(byte[] paramArrayOfByte)
  {
    return (zzd)zzbxt.zza(new zzd(), paramArrayOfByte);
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.data != null) {
      paramzzbxm.zzb(1, this.data);
    }
    if (this.zzcv != null) {
      paramzzbxm.zzb(2, this.zzcv);
    }
    if (this.zzcw != null) {
      paramzzbxm.zzb(3, this.zzcw);
    }
    if (this.zzcx != null) {
      paramzzbxm.zzb(4, this.zzcx);
    }
    super.zza(paramzzbxm);
  }
  
  public final zzd zzk(zzbxl paramzzbxl)
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
        this.data = paramzzbxl.readBytes();
        break;
      case 18: 
        this.zzcv = paramzzbxl.readBytes();
        break;
      case 26: 
        this.zzcw = paramzzbxl.readBytes();
        break;
      }
      this.zzcx = paramzzbxl.readBytes();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.data != null) {
      i = j + zzbxm.zzc(1, this.data);
    }
    j = i;
    if (this.zzcv != null) {
      j = i + zzbxm.zzc(2, this.zzcv);
    }
    i = j;
    if (this.zzcw != null) {
      i = j + zzbxm.zzc(3, this.zzcw);
    }
    j = i;
    if (this.zzcx != null) {
      j = i + zzbxm.zzc(4, this.zzcx);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzag.zzd
 * JD-Core Version:    0.7.0.1
 */