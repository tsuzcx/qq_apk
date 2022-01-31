package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

class zzp$3
  implements zzp.zza
{
  private Long zzbFA;
  
  zzp$3(zzp paramzzp, boolean paramBoolean) {}
  
  private long zzQn()
  {
    if (this.zzbFA == null) {
      this.zzbFA = Long.valueOf(zzp.zzc(this.zzbFz).zzQp());
    }
    return this.zzbFA.longValue();
  }
  
  public boolean zzb(Container paramContainer)
  {
    if (this.zzbFB) {
      if (paramContainer.getLastRefreshTime() + zzQn() < zzp.zzd(this.zzbFz).currentTimeMillis()) {}
    }
    while (!paramContainer.isDefault())
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzp.3
 * JD-Core Version:    0.7.0.1
 */