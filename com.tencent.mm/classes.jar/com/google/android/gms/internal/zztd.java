package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zztd
  extends zzsa
{
  private static String zzags = "3";
  private static String zzagt = "01VDIWEA?";
  private static zztd zzagu;
  
  public zztd(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  public static zztd zzpW()
  {
    return zzagu;
  }
  
  public void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str = (String)zzsw.zzafl.get();
    if (Log.isLoggable(str, paramInt)) {
      Log.println(paramInt, str, zzc(paramString, paramObject1, paramObject2, paramObject3));
    }
    if (paramInt >= 5) {
      zzb(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
  }
  
  public void zza(zzsz paramzzsz, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "no reason provided";
    }
    if (paramzzsz != null)
    {
      paramzzsz = paramzzsz.toString();
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {
        break label50;
      }
    }
    label50:
    for (paramString = "Discarding hit. ".concat(paramString);; paramString = new String("Discarding hit. "))
    {
      zzd(paramString, paramzzsz);
      return;
      paramzzsz = "no hit data";
      break;
    }
  }
  
  public void zzb(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        zzac.zzw(paramString);
        if (paramInt < 0)
        {
          paramInt = i;
          if (paramInt >= zzagt.length())
          {
            paramInt = zzagt.length() - 1;
            if (zznT().zzoW())
            {
              c1 = 'C';
              String str1 = zzags;
              char c2 = zzagt.charAt(paramInt);
              String str2 = zzsb.VERSION;
              paramString = String.valueOf(zzc(paramString, zzm(paramObject1), zzm(paramObject2), zzm(paramObject3)));
              paramObject1 = String.valueOf(str1).length() + 3 + String.valueOf(str2).length() + String.valueOf(paramString).length() + str1 + c2 + c1 + str2 + ":" + paramString;
              paramString = paramObject1;
              if (paramObject1.length() > 1024) {
                paramString = paramObject1.substring(0, 1024);
              }
              paramObject1 = zznQ().zzog();
              if (paramObject1 != null) {
                paramObject1.zzqj().zzcc(paramString);
              }
              return;
            }
            char c1 = 'c';
            continue;
          }
        }
      }
      finally {}
    }
  }
  
  public void zzg(Map<String, String> paramMap, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "no reason provided";
    }
    if (paramMap != null)
    {
      paramString = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (paramString.length() > 0) {
          paramString.append(',');
        }
        paramString.append((String)localEntry.getKey());
        paramString.append('=');
        paramString.append((String)localEntry.getValue());
      }
      paramMap = paramString.toString();
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {
        break label144;
      }
    }
    label144:
    for (paramString = "Discarding hit. ".concat(paramString);; paramString = new String("Discarding hit. "))
    {
      zzd(paramString, paramMap);
      return;
      paramMap = "no hit data";
      break;
    }
  }
  
  protected String zzm(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Integer)) {
      paramObject = new Long(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      if ((paramObject instanceof Long))
      {
        if (Math.abs(((Long)paramObject).longValue()) < 100L) {
          return String.valueOf(paramObject);
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (String str = "-";; str = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(Math.round(Math.pow(10.0D, paramObject.length() - 1)));
          localStringBuilder.append("...");
          localStringBuilder.append(str);
          localStringBuilder.append(Math.round(Math.pow(10.0D, paramObject.length()) - 1.0D));
          return localStringBuilder.toString();
        }
      }
      if ((paramObject instanceof Boolean)) {
        return String.valueOf(paramObject);
      }
      if ((paramObject instanceof Throwable)) {
        return paramObject.getClass().getCanonicalName();
      }
      return "-";
    }
  }
  
  protected void zzmS()
  {
    try
    {
      zzagu = this;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zztd
 * JD-Core Version:    0.7.0.1
 */