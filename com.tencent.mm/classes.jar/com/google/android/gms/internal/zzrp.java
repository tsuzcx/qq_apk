package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrp
  extends zzf<zzrp>
{
  public int zzMy;
  public int zzMz;
  private String zzacX;
  public int zzacY;
  public int zzacZ;
  public int zzada;
  
  public final String getLanguage()
  {
    return this.zzacX;
  }
  
  public final void setLanguage(String paramString)
  {
    this.zzacX = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("language", this.zzacX);
    localHashMap.put("screenColors", Integer.valueOf(this.zzacY));
    localHashMap.put("screenWidth", Integer.valueOf(this.zzMy));
    localHashMap.put("screenHeight", Integer.valueOf(this.zzMz));
    localHashMap.put("viewportWidth", Integer.valueOf(this.zzacZ));
    localHashMap.put("viewportHeight", Integer.valueOf(this.zzada));
    return zzj(localHashMap);
  }
  
  public final void zza(zzrp paramzzrp)
  {
    if (this.zzacY != 0) {
      paramzzrp.zzaA(this.zzacY);
    }
    if (this.zzMy != 0) {
      paramzzrp.zzaB(this.zzMy);
    }
    if (this.zzMz != 0) {
      paramzzrp.zzaC(this.zzMz);
    }
    if (this.zzacZ != 0) {
      paramzzrp.zzaD(this.zzacZ);
    }
    if (this.zzada != 0) {
      paramzzrp.zzaE(this.zzada);
    }
    if (!TextUtils.isEmpty(this.zzacX)) {
      paramzzrp.setLanguage(this.zzacX);
    }
  }
  
  public final void zzaA(int paramInt)
  {
    this.zzacY = paramInt;
  }
  
  public final void zzaB(int paramInt)
  {
    this.zzMy = paramInt;
  }
  
  public final void zzaC(int paramInt)
  {
    this.zzMz = paramInt;
  }
  
  public final void zzaD(int paramInt)
  {
    this.zzacZ = paramInt;
  }
  
  public final void zzaE(int paramInt)
  {
    this.zzada = paramInt;
  }
  
  public final int zznk()
  {
    return this.zzacY;
  }
  
  public final int zznl()
  {
    return this.zzMy;
  }
  
  public final int zznm()
  {
    return this.zzMz;
  }
  
  public final int zznn()
  {
    return this.zzacZ;
  }
  
  public final int zzno()
  {
    return this.zzada;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzrp
 * JD-Core Version:    0.7.0.1
 */