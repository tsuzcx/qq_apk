package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzac
  extends zzam
{
  private static final String ID = zzah.zzdo.toString();
  
  public zzac()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    paramMap = str1;
    if (!str1.startsWith(str2))
    {
      paramMap = str1;
      if (!str2.equals("unknown")) {
        paramMap = String.valueOf(str2).length() + 1 + String.valueOf(str1).length() + str2 + " " + str1;
      }
    }
    return zzdl.zzR(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzac
 * JD-Core Version:    0.7.0.1
 */