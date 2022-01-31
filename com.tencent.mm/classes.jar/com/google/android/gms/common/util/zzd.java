package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.internal.zzadf;
import com.google.android.gms.internal.zzadg;

public class zzd
{
  public static int zzC(Context paramContext, String paramString)
  {
    return zzc(zzD(paramContext, paramString));
  }
  
  public static PackageInfo zzD(Context paramContext, String paramString)
  {
    try
    {
      paramContext = zzadg.zzbi(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static boolean zzE(Context paramContext, String paramString)
  {
    boolean bool = false;
    "com.google.android.gms".equals(paramString);
    try
    {
      int i = zzadg.zzbi(paramContext).getApplicationInfo(paramString, 0).flags;
      if ((i & 0x200000) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static int zzc(PackageInfo paramPackageInfo)
  {
    if ((paramPackageInfo == null) || (paramPackageInfo.applicationInfo == null)) {}
    do
    {
      return -1;
      paramPackageInfo = paramPackageInfo.applicationInfo.metaData;
    } while (paramPackageInfo == null);
    return paramPackageInfo.getInt("com.google.android.gms.version", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.util.zzd
 * JD-Core Version:    0.7.0.1
 */