package com.facebook.share.widget;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ShareDialog$FeedHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
{
  private ShareDialog$FeedHandler(ShareDialog paramShareDialog)
  {
    super(paramShareDialog);
  }
  
  public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
  {
    return ((paramShareContent instanceof ShareLinkContent)) || ((paramShareContent instanceof ShareFeedContent));
  }
  
  public AppCall createAppCall(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97683);
    ShareDialog.access$700(this.this$0, ShareDialog.access$1100(this.this$0), paramShareContent, ShareDialog.Mode.FEED);
    AppCall localAppCall = this.this$0.createBaseAppCall();
    if ((paramShareContent instanceof ShareLinkContent))
    {
      paramShareContent = (ShareLinkContent)paramShareContent;
      ShareContentValidation.validateForWebShare(paramShareContent);
    }
    for (paramShareContent = WebDialogParameters.createForFeed(paramShareContent);; paramShareContent = WebDialogParameters.createForFeed((ShareFeedContent)paramShareContent))
    {
      DialogPresenter.setupAppCallForWebDialog(localAppCall, "feed", paramShareContent);
      AppMethodBeat.o(97683);
      return localAppCall;
    }
  }
  
  public Object getMode()
  {
    return ShareDialog.Mode.FEED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.FeedHandler
 * JD-Core Version:    0.7.0.1
 */