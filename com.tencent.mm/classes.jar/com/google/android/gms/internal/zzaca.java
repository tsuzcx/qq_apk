package com.google.android.gms.internal;

public abstract class zzaca<T>
{
  private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static zzaca.zza zzaDC;
  private static int zzaDD;
  private static final Object zztX = new Object();
  protected final String zzAX;
  protected final T zzAY;
  private T zzaDE = null;
  
  static
  {
    zzaDC = null;
    zzaDD = 0;
  }
  
  protected zzaca(String paramString, T paramT)
  {
    this.zzAX = paramString;
    this.zzAY = paramT;
  }
  
  public static zzaca<String> zzB(String paramString1, String paramString2)
  {
    return new zzaca.5(paramString1, paramString2);
  }
  
  public static zzaca<Float> zza(String paramString, Float paramFloat)
  {
    new zzaca(paramString, paramFloat) {};
  }
  
  public static zzaca<Integer> zza(String paramString, Integer paramInteger)
  {
    return new zzaca.3(paramString, paramInteger);
  }
  
  public static zzaca<Long> zza(String paramString, Long paramLong)
  {
    return new zzaca.2(paramString, paramLong);
  }
  
  public static zzaca<Boolean> zzj(String paramString, boolean paramBoolean)
  {
    return new zzaca.1(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzaca
 * JD-Core Version:    0.7.0.1
 */