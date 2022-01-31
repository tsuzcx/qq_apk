package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public class zzbjf$zza
{
  private final zzak.zza zzbHX;
  private final Map<String, zzak.zza> zzbMB;
  
  private zzbjf$zza(Map<String, zzak.zza> paramMap, zzak.zza paramzza)
  {
    this.zzbMB = paramMap;
    this.zzbHX = paramzza;
  }
  
  public static zzbjf.zzb zzTv()
  {
    return new zzbjf.zzb(null);
  }
  
  public String toString()
  {
    String str1 = String.valueOf(zzSV());
    String str2 = String.valueOf(this.zzbHX);
    return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "Properties: " + str1 + " pushAfterEvaluate: " + str2;
  }
  
  public zzak.zza zzRq()
  {
    return this.zzbHX;
  }
  
  public Map<String, zzak.zza> zzSV()
  {
    return Collections.unmodifiableMap(this.zzbMB);
  }
  
  public void zza(String paramString, zzak.zza paramzza)
  {
    this.zzbMB.put(paramString, paramzza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjf.zza
 * JD-Core Version:    0.7.0.1
 */