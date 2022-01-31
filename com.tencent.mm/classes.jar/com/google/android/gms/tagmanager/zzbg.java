package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzbg
  extends zzam
{
  private static final String ID = zzah.zzdQ.toString();
  private static final String zzbGB = zzai.zzhM.toString();
  private static final String zzbGC = zzai.zzhQ.toString();
  private static final String zzbGD = zzai.zzhg.toString();
  private static final String zzbGj = zzai.zzfI.toString();
  
  public zzbg()
  {
    super(ID, new String[] { zzbGj });
  }
  
  private String zza(String paramString, zzbg.zza paramzza, Set<Character> paramSet)
  {
    switch (zzbg.1.zzbGE[paramzza.ordinal()])
    {
    default: 
      return paramString;
    case 1: 
      try
      {
        paramzza = zzdp.zzhD(paramString);
        return paramzza;
      }
      catch (UnsupportedEncodingException paramzza)
      {
        zzbo.zzb("Joiner: unsupported encoding", paramzza);
        return paramString;
      }
    }
    paramString = paramString.replace("\\", "\\\\");
    paramSet = paramSet.iterator();
    if (paramSet.hasNext())
    {
      String str = ((Character)paramSet.next()).toString();
      paramzza = String.valueOf(str);
      if (paramzza.length() != 0) {}
      for (paramzza = "\\".concat(paramzza);; paramzza = new String("\\"))
      {
        paramString = paramString.replace(str, paramzza);
        break;
      }
    }
    return paramString;
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, zzbg.zza paramzza, Set<Character> paramSet)
  {
    paramStringBuilder.append(zza(paramString, paramzza, paramSet));
  }
  
  private void zza(Set<Character> paramSet, String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      paramSet.add(Character.valueOf(paramString.charAt(i)));
      i += 1;
    }
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    zzak.zza localzza = (zzak.zza)paramMap.get(zzbGj);
    if (localzza == null) {
      return zzdl.zzRQ();
    }
    Object localObject1 = (zzak.zza)paramMap.get(zzbGB);
    String str1;
    Object localObject2;
    if (localObject1 != null)
    {
      str1 = zzdl.zze((zzak.zza)localObject1);
      localObject1 = (zzak.zza)paramMap.get(zzbGC);
      if (localObject1 == null) {
        break label186;
      }
      localObject2 = zzdl.zze((zzak.zza)localObject1);
      label75:
      localObject1 = zzbg.zza.zzbGF;
      paramMap = (zzak.zza)paramMap.get(zzbGD);
      if (paramMap == null) {
        break label432;
      }
      paramMap = zzdl.zze(paramMap);
      if (!"url".equals(paramMap)) {
        break label193;
      }
      localObject1 = zzbg.zza.zzbGG;
      paramMap = null;
    }
    for (;;)
    {
      label118:
      StringBuilder localStringBuilder = new StringBuilder();
      switch (localzza.type)
      {
      default: 
        zza(localStringBuilder, zzdl.zze(localzza), (zzbg.zza)localObject1, paramMap);
      }
      for (;;)
      {
        return zzdl.zzR(localStringBuilder.toString());
        str1 = "";
        break;
        label186:
        localObject2 = "=";
        break label75;
        label193:
        if ("backslash".equals(paramMap))
        {
          localObject1 = zzbg.zza.zzbGH;
          paramMap = new HashSet();
          zza(paramMap, str1);
          zza(paramMap, (String)localObject2);
          paramMap.remove(Character.valueOf('\\'));
          break label118;
        }
        paramMap = String.valueOf(paramMap);
        if (paramMap.length() != 0) {}
        for (paramMap = "Joiner: unsupported escape type: ".concat(paramMap);; paramMap = new String("Joiner: unsupported escape type: "))
        {
          zzbo.e(paramMap);
          return zzdl.zzRQ();
        }
        int j = 1;
        localObject2 = localzza.zzlu;
        int k = localObject2.length;
        int i = 0;
        while (i < k)
        {
          localzza = localObject2[i];
          if (j == 0) {
            localStringBuilder.append(str1);
          }
          zza(localStringBuilder, zzdl.zze(localzza), (zzbg.zza)localObject1, paramMap);
          i += 1;
          j = 0;
        }
        i = 0;
        while (i < localzza.zzlv.length)
        {
          if (i > 0) {
            localStringBuilder.append(str1);
          }
          String str2 = zzdl.zze(localzza.zzlv[i]);
          String str3 = zzdl.zze(localzza.zzlw[i]);
          zza(localStringBuilder, str2, (zzbg.zza)localObject1, paramMap);
          localStringBuilder.append((String)localObject2);
          zza(localStringBuilder, str3, (zzbg.zza)localObject1, paramMap);
          i += 1;
        }
      }
      label432:
      paramMap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbg
 * JD-Core Version:    0.7.0.1
 */