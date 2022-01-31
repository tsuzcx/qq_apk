package com.google.android.gms.analytics;

import com.google.android.gms.internal.zztc;

public final class zzc
{
  public static String zzan(int paramInt)
  {
    return zzc("&cd", paramInt);
  }
  
  public static String zzao(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzap(int paramInt)
  {
    return zzc("&cm", paramInt);
  }
  
  public static String zzaq(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  public static String zzar(int paramInt)
  {
    return zzc("&pr", paramInt);
  }
  
  public static String zzas(int paramInt)
  {
    return zzc("pr", paramInt);
  }
  
  public static String zzat(int paramInt)
  {
    return zzc("&promo", paramInt);
  }
  
  public static String zzau(int paramInt)
  {
    return zzc("promo", paramInt);
  }
  
  public static String zzav(int paramInt)
  {
    return zzc("pi", paramInt);
  }
  
  public static String zzaw(int paramInt)
  {
    return zzc("&il", paramInt);
  }
  
  public static String zzax(int paramInt)
  {
    return zzc("il", paramInt);
  }
  
  public static String zzay(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzaz(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  private static String zzc(String paramString, int paramInt)
  {
    if (paramInt <= 0)
    {
      zztc.zzf("index out of range for prefix", paramString);
      return "";
    }
    return String.valueOf(paramString).length() + 11 + paramString + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.zzc
 * JD-Core Version:    0.7.0.1
 */