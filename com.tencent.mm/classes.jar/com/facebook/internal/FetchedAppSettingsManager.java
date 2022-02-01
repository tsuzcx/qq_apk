package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FetchedAppSettingsManager
{
  private static final String ADVERTISER_ID_KEY = "advertiser_id";
  private static final String APPLICATION_FIELDS = "fields";
  private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
  private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
  private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
  private static final String APP_SETTING_APP_EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
  private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
  private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
  private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
  private static final String APP_SETTING_CUSTOM_TABS_ENABLED = "gdpv4_chrome_custom_tabs_enabled";
  private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
  private static final String[] APP_SETTING_FIELDS;
  private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
  private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
  private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
  private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
  private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
  private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
  private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
  private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
  private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
  private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
  private static final String TAG;
  private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
  private static final Map<String, FetchedAppSettings> fetchedAppSettings;
  private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks;
  private static boolean isUnityInit;
  private static final AtomicReference<FetchedAppSettingsManager.FetchAppSettingState> loadingState;
  private static boolean printedSDKUpdatedMessage;
  private static JSONArray unityEventBindings;
  
  static
  {
    AppMethodBeat.i(17758);
    TAG = FetchedAppSettingsManager.class.getSimpleName();
    APP_SETTING_FIELDS = new String[] { "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "auto_event_setup_enabled", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url" };
    fetchedAppSettings = new ConcurrentHashMap();
    loadingState = new AtomicReference(FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED);
    fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue();
    printedSDKUpdatedMessage = false;
    isUnityInit = false;
    unityEventBindings = null;
    AppMethodBeat.o(17758);
  }
  
  public static void getAppSettingsAsync(FetchedAppSettingsCallback paramFetchedAppSettingsCallback)
  {
    AppMethodBeat.i(17748);
    fetchedAppSettingsCallbacks.add(paramFetchedAppSettingsCallback);
    loadAppSettingsAsync();
    AppMethodBeat.o(17748);
  }
  
  private static JSONObject getAppSettingsQueryResponse(String paramString)
  {
    AppMethodBeat.i(17753);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(APP_SETTING_FIELDS))));
    AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
    if ((localAttributionIdentifiers != null) && (localAttributionIdentifiers.getAndroidAdvertiserId() != null)) {
      localBundle.putString("advertiser_id", localAttributionIdentifiers.getAndroidAdvertiserId());
    }
    paramString = GraphRequest.newGraphPathRequest(null, paramString, null);
    paramString.setSkipClientToken(true);
    paramString.setParameters(localBundle);
    paramString = paramString.executeAndWait().getJSONObject();
    AppMethodBeat.o(17753);
    return paramString;
  }
  
  public static FetchedAppSettings getAppSettingsWithoutQuery(String paramString)
  {
    AppMethodBeat.i(17747);
    if (paramString != null)
    {
      paramString = (FetchedAppSettings)fetchedAppSettings.get(paramString);
      AppMethodBeat.o(17747);
      return paramString;
    }
    AppMethodBeat.o(17747);
    return null;
  }
  
  public static void loadAppSettingsAsync()
  {
    AppMethodBeat.i(17746);
    Context localContext = FacebookSdk.getApplicationContext();
    final String str1 = FacebookSdk.getApplicationId();
    if (Utility.isNullOrEmpty(str1))
    {
      loadingState.set(FetchedAppSettingsManager.FetchAppSettingState.ERROR);
      pollCallbacks();
      AppMethodBeat.o(17746);
      return;
    }
    if (fetchedAppSettings.containsKey(str1))
    {
      loadingState.set(FetchedAppSettingsManager.FetchAppSettingState.SUCCESS);
      pollCallbacks();
      AppMethodBeat.o(17746);
      return;
    }
    if ((loadingState.compareAndSet(FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED, FetchedAppSettingsManager.FetchAppSettingState.LOADING)) || (loadingState.compareAndSet(FetchedAppSettingsManager.FetchAppSettingState.ERROR, FetchedAppSettingsManager.FetchAppSettingState.LOADING))) {}
    for (int i = 1; i == 0; i = 0)
    {
      pollCallbacks();
      AppMethodBeat.o(17746);
      return;
    }
    final String str2 = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[] { str1 });
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(17740);
        SharedPreferences localSharedPreferences = this.val$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        Object localObject2 = localSharedPreferences.getString(str2, null);
        Object localObject1 = localObject3;
        if (!Utility.isNullOrEmpty((String)localObject2)) {}
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = FetchedAppSettingsManager.access$000(str1, (JSONObject)localObject2);
          }
          localObject2 = FetchedAppSettingsManager.access$100(str1);
          if (localObject2 != null)
          {
            FetchedAppSettingsManager.access$000(str1, (JSONObject)localObject2);
            localSharedPreferences.edit().putString(str2, ((JSONObject)localObject2).toString()).apply();
          }
          if (localObject1 != null)
          {
            localObject1 = ((FetchedAppSettings)localObject1).getSdkUpdateMessage();
            if ((!FetchedAppSettingsManager.printedSDKUpdatedMessage) && (localObject1 != null) && (((String)localObject1).length() > 0)) {
              FetchedAppSettingsManager.access$202(true);
            }
          }
          AutomaticAnalyticsLogger.logActivateAppEvent();
          InAppPurchaseActivityLifecycleTracker.update();
          localObject2 = FetchedAppSettingsManager.loadingState;
          if (FetchedAppSettingsManager.fetchedAppSettings.containsKey(str1))
          {
            localObject1 = FetchedAppSettingsManager.FetchAppSettingState.SUCCESS;
            ((AtomicReference)localObject2).set(localObject1);
            FetchedAppSettingsManager.access$600();
            AppMethodBeat.o(17740);
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
    });
    AppMethodBeat.o(17746);
  }
  
  private static FetchedAppSettings parseAppSettingsFromJSON(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17751);
    Object localObject = paramJSONObject.optJSONArray("android_sdk_error_categories");
    boolean bool1;
    label41:
    boolean bool2;
    label51:
    boolean bool3;
    if (localObject == null)
    {
      localObject = FacebookRequestErrorClassification.getDefaultErrorClassification();
      int i = paramJSONObject.optInt("app_events_feature_bitmask", 0);
      if ((i & 0x8) == 0) {
        break label238;
      }
      bool1 = true;
      if ((i & 0x10) == 0) {
        break label243;
      }
      bool2 = true;
      if ((i & 0x20) == 0) {
        break label249;
      }
      bool3 = true;
      label61:
      if ((i & 0x100) == 0) {
        break label255;
      }
    }
    label238:
    label243:
    label249:
    label255:
    for (boolean bool4 = true;; bool4 = false)
    {
      boolean bool5 = paramJSONObject.optBoolean("auto_event_setup_enabled", false);
      JSONArray localJSONArray = paramJSONObject.optJSONArray("auto_event_mapping_android");
      unityEventBindings = localJSONArray;
      if ((localJSONArray != null) && (InternalSettings.isUnityApp())) {
        UnityReflection.sendEventMapping(localJSONArray.toString());
      }
      paramJSONObject = new FetchedAppSettings(paramJSONObject.optBoolean("supports_implicit_sdk_logging", false), paramJSONObject.optString("gdpv4_nux_content", ""), paramJSONObject.optBoolean("gdpv4_nux_enabled", false), paramJSONObject.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), paramJSONObject.optInt("app_events_session_timeout", Constants.getDefaultAppEventsSessionTimeoutInSeconds()), SmartLoginOption.parseOptions(paramJSONObject.optLong("seamless_login")), parseDialogConfigurations(paramJSONObject.optJSONObject("android_dialog_configs")), bool1, (FacebookRequestErrorClassification)localObject, paramJSONObject.optString("smart_login_bookmark_icon_url"), paramJSONObject.optString("smart_login_menu_icon_url"), bool2, bool3, localJSONArray, paramJSONObject.optString("sdk_update_message"), bool4, bool5);
      fetchedAppSettings.put(paramString, paramJSONObject);
      AppMethodBeat.o(17751);
      return paramJSONObject;
      localObject = FacebookRequestErrorClassification.createFromJSON((JSONArray)localObject);
      break;
      bool1 = false;
      break label41;
      bool2 = false;
      break label51;
      bool3 = false;
      break label61;
    }
  }
  
  private static Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17754);
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("data");
      if (localJSONArray != null)
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          FetchedAppSettings.DialogFeatureConfig localDialogFeatureConfig = FetchedAppSettings.DialogFeatureConfig.parseDialogConfig(localJSONArray.optJSONObject(i));
          if (localDialogFeatureConfig != null)
          {
            String str = localDialogFeatureConfig.getDialogName();
            Map localMap = (Map)localHashMap.get(str);
            paramJSONObject = localMap;
            if (localMap == null)
            {
              paramJSONObject = new HashMap();
              localHashMap.put(str, paramJSONObject);
            }
            paramJSONObject.put(localDialogFeatureConfig.getFeatureName(), localDialogFeatureConfig);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(17754);
    return localHashMap;
  }
  
  private static void pollCallbacks()
  {
    for (;;)
    {
      Object localObject2;
      Handler localHandler;
      try
      {
        AppMethodBeat.i(17749);
        FetchedAppSettingsManager.FetchAppSettingState localFetchAppSettingState = (FetchedAppSettingsManager.FetchAppSettingState)loadingState.get();
        if ((FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED.equals(localFetchAppSettingState)) || (FetchedAppSettingsManager.FetchAppSettingState.LOADING.equals(localFetchAppSettingState)))
        {
          AppMethodBeat.o(17749);
          return;
        }
        localObject2 = FacebookSdk.getApplicationId();
        localObject2 = (FetchedAppSettings)fetchedAppSettings.get(localObject2);
        localHandler = new Handler(Looper.getMainLooper());
        if (!FetchedAppSettingsManager.FetchAppSettingState.ERROR.equals(localFetchAppSettingState)) {
          break label135;
        }
        if (!fetchedAppSettingsCallbacks.isEmpty())
        {
          localHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(17741);
              this.val$callback.onError();
              AppMethodBeat.o(17741);
            }
          });
          continue;
        }
        AppMethodBeat.o(17749);
      }
      finally {}
      continue;
      label135:
      while (!fetchedAppSettingsCallbacks.isEmpty()) {
        localHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(17742);
            this.val$callback.onSuccess(this.val$appSettings);
            AppMethodBeat.o(17742);
          }
        });
      }
      AppMethodBeat.o(17749);
    }
  }
  
  public static FetchedAppSettings queryAppSettings(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(17750);
    if ((!paramBoolean) && (fetchedAppSettings.containsKey(paramString)))
    {
      paramString = (FetchedAppSettings)fetchedAppSettings.get(paramString);
      AppMethodBeat.o(17750);
      return paramString;
    }
    Object localObject = getAppSettingsQueryResponse(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(17750);
      return null;
    }
    localObject = parseAppSettingsFromJSON(paramString, (JSONObject)localObject);
    if (paramString.equals(FacebookSdk.getApplicationId()))
    {
      loadingState.set(FetchedAppSettingsManager.FetchAppSettingState.SUCCESS);
      pollCallbacks();
    }
    AppMethodBeat.o(17750);
    return localObject;
  }
  
  public static void setIsUnityInit(boolean paramBoolean)
  {
    AppMethodBeat.i(17752);
    isUnityInit = paramBoolean;
    if ((unityEventBindings != null) && (isUnityInit)) {
      UnityReflection.sendEventMapping(unityEventBindings.toString());
    }
    AppMethodBeat.o(17752);
  }
  
  public static abstract interface FetchedAppSettingsCallback
  {
    public abstract void onError();
    
    public abstract void onSuccess(FetchedAppSettings paramFetchedAppSettings);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettingsManager
 * JD-Core Version:    0.7.0.1
 */