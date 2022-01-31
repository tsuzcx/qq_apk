package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeActionController$7$1
  implements GraphRequestBatch.Callback
{
  LikeActionController$7$1(LikeActionController.7 param7, LikeActionController.PublishLikeRequestWrapper paramPublishLikeRequestWrapper) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(96991);
    LikeActionController.access$1802(this.this$1.this$0, false);
    if (this.val$likeRequest.getError() != null)
    {
      LikeActionController.access$1900(this.this$1.this$0, false);
      AppMethodBeat.o(96991);
      return;
    }
    LikeActionController.access$1102(this.this$1.this$0, Utility.coerceValueIfNullOrEmpty(this.val$likeRequest.unlikeToken, null));
    LikeActionController.access$2002(this.this$1.this$0, true);
    LikeActionController.access$1200(this.this$1.this$0).logSdkEvent("fb_like_control_did_like", null, this.this$1.val$analyticsParameters);
    LikeActionController.access$2100(this.this$1.this$0, this.this$1.val$analyticsParameters);
    AppMethodBeat.o(96991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.7.1
 * JD-Core Version:    0.7.0.1
 */