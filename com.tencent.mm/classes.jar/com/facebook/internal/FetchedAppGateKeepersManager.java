package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchedAppGateKeepersManager
{
  private static final String APPLICATION_DEVICE_ID = "device_id";
  private static final String APPLICATION_FIELDS = "fields";
  private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
  private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
  private static final String APPLICATION_GRAPH_DATA = "data";
  private static final String APPLICATION_PLATFORM = "platform";
  private static final String APPLICATION_SDK_VERSION = "sdk_version";
  public static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
  private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
  private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
  private static final String APP_PLATFORM = "android";
  private static final String TAG;
  private static final Map<String, JSONObject> fetchedAppGateKeepers;
  
  static
  {
    AppMethodBeat.i(17736);
    TAG = FetchedAppGateKeepersManager.class.getCanonicalName();
    fetchedAppGateKeepers = new ConcurrentHashMap();
    AppMethodBeat.o(17736);
  }
  
  private static JSONObject getAppGateKeepersQueryResponse(String paramString)
  {
    AppMethodBeat.i(17732);
    Bundle localBundle = new Bundle();
    AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
    String str2 = "";
    String str1 = str2;
    if (localAttributionIdentifiers != null)
    {
      str1 = str2;
      if (localAttributionIdentifiers.getAndroidAdvertiserId() != null) {
        str1 = localAttributionIdentifiers.getAndroidAdvertiserId();
      }
    }
    str2 = FacebookSdk.getSdkVersion();
    localBundle.putString("platform", "android");
    localBundle.putString("device_id", str1);
    localBundle.putString("sdk_version", str2);
    localBundle.putString("fields", "gatekeepers");
    paramString = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", new Object[] { paramString, "mobile_sdk_gk" }), null);
    paramString.setSkipClientToken(true);
    paramString.setParameters(localBundle);
    paramString = paramString.executeAndWait().getJSONObject();
    AppMethodBeat.o(17732);
    return paramString;
  }
  
  public static boolean getGateKeeperForKey(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(17731);
    if ((paramString2 == null) || (!fetchedAppGateKeepers.containsKey(paramString2)))
    {
      AppMethodBeat.o(17731);
      return paramBoolean;
    }
    paramBoolean = ((JSONObject)fetchedAppGateKeepers.get(paramString2)).optBoolean(paramString1, paramBoolean);
    AppMethodBeat.o(17731);
    return paramBoolean;
  }
  
  public static void loadAppGateKeepersAsync()
  {
    try
    {
      AppMethodBeat.i(17730);
      Context localContext = FacebookSdk.getApplicationContext();
      final String str1 = FacebookSdk.getApplicationId();
      final String str2 = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", new Object[] { str1 });
      FacebookSdk.getExecutor().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(17729);
          SharedPreferences localSharedPreferences = this.val$context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0);
          Object localObject1 = localSharedPreferences.getString(str2, null);
          if (!Utility.isNullOrEmpty((String)localObject1)) {}
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            if (localObject1 != null) {
              FetchedAppGateKeepersManager.access$000(str1, (JSONObject)localObject1);
            }
            localObject1 = FetchedAppGateKeepersManager.access$100(str1);
            if (localObject1 != null)
            {
              FetchedAppGateKeepersManager.access$000(str1, (JSONObject)localObject1);
              localSharedPreferences.edit().putString(str2, ((JSONObject)localObject1).toString()).apply();
            }
            AppMethodBeat.o(17729);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Utility.logd("FacebookSDK", localJSONException);
              Object localObject2 = null;
            }
          }
        }
      });
      AppMethodBeat.o(17730);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void parseAppGateKeepersFromJSON(String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(17733);
    JSONObject localJSONObject;
    if (fetchedAppGateKeepers.containsKey(paramString)) {
      localJSONObject = (JSONObject)fetchedAppGateKeepers.get(paramString);
    }
    for (;;)
    {
      Object localObject = paramJSONObject.optJSONArray("data");
      paramJSONObject = null;
      if (localObject != null) {
        paramJSONObject = ((JSONArray)localObject).optJSONObject(0);
      }
      if ((paramJSONObject != null) && (paramJSONObject.optJSONArray("gatekeepers") != null))
      {
        paramJSONObject = paramJSONObject.optJSONArray("gatekeepers");
        label75:
        if (i < paramJSONObject.length()) {
          try
          {
            localObject = paramJSONObject.getJSONObject(i);
            localJSONObject.put(((JSONObject)localObject).getString("key"), ((JSONObject)localObject).getBoolean("value"));
            i += 1;
            break label75;
            localJSONObject = new JSONObject();
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Utility.logd("FacebookSDK", localJSONException);
            }
          }
        }
      }
    }
    fetchedAppGateKeepers.put(paramString, localJSONObject);
    AppMethodBeat.o(17733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.FetchedAppGateKeepersManager
 * JD-Core Version:    0.7.0.1
 */