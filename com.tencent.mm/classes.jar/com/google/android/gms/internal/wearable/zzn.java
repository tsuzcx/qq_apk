package com.google.android.gms.internal.wearable;

public abstract class zzn<M extends zzn<M>>
  extends zzt
{
  protected zzp zzhc;
  
  public void zza(zzl paramzzl)
  {
    if (this.zzhc == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.zzhc.size())
      {
        this.zzhc.zzp(i).zza(paramzzl);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzk paramzzk, int paramInt)
  {
    int i = paramzzk.getPosition();
    if (!paramzzk.zzd(paramInt)) {
      return false;
    }
    int j = paramInt >>> 3;
    zzv localzzv = new zzv(paramInt, paramzzk.zzb(i, paramzzk.getPosition() - i));
    paramzzk = null;
    if (this.zzhc == null) {
      this.zzhc = new zzp();
    }
    for (;;)
    {
      Object localObject = paramzzk;
      if (paramzzk == null)
      {
        localObject = new zzq();
        this.zzhc.zza(j, (zzq)localObject);
      }
      ((zzq)localObject).zza(localzzv);
      return true;
      paramzzk = this.zzhc.zzo(j);
    }
  }
  
  protected int zzg()
  {
    if (this.zzhc != null)
    {
      int j = 0;
      for (int i = 0;; i = k + i)
      {
        k = i;
        if (j >= this.zzhc.size()) {
          break;
        }
        k = this.zzhc.zzp(j).zzg();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzn
 * JD-Core Version:    0.7.0.1
 */