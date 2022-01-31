package com.google.android.gms.internal;

public final class zzag$zzc
  extends zzbxn<zzc>
{
  public byte[] zzct = null;
  public byte[] zzcu = null;
  
  public zzag$zzc()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzct != null) {
      paramzzbxm.zzb(1, this.zzct);
    }
    if (this.zzcu != null) {
      paramzzbxm.zzb(2, this.zzcu);
    }
    super.zza(paramzzbxm);
  }
  
  public final zzc zzj(zzbxl paramzzbxl)
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
        this.zzct = paramzzbxl.readBytes();
        break;
      }
      this.zzcu = paramzzbxl.readBytes();
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzct != null) {
      i = j + zzbxm.zzc(1, this.zzct);
    }
    j = i;
    if (this.zzcu != null) {
      j = i + zzbxm.zzc(2, this.zzcu);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzag.zzc
 * JD-Core Version:    0.7.0.1
 */