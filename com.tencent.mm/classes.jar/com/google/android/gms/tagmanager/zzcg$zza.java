package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

class zzcg$zza
  implements zzde.zza
{
  zzcg$zza(zzcg paramzzcg) {}
  
  public void zza(zzas paramzzas)
  {
    zzcg.zza(this.zzbHc, paramzzas.zzQM());
  }
  
  public void zzb(zzas paramzzas)
  {
    zzcg.zza(this.zzbHc, paramzzas.zzQM());
    long l = paramzzas.zzQM();
    zzbo.v(57 + "Permanent failure dispatching hitId: " + l);
  }
  
  public void zzc(zzas paramzzas)
  {
    long l = paramzzas.zzQN();
    if (l == 0L) {
      zzcg.zza(this.zzbHc, paramzzas.zzQM(), zzcg.zza(this.zzbHc).currentTimeMillis());
    }
    while (l + 14400000L >= zzcg.zza(this.zzbHc).currentTimeMillis()) {
      return;
    }
    zzcg.zza(this.zzbHc, paramzzas.zzQM());
    l = paramzzas.zzQM();
    zzbo.v(47 + "Giving up on failed hitId: " + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcg.zza
 * JD-Core Version:    0.7.0.1
 */