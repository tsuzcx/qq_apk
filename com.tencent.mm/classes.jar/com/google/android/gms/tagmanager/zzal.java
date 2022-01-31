package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zzc;
import com.google.android.gms.internal.zzaj.zzd;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzal
{
  private static void zza(DataLayer paramDataLayer, zzaj.zzd paramzzd)
  {
    paramzzd = paramzzd.zzkA;
    int j = paramzzd.length;
    int i = 0;
    while (i < j)
    {
      paramDataLayer.zzha(zzdl.zze(paramzzd[i]));
      i += 1;
    }
  }
  
  public static void zza(DataLayer paramDataLayer, zzaj.zzi paramzzi)
  {
    if (paramzzi.zzlp == null)
    {
      zzbo.zzbh("supplemental missing experimentSupplemental");
      return;
    }
    zza(paramDataLayer, paramzzi.zzlp);
    zzb(paramDataLayer, paramzzi.zzlp);
    zzc(paramDataLayer, paramzzi.zzlp);
  }
  
  private static void zzb(DataLayer paramDataLayer, zzaj.zzd paramzzd)
  {
    paramzzd = paramzzd.zzkz;
    int j = paramzzd.length;
    int i = 0;
    while (i < j)
    {
      Map localMap = zzc(paramzzd[i]);
      if (localMap != null) {
        paramDataLayer.push(localMap);
      }
      i += 1;
    }
  }
  
  private static Map<String, Object> zzc(zzak.zza paramzza)
  {
    paramzza = zzdl.zzj(paramzza);
    if (!(paramzza instanceof Map))
    {
      paramzza = String.valueOf(paramzza);
      zzbo.zzbh(String.valueOf(paramzza).length() + 36 + "value: " + paramzza + " is not a map value, ignored.");
      return null;
    }
    return (Map)paramzza;
  }
  
  private static void zzc(DataLayer paramDataLayer, zzaj.zzd paramzzd)
  {
    zzaj.zzc[] arrayOfzzc = paramzzd.zzkB;
    int j = arrayOfzzc.length;
    int i = 0;
    while (i < j)
    {
      zzaj.zzc localzzc = arrayOfzzc[i];
      if (localzzc.zzaB == null)
      {
        zzbo.zzbh("GaExperimentRandom: No key");
        i += 1;
      }
      else
      {
        Object localObject = paramDataLayer.get(localzzc.zzaB);
        if (!(localObject instanceof Number))
        {
          paramzzd = null;
          label64:
          long l1 = localzzc.zzkv;
          long l2 = localzzc.zzkw;
          if ((!localzzc.zzkx) || (paramzzd == null) || (paramzzd.longValue() < l1) || (paramzzd.longValue() > l2))
          {
            if (l1 > l2) {
              break label237;
            }
            localObject = Long.valueOf(Math.round(Math.random() * (l2 - l1) + l1));
          }
          paramDataLayer.zzha(localzzc.zzaB);
          paramzzd = paramDataLayer.zzo(localzzc.zzaB, localObject);
          if (localzzc.zzky > 0L)
          {
            if (paramzzd.containsKey("gtm")) {
              break label245;
            }
            paramzzd.put("gtm", DataLayer.mapOf(new Object[] { "lifetime", Long.valueOf(localzzc.zzky) }));
          }
        }
        for (;;)
        {
          paramDataLayer.push(paramzzd);
          break;
          paramzzd = Long.valueOf(((Number)localObject).longValue());
          break label64;
          label237:
          zzbo.zzbh("GaExperimentRandom: random range invalid");
          break;
          label245:
          localObject = paramzzd.get("gtm");
          if ((localObject instanceof Map)) {
            ((Map)localObject).put("lifetime", Long.valueOf(localzzc.zzky));
          } else {
            zzbo.zzbh("GaExperimentRandom: gtm not a map");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzal
 * JD-Core Version:    0.7.0.1
 */