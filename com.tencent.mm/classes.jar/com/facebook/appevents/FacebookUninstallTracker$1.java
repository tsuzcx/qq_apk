package com.facebook.appevents;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class FacebookUninstallTracker$1
  implements Runnable
{
  FacebookUninstallTracker$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(71998);
    Object localObject = FacebookUninstallTracker.access$000(FacebookSdk.getApplicationId(), this.val$deviceToken);
    if (localObject != null)
    {
      localObject = ((GraphRequest)localObject).executeAndWait();
      try
      {
        JSONObject localJSONObject = ((GraphResponse)localObject).getJSONObject();
        if (localJSONObject != null)
        {
          if ((localJSONObject.has("success")) && (localJSONObject.getString("success").equals("true")))
          {
            FacebookUninstallTracker.access$100().edit().putString("uploaded_token", this.val$deviceToken).putBoolean("pre_track_uninstall_enabled", true).apply();
            AppMethodBeat.o(71998);
            return;
          }
          FacebookUninstallTracker.access$200();
          new StringBuilder("Error sending device token to Facebook: ").append(((GraphResponse)localObject).getError());
        }
        AppMethodBeat.o(71998);
        return;
      }
      catch (JSONException localJSONException)
      {
        FacebookUninstallTracker.access$200();
      }
    }
    AppMethodBeat.o(71998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.FacebookUninstallTracker.1
 * JD-Core Version:    0.7.0.1
 */