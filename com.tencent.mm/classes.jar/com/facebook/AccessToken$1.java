package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

final class AccessToken$1
  implements Utility.GraphMeRequestWithCacheCallback
{
  AccessToken$1(Bundle paramBundle, AccessToken.AccessTokenCreationCallback paramAccessTokenCreationCallback, String paramString) {}
  
  public final void onFailure(FacebookException paramFacebookException)
  {
    AppMethodBeat.i(71509);
    this.val$accessTokenCallback.onError(paramFacebookException);
    AppMethodBeat.o(71509);
  }
  
  public final void onSuccess(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71508);
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      this.val$extras.putString("user_id", paramJSONObject);
      this.val$accessTokenCallback.onSuccess(AccessToken.access$000(null, this.val$extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), this.val$applicationId));
      AppMethodBeat.o(71508);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.val$accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
      AppMethodBeat.o(71508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.AccessToken.1
 * JD-Core Version:    0.7.0.1
 */