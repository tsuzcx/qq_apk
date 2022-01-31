package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.widget.LikeView.ObjectType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

class LikeActionController$GetOGObjectIdRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  String verifiedObjectId;
  
  LikeActionController$GetOGObjectIdRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    AppMethodBeat.i(97001);
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "og_object.fields(id)");
    paramLikeActionController.putString("ids", paramString);
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", paramLikeActionController, HttpMethod.GET));
    AppMethodBeat.o(97001);
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97002);
    if (paramFacebookRequestError.getErrorMessage().contains("og_object"))
    {
      this.error = null;
      AppMethodBeat.o(97002);
      return;
    }
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
    AppMethodBeat.o(97002);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(97003);
    paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), this.objectId);
    if (paramGraphResponse != null)
    {
      paramGraphResponse = paramGraphResponse.optJSONObject("og_object");
      if (paramGraphResponse != null) {
        this.verifiedObjectId = paramGraphResponse.optString("id");
      }
    }
    AppMethodBeat.o(97003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetOGObjectIdRequestWrapper
 * JD-Core Version:    0.7.0.1
 */