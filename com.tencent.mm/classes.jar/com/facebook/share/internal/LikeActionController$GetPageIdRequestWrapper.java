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

class LikeActionController$GetPageIdRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  boolean objectIsPage;
  String verifiedObjectId;
  
  LikeActionController$GetPageIdRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    AppMethodBeat.i(97007);
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "id");
    paramLikeActionController.putString("ids", paramString);
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", paramLikeActionController, HttpMethod.GET));
    AppMethodBeat.o(97007);
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97009);
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
    AppMethodBeat.o(97009);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(97008);
    paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), this.objectId);
    if (paramGraphResponse != null)
    {
      this.verifiedObjectId = paramGraphResponse.optString("id");
      if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      this.objectIsPage = bool;
      AppMethodBeat.o(97008);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetPageIdRequestWrapper
 * JD-Core Version:    0.7.0.1
 */