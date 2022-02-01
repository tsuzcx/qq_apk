package com.tencent.midas.jsbridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.download.APMidasPluginDownloadUtils;
import java.io.File;
import java.lang.reflect.Method;

public class APWebView
{
  private static final String TAG = "APWebView";
  private IAPWebViewCallback callback;
  private WebChromeClient mChromeClient;
  private Activity mContext;
  private WebViewClient mWebViewClient;
  private WebView mWebview;
  
  public APWebView(Activity paramActivity, WebView paramWebView, IAPWebViewCallback paramIAPWebViewCallback)
  {
    AppMethodBeat.i(253159);
    this.mWebview = null;
    this.mContext = null;
    this.callback = null;
    this.mChromeClient = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(253088);
        APLog.e("inner onJsAlert message", paramAnonymousString2);
        APLog.e("APWebView", " url = ".concat(String.valueOf(paramAnonymousString1)));
        APLog.e("APWebView", " message = ".concat(String.valueOf(paramAnonymousString2)));
        if (APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(APWebView.this.mContext, paramAnonymousString2))
        {
          APLog.d("APWebView", "onJsAlert is pure h5 update! Cancel alert!");
          paramAnonymousJsResult.cancel();
          AppMethodBeat.o(253088);
          return true;
        }
        APLog.d("APWebView", "onJsAlert not pure h5 update!");
        if (APWebProtocol.hookH5Method(APWebView.this.mContext, APWebView.this.mWebview, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult, APWebView.this.callback))
        {
          APLog.d("APWebView", "hookH5Method is processed");
          paramAnonymousJsResult.cancel();
          AppMethodBeat.o(253088);
          return true;
        }
        if (APMidasPayAPI.h5PayHook(APWebView.this.mContext, APWebView.this.mWebview, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult) == 0)
        {
          APWebView.this.callback.WebChromeClientJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
          paramAnonymousJsResult.cancel();
          AppMethodBeat.o(253088);
          return true;
        }
        boolean bool = super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(253088);
        return bool;
      }
      
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(253089);
        boolean bool = APWebView.this.callback.WebChromeClientJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(253089);
        return bool;
      }
    };
    this.mWebViewClient = new WebViewClient()
    {
      private byte _hellAccFlag_;
      
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(253151);
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        APLog.d("APWebView", "onPageFinished!");
        APLog.i("APWebView url == ", paramAnonymousString);
        APWebView.this.mWebview.setVisibility(0);
        APMidasPayAPI.InnerH5PayInit(APWebView.this.mContext, APWebView.this.mWebview);
        APWebView.this.callback.WebViewClientPageFinished(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(253151);
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(253152);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        APLog.d("APWebView", "onPageStarted!");
        APWebView.this.callback.WebViewClientPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(253152);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(253154);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        APLog.d("APWebView", "onReceivedError!");
        APWebView.this.callback.WebViewClientReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(253154);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(253149);
        APLog.d("APWebView", "shouldOverrideUrlLoading url = ".concat(String.valueOf(paramAnonymousString)));
        if ((!paramAnonymousString.startsWith("http://unipay.sdk.android/?")) && (!paramAnonymousString.startsWith("wsj://")) && (!paramAnonymousString.startsWith("mqqapi://")) && (!paramAnonymousString.startsWith("weixin://")) && (!paramAnonymousString.startsWith("sms://")))
        {
          paramAnonymousWebView.loadUrl(paramAnonymousString);
          APLog.d("APWebView", "shouldOverrideUrlLoading loadUrl = ");
        }
        if ((paramAnonymousString.startsWith("mqqapi://")) || (paramAnonymousString.startsWith("weixin://")) || (paramAnonymousString.startsWith("sms://")))
        {
          paramAnonymousString = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
          if (paramAnonymousString.resolveActivity(APWebView.this.mContext.getPackageManager()) != null)
          {
            paramAnonymousWebView = paramAnonymousWebView.getContext();
            paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousString);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousWebView, paramAnonymousString.aFh(), "com/tencent/midas/jsbridge/APWebView$2", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousWebView.startActivity((Intent)paramAnonymousString.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousWebView, "com/tencent/midas/jsbridge/APWebView$2", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(253149);
            return true;
          }
          Toast.makeText(APWebView.this.mContext, "抱歉，你未安装相应客户端", 1).show();
          APLog.w("APWebView", "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
          AppMethodBeat.o(253149);
          return false;
        }
        AppMethodBeat.o(253149);
        return true;
      }
    };
    this.mContext = paramActivity;
    this.mWebview = paramWebView;
    this.callback = paramIAPWebViewCallback;
    InitWebView();
    AppMethodBeat.o(253159);
  }
  
  @SuppressLint({"NewApi"})
  private void InitWebView()
  {
    AppMethodBeat.i(253160);
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
    AppMethodBeat.o(253160);
  }
  
  private void removeInterface()
  {
    AppMethodBeat.i(253161);
    try
    {
      Method localMethod = this.mWebview.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
      {
        localMethod.invoke(this.mWebview, new Object[] { "searchBoxJavaBridge_" });
        localMethod.invoke(this.mWebview, new Object[] { "accessibility" });
        localMethod.invoke(this.mWebview, new Object[] { "accessibilityTraversal" });
      }
      AppMethodBeat.o(253161);
      return;
    }
    catch (Exception localException)
    {
      APLog.i("removeJavascriptInterface", localException.toString());
      AppMethodBeat.o(253161);
    }
  }
  
  public WebView getWebView()
  {
    return this.mWebview;
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(253164);
    this.mWebview.loadUrl(paramString);
    AppMethodBeat.o(253164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APWebView
 * JD-Core Version:    0.7.0.1
 */