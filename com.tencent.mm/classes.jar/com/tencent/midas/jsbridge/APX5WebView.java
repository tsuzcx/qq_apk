package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.download.APMidasPluginDownloadUtils;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.lang.reflect.Method;

public class APX5WebView
{
  private static final String TAG = "APX5WebView";
  private IAPX5WebViewCallback callback;
  private WebChromeClient mChromeClient;
  private Activity mContext;
  private WebViewClient mWebViewClient;
  private WebView mWebview;
  
  public APX5WebView(Activity paramActivity, WebView paramWebView, IAPX5WebViewCallback paramIAPX5WebViewCallback)
  {
    AppMethodBeat.i(217009);
    this.mWebview = null;
    this.mContext = null;
    this.callback = null;
    this.mChromeClient = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(217075);
        APLog.e("inner onJsAlert message", paramAnonymousString2);
        APLog.e("APX5WebView", " url = ".concat(String.valueOf(paramAnonymousString1)));
        APLog.e("APX5WebView", " message = ".concat(String.valueOf(paramAnonymousString2)));
        if (APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(APX5WebView.this.mContext, paramAnonymousString2))
        {
          APLog.d("APX5WebView", "onJsAlert is pure h5 update! Cancel alert!");
          paramAnonymousJsResult.cancel();
          AppMethodBeat.o(217075);
          return true;
        }
        APLog.d("APX5WebView", "onJsAlert not pure h5 update!");
        if (APWebProtocol.hookH5Method(APX5WebView.this.mContext, APX5WebView.this.mWebview, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult, APX5WebView.this.callback))
        {
          APLog.d("APX5WebView", "hookH5Method is processed");
          paramAnonymousJsResult.cancel();
          AppMethodBeat.o(217075);
          return true;
        }
        if (APMidasPayAPI.h5PayHookX5(APX5WebView.this.mContext, APX5WebView.this.mWebview, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult) == 0)
        {
          APX5WebView.this.callback.WebChromeClientJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
          paramAnonymousJsResult.cancel();
          AppMethodBeat.o(217075);
          return true;
        }
        boolean bool = super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(217075);
        return bool;
      }
      
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(217083);
        boolean bool = APX5WebView.this.callback.WebChromeClientJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(217083);
        return bool;
      }
    };
    this.mWebViewClient = new WebViewClient()
    {
      private byte _hellAccFlag_;
      
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(217076);
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        APLog.d("APX5WebView", "onPageFinished!");
        APLog.i("APWebView url == ", paramAnonymousString);
        APX5WebView.this.mWebview.setVisibility(0);
        APMidasPayAPI.InnerH5PayInitX5(APX5WebView.this.mContext, APX5WebView.this.mWebview);
        APX5WebView.this.callback.WebViewClientPageFinished(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(217076);
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(217088);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        APLog.d("APX5WebView", "onPageStarted!");
        APX5WebView.this.callback.WebViewClientPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(217088);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(217100);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        APLog.d("APX5WebView", "onReceivedError!");
        APX5WebView.this.callback.WebViewClientReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(217100);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(217062);
        APLog.d("APX5WebView", "shouldOverrideUrlLoading url = ".concat(String.valueOf(paramAnonymousString)));
        if ((!paramAnonymousString.startsWith("http://unipay.sdk.android/?")) && (!paramAnonymousString.startsWith("wsj://")) && (!paramAnonymousString.startsWith("mqqapi://")) && (!paramAnonymousString.startsWith("weixin://")) && (!paramAnonymousString.startsWith("sms://")))
        {
          paramAnonymousWebView.loadUrl(paramAnonymousString);
          APLog.d("APX5WebView", "shouldOverrideUrlLoading loadUrl = ");
        }
        if ((paramAnonymousString.startsWith("mqqapi://")) || (paramAnonymousString.startsWith("weixin://")) || (paramAnonymousString.startsWith("sms://")))
        {
          paramAnonymousString = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
          if (paramAnonymousString.resolveActivity(APX5WebView.this.mContext.getPackageManager()) != null)
          {
            paramAnonymousWebView = paramAnonymousWebView.getContext();
            paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousWebView, paramAnonymousString.aYi(), "com/tencent/midas/jsbridge/APX5WebView$2", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousWebView.startActivity((Intent)paramAnonymousString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousWebView, "com/tencent/midas/jsbridge/APX5WebView$2", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(217062);
            return true;
          }
          Toast.makeText(APX5WebView.this.mContext, "抱歉，你未安装相应客户端", 1).show();
          APLog.w("APX5WebView", "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
          AppMethodBeat.o(217062);
          return true;
        }
        AppMethodBeat.o(217062);
        return true;
      }
    };
    this.mContext = paramActivity;
    this.mWebview = paramWebView;
    this.callback = paramIAPX5WebViewCallback;
    InitWebView();
    AppMethodBeat.o(217009);
  }
  
  private void InitWebView()
  {
    AppMethodBeat.i(217015);
    WebSettings localWebSettings = this.mWebview.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 19) {
      APMidasPayAPI.env.equals("test");
    }
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCachePath(this.mContext.getApplicationContext().getDir("cache", 0).getPath());
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setCacheMode(-1);
    this.mWebview.setScrollBarStyle(0);
    this.mWebview.setWebChromeClient(this.mChromeClient);
    this.mWebview.setWebViewClient(this.mWebViewClient);
    removeInterface();
    AppMethodBeat.o(217015);
  }
  
  private void removeInterface()
  {
    AppMethodBeat.i(217021);
    try
    {
      Method localMethod = this.mWebview.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
      {
        localMethod.invoke(this.mWebview, new Object[] { "searchBoxJavaBridge_" });
        localMethod.invoke(this.mWebview, new Object[] { "accessibility" });
        localMethod.invoke(this.mWebview, new Object[] { "accessibilityTraversal" });
      }
      AppMethodBeat.o(217021);
      return;
    }
    catch (Exception localException)
    {
      APLog.i("removeJavascriptInterface", localException.toString());
      AppMethodBeat.o(217021);
    }
  }
  
  public WebView getWebView()
  {
    return this.mWebview;
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(217057);
    this.mWebview.loadUrl(paramString);
    AppMethodBeat.o(217057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APX5WebView
 * JD-Core Version:    0.7.0.1
 */