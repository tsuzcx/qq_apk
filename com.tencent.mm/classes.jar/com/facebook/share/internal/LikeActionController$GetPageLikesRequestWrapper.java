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
import org.json.JSONArray;

class LikeActionController$GetPageLikesRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
  implements LikeActionController.LikeRequestWrapper
{
  private boolean objectIsLiked;
  private String pageId;
  
  LikeActionController$GetPageLikesRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString, LikeView.ObjectType.PAGE);
    AppMethodBeat.i(97010);
    this.objectIsLiked = LikeActionController.access$2500(this.this$0);
    this.pageId = paramString;
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "id");
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/".concat(String.valueOf(paramString)), paramLikeActionController, HttpMethod.GET));
    AppMethodBeat.o(97010);
  }
  
  public String getUnlikeToken()
  {
    return null;
  }
  
  public boolean isObjectLiked()
  {
    return this.objectIsLiked;
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97012);
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error fetching like status for page id '%s': %s", new Object[] { this.pageId, paramFacebookRequestError });
    LikeActionController.access$2400(this.this$0, "get_page_like", paramFacebookRequestError);
    AppMethodBeat.o(97012);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(97011);
    paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
    if ((paramGraphResponse != null) && (paramGraphResponse.length() > 0)) {
      this.objectIsLiked = true;
    }
    AppMethodBeat.o(97011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetPageLikesRequestWrapper
 * JD-Core Version:    0.7.0.1
 */