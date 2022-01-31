package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

final class FetchedAppSettingsManager$1
  implements Runnable
{
  FetchedAppSettingsManager$1(Context paramContext, String paramString1, String paramString2) {}
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(72304);
    SharedPreferences localSharedPreferences = this.val$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
    Object localObject2 = localSharedPreferences.getString(this.val$settingsKey, null);
    Object localObject1 = localObject3;
    if (!Utility.isNullOrEmpty((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject1 = localObject3;
      if (localObject2 != null) {
        localObject1 = FetchedAppSettingsManager.access$000(this.val$applicationId, (JSONObject)localObject2);
      }
      localObject2 = FetchedAppSettingsManager.access$100(this.val$applicationId);
      if (localObject2 != null)
      {
        FetchedAppSettingsManager.access$000(this.val$applicationId, (JSONObject)localObject2);
        localSharedPreferences.edit().putString(this.val$settingsKey, ((JSONObject)localObject2).toString()).apply();
      }
      if (localObject1 != null)
      {
        localObject1 = ((FetchedAppSettings)localObject1).getSdkUpdateMessage();
        if ((!FetchedAppSettingsManager.access$200()) && (localObject1 != null) && (((String)localObject1).length() > 0))
        {
          FetchedAppSettingsManager.access$202(true);
          FetchedAppSettingsManager.access$300();
        }
      }
      AutomaticAnalyticsLogger.logActivateAppEvent();
      InAppPurchaseActivityLifecycleTracker.update();
      localObject2 = FetchedAppSettingsManager.access$500();
      if (FetchedAppSettingsManager.access$400().containsKey(this.val$applicationId))
      {
        localObject1 = FetchedAppSettingsManager.FetchAppSettingState.SUCCESS;
        ((AtomicReference)localObject2).set(localObject1);
        FetchedAppSettingsManager.access$600();
        AppMethodBeat.o(72304);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Utility.logd("FacebookSDK", localJSONException);
        localObject2 = null;
        continue;
        FetchedAppSettingsManager.FetchAppSettingState localFetchAppSettingState = FetchedAppSettingsManager.FetchAppSettingState.ERROR;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettingsManager.1
 * JD-Core Version:    0.7.0.1
 */