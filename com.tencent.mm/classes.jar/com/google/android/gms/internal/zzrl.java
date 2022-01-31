package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrl
  extends zzf<zzrl>
{
  private String mName;
  private String zzFV;
  private String zzGV;
  private String zzacO;
  private String zzacP;
  private String zzacQ;
  private String zzacR;
  private String zzacS;
  private String zzacT;
  private String zzacU;
  
  public final String getContent()
  {
    return this.zzFV;
  }
  
  public final String getId()
  {
    return this.zzGV;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final String getSource()
  {
    return this.zzacO;
  }
  
  public final void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", this.mName);
    localHashMap.put("source", this.zzacO);
    localHashMap.put("medium", this.zzacP);
    localHashMap.put("keyword", this.zzacQ);
    localHashMap.put("content", this.zzFV);
    localHashMap.put("id", this.zzGV);
    localHashMap.put("adNetworkId", this.zzacR);
    localHashMap.put("gclid", this.zzacS);
    localHashMap.put("dclid", this.zzacT);
    localHashMap.put("aclid", this.zzacU);
    return zzj(localHashMap);
  }
  
  public final void zza(zzrl paramzzrl)
  {
    if (!TextUtils.isEmpty(this.mName)) {
      paramzzrl.setName(this.mName);
    }
    if (!TextUtils.isEmpty(this.zzacO)) {
      paramzzrl.zzbr(this.zzacO);
    }
    if (!TextUtils.isEmpty(this.zzacP)) {
      paramzzrl.zzbs(this.zzacP);
    }
    if (!TextUtils.isEmpty(this.zzacQ)) {
      paramzzrl.zzbt(this.zzacQ);
    }
    if (!TextUtils.isEmpty(this.zzFV)) {
      paramzzrl.zzbu(this.zzFV);
    }
    if (!TextUtils.isEmpty(this.zzGV)) {
      paramzzrl.zzbv(this.zzGV);
    }
    if (!TextUtils.isEmpty(this.zzacR)) {
      paramzzrl.zzbw(this.zzacR);
    }
    if (!TextUtils.isEmpty(this.zzacS)) {
      paramzzrl.zzbx(this.zzacS);
    }
    if (!TextUtils.isEmpty(this.zzacT)) {
      paramzzrl.zzby(this.zzacT);
    }
    if (!TextUtils.isEmpty(this.zzacU)) {
      paramzzrl.zzbz(this.zzacU);
    }
  }
  
  public final void zzbr(String paramString)
  {
    this.zzacO = paramString;
  }
  
  public final void zzbs(String paramString)
  {
    this.zzacP = paramString;
  }
  
  public final void zzbt(String paramString)
  {
    this.zzacQ = paramString;
  }
  
  public final void zzbu(String paramString)
  {
    this.zzFV = paramString;
  }
  
  public final void zzbv(String paramString)
  {
    this.zzGV = paramString;
  }
  
  public final void zzbw(String paramString)
  {
    this.zzacR = paramString;
  }
  
  public final void zzbx(String paramString)
  {
    this.zzacS = paramString;
  }
  
  public final void zzby(String paramString)
  {
    this.zzacT = paramString;
  }
  
  public final void zzbz(String paramString)
  {
    this.zzacU = paramString;
  }
  
  public final String zznb()
  {
    return this.zzacP;
  }
  
  public final String zznc()
  {
    return this.zzacQ;
  }
  
  public final String zznd()
  {
    return this.zzacR;
  }
  
  public final String zzne()
  {
    return this.zzacS;
  }
  
  public final String zznf()
  {
    return this.zzacT;
  }
  
  public final String zzng()
  {
    return this.zzacU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzrl
 * JD-Core Version:    0.7.0.1
 */