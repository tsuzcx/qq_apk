package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class zzbjf$zzc
{
  private final String zzavB;
  private final int zzbMA;
  private final List<zzbjf.zze> zzbMy;
  private final Map<String, List<zzbjf.zza>> zzbMz;
  
  private zzbjf$zzc(List<zzbjf.zze> paramList, Map<String, List<zzbjf.zza>> paramMap, String paramString, int paramInt)
  {
    this.zzbMy = Collections.unmodifiableList(paramList);
    this.zzbMz = Collections.unmodifiableMap(paramMap);
    this.zzavB = paramString;
    this.zzbMA = paramInt;
  }
  
  public static zzbjf.zzd zzTx()
  {
    return new zzbjf.zzd(null);
  }
  
  public String getVersion()
  {
    return this.zzavB;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(zzST());
    String str2 = String.valueOf(this.zzbMz);
    return String.valueOf(str1).length() + 17 + String.valueOf(str2).length() + "Rules: " + str1 + "  Macros: " + str2;
  }
  
  public List<zzbjf.zze> zzST()
  {
    return this.zzbMy;
  }
  
  public Map<String, List<zzbjf.zza>> zzTy()
  {
    return this.zzbMz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjf.zzc
 * JD-Core Version:    0.7.0.1
 */