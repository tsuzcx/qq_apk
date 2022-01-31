package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler$2
  implements Utility.GraphMeRequestWithCacheCallback
{
  GetTokenLoginMethodHandler$2(GetTokenLoginMethodHandler paramGetTokenLoginMethodHandler, Bundle paramBundle, LoginClient.Request paramRequest) {}
  
  public void onFailure(FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96769);
    this.this$0.loginClient.complete(LoginClient.Result.createErrorResult(this.this$0.loginClient.getPendingRequest(), "Caught exception", paramFacebookException.getMessage()));
    AppMethodBeat.o(96769);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96768);
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      this.val$result.putString("com.facebook.platform.extra.USER_ID", paramJSONObject);
      this.this$0.onComplete(this.val$request, this.val$result);
      AppMethodBeat.o(96768);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.this$0.loginClient.complete(LoginClient.Result.createErrorResult(this.this$0.loginClient.getPendingRequest(), "Caught exception", paramJSONObject.getMessage()));
      AppMethodBeat.o(96768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.GetTokenLoginMethodHandler.2
 * JD-Core Version:    0.7.0.1
 */