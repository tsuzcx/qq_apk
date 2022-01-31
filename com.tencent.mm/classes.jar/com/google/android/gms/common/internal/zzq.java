package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzq
{
  public static final int zzaGp = 15;
  private static final String zzaGq = null;
  private final String zzaGr;
  private final String zzaGs;
  
  public zzq(String paramString)
  {
    this(paramString, null);
  }
  
  public zzq(String paramString1, String paramString2)
  {
    zzac.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      this.zzaGr = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        break;
      }
      this.zzaGs = null;
      return;
    }
    this.zzaGs = paramString2;
  }
  
  private String zzdq(String paramString)
  {
    if (this.zzaGs == null) {
      return paramString;
    }
    return this.zzaGs.concat(paramString);
  }
  
  public final void zzE(String paramString1, String paramString2)
  {
    if (zzcW(3)) {
      zzdq(paramString2);
    }
  }
  
  public final void zzF(String paramString1, String paramString2)
  {
    if (zzcW(5)) {
      zzdq(paramString2);
    }
  }
  
  public final void zzG(String paramString1, String paramString2)
  {
    if (zzcW(6)) {
      zzdq(paramString2);
    }
  }
  
  public final void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcW(4)) {
      zzdq(paramString2);
    }
  }
  
  public final void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcW(5)) {
      zzdq(paramString2);
    }
  }
  
  public final boolean zzcW(int paramInt)
  {
    return Log.isLoggable(this.zzaGr, paramInt);
  }
  
  public final void zzd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcW(6)) {
      zzdq(paramString2);
    }
  }
  
  public final void zze(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcW(7))
    {
      zzdq(paramString2);
      Log.wtf(paramString1, zzdq(paramString2), paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzq
 * JD-Core Version:    0.7.0.1
 */