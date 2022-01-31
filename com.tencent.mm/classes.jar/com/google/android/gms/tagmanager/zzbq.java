package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzbq
  extends zzam
{
  private static final String ID = zzah.zzdU.toString();
  private static final String zzbGj = zzai.zzfI.toString();
  
  public zzbq()
  {
    super(ID, new String[] { zzbGj });
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    return zzdl.zzR(zzdl.zze((zzak.zza)paramMap.get(zzbGj)).toLowerCase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbq
 * JD-Core Version:    0.7.0.1
 */