package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.o;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient
  extends android.webkit.WebViewClient
{
  private static String c = null;
  private WebViewClient a;
  private WebView b;
  
  SystemWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.b = paramWebView;
    this.a = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.b.a(paramWebView);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.b.a(paramWebView);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    this.b.a(paramWebView);
    this.a.onLoadResource(this.b, paramString);
  }
  
  public void onPageCommitVisible(android.webkit.WebView paramWebView, String paramString)
  {
    this.b.a(paramWebView);
    this.a.onPageCommitVisible(this.b, paramString);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    if (c == null)
    {
      localObject = o.a();
      if (localObject != null)
      {
        ((o)localObject).a(true);
        c = Boolean.toString(true);
      }
    }
    this.b.a(paramWebView);
    Object localObject = this.b;
    ((WebView)localObject).a += 1;
    this.a.onPageFinished(this.b, paramString);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      this.b.a(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.c();
    if ((!TbsShareManager.mHasQueryed) && (this.b.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.b.getContext())))
    {
      TbsShareManager.mHasQueryed = true;
      new Thread(new Runnable()
      {
        public void run()
        {
          if ((!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.a(SystemWebViewClient.this).getContext())) && (TbsDownloader.needDownload(SystemWebViewClient.a(SystemWebViewClient.this).getContext(), false))) {
            TbsDownloader.startDownload(SystemWebViewClient.a(SystemWebViewClient.this).getContext());
          }
        }
      }).start();
    }
    if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
    {
      TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
      TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.b.a(paramWebView);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, android.webkit.ClientCertRequest paramClientCertRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.a(paramWebView);
      paramWebView = new a(paramClientCertRequest);
      this.a.onReceivedClientCertRequest(this.b, paramWebView);
    }
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.b.a(paramWebView);
    this.a.onReceivedError(this.b, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, final android.webkit.WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    this.b.a(paramWebView);
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new f(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new com.tencent.smtt.export.external.interfaces.WebResourceError()
        {
          public CharSequence getDescription()
          {
            return paramWebResourceError.getDescription();
          }
          
          public int getErrorCode()
          {
            return paramWebResourceError.getErrorCode();
          }
        };
      }
      this.a.onReceivedError(this.b, paramWebView, paramWebResourceRequest);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, android.webkit.HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.b.a(paramWebView);
    this.a.onReceivedHttpAuthRequest(this.b, new b(paramHttpAuthHandler), paramString1, paramString2);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.b.a(paramWebView);
    paramWebView = new f(paramWebResourceRequest);
    paramWebResourceRequest = new g(paramWebResourceResponse);
    this.a.onReceivedHttpError(this.b, paramWebView, paramWebResourceRequest);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.b.a(paramWebView);
      this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
    }
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, android.webkit.SslErrorHandler paramSslErrorHandler, android.net.http.SslError paramSslError)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.b.a(paramWebView);
      this.a.onReceivedSslError(this.b, new c(paramSslErrorHandler), new d(paramSslError));
    }
  }
  
  public boolean onRenderProcessGone(android.webkit.WebView paramWebView, final RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    this.b.a(paramWebView);
    this.a.onRenderProcessGone(this.b, new WebViewClient.RenderProcessGoneDetail()
    {
      public boolean didCrash()
      {
        return paramRenderProcessGoneDetail.didCrash();
      }
    });
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.b.a(paramWebView);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.b.a(paramWebView);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.b.a(paramWebView);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
  }
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramWebView = null;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramWebView;
        if (paramWebResourceRequest == null) {
          return null;
        }
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          paramWebView = i.a(paramWebResourceRequest, "isRedirect");
          bool1 = bool2;
          if ((paramWebView instanceof Boolean)) {
            bool1 = ((Boolean)paramWebView).booleanValue();
          }
        }
        paramWebView = new e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
        paramWebView = this.a.shouldInterceptRequest(this.b, paramWebView);
        if (paramWebView == null) {
          return null;
        }
        paramWebResourceRequest = new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
        paramWebResourceRequest.setResponseHeaders(paramWebView.getResponseHeaders());
        i = paramWebView.getStatusCode();
        str = paramWebView.getReasonPhrase();
        if (i != paramWebResourceRequest.getStatusCode()) {
          break;
        }
        paramWebView = paramWebResourceRequest;
      } while (str == null);
      paramWebView = paramWebResourceRequest;
    } while (str.equals(paramWebResourceRequest.getReasonPhrase()));
    paramWebResourceRequest.setStatusCodeAndReasonPhrase(i, str);
    return paramWebResourceRequest;
  }
  
  @TargetApi(11)
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return null;
      paramWebView = this.a.shouldInterceptRequest(this.b, paramString);
    } while (paramWebView == null);
    return new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.b.a(paramWebView);
    return this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWebResourceRequest != null)
    {
      localObject1 = localObject2;
      if (paramWebResourceRequest.getUrl() != null) {
        localObject1 = paramWebResourceRequest.getUrl().toString();
      }
    }
    if ((localObject1 == null) || (this.b.showDebugView((String)localObject1))) {
      return true;
    }
    this.b.a(paramWebView);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = i.a(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    return this.a.shouldOverrideUrlLoading(this.b, paramWebView);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    if ((paramString == null) || (this.b.showDebugView(paramString))) {
      return true;
    }
    this.b.a(paramWebView);
    return this.a.shouldOverrideUrlLoading(this.b, paramString);
  }
  
  private static class a
    extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
  {
    private android.webkit.ClientCertRequest a;
    
    public a(android.webkit.ClientCertRequest paramClientCertRequest)
    {
      this.a = paramClientCertRequest;
    }
    
    public void cancel()
    {
      this.a.cancel();
    }
    
    public String getHost()
    {
      return this.a.getHost();
    }
    
    public String[] getKeyTypes()
    {
      return this.a.getKeyTypes();
    }
    
    public int getPort()
    {
      return this.a.getPort();
    }
    
    public Principal[] getPrincipals()
    {
      return this.a.getPrincipals();
    }
    
    public void ignore()
    {
      this.a.ignore();
    }
    
    public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
    {
      this.a.proceed(paramPrivateKey, paramArrayOfX509Certificate);
    }
  }
  
  private static class b
    implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
  {
    private android.webkit.HttpAuthHandler a;
    
    b(android.webkit.HttpAuthHandler paramHttpAuthHandler)
    {
      this.a = paramHttpAuthHandler;
    }
    
    public void cancel()
    {
      this.a.cancel();
    }
    
    public void proceed(String paramString1, String paramString2)
    {
      this.a.proceed(paramString1, paramString2);
    }
    
    public boolean useHttpAuthUsernamePassword()
    {
      return this.a.useHttpAuthUsernamePassword();
    }
  }
  
  private static class c
    implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
  {
    android.webkit.SslErrorHandler a;
    
    c(android.webkit.SslErrorHandler paramSslErrorHandler)
    {
      this.a = paramSslErrorHandler;
    }
    
    public void cancel()
    {
      this.a.cancel();
    }
    
    public void proceed()
    {
      this.a.proceed();
    }
  }
  
  private static class d
    implements com.tencent.smtt.export.external.interfaces.SslError
  {
    android.net.http.SslError a;
    
    d(android.net.http.SslError paramSslError)
    {
      this.a = paramSslError;
    }
    
    public boolean addError(int paramInt)
    {
      return this.a.addError(paramInt);
    }
    
    public SslCertificate getCertificate()
    {
      return this.a.getCertificate();
    }
    
    public int getPrimaryError()
    {
      return this.a.getPrimaryError();
    }
    
    public String getUrl()
    {
      return this.a.getUrl();
    }
    
    public boolean hasError(int paramInt)
    {
      return this.a.hasError(paramInt);
    }
  }
  
  static class e
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    private String a;
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private Map<String, String> f;
    
    public e(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, Map<String, String> paramMap)
    {
      this.a = paramString1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      this.e = paramString2;
      this.f = paramMap;
    }
    
    public String getMethod()
    {
      return this.e;
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.f;
    }
    
    public Uri getUrl()
    {
      return Uri.parse(this.a);
    }
    
    public boolean hasGesture()
    {
      return this.d;
    }
    
    public boolean isForMainFrame()
    {
      return this.b;
    }
    
    public boolean isRedirect()
    {
      return this.c;
    }
  }
  
  private static class f
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    android.webkit.WebResourceRequest a;
    
    f(android.webkit.WebResourceRequest paramWebResourceRequest)
    {
      this.a = paramWebResourceRequest;
    }
    
    public String getMethod()
    {
      return this.a.getMethod();
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.a.getRequestHeaders();
    }
    
    public Uri getUrl()
    {
      return this.a.getUrl();
    }
    
    public boolean hasGesture()
    {
      return this.a.hasGesture();
    }
    
    public boolean isForMainFrame()
    {
      return this.a.isForMainFrame();
    }
    
    public boolean isRedirect()
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        Object localObject = i.a(this.a, "isRedirect");
        if ((localObject instanceof Boolean)) {
          return ((Boolean)localObject).booleanValue();
        }
      }
      return false;
    }
  }
  
  private static class g
    extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
  {
    android.webkit.WebResourceResponse a;
    
    public g(android.webkit.WebResourceResponse paramWebResourceResponse)
    {
      this.a = paramWebResourceResponse;
    }
    
    public InputStream getData()
    {
      return this.a.getData();
    }
    
    public String getEncoding()
    {
      return this.a.getEncoding();
    }
    
    public String getMimeType()
    {
      return this.a.getMimeType();
    }
    
    public String getReasonPhrase()
    {
      return this.a.getReasonPhrase();
    }
    
    public Map<String, String> getResponseHeaders()
    {
      return this.a.getResponseHeaders();
    }
    
    public int getStatusCode()
    {
      return this.a.getStatusCode();
    }
    
    public void setData(InputStream paramInputStream)
    {
      this.a.setData(paramInputStream);
    }
    
    public void setEncoding(String paramString)
    {
      this.a.setEncoding(paramString);
    }
    
    public void setMimeType(String paramString)
    {
      this.a.setMimeType(paramString);
    }
    
    public void setResponseHeaders(Map<String, String> paramMap)
    {
      this.a.setResponseHeaders(paramMap);
    }
    
    public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
    {
      this.a.setStatusCodeAndReasonPhrase(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient
 * JD-Core Version:    0.7.0.1
 */