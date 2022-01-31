package com.facebook.share.widget;

import com.facebook.FacebookException;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeActionController.CreationCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeView$LikeActionControllerCreationCallback
  implements LikeActionController.CreationCallback
{
  private boolean isCancelled;
  
  private LikeView$LikeActionControllerCreationCallback(LikeView paramLikeView) {}
  
  public void cancel()
  {
    this.isCancelled = true;
  }
  
  public void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(97636);
    if (this.isCancelled)
    {
      AppMethodBeat.o(97636);
      return;
    }
    FacebookException localFacebookException = paramFacebookException;
    if (paramLikeActionController != null)
    {
      if (!paramLikeActionController.shouldEnableView()) {
        paramFacebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
      }
      LikeView.access$1100(this.this$0, paramLikeActionController);
      LikeView.access$700(this.this$0);
      localFacebookException = paramFacebookException;
    }
    if ((localFacebookException != null) && (LikeView.access$800(this.this$0) != null)) {
      LikeView.access$800(this.this$0).onError(localFacebookException);
    }
    LikeView.access$1202(this.this$0, null);
    AppMethodBeat.o(97636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.widget.LikeView.LikeActionControllerCreationCallback
 * JD-Core Version:    0.7.0.1
 */