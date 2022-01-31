package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbjf.zza;
import com.google.android.gms.internal.zzbjf.zzb;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class zzbh
{
  private static zzak.zza zzK(Object paramObject)
  {
    return zzdl.zzR(zzL(paramObject));
  }
  
  static Object zzL(Object paramObject)
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = new HashMap();
      Iterator localIterator = paramObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject).put(str, zzL(paramObject.get(str)));
      }
    }
    return localObject;
  }
  
  public static zzbjf.zzc zzhl(String paramString)
  {
    paramString = zzK(new JSONObject(paramString));
    zzbjf.zzd localzzd = zzbjf.zzc.zzTx();
    int i = 0;
    while (i < paramString.zzlv.length)
    {
      localzzd.zzc(zzbjf.zza.zzTv().zzb(zzai.zzhI.toString(), paramString.zzlv[i]).zzb(zzai.zzhw.toString(), zzdl.zzhw(zzn.zzQc())).zzb(zzn.zzQd(), paramString.zzlw[i]).zzTw());
      i += 1;
    }
    return localzzd.zzTz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbh
 * JD-Core Version:    0.7.0.1
 */