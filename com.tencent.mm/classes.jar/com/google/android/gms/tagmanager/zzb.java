package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzb
  extends zzam
{
  private static final String ID = zzah.zzdd.toString();
  private final zza zzbEP;
  
  public zzb(Context paramContext)
  {
    this(zza.zzbS(paramContext));
  }
  
  zzb(zza paramzza)
  {
    super(ID, new String[0]);
    this.zzbEP = paramzza;
    this.zzbEP.zzPU();
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    paramMap = this.zzbEP.zzPU();
    if (paramMap == null) {
      return zzdl.zzRQ();
    }
    return zzdl.zzR(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzb
 * JD-Core Version:    0.7.0.1
 */