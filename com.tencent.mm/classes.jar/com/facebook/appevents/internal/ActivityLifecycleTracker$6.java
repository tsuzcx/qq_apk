package com.facebook.appevents.internal;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

final class ActivityLifecycleTracker$6
  implements Runnable
{
  ActivityLifecycleTracker$6(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(72145);
    GraphRequest localGraphRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", new Object[] { this.val$applicationId }), null, null);
    Object localObject2 = localGraphRequest.getParameters();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
    JSONArray localJSONArray = new JSONArray();
    label110:
    label127:
    boolean bool;
    if (Build.MODEL != null)
    {
      localObject2 = Build.MODEL;
      localJSONArray.put(localObject2);
      if ((localAttributionIdentifiers == null) || (localAttributionIdentifiers.getAndroidAdvertiserId() == null)) {
        break label272;
      }
      localJSONArray.put(localAttributionIdentifiers.getAndroidAdvertiserId());
      localJSONArray.put("0");
      if (!AppEventUtility.isEmulator()) {
        break label283;
      }
      localObject2 = "1";
      localJSONArray.put(localObject2);
      localObject2 = Utility.getCurrentLocale();
      localJSONArray.put(((Locale)localObject2).getLanguage() + "_" + ((Locale)localObject2).getCountry());
      localObject2 = localJSONArray.toString();
      ((Bundle)localObject1).putString("device_session_id", ActivityLifecycleTracker.getCurrentDeviceSessionID());
      ((Bundle)localObject1).putString("extinfo", (String)localObject2);
      localGraphRequest.setParameters((Bundle)localObject1);
      if (localGraphRequest != null)
      {
        localObject1 = localGraphRequest.executeAndWait().getJSONObject();
        if ((localObject1 == null) || (!((JSONObject)localObject1).optBoolean("is_app_indexing_enabled", false))) {
          break label289;
        }
        bool = true;
        label231:
        ActivityLifecycleTracker.access$1002(Boolean.valueOf(bool));
        if (ActivityLifecycleTracker.access$1000().booleanValue()) {
          break label294;
        }
        ActivityLifecycleTracker.access$1102(null);
      }
    }
    for (;;)
    {
      ActivityLifecycleTracker.access$1302(Boolean.FALSE);
      AppMethodBeat.o(72145);
      return;
      localObject2 = "";
      break;
      label272:
      localJSONArray.put("");
      break label110;
      label283:
      localObject2 = "0";
      break label127;
      label289:
      bool = false;
      break label231;
      label294:
      ActivityLifecycleTracker.access$1200().schedule();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.6
 * JD-Core Version:    0.7.0.1
 */