package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.e.m;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public final class ConnectionErrorMessages
{
  @GuardedBy("sCache")
  private static final m<String, String> zzse;
  
  static
  {
    AppMethodBeat.i(61333);
    zzse = new m();
    AppMethodBeat.o(61333);
  }
  
  public static String getAppName(Context paramContext)
  {
    AppMethodBeat.i(61329);
    String str1 = paramContext.getPackageName();
    try
    {
      String str2 = Wrappers.packageManager(paramContext).getApplicationLabel(str1).toString();
      AppMethodBeat.o(61329);
      return str2;
    }
    catch (NullPointerException localNullPointerException)
    {
      paramContext = paramContext.getApplicationInfo().name;
      if (TextUtils.isEmpty(paramContext))
      {
        AppMethodBeat.o(61329);
        return str1;
      }
      AppMethodBeat.o(61329);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label32:
      break label32;
    }
  }
  
  public static String getDefaultNotificationChannelName(Context paramContext)
  {
    AppMethodBeat.i(61332);
    paramContext = paramContext.getResources().getString(2131296292);
    AppMethodBeat.o(61332);
    return paramContext;
  }
  
  public static String getErrorDialogButtonMessage(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(61328);
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(17039370);
      AppMethodBeat.o(61328);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131296289);
      AppMethodBeat.o(61328);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131296286);
      AppMethodBeat.o(61328);
      return paramContext;
    }
    paramContext = paramContext.getString(2131296296);
    AppMethodBeat.o(61328);
    return paramContext;
  }
  
  public static String getErrorMessage(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(61326);
    Resources localResources = paramContext.getResources();
    String str = getAppName(paramContext);
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      paramContext = localResources.getString(2131296294, new Object[] { str });
      AppMethodBeat.o(61326);
      return paramContext;
    case 1: 
      paramContext = localResources.getString(2131296290, new Object[] { str });
      AppMethodBeat.o(61326);
      return paramContext;
    case 3: 
      paramContext = localResources.getString(2131296287, new Object[] { str });
      AppMethodBeat.o(61326);
      return paramContext;
    case 18: 
      paramContext = localResources.getString(2131296299, new Object[] { str });
      AppMethodBeat.o(61326);
      return paramContext;
    case 2: 
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext))
      {
        paramContext = localResources.getString(2131296300);
        AppMethodBeat.o(61326);
        return paramContext;
      }
      paramContext = localResources.getString(2131296297, new Object[] { str });
      AppMethodBeat.o(61326);
      return paramContext;
    case 9: 
      paramContext = localResources.getString(2131296295, new Object[] { str });
      AppMethodBeat.o(61326);
      return paramContext;
    case 7: 
      paramContext = zza(paramContext, "common_google_play_services_network_error_text", str);
      AppMethodBeat.o(61326);
      return paramContext;
    case 5: 
      paramContext = zza(paramContext, "common_google_play_services_invalid_account_text", str);
      AppMethodBeat.o(61326);
      return paramContext;
    case 16: 
      paramContext = zza(paramContext, "common_google_play_services_api_unavailable_text", str);
      AppMethodBeat.o(61326);
      return paramContext;
    case 17: 
      paramContext = zza(paramContext, "common_google_play_services_sign_in_failed_text", str);
      AppMethodBeat.o(61326);
      return paramContext;
    }
    paramContext = zza(paramContext, "common_google_play_services_restricted_profile_text", str);
    AppMethodBeat.o(61326);
    return paramContext;
  }
  
  public static String getErrorNotificationMessage(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(61327);
    if (paramInt == 6)
    {
      paramContext = zza(paramContext, "common_google_play_services_resolution_required_text", getAppName(paramContext));
      AppMethodBeat.o(61327);
      return paramContext;
    }
    paramContext = getErrorMessage(paramContext, paramInt);
    AppMethodBeat.o(61327);
    return paramContext;
  }
  
  public static String getErrorNotificationTitle(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(61325);
    if (paramInt == 6) {}
    for (String str1 = zzb(paramContext, "common_google_play_services_resolution_required_title");; str1 = getErrorTitle(paramContext, paramInt))
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = paramContext.getResources().getString(2131296293);
      }
      AppMethodBeat.o(61325);
      return str2;
    }
  }
  
  public static String getErrorTitle(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(61324);
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      new StringBuilder(33).append("Unexpected error code ").append(paramInt);
      AppMethodBeat.o(61324);
      return null;
    case 4: 
    case 6: 
    case 18: 
      AppMethodBeat.o(61324);
      return null;
    case 1: 
      paramContext = localResources.getString(2131296291);
      AppMethodBeat.o(61324);
      return paramContext;
    case 3: 
      paramContext = localResources.getString(2131296288);
      AppMethodBeat.o(61324);
      return paramContext;
    case 2: 
      paramContext = localResources.getString(2131296298);
      AppMethodBeat.o(61324);
      return paramContext;
    case 9: 
      AppMethodBeat.o(61324);
      return null;
    case 7: 
      paramContext = zzb(paramContext, "common_google_play_services_network_error_title");
      AppMethodBeat.o(61324);
      return paramContext;
    case 8: 
      AppMethodBeat.o(61324);
      return null;
    case 10: 
      AppMethodBeat.o(61324);
      return null;
    case 5: 
      paramContext = zzb(paramContext, "common_google_play_services_invalid_account_title");
      AppMethodBeat.o(61324);
      return paramContext;
    case 11: 
      AppMethodBeat.o(61324);
      return null;
    case 16: 
      AppMethodBeat.o(61324);
      return null;
    case 17: 
      paramContext = zzb(paramContext, "common_google_play_services_sign_in_failed_title");
      AppMethodBeat.o(61324);
      return paramContext;
    }
    paramContext = zzb(paramContext, "common_google_play_services_restricted_profile_title");
    AppMethodBeat.o(61324);
    return paramContext;
  }
  
  private static String zza(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(61330);
    Resources localResources = paramContext.getResources();
    paramString1 = zzb(paramContext, paramString1);
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = localResources.getString(2131296294);
    }
    paramContext = String.format(localResources.getConfiguration().locale, paramContext, new Object[] { paramString2 });
    AppMethodBeat.o(61330);
    return paramContext;
  }
  
  private static String zzb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(61331);
    int i;
    synchronized (zzse)
    {
      String str = (String)zzse.get(paramString);
      if (str != null)
      {
        AppMethodBeat.o(61331);
        return str;
      }
      paramContext = GooglePlayServicesUtil.getRemoteResource(paramContext);
      if (paramContext == null)
      {
        AppMethodBeat.o(61331);
        return null;
      }
      i = paramContext.getIdentifier(paramString, "string", "com.google.android.gms");
      if (i == 0)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0)
        {
          "Missing resource: ".concat(paramContext);
          AppMethodBeat.o(61331);
          return null;
        }
        new String("Missing resource: ");
      }
    }
    paramContext = paramContext.getString(i);
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() != 0) {
        "Got empty resource: ".concat(paramContext);
      }
      for (;;)
      {
        AppMethodBeat.o(61331);
        return null;
        new String("Got empty resource: ");
      }
    }
    zzse.put(paramString, paramContext);
    AppMethodBeat.o(61331);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ConnectionErrorMessages
 * JD-Core Version:    0.7.0.1
 */