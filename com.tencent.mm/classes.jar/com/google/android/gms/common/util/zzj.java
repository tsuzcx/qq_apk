package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.zzg;

public final class zzj
{
  private static Boolean zzaHZ;
  private static Boolean zzaIa;
  private static Boolean zzaIb;
  private static Boolean zzaIc;
  private static Boolean zzaId;
  
  @TargetApi(20)
  public static boolean zzaZ(Context paramContext)
  {
    if (zzaIb == null) {
      if ((!zzt.zzzm()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      zzaIb = Boolean.valueOf(bool);
      return zzaIb.booleanValue();
    }
  }
  
  public static boolean zzb(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null) {
      return false;
    }
    if (zzaHZ == null) {
      if ((paramResources.getConfiguration().screenLayout & 0xF) <= 3) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (zzc(paramResources))) {
        bool = true;
      }
      zzaHZ = Boolean.valueOf(bool);
      return zzaHZ.booleanValue();
    }
  }
  
  @TargetApi(24)
  public static boolean zzba(Context paramContext)
  {
    return ((!zzt.isAtLeastN()) || (zzbb(paramContext))) && (zzaZ(paramContext));
  }
  
  @TargetApi(21)
  public static boolean zzbb(Context paramContext)
  {
    if (zzaIc == null) {
      if ((!zzt.zzzo()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      zzaIc = Boolean.valueOf(bool);
      return zzaIc.booleanValue();
    }
  }
  
  public static boolean zzbc(Context paramContext)
  {
    if (zzaId == null) {
      zzaId = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
    }
    return zzaId.booleanValue();
  }
  
  private static boolean zzc(Resources paramResources)
  {
    if (zzaIa == null)
    {
      paramResources = paramResources.getConfiguration();
      if (((paramResources.screenLayout & 0xF) > 3) || (paramResources.smallestScreenWidthDp < 600)) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      zzaIa = Boolean.valueOf(bool);
      return zzaIa.booleanValue();
    }
  }
  
  public static boolean zzzd()
  {
    boolean bool = zzg.zzayx;
    return "user".equals(Build.TYPE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.zzj
 * JD-Core Version:    0.7.0.1
 */