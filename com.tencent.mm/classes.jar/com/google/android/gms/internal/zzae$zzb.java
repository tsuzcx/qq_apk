package com.google.android.gms.internal;

public final class zzae$zzb
  extends zzbxn<zzb>
{
  public Integer zzaM = null;
  
  public zzae$zzb()
  {
    this.zzcuJ = -1;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if (this.zzaM != null) {
      paramzzbxm.zzJ(27, this.zzaM.intValue());
    }
    super.zza(paramzzbxm);
  }
  
  public final zzb zzc(zzbxl paramzzbxl)
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
      }
      i = paramzzbxl.zzaer();
      switch (i)
      {
      default: 
        break;
      }
      this.zzaM = Integer.valueOf(i);
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzaM != null) {
      i = j + zzbxm.zzL(27, this.zzaM.intValue());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzae.zzb
 * JD-Core Version:    0.7.0.1
 */