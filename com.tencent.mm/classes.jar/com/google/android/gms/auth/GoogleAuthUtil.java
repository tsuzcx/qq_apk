package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil
  extends zzg
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  private static final String KEY_ANDROID_PACKAGE_NAME = zzg.KEY_ANDROID_PACKAGE_NAME;
  private static final String KEY_CALLER_UID = zzg.KEY_CALLER_UID;
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  
  public static void clearToken(Context paramContext, String paramString)
  {
    AppMethodBeat.i(10609);
    zzg.clearToken(paramContext, paramString);
    AppMethodBeat.o(10609);
  }
  
  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(10610);
    paramContext = zzg.getAccountChangeEvents(paramContext, paramInt, paramString);
    AppMethodBeat.o(10610);
    return paramContext;
  }
  
  public static String getAccountId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(10611);
    paramContext = zzg.getAccountId(paramContext, paramString);
    AppMethodBeat.o(10611);
    return paramContext;
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
  {
    AppMethodBeat.i(10606);
    paramContext = zzg.getToken(paramContext, paramAccount, paramString);
    AppMethodBeat.o(10606);
    return paramContext;
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10607);
    paramContext = zzg.getToken(paramContext, paramAccount, paramString, paramBundle);
    AppMethodBeat.o(10607);
    return paramContext;
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10604);
    paramContext = zzg.getToken(paramContext, paramString1, paramString2);
    AppMethodBeat.o(10604);
    return paramContext;
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(10605);
    paramContext = zzg.getToken(paramContext, paramString1, paramString2, paramBundle);
    AppMethodBeat.o(10605);
    return paramContext;
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10600);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("handle_notification", true);
    paramContext = zzd(paramContext, paramAccount, paramString, localBundle).zze();
    AppMethodBeat.o(10600);
    return paramContext;
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle, Intent paramIntent)
  {
    AppMethodBeat.i(10601);
    if (paramIntent == null)
    {
      paramContext = new IllegalArgumentException("Callback cannot be null.");
      AppMethodBeat.o(10601);
      throw paramContext;
    }
    Object localObject = paramIntent.toUri(1);
    try
    {
      Intent.parseUri((String)localObject, 1);
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putParcelable("callback_intent", paramIntent);
      ((Bundle)localObject).putBoolean("handle_notification", true);
      paramContext = zzd(paramContext, paramAccount, paramString, (Bundle)localObject).zze();
      AppMethodBeat.o(10601);
      return paramContext;
    }
    catch (URISyntaxException paramContext)
    {
      paramContext = new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
      AppMethodBeat.o(10601);
      throw paramContext;
    }
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
  {
    AppMethodBeat.i(10602);
    Preconditions.checkNotEmpty(paramString2, "Authority cannot be empty or null.");
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
    paramContext = zzd(paramContext, paramAccount, paramString1, localBundle).zze();
    AppMethodBeat.o(10602);
    return paramContext;
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(10597);
    paramContext = getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
    AppMethodBeat.o(10597);
    return paramContext;
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
  {
    AppMethodBeat.i(10598);
    paramContext = getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle, paramIntent);
    AppMethodBeat.o(10598);
    return paramContext;
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
  {
    AppMethodBeat.i(10599);
    paramContext = getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
    AppMethodBeat.o(10599);
    return paramContext;
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AppMethodBeat.i(10608);
    zzg.invalidateToken(paramContext, paramString);
    AppMethodBeat.o(10608);
  }
  
  @TargetApi(23)
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
  {
    AppMethodBeat.i(10612);
    paramContext = zzg.removeAccount(paramContext, paramAccount);
    AppMethodBeat.o(10612);
    return paramContext;
  }
  
  @TargetApi(26)
  public static Boolean requestGoogleAccountsAccess(Context paramContext)
  {
    AppMethodBeat.i(10613);
    paramContext = zzg.requestGoogleAccountsAccess(paramContext);
    AppMethodBeat.o(10613);
    return paramContext;
  }
  
  private static TokenData zzd(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10603);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      paramAccount = zzg.zze(paramContext, paramAccount, paramString, localBundle);
      GooglePlayServicesUtil.cancelAvailabilityErrorNotifications(paramContext);
      AppMethodBeat.o(10603);
      return paramAccount;
    }
    catch (GooglePlayServicesAvailabilityException paramAccount)
    {
      GooglePlayServicesUtil.showErrorNotification(paramAccount.getConnectionStatusCode(), paramContext);
      paramContext = new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      AppMethodBeat.o(10603);
      throw paramContext;
    }
    catch (UserRecoverableAuthException paramAccount)
    {
      GooglePlayServicesUtil.cancelAvailabilityErrorNotifications(paramContext);
      paramContext = new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      AppMethodBeat.o(10603);
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * JD-Core Version:    0.7.0.1
 */