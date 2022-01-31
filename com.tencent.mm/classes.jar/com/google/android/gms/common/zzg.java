package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzg
{
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 10298000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  private static boolean zzayA = false;
  static final AtomicBoolean zzayB = new AtomicBoolean();
  private static final AtomicBoolean zzayC = new AtomicBoolean();
  public static boolean zzayx = false;
  public static boolean zzayy = false;
  static boolean zzayz = false;
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zze.zzuY().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  /* Error */
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 74	android/net/Uri$Builder
    //   3: dup
    //   4: invokespecial 75	android/net/Uri$Builder:<init>	()V
    //   7: ldc 77
    //   9: invokevirtual 81	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   12: ldc 8
    //   14: invokevirtual 84	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   17: ldc 86
    //   19: invokevirtual 89	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   22: ldc 91
    //   24: invokevirtual 89	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   27: invokevirtual 95	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_1
    //   36: invokevirtual 107	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   39: astore_2
    //   40: new 109	java/util/Scanner
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 112	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   48: ldc 114
    //   50: invokevirtual 118	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   53: invokevirtual 122	java/util/Scanner:next	()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: astore_1
    //   59: aload_2
    //   60: ifnull +35 -> 95
    //   63: aload_2
    //   64: invokevirtual 127	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: areturn
    //   69: astore_0
    //   70: aload_2
    //   71: ifnull +26 -> 97
    //   74: aload_2
    //   75: invokevirtual 127	java/io/InputStream:close	()V
    //   78: goto +19 -> 97
    //   81: astore_0
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 127	java/io/InputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: areturn
    //   97: aconst_null
    //   98: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   30	66	1	localObject	Object
    //   39	48	2	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   40	57	69	java/util/NoSuchElementException
    //   40	57	81	finally
    //   31	40	92	java/lang/Exception
    //   63	67	92	java/lang/Exception
    //   74	78	92	java/lang/Exception
    //   86	90	92	java/lang/Exception
    //   90	92	92	java/lang/Exception
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      label17:
      if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
        zzaH(paramContext);
      }
      int i;
      if ((!zzj.zzba(paramContext)) && (!zzj.zzbc(paramContext)))
      {
        i = 1;
        localObject = null;
        if (i == 0) {}
      }
      label110:
      do
      {
        try
        {
          localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
          try
          {
            localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
            paramContext = zzh.zzaN(paramContext);
            if (i == 0) {
              break label186;
            }
            localObject = paramContext.zza((PackageInfo)localObject, zzf.zzd.zzayw);
            if (localObject != null) {
              break label110;
            }
            return 9;
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            return 1;
          }
          i = 0;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          PackageInfo localPackageInfo;
          return 9;
        }
      } while (paramContext.zza(localPackageInfo, new zzf.zza[] { localObject }) == null);
      label186:
      do
      {
        i = zzm.zzdp(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (zzm.zzdp(localPackageInfo.versionCode) >= i) {
          break;
        }
        i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        int j = localPackageInfo.versionCode;
        new StringBuilder(77).append("Google Play services out of date.  Requires ").append(i).append(" but found ").append(j);
        return 2;
      } while (paramContext.zza(localPackageInfo, zzf.zzd.zzayw) != null);
      return 9;
      Object localObject = localPackageInfo.applicationInfo;
      paramContext = (Context)localObject;
      if (localObject == null) {}
      try
      {
        paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
        if (!paramContext.enabled) {
          return 3;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
        return 1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      break label17;
    }
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  @Deprecated
  public static int zzaC(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return paramContext.versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 0;
  }
  
  @Deprecated
  public static void zzaF(Context paramContext)
  {
    if (zzayB.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext != null)
        {
          paramContext.cancel(10436);
          return;
        }
      }
      catch (SecurityException paramContext) {}
    }
  }
  
  private static void zzaH(Context paramContext)
  {
    if (zzayC.get()) {}
    int i;
    do
    {
      return;
      i = zzz.zzaW(paramContext);
      if (i == 0) {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
    } while (i == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    int j = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    paramContext = String.valueOf("com.google.android.gms.version");
    throw new IllegalStateException(String.valueOf(paramContext).length() + 290 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + j + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"" + paramContext + "\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  public static boolean zzaI(Context paramContext)
  {
    zzaL(paramContext);
    return zzayz;
  }
  
  public static boolean zzaJ(Context paramContext)
  {
    return (zzaI(paramContext)) || (!zzvd());
  }
  
  @TargetApi(18)
  public static boolean zzaK(Context paramContext)
  {
    if (zzt.zzzk())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  private static void zzaL(Context paramContext)
  {
    if (!zzayA) {
      zzaM(paramContext);
    }
  }
  
  /* Error */
  private static void zzaM(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 361	com/google/android/gms/internal/zzadg:zzbi	(Landroid/content/Context;)Lcom/google/android/gms/internal/zzadf;
    //   4: ldc 8
    //   6: bipush 64
    //   8: invokevirtual 364	com/google/android/gms/internal/zzadf:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +35 -> 48
    //   16: aload_0
    //   17: invokestatic 197	com/google/android/gms/common/zzh:zzaN	(Landroid/content/Context;)Lcom/google/android/gms/common/zzh;
    //   20: aload_1
    //   21: iconst_1
    //   22: anewarray 209	com/google/android/gms/common/zzf$zza
    //   25: dup
    //   26: iconst_0
    //   27: getstatic 203	com/google/android/gms/common/zzf$zzd:zzayw	[Lcom/google/android/gms/common/zzf$zza;
    //   30: iconst_1
    //   31: aaload
    //   32: aastore
    //   33: invokevirtual 207	com/google/android/gms/common/zzh:zza	(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzf$zza;)Lcom/google/android/gms/common/zzf$zza;
    //   36: ifnull +12 -> 48
    //   39: iconst_1
    //   40: putstatic 33	com/google/android/gms/common/zzg:zzayz	Z
    //   43: iconst_1
    //   44: putstatic 35	com/google/android/gms/common/zzg:zzayA	Z
    //   47: return
    //   48: iconst_0
    //   49: putstatic 33	com/google/android/gms/common/zzg:zzayz	Z
    //   52: goto -9 -> 43
    //   55: astore_0
    //   56: iconst_1
    //   57: putstatic 35	com/google/android/gms/common/zzg:zzayA	Z
    //   60: return
    //   61: astore_0
    //   62: iconst_1
    //   63: putstatic 35	com/google/android/gms/common/zzg:zzayA	Z
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   11	10	1	localPackageInfo	PackageInfo
    // Exception table:
    //   from	to	target	type
    //   0	12	55	android/content/pm/PackageManager$NameNotFoundException
    //   16	43	55	android/content/pm/PackageManager$NameNotFoundException
    //   48	52	55	android/content/pm/PackageManager$NameNotFoundException
    //   0	12	61	finally
    //   16	43	61	finally
    //   48	52	61	finally
  }
  
  @Deprecated
  public static void zzaq(Context paramContext)
  {
    int i = zze.zzuY().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = zze.zzuY().zzb(paramContext, i, "e");
      new StringBuilder(57).append("GooglePlayServices not available due to error ").append(i);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzy.zzc(paramContext, paramInt, paramString);
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return zzz(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  @Deprecated
  public static boolean zze(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return zzz(paramContext, "com.android.vending");
    }
    return false;
  }
  
  @Deprecated
  public static boolean zzf(Context paramContext, int paramInt)
  {
    return zzy.zzf(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean zzvd()
  {
    return zzj.zzzd();
  }
  
  @TargetApi(21)
  static boolean zzz(Context paramContext, String paramString)
  {
    boolean bool = paramString.equals("com.google.android.gms");
    if (zzt.zzzo())
    {
      localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName())) {
          return true;
        }
      }
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
      if (bool) {
        return paramString.enabled;
      }
      if (paramString.enabled)
      {
        bool = zzaK(paramContext);
        if (!bool) {
          return true;
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.zzg
 * JD-Core Version:    0.7.0.1
 */