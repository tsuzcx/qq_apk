package com.google.android.gms.internal;

import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzy
{
  public static String zza(Map<String, String> paramMap)
  {
    return zza(paramMap, "ISO-8859-1");
  }
  
  public static String zza(Map<String, String> paramMap, String paramString)
  {
    Object localObject = (String)paramMap.get("Content-Type");
    paramMap = paramString;
    int i;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      i = 1;
    }
    for (;;)
    {
      paramMap = paramString;
      if (i < localObject.length)
      {
        paramMap = localObject[i].trim().split("=");
        if ((paramMap.length == 2) && (paramMap[0].equals("charset"))) {
          paramMap = paramMap[1];
        }
      }
      else
      {
        return paramMap;
      }
      i += 1;
    }
  }
  
  public static zzb.zza zzb(zzj paramzzj)
  {
    long l6 = System.currentTimeMillis();
    Map localMap = paramzzj.zzz;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    int j = 0;
    Object localObject = (String)localMap.get("Date");
    if (localObject != null) {
      l3 = zzg((String)localObject);
    }
    localObject = (String)localMap.get("Cache-Control");
    int i;
    long l4;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      j = 0;
      i = 0;
      if (j < localObject.length)
      {
        String str = localObject[j].trim();
        if ((str.equals("no-cache")) || (str.equals("no-store"))) {
          return null;
        }
        if (str.startsWith("max-age=")) {}
        for (;;)
        {
          try
          {
            l4 = Long.parseLong(str.substring(8));
            l2 = l4;
          }
          catch (Exception localException1)
          {
            continue;
          }
          j += 1;
          break;
          if (localException1.startsWith("stale-while-revalidate="))
          {
            try
            {
              l4 = Long.parseLong(localException1.substring(23));
              l1 = l4;
            }
            catch (Exception localException2) {}
          }
          else
          {
            if ((!localException2.equals("must-revalidate")) && (!localException2.equals("proxy-revalidate"))) {
              break label428;
            }
            i = 1;
          }
        }
      }
      j = 1;
    }
    for (;;)
    {
      localObject = (String)localMap.get("Expires");
      if (localObject != null) {}
      for (long l5 = zzg((String)localObject);; l5 = 0L)
      {
        localObject = (String)localMap.get("Last-Modified");
        if (localObject != null) {}
        for (l4 = zzg((String)localObject);; l4 = 0L)
        {
          localObject = (String)localMap.get("ETag");
          if (j != 0)
          {
            l2 = l6 + 1000L * l2;
            if (i != 0) {
              l1 = l2;
            }
          }
          for (;;)
          {
            zzb.zza localzza = new zzb.zza();
            localzza.data = paramzzj.data;
            localzza.zza = ((String)localObject);
            localzza.zze = l2;
            localzza.zzd = l1;
            localzza.zzb = l3;
            localzza.zzc = l4;
            localzza.zzf = localMap;
            return localzza;
            l1 = 1000L * l1 + l2;
            continue;
            if ((l3 > 0L) && (l5 >= l3))
            {
              l2 = l6 + (l5 - l3);
              l1 = l2;
            }
            else
            {
              l1 = 0L;
              l2 = 0L;
            }
          }
        }
      }
      label428:
      break;
      i = 0;
    }
  }
  
  public static long zzg(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzy
 * JD-Core Version:    0.7.0.1
 */