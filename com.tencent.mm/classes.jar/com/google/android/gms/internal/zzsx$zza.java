package com.google.android.gms.internal;

class zzsx$zza
  implements zzso.zza<zzsy>
{
  private final zzsc zzadO;
  private final zzsy zzagc;
  
  public zzsx$zza(zzsc paramzzsc)
  {
    this.zzadO = paramzzsc;
    this.zzagc = new zzsy();
  }
  
  public void zzd(String paramString, int paramInt)
  {
    if ("ga_dispatchPeriod".equals(paramString))
    {
      this.zzagc.zzage = paramInt;
      return;
    }
    this.zzadO.zznS().zzd("Int xml configuration name not recognized", paramString);
  }
  
  public void zze(String paramString, boolean paramBoolean)
  {
    if ("ga_dryRun".equals(paramString))
    {
      paramString = this.zzagc;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString.zzagf = i;
        return;
      }
    }
    this.zzadO.zznS().zzd("Bool xml configuration name not recognized", paramString);
  }
  
  public void zzp(String paramString1, String paramString2) {}
  
  public zzsy zzpF()
  {
    return this.zzagc;
  }
  
  public void zzq(String paramString1, String paramString2)
  {
    if ("ga_appName".equals(paramString1))
    {
      this.zzagc.zzacL = paramString2;
      return;
    }
    if ("ga_appVersion".equals(paramString1))
    {
      this.zzagc.zzacM = paramString2;
      return;
    }
    if ("ga_logLevel".equals(paramString1))
    {
      this.zzagc.zzagd = paramString2;
      return;
    }
    this.zzadO.zznS().zzd("String xml configuration name not recognized", paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzsx.zza
 * JD-Core Version:    0.7.0.1
 */