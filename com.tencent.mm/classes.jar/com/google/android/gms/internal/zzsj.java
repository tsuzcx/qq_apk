package com.google.android.gms.internal;

public enum zzsj
{
  private zzsj() {}
  
  public static zzsj zzbY(String paramString)
  {
    if ("BATCH_BY_SESSION".equalsIgnoreCase(paramString)) {
      return zzaeM;
    }
    if ("BATCH_BY_TIME".equalsIgnoreCase(paramString)) {
      return zzaeN;
    }
    if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(paramString)) {
      return zzaeO;
    }
    if ("BATCH_BY_COUNT".equalsIgnoreCase(paramString)) {
      return zzaeP;
    }
    if ("BATCH_BY_SIZE".equalsIgnoreCase(paramString)) {
      return zzaeQ;
    }
    return zzaeL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzsj
 * JD-Core Version:    0.7.0.1
 */