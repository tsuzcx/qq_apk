package com.google.android.gms.common;

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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.GmsVersionParser;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
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
  public static boolean sIsTestMode;
  public static boolean sTestIsUserBuild;
  private static boolean zzbr;
  private static boolean zzbs;
  static final AtomicBoolean zzbt;
  private static final AtomicBoolean zzbu;
  
  static
  {
    AppMethodBeat.i(4440);
    GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    sIsTestMode = false;
    sTestIsUserBuild = false;
    zzbr = false;
    zzbs = false;
    zzbt = new AtomicBoolean();
    zzbu = new AtomicBoolean();
    AppMethodBeat.o(4440);
  }
  
  @Deprecated
  public static void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    AppMethodBeat.i(4429);
    if (zzbt.getAndSet(true))
    {
      AppMethodBeat.o(4429);
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null) {
        paramContext.cancel(10436);
      }
      AppMethodBeat.o(4429);
      return;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o(4429);
    }
  }
  
  public static void enableUsingApkIndependentContext()
  {
    AppMethodBeat.i(4415);
    zzbu.set(true);
    AppMethodBeat.o(4415);
  }
  
  @Deprecated
  public static void ensurePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(4420);
    ensurePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    AppMethodBeat.o(4420);
  }
  
  @Deprecated
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4421);
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0)
    {
      paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      new StringBuilder(57).append("GooglePlayServices not available due to error ").append(paramInt);
      if (paramContext == null)
      {
        paramContext = new GooglePlayServicesNotAvailableException(paramInt);
        AppMethodBeat.o(4421);
        throw paramContext;
      }
      paramContext = new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", paramContext);
      AppMethodBeat.o(4421);
      throw paramContext;
    }
    AppMethodBeat.o(4421);
  }
  
  @Deprecated
  public static int getApkVersion(Context paramContext)
  {
    AppMethodBeat.i(4434);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      int i = paramContext.versionCode;
      AppMethodBeat.o(4434);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(4434);
    }
    return 0;
  }
  
  @Deprecated
  public static int getClientVersion(Context paramContext)
  {
    AppMethodBeat.i(4433);
    Preconditions.checkState(true);
    int i = ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
    AppMethodBeat.o(4433);
    return i;
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    AppMethodBeat.i(4428);
    paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
    AppMethodBeat.o(4428);
    return paramContext;
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    AppMethodBeat.i(4416);
    String str = ConnectionResult.zza(paramInt);
    AppMethodBeat.o(4416);
    return str;
  }
  
  @Deprecated
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    AppMethodBeat.i(4424);
    Intent localIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
    AppMethodBeat.o(4424);
    return localIntent;
  }
  
  /* Error */
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: sipush 4430
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 201	android/net/Uri$Builder
    //   9: dup
    //   10: invokespecial 202	android/net/Uri$Builder:<init>	()V
    //   13: ldc 204
    //   15: invokevirtual 208	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   18: ldc 14
    //   20: invokevirtual 211	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   23: ldc 213
    //   25: invokevirtual 216	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   28: ldc 218
    //   30: invokevirtual 216	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   33: invokevirtual 222	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   36: astore_1
    //   37: aload_0
    //   38: invokevirtual 226	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_1
    //   42: invokevirtual 232	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   45: astore_0
    //   46: new 234	java/util/Scanner
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 237	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   54: ldc 239
    //   56: invokevirtual 243	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   59: invokevirtual 246	java/util/Scanner:next	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 251	java/io/InputStream:close	()V
    //   71: sipush 4430
    //   74: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: areturn
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 251	java/io/InputStream:close	()V
    //   88: sipush 4430
    //   91: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 251	java/io/InputStream:close	()V
    //   105: sipush 4430
    //   108: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: athrow
    //   113: astore_0
    //   114: sipush 4430
    //   117: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   36	42	1	localObject1	Object
    //   79	1	1	localNoSuchElementException	java.util.NoSuchElementException
    //   96	16	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	63	79	java/util/NoSuchElementException
    //   46	63	96	finally
    //   37	46	113	java/lang/Exception
    //   67	71	113	java/lang/Exception
    //   84	88	113	java/lang/Exception
    //   101	105	113	java/lang/Exception
    //   105	113	113	java/lang/Exception
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    AppMethodBeat.i(4432);
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      AppMethodBeat.o(4432);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(4432);
    }
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    AppMethodBeat.i(4431);
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      AppMethodBeat.o(4431);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(4431);
    }
    return null;
  }
  
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    AppMethodBeat.i(4427);
    if ((isTestKeysBuild(paramContext)) || (!isUserBuildDevice()))
    {
      AppMethodBeat.o(4427);
      return true;
    }
    AppMethodBeat.o(4427);
    return false;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(4417);
    int i = isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    AppMethodBeat.o(4417);
    return i;
  }
  
  /* Error */
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: sipush 4418
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 277	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: getstatic 282	com/google/android/gms/common/R$string:common_google_play_services_unknown_issue	I
    //   13: invokevirtual 287	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   16: pop
    //   17: ldc 14
    //   19: aload_0
    //   20: invokevirtual 173	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +106 -> 132
    //   29: getstatic 69	com/google/android/gms/common/GooglePlayServicesUtilLight:zzbu	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   32: invokevirtual 296	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   35: ifne +97 -> 132
    //   38: aload_0
    //   39: invokestatic 301	com/google/android/gms/common/internal/MetadataValueReader:getGooglePlayServicesVersion	(Landroid/content/Context;)I
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +22 -> 66
    //   47: new 303	java/lang/IllegalStateException
    //   50: dup
    //   51: ldc_w 305
    //   54: invokespecial 308	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   57: astore_0
    //   58: sipush 4418
    //   61: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: athrow
    //   66: iload_2
    //   67: getstatic 52	com/google/android/gms/common/GooglePlayServicesUtilLight:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   70: if_icmpeq +62 -> 132
    //   73: getstatic 52	com/google/android/gms/common/GooglePlayServicesUtilLight:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   76: istore_1
    //   77: new 303	java/lang/IllegalStateException
    //   80: dup
    //   81: new 123	java/lang/StringBuilder
    //   84: dup
    //   85: sipush 320
    //   88: invokespecial 125	java/lang/StringBuilder:<init>	(I)V
    //   91: ldc_w 310
    //   94: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_1
    //   98: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc_w 312
    //   104: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload_2
    //   108: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc_w 314
    //   114: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 308	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   123: astore_0
    //   124: sipush 4418
    //   127: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: athrow
    //   132: aload_0
    //   133: invokestatic 322	com/google/android/gms/common/util/DeviceProperties:isWearableWithoutPlayStore	(Landroid/content/Context;)Z
    //   136: ifne +27 -> 163
    //   139: aload_0
    //   140: invokestatic 325	com/google/android/gms/common/util/DeviceProperties:isIoT	(Landroid/content/Context;)Z
    //   143: ifne +20 -> 163
    //   146: iconst_1
    //   147: istore_3
    //   148: aload_0
    //   149: iload_3
    //   150: iload_1
    //   151: invokestatic 328	com/google/android/gms/common/GooglePlayServicesUtilLight:zza	(Landroid/content/Context;ZI)I
    //   154: istore_1
    //   155: sipush 4418
    //   158: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iload_1
    //   162: ireturn
    //   163: iconst_0
    //   164: istore_3
    //   165: goto -17 -> 148
    //   168: astore 4
    //   170: goto -153 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramContext	Context
    //   0	173	1	paramInt	int
    //   42	66	2	i	int
    //   147	18	3	bool	boolean
    //   168	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	17	168	finally
  }
  
  @Deprecated
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4422);
    boolean bool = UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
    AppMethodBeat.o(4422);
    return bool;
  }
  
  @Deprecated
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4436);
    if (paramInt == 18)
    {
      AppMethodBeat.o(4436);
      return true;
    }
    if (paramInt == 1)
    {
      boolean bool = isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms");
      AppMethodBeat.o(4436);
      return bool;
    }
    AppMethodBeat.o(4436);
    return false;
  }
  
  @Deprecated
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4437);
    if (paramInt == 9)
    {
      boolean bool = isUninstalledAppPossiblyUpdating(paramContext, "com.android.vending");
      AppMethodBeat.o(4437);
      return bool;
    }
    AppMethodBeat.o(4437);
    return false;
  }
  
  public static boolean isRestrictedUserProfile(Context paramContext)
  {
    AppMethodBeat.i(4439);
    if (PlatformVersion.isAtLeastJellyBeanMR2())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile"))))
      {
        AppMethodBeat.o(4439);
        return true;
      }
    }
    AppMethodBeat.o(4439);
    return false;
  }
  
  @Deprecated
  public static boolean isSidewinderDevice(Context paramContext)
  {
    AppMethodBeat.i(4435);
    boolean bool = DeviceProperties.isSidewinder(paramContext);
    AppMethodBeat.o(4435);
    return bool;
  }
  
  public static boolean isTestKeysBuild(Context paramContext)
  {
    AppMethodBeat.i(4426);
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
        AppMethodBeat.o(4426);
      }
      bool = zzbr;
      AppMethodBeat.o(4426);
      return bool;
      zzbr = false;
    }
  }
  
  static boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4438);
    boolean bool = paramString.equals("com.google.android.gms");
    if (PlatformVersion.isAtLeastLollipop()) {
      try
      {
        localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName()))
          {
            AppMethodBeat.o(4438);
            return true;
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(4438);
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
        AppMethodBeat.o(4438);
        return bool;
      }
      if ((paramString.enabled) && (!isRestrictedUserProfile(paramContext)))
      {
        AppMethodBeat.o(4438);
        return true;
      }
      AppMethodBeat.o(4438);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(4438);
    }
    return false;
  }
  
  @Deprecated
  public static boolean isUserBuildDevice()
  {
    AppMethodBeat.i(4425);
    boolean bool = DeviceProperties.isUserBuild();
    AppMethodBeat.o(4425);
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
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(4423);
    boolean bool = UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
    AppMethodBeat.o(4423);
    return bool;
  }
  
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(4419);
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
        AppMethodBeat.o(4419);
        return 9;
      }
      try
      {
        localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        paramContext = GoogleSignatureVerifier.getInstance(paramContext);
        if (paramContext.isGooglePublicSignedPackage(localPackageInfo, true)) {
          break label103;
        }
        AppMethodBeat.o(4419);
        return 9;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        AppMethodBeat.o(4419);
        return 1;
      }
    }
    label103:
    if ((paramBoolean) && ((!paramContext.isGooglePublicSignedPackage((PackageInfo)localObject, true)) || (!localObject.signatures[0].equals(localPackageInfo.signatures[0]))))
    {
      AppMethodBeat.o(4419);
      return 9;
    }
    if (GmsVersionParser.parseBuildVersion(localPackageInfo.versionCode) < GmsVersionParser.parseBuildVersion(paramInt))
    {
      int i = localPackageInfo.versionCode;
      new StringBuilder(77).append("Google Play services out of date.  Requires ").append(paramInt).append(" but found ").append(i);
      AppMethodBeat.o(4419);
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
        AppMethodBeat.o(4419);
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
      AppMethodBeat.o(4419);
      return 1;
    }
    AppMethodBeat.o(4419);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtilLight
 * JD-Core Version:    0.7.0.1
 */