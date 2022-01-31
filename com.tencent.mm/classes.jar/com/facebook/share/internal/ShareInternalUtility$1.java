package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareInternalUtility$1
  extends ResultProcessor
{
  ShareInternalUtility$1(FacebookCallback paramFacebookCallback1, FacebookCallback paramFacebookCallback2)
  {
    super(paramFacebookCallback1);
  }
  
  public final void onCancel(AppCall paramAppCall)
  {
    AppMethodBeat.i(97256);
    ShareInternalUtility.invokeOnCancelCallback(this.val$callback);
    AppMethodBeat.o(97256);
  }
  
  public final void onError(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(97257);
    ShareInternalUtility.invokeOnErrorCallback(this.val$callback, paramFacebookException);
    AppMethodBeat.o(97257);
  }
  
  public final void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    AppMethodBeat.i(97255);
    if (paramBundle != null)
    {
      paramAppCall = ShareInternalUtility.getNativeDialogCompletionGesture(paramBundle);
      if ((paramAppCall == null) || ("post".equalsIgnoreCase(paramAppCall)))
      {
        paramAppCall = ShareInternalUtility.getShareDialogPostId(paramBundle);
        ShareInternalUtility.invokeOnSuccessCallback(this.val$callback, paramAppCall);
        AppMethodBeat.o(97255);
        return;
      }
      if ("cancel".equalsIgnoreCase(paramAppCall))
      {
        ShareInternalUtility.invokeOnCancelCallback(this.val$callback);
        AppMethodBeat.o(97255);
        return;
      }
      ShareInternalUtility.invokeOnErrorCallback(this.val$callback, new FacebookException("UnknownError"));
    }
    AppMethodBeat.o(97255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.1
 * JD-Core Version:    0.7.0.1
 */