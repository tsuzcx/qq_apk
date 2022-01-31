package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzcz
  extends zzam
{
  private static final String ID = zzah.zzdG.toString();
  
  public zzcz()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    return zzdl.zzR(Integer.valueOf(Build.VERSION.SDK_INT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcz
 * JD-Core Version:    0.7.0.1
 */