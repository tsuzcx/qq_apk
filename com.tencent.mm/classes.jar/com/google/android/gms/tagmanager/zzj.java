package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj
  extends zzdj
{
  private static final String ID = zzah.zzex.toString();
  private static final String URL = zzai.zzjW.toString();
  private static final String zzbES = zzai.zzfv.toString();
  private static final String zzbET = zzai.zzjV.toString();
  static final String zzbEU;
  private static final Set<String> zzbEV = new HashSet();
  private final Context mContext;
  private final zzj.zza zzbEW;
  
  static
  {
    String str = ID;
    zzbEU = String.valueOf(str).length() + 17 + "gtm_" + str + "_unrepeatable";
  }
  
  public zzj(Context paramContext)
  {
    this(paramContext, new zzj.1(paramContext));
  }
  
  zzj(Context paramContext, zzj.zza paramzza)
  {
    super(ID, new String[] { URL });
    this.zzbEW = paramzza;
    this.mContext = paramContext;
  }
  
  private boolean zzgO(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = zzgQ(paramString);
        if (bool2) {
          return bool1;
        }
        if (zzgP(paramString)) {
          zzbEV.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void zzab(Map<String, zzak.zza> paramMap)
  {
    if (paramMap.get(zzbET) != null) {}
    for (String str = zzdl.zze((zzak.zza)paramMap.get(zzbET)); (str != null) && (zzgO(str)); str = null) {
      return;
    }
    Uri.Builder localBuilder = Uri.parse(zzdl.zze((zzak.zza)paramMap.get(URL))).buildUpon();
    paramMap = (zzak.zza)paramMap.get(zzbES);
    if (paramMap != null)
    {
      paramMap = zzdl.zzj(paramMap);
      if (!(paramMap instanceof List))
      {
        paramMap = String.valueOf(localBuilder.build().toString());
        if (paramMap.length() != 0) {}
        for (paramMap = "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(paramMap);; paramMap = new String("ArbitraryPixel: additional params not a list: not sending partial hit: "))
        {
          zzbo.e(paramMap);
          return;
        }
      }
      paramMap = ((List)paramMap).iterator();
      while (paramMap.hasNext())
      {
        Object localObject = paramMap.next();
        if (!(localObject instanceof Map))
        {
          paramMap = String.valueOf(localBuilder.build().toString());
          if (paramMap.length() != 0) {}
          for (paramMap = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(paramMap);; paramMap = new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: "))
          {
            zzbo.e(paramMap);
            return;
          }
        }
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localBuilder.appendQueryParameter(localEntry.getKey().toString(), localEntry.getValue().toString());
        }
      }
    }
    paramMap = localBuilder.build().toString();
    this.zzbEW.zzQb().zzhf(paramMap);
    paramMap = String.valueOf(paramMap);
    if (paramMap.length() != 0) {}
    for (paramMap = "ArbitraryPixel: url = ".concat(paramMap);; paramMap = new String("ArbitraryPixel: url = "))
    {
      zzbo.v(paramMap);
      if (str == null) {
        break;
      }
      try
      {
        zzbEV.add(str);
        zzdd.zzd(this.mContext, zzbEU, str, "true");
        return;
      }
      finally {}
    }
  }
  
  boolean zzgP(String paramString)
  {
    return this.mContext.getSharedPreferences(zzbEU, 0).contains(paramString);
  }
  
  boolean zzgQ(String paramString)
  {
    return zzbEV.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzj
 * JD-Core Version:    0.7.0.1
 */