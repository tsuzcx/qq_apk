package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class zzbjf$zzb
{
  private zzak.zza zzbHX;
  private final Map<String, zzak.zza> zzbMB = new HashMap();
  
  public zzbjf.zza zzTw()
  {
    return new zzbjf.zza(this.zzbMB, this.zzbHX, null);
  }
  
  public zzb zzb(String paramString, zzak.zza paramzza)
  {
    this.zzbMB.put(paramString, paramzza);
    return this;
  }
  
  public zzb zzo(zzak.zza paramzza)
  {
    this.zzbHX = paramzza;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjf.zzb
 * JD-Core Version:    0.7.0.1
 */