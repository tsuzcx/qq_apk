package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzc
  extends zzam
{
  private static final String ID = zzah.zzde.toString();
  private final zza zzbEP;
  
  public zzc(Context paramContext)
  {
    this(zza.zzbS(paramContext));
  }
  
  zzc(zza paramzza)
  {
    super(ID, new String[0]);
    this.zzbEP = paramzza;
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    if (!this.zzbEP.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return zzdl.zzR(Boolean.valueOf(bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzc
 * JD-Core Version:    0.7.0.1
 */