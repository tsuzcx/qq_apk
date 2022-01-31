package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebViewLoginMethodHandler$1
  implements WebDialog.OnCompleteListener
{
  WebViewLoginMethodHandler$1(WebViewLoginMethodHandler paramWebViewLoginMethodHandler, LoginClient.Request paramRequest) {}
  
  public void onComplete(Bundle paramBundle, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96930);
    this.this$0.onWebDialogComplete(this.val$request, paramBundle, paramFacebookException);
    AppMethodBeat.o(96930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.login.WebViewLoginMethodHandler.1
 * JD-Core Version:    0.7.0.1
 */