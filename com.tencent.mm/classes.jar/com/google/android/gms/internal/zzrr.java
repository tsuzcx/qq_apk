package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrr
  extends zzf<zzrr>
{
  private String mCategory;
  private String zzadb;
  private String zzadc;
  private long zzadd;
  
  public final String getAction()
  {
    return this.zzadb;
  }
  
  public final String getCategory()
  {
    return this.mCategory;
  }
  
  public final String getLabel()
  {
    return this.zzadc;
  }
  
  public final long getValue()
  {
    return this.zzadd;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("category", this.mCategory);
    localHashMap.put("action", this.zzadb);
    localHashMap.put("label", this.zzadc);
    localHashMap.put("value", Long.valueOf(this.zzadd));
    return zzj(localHashMap);
  }
  
  public final void zza(zzrr paramzzrr)
  {
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzrr.zzbB(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.zzadb)) {
      paramzzrr.zzbC(this.zzadb);
    }
    if (!TextUtils.isEmpty(this.zzadc)) {
      paramzzrr.zzbD(this.zzadc);
    }
    if (this.zzadd != 0L) {
      paramzzrr.zzr(this.zzadd);
    }
  }
  
  public final void zzbB(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public final void zzbC(String paramString)
  {
    this.zzadb = paramString;
  }
  
  public final void zzbD(String paramString)
  {
    this.zzadc = paramString;
  }
  
  public final void zzr(long paramLong)
  {
    this.zzadd = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzrr
 * JD-Core Version:    0.7.0.1
 */