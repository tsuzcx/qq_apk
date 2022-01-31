package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrk
  extends zzf<zzrk>
{
  private String mAppId;
  private String zzacL;
  private String zzacM;
  private String zzacN;
  
  public final void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public final void setAppInstallerId(String paramString)
  {
    this.zzacN = paramString;
  }
  
  public final void setAppName(String paramString)
  {
    this.zzacL = paramString;
  }
  
  public final void setAppVersion(String paramString)
  {
    this.zzacM = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appName", this.zzacL);
    localHashMap.put("appVersion", this.zzacM);
    localHashMap.put("appId", this.mAppId);
    localHashMap.put("appInstallerId", this.zzacN);
    return zzj(localHashMap);
  }
  
  public final void zza(zzrk paramzzrk)
  {
    if (!TextUtils.isEmpty(this.zzacL)) {
      paramzzrk.setAppName(this.zzacL);
    }
    if (!TextUtils.isEmpty(this.zzacM)) {
      paramzzrk.setAppVersion(this.zzacM);
    }
    if (!TextUtils.isEmpty(this.mAppId)) {
      paramzzrk.setAppId(this.mAppId);
    }
    if (!TextUtils.isEmpty(this.zzacN)) {
      paramzzrk.setAppInstallerId(this.zzacN);
    }
  }
  
  public final String zzke()
  {
    return this.mAppId;
  }
  
  public final String zzmY()
  {
    return this.zzacL;
  }
  
  public final String zzmZ()
  {
    return this.zzacM;
  }
  
  public final String zzna()
  {
    return this.zzacN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzrk
 * JD-Core Version:    0.7.0.1
 */