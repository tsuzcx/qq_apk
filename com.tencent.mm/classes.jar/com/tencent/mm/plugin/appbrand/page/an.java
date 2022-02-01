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
import com.tencent.luggage.sdk.h.d.a;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.af;
import com.tencent.xweb.ag;
import com.tencent.xweb.t;
import com.tencent.xweb.z;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public class an
  extends com.tencent.xweb.WebView
  implements d.a, com.tencent.luggage.xweb_ext.extendplugin.b, com.tencent.mm.plugin.appbrand.page.a.e, be
{
  private aw eEr;
  private String ekO;
  private c ews;
  private boolean mDestroyed;
  private af sLl;
  private com.tencent.xweb.x5.export.external.extension.proxy.a sLm;
  private at txM;
  private com.tencent.mm.plugin.appbrand.platform.window.d txi;
  private au tyO;
  private aq tyP;
  private ar tyQ;
  private ao tyR;
  private Animator tyS;
  private boolean tyT;
  private final LinkedList<a> tyU;
  private ag tyV;
  private z tyW;
  private Boolean tyX;
  
  private an(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(47950);
    this.tyP = null;
    this.tyT = false;
    this.mDestroyed = false;
    this.tyU = new LinkedList();
    this.tyV = new ag()
    {
      public final WebResourceResponse a(com.tencent.xweb.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(325010);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (Util.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(325010);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = an.a(an.this, paramAnonymousWebView);
        AppMethodBeat.o(325010);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(com.tencent.xweb.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(325014);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (Util.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(325014);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = an.a(an.this, paramAnonymousWebView);
        AppMethodBeat.o(325014);
        return paramAnonymousWebView;
      }
      
      public final void a(com.tencent.xweb.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(325017);
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(325017);
      }
      
      public final void a(com.tencent.xweb.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(325020);
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl();
        if (paramAnonymousWebView == null) {}
        for (paramAnonymousWebView = "null";; paramAnonymousWebView = paramAnonymousWebView.toString())
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramAnonymousWebView, paramAnonymousWebResourceResponse.mMimeType, Integer.valueOf(paramAnonymousWebResourceResponse.mStatusCode) });
          AppMethodBeat.o(325020);
          return;
        }
      }
      
      public final void a(com.tencent.xweb.WebView paramAnonymousWebView, t paramAnonymoust, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(325002);
        if (paramAnonymousSslError.getPrimaryError() == 3)
        {
          if (an.d(an.this).a(paramAnonymousSslError.getCertificate()))
          {
            paramAnonymoust.proceed();
            AppMethodBeat.o(325002);
            return;
          }
          paramAnonymoust.cancel();
          AppMethodBeat.o(325002);
          return;
        }
        paramAnonymoust.cancel();
        AppMethodBeat.o(325002);
      }
      
      public final boolean a(com.tencent.xweb.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(324998);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(324998);
        return true;
      }
      
      public final void b(com.tencent.xweb.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(324993);
        an.d(an.this).eH(paramAnonymousString);
        AppMethodBeat.o(324993);
      }
      
      public final void b(com.tencent.xweb.WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(324991);
        an.d(an.this);
        AppMethodBeat.o(324991);
      }
      
      public final WebResourceResponse c(com.tencent.xweb.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(325006);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          AppMethodBeat.o(325006);
          return null;
        }
        paramAnonymousWebView = an.a(an.this, paramAnonymousString);
        AppMethodBeat.o(325006);
        return paramAnonymousWebView;
      }
    };
    this.tyW = new z()
    {
      public final boolean a(View paramAnonymousView, final WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(324997);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
        if (an.this.isXWalkKernel())
        {
          if (an.e(an.this) != null) {
            an.e(an.this).a(new WebChromeClient.CustomViewCallback()
            {
              public final void onCustomViewHidden()
              {
                AppMethodBeat.i(324848);
                if (an.this.hasEnteredFullscreen())
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
                  an.this.leaveFullscreen();
                }
                if (paramAnonymousCustomViewCallback != null) {
                  paramAnonymousCustomViewCallback.onCustomViewHidden();
                }
                AppMethodBeat.o(324848);
              }
            });
          }
          AppMethodBeat.o(324997);
          return true;
        }
        boolean bool = super.a(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(324997);
        return bool;
      }
      
      public final boolean cxL()
      {
        AppMethodBeat.i(325001);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
        if (an.this.isXWalkKernel())
        {
          AppMethodBeat.o(325001);
          return true;
        }
        boolean bool = super.cxL();
        AppMethodBeat.o(325001);
        return bool;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(325015);
        if ((paramAnonymousConsoleMessage != null) && (an.d(an.this) != null))
        {
          ao localao = an.d(an.this);
          if (localao.enm != null) {
            com.tencent.luggage.sdk.h.f.a(paramAnonymousConsoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { localao.enm.getAppId(), localao.enm.cgR() }));
          }
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(325015);
        return bool;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(325008);
        try
        {
          if (an.e(an.this) != null) {
            an.e(an.this).cdL();
          }
          AppMethodBeat.o(325008);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
          AppMethodBeat.o(325008);
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(325005);
        try
        {
          if (an.e(an.this) != null)
          {
            an.e(an.this).T(paramAnonymousView, 90);
            an.e(an.this).a(paramAnonymousCustomViewCallback);
          }
          AppMethodBeat.o(325005);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramAnonymousView.getMessage());
          AppMethodBeat.o(325005);
        }
      }
    };
    this.sLl = new af()
    {
      private boolean tzc = true;
      
      public final void Bv(int paramAnonymousInt) {}
      
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(47945);
        an.this.super_computeScroll();
        AppMethodBeat.o(47945);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47941);
        boolean bool = an.this.super_dispatchTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(47941);
        return bool;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47940);
        boolean bool = an.this.super_onInterceptTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(47940);
        return bool;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(47944);
        an.this.super_onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
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
        an.this.super_onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(47943);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        boolean bool1 = false;
        AppMethodBeat.i(47939);
        int i = paramAnonymousMotionEvent.getAction();
        boolean bool2 = an.this.super_onTouchEvent(paramAnonymousMotionEvent);
        switch (i & 0xFF)
        {
        default: 
          if (bool2) {
            if (this.tzc) {
              break;
            }
          }
          break;
        }
        for (bool1 = true;; bool1 = bool2)
        {
          AppMethodBeat.o(47939);
          return bool1;
          this.tzc = false;
          break;
        }
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(47942);
        paramAnonymousBoolean = an.this.super_overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandWebView", "tbs_overScrollBy, deltaX: %d, deltaY: %d, scrollX: %b, scrollY: %b, r: %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousInt4 < 0) || ((paramAnonymousInt4 == 0) && (paramAnonymousInt2 < 0))) {
          this.tzc = true;
        }
        AppMethodBeat.o(47942);
        return paramAnonymousBoolean;
      }
    };
    this.sLm = new com.tencent.xweb.x5.export.external.extension.proxy.a()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(324992);
        an.h(an.this).computeScroll(paramAnonymousView);
        AppMethodBeat.o(324992);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(324982);
        boolean bool = an.h(an.this).dispatchTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(324982);
        return bool;
      }
      
      public final void hasDiscardCurrentPage(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(325011);
        an.a(an.this, paramAnonymousBoolean);
        if ((paramAnonymousBoolean) && ((an.i(an.this) instanceof as))) {
          an.i(an.this);
        }
        AppMethodBeat.o(325011);
      }
      
      public final void invalidate() {}
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(324978);
        boolean bool = an.h(an.this).onInterceptTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(324978);
        return bool;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(325004);
        if ((Util.isNullOrNil(paramAnonymousString)) || (paramAnonymousBundle == null))
        {
          AppMethodBeat.o(325004);
          return null;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", new Object[] { paramAnonymousString });
        if ("onJavascriptCloseWindow".equals(paramAnonymousString))
        {
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(325004);
          return paramAnonymousString;
        }
        AppMethodBeat.o(325004);
        return null;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(324989);
        an.h(an.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
        AppMethodBeat.o(324989);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(324986);
        an.h(an.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(324986);
      }
      
      public final boolean onShowLongClickPopupMenu()
      {
        AppMethodBeat.i(324996);
        if (com.tencent.xweb.ao.getUsingTbsCoreVersion(an.this.getContext()) >= 43011)
        {
          AppMethodBeat.o(324996);
          return false;
        }
        AppMethodBeat.o(324996);
        return true;
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(324977);
        boolean bool = an.h(an.this).onTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(324977);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(324984);
        paramAnonymousBoolean = an.h(an.this).overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView);
        AppMethodBeat.o(324984);
        return paramAnonymousBoolean;
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(325007);
        if (an.i(an.this) == null)
        {
          AppMethodBeat.o(325007);
          return false;
        }
        boolean bool2 = an.i(an.this).cFM();
        if ((bool2) && (!an.j(an.this))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
          if ((!bool2) || (an.j(an.this))) {
            break;
          }
          AppMethodBeat.o(325007);
          return true;
        }
        AppMethodBeat.o(325007);
        return false;
      }
    };
    this.tyX = null;
    this.tyR = null;
    try
    {
      if (BuildInfo.DEBUG)
      {
        com.tencent.xweb.ao.kgq();
        if (com.tencent.xweb.ao.kgl()) {
          android.webkit.WebView.setWebContentsDebuggingEnabled(true);
        }
      }
      label120:
      k.Xp(getSettings().getUserAgentString());
      getSettings().kfS();
      getSettings().setJavaScriptEnabled(true);
      getSettings().setMediaPlaybackRequiresUserGesture(false);
      getSettings().kfU();
      getSettings().setUserAgentString(v.Y(getContext(), getSettings().getUserAgentString()));
      this.ekO = getSettings().getUserAgentString();
      getSettings().setTextZoom(100);
      getView().setHorizontalScrollBarEnabled(false);
      getView().setVerticalScrollBarEnabled(false);
      setWebViewClient(this.tyV);
      setWebChromeClient(this.tyW);
      setWebViewCallbackClient(this.sLl);
      setWebViewClientExtension(this.sLm);
      getSettings().setUsingForAppBrand(1);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "<init> hash:%d, type:%s", new Object[] { Integer.valueOf(hashCode()), getCurWebType() });
      this.ews = com.tencent.luggage.xweb_ext.extendplugin.d.a(this, com.tencent.mm.plugin.appbrand.xweb_ext.d.uTt, new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new aw()
      {
        public final com.tencent.mm.plugin.appbrand.jsapi.h cFb()
        {
          AppMethodBeat.i(47914);
          if (an.a(an.this) != null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.h localh = an.a(an.this).cFb();
            AppMethodBeat.o(47914);
            return localh;
          }
          AppMethodBeat.o(47914);
          return null;
        }
        
        public final com.tencent.mm.plugin.appbrand.jsapi.f cik()
        {
          AppMethodBeat.i(47915);
          if (an.a(an.this) != null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.f localf = an.a(an.this).cik();
            AppMethodBeat.o(47915);
            return localf;
          }
          AppMethodBeat.o(47915);
          return null;
        }
      });
      setBackgroundColor(0);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(324976);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(324976);
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
      return;
    }
    finally
    {
      break label120;
    }
  }
  
  public an(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private void b(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(325229);
    try
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(325229);
      return;
    }
    catch (IllegalStateException paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "evaluateJavascript get exception:%s", new Object[] { paramString });
      AppMethodBeat.o(325229);
    }
  }
  
  public final void G(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47956);
    this.tyT = false;
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(47956);
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    AppMethodBeat.i(47960);
    if (paramClass == com.tencent.mm.plugin.appbrand.page.a.e.class)
    {
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.e.cTt())
      {
        AppMethodBeat.o(47960);
        return null;
      }
      if (supportFeature(1040))
      {
        paramClass = (j)paramClass.cast(this);
        AppMethodBeat.o(47960);
        return paramClass;
      }
      AppMethodBeat.o(47960);
      return null;
    }
    if (paramClass.isInstance(this))
    {
      paramClass = (j)paramClass.cast(this);
      AppMethodBeat.o(47960);
      return paramClass;
    }
    AppMethodBeat.o(47960);
    return null;
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
  
  public final void apO()
  {
    AppMethodBeat.i(47967);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(47967);
  }
  
  public final boolean apP()
  {
    AppMethodBeat.i(47969);
    if ((isXWalkKernel()) && (com.tencent.xweb.ao.getAvailableVersion() >= 472))
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
  
  public final boolean apQ()
  {
    AppMethodBeat.i(325419);
    boolean bool;
    if (this.tyX != null)
    {
      bool = this.tyX.booleanValue();
      AppMethodBeat.o(325419);
      return bool;
    }
    try
    {
      Boolean localBoolean = Boolean.valueOf(com.tencent.xweb.ao.kgp());
      this.tyX = localBoolean;
      bool = localBoolean.booleanValue();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(325419);
    }
    return false;
  }
  
  public final String asQ()
  {
    AppMethodBeat.i(47951);
    String str = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", new Object[] { q.cIC(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(47951);
    return str;
  }
  
  public void bm(Context paramContext)
  {
    AppMethodBeat.i(47952);
    if (!(getContext() instanceof MutableContextWrapper))
    {
      AppMethodBeat.o(47952);
      return;
    }
    MutableContextWrapper localMutableContextWrapper = (MutableContextWrapper)getContext();
    if (localMutableContextWrapper.getBaseContext() == paramContext)
    {
      AppMethodBeat.o(47952);
      return;
    }
    localMutableContextWrapper.setBaseContext(paramContext);
    AppMethodBeat.o(47952);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(325369);
    if (supportSetWebContentsSize()) {
      setWebContentsSize(paramInt1, paramInt2);
    }
    AppMethodBeat.o(325369);
  }
  
  public final void cxC()
  {
    AppMethodBeat.i(47961);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onShow();
    AppMethodBeat.o(47961);
  }
  
  public final void cxD()
  {
    AppMethodBeat.i(47962);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onHide();
    AppMethodBeat.o(47962);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(47964);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47964);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.tyU.size()) });
    while (!this.tyU.isEmpty()) {
      ((a)this.tyU.pollFirst()).run();
    }
    try
    {
      super.destroy();
      if (this.tyS != null)
      {
        this.tyS.cancel();
        this.tyS = null;
      }
      if (this.txi != null)
      {
        this.txi.a(null);
        this.txi.release();
      }
      this.txi = null;
    }
    catch (Exception localException1)
    {
      try
      {
        bm(getContext().getApplicationContext());
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
    AppMethodBeat.i(325395);
    try
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(325395);
      return;
    }
    catch (Exception paramCanvas)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "dispatchDraw %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(325395);
    }
  }
  
  public void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(47957);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramString, paramValueCallback);
      AppMethodBeat.o(47957);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324983);
        an.a(an.this, paramString, paramValueCallback);
        AppMethodBeat.o(324983);
      }
    });
    AppMethodBeat.o(47957);
  }
  
  public final boolean g(Canvas paramCanvas)
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
  
  public View getContentView()
  {
    AppMethodBeat.i(47953);
    View localView = super.getView();
    AppMethodBeat.o(47953);
    return localView;
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    return this.txi;
  }
  
  public String getUserAgentString()
  {
    return this.ekO;
  }
  
  public c getWebViewPluginClientProxy()
  {
    return this.ews;
  }
  
  public View getWrapperView()
  {
    return this;
  }
  
  public final void k(Runnable paramRunnable)
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
    if (this.tyP != null) {
      this.tyP.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(47970);
  }
  
  public void setAppBrandInfo(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(325363);
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
      AppMethodBeat.o(325363);
      return;
    }
    MMHandlerThread.postToMainThread(paramMap);
    AppMethodBeat.o(325363);
  }
  
  public void setAppBrandWebViewClient(ao paramao)
  {
    this.tyR = paramao;
  }
  
  public void setFullscreenImpl(com.tencent.mm.plugin.appbrand.platform.window.d paramd)
  {
    this.txi = paramd;
  }
  
  public void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.n.h paramh) {}
  
  public void setOnScrollChangedListener(au paramau)
  {
    this.tyO = paramau;
  }
  
  public void setOnTrimListener(ar paramar)
  {
    this.tyQ = paramar;
  }
  
  public void setOverScrolledListener(at paramat)
  {
    this.txM = paramat;
  }
  
  public void setWebViewLayoutListener(aq paramaq)
  {
    this.tyP = paramaq;
  }
  
  public void setXWebKeyboardImpl(aw paramaw)
  {
    this.eEr = paramaw;
  }
  
  public final void w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(47968);
    if (this.tyS != null)
    {
      this.tyS.cancel();
      this.tyS = null;
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
        AppMethodBeat.i(324985);
        an.this.getView().setScrollY(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        AppMethodBeat.o(324985);
      }
    });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.tyS = localValueAnimator;
    AppMethodBeat.o(47968);
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