package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzh;
import com.google.android.gms.internal.zzadf;
import com.google.android.gms.internal.zzadg;

public final class zzy
{
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzadg.zzbi(paramContext).zzg(paramInt, paramString);
  }
  
  public static boolean zzf(Context paramContext, int paramInt)
  {
    if (!zzc(paramContext, paramInt, "com.google.android.gms")) {
      return false;
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
      return zzh.zzaN(paramContext).zza(paramContext.getPackageManager(), (PackageInfo)localObject);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.isLoggable("UidVerifier", 3);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.util.zzy
 * JD-Core Version:    0.7.0.1
 */