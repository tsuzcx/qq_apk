package com.facebook.share.widget;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareStoryContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ShareDialog$NativeHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
{
  private ShareDialog$NativeHandler(ShareDialog paramShareDialog)
  {
    super(paramShareDialog);
  }
  
  public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(97691);
    if ((paramShareContent == null) || ((paramShareContent instanceof ShareCameraEffectContent)) || ((paramShareContent instanceof ShareStoryContent)))
    {
      AppMethodBeat.o(97691);
      return false;
    }
    if (!paramBoolean) {
      if (paramShareContent.getShareHashtag() != null)
      {
        paramBoolean = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
        bool = paramBoolean;
        if ((paramShareContent instanceof ShareLinkContent))
        {
          bool = paramBoolean;
          if (Utility.isNullOrEmpty(((ShareLinkContent)paramShareContent).getQuote())) {}
        }
      }
    }
    for (boolean bool = paramBoolean & DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);; bool = true)
    {
      if ((bool) && (ShareDialog.access$500(paramShareContent.getClass())))
      {
        AppMethodBeat.o(97691);
        return true;
      }
      AppMethodBeat.o(97691);
      return false;
      paramBoolean = true;
      break;
    }
  }
  
  public AppCall createAppCall(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97692);
    ShareDialog.access$700(this.this$0, ShareDialog.access$600(this.this$0), paramShareContent, ShareDialog.Mode.NATIVE);
    ShareContentValidation.validateForNativeShare(paramShareContent);
    AppCall localAppCall = this.this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new ShareDialog.NativeHandler.1(this, localAppCall, paramShareContent, this.this$0.getShouldFailOnDataError()), ShareDialog.access$800(paramShareContent.getClass()));
    AppMethodBeat.o(97692);
    return localAppCall;
  }
  
  public Object getMode()
  {
    return ShareDialog.Mode.NATIVE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.NativeHandler
 * JD-Core Version:    0.7.0.1
 */