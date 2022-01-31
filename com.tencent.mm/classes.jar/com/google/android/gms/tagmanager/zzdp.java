package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzdp
{
  private static zzce<zzak.zza> zza(zzce<zzak.zza> paramzzce)
  {
    try
    {
      zzce localzzce = new zzce(zzdl.zzR(zzhD(zzdl.zze((zzak.zza)paramzzce.getObject()))), paramzzce.zzQY());
      return localzzce;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      zzbo.zzb("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return paramzzce;
  }
  
  private static zzce<zzak.zza> zza(zzce<zzak.zza> paramzzce, int paramInt)
  {
    if (!zzl((zzak.zza)paramzzce.getObject()))
    {
      zzbo.e("Escaping can only be applied to strings.");
      return paramzzce;
    }
    switch (paramInt)
    {
    default: 
      zzbo.e(39 + "Unsupported Value Escaping: " + paramInt);
      return paramzzce;
    }
    return zza(paramzzce);
  }
  
  static zzce<zzak.zza> zza(zzce<zzak.zza> paramzzce, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramzzce = zza(paramzzce, paramVarArgs[i]);
      i += 1;
    }
    return paramzzce;
  }
  
  static String zzhD(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean zzl(zzak.zza paramzza)
  {
    return zzdl.zzj(paramzza) instanceof String;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdp
 * JD-Core Version:    0.7.0.1
 */