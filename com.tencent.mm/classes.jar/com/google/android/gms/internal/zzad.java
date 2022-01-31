package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class zzad
{
  public static zzm zza(Context paramContext)
  {
    return zza(paramContext, null);
  }
  
  public static zzm zza(Context paramContext, zzz paramzzz)
  {
    File localFile = new File(paramContext.getCacheDir(), "volley");
    Object localObject = "volley/0";
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      paramContext = str + "/" + paramContext.versionCode;
      localObject = paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label64:
      label118:
      break label64;
    }
    paramContext = paramzzz;
    if (paramzzz == null) {
      if (Build.VERSION.SDK_INT < 9) {
        break label118;
      }
    }
    for (paramContext = new zzaa();; paramContext = new zzx(AndroidHttpClient.newInstance((String)localObject)))
    {
      paramContext = new zzu(paramContext);
      paramContext = new zzm(new zzw(localFile), paramContext);
      paramContext.start();
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzad
 * JD-Core Version:    0.7.0.1
 */