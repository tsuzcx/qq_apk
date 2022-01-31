package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzu
  extends zzam
{
  private static final String ID = zzah.zzdv.toString();
  private static final String zzbES = zzai.zzfv.toString();
  private static final String zzbFD = zzai.zzhx.toString();
  private final zza zzbFE;
  
  public zzu(zza paramzza)
  {
    super(ID, new String[] { zzbFD });
    this.zzbFE = paramzza;
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    String str = zzdl.zze((zzak.zza)paramMap.get(zzbFD));
    HashMap localHashMap = new HashMap();
    paramMap = (zzak.zza)paramMap.get(zzbES);
    if (paramMap != null)
    {
      paramMap = zzdl.zzj(paramMap);
      if (!(paramMap instanceof Map))
      {
        zzbo.zzbh("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return zzdl.zzRQ();
      }
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      paramMap = zzdl.zzR(this.zzbFE.zze(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      paramMap = String.valueOf(paramMap.getMessage());
      zzbo.zzbh(String.valueOf(str).length() + 34 + String.valueOf(paramMap).length() + "Custom macro/tag " + str + " threw exception " + paramMap);
    }
    return zzdl.zzRQ();
  }
  
  public static abstract interface zza
  {
    public abstract Object zze(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzu
 * JD-Core Version:    0.7.0.1
 */