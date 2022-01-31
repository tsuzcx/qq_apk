package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.GmsVersionParser;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight
{
  public static final String FEATURE_SIDEWINDER = "cn.google";
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final String GOOGLE_PLAY_STORE_GAMES_URI_STRING = "http://play.google.com/store/apps/category/GAME";
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static final String GOOGLE_PLAY_STORE_URI_STRING = "http://play.google.com/store/apps/";
  public static final boolean HONOR_DEBUG_CERTIFICATES = false;
  public static final String KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION = "com.google.android.gms.version";
  public static final int MAX_ATTEMPTS_NO_SUCH_ALGORITHM = 2;
  @VisibleForTesting
  public static boolean sIsTestMode;
  @VisibleForTesting
  public static boolean sTestIsUserBuild;
  private static boolean zzbr;
  @VisibleForTesting
  private static boolean zzbs;
  @VisibleForTesting
  static final AtomicBoolean zzbt;
  private static final AtomicBoolean zzbu;
  
  static
  {
    AppMethodBeat.i(89418);
    GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    sIsTestMode = false;
    sTestIsUserBuild = false;
    zzbr = false;
    zzbs = false;
    zzbt = new AtomicBoolean();
    zzbu = new AtomicBoolean();
    AppMethodBeat.o(89418);
  }
  
  @Deprecated
  public static void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    AppMethodBeat.i(89407);
    if (zzbt.getAndSet(true))
    {
      AppMethodBeat.o(89407);
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null) {
        paramContext.cancel(10436);
      }
      AppMethodBeat.o(89407);
      return;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o(89407);
    }
  }
  
  public static void enableUsingApkIndependentContext()
  {
    AppMethodBeat.i(89393);
    zzbu.set(true);
    AppMethodBeat.o(89393);
  }
  
  @Deprecated
  public static void ensurePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(89398);
    ensurePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    AppMethodBeat.o(89398);
  }
  
  @Deprecated
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89399);
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0)
    {
      paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      new StringBuilder(57).append("GooglePlayServices not available due to error ").append(paramInt);
      if (paramContext == null)
      {
        paramContext = new GooglePlayServicesNotAvailableException(paramInt);
        AppMethodBeat.o(89399);
        throw paramContext;
      }
      paramContext = new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", paramContext);
      AppMethodBeat.o(89399);
      throw paramContext;
    }
    AppMethodBeat.o(89399);
  }
  
  @Deprecated
  public static int getApkVersion(Context paramContext)
  {
    AppMethodBeat.i(89412);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      int i = paramContext.versionCode;
      AppMethodBeat.o(89412);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(89412);
    }
    return 0;
  }
  
  @Deprecated
  public static int getClientVersion(Context paramContext)
  {
    AppMethodBeat.i(89411);
    Preconditions.checkState(true);
    int i = ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
    AppMethodBeat.o(89411);
    return i;
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    AppMethodBeat.i(89406);
    paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
    AppMethodBeat.o(89406);
    return paramContext;
  }
  
  @Deprecated
  @VisibleForTesting
  public static String getErrorString(int paramInt)
  {
    AppMethodBeat.i(89394);
    String str = ConnectionResult.zza(paramInt);
    AppMethodBeat.o(89394);
    return str;
  }
  
  @Deprecated
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    AppMethodBeat.i(89402);
    Intent localIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
    AppMethodBeat.o(89402);
    return localIntent;
  }
  
  /* Error */
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: ldc 212
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 214	android/net/Uri$Builder
    //   8: dup
    //   9: invokespecial 215	android/net/Uri$Builder:<init>	()V
    //   12: ldc 217
    //   14: invokevirtual 221	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   17: ldc 14
    //   19: invokevirtual 224	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   22: ldc 226
    //   24: invokevirtual 229	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   27: ldc 231
    //   29: invokevirtual 229	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   32: invokevirtual 235	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 239	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: aload_1
    //   41: invokevirtual 245	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   44: astore_0
    //   45: new 247	java/util/Scanner
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 250	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   53: ldc 252
    //   55: invokevirtual 256	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   58: invokevirtual 259	java/util/Scanner:next	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 264	java/io/InputStream:close	()V
    //   70: ldc 212
    //   72: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 264	java/io/InputStream:close	()V
    //   86: ldc 212
    //   88: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 264	java/io/InputStream:close	()V
    //   102: ldc 212
    //   104: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_0
    //   110: ldc 212
    //   112: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aconst_null
    //   116: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   35	41	1	localObject1	Object
    //   77	1	1	localNoSuchElementException	java.util.NoSuchElementException
    //   93	15	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	62	77	java/util/NoSuchElementException
    //   45	62	93	finally
    //   36	45	109	java/lang/Exception
    //   66	70	109	java/lang/Exception
    //   82	86	109	java/lang/Exception
    //   98	102	109	java/lang/Exception
    //   102	109	109	java/lang/Exception
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    AppMethodBeat.i(89410);
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      AppMethodBeat.o(89410);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(89410);
    }
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    AppMethodBeat.i(89409);
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      AppMethodBeat.o(89409);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(89409);
    }
    return null;
  }
  
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    AppMethodBeat.i(89405);
    if ((isTestKeysBuild(paramContext)) || (!isUserBuildDevice()))
    {
      AppMethodBeat.o(89405);
      return true;
    }
    AppMethodBeat.o(89405);
    return false;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(89395);
    int i = isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    AppMethodBeat.o(89395);
    return i;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89396);
    try
    {
      paramContext.getResources().getString(2131296294);
      label17:
      if ((!"com.google.android.gms".equals(paramContext.getPackageName())) && (!zzbu.get()))
      {
        int i = MetadataValueReader.getGooglePlayServicesVersion(paramContext);
        if (i == 0)
        {
          paramContext = new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
          AppMethodBeat.o(89396);
          throw paramContext;
        }
        if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
          paramInt = GOOGLE_PLAY_SERVICES_VERSION_CODE;
          paramContext = new IllegalStateException(320 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + paramInt + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
          AppMethodBeat.o(89396);
          throw paramContext;
        }
      }
      if ((!DeviceProperties.isWearableWithoutPlayStore(paramContext)) && (!DeviceProperties.isIoT(paramContext))) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt = zza(paramContext, bool, paramInt);
        AppMethodBeat.o(89396);
        return paramInt;
      }
    }
    catch (Throwable localThrowable)
    {
      break label17;
    }
  }
  
  @Deprecated
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89400);
    boolean bool = UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
    AppMethodBeat.o(89400);
    return bool;
  }
  
  @Deprecated
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89414);
    if (paramInt == 18)
    {
      AppMethodBeat.o(89414);
      return true;
    }
    if (paramInt == 1)
    {
      boolean bool = isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms");
      AppMethodBeat.o(89414);
      return bool;
    }
    AppMethodBeat.o(89414);
    return false;
  }
  
  @Deprecated
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89415);
    if (paramInt == 9)
    {
      boolean bool = isUninstalledAppPossiblyUpdating(paramContext, "com.android.vending");
      AppMethodBeat.o(89415);
      return bool;
    }
    AppMethodBeat.o(89415);
    return false;
  }
  
  @TargetApi(18)
  public static boolean isRestrictedUserProfile(Context paramContext)
  {
    AppMethodBeat.i(89417);
    if (PlatformVersion.isAtLeastJellyBeanMR2())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile"))))
      {
        AppMethodBeat.o(89417);
        return true;
      }
    }
    AppMethodBeat.o(89417);
    return false;
  }
  
  @Deprecated
  @VisibleForTesting
  public static boolean isSidewinderDevice(Context paramContext)
  {
    AppMethodBeat.i(89413);
    boolean bool = DeviceProperties.isSidewinder(paramContext);
    AppMethodBeat.o(89413);
    return bool;
  }
  
  public static boolean isTestKeysBuild(Context paramContext)
  {
    AppMethodBeat.i(89404);
    if (!zzbs) {}
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.google.android.gms", 64);
        paramContext = GoogleSignatureVerifier.getInstance(paramContext);
        if ((localPackageInfo == null) || (paramContext.isGooglePublicSignedPackage(localPackageInfo, false)) || (!paramContext.isGooglePublicSignedPackage(localPackageInfo, true))) {
          continue;
        }
        zzbr = true;
        zzbs = true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        boolean bool;
        zzbs = true;
        continue;
      }
      finally
      {
        zzbs = true;
        AppMethodBeat.o(89404);
      }
      bool = zzbr;
      AppMethodBeat.o(89404);
      return bool;
      zzbr = false;
    }
  }
  
  @TargetApi(21)
  static boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89416);
    boolean bool = paramString.equals("com.google.android.gms");
    if (PlatformVersion.isAtLeastLollipop()) {
      try
      {
        localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName()))
          {
            AppMethodBeat.o(89416);
            return true;
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(89416);
        return false;
      }
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
      if (bool)
      {
        bool = paramString.enabled;
        AppMethodBeat.o(89416);
        return bool;
      }
      if ((paramString.enabled) && (!isRestrictedUserProfile(paramContext)))
      {
        AppMethodBeat.o(89416);
        return true;
      }
      AppMethodBeat.o(89416);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(89416);
    }
    return false;
  }
  
  @Deprecated
  public static boolean isUserBuildDevice()
  {
    AppMethodBeat.i(89403);
    boolean bool = DeviceProperties.isUserBuild();
    AppMethodBeat.o(89403);
    return bool;
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
  @TargetApi(19)
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(89401);
    boolean bool = UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
    AppMethodBeat.o(89401);
    return bool;
  }
  
  @VisibleForTesting
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89397);
    if (paramInt >= 0) {}
    PackageManager localPackageManager;
    PackageInfo localPackageInfo;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      localPackageManager = paramContext.getPackageManager();
      localObject = null;
      if (paramBoolean) {}
      try
      {
        localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        AppMethodBeat.o(89397);
        return 9;
      }
      try
      {
        localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        paramContext = GoogleSignatureVerifier.getInstance(paramContext);
        if (paramContext.isGooglePublicSignedPackage(localPackageInfo, true)) {
          break label103;
        }
        AppMethodBeat.o(89397);
        return 9;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        AppMethodBeat.o(89397);
        return 1;
      }
    }
    label103:
    if ((paramBoolean) && ((!paramContext.isGooglePublicSignedPackage((PackageInfo)localObject, true)) || (!localObject.signatures[0].equals(localPackageInfo.signatures[0]))))
    {
      AppMethodBeat.o(89397);
      return 9;
    }
    if (GmsVersionParser.parseBuildVersion(localPackageInfo.versionCode) < GmsVersionParser.parseBuildVersion(paramInt))
    {
      int i = localPackageInfo.versionCode;
      new StringBuilder(77).append("Google Play services out of date.  Requires ").append(paramInt).append(" but found ").append(i);
      AppMethodBeat.o(89397);
      return 2;
    }
    Object localObject = localPackageInfo.applicationInfo;
    paramContext = (Context)localObject;
    if (localObject == null) {}
    try
    {
      paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!paramContext.enabled)
      {
        AppMethodBeat.o(89397);
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
      AppMethodBeat.o(89397);
      return 1;
    }
    AppMethodBeat.o(89397);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtilLight
 * JD-Core Version:    0.7.0.1
 */