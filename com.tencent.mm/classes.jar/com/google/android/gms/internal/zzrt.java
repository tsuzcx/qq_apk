package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;

public final class zzrt
  extends zzf<zzrt>
{
  private String zzadg;
  private String zzadh;
  private String zzadi;
  private String zzadj;
  private boolean zzadk;
  private String zzadl;
  private boolean zzadm;
  private double zzadn;
  
  public final String getUserId()
  {
    return this.zzadi;
  }
  
  public final void setClientId(String paramString)
  {
    this.zzadh = paramString;
  }
  
  public final void setSampleRate(double paramDouble)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 100.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Sample rate must be between 0% and 100%");
      this.zzadn = paramDouble;
      return;
    }
  }
  
  public final void setUserId(String paramString)
  {
    this.zzadi = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hitType", this.zzadg);
    localHashMap.put("clientId", this.zzadh);
    localHashMap.put("userId", this.zzadi);
    localHashMap.put("androidAdId", this.zzadj);
    localHashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzadk));
    localHashMap.put("sessionControl", this.zzadl);
    localHashMap.put("nonInteraction", Boolean.valueOf(this.zzadm));
    localHashMap.put("sampleRate", Double.valueOf(this.zzadn));
    return zzj(localHashMap);
  }
  
  public final void zzS(boolean paramBoolean)
  {
    this.zzadk = paramBoolean;
  }
  
  public final void zzT(boolean paramBoolean)
  {
    this.zzadm = paramBoolean;
  }
  
  public final void zza(zzrt paramzzrt)
  {
    if (!TextUtils.isEmpty(this.zzadg)) {
      paramzzrt.zzbE(this.zzadg);
    }
    if (!TextUtils.isEmpty(this.zzadh)) {
      paramzzrt.setClientId(this.zzadh);
    }
    if (!TextUtils.isEmpty(this.zzadi)) {
      paramzzrt.setUserId(this.zzadi);
    }
    if (!TextUtils.isEmpty(this.zzadj)) {
      paramzzrt.zzbF(this.zzadj);
    }
    if (this.zzadk) {
      paramzzrt.zzS(true);
    }
    if (!TextUtils.isEmpty(this.zzadl)) {
      paramzzrt.zzbG(this.zzadl);
    }
    if (this.zzadm) {
      paramzzrt.zzT(this.zzadm);
    }
    if (this.zzadn != 0.0D) {
      paramzzrt.setSampleRate(this.zzadn);
    }
  }
  
  public final void zzbE(String paramString)
  {
    this.zzadg = paramString;
  }
  
  public final void zzbF(String paramString)
  {
    this.zzadj = paramString;
  }
  
  public final void zzbG(String paramString)
  {
    this.zzadl = paramString;
  }
  
  public final String zzmy()
  {
    return this.zzadh;
  }
  
  public final String zznu()
  {
    return this.zzadg;
  }
  
  public final String zznv()
  {
    return this.zzadj;
  }
  
  public final boolean zznw()
  {
    return this.zzadk;
  }
  
  public final String zznx()
  {
    return this.zzadl;
  }
  
  public final boolean zzny()
  {
    return this.zzadm;
  }
  
  public final double zznz()
  {
    return this.zzadn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzrt
 * JD-Core Version:    0.7.0.1
 */