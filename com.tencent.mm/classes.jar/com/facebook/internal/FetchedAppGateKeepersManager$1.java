package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class FetchedAppGateKeepersManager$1
  implements Runnable
{
  FetchedAppGateKeepersManager$1(Context paramContext, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(72293);
    SharedPreferences localSharedPreferences = this.val$context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0);
    Object localObject1 = localSharedPreferences.getString(this.val$gateKeepersKey, null);
    if (!Utility.isNullOrEmpty((String)localObject1)) {}
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      if (localObject1 != null) {
        FetchedAppGateKeepersManager.access$000(this.val$applicationId, (JSONObject)localObject1);
      }
      localObject1 = FetchedAppGateKeepersManager.access$100(this.val$applicationId);
      if (localObject1 != null)
      {
        FetchedAppGateKeepersManager.access$000(this.val$applicationId, (JSONObject)localObject1);
        localSharedPreferences.edit().putString(this.val$gateKeepersKey, ((JSONObject)localObject1).toString()).apply();
      }
      AppMethodBeat.o(72293);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.FetchedAppGateKeepersManager.1
 * JD-Core Version:    0.7.0.1
 */