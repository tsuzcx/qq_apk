package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzaf
  extends zzam
{
  private static final String ID = zzah.zzdM.toString();
  private static final String zzbGj = zzai.zzfI.toString();
  private static final String zzbGk = zzai.zzio.toString();
  private static final String zzbGl = zzai.zzhH.toString();
  private static final String zzbGm = zzai.zziy.toString();
  
  public zzaf()
  {
    super(ID, new String[] { zzbGj });
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzbGj);
    if ((localObject == null) || (localObject == zzdl.zzRQ())) {
      return zzdl.zzRQ();
    }
    String str2 = zzdl.zze((zzak.zza)localObject);
    localObject = (zzak.zza)paramMap.get(zzbGl);
    String str1;
    label84:
    int i;
    if (localObject == null)
    {
      str1 = "text";
      localObject = (zzak.zza)paramMap.get(zzbGm);
      if (localObject != null) {
        break label165;
      }
      localObject = "base16";
      int j = 2;
      paramMap = (zzak.zza)paramMap.get(zzbGk);
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (zzdl.zzi(paramMap).booleanValue()) {
          i = 3;
        }
      }
    }
    for (;;)
    {
      try
      {
        if ("text".equals(str1))
        {
          paramMap = str2.getBytes();
          if (!"base16".equals(localObject)) {
            break label288;
          }
          paramMap = zzk.zzq(paramMap);
          return zzdl.zzR(paramMap);
          str1 = zzdl.zze((zzak.zza)localObject);
          break;
          label165:
          localObject = zzdl.zze((zzak.zza)localObject);
          break label84;
        }
        if ("base16".equals(str1))
        {
          paramMap = zzk.zzgR(str2);
          continue;
        }
        if ("base64".equals(str1))
        {
          paramMap = Base64.decode(str2, i);
          continue;
        }
        if ("base64url".equals(str1))
        {
          paramMap = Base64.decode(str2, i | 0x8);
          continue;
        }
        paramMap = String.valueOf(str1);
        if (paramMap.length() != 0)
        {
          paramMap = "Encode: unknown input format: ".concat(paramMap);
          zzbo.e(paramMap);
          return zzdl.zzRQ();
        }
        paramMap = new String("Encode: unknown input format: ");
        continue;
        if (!"base64".equals(localObject)) {
          break label307;
        }
      }
      catch (IllegalArgumentException paramMap)
      {
        zzbo.e("Encode: invalid input:");
        return zzdl.zzRQ();
      }
      label288:
      paramMap = Base64.encodeToString(paramMap, i);
      continue;
      label307:
      if (!"base64url".equals(localObject)) {
        break label329;
      }
      paramMap = Base64.encodeToString(paramMap, i | 0x8);
    }
    label329:
    paramMap = String.valueOf(localObject);
    if (paramMap.length() != 0) {}
    for (paramMap = "Encode: unknown output format: ".concat(paramMap);; paramMap = new String("Encode: unknown output format: "))
    {
      zzbo.e(paramMap);
      return zzdl.zzRQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzaf
 * JD-Core Version:    0.7.0.1
 */