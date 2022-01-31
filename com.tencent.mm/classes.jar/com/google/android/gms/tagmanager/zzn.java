package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzn
  extends zzam
{
  private static final String ID = zzah.zzdj.toString();
  private static final String VALUE = zzai.zzke.toString();
  
  public zzn()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String zzQc()
  {
    return ID;
  }
  
  public static String zzQd()
  {
    return VALUE;
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    return (zzak.zza)paramMap.get(VALUE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzn
 * JD-Core Version:    0.7.0.1
 */