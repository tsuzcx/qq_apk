package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class zzcd
  extends zzci
{
  public zzcd(String paramString)
  {
    super(paramString);
  }
  
  protected boolean zza(zzak.zza paramzza1, zzak.zza paramzza2, Map<String, zzak.zza> paramMap)
  {
    paramzza1 = zzdl.zzf(paramzza1);
    paramzza2 = zzdl.zzf(paramzza2);
    if ((paramzza1 == zzdl.zzRO()) || (paramzza2 == zzdl.zzRO())) {
      return false;
    }
    return zza(paramzza1, paramzza2, paramMap);
  }
  
  protected abstract boolean zza(zzdk paramzzdk1, zzdk paramzzdk2, Map<String, zzak.zza> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcd
 * JD-Core Version:    0.7.0.1
 */