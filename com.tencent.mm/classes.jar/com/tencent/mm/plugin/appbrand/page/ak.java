package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.jg.JgClassChecked;
import com.tencent.luggage.sdk.g.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.z;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public final class ak
  extends MMWebView
  implements com.tencent.luggage.k.a.b, c.a, az, com.tencent.mm.plugin.appbrand.page.b.e
{
  private as ckY;
  private ab kYj;
  private com.tencent.xweb.x5.export.external.extension.proxy.a kYk;
  private com.tencent.mm.plugin.appbrand.r.a.d lCA;
  private aq lDO;
  private an lDP;
  private ao lDQ;
  private al lDR;
  private Animator lDS;
  private boolean lDT;
  private com.tencent.luggage.k.a.c.c lDU;
  private final LinkedList<a> lDV;
  private com.tencent.xweb.ac lDW;
  private com.tencent.xweb.x lDX;
  private boolean mDestroyed;
  private String mUserAgent;
  
  private ak(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(47950);
    this.lDP = null;
    this.lDT = false;
    this.mDestroyed = false;
    this.lDV = new LinkedList();
    this.lDW = new ak.6(this);
    this.lDX = new com.tencent.xweb.x()
    {
      public final boolean a(View paramAnonymousView, final WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(47928);
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
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
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
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
      
      public final boolean blz()
      {
        AppMethodBeat.i(47929);
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
        if (ak.this.isXWalkKernel())
        {
          AppMethodBeat.o(47929);
          return true;
        }
        boolean bool = super.blz();
        AppMethodBeat.o(47929);
        return bool;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(175038);
        if ((paramAnonymousConsoleMessage != null) && (ak.c(ak.this) != null))
        {
          al localal = ak.c(ak.this);
          if (localal.caw != null) {
            com.tencent.luggage.sdk.g.e.a(paramAnonymousConsoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { localal.caw.getAppId(), localal.caw.jZJ }));
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
            ak.d(ak.this).aUJ();
          }
          AppMethodBeat.o(47931);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramAnonymousView.getMessage());
          AppMethodBeat.o(47930);
        }
      }
    };
    this.kYj = new ab()
    {
      public final boolean A(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(47937);
        boolean bool = ak.this.ag(paramAnonymousMotionEvent);
        AppMethodBeat.o(47937);
        return bool;
      }
      
      public final boolean B(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(47938);
        boolean bool = ak.this.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(47938);
        return bool;
      }
      
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(47933);
        paramAnonymousBoolean = ak.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(47933);
        return paramAnonymousBoolean;
      }
      
      public final void blu()
      {
        AppMethodBeat.i(47934);
        ak.this.fuO();
        AppMethodBeat.o(47934);
      }
      
      @TargetApi(9)
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(47935);
        ak.this.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
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
      
      public final boolean z(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(47932);
        boolean bool = ak.this.af(paramAnonymousMotionEvent);
        AppMethodBeat.o(47932);
        return bool;
      }
    };
    this.kYk = new ak.9(this);
    this.fJw = true;
    this.lDR = null;
    i.JT(getSettings().getUserAgentString());
    getSettings().fJH();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    getSettings().fJJ();
    getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.x.bS(getContext(), getSettings().getUserAgentString()));
    this.mUserAgent = getSettings().getUserAgentString();
    getSettings().setTextZoom(100);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.lDW);
    setWebChromeClient(this.lDX);
    setWebViewCallbackClient(this.kYj);
    setWebViewClientExtension(this.kYk);
    getIsX5Kernel();
    getSettings().setUsingForAppBrand(1);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
    this.lDU = com.tencent.luggage.k.a.d.a(this, com.tencent.luggage.k.a.c.b.Fs(), new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new as()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e bqP()
      {
        AppMethodBeat.i(47914);
        if (ak.a(ak.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.e locale = ak.a(ak.this).bqP();
          AppMethodBeat.o(47914);
          return locale;
        }
        AppMethodBeat.o(47914);
        return null;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.c bqQ()
      {
        AppMethodBeat.i(47915);
        if (ak.a(ak.this) != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.c localc = ak.a(ak.this).bqQ();
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
        return false;
      }
    });
    setDownloadListener(new ak.2(this));
    AppMethodBeat.o(47950);
  }
  
  public ak(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public final void BO()
  {
    AppMethodBeat.i(47967);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(47967);
  }
  
  public final boolean BP()
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
  
  public final String DO()
  {
    AppMethodBeat.i(47951);
    String str = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", new Object[] { m.bti(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(47951);
    return str;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    AppMethodBeat.i(47960);
    if (paramClass == com.tencent.mm.plugin.appbrand.page.b.e.class)
    {
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bCa())
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
  
  public final void blo()
  {
    AppMethodBeat.i(47961);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onShow();
    AppMethodBeat.o(47961);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(47962);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.lDV.size()) });
    while (!this.lDV.isEmpty()) {
      ((a)this.lDV.pollFirst()).run();
    }
    try
    {
      super.destroy();
      if (this.lDS != null)
      {
        this.lDS.cancel();
        this.lDS = null;
      }
      if (this.lCA != null)
      {
        this.lCA.a(null);
        this.lCA.release();
      }
      this.lCA = null;
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "destroyed hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(47964);
        return;
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandWebView", localException1, "[CAUGHT CRASH]", new Object[0]);
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
    ap.f(paramString);
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
    return this.lCA;
  }
  
  public final String getUserAgentString()
  {
    return this.mUserAgent;
  }
  
  public final com.tencent.luggage.k.a.c.c getWebViewPluginClientProxy()
  {
    return this.lDU;
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
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandWebView", "postOnReRendered webview destroyed, stack=%s", new Object[] { Log.getStackTraceString(new Throwable()) });
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
    if (this.lDP != null) {
      this.lDP.d(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(47970);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(47968);
    if (this.lDS != null)
    {
      this.lDS.cancel();
      this.lDS = null;
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
    this.lDS = localValueAnimator;
    AppMethodBeat.o(47968);
  }
  
  public final void setAppBrandWebViewClient(al paramal)
  {
    this.lDR = paramal;
  }
  
  public final void setFullscreenImpl(com.tencent.mm.plugin.appbrand.r.a.d paramd)
  {
    this.lCA = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aq paramaq)
  {
    this.lDO = paramaq;
  }
  
  public final void setOnTrimListener(ao paramao)
  {
    this.lDQ = paramao;
  }
  
  public final void setWebViewLayoutListener(an paraman)
  {
    this.lDP = paraman;
  }
  
  public final void setXWebKeyboardImpl(as paramas)
  {
    this.ckY = paramas;
  }
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47956);
    this.lDT = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak
 * JD-Core Version:    0.7.0.1
 */