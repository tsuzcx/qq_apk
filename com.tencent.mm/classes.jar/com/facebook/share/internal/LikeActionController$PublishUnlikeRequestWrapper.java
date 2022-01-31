package com.facebook.share.internal;

import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeActionController$PublishUnlikeRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  private String unlikeToken;
  
  LikeActionController$PublishUnlikeRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, null, null);
    AppMethodBeat.i(97018);
    this.unlikeToken = paramString;
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, null, HttpMethod.DELETE));
    AppMethodBeat.o(97018);
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97019);
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error unliking object with unlike token '%s' : %s", new Object[] { this.unlikeToken, paramFacebookRequestError });
    LikeActionController.access$2400(this.this$0, "publish_unlike", paramFacebookRequestError);
    AppMethodBeat.o(97019);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.PublishUnlikeRequestWrapper
 * JD-Core Version:    0.7.0.1
 */