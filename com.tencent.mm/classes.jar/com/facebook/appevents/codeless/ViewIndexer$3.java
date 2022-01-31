package com.facebook.appevents.codeless;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class ViewIndexer$3
  implements Runnable
{
  ViewIndexer$3(ViewIndexer paramViewIndexer, String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(72077);
    Object localObject1 = FacebookSdk.getApplicationId();
    String str = Utility.md5hash(this.val$tree);
    Object localObject2 = AccessToken.getCurrentAccessToken();
    if ((str != null) && (str.equals(ViewIndexer.access$400(this.this$0))))
    {
      AppMethodBeat.o(72077);
      return;
    }
    localObject1 = ViewIndexer.buildAppIndexingRequest(this.val$tree, (AccessToken)localObject2, (String)localObject1, "app_indexing");
    if (localObject1 != null)
    {
      localObject1 = ((GraphRequest)localObject1).executeAndWait();
      try
      {
        localObject2 = ((GraphResponse)localObject1).getJSONObject();
        if (localObject2 == null) {
          break label153;
        }
        if ((((JSONObject)localObject2).has("success")) && (((JSONObject)localObject2).getString("success") == "true"))
        {
          Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$100(), "Successfully send UI component tree to server");
          ViewIndexer.access$402(this.this$0, str);
        }
        if (!((JSONObject)localObject2).has("is_app_indexing_enabled")) {
          break label174;
        }
        ActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(((JSONObject)localObject2).getBoolean("is_app_indexing_enabled")));
        AppMethodBeat.o(72077);
        return;
      }
      catch (JSONException localJSONException)
      {
        ViewIndexer.access$100();
      }
    }
    else
    {
      AppMethodBeat.o(72077);
      return;
    }
    label153:
    ViewIndexer.access$100();
    new StringBuilder("Error sending UI component tree to Facebook: ").append(((GraphResponse)localObject1).getError());
    label174:
    AppMethodBeat.o(72077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.codeless.ViewIndexer.3
 * JD-Core Version:    0.7.0.1
 */