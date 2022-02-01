package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

class SystemWebChromeClient
  extends android.webkit.WebChromeClient
{
  protected WebChromeClient a;
  private WebView b;
  
  SystemWebChromeClient(WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    this.b = paramWebView;
    this.a = paramWebChromeClient;
  }
  
  @TargetApi(7)
  public Bitmap getDefaultVideoPoster()
  {
    Bitmap localBitmap2 = this.a.getDefaultVideoPoster();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = localBitmap2;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        localBitmap1 = BitmapFactory.decodeResource(this.b.getResources(), 17301540);
      }
      return localBitmap1;
    }
    catch (Exception localException) {}
    return localBitmap2;
  }
  
  @TargetApi(7)
  public View getVideoLoadingProgressView()
  {
    return this.a.getVideoLoadingProgressView();
  }
  
  public void getVisitedHistory(final android.webkit.ValueCallback<String[]> paramValueCallback)
  {
    this.a.getVisitedHistory(new ValueCallback()
    {
      public void a(String[] paramAnonymousArrayOfString)
      {
        paramValueCallback.onReceiveValue(paramAnonymousArrayOfString);
      }
    });
  }
  
  public void onCloseWindow(android.webkit.WebView paramWebView)
  {
    this.b.a(paramWebView);
    this.a.onCloseWindow(this.b);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    this.a.onConsoleMessage(new a(paramString1, paramString2, paramInt));
  }
  
  public boolean onConsoleMessage(android.webkit.ConsoleMessage paramConsoleMessage)
  {
    return this.a.onConsoleMessage(new a(paramConsoleMessage));
  }
  
  public boolean onCreateWindow(final android.webkit.WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    paramWebView = this.b;
    paramWebView.getClass();
    paramWebView = new WebView.WebViewTransport(paramWebView);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        WebView localWebView = paramWebView.getWebView();
        if (localWebView != null) {
          ((android.webkit.WebView.WebViewTransport)paramMessage.obj).setWebView(localWebView.a());
        }
        paramMessage.sendToTarget();
      }
    });
    paramMessage.obj = paramWebView;
    return this.a.onCreateWindow(this.b, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  @Deprecated
  @TargetApi(5)
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.a.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new f(paramQuotaUpdater));
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsHidePrompt()
  {
    this.a.onGeolocationPermissionsHidePrompt();
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    this.a.onGeolocationPermissionsShowPrompt(paramString, new c(paramCallback));
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    this.b.a(paramWebView);
    return this.a.onJsAlert(this.b, paramString1, paramString2, new e(paramJsResult));
  }
  
  public boolean onJsBeforeUnload(android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    this.b.a(paramWebView);
    return this.a.onJsBeforeUnload(this.b, paramString1, paramString2, new e(paramJsResult));
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    this.b.a(paramWebView);
    return this.a.onJsConfirm(this.b, paramString1, paramString2, new e(paramJsResult));
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, android.webkit.JsPromptResult paramJsPromptResult)
  {
    this.b.a(paramWebView);
    return this.a.onJsPrompt(this.b, paramString1, paramString2, paramString3, new d(paramJsPromptResult));
  }
  
  @TargetApi(7)
  public boolean onJsTimeout()
  {
    return this.a.onJsTimeout();
  }
  
  public void onPermissionRequest(final android.webkit.PermissionRequest paramPermissionRequest)
  {
    this.a.onPermissionRequest(new com.tencent.smtt.export.external.interfaces.PermissionRequest()
    {
      public void deny()
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramPermissionRequest.deny();
        }
      }
      
      public Uri getOrigin()
      {
        if (Build.VERSION.SDK_INT >= 21) {
          return paramPermissionRequest.getOrigin();
        }
        return null;
      }
      
      public String[] getResources()
      {
        if (Build.VERSION.SDK_INT >= 21) {
          return paramPermissionRequest.getResources();
        }
        return new String[0];
      }
      
      public void grant(String[] paramAnonymousArrayOfString)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramPermissionRequest.grant(paramAnonymousArrayOfString);
        }
      }
    });
  }
  
  public void onPermissionRequestCanceled(final android.webkit.PermissionRequest paramPermissionRequest)
  {
    this.a.onPermissionRequestCanceled(new com.tencent.smtt.export.external.interfaces.PermissionRequest()
    {
      public void deny()
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramPermissionRequest.deny();
        }
      }
      
      public Uri getOrigin()
      {
        if (Build.VERSION.SDK_INT >= 21) {
          return paramPermissionRequest.getOrigin();
        }
        return null;
      }
      
      public String[] getResources()
      {
        if (Build.VERSION.SDK_INT >= 21) {
          return paramPermissionRequest.getResources();
        }
        return new String[0];
      }
      
      public void grant(String[] paramAnonymousArrayOfString)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramPermissionRequest.grant(paramAnonymousArrayOfString);
        }
      }
    });
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    this.b.a(paramWebView);
    this.a.onProgressChanged(this.b, paramInt);
  }
  
  @Deprecated
  @TargetApi(7)
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.a.onReachedMaxAppCacheSize(paramLong1, paramLong2, new f(paramQuotaUpdater));
  }
  
  public void onReceivedIcon(android.webkit.WebView paramWebView, Bitmap paramBitmap)
  {
    this.b.a(paramWebView);
    this.a.onReceivedIcon(this.b, paramBitmap);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    this.b.a(paramWebView);
    this.a.onReceivedTitle(this.b, paramString);
  }
  
  @TargetApi(7)
  public void onReceivedTouchIconUrl(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.b.a(paramWebView);
    this.a.onReceivedTouchIconUrl(this.b, paramString, paramBoolean);
  }
  
  public void onRequestFocus(android.webkit.WebView paramWebView)
  {
    this.b.a(paramWebView);
    this.a.onRequestFocus(this.b);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, final android.webkit.ValueCallback<Uri[]> paramValueCallback, final android.webkit.WebChromeClient.FileChooserParams paramFileChooserParams)
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
    this.b.a(paramWebView);
    return this.a.onShowFileChooser(this.b, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(android.webkit.ValueCallback<Uri> paramValueCallback)
  {
    openFileChooser(paramValueCallback, null, null);
  }
  
  public void openFileChooser(android.webkit.ValueCallback<Uri> paramValueCallback, String paramString)
  {
    openFileChooser(paramValueCallback, paramString, null);
  }
  
  public void openFileChooser(final android.webkit.ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.a.openFileChooser(new ValueCallback()
    {
      public void a(Uri paramAnonymousUri)
      {
        paramValueCallback.onReceiveValue(paramAnonymousUri);
      }
    }, paramString1, paramString2);
  }
  
  public void setupAutoFill(Message paramMessage) {}
  
  private static class a
    implements com.tencent.smtt.export.external.interfaces.ConsoleMessage
  {
    private com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel a;
    private String b;
    private String c;
    private int d;
    
    a(android.webkit.ConsoleMessage paramConsoleMessage)
    {
      this.a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.valueOf(paramConsoleMessage.messageLevel().name());
      this.b = paramConsoleMessage.message();
      this.c = paramConsoleMessage.sourceId();
      this.d = paramConsoleMessage.lineNumber();
    }
    
    a(String paramString1, String paramString2, int paramInt)
    {
      this.a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.LOG;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramInt;
    }
    
    public int lineNumber()
    {
      return this.d;
    }
    
    public String message()
    {
      return this.b;
    }
    
    public com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel messageLevel()
    {
      return this.a;
    }
    
    public String sourceId()
    {
      return this.c;
    }
  }
  
  class b
    implements IX5WebChromeClient.CustomViewCallback
  {
    WebChromeClient.CustomViewCallback a;
    
    b(WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      this.a = paramCustomViewCallback;
    }
    
    public void onCustomViewHidden()
    {
      this.a.onCustomViewHidden();
    }
  }
  
  class c
    implements GeolocationPermissionsCallback
  {
    GeolocationPermissions.Callback a;
    
    c(GeolocationPermissions.Callback paramCallback)
    {
      this.a = paramCallback;
    }
    
    public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a.invoke(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  private class d
    implements com.tencent.smtt.export.external.interfaces.JsPromptResult
  {
    android.webkit.JsPromptResult a;
    
    d(android.webkit.JsPromptResult paramJsPromptResult)
    {
      this.a = paramJsPromptResult;
    }
    
    public void cancel()
    {
      this.a.cancel();
    }
    
    public void confirm()
    {
      this.a.confirm();
    }
    
    public void confirm(String paramString)
    {
      this.a.confirm(paramString);
    }
  }
  
  private class e
    implements com.tencent.smtt.export.external.interfaces.JsResult
  {
    android.webkit.JsResult a;
    
    e(android.webkit.JsResult paramJsResult)
    {
      this.a = paramJsResult;
    }
    
    public void cancel()
    {
      this.a.cancel();
    }
    
    public void confirm()
    {
      this.a.confirm();
    }
  }
  
  class f
    implements WebStorage.QuotaUpdater
  {
    android.webkit.WebStorage.QuotaUpdater a;
    
    f(android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
    {
      this.a = paramQuotaUpdater;
    }
    
    public void updateQuota(long paramLong)
    {
      this.a.updateQuota(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient
 * JD-Core Version:    0.7.0.1
 */