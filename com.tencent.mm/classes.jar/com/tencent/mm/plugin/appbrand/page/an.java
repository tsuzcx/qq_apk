package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.jg.JgClassChecked;
import com.tencent.luggage.sdk.h.d.a;
import com.tencent.luggage.sdk.h.f;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;
import com.tencent.xweb.x;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkPreferences;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public class an
  extends MMWebView
  implements d.a, com.tencent.luggage.xweb_ext.extendplugin.b, com.tencent.mm.plugin.appbrand.page.a.e, be
{
  private aw cKG;
  private boolean mDestroyed;
  private String mUserAgent;
  private ac pGc;
  private com.tencent.xweb.x5.export.external.extension.proxy.a pGd;
  private com.tencent.mm.plugin.appbrand.platform.window.d qsE;
  private au qtW;
  private aq qtX;
  private ar qtY;
  private ao qtZ;
  private at qtg;
  private Animator qub;
  private boolean quc;
  private c qud;
  private final LinkedList<a> que;
  private com.tencent.xweb.ad quf;
  private x qug;
  private Boolean quh;
  
  private an(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(47950);
    this.qtX = null;
    this.quc = false;
    this.mDestroyed = false;
    this.que = new LinkedList();
    this.quf = new com.tencent.xweb.ad()
    {
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(265397);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (Util.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(265397);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = an.a(an.this, paramAnonymousWebView);
        AppMethodBeat.o(265397);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(265398);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (Util.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(265398);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = an.a(an.this, paramAnonymousWebView);
        AppMethodBeat.o(265398);
        return paramAnonymousWebView;
      }
      
      public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(265399);
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(265399);
      }
      
      public final void a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(265400);
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl();
        if (paramAnonymousWebView == null) {}
        for (paramAnonymousWebView = "null";; paramAnonymousWebView = paramAnonymousWebView.toString())
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramAnonymousWebView, paramAnonymousWebResourceResponse.mMimeType, Integer.valueOf(paramAnonymousWebResourceResponse.mStatusCode) });
          AppMethodBeat.o(265400);
          return;
        }
      }
      
      public final void a(WebView paramAnonymousWebView, r paramAnonymousr, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(265395);
        if (paramAnonymousSslError.getPrimaryError() == 3)
        {
          if (an.d(an.this).a(paramAnonymousSslError.getCertificate()))
          {
            paramAnonymousr.proceed();
            AppMethodBeat.o(265395);
            return;
          }
          paramAnonymousr.cancel();
          AppMethodBeat.o(265395);
          return;
        }
        paramAnonymousr.cancel();
        AppMethodBeat.o(265395);
      }
      
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(265394);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(265394);
        return true;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(265393);
        an.d(an.this).dw(paramAnonymousString);
        AppMethodBeat.o(265393);
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(265392);
        an.d(an.this);
        AppMethodBeat.o(265392);
      }
      
      public final WebResourceResponse c(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(265396);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          AppMethodBeat.o(265396);
          return null;
        }
        paramAnonymousWebView = an.a(an.this, paramAnonymousString);
        AppMethodBeat.o(265396);
        return paramAnonymousWebView;
      }
    };
    this.qug = new x()
    {
      public final boolean a(View paramAnonymousView, final WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(267380);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
        if (an.this.isXWalkKernel())
        {
          if (an.e(an.this) != null) {
            an.e(an.this).a(new WebChromeClient.CustomViewCallback()
            {
              public final void onCustomViewHidden()
              {
                AppMethodBeat.i(279698);
                if (an.this.hasEnteredFullscreen())
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
                  an.this.leaveFullscreen();
                }
                if (paramAnonymousCustomViewCallback != null) {
                  paramAnonymousCustomViewCallback.onCustomViewHidden();
                }
                AppMethodBeat.o(279698);
              }
            });
          }
          AppMethodBeat.o(267380);
          return true;
        }
        boolean bool = super.a(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(267380);
        return bool;
      }
      
      public final boolean bXA()
      {
        AppMethodBeat.i(267381);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
        if (an.this.isXWalkKernel())
        {
          AppMethodBeat.o(267381);
          return true;
        }
        boolean bool = super.bXA();
        AppMethodBeat.o(267381);
        return bool;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(267385);
        if ((paramAnonymousConsoleMessage != null) && (an.d(an.this) != null))
        {
          ao localao = an.d(an.this);
          if (localao.cvo != null) {
            f.a(paramAnonymousConsoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { localao.cvo.getAppId(), localao.cvo.oxe }));
          }
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(267385);
        return bool;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(267384);
        try
        {
          if (an.e(an.this) != null) {
            an.e(an.this).bEz();
          }
          AppMethodBeat.o(267384);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
          AppMethodBeat.o(267384);
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(267382);
        try
        {
          if (an.e(an.this) != null)
          {
            an.e(an.this).O(paramAnonymousView, 90);
            an.e(an.this).a(paramAnonymousCustomViewCallback);
          }
          AppMethodBeat.o(267382);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramAnonymousView.getMessage());
          AppMethodBeat.o(267382);
        }
      }
    };
    this.pGc = new ac()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(47945);
        an.this.hZQ();
        AppMethodBeat.o(47945);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47941);
        boolean bool = an.this.av(paramAnonymousMotionEvent);
        AppMethodBeat.o(47941);
        return bool;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47940);
        boolean bool = an.this.aw(paramAnonymousMotionEvent);
        AppMethodBeat.o(47940);
        return bool;
      }
      
      @TargetApi(9)
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(47944);
        an.this.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        if (an.f(an.this) != null) {
          an.f(an.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(47944);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(47943);
        if (an.g(an.this) != null) {
          an.g(an.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        }
        an.d(an.this);
        an.this.W(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(47943);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47939);
        boolean bool = an.this.au(paramAnonymousMotionEvent);
        AppMethodBeat.o(47939);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(47942);
        paramAnonymousBoolean = an.this.b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(47942);
        return paramAnonymousBoolean;
      }
    };
    this.pGd = new com.tencent.xweb.x5.export.external.extension.proxy.a()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(275823);
        an.h(an.this).computeScroll(paramAnonymousView);
        AppMethodBeat.o(275823);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(275819);
        boolean bool = an.h(an.this).dispatchTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(275819);
        return bool;
      }
      
      public final void hasDiscardCurrentPage(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(275827);
        an.a(an.this, paramAnonymousBoolean);
        if ((paramAnonymousBoolean) && ((an.i(an.this) instanceof as))) {
          an.i(an.this);
        }
        AppMethodBeat.o(275827);
      }
      
      public final void invalidate() {}
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(275817);
        boolean bool = an.h(an.this).onInterceptTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(275817);
        return bool;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(275825);
        if ((Util.isNullOrNil(paramAnonymousString)) || (paramAnonymousBundle == null))
        {
          AppMethodBeat.o(275825);
          return null;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", new Object[] { paramAnonymousString });
        if ("onJavascriptCloseWindow".equals(paramAnonymousString))
        {
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(275825);
          return paramAnonymousString;
        }
        AppMethodBeat.o(275825);
        return null;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(275822);
        an.h(an.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
        AppMethodBeat.o(275822);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(275821);
        an.h(an.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(275821);
      }
      
      public final boolean onShowLongClickPopupMenu()
      {
        AppMethodBeat.i(275824);
        if (WebView.getUsingTbsCoreVersion(an.this.getContext()) >= 43011)
        {
          AppMethodBeat.o(275824);
          return false;
        }
        AppMethodBeat.o(275824);
        return true;
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(275814);
        boolean bool = an.h(an.this).onTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(275814);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(275820);
        paramAnonymousBoolean = an.h(an.this).overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView);
        AppMethodBeat.o(275820);
        return paramAnonymousBoolean;
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(275826);
        if (an.i(an.this) == null)
        {
          AppMethodBeat.o(275826);
          return false;
        }
        boolean bool2 = an.i(an.this).ceX();
        if ((bool2) && (!an.j(an.this))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
          if ((!bool2) || (an.j(an.this))) {
            break;
          }
          AppMethodBeat.o(275826);
          return true;
        }
        AppMethodBeat.o(275826);
        return false;
      }
    };
    this.quh = null;
    this.jvb = true;
    this.qtZ = null;
    com.tencent.mm.plugin.appbrand.config.j.aeN(getSettings().getUserAgentString());
    getSettings().iwC();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    getSettings().iwE();
    getSettings().setUserAgentString(s.Y(getContext(), getSettings().getUserAgentString()));
    this.mUserAgent = getSettings().getUserAgentString();
    getSettings().setTextZoom(100);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.quf);
    setWebChromeClient(this.qug);
    setWebViewCallbackClient(this.pGc);
    setWebViewClientExtension(this.pGd);
    getIsX5Kernel();
    getSettings().setUsingForAppBrand(1);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "<init> hash:%d, type:%s", new Object[] { Integer.valueOf(hashCode()), getCurWebType() });
    this.qud = com.tencent.luggage.xweb_ext.extendplugin.d.a(this, com.tencent.mm.plugin.appbrand.xweb_ext.d.rIe, new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new aw()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e bIF()
      {
        AppMethodBeat.i(47915);
        if (an.a(an.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.e locale = an.a(an.this).bIF();
          AppMethodBeat.o(47915);
          return locale;
        }
        AppMethodBeat.o(47915);
        return null;
      }
      
      public final g cey()
      {
        AppMethodBeat.i(47914);
        if (an.a(an.this) != null)
        {
          g localg = an.a(an.this).cey();
          AppMethodBeat.o(47914);
          return localg;
        }
        AppMethodBeat.o(47914);
        return null;
      }
    });
    setBackgroundColor(0);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(278554);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(278554);
        return false;
      }
    });
    setDownloadListener(new DownloadListener()
    {
      public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        AppMethodBeat.i(47913);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[] { paramAnonymousString1, paramAnonymousString4, paramAnonymousString2 });
        AppMethodBeat.o(47913);
      }
    });
    AppMethodBeat.o(47950);
  }
  
  public an(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private void a(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(283542);
    try
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(283542);
      return;
    }
    catch (IllegalStateException paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "evaluateJavascript get exception:%s", new Object[] { paramString });
      AppMethodBeat.o(283542);
    }
  }
  
  public final void B(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47956);
    this.quc = false;
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(47956);
  }
  
  public final void PE()
  {
    AppMethodBeat.i(47967);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(47967);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(47969);
    if ((isXWalkKernel()) && (XWalkEnvironment.getAvailableVersion() >= 472))
    {
      boolean bool = isOverScrollStart();
      AppMethodBeat.o(47969);
      return bool;
    }
    if (getWebScrollY() == 0)
    {
      AppMethodBeat.o(47969);
      return true;
    }
    AppMethodBeat.o(47969);
    return false;
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(283557);
    boolean bool;
    if (this.quh != null)
    {
      bool = this.quh.booleanValue();
      AppMethodBeat.o(283557);
      return bool;
    }
    try
    {
      Boolean localBoolean = Boolean.valueOf(XWalkPreferences.getBooleanValue("remote-debugging"));
      this.quh = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(283557);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(283557);
    }
    return false;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.m.j> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(47960);
    if (paramClass == com.tencent.mm.plugin.appbrand.page.a.e.class)
    {
      com.tencent.mm.plugin.appbrand.xweb_ext.e.cqM();
      if (supportFeature(1040))
      {
        paramClass = (com.tencent.mm.plugin.appbrand.m.j)paramClass.cast(this);
        AppMethodBeat.o(47960);
        return paramClass;
      }
      AppMethodBeat.o(47960);
      return null;
    }
    if (paramClass.isInstance(this))
    {
      paramClass = (com.tencent.mm.plugin.appbrand.m.j)paramClass.cast(this);
      AppMethodBeat.o(47960);
      return paramClass;
    }
    AppMethodBeat.o(47960);
    return null;
  }
  
  public final String SA()
  {
    AppMethodBeat.i(47951);
    String str = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", new Object[] { p.chH(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(47951);
    return str;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(47958);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(47958);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(47959);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(47959);
  }
  
  public final void bXq()
  {
    AppMethodBeat.i(47961);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onShow();
    AppMethodBeat.o(47961);
  }
  
  public final void bXr()
  {
    AppMethodBeat.i(47962);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onHide();
    AppMethodBeat.o(47962);
  }
  
  public final void cl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283543);
    if (supportSetWebContentsSize()) {
      setWebContentsSize(paramInt1, paramInt2);
    }
    AppMethodBeat.o(283543);
  }
  
  public final boolean d(Canvas paramCanvas)
  {
    AppMethodBeat.i(47954);
    if (isXWalkKernel()) {
      drawCanvas(paramCanvas);
    }
    for (;;)
    {
      AppMethodBeat.o(47954);
      return true;
      draw(paramCanvas);
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(47964);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47964);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.que.size()) });
    while (!this.que.isEmpty()) {
      ((a)this.que.pollFirst()).run();
    }
    try
    {
      super.destroy();
      if (this.qub != null)
      {
        this.qub.cancel();
        this.qub = null;
      }
      if (this.qsE != null)
      {
        this.qsE.a(null);
        this.qsE.release();
      }
      this.qsE = null;
    }
    catch (Exception localException1)
    {
      try
      {
        aD(getContext().getApplicationContext());
        label136:
        if ((getParent() instanceof ViewGroup)) {
          ((ViewGroup)getParent()).removeView(this);
        }
        this.mDestroyed = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "destroyed hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(47964);
        return;
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandWebView", localException1, "[CAUGHT CRASH]", new Object[0]);
      }
      catch (Exception localException2)
      {
        break label136;
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(283546);
    try
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(283546);
      return;
    }
    catch (Exception paramCanvas)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "dispatchDraw %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(283546);
    }
  }
  
  public void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(47957);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      a(paramString, paramValueCallback);
      AppMethodBeat.o(47957);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(279227);
        an.a(an.this, paramString, paramValueCallback);
        AppMethodBeat.o(279227);
      }
    });
    AppMethodBeat.o(47957);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(47953);
    View localView = super.getView();
    AppMethodBeat.o(47953);
    return localView;
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    return this.qsE;
  }
  
  public String getUserAgentString()
  {
    return this.mUserAgent;
  }
  
  public c getWebViewPluginClientProxy()
  {
    return this.qud;
  }
  
  public View getWrapperView()
  {
    return this;
  }
  
  public final void i(Runnable paramRunnable)
  {
    AppMethodBeat.i(47955);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(47955);
      return;
    }
    if (this.mDestroyed)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "postOnReRendered webview destroyed, stack=%s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(47955);
      return;
    }
    paramRunnable = new a(paramRunnable, (byte)0);
    if (isXWalkKernel())
    {
      postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(47955);
      return;
    }
    postOnAnimation(paramRunnable);
    AppMethodBeat.o(47955);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(47963);
    try
    {
      super.onAttachedToWindow();
      AppMethodBeat.o(47963);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      AppMethodBeat.o(47963);
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(47966);
    onPause();
    AppMethodBeat.o(47966);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(47965);
    onResume();
    AppMethodBeat.o(47965);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(47970);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.qtX != null) {
      this.qtX.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(47970);
  }
  
  public final void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(47968);
    if (this.qub != null)
    {
      this.qub.cancel();
      this.qub = null;
    }
    if (super.supportFeature(2005))
    {
      super.smoothScroll(getWebScrollX(), paramInt, paramLong);
      AppMethodBeat.o(47968);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getWebScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(279284);
        an.this.getView().setScrollY(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        AppMethodBeat.o(279284);
      }
    });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.qub = localValueAnimator;
    AppMethodBeat.o(47968);
  }
  
  public void setAppBrandInfo(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(283541);
    paramMap = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47916);
        an.c(an.this).setAppBrandInfo(paramMap);
        AppMethodBeat.o(47916);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramMap.run();
      AppMethodBeat.o(283541);
      return;
    }
    MMHandlerThread.postToMainThread(paramMap);
    AppMethodBeat.o(283541);
  }
  
  public void setAppBrandWebViewClient(ao paramao)
  {
    this.qtZ = paramao;
  }
  
  public void setFullscreenImpl(com.tencent.mm.plugin.appbrand.platform.window.d paramd)
  {
    this.qsE = paramd;
  }
  
  public void setJsExceptionHandler(h paramh) {}
  
  public void setOnScrollChangedListener(au paramau)
  {
    this.qtW = paramau;
  }
  
  public void setOnTrimListener(ar paramar)
  {
    this.qtY = paramar;
  }
  
  public void setOverScrolledListener(at paramat)
  {
    this.qtg = paramat;
  }
  
  public void setWebViewLayoutListener(aq paramaq)
  {
    this.qtX = paramaq;
  }
  
  public void setXWebKeyboardImpl(aw paramaw)
  {
    this.cKG = paramaw;
  }
  
  final class a
    implements Runnable
  {
    private final Runnable mRunnable;
    
    private a(Runnable paramRunnable)
    {
      AppMethodBeat.i(175039);
      this.mRunnable = paramRunnable;
      an.b(an.this).add(this);
      AppMethodBeat.o(175039);
    }
    
    public final void run()
    {
      AppMethodBeat.i(175040);
      an.b(an.this).remove(this);
      this.mRunnable.run();
      AppMethodBeat.o(175040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.an
 * JD-Core Version:    0.7.0.1
 */