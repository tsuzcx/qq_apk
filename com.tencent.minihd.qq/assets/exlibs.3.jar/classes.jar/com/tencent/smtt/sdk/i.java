package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;

class i
  extends X5ProxyWebChromeClient
{
  private WebView a;
  private WebChromeClient b;
  
  public i(IX5WebChromeClient paramIX5WebChromeClient, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramIX5WebChromeClient);
    this.a = paramWebView;
    this.b = paramWebChromeClient;
  }
  
  public Bitmap getDefaultVideoPoster()
  {
    return this.b.getDefaultVideoPoster();
  }
  
  public void getVisitedHistory(android.webkit.ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    this.a.a(paramIX5WebViewBase);
    this.b.onCloseWindow(this.a);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return this.b.onConsoleMessage(paramConsoleMessage);
  }
  
  public boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    paramIX5WebViewBase = this.a;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.b());
        }
        paramMessage.sendToTarget();
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    return this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new a(paramQuotaUpdater));
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    this.b.onGeolocationPermissionsHidePrompt();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.b.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    this.b.onHideCustomView();
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.a.a(paramIX5WebViewBase);
    return this.b.onJsAlert(this.a, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.a.a(paramIX5WebViewBase);
    return this.b.onJsBeforeUnload(this.a, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.a.a(paramIX5WebViewBase);
    return this.b.onJsConfirm(this.a, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    this.a.a(paramIX5WebViewBase);
    return this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public boolean onJsTimeout()
  {
    return this.b.onJsTimeout();
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    this.a.a(paramIX5WebViewBase);
    this.b.onProgressChanged(this.a, paramInt);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new a(paramQuotaUpdater));
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedIcon(this.a, paramBitmap);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTitle(this.a, paramString);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    this.a.a(paramIX5WebViewBase);
    this.b.onRequestFocus(this.a);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.b.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.b.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, final android.webkit.ValueCallback<Uri[]> paramValueCallback, final IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    paramValueCallback = new ValueCallback()
    {
      public void a(Uri[] paramAnonymousArrayOfUri)
      {
        paramValueCallback.onReceiveValue(paramAnonymousArrayOfUri);
      }
    };
    paramFileChooserParams = new WebChromeClient.FileChooserParams()
    {
      public Intent createIntent()
      {
        return paramFileChooserParams.createIntent();
      }
      
      public String[] getAcceptTypes()
      {
        return paramFileChooserParams.getAcceptTypes();
      }
      
      public String getFilenameHint()
      {
        return paramFileChooserParams.getFilenameHint();
      }
      
      public int getMode()
      {
        return paramFileChooserParams.getMode();
      }
      
      public CharSequence getTitle()
      {
        return paramFileChooserParams.getTitle();
      }
      
      public boolean isCaptureEnabled()
      {
        return paramFileChooserParams.isCaptureEnabled();
      }
    };
    this.a.a(paramIX5WebViewBase);
    return this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(final android.webkit.ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.b.openFileChooser(new ValueCallback()
    {
      public void a(Uri paramAnonymousUri)
      {
        paramValueCallback.onReceiveValue(new Uri[] { paramAnonymousUri });
      }
    }, paramString1, paramString2);
  }
  
  class a
    implements WebStorage.QuotaUpdater
  {
    QuotaUpdater a;
    
    a(QuotaUpdater paramQuotaUpdater)
    {
      this.a = paramQuotaUpdater;
    }
    
    public void updateQuota(long paramLong)
    {
      this.a.updateQuota(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.i
 * JD-Core Version:    0.7.0.1
 */