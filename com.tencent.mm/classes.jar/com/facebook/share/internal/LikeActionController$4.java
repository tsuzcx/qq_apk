package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LikeActionController$4
  implements Runnable
{
  LikeActionController$4(LikeActionController.CreationCallback paramCreationCallback, LikeActionController paramLikeActionController, FacebookException paramFacebookException) {}
  
  public final void run()
  {
    AppMethodBeat.i(96986);
    this.val$callback.onComplete(this.val$controller, this.val$error);
    AppMethodBeat.o(96986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.4
 * JD-Core Version:    0.7.0.1
 */