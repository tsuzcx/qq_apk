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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkPreferences;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public final class ak
  extends MMWebView
  implements c.a, com.tencent.luggage.xweb_ext.extendplugin.b, az, com.tencent.mm.plugin.appbrand.page.b.e
{
  private as cvA;
  private ab lvl;
  private com.tencent.xweb.x5.export.external.extension.proxy.a lvm;
  private boolean mDestroyed;
  private String mUserAgent;
  private com.tencent.mm.plugin.appbrand.r.a.d mcb;
  private com.tencent.xweb.x mdA;
  private Boolean mdB;
  private aq mdr;
  private an mds;
  private ao mdt;
  private al mdu;
  private Animator mdv;
  private boolean mdw;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c mdx;
  private final LinkedList<a> mdy;
  private ac mdz;
  
  private ak(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(47950);
    this.mds = null;
    this.mdw = false;
    this.mDestroyed = false;
    this.mdy = new LinkedList();
    this.mdz = new ac()
    {
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(47923);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (bt.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(47923);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = ak.a(ak.this, paramAnonymousWebView);
        AppMethodBeat.o(47923);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(47924);
        if ((paramAnonymousWebResourceRequest == null) || (paramAnonymousWebResourceRequest.getUrl() == null) || (bt.isNullOrNil(paramAnonymousWebResourceRequest.getUrl().toString())))
        {
          AppMethodBeat.o(47924);
          return null;
        }
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
        paramAnonymousWebView = ak.a(ak.this, paramAnonymousWebView);
        AppMethodBeat.o(47924);
        return paramAnonymousWebView;
      }
      
      public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47925);
        ad.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(47925);
      }
      
      public final void a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(47926);
        paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl();
        if (paramAnonymousWebView == null) {}
        for (paramAnonymousWebView = "null";; paramAnonymousWebView = paramAnonymousWebView.toString())
        {
          ad.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramAnonymousWebView, paramAnonymousWebResourceResponse.mMimeType, Integer.valueOf(paramAnonymousWebResourceResponse.mStatusCode) });
          AppMethodBeat.o(47926);
          return;
        }
      }
      
      public final void a(WebView paramAnonymousWebView, r paramAnonymousr, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(47921);
        if (paramAnonymousSslError.getPrimaryError() == 3)
        {
          if (ak.c(ak.this).a(paramAnonymousSslError.getCertificate()))
          {
            paramAnonymousr.proceed();
            AppMethodBeat.o(47921);
            return;
          }
          paramAnonymousr.cancel();
          AppMethodBeat.o(47921);
          return;
        }
        paramAnonymousr.cancel();
        AppMethodBeat.o(47921);
      }
      
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(47920);
        ad.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(47920);
        return true;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(47919);
        ak.c(ak.this).cE(paramAnonymousString);
        AppMethodBeat.o(47919);
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(47918);
        ak.c(ak.this);
        AppMethodBeat.o(47918);
      }
      
      public final WebResourceResponse c(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(47922);
        if (bt.isNullOrNil(paramAnonymousString))
        {
          AppMethodBeat.o(47922);
          return null;
        }
        paramAnonymousWebView = ak.a(ak.this, paramAnonymousString);
        AppMethodBeat.o(47922);
        return paramAnonymousWebView;
      }
    };
    this.mdA = new com.tencent.xweb.x()
    {
      public final boolean a(View paramAnonymousView, final WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(47928);
        ad.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
        if (ak.this.isXWalkKernel())
        {
          if (ak.d(ak.this) != null) {
            ak.d(ak.this).a(new WebChromeClient.CustomViewCallback()
            {
              public final void onCustomViewHidden()
              {
                AppMethodBeat.i(47927);
                if (ak.this.hasEnteredFullscreen())
                {
                  ad.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
                  ak.this.leaveFullscreen();
                }
                if (paramAnonymousCustomViewCallback != null) {
                  paramAnonymousCustomViewCallback.onCustomViewHidden();
                }
                AppMethodBeat.o(47927);
              }
            });
          }
          AppMethodBeat.o(47928);
          return true;
        }
        boolean bool = super.a(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(47928);
        return bool;
      }
      
      public final boolean bpk()
      {
        AppMethodBeat.i(47929);
        ad.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
        if (ak.this.isXWalkKernel())
        {
          AppMethodBeat.o(47929);
          return true;
        }
        boolean bool = super.bpk();
        AppMethodBeat.o(47929);
        return bool;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(175038);
        if ((paramAnonymousConsoleMessage != null) && (ak.c(ak.this) != null))
        {
          al localal = ak.c(ak.this);
          if (localal.ckN != null) {
            com.tencent.luggage.sdk.g.e.a(paramAnonymousConsoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { localal.ckN.getAppId(), localal.ckN.kuf }));
          }
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(175038);
        return bool;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(47931);
        try
        {
          if (ak.d(ak.this) != null) {
            ak.d(ak.this).aXV();
          }
          AppMethodBeat.o(47931);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
          AppMethodBeat.o(47931);
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(47930);
        try
        {
          if (ak.d(ak.this) != null)
          {
            ak.d(ak.this).O(paramAnonymousView, 90);
            ak.d(ak.this).a(paramAnonymousCustomViewCallback);
          }
          AppMethodBeat.o(47930);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ad.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramAnonymousView.getMessage());
          AppMethodBeat.o(47930);
        }
      }
    };
    this.lvl = new ab()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(47933);
        paramAnonymousBoolean = ak.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(47933);
        return paramAnonymousBoolean;
      }
      
      public final void bpf()
      {
        AppMethodBeat.i(47934);
        ak.this.fLB();
        AppMethodBeat.o(47934);
      }
      
      @TargetApi(9)
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(47935);
        ak.this.i(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(47935);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(47936);
        if (ak.e(ak.this) != null) {
          ak.e(ak.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        }
        ak.c(ak.this);
        ak.this.S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(47936);
      }
      
      public final boolean x(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(47932);
        boolean bool = ak.this.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(47932);
        return bool;
      }
      
      public final boolean y(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(47937);
        boolean bool = ak.this.ai(paramAnonymousMotionEvent);
        AppMethodBeat.o(47937);
        return bool;
      }
      
      public final boolean z(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(47938);
        boolean bool = ak.this.aj(paramAnonymousMotionEvent);
        AppMethodBeat.o(47938);
        return bool;
      }
    };
    this.lvm = new com.tencent.xweb.x5.export.external.extension.proxy.a()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(47945);
        ak.f(ak.this).bpf();
        AppMethodBeat.o(47945);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47941);
        boolean bool = ak.f(ak.this).y(paramAnonymousMotionEvent);
        AppMethodBeat.o(47941);
        return bool;
      }
      
      public final void hasDiscardCurrentPage(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(47949);
        ak.a(ak.this, paramAnonymousBoolean);
        if ((paramAnonymousBoolean) && ((ak.g(ak.this) instanceof ap))) {
          ak.g(ak.this);
        }
        AppMethodBeat.o(47949);
      }
      
      public final void invalidate() {}
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47940);
        boolean bool = ak.f(ak.this).z(paramAnonymousMotionEvent);
        AppMethodBeat.o(47940);
        return bool;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(47947);
        if ((bt.isNullOrNil(paramAnonymousString)) || (paramAnonymousBundle == null))
        {
          AppMethodBeat.o(47947);
          return null;
        }
        ad.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", new Object[] { paramAnonymousString });
        if ("onJavascriptCloseWindow".equals(paramAnonymousString))
        {
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(47947);
          return paramAnonymousString;
        }
        AppMethodBeat.o(47947);
        return null;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(47944);
        ak.f(ak.this).d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(47944);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(47943);
        ak.f(ak.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(47943);
      }
      
      public final boolean onShowLongClickPopupMenu()
      {
        AppMethodBeat.i(47946);
        if (WebView.getUsingTbsCoreVersion(ak.this.getContext()) >= 43011)
        {
          AppMethodBeat.o(47946);
          return false;
        }
        AppMethodBeat.o(47946);
        return true;
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(47939);
        boolean bool = ak.f(ak.this).x(paramAnonymousMotionEvent);
        AppMethodBeat.o(47939);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(47942);
        paramAnonymousBoolean = ak.f(ak.this).b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(47942);
        return paramAnonymousBoolean;
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(47948);
        if (ak.g(ak.this) == null)
        {
          AppMethodBeat.o(47948);
          return false;
        }
        boolean bool2 = ak.g(ak.this).bvk();
        if ((bool2) && (!ak.h(ak.this))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ad.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
          if ((!bool2) || (ak.h(ak.this))) {
            break;
          }
          AppMethodBeat.o(47948);
          return true;
        }
        AppMethodBeat.o(47948);
        return false;
      }
    };
    this.mdB = null;
    this.gcX = true;
    this.mdu = null;
    i.Nm(getSettings().getUserAgentString());
    getSettings().gbb();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    getSettings().gbd();
    getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.x.bW(getContext(), getSettings().getUserAgentString()));
    this.mUserAgent = getSettings().getUserAgentString();
    getSettings().setTextZoom(100);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.mdz);
    setWebChromeClient(this.mdA);
    setWebViewCallbackClient(this.lvl);
    setWebViewClientExtension(this.lvm);
    getIsX5Kernel();
    getSettings().setUsingForAppBrand(1);
    ad.i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
    this.mdx = com.tencent.luggage.xweb_ext.extendplugin.d.a(this, com.tencent.luggage.xweb_ext.extendplugin.b.b.GM(), new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new as()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e buP()
      {
        AppMethodBeat.i(47914);
        if (ak.a(ak.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.e locale = ak.a(ak.this).buP();
          AppMethodBeat.o(47914);
          return locale;
        }
        AppMethodBeat.o(47914);
        return null;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.c buQ()
      {
        AppMethodBeat.i(47915);
        if (ak.a(ak.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.c localc = ak.a(ak.this).buQ();
          AppMethodBeat.o(47915);
          return localc;
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
        AppMethodBeat.i(188699);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(188699);
        return false;
      }
    });
    setDownloadListener(new DownloadListener()
    {
      public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        AppMethodBeat.i(47913);
        ad.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[] { paramAnonymousString1, paramAnonymousString4, paramAnonymousString2 });
        AppMethodBeat.o(47913);
      }
    });
    AppMethodBeat.o(47950);
  }
  
  public ak(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public final void Dn()
  {
    AppMethodBeat.i(47967);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(47967);
  }
  
  public final boolean Do()
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
  
  public final boolean Dp()
  {
    AppMethodBeat.i(188700);
    boolean bool;
    if (this.mdB != null)
    {
      bool = this.mdB.booleanValue();
      AppMethodBeat.o(188700);
      return bool;
    }
    try
    {
      Boolean localBoolean = Boolean.valueOf(XWalkPreferences.getBooleanValue("remote-debugging"));
      this.mdB = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(188700);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(188700);
    }
    return false;
  }
  
  public final String Fn()
  {
    AppMethodBeat.i(47951);
    String str = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", new Object[] { n.bxn(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(47951);
    return str;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    AppMethodBeat.i(47960);
    if (paramClass == com.tencent.mm.plugin.appbrand.page.b.e.class)
    {
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bGe())
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
  
  public final void boZ()
  {
    AppMethodBeat.i(47961);
    ad.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onShow();
    AppMethodBeat.o(47961);
  }
  
  public final void bpa()
  {
    AppMethodBeat.i(47962);
    ad.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
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
    ad.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.mdy.size()) });
    while (!this.mdy.isEmpty()) {
      ((a)this.mdy.pollFirst()).run();
    }
    try
    {
      super.destroy();
      if (this.mdv != null)
      {
        this.mdv.cancel();
        this.mdv = null;
      }
      if (this.mcb != null)
      {
        this.mcb.a(null);
        this.mcb.release();
      }
      this.mcb = null;
    }
    catch (Exception localException1)
    {
      try
      {
        aw(getContext().getApplicationContext());
        label136:
        if ((getParent() instanceof ViewGroup)) {
          ((ViewGroup)getParent()).removeView(this);
        }
        this.mDestroyed = true;
        ad.i("MicroMsg.AppBrandWebView", "destroyed hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(47964);
        return;
        localException1 = localException1;
        ad.printErrStackTrace("MicroMsg.AppBrandWebView", localException1, "[CAUGHT CRASH]", new Object[0]);
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
        AppMethodBeat.i(47916);
        ak.a(ak.this, paramString, paramValueCallback);
        AppMethodBeat.o(47916);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(47957);
      return;
    }
    com.tencent.mm.sdk.platformtools.aq.f(paramString);
    AppMethodBeat.o(47957);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(47953);
    View localView = super.getView();
    AppMethodBeat.o(47953);
    return localView;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d getFullscreenImpl()
  {
    return this.mcb;
  }
  
  public final String getUserAgentString()
  {
    return this.mUserAgent;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return this.mdx;
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
      ad.w("MicroMsg.AppBrandWebView", "postOnReRendered webview destroyed, stack=%s", new Object[] { Log.getStackTraceString(new Throwable()) });
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
    if (this.mds != null) {
      this.mds.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(47970);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(47968);
    if (this.mdv != null)
    {
      this.mdv.cancel();
      this.mdv = null;
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
        AppMethodBeat.i(47917);
        ak.this.getView().setScrollY(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        AppMethodBeat.o(47917);
      }
    });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.mdv = localValueAnimator;
    AppMethodBeat.o(47968);
  }
  
  public final void setAppBrandWebViewClient(al paramal)
  {
    this.mdu = paramal;
  }
  
  public final void setFullscreenImpl(com.tencent.mm.plugin.appbrand.r.a.d paramd)
  {
    this.mcb = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aq paramaq)
  {
    this.mdr = paramaq;
  }
  
  public final void setOnTrimListener(ao paramao)
  {
    this.mdt = paramao;
  }
  
  public final void setWebViewLayoutListener(an paraman)
  {
    this.mds = paraman;
  }
  
  public final void setXWebKeyboardImpl(as paramas)
  {
    this.cvA = paramas;
  }
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47956);
    this.mdw = false;
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
      ak.b(ak.this).add(this);
      AppMethodBeat.o(175039);
    }
    
    public final void run()
    {
      AppMethodBeat.i(175040);
      ak.b(ak.this).remove(this);
      this.mRunnable.run();
      AppMethodBeat.o(175040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak
 * JD-Core Version:    0.7.0.1
 */