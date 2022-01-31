package com.facebook.share.widget;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareStoryContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ShareDialog$ShareStoryHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
{
  private ShareDialog$ShareStoryHandler(ShareDialog paramShareDialog)
  {
    super(paramShareDialog);
  }
  
  public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(97697);
    if (((paramShareContent instanceof ShareStoryContent)) && (ShareDialog.access$500(paramShareContent.getClass())))
    {
      AppMethodBeat.o(97697);
      return true;
    }
    AppMethodBeat.o(97697);
    return false;
  }
  
  public AppCall createAppCall(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97698);
    ShareContentValidation.validateForStoryShare(paramShareContent);
    AppCall localAppCall = this.this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new ShareDialog.ShareStoryHandler.1(this, localAppCall, paramShareContent, this.this$0.getShouldFailOnDataError()), ShareDialog.access$800(paramShareContent.getClass()));
    AppMethodBeat.o(97698);
    return localAppCall;
  }
  
  public Object getMode()
  {
    return ShareDialog.Mode.NATIVE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.ShareStoryHandler
 * JD-Core Version:    0.7.0.1
 */