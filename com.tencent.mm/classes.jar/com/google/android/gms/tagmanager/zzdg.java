package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class zzdg
  extends zzci
{
  public zzdg(String paramString)
  {
    super(paramString);
  }
  
  protected boolean zza(zzak.zza paramzza1, zzak.zza paramzza2, Map<String, zzak.zza> paramMap)
  {
    paramzza1 = zzdl.zze(paramzza1);
    paramzza2 = zzdl.zze(paramzza2);
    if ((paramzza1 == zzdl.zzRP()) || (paramzza2 == zzdl.zzRP())) {
      return false;
    }
    return zza(paramzza1, paramzza2, paramMap);
  }
  
  protected abstract boolean zza(String paramString1, String paramString2, Map<String, zzak.zza> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdg
 * JD-Core Version:    0.7.0.1
 */