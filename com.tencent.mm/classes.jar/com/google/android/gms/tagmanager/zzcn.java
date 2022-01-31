package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcn
  extends zzdg
{
  private static final String ID = zzah.zzem.toString();
  private static final String zzbHt = zzai.zzhF.toString();
  
  public zzcn()
  {
    super(ID);
  }
  
  protected boolean zza(String paramString1, String paramString2, Map<String, zzak.zza> paramMap)
  {
    if (zzdl.zzi((zzak.zza)paramMap.get(zzbHt)).booleanValue()) {}
    for (int i = 66;; i = 64) {
      try
      {
        boolean bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
        return bool;
      }
      catch (PatternSyntaxException paramString1)
      {
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcn
 * JD-Core Version:    0.7.0.1
 */