package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzsz
{
  private final Map<String, String> zzFP;
  private final List<zzsl> zzagg;
  private final long zzagh;
  private final long zzagi;
  private final int zzagj;
  private final boolean zzagk;
  private final String zzagl;
  
  public zzsz(zzrz paramzzrz, Map<String, String> paramMap, long paramLong, boolean paramBoolean)
  {
    this(paramzzrz, paramMap, paramLong, paramBoolean, 0L, 0, null);
  }
  
  public zzsz(zzrz paramzzrz, Map<String, String> paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    this(paramzzrz, paramMap, paramLong1, paramBoolean, paramLong2, paramInt, null);
  }
  
  public zzsz(zzrz paramzzrz, Map<String, String> paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt, List<zzsl> paramList)
  {
    zzac.zzw(paramzzrz);
    zzac.zzw(paramMap);
    this.zzagi = paramLong1;
    this.zzagk = paramBoolean;
    this.zzagh = paramLong2;
    this.zzagj = paramInt;
    if (paramList != null) {}
    Object localObject2;
    for (Object localObject1 = paramList;; localObject1 = Collections.emptyList())
    {
      this.zzagg = ((List)localObject1);
      this.zzagl = zzs(paramList);
      paramList = new HashMap();
      localObject1 = paramMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (zzl(((Map.Entry)localObject2).getKey()))
        {
          String str = zza(paramzzrz, ((Map.Entry)localObject2).getKey());
          if (str != null) {
            paramList.put(str, zzb(paramzzrz, ((Map.Entry)localObject2).getValue()));
          }
        }
      }
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      if (!zzl(((Map.Entry)localObject1).getKey()))
      {
        localObject2 = zza(paramzzrz, ((Map.Entry)localObject1).getKey());
        if (localObject2 != null) {
          paramList.put(localObject2, zzb(paramzzrz, ((Map.Entry)localObject1).getValue()));
        }
      }
    }
    if (!TextUtils.isEmpty(this.zzagl))
    {
      zztm.zzc(paramList, "_v", this.zzagl);
      if ((this.zzagl.equals("ma4.0.0")) || (this.zzagl.equals("ma4.0.1"))) {
        paramList.remove("adid");
      }
    }
    this.zzFP = Collections.unmodifiableMap(paramList);
  }
  
  public static zzsz zza(zzrz paramzzrz, zzsz paramzzsz, Map<String, String> paramMap)
  {
    return new zzsz(paramzzrz, paramMap, paramzzsz.zzpQ(), paramzzsz.zzpS(), paramzzsz.zzpP(), paramzzsz.zzpO(), paramzzsz.zzpR());
  }
  
  private static String zza(zzrz paramzzrz, Object paramObject)
  {
    if (paramObject == null) {
      paramzzrz = null;
    }
    Object localObject;
    do
    {
      return paramzzrz;
      localObject = paramObject.toString();
      paramObject = localObject;
      if (((String)localObject).startsWith("&")) {
        paramObject = ((String)localObject).substring(1);
      }
      int i = paramObject.length();
      localObject = paramObject;
      if (i > 256)
      {
        localObject = paramObject.substring(0, 256);
        paramzzrz.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(i), localObject);
      }
      paramzzrz = (zzrz)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return null;
  }
  
  private static String zzb(zzrz paramzzrz, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      int i = paramObject.length();
      Object localObject = paramObject;
      if (i > 8192)
      {
        localObject = paramObject.substring(0, 8192);
        paramzzrz.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(i), localObject);
      }
      return localObject;
    }
  }
  
  private static boolean zzl(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return paramObject.toString().startsWith("&");
  }
  
  private String zzs(String paramString1, String paramString2)
  {
    zzac.zzdr(paramString1);
    if (!paramString1.startsWith("&")) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Short param name required");
      paramString1 = (String)this.zzFP.get(paramString1);
      if (paramString1 == null) {
        break;
      }
      return paramString1;
    }
    return paramString2;
  }
  
  private static String zzs(List<zzsl> paramList)
  {
    zzsl localzzsl;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localzzsl = (zzsl)paramList.next();
      } while (!"appendVersion".equals(localzzsl.getId()));
    }
    for (paramList = localzzsl.getValue();; paramList = null)
    {
      if (TextUtils.isEmpty(paramList)) {
        return null;
      }
      return paramList;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ht=").append(this.zzagi);
    if (this.zzagh != 0L) {
      localStringBuffer.append(", dbId=").append(this.zzagh);
    }
    if (this.zzagj != 0) {
      localStringBuffer.append(", appUID=").append(this.zzagj);
    }
    Object localObject = new ArrayList(this.zzFP.keySet());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuffer.append(", ");
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append((String)this.zzFP.get(str));
    }
    return localStringBuffer.toString();
  }
  
  public Map<String, String> zzfE()
  {
    return this.zzFP;
  }
  
  public int zzpO()
  {
    return this.zzagj;
  }
  
  public long zzpP()
  {
    return this.zzagh;
  }
  
  public long zzpQ()
  {
    return this.zzagi;
  }
  
  public List<zzsl> zzpR()
  {
    return this.zzagg;
  }
  
  public boolean zzpS()
  {
    return this.zzagk;
  }
  
  public long zzpT()
  {
    return zztm.zzcf(zzs("_s", "0"));
  }
  
  public String zzpU()
  {
    return zzs("_m", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzsz
 * JD-Core Version:    0.7.0.1
 */