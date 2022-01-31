package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeActionController$9$1
  implements GraphRequestBatch.Callback
{
  LikeActionController$9$1(LikeActionController.9 param9, LikeActionController.LikeRequestWrapper paramLikeRequestWrapper, LikeActionController.GetEngagementRequestWrapper paramGetEngagementRequestWrapper) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(96994);
    if ((this.val$likeRequestWrapper.getError() != null) || (this.val$engagementRequest.getError() != null))
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Unable to refresh like state for id: '%s'", new Object[] { LikeActionController.access$2200(this.this$1.this$0) });
      AppMethodBeat.o(96994);
      return;
    }
    LikeActionController.access$1300(this.this$1.this$0, this.val$likeRequestWrapper.isObjectLiked(), this.val$engagementRequest.likeCountStringWithLike, this.val$engagementRequest.likeCountStringWithoutLike, this.val$engagementRequest.socialSentenceStringWithLike, this.val$engagementRequest.socialSentenceStringWithoutLike, this.val$likeRequestWrapper.getUnlikeToken());
    AppMethodBeat.o(96994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.9.1
 * JD-Core Version:    0.7.0.1
 */