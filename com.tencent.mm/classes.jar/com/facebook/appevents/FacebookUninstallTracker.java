package com.facebook.appevents;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;

public class FacebookUninstallTracker
{
  private static final String PLATFORM = "android";
  private static final String SUCCESS = "success";
  private static final String TAG;
  private static final String UPLOADED_TOKEN_STORE = "com.facebook.appevents.FacebookUninstallTracker.UPLOADED_TOKEN";
  private static final SharedPreferences uploadedTokenSharedPrefs;
  
  static
  {
    AppMethodBeat.i(72003);
    TAG = FacebookUninstallTracker.class.getCanonicalName();
    uploadedTokenSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.appevents.FacebookUninstallTracker.UPLOADED_TOKEN", 0);
    AppMethodBeat.o(72003);
  }
  
  private static GraphRequest buildPushDeviceTokenRequest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72001);
    GraphRequest localGraphRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_push_device_token", new Object[] { paramString1 }), null, null);
    localGraphRequest.setSkipClientToken(true);
    paramString1 = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
    if (paramString1 == null)
    {
      AppMethodBeat.o(72001);
      return null;
    }
    String str = paramString1.getAndroidAdvertiserId();
    Bundle localBundle = localGraphRequest.getParameters();
    paramString1 = localBundle;
    if (localBundle == null) {
      paramString1 = new Bundle();
    }
    paramString1.putString("device_id", str);
    paramString1.putString("device_token", paramString2);
    paramString1.putString("platform", "android");
    localGraphRequest.setParameters(paramString1);
    AppMethodBeat.o(72001);
    return localGraphRequest;
  }
  
  private static void sendToServer(String paramString)
  {
    AppMethodBeat.i(72000);
    FacebookSdk.getExecutor().execute(new FacebookUninstallTracker.1(paramString));
    AppMethodBeat.o(72000);
  }
  
  public static void updateDeviceToken(String paramString)
  {
    AppMethodBeat.i(71999);
    Object localObject = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
    if (localObject == null)
    {
      AppMethodBeat.o(71999);
      return;
    }
    boolean bool1 = ((FetchedAppSettings)localObject).getTrackUninstallEnabled();
    localObject = uploadedTokenSharedPrefs.getString("uploaded_token", null);
    boolean bool2 = uploadedTokenSharedPrefs.getBoolean("pre_track_uninstall_enabled", false);
    if ((bool1) && ((!bool2) || (!paramString.equals(localObject))))
    {
      sendToServer(paramString);
      AppMethodBeat.o(71999);
      return;
    }
    if ((!bool1) && (bool2)) {
      uploadedTokenSharedPrefs.edit().putBoolean("pre_track_uninstall_enabled", false).apply();
    }
    AppMethodBeat.o(71999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.FacebookUninstallTracker
 * JD-Core Version:    0.7.0.1
 */