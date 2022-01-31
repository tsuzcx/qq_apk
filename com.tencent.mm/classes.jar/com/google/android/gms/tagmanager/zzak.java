package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzak
  extends zzam
{
  private static final String ID = zzah.zzdu.toString();
  private final zzcx zzbFa;
  
  public zzak(zzcx paramzzcx)
  {
    super(ID, new String[0]);
    this.zzbFa = paramzzcx;
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    paramMap = this.zzbFa.zzRn();
    if (paramMap == null) {
      return zzdl.zzRQ();
    }
    return zzdl.zzR(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzak
 * JD-Core Version:    0.7.0.1
 */