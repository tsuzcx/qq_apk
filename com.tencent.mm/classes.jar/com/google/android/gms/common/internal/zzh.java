package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.f.m;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.internal.zzadf;
import com.google.android.gms.internal.zzadg;

public final class zzh
{
  private static final m<String, String> zzaFE = new m();
  
  private static String zzB(Context paramContext, String paramString)
  {
    int i;
    synchronized (zzaFE)
    {
      String str = (String)zzaFE.get(paramString);
      if (str != null) {
        return str;
      }
      paramContext = GooglePlayServicesUtil.getRemoteResource(paramContext);
      if (paramContext == null) {
        return null;
      }
      i = paramContext.getIdentifier(paramString, "string", "com.google.android.gms");
      if (i == 0)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0)
        {
          "Missing resource: ".concat(paramContext);
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
        return null;
        new String("Got empty resource: ");
      }
    }
    zzaFE.put(paramString, paramContext);
    return paramContext;
  }
  
  public static String zzaT(Context paramContext)
  {
    String str2 = paramContext.getApplicationInfo().name;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str2 = paramContext.getPackageName();
    }
    try
    {
      str1 = zzadg.zzbi(paramContext).zzdA(paramContext.getPackageName()).toString();
      return str1;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return str2;
  }
  
  public static String zzg(Context paramContext, int paramInt)
  {
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
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 16: 
    case 18: 
      return null;
    case 1: 
      return localResources.getString(R.string.common_google_play_services_install_title);
    case 3: 
      return localResources.getString(R.string.common_google_play_services_enable_title);
    case 2: 
      return localResources.getString(R.string.common_google_play_services_update_title);
    case 7: 
      return zzB(paramContext, "common_google_play_services_network_error_title");
    case 5: 
      return zzB(paramContext, "common_google_play_services_invalid_account_title");
    case 17: 
      return zzB(paramContext, "common_google_play_services_sign_in_failed_title");
    }
    return zzB(paramContext, "common_google_play_services_restricted_profile_title");
  }
  
  public static String zzh(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {}
    for (String str1 = zzB(paramContext, "common_google_play_services_resolution_required_title");; str1 = zzg(paramContext, paramInt))
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = paramContext.getResources().getString(R.string.common_google_play_services_notification_ticker);
      }
      return str2;
    }
  }
  
  public static String zzi(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str = zzaT(paramContext);
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
      return localResources.getString(R.string.common_google_play_services_unknown_issue, new Object[] { str });
    case 1: 
      return localResources.getString(R.string.common_google_play_services_install_text, new Object[] { str });
    case 3: 
      return localResources.getString(R.string.common_google_play_services_enable_text, new Object[] { str });
    case 18: 
      return localResources.getString(R.string.common_google_play_services_updating_text, new Object[] { str });
    case 2: 
      if (zzj.zzba(paramContext)) {
        return localResources.getString(R.string.common_google_play_services_wear_update_text);
      }
      return localResources.getString(R.string.common_google_play_services_update_text, new Object[] { str });
    case 9: 
      return localResources.getString(R.string.common_google_play_services_unsupported_text, new Object[] { str });
    case 7: 
      return zzo(paramContext, "common_google_play_services_network_error_text", str);
    case 5: 
      return zzo(paramContext, "common_google_play_services_invalid_account_text", str);
    case 16: 
      return zzo(paramContext, "common_google_play_services_api_unavailable_text", str);
    case 17: 
      return zzo(paramContext, "common_google_play_services_sign_in_failed_text", str);
    }
    return zzo(paramContext, "common_google_play_services_restricted_profile_text", str);
  }
  
  public static String zzj(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {
      return zzo(paramContext, "common_google_play_services_resolution_required_text", zzaT(paramContext));
    }
    return zzi(paramContext, paramInt);
  }
  
  public static String zzk(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      return paramContext.getString(17039370);
    case 1: 
      return paramContext.getString(R.string.common_google_play_services_install_button);
    case 3: 
      return paramContext.getString(R.string.common_google_play_services_enable_button);
    }
    return paramContext.getString(R.string.common_google_play_services_update_button);
  }
  
  private static String zzo(Context paramContext, String paramString1, String paramString2)
  {
    Resources localResources = paramContext.getResources();
    paramString1 = zzB(paramContext, paramString1);
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = localResources.getString(R.string.common_google_play_services_unknown_issue);
    }
    return String.format(localResources.getConfiguration().locale, paramContext, new Object[] { paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzh
 * JD-Core Version:    0.7.0.1
 */