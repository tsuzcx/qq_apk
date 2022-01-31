package com.google.android.gms.internal;

import java.util.Map;

class zztk$zza
  extends zzrz
  implements zzso.zza<zztl>
{
  private final zztl zzagN = new zztl();
  
  public zztk$zza(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  public void zzd(String paramString, int paramInt)
  {
    if ("ga_sessionTimeout".equals(paramString))
    {
      this.zzagN.zzagP = paramInt;
      return;
    }
    zzd("int configuration name not recognized", paramString);
  }
  
  public void zze(String paramString, boolean paramBoolean)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    if ("ga_autoActivityTracking".equals(paramString))
    {
      paramString = this.zzagN;
      if (paramBoolean) {}
      for (;;)
      {
        paramString.zzagQ = i;
        return;
        i = 0;
      }
    }
    if ("ga_anonymizeIp".equals(paramString))
    {
      paramString = this.zzagN;
      if (paramBoolean) {}
      for (i = j;; i = 0)
      {
        paramString.zzagR = i;
        return;
      }
    }
    if ("ga_reportUncaughtExceptions".equals(paramString))
    {
      paramString = this.zzagN;
      if (paramBoolean) {}
      for (i = k;; i = 0)
      {
        paramString.zzagS = i;
        return;
      }
    }
    zzd("bool configuration name not recognized", paramString);
  }
  
  public void zzp(String paramString1, String paramString2)
  {
    this.zzagN.zzagT.put(paramString1, paramString2);
  }
  
  public void zzq(String paramString1, String paramString2)
  {
    if ("ga_trackingId".equals(paramString1))
    {
      this.zzagN.zzabs = paramString2;
      return;
    }
    if ("ga_sampleFrequency".equals(paramString1)) {
      try
      {
        this.zzagN.zzagO = Double.parseDouble(paramString2);
        return;
      }
      catch (NumberFormatException paramString1)
      {
        zzc("Error parsing ga_sampleFrequency value", paramString2, paramString1);
        return;
      }
    }
    zzd("string configuration name not recognized", paramString1);
  }
  
  public zztl zzqr()
  {
    return this.zzagN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zztk.zza
 * JD-Core Version:    0.7.0.1
 */