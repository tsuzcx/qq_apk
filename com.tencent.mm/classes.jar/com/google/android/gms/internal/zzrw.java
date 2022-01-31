package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrw
  extends zzf<zzrw>
{
  public String mCategory;
  public String zzadc;
  public String zzadx;
  public long zzady;
  
  public final String getCategory()
  {
    return this.mCategory;
  }
  
  public final String getLabel()
  {
    return this.zzadc;
  }
  
  public final long getTimeInMillis()
  {
    return this.zzady;
  }
  
  public final void setTimeInMillis(long paramLong)
  {
    this.zzady = paramLong;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("variableName", this.zzadx);
    localHashMap.put("timeInMillis", Long.valueOf(this.zzady));
    localHashMap.put("category", this.mCategory);
    localHashMap.put("label", this.zzadc);
    return zzj(localHashMap);
  }
  
  public final void zza(zzrw paramzzrw)
  {
    if (!TextUtils.isEmpty(this.zzadx)) {
      paramzzrw.zzbL(this.zzadx);
    }
    if (this.zzady != 0L) {
      paramzzrw.setTimeInMillis(this.zzady);
    }
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzrw.zzbB(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.zzadc)) {
      paramzzrw.zzbD(this.zzadc);
    }
  }
  
  public final void zzbB(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public final void zzbD(String paramString)
  {
    this.zzadc = paramString;
  }
  
  public final void zzbL(String paramString)
  {
    this.zzadx = paramString;
  }
  
  public final String zznF()
  {
    return this.zzadx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzrw
 * JD-Core Version:    0.7.0.1
 */