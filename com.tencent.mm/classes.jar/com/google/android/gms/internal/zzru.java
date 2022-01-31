package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzru
  extends zzf<zzru>
{
  private String zzado;
  private int zzadp;
  private int zzadq;
  private String zzadr;
  private String zzads;
  private boolean zzadt;
  private boolean zzadu;
  
  public zzru()
  {
    this(false);
  }
  
  public zzru(boolean paramBoolean)
  {
    this(paramBoolean, zznA());
  }
  
  public zzru(boolean paramBoolean, int paramInt)
  {
    zzac.zzcX(paramInt);
    this.zzadp = paramInt;
    this.zzadu = paramBoolean;
  }
  
  static int zznA()
  {
    UUID localUUID = UUID.randomUUID();
    int i = (int)(localUUID.getLeastSignificantBits() & 0x7FFFFFFF);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = (int)(localUUID.getMostSignificantBits() & 0x7FFFFFFF);
      i = j;
    } while (j != 0);
    return 2147483647;
  }
  
  public final void setScreenName(String paramString)
  {
    this.zzado = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("screenName", this.zzado);
    localHashMap.put("interstitial", Boolean.valueOf(this.zzadt));
    localHashMap.put("automatic", Boolean.valueOf(this.zzadu));
    localHashMap.put("screenId", Integer.valueOf(this.zzadp));
    localHashMap.put("referrerScreenId", Integer.valueOf(this.zzadq));
    localHashMap.put("referrerScreenName", this.zzadr);
    localHashMap.put("referrerUri", this.zzads);
    return zzj(localHashMap);
  }
  
  public final void zzU(boolean paramBoolean)
  {
    this.zzadu = paramBoolean;
  }
  
  public final void zzV(boolean paramBoolean)
  {
    this.zzadt = paramBoolean;
  }
  
  public final void zza(zzru paramzzru)
  {
    if (!TextUtils.isEmpty(this.zzado)) {
      paramzzru.setScreenName(this.zzado);
    }
    if (this.zzadp != 0) {
      paramzzru.zzaF(this.zzadp);
    }
    if (this.zzadq != 0) {
      paramzzru.zzaG(this.zzadq);
    }
    if (!TextUtils.isEmpty(this.zzadr)) {
      paramzzru.zzbH(this.zzadr);
    }
    if (!TextUtils.isEmpty(this.zzads)) {
      paramzzru.zzbI(this.zzads);
    }
    if (this.zzadt) {
      paramzzru.zzV(this.zzadt);
    }
    if (this.zzadu) {
      paramzzru.zzU(this.zzadu);
    }
  }
  
  public final void zzaF(int paramInt)
  {
    this.zzadp = paramInt;
  }
  
  public final void zzaG(int paramInt)
  {
    this.zzadq = paramInt;
  }
  
  public final void zzbH(String paramString)
  {
    this.zzadr = paramString;
  }
  
  public final void zzbI(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.zzads = null;
      return;
    }
    this.zzads = paramString;
  }
  
  public final String zznB()
  {
    return this.zzado;
  }
  
  public final int zznC()
  {
    return this.zzadp;
  }
  
  public final String zznD()
  {
    return this.zzads;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzru
 * JD-Core Version:    0.7.0.1
 */