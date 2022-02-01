package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public class zzg
{
  private static final String[] ACCEPTABLE_ACCOUNT_TYPES;
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  private static final ComponentName zzp;
  private static final Logger zzq;
  
  static
  {
    AppMethodBeat.i(10732);
    ACCEPTABLE_ACCOUNT_TYPES = new String[] { "com.google", "com.google.work", "cn.google" };
    KEY_CALLER_UID = "callerUid";
    KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    zzp = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    zzq = new Logger("Auth", new String[] { "GoogleAuthUtil" });
    AppMethodBeat.o(10732);
  }
  
  public static void clearToken(Context paramContext, String paramString)
  {
    AppMethodBeat.i(10722);
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    Bundle localBundle = new Bundle();
    String str = paramContext.getApplicationInfo().packageName;
    localBundle.putString("clientPackageName", str);
    if (!localBundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
      localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    }
    paramString = new zzi(paramString, localBundle);
    zzd(paramContext, zzp, paramString);
    AppMethodBeat.o(10722);
  }
  
  private static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(10728);
    try
    {
      GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext.getApplicationContext(), paramInt);
      AppMethodBeat.o(10728);
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      paramContext = new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
      AppMethodBeat.o(10728);
      throw paramContext;
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      paramContext = new GoogleAuthException(paramContext.getMessage());
      AppMethodBeat.o(10728);
      throw paramContext;
    }
  }
  
  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(10723);
    Preconditions.checkNotEmpty(paramString, "accountName must be provided");
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    paramString = new zzj(paramString, paramInt);
    paramContext = (List)zzd(paramContext, zzp, paramString);
    AppMethodBeat.o(10723);
    return paramContext;
  }
  
  public static String getAccountId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(10724);
    Preconditions.checkNotEmpty(paramString, "accountName must be provided");
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    paramContext = getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
    AppMethodBeat.o(10724);
    return paramContext;
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
  {
    AppMethodBeat.i(10718);
    paramContext = getToken(paramContext, paramAccount, paramString, new Bundle());
    AppMethodBeat.o(10718);
    return paramContext;
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10719);
    zze(paramAccount);
    paramContext = zze(paramContext, paramAccount, paramString, paramBundle).zze();
    AppMethodBeat.o(10719);
    return paramContext;
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10716);
    paramContext = getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
    AppMethodBeat.o(10716);
    return paramContext;
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(10717);
    paramContext = getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
    AppMethodBeat.o(10717);
    return paramContext;
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AppMethodBeat.i(10721);
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
    AppMethodBeat.o(10721);
  }
  
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
  {
    AppMethodBeat.i(10725);
    Preconditions.checkNotNull(paramContext);
    zze(paramAccount);
    ensurePlayServicesAvailable(paramContext, 8400000);
    paramAccount = new zzk(paramAccount);
    paramContext = (Bundle)zzd(paramContext, zzp, paramAccount);
    AppMethodBeat.o(10725);
    return paramContext;
  }
  
  public static Boolean requestGoogleAccountsAccess(Context paramContext)
  {
    AppMethodBeat.i(10726);
    Preconditions.checkNotNull(paramContext);
    ensurePlayServicesAvailable(paramContext, 11400000);
    zzl localzzl = new zzl(paramContext.getApplicationInfo().packageName);
    paramContext = (Boolean)zzd(paramContext, zzp, localzzl);
    AppMethodBeat.o(10726);
    return paramContext;
  }
  
  /* Error */
  private static <T> T zzd(Context paramContext, ComponentName paramComponentName, zzm<T> paramzzm)
  {
    // Byte code:
    //   0: sipush 10730
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 245	com/google/android/gms/common/BlockingServiceConnection
    //   9: dup
    //   10: invokespecial 246	com/google/android/gms/common/BlockingServiceConnection:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: invokestatic 252	com/google/android/gms/common/internal/GmsClientSupervisor:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/GmsClientSupervisor;
    //   18: astore 4
    //   20: aload 4
    //   22: aload_1
    //   23: aload_3
    //   24: ldc 71
    //   26: invokevirtual 256	com/google/android/gms/common/internal/GmsClientSupervisor:bindService	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   29: ifeq +92 -> 121
    //   32: aload_2
    //   33: aload_3
    //   34: invokevirtual 260	com/google/android/gms/common/BlockingServiceConnection:getService	()Landroid/os/IBinder;
    //   37: invokeinterface 265 2 0
    //   42: astore_0
    //   43: aload 4
    //   45: aload_1
    //   46: aload_3
    //   47: ldc 71
    //   49: invokevirtual 269	com/google/android/gms/common/internal/GmsClientSupervisor:unbindService	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   52: sipush 10730
    //   55: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: areturn
    //   60: astore_0
    //   61: getstatic 76	com/google/android/gms/auth/zzg:zzq	Lcom/google/android/gms/common/logging/Logger;
    //   64: ldc 71
    //   66: iconst_2
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: ldc_w 271
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_0
    //   79: aastore
    //   80: invokevirtual 274	com/google/android/gms/common/logging/Logger:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: new 276	java/io/IOException
    //   86: dup
    //   87: ldc_w 271
    //   90: aload_0
    //   91: invokespecial 279	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: astore_0
    //   95: sipush 10730
    //   98: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: aload 4
    //   106: aload_1
    //   107: aload_3
    //   108: ldc 71
    //   110: invokevirtual 269	com/google/android/gms/common/internal/GmsClientSupervisor:unbindService	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   113: sipush 10730
    //   116: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: athrow
    //   121: new 276	java/io/IOException
    //   124: dup
    //   125: ldc_w 281
    //   128: invokespecial 282	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   131: astore_0
    //   132: sipush 10730
    //   135: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: athrow
    //   140: astore_0
    //   141: goto -80 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramComponentName	ComponentName
    //   0	144	2	paramzzm	zzm<T>
    //   13	95	3	localBlockingServiceConnection	com.google.android.gms.common.BlockingServiceConnection
    //   18	87	4	localGmsClientSupervisor	com.google.android.gms.common.internal.GmsClientSupervisor
    // Exception table:
    //   from	to	target	type
    //   32	43	60	java/lang/InterruptedException
    //   32	43	103	finally
    //   61	103	103	finally
    //   32	43	140	android/os/RemoteException
  }
  
  private static <T> T zzd(T paramT)
  {
    AppMethodBeat.i(10729);
    if (paramT == null)
    {
      zzq.w("GoogleAuthUtil", new Object[] { "Binder call returned null." });
      paramT = new IOException("Service unavailable.");
      AppMethodBeat.o(10729);
      throw paramT;
    }
    AppMethodBeat.o(10729);
    return paramT;
  }
  
  public static TokenData zze(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10720);
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    Preconditions.checkNotEmpty(paramString, "Scope cannot be empty or null.");
    zze(paramAccount);
    ensurePlayServicesAvailable(paramContext, 8400000);
    if (paramBundle == null) {}
    for (paramBundle = new Bundle();; paramBundle = new Bundle(paramBundle))
    {
      String str = paramContext.getApplicationInfo().packageName;
      paramBundle.putString("clientPackageName", str);
      if (TextUtils.isEmpty(paramBundle.getString(KEY_ANDROID_PACKAGE_NAME))) {
        paramBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
      }
      paramBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      paramAccount = new zzh(paramAccount, paramString, paramBundle);
      paramContext = (TokenData)zzd(paramContext, zzp, paramAccount);
      AppMethodBeat.o(10720);
      return paramContext;
    }
  }
  
  private static void zze(Account paramAccount)
  {
    AppMethodBeat.i(10727);
    if (paramAccount == null)
    {
      paramAccount = new IllegalArgumentException("Account cannot be null");
      AppMethodBeat.o(10727);
      throw paramAccount;
    }
    if (TextUtils.isEmpty(paramAccount.name))
    {
      paramAccount = new IllegalArgumentException("Account name cannot be empty!");
      AppMethodBeat.o(10727);
      throw paramAccount;
    }
    String[] arrayOfString = ACCEPTABLE_ACCOUNT_TYPES;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramAccount.type))
      {
        AppMethodBeat.o(10727);
        return;
      }
      i += 1;
    }
    paramAccount = new IllegalArgumentException("Account type not supported");
    AppMethodBeat.o(10727);
    throw paramAccount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.zzg
 * JD-Core Version:    0.7.0.1
 */