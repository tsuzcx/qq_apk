package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.util.HashMap;
import java.util.Map;

public class zzbje
{
  private final Context mContext;
  private String zzbFC = null;
  Map<String, Object> zzbLY = new HashMap();
  private final Map<String, Object> zzbLZ;
  private final zzbjg zzbNk;
  private final zze zzuP;
  
  public zzbje(Context paramContext)
  {
    this(paramContext, new HashMap(), new zzbjg(paramContext), zzi.zzzc());
  }
  
  zzbje(Context paramContext, Map<String, Object> paramMap, zzbjg paramzzbjg, zze paramzze)
  {
    this.mContext = paramContext;
    this.zzuP = paramzze;
    this.zzbNk = paramzzbjg;
    this.zzbLZ = paramMap;
  }
  
  public void zzig(String paramString)
  {
    this.zzbFC = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzbje
 * JD-Core Version:    0.7.0.1
 */