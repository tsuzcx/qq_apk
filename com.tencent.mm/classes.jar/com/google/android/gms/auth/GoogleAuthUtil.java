package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

public final class GoogleAuthUtil
  extends zze
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME = zze.KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID = zze.KEY_CALLER_UID;
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  
  public static void clearToken(Context paramContext, String paramString)
  {
    zze.clearToken(paramContext, paramString);
  }
  
  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
  {
    return zze.getAccountChangeEvents(paramContext, paramInt, paramString);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
  {
    return zze.getAccountId(paramContext, paramString);
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
  {
    return zze.getToken(paramContext, paramAccount, paramString);
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return zze.getToken(paramContext, paramAccount, paramString, paramBundle);
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
  {
    return zze.getToken(paramContext, paramString1, paramString2);
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    return zze.getToken(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return zza(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle, Intent paramIntent)
  {
    zzi(paramIntent);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("callback_intent", paramIntent);
    localBundle.putBoolean("handle_notification", true);
    return zzb(paramContext, paramAccount, paramString, localBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
  {
    zzac.zzh(paramString2, "Authority cannot be empty or null.");
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle1);
    localBundle.putString("authority", paramString2);
    localBundle.putBundle("sync_extras", paramBundle1);
    localBundle.putBoolean("handle_notification", true);
    return zzb(paramContext, paramAccount, paramString1, localBundle).getToken();
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle, paramIntent);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    zze.invalidateToken(paramContext, paramString);
  }
  
  @TargetApi(23)
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
  {
    return zze.removeAccount(paramContext, paramAccount);
  }
  
  public static TokenData zza(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("handle_notification", true);
    return zzb(paramContext, paramAccount, paramString, localBundle);
  }
  
  private static TokenData zzb(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      paramAccount = zzc(paramContext, paramAccount, paramString, localBundle);
      GooglePlayServicesUtil.zzaF(paramContext);
      return paramAccount;
    }
    catch (GooglePlayServicesAvailabilityException paramAccount)
    {
      GooglePlayServicesUtil.showErrorNotification(paramAccount.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException paramAccount)
    {
      GooglePlayServicesUtil.zzaF(paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  public static TokenData zzc(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return zze.zzc(paramContext, paramAccount, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * JD-Core Version:    0.7.0.1
 */