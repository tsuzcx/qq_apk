package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zzg;
import com.google.android.gms.internal.zzacm;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class zze
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  @SuppressLint({"InlinedApi"})
  public static final String KEY_ANDROID_PACKAGE_NAME;
  @SuppressLint({"InlinedApi"})
  public static final String KEY_CALLER_UID;
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  private static final zzacm zzaiA = zzd.zzb(new String[] { "GoogleAuthUtil" });
  private static final String[] zzaiy = { "com.google", "com.google.work", "cn.google" };
  private static final ComponentName zzaiz;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    KEY_CALLER_UID = "callerUid";
    i = Build.VERSION.SDK_INT;
    KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    zzaiz = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  }
  
  public static void clearToken(Context paramContext, String paramString)
  {
    zzac.zzdk("Calling this from your main thread can lead to deadlock");
    zzaq(paramContext);
    Bundle localBundle = new Bundle();
    String str = paramContext.getApplicationInfo().packageName;
    localBundle.putString("clientPackageName", str);
    if (!localBundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
      localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    }
    paramString = new zze.2(paramString, localBundle);
    zza(paramContext, zzaiz, paramString);
  }
  
  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
  {
    zzac.zzh(paramString, "accountName must be provided");
    zzac.zzdk("Calling this from your main thread can lead to deadlock");
    zzaq(paramContext);
    paramString = new zze.3(paramString, paramInt);
    return (List)zza(paramContext, zzaiz, paramString);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
  {
    zzac.zzh(paramString, "accountName must be provided");
    zzac.zzdk("Calling this from your main thread can lead to deadlock");
    zzaq(paramContext);
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    zzc(paramAccount);
    return zzc(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  @TargetApi(23)
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
  {
    zzac.zzw(paramContext);
    zzc(paramAccount);
    zzaq(paramContext);
    paramAccount = new zze.4(paramAccount);
    return (Bundle)zza(paramContext, zzaiz, paramAccount);
  }
  
  /* Error */
  private static <T> T zza(Context paramContext, ComponentName paramComponentName, zze.zza<T> paramzza)
  {
    // Byte code:
    //   0: new 206	com/google/android/gms/common/zza
    //   3: dup
    //   4: invokespecial 207	com/google/android/gms/common/zza:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 213	com/google/android/gms/common/internal/zzn:zzaU	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzn;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: aload_3
    //   18: ldc 71
    //   20: invokevirtual 216	com/google/android/gms/common/internal/zzn:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   23: ifeq +70 -> 93
    //   26: aload_2
    //   27: aload_3
    //   28: invokevirtual 220	com/google/android/gms/common/zza:zzuX	()Landroid/os/IBinder;
    //   31: invokeinterface 224 2 0
    //   36: astore_0
    //   37: aload 4
    //   39: aload_1
    //   40: aload_3
    //   41: ldc 71
    //   43: invokevirtual 227	com/google/android/gms/common/internal/zzn:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: getstatic 79	com/google/android/gms/auth/zze:zzaiA	Lcom/google/android/gms/internal/zzacm;
    //   52: ldc 71
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: ldc 229
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_0
    //   66: aastore
    //   67: invokevirtual 235	com/google/android/gms/internal/zzacm:zze	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: new 237	java/io/IOException
    //   73: dup
    //   74: ldc 229
    //   76: aload_0
    //   77: invokespecial 240	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: athrow
    //   81: astore_0
    //   82: aload 4
    //   84: aload_1
    //   85: aload_3
    //   86: ldc 71
    //   88: invokevirtual 227	com/google/android/gms/common/internal/zzn:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   91: aload_0
    //   92: athrow
    //   93: new 237	java/io/IOException
    //   96: dup
    //   97: ldc 242
    //   99: invokespecial 244	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   102: athrow
    //   103: astore_0
    //   104: goto -55 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramContext	Context
    //   0	107	1	paramComponentName	ComponentName
    //   0	107	2	paramzza	zze.zza<T>
    //   7	79	3	localzza	com.google.android.gms.common.zza
    //   12	71	4	localzzn	com.google.android.gms.common.internal.zzn
    // Exception table:
    //   from	to	target	type
    //   26	37	48	java/lang/InterruptedException
    //   26	37	81	finally
    //   49	81	81	finally
    //   26	37	103	android/os/RemoteException
  }
  
  private static void zzaq(Context paramContext)
  {
    try
    {
      zzg.zzaq(paramContext.getApplicationContext());
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
  }
  
  public static TokenData zzc(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    zzac.zzdk("Calling this from your main thread can lead to deadlock");
    zzac.zzh(paramString, "Scope cannot be empty or null.");
    zzc(paramAccount);
    zzaq(paramContext);
    if (paramBundle == null) {}
    for (paramBundle = new Bundle();; paramBundle = new Bundle(paramBundle))
    {
      String str = paramContext.getApplicationInfo().packageName;
      paramBundle.putString("clientPackageName", str);
      if (TextUtils.isEmpty(paramBundle.getString(KEY_ANDROID_PACKAGE_NAME))) {
        paramBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
      }
      paramBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      paramAccount = new zze.1(paramAccount, paramString, paramBundle);
      return (TokenData)zza(paramContext, zzaiz, paramAccount);
    }
  }
  
  private static void zzc(Account paramAccount)
  {
    if (paramAccount == null) {
      throw new IllegalArgumentException("Account cannot be null");
    }
    if (TextUtils.isEmpty(paramAccount.name)) {
      throw new IllegalArgumentException("Account name cannot be empty!");
    }
    String[] arrayOfString = zzaiy;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramAccount.type)) {
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("Account type not supported");
  }
  
  static void zzi(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    paramIntent = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(paramIntent, 1);
      return;
    }
    catch (URISyntaxException paramIntent)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
  
  private static <T> T zzn(T paramT)
  {
    if (paramT == null)
    {
      zzaiA.zzf("GoogleAuthUtil", new Object[] { "Binder call returned null." });
      throw new IOException("Service unavailable.");
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.zze
 * JD-Core Version:    0.7.0.1
 */