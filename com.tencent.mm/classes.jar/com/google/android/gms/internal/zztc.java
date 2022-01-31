package com.google.android.gms.internal;

import com.google.android.gms.analytics.Logger;

@Deprecated
public class zztc
{
  private static volatile Logger zzagr;
  
  static
  {
    setLogger(new zzsq());
  }
  
  public static Logger getLogger()
  {
    return zzagr;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    zzagr = paramLogger;
  }
  
  public static void v(String paramString)
  {
    Object localObject = zztd.zzpW();
    if (localObject != null) {
      ((zztd)localObject).zzbP(paramString);
    }
    for (;;)
    {
      localObject = zzagr;
      if (localObject != null) {
        ((Logger)localObject).verbose(paramString);
      }
      return;
      if (zzak(0)) {
        zzsw.zzafl.get();
      }
    }
  }
  
  public static boolean zzak(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getLogger() != null)
    {
      bool1 = bool2;
      if (getLogger().getLogLevel() <= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void zzbh(String paramString)
  {
    Object localObject = zztd.zzpW();
    if (localObject != null) {
      ((zztd)localObject).zzbS(paramString);
    }
    for (;;)
    {
      localObject = zzagr;
      if (localObject != null) {
        ((Logger)localObject).warn(paramString);
      }
      return;
      if (zzak(2)) {
        zzsw.zzafl.get();
      }
    }
  }
  
  public static void zzf(String paramString, Object paramObject)
  {
    zztd localzztd = zztd.zzpW();
    if (localzztd != null) {
      localzztd.zze(paramString, paramObject);
    }
    for (;;)
    {
      paramObject = zzagr;
      if (paramObject != null) {
        paramObject.error(paramString);
      }
      return;
      if (zzak(3))
      {
        if (paramObject != null)
        {
          paramObject = String.valueOf(paramObject);
          new StringBuilder(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length()).append(paramString).append(":").append(paramObject);
        }
        zzsw.zzafl.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zztc
 * JD-Core Version:    0.7.0.1
 */