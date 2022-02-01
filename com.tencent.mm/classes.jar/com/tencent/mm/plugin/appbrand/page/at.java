package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URL;
import java.util.Map;

@JgClassChecked(author=10, fComment="checked", lastDate="20180817", reviewer=10, vComment={com.jg.EType.HTTPSCHECK})
public final class at
  extends WebView
  implements ay
{
  private WebViewClient cgX;
  private WebChromeClient cgY;
  private String mUserAgent;
  private ak mhM;
  private Animator mhN;
  private ap miI;
  private am miJ;
  private d miK;
  
  public at(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public at(Context paramContext, ak paramak)
  {
    super(paramContext);
    AppMethodBeat.i(135258);
    this.cgX = new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(135254);
        at.a(at.this).cF(paramAnonymousString);
        AppMethodBeat.o(135254);
      }
      
      public final void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(135253);
        at.a(at.this);
        AppMethodBeat.o(135253);
      }
      
      public final void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(135255);
        if (paramAnonymousSslError.getPrimaryError() == 3)
        {
          if (at.a(at.this).a(paramAnonymousSslError.getCertificate()))
          {
            paramAnonymousSslErrorHandler.proceed();
            AppMethodBeat.o(135255);
            return;
          }
          paramAnonymousSslErrorHandler.cancel();
          AppMethodBeat.o(135255);
          return;
        }
        paramAnonymousSslErrorHandler.cancel();
        AppMethodBeat.o(135255);
      }
      
      public final WebResourceResponse shouldInterceptRequest(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(135257);
        if (Build.VERSION.SDK_INT < 21)
        {
          AppMethodBeat.o(135257);
          return null;
        }
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (bu.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(135257);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = at.a(at.this).Ue(paramAnonymousWebView);
        AppMethodBeat.o(135257);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(135256);
        if (bu.isNullOrNil(paramAnonymousString))
        {
          AppMethodBeat.o(135256);
          return null;
        }
        paramAnonymousWebView = at.a(at.this).Ue(paramAnonymousString);
        AppMethodBeat.o(135256);
        return paramAnonymousWebView;
      }
      
      public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return true;
      }
    };
    this.cgY = new DefaultWebViewImpl.4(this);
    this.mhM = paramak;
    getSettings().setDomStorageEnabled(true);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      getSettings().setMixedContentMode(0);
    }
    getSettings().setUserAgentString(getSettings().getUserAgentString() + "/ DEMO");
    this.mUserAgent = getSettings().getUserAgentString();
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setWebViewClient(this.cgX);
    setWebChromeClient(this.cgY);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(135258);
  }
  
  public final void Dq()
  {
    AppMethodBeat.i(135273);
    super.scrollTo(getScrollX(), 0);
    AppMethodBeat.o(135273);
  }
  
  public final boolean Dr()
  {
    AppMethodBeat.i(135275);
    if (getWebScrollY() == 0)
    {
      AppMethodBeat.o(135275);
      return true;
    }
    AppMethodBeat.o(135275);
    return false;
  }
  
  public final boolean Ds()
  {
    return false;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(135266);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(135266);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(135267);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(135267);
  }
  
  public final void ax(Context paramContext)
  {
    AppMethodBeat.i(135259);
    if (!(getContext() instanceof MutableContextWrapper))
    {
      AppMethodBeat.o(135259);
      return;
    }
    ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    AppMethodBeat.o(135259);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(135260);
    draw(paramCanvas);
    AppMethodBeat.o(135260);
    return true;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(135268);
    super.destroy();
    AppMethodBeat.o(135268);
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(135265);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135251);
        at.a(at.this, paramString, paramValueCallback);
        AppMethodBeat.o(135251);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(135265);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.f(paramString);
    AppMethodBeat.o(135265);
  }
  
  public final View getContentView()
  {
    return this;
  }
  
  public final d getFullscreenImpl()
  {
    return this.miK;
  }
  
  public final String getUserAgentString()
  {
    return this.mUserAgent;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(135263);
    int i = getScrollX();
    AppMethodBeat.o(135263);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(135264);
    int i = getScrollY();
    AppMethodBeat.o(135264);
    return i;
  }
  
  public final View getWrapperView()
  {
    return this;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(135261);
    if (paramRunnable != null) {
      postOnAnimation(paramRunnable);
    }
    AppMethodBeat.o(135261);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(135270);
    super.onPause();
    AppMethodBeat.o(135270);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135269);
    super.onResume();
    AppMethodBeat.o(135269);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135271);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.miJ != null) {
      this.miJ.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(135271);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135272);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.miI != null) {
      this.miI.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
    AppMethodBeat.o(135272);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(135274);
    if (this.mhN != null)
    {
      this.mhN.cancel();
      this.mhN = null;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getContentView().getScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135252);
        at.this.getContentView().setScrollY(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        AppMethodBeat.o(135252);
      }
    });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.mhN = localValueAnimator;
    AppMethodBeat.o(135274);
  }
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setAppBrandWebViewClient(ak paramak)
  {
    this.mhM = paramak;
  }
  
  public final void setFullscreenImpl(d paramd)
  {
    this.miK = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(ap paramap)
  {
    this.miI = paramap;
  }
  
  public final void setOnTrimListener(an paraman) {}
  
  public final void setWebViewLayoutListener(am paramam)
  {
    this.miJ = paramam;
  }
  
  public final void setXWebKeyboardImpl(ar paramar) {}
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135262);
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(135262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at
 * JD-Core Version:    0.7.0.1
 */