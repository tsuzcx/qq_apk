package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

final class AppEventsLogger$4
  implements Runnable
{
  AppEventsLogger$4(Bundle paramBundle, String paramString, GraphRequest.Callback paramCallback) {}
  
  public final void run()
  {
    AppMethodBeat.i(71909);
    Object localObject2 = AppEventsLogger.getUserID();
    if ((localObject2 == null) || (((String)localObject2).isEmpty()))
    {
      Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.access$200(), "AppEventsLogger userID cannot be null or empty");
      AppMethodBeat.o(71909);
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("user_unique_id", (String)localObject2);
    ((Bundle)localObject1).putBundle("custom_data", this.val$parameters);
    localObject2 = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
    if ((localObject2 != null) && (((AttributionIdentifiers)localObject2).getAndroidAdvertiserId() != null)) {
      ((Bundle)localObject1).putString("advertiser_id", ((AttributionIdentifiers)localObject2).getAndroidAdvertiserId());
    }
    localObject2 = new Bundle();
    try
    {
      localObject1 = BundleJSONConverter.convertToJSON((Bundle)localObject1);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localObject1);
      ((Bundle)localObject2).putString("data", localJSONArray.toString());
      localObject1 = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", new Object[] { this.val$applicationID }), (Bundle)localObject2, HttpMethod.POST, this.val$callback);
      ((GraphRequest)localObject1).setSkipClientToken(true);
      ((GraphRequest)localObject1).executeAsync();
      AppMethodBeat.o(71909);
      return;
    }
    catch (JSONException localJSONException)
    {
      FacebookException localFacebookException = new FacebookException("Failed to construct request", localJSONException);
      AppMethodBeat.o(71909);
      throw localFacebookException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.4
 * JD-Core Version:    0.7.0.1
 */