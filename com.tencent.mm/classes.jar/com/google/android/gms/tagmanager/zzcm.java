package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcm
  extends zzam
{
  private static final String ID = zzah.zzdS.toString();
  private static final String zzbHr = zzai.zzfI.toString();
  private static final String zzbHs = zzai.zzfJ.toString();
  private static final String zzbHt = zzai.zzhF.toString();
  private static final String zzbHu = zzai.zzhy.toString();
  
  public zzcm()
  {
    super(ID, new String[] { zzbHr, zzbHs });
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzbHr);
    zzak.zza localzza = (zzak.zza)paramMap.get(zzbHs);
    if ((localObject == null) || (localObject == zzdl.zzRQ()) || (localzza == null) || (localzza == zzdl.zzRQ())) {
      return zzdl.zzRQ();
    }
    int i = 64;
    if (zzdl.zzi((zzak.zza)paramMap.get(zzbHt)).booleanValue()) {
      i = 66;
    }
    paramMap = (zzak.zza)paramMap.get(zzbHu);
    int j;
    if (paramMap != null)
    {
      paramMap = zzdl.zzg(paramMap);
      if (paramMap == zzdl.zzRL()) {
        return zzdl.zzRQ();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return zzdl.zzRQ();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = zzdl.zze((zzak.zza)localObject);
      localObject = zzdl.zze(localzza);
      localzza = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      paramMap = localzza;
      if (((Matcher)localObject).find())
      {
        paramMap = localzza;
        if (((Matcher)localObject).groupCount() >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return zzdl.zzRQ();
      }
      paramMap = zzdl.zzR(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return zzdl.zzRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcm
 * JD-Core Version:    0.7.0.1
 */