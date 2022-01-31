package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ShareDialog$ShareStoryHandler$1
  implements DialogPresenter.ParameterProvider
{
  ShareDialog$ShareStoryHandler$1(ShareDialog.ShareStoryHandler paramShareStoryHandler, AppCall paramAppCall, ShareContent paramShareContent, boolean paramBoolean) {}
  
  public Bundle getLegacyParameters()
  {
    AppMethodBeat.i(97696);
    Bundle localBundle = LegacyNativeDialogParameters.create(this.val$appCall.getCallId(), this.val$content, this.val$shouldFailOnDataError);
    AppMethodBeat.o(97696);
    return localBundle;
  }
  
  public Bundle getParameters()
  {
    AppMethodBeat.i(97695);
    Bundle localBundle = NativeDialogParameters.create(this.val$appCall.getCallId(), this.val$content, this.val$shouldFailOnDataError);
    AppMethodBeat.o(97695);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.ShareStoryHandler.1
 * JD-Core Version:    0.7.0.1
 */