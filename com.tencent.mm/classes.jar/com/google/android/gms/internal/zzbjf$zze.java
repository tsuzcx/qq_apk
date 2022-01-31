package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class zzbjf$zze
{
  private final List<zzbjf.zza> zzbMD;
  private final List<zzbjf.zza> zzbME;
  private final List<zzbjf.zza> zzbMF;
  private final List<zzbjf.zza> zzbMG;
  private final List<zzbjf.zza> zzbNl;
  private final List<zzbjf.zza> zzbNm;
  private final List<String> zzbNn;
  private final List<String> zzbNo;
  private final List<String> zzbNp;
  private final List<String> zzbNq;
  
  private zzbjf$zze(List<zzbjf.zza> paramList1, List<zzbjf.zza> paramList2, List<zzbjf.zza> paramList3, List<zzbjf.zza> paramList4, List<zzbjf.zza> paramList5, List<zzbjf.zza> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
  {
    this.zzbMD = Collections.unmodifiableList(paramList1);
    this.zzbME = Collections.unmodifiableList(paramList2);
    this.zzbMF = Collections.unmodifiableList(paramList3);
    this.zzbMG = Collections.unmodifiableList(paramList4);
    this.zzbNl = Collections.unmodifiableList(paramList5);
    this.zzbNm = Collections.unmodifiableList(paramList6);
    this.zzbNn = Collections.unmodifiableList(paramList7);
    this.zzbNo = Collections.unmodifiableList(paramList8);
    this.zzbNp = Collections.unmodifiableList(paramList9);
    this.zzbNq = Collections.unmodifiableList(paramList10);
  }
  
  public static zzbjf.zzf zzTA()
  {
    return new zzbjf.zzf(null);
  }
  
  public String toString()
  {
    String str1 = String.valueOf(zzSX());
    String str2 = String.valueOf(zzSY());
    String str3 = String.valueOf(zzSZ());
    String str4 = String.valueOf(zzTa());
    String str5 = String.valueOf(zzTB());
    String str6 = String.valueOf(zzTC());
    return String.valueOf(str1).length() + 102 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + "Positive predicates: " + str1 + "  Negative predicates: " + str2 + "  Add tags: " + str3 + "  Remove tags: " + str4 + "  Add macros: " + str5 + "  Remove macros: " + str6;
  }
  
  public List<zzbjf.zza> zzSX()
  {
    return this.zzbMD;
  }
  
  public List<zzbjf.zza> zzSY()
  {
    return this.zzbME;
  }
  
  public List<zzbjf.zza> zzSZ()
  {
    return this.zzbMF;
  }
  
  public List<zzbjf.zza> zzTB()
  {
    return this.zzbNl;
  }
  
  public List<zzbjf.zza> zzTC()
  {
    return this.zzbNm;
  }
  
  public List<zzbjf.zza> zzTa()
  {
    return this.zzbMG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjf.zze
 * JD-Core Version:    0.7.0.1
 */