package com.google.android.gms.tagmanager;

import java.util.Map;

class Container$zzb
  implements zzu.zza
{
  private Container$zzb(Container paramContainer) {}
  
  public Object zze(String paramString, Map<String, Object> paramMap)
  {
    Container.FunctionCallTagCallback localFunctionCallTagCallback = this.zzbFf.zzgT(paramString);
    if (localFunctionCallTagCallback != null) {
      localFunctionCallTagCallback.execute(paramString, paramMap);
    }
    return zzdl.zzRP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.Container.zzb
 * JD-Core Version:    0.7.0.1
 */