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
import android.util.Log;
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
import com.tencent.luggage.sdk.g.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkPreferences;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public final class aj
  extends MMWebView
  implements c.a, com.tencent.luggage.xweb_ext.extendplugin.b, com.tencent.mm.plugin.appbrand.page.a.e, ay
{
  private ar cwe;
  private ab lzJ;
  private com.tencent.xweb.x5.export.external.extension.proxy.a lzK;
  private boolean mDestroyed;
  private String mUserAgent;
  private com.tencent.mm.plugin.appbrand.platform.window.d mgt;
  private ap mhJ;
  private am mhK;
  private an mhL;
  private ak mhM;
  private Animator mhN;
  private boolean mhO;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c mhP;
  private final LinkedList<a> mhQ;
  private ac mhR;
  private com.tencent.xweb.x mhS;
  private Boolean mhT;
  
  private aj(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(47950);
    this.mhK = null;
    this.mhO = false;
    this.mDestroyed = false;
    this.mhQ = new LinkedList();
    this.mhR = new ac()
    {
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(222896);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (bu.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(222896);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = aj.a(aj.this, paramAnonymousWebView);
        AppMethodBeat.o(222896);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(222897);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (bu.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(222897);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = aj.a(aj.this, paramAnonymousWebView);
        AppMethodBeat.o(222897);
        return paramAnonymousWebView;
      }
      
      public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(222898);
        ae.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(222898);
      }
      
      public final void a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(222899);
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl();
        if (paramAnonymousWebView == null) {}
        for (paramAnonymousWebView = "null";; paramAnonymousWebView = paramAnonymousWebView.toString())
        {
          ae.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramAnonymousWebView, paramAnonymousWebResourceResponse.mMimeType, Integer.valueOf(paramAnonymousWebResourceResponse.mStatusCode) });
          AppMethodBeat.o(222899);
          return;
        }
      }
      
      public final void a(WebView paramAnonymousWebView, r paramAnonymousr, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(222894);
        if (paramAnonymousSslError.getPrimaryError() == 3)
        {
          if (aj.d(aj.this).a(paramAnonymousSslError.getCertificate()))
          {
            paramAnonymousr.proceed();
            AppMethodBeat.o(222894);
            return;
          }
          paramAnonymousr.cancel();
          AppMethodBeat.o(222894);
          return;
        }
        paramAnonymousr.cancel();
        AppMethodBeat.o(222894);
      }
      
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(222893);
        ae.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(222893);
        return true;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(222892);
        aj.d(aj.this).cF(paramAnonymousString);
        AppMethodBeat.o(222892);
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(222891);
        aj.d(aj.this);
        AppMethodBeat.o(222891);
      }
      
      public final WebResourceResponse c(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(222895);
        if (bu.isNullOrNil(paramAnonymousString))
        {
          AppMethodBeat.o(222895);
          return null;
        }
        paramAnonymousWebView = aj.a(aj.this, paramAnonymousString);
        AppMethodBeat.o(222895);
        return paramAnonymousWebView;
      }
    };
    this.mhS = new com.tencent.xweb.x()
    {
      public final boolean a(View paramAnonymousView, final WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(222901);
        ae.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
        if (aj.this.isXWalkKernel())
        {
          if (aj.e(aj.this) != null) {
            aj.e(aj.this).a(new WebChromeClient.CustomViewCallback()
            {
              public final void onCustomViewHidden()
              {
                AppMethodBeat.i(222900);
                if (aj.this.hasEnteredFullscreen())
                {
                  ae.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
                  aj.this.leaveFullscreen();
                }
                if (paramAnonymousCustomViewCallback != null) {
                  paramAnonymousCustomViewCallback.onCustomViewHidden();
                }
                AppMethodBeat.o(222900);
              }
            });
          }
          AppMethodBeat.o(222901);
          return true;
        }
        boolean bool = super.a(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(222901);
        return bool;
      }
      
      public final boolean bpU()
      {
        AppMethodBeat.i(222902);
        ae.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
        if (aj.this.isXWalkKernel())
        {
          AppMethodBeat.o(222902);
          return true;
        }
        boolean bool = super.bpU();
        AppMethodBeat.o(222902);
        return bool;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(222905);
        if ((paramAnonymousConsoleMessage != null) && (aj.d(aj.this) != null))
        {
          ak localak = aj.d(aj.this);
          if (localak.ckP != null) {
            com.tencent.luggage.sdk.g.e.a(paramAnonymousConsoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { localak.ckP.getAppId(), localak.ckP.kxv }));
          }
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(222905);
        return bool;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(222904);
        try
        {
          if (aj.e(aj.this) != null) {
            aj.e(aj.this).aYo();
          }
          AppMethodBeat.o(222904);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
          AppMethodBeat.o(222904);
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(222903);
        try
        {
          if (aj.e(aj.this) != null)
          {
            aj.e(aj.this).O(paramAnonymousView, 90);
            aj.e(aj.this).a(paramAnonymousCustomViewCallback);
          }
          AppMethodBeat.o(222903);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ae.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramAnonymousView.getMessage());
          AppMethodBeat.o(222903);
        }
      }
    };
    this.lzJ = new ab()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(222907);
        paramAnonymousBoolean = aj.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(222907);
        return paramAnonymousBoolean;
      }
      
      public final void bpP()
      {
        AppMethodBeat.i(222908);
        aj.this.fPV();
        AppMethodBeat.o(222908);
      }
      
      @TargetApi(9)
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(222909);
        aj.this.i(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(222909);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(47943);
        if (aj.f(aj.this) != null) {
          aj.f(aj.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        }
        aj.d(aj.this);
        aj.this.S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(47943);
      }
      
      public final boolean x(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222906);
        boolean bool = aj.this.af(paramAnonymousMotionEvent);
        AppMethodBeat.o(222906);
        return bool;
      }
      
      public final boolean y(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222910);
        boolean bool = aj.this.ag(paramAnonymousMotionEvent);
        AppMethodBeat.o(222910);
        return bool;
      }
      
      public final boolean z(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222911);
        boolean bool = aj.this.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(222911);
        return bool;
      }
    };
    this.lzK = new com.tencent.xweb.x5.export.external.extension.proxy.a()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(222884);
        aj.g(aj.this).bpP();
        AppMethodBeat.o(222884);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(222880);
        boolean bool = aj.g(aj.this).y(paramAnonymousMotionEvent);
        AppMethodBeat.o(222880);
        return bool;
      }
      
      public final void hasDiscardCurrentPage(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(222888);
        aj.a(aj.this, paramAnonymousBoolean);
        if ((paramAnonymousBoolean) && ((aj.h(aj.this) instanceof ao))) {
          aj.h(aj.this);
        }
        AppMethodBeat.o(222888);
      }
      
      public final void invalidate() {}
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(222879);
        boolean bool = aj.g(aj.this).z(paramAnonymousMotionEvent);
        AppMethodBeat.o(222879);
        return bool;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(222886);
        if ((bu.isNullOrNil(paramAnonymousString)) || (paramAnonymousBundle == null))
        {
          AppMethodBeat.o(222886);
          return null;
        }
        ae.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", new Object[] { paramAnonymousString });
        if ("onJavascriptCloseWindow".equals(paramAnonymousString))
        {
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(222886);
          return paramAnonymousString;
        }
        AppMethodBeat.o(222886);
        return null;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(222883);
        aj.g(aj.this).d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(222883);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(222882);
        aj.g(aj.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(222882);
      }
      
      public final boolean onShowLongClickPopupMenu()
      {
        AppMethodBeat.i(222885);
        if (WebView.getUsingTbsCoreVersion(aj.this.getContext()) >= 43011)
        {
          AppMethodBeat.o(222885);
          return false;
        }
        AppMethodBeat.o(222885);
        return true;
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(222878);
        boolean bool = aj.g(aj.this).x(paramAnonymousMotionEvent);
        AppMethodBeat.o(222878);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(222881);
        paramAnonymousBoolean = aj.g(aj.this).b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(222881);
        return paramAnonymousBoolean;
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(222887);
        if (aj.h(aj.this) == null)
        {
          AppMethodBeat.o(222887);
          return false;
        }
        boolean bool2 = aj.h(aj.this).bvV();
        if ((bool2) && (!aj.i(aj.this))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ae.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
          if ((!bool2) || (aj.i(aj.this))) {
            break;
          }
          AppMethodBeat.o(222887);
          return true;
        }
        AppMethodBeat.o(222887);
        return false;
      }
    };
    this.mhT = null;
    this.gff = true;
    this.mhM = null;
    i.NT(getSettings().getUserAgentString());
    getSettings().gfD();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    getSettings().gfF();
    getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.x.bX(getContext(), getSettings().getUserAgentString()));
    this.mUserAgent = getSettings().getUserAgentString();
    getSettings().setTextZoom(100);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.mhR);
    setWebChromeClient(this.mhS);
    setWebViewCallbackClient(this.lzJ);
    setWebViewClientExtension(this.lzK);
    getIsX5Kernel();
    getSettings().setUsingForAppBrand(1);
    ae.i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
    this.mhP = com.tencent.luggage.xweb_ext.extendplugin.d.a(this, com.tencent.luggage.xweb_ext.extendplugin.b.b.GS(), new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new ar()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.c bcc()
      {
        AppMethodBeat.i(47915);
        if (aj.a(aj.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.c localc = aj.a(aj.this).bcc();
          AppMethodBeat.o(47915);
          return localc;
        }
        AppMethodBeat.o(47915);
        return null;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.e bvB()
      {
        AppMethodBeat.i(47914);
        if (aj.a(aj.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.e locale = aj.a(aj.this).bvB();
          AppMethodBeat.o(47914);
          return locale;
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
        AppMethodBeat.i(222877);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(222877);
        return false;
      }
    });
    setDownloadListener(new DownloadListener()
    {
      public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        AppMethodBeat.i(47913);
        ae.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[] { paramAnonymousString1, paramAnonymousString4, paramAnonymousString2 });
        AppMethodBeat.o(47913);
      }
    });
    AppMethodBeat.o(47950);
  }
  
  public aj(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public final void Dq()
  {
    AppMethodBeat.i(47967);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(47967);
  }
  
  public final boolean Dr()
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
  
  public final boolean Ds()
  {
    AppMethodBeat.i(222913);
    boolean bool;
    if (this.mhT != null)
    {
      bool = this.mhT.booleanValue();
      AppMethodBeat.o(222913);
      return bool;
    }
    try
    {
      Boolean localBoolean = Boolean.valueOf(XWalkPreferences.getBooleanValue("remote-debugging"));
      this.mhT = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(222913);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(222913);
    }
    return false;
  }
  
  public final String Fs()
  {
    AppMethodBeat.i(47951);
    String str = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", new Object[] { n.byg(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(47951);
    return str;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    AppMethodBeat.i(47960);
    if (paramClass == com.tencent.mm.plugin.appbrand.page.a.e.class)
    {
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bHa())
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
  
  public final void bpJ()
  {
    AppMethodBeat.i(47961);
    ae.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onShow();
    AppMethodBeat.o(47961);
  }
  
  public final void bpK()
  {
    AppMethodBeat.i(47962);
    ae.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onHide();
    AppMethodBeat.o(47962);
  }
  
  public final boolean c(Canvas paramCanvas)
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
  
  public final void destroy()
  {
    AppMethodBeat.i(47964);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47964);
      return;
    }
    ae.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.mhQ.size()) });
    while (!this.mhQ.isEmpty()) {
      ((a)this.mhQ.pollFirst()).run();
    }
    try
    {
      super.destroy();
      if (this.mhN != null)
      {
        this.mhN.cancel();
        this.mhN = null;
      }
      if (this.mgt != null)
      {
        this.mgt.a(null);
        this.mgt.release();
      }
      this.mgt = null;
    }
    catch (Exception localException1)
    {
      try
      {
        ax(getContext().getApplicationContext());
        label136:
        if ((getParent() instanceof ViewGroup)) {
          ((ViewGroup)getParent()).removeView(this);
        }
        this.mDestroyed = true;
        ae.i("MicroMsg.AppBrandWebView", "destroyed hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(47964);
        return;
        localException1 = localException1;
        ae.printErrStackTrace("MicroMsg.AppBrandWebView", localException1, "[CAUGHT CRASH]", new Object[0]);
      }
      catch (Exception localException2)
      {
        break label136;
      }
    }
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(47957);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222889);
        aj.a(aj.this, paramString, paramValueCallback);
        AppMethodBeat.o(222889);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(47957);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.f(paramString);
    AppMethodBeat.o(47957);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(47953);
    View localView = super.getView();
    AppMethodBeat.o(47953);
    return localView;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    return this.mgt;
  }
  
  public final String getUserAgentString()
  {
    return this.mUserAgent;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return this.mhP;
  }
  
  public final View getWrapperView()
  {
    return this;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(47955);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(47955);
      return;
    }
    if (this.mDestroyed)
    {
      ae.w("MicroMsg.AppBrandWebView", "postOnReRendered webview destroyed, stack=%s", new Object[] { Log.getStackTraceString(new Throwable()) });
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
  
  protected final void onAttachedToWindow()
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
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(47970);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mhK != null) {
      this.mhK.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(47970);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(47968);
    if (this.mhN != null)
    {
      this.mhN.cancel();
      this.mhN = null;
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
        AppMethodBeat.i(222890);
        aj.this.getView().setScrollY(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        AppMethodBeat.o(222890);
      }
    });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.mhN = localValueAnimator;
    AppMethodBeat.o(47968);
  }
  
  public final void setAppBrandInfo(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(222912);
    paramMap = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47916);
        aj.c(aj.this).setAppBrandInfo(paramMap);
        AppMethodBeat.o(47916);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramMap.run();
      AppMethodBeat.o(222912);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.f(paramMap);
    AppMethodBeat.o(222912);
  }
  
  public final void setAppBrandWebViewClient(ak paramak)
  {
    this.mhM = paramak;
  }
  
  public final void setFullscreenImpl(com.tencent.mm.plugin.appbrand.platform.window.d paramd)
  {
    this.mgt = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(ap paramap)
  {
    this.mhJ = paramap;
  }
  
  public final void setOnTrimListener(an paraman)
  {
    this.mhL = paraman;
  }
  
  public final void setWebViewLayoutListener(am paramam)
  {
    this.mhK = paramam;
  }
  
  public final void setXWebKeyboardImpl(ar paramar)
  {
    this.cwe = paramar;
  }
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47956);
    this.mhO = false;
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(47956);
  }
  
  final class a
    implements Runnable
  {
    private final Runnable mRunnable;
    
    private a(Runnable paramRunnable)
    {
      AppMethodBeat.i(175039);
      this.mRunnable = paramRunnable;
      aj.b(aj.this).add(this);
      AppMethodBeat.o(175039);
    }
    
    public final void run()
    {
      AppMethodBeat.i(175040);
      aj.b(aj.this).remove(this);
      this.mRunnable.run();
      AppMethodBeat.o(175040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */