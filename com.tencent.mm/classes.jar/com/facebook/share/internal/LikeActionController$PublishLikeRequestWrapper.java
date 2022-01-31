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

class LikeActionController$PublishLikeRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  String unlikeToken;
  
  LikeActionController$PublishLikeRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    AppMethodBeat.i(97015);
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("object", paramString);
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", paramLikeActionController, HttpMethod.POST));
    AppMethodBeat.o(97015);
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97017);
    if (paramFacebookRequestError.getErrorCode() == 3501)
    {
      this.error = null;
      AppMethodBeat.o(97017);
      return;
    }
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error liking object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
    LikeActionController.access$2400(this.this$0, "publish_like", paramFacebookRequestError);
    AppMethodBeat.o(97017);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(97016);
    this.unlikeToken = Utility.safeGetStringFromResponse(paramGraphResponse.getJSONObject(), "id");
    AppMethodBeat.o(97016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.PublishLikeRequestWrapper
 * JD-Core Version:    0.7.0.1
 */