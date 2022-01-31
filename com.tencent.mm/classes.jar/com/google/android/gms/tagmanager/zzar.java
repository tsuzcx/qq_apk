package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzar
  extends zzam
{
  private static final String ID = zzah.zzdO.toString();
  private static final String zzbGj = zzai.zzfI.toString();
  private static final String zzbGl = zzai.zzhH.toString();
  private static final String zzbGp = zzai.zzfy.toString();
  
  public zzar()
  {
    super(ID, new String[] { zzbGj });
  }
  
  private byte[] zzf(String paramString, byte[] paramArrayOfByte)
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
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
    String str = zzdl.zze((zzak.zza)localObject);
    localObject = (zzak.zza)paramMap.get(zzbGp);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (zzak.zza)paramMap.get(zzbGl);
      if (paramMap != null) {
        break label110;
      }
      paramMap = "text";
      label73:
      if (!"text".equals(paramMap)) {
        break label118;
      }
      paramMap = str.getBytes();
    }
    for (;;)
    {
      try
      {
        paramMap = zzdl.zzR(zzk.zzq(zzf((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        paramMap = String.valueOf(localObject);
        if (paramMap.length() == 0) {
          break label203;
        }
      }
      localObject = zzdl.zze((zzak.zza)localObject);
      break;
      paramMap = zzdl.zze(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = zzk.zzgR(str);
      }
      else
      {
        paramMap = String.valueOf(paramMap);
        if (paramMap.length() != 0) {}
        for (paramMap = "Hash: unknown input format: ".concat(paramMap);; paramMap = new String("Hash: unknown input format: "))
        {
          zzbo.e(paramMap);
          return zzdl.zzRQ();
        }
      }
    }
    label203:
    for (paramMap = "Hash: unknown algorithm: ".concat(paramMap);; paramMap = new String("Hash: unknown algorithm: "))
    {
      zzbo.e(paramMap);
      return zzdl.zzRQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzar
 * JD-Core Version:    0.7.0.1
 */