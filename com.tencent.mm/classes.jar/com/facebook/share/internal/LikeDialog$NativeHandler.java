package com.facebook.share.internal;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeDialog$NativeHandler
  extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler
{
  private LikeDialog$NativeHandler(LikeDialog paramLikeDialog)
  {
    super(paramLikeDialog);
  }
  
  public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
  {
    return false;
  }
  
  public AppCall createAppCall(LikeContent paramLikeContent)
  {
    AppMethodBeat.i(97103);
    AppCall localAppCall = this.this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new LikeDialog.NativeHandler.1(this, paramLikeContent), LikeDialog.access$300());
    AppMethodBeat.o(97103);
    return localAppCall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.internal.LikeDialog.NativeHandler
 * JD-Core Version:    0.7.0.1
 */