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
import java.util.Locale;
import org.json.JSONObject;

class LikeActionController$GetEngagementRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  String likeCountStringWithLike;
  String likeCountStringWithoutLike;
  String socialSentenceStringWithLike;
  String socialSentenceStringWithoutLike;
  
  LikeActionController$GetEngagementRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    AppMethodBeat.i(96998);
    this.likeCountStringWithLike = LikeActionController.access$700(this.this$0);
    this.likeCountStringWithoutLike = LikeActionController.access$800(this.this$0);
    this.socialSentenceStringWithLike = LikeActionController.access$900(this.this$0);
    this.socialSentenceStringWithoutLike = LikeActionController.access$1000(this.this$0);
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
    paramLikeActionController.putString("locale", Locale.getDefault().toString());
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, paramLikeActionController, HttpMethod.GET));
    AppMethodBeat.o(96998);
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(97000);
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error fetching engagement for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
    LikeActionController.access$2400(this.this$0, "get_engagement", paramFacebookRequestError);
    AppMethodBeat.o(97000);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96999);
    paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), "engagement");
    if (paramGraphResponse != null)
    {
      this.likeCountStringWithLike = paramGraphResponse.optString("count_string_with_like", this.likeCountStringWithLike);
      this.likeCountStringWithoutLike = paramGraphResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
      this.socialSentenceStringWithLike = paramGraphResponse.optString("social_sentence_with_like", this.socialSentenceStringWithLike);
      this.socialSentenceStringWithoutLike = paramGraphResponse.optString("social_sentence_without_like", this.socialSentenceStringWithoutLike);
    }
    AppMethodBeat.o(96999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetEngagementRequestWrapper
 * JD-Core Version:    0.7.0.1
 */