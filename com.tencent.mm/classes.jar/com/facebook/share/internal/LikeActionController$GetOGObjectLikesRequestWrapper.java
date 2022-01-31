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
import org.json.JSONObject;

class LikeActionController$GetOGObjectLikesRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
  implements LikeActionController.LikeRequestWrapper
{
  private final String objectId;
  private boolean objectIsLiked;
  private final LikeView.ObjectType objectType;
  private String unlikeToken;
  
  LikeActionController$GetOGObjectLikesRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    AppMethodBeat.i(97004);
    this.objectIsLiked = LikeActionController.access$2500(this.this$0);
    this.objectId = paramString;
    this.objectType = paramObjectType;
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "id,application");
    paramLikeActionController.putString("object", this.objectId);
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", paramLikeActionController, HttpMethod.GET));
    AppMethodBeat.o(97004);
  }
  
  public String getUnlikeToken()
  {
    return this.unlikeToken;
  }
  
  public boolean isObjectLiked()
  {
    return this.objectIsLiked;
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97006);
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error fetching like status for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
    LikeActionController.access$2400(this.this$0, "get_og_object_like", paramFacebookRequestError);
    AppMethodBeat.o(97006);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(97005);
    paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
    if (paramGraphResponse != null)
    {
      int i = 0;
      while (i < paramGraphResponse.length())
      {
        JSONObject localJSONObject1 = paramGraphResponse.optJSONObject(i);
        if (localJSONObject1 != null)
        {
          this.objectIsLiked = true;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("application");
          AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
          if ((localJSONObject2 != null) && (AccessToken.isCurrentAccessTokenActive()) && (Utility.areObjectsEqual(localAccessToken.getApplicationId(), localJSONObject2.optString("id")))) {
            this.unlikeToken = localJSONObject1.optString("id");
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(97005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetOGObjectLikesRequestWrapper
 * JD-Core Version:    0.7.0.1
 */