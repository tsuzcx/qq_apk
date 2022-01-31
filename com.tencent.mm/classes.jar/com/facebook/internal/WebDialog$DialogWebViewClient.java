package com.facebook.internal;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebDialog$DialogWebViewClient
  extends WebViewClient
{
  private WebDialog$DialogWebViewClient(WebDialog paramWebDialog) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(96667);
    super.onPageFinished(paramWebView, paramString);
    if (!WebDialog.access$200(this.this$0)) {
      WebDialog.access$300(this.this$0).dismiss();
    }
    WebDialog.access$400(this.this$0).setBackgroundColor(0);
    WebDialog.access$500(this.this$0).setVisibility(0);
    WebDialog.access$600(this.this$0).setVisibility(0);
    WebDialog.access$702(this.this$0, true);
    AppMethodBeat.o(96667);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(96666);
    Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: ".concat(String.valueOf(paramString)));
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (!WebDialog.access$200(this.this$0)) {
      WebDialog.access$300(this.this$0).show();
    }
    AppMethodBeat.o(96666);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96664);
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.this$0.sendErrorToListener(new FacebookDialogException(paramString1, paramInt, paramString2));
    AppMethodBeat.o(96664);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(96665);
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    paramSslErrorHandler.cancel();
    this.this$0.sendErrorToListener(new FacebookDialogException(null, -11, null));
    AppMethodBeat.o(96665);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(96663);
    Utility.logd("FacebookSDK.WebDialog", "Redirect URL: ".concat(String.valueOf(paramString)));
    Bundle localBundle;
    Object localObject;
    if (paramString.startsWith(WebDialog.access$100(this.this$0)))
    {
      localBundle = this.this$0.parseResponseUri(paramString);
      paramWebView = localBundle.getString("error");
      paramString = paramWebView;
      if (paramWebView == null) {
        paramString = localBundle.getString("error_type");
      }
      localObject = localBundle.getString("error_msg");
      paramWebView = (WebView)localObject;
      if (localObject == null) {
        paramWebView = localBundle.getString("error_message");
      }
      localObject = paramWebView;
      if (paramWebView == null) {
        localObject = localBundle.getString("error_description");
      }
      paramWebView = localBundle.getString("error_code");
      if (Utility.isNullOrEmpty(paramWebView)) {
        break label326;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramWebView);
        if ((Utility.isNullOrEmpty(paramString)) && (Utility.isNullOrEmpty((String)localObject)) && (i == -1))
        {
          this.this$0.sendSuccessToListener(localBundle);
          AppMethodBeat.o(96663);
          return true;
        }
      }
      catch (NumberFormatException paramWebView)
      {
        i = -1;
        continue;
        if ((paramString != null) && ((paramString.equals("access_denied")) || (paramString.equals("OAuthAccessDeniedException"))))
        {
          this.this$0.cancel();
          continue;
        }
        if (i == 4201)
        {
          this.this$0.cancel();
          continue;
        }
        paramWebView = new FacebookRequestError(i, paramString, (String)localObject);
        this.this$0.sendErrorToListener(new FacebookServiceException(paramWebView, (String)localObject));
        continue;
      }
      if (paramString.startsWith("fbconnect://cancel"))
      {
        this.this$0.cancel();
        AppMethodBeat.o(96663);
        return true;
      }
      if (paramString.contains("touch"))
      {
        AppMethodBeat.o(96663);
        return false;
      }
      try
      {
        this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        AppMethodBeat.o(96663);
        return true;
      }
      catch (ActivityNotFoundException paramWebView)
      {
        AppMethodBeat.o(96663);
        return false;
      }
      label326:
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.WebDialog.DialogWebViewClient
 * JD-Core Version:    0.7.0.1
 */