package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeActionController$8
  implements GraphRequestBatch.Callback
{
  LikeActionController$8(LikeActionController paramLikeActionController, LikeActionController.PublishUnlikeRequestWrapper paramPublishUnlikeRequestWrapper, Bundle paramBundle) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(96993);
    LikeActionController.access$1802(this.this$0, false);
    if (this.val$unlikeRequest.getError() != null)
    {
      LikeActionController.access$1900(this.this$0, true);
      AppMethodBeat.o(96993);
      return;
    }
    LikeActionController.access$1102(this.this$0, null);
    LikeActionController.access$2002(this.this$0, false);
    LikeActionController.access$1200(this.this$0).logSdkEvent("fb_like_control_did_unlike", null, this.val$analyticsParameters);
    LikeActionController.access$2100(this.this$0, this.val$analyticsParameters);
    AppMethodBeat.o(96993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.8
 * JD-Core Version:    0.7.0.1
 */