package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Locale;
import java.util.Map;

public class zzbj
  extends zzam
{
  private static final String ID = zzah.zzdy.toString();
  
  public zzbj()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return zzdl.zzRQ();
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return zzdl.zzRQ();
    }
    return zzdl.zzR(paramMap.toLowerCase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbj
 * JD-Core Version:    0.7.0.1
 */