package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzck
  extends zzam
{
  private static final String ID = zzah.zzdC.toString();
  private static final String zzbHp = zzai.zzif.toString();
  private static final String zzbHq = zzai.zzid.toString();
  
  public zzck()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzbHp);
    paramMap = (zzak.zza)paramMap.get(zzbHq);
    double d2;
    double d1;
    if ((localObject != null) && (localObject != zzdl.zzRQ()) && (paramMap != null) && (paramMap != zzdl.zzRQ()))
    {
      localObject = zzdl.zzf((zzak.zza)localObject);
      paramMap = zzdl.zzf(paramMap);
      if ((localObject != zzdl.zzRO()) && (paramMap != zzdl.zzRO()))
      {
        d2 = ((zzdk)localObject).doubleValue();
        d1 = paramMap.doubleValue();
        if (d2 > d1) {}
      }
    }
    for (;;)
    {
      return zzdl.zzR(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
      d1 = 2147483647.0D;
      d2 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzck
 * JD-Core Version:    0.7.0.1
 */