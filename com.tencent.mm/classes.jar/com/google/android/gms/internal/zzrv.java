package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrv
  extends zzf<zzrv>
{
  public String zzadb;
  public String zzadv;
  public String zzadw;
  
  public final String getAction()
  {
    return this.zzadb;
  }
  
  public final String getTarget()
  {
    return this.zzadw;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("network", this.zzadv);
    localHashMap.put("action", this.zzadb);
    localHashMap.put("target", this.zzadw);
    return zzj(localHashMap);
  }
  
  public final void zza(zzrv paramzzrv)
  {
    if (!TextUtils.isEmpty(this.zzadv)) {
      paramzzrv.zzbJ(this.zzadv);
    }
    if (!TextUtils.isEmpty(this.zzadb)) {
      paramzzrv.zzbC(this.zzadb);
    }
    if (!TextUtils.isEmpty(this.zzadw)) {
      paramzzrv.zzbK(this.zzadw);
    }
  }
  
  public final void zzbC(String paramString)
  {
    this.zzadb = paramString;
  }
  
  public final void zzbJ(String paramString)
  {
    this.zzadv = paramString;
  }
  
  public final void zzbK(String paramString)
  {
    this.zzadw = paramString;
  }
  
  public final String zznE()
  {
    return this.zzadv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzrv
 * JD-Core Version:    0.7.0.1
 */