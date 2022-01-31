package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class zzci
  extends zzam
{
  private static final String zzbGj = zzai.zzfI.toString();
  private static final String zzbHg = zzai.zzfJ.toString();
  
  public zzci(String paramString)
  {
    super(paramString, new String[] { zzbGj, zzbHg });
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((zzak.zza)((Iterator)localObject).next() == zzdl.zzRQ()) {
        return zzdl.zzR(Boolean.valueOf(false));
      }
    }
    localObject = (zzak.zza)paramMap.get(zzbGj);
    zzak.zza localzza = (zzak.zza)paramMap.get(zzbHg);
    if ((localObject == null) || (localzza == null)) {}
    for (boolean bool = false;; bool = zza((zzak.zza)localObject, localzza, paramMap)) {
      return zzdl.zzR(Boolean.valueOf(bool));
    }
  }
  
  protected abstract boolean zza(zzak.zza paramzza1, zzak.zza paramzza2, Map<String, zzak.zza> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzci
 * JD-Core Version:    0.7.0.1
 */