package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ShareDialog$CameraEffectHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
{
  private ShareDialog$CameraEffectHandler(ShareDialog paramShareDialog)
  {
    super(paramShareDialog);
  }
  
  public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(97679);
    if (((paramShareContent instanceof ShareCameraEffectContent)) && (ShareDialog.access$500(paramShareContent.getClass())))
    {
      AppMethodBeat.o(97679);
      return true;
    }
    AppMethodBeat.o(97679);
    return false;
  }
  
  public AppCall createAppCall(final ShareContent paramShareContent)
  {
    AppMethodBeat.i(97680);
    ShareContentValidation.validateForNativeShare(paramShareContent);
    final AppCall localAppCall = this.this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
    {
      public Bundle getLegacyParameters()
      {
        AppMethodBeat.i(97678);
        Bundle localBundle = LegacyNativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
        AppMethodBeat.o(97678);
        return localBundle;
      }
      
      public Bundle getParameters()
      {
        AppMethodBeat.i(97677);
        Bundle localBundle = NativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
        AppMethodBeat.o(97677);
        return localBundle;
      }
    }, ShareDialog.access$800(paramShareContent.getClass()));
    AppMethodBeat.o(97680);
    return localAppCall;
  }
  
  public Object getMode()
  {
    return ShareDialog.Mode.NATIVE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.CameraEffectHandler
 * JD-Core Version:    0.7.0.1
 */