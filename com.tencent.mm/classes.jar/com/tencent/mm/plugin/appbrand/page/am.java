package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.jg.JgClassChecked;
import com.tencent.luggage.sdk.g.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkPreferences;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public final class am
  extends MMWebView
  implements c.a, com.tencent.luggage.xweb_ext.extendplugin.b, com.tencent.mm.plugin.appbrand.page.a.e, bc
{
  private au cKd;
  private boolean mDestroyed;
  private ab mGX;
  private com.tencent.xweb.x5.export.external.extension.proxy.a mGY;
  private String mUserAgent;
  private com.tencent.mm.plugin.appbrand.platform.window.d nqS;
  private as nse;
  private ap nsf;
  private aq nsg;
  private an nsh;
  private Animator nsi;
  private boolean nsj;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c nsk;
  private final LinkedList<am.a> nsl;
  private com.tencent.xweb.ac nsm;
  private x nsn;
  private Boolean nso;
  
  private am(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(47950);
    this.nsf = null;
    this.nsj = false;
    this.mDestroyed = false;
    this.nsl = new LinkedList();
    this.nsm = new am.8(this);
    this.nsn = new x()
    {
      public final boolean a(View paramAnonymousView, final WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(227334);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
        if (am.this.isXWalkKernel())
        {
          if (am.e(am.this) != null) {
            am.e(am.this).a(new WebChromeClient.CustomViewCallback()
            {
              public final void onCustomViewHidden()
              {
                AppMethodBeat.i(227333);
                if (am.this.hasEnteredFullscreen())
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
                  am.this.leaveFullscreen();
                }
                if (paramAnonymousCustomViewCallback != null) {
                  paramAnonymousCustomViewCallback.onCustomViewHidden();
                }
                AppMethodBeat.o(227333);
              }
            });
          }
          AppMethodBeat.o(227334);
          return true;
        }
        boolean bool = super.a(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(227334);
        return bool;
      }
      
      public final boolean bLA()
      {
        AppMethodBeat.i(227335);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
        if (am.this.isXWalkKernel())
        {
          AppMethodBeat.o(227335);
          return true;
        }
        boolean bool = super.bLA();
        AppMethodBeat.o(227335);
        return bool;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(227338);
        if ((paramAnonymousConsoleMessage != null) && (am.d(am.this) != null))
        {
          an localan = am.d(am.this);
          if (localan.cwK != null) {
            com.tencent.luggage.sdk.g.e.a(paramAnonymousConsoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { localan.cwK.getAppId(), localan.cwK.lBI }));
          }
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(227338);
        return bool;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(227337);
        try
        {
          if (am.e(am.this) != null) {
            am.e(am.this).btC();
          }
          AppMethodBeat.o(227337);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
          AppMethodBeat.o(227337);
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(227336);
        try
        {
          if (am.e(am.this) != null)
          {
            am.e(am.this).N(paramAnonymousView, 90);
            am.e(am.this).a(paramAnonymousCustomViewCallback);
          }
          AppMethodBeat.o(227336);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramAnonymousView.getMessage());
          AppMethodBeat.o(227336);
        }
      }
    };
    this.mGX = new am.10(this);
    this.mGY = new am.2(this);
    this.nso = null;
    this.gKM = true;
    this.nsh = null;
    com.tencent.mm.plugin.appbrand.config.j.Xb(getSettings().getUserAgentString());
    getSettings().hsU();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    getSettings().hsW();
    getSettings().setUserAgentString(s.aa(getContext(), getSettings().getUserAgentString()));
    this.mUserAgent = getSettings().getUserAgentString();
    getSettings().setTextZoom(100);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.nsm);
    setWebChromeClient(this.nsn);
    setWebViewCallbackClient(this.mGX);
    setWebViewClientExtension(this.mGY);
    getIsX5Kernel();
    getSettings().setUsingForAppBrand(1);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "<init> hash:%d, type:%s", new Object[] { Integer.valueOf(hashCode()), getCurWebType() });
    this.nsk = com.tencent.luggage.xweb_ext.extendplugin.d.a(this, com.tencent.luggage.xweb_ext.extendplugin.b.b.QL(), new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new am.4(this));
    setBackgroundColor(0);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setOnLongClickListener(new am.1(this));
    setDownloadListener(new am.3(this));
    AppMethodBeat.o(47950);
  }
  
  public am(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public final void MM()
  {
    AppMethodBeat.i(47967);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(47967);
  }
  
  public final boolean MN()
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
  
  public final boolean MO()
  {
    AppMethodBeat.i(227346);
    boolean bool;
    if (this.nso != null)
    {
      bool = this.nso.booleanValue();
      AppMethodBeat.o(227346);
      return bool;
    }
    try
    {
      Boolean localBoolean = Boolean.valueOf(XWalkPreferences.getBooleanValue("remote-debugging"));
      this.nso = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(227346);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(227346);
    }
    return false;
  }
  
  public final String Pb()
  {
    AppMethodBeat.i(47951);
    String str = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", new Object[] { o.bUx(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(47951);
    return str;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.m.j> T R(Class<T> paramClass)
  {
    AppMethodBeat.i(47960);
    if (paramClass == com.tencent.mm.plugin.appbrand.page.a.e.class)
    {
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.cdA())
      {
        AppMethodBeat.o(47960);
        return null;
      }
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
  
  public final void bLp()
  {
    AppMethodBeat.i(47961);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    onShow();
    AppMethodBeat.o(47961);
  }
  
  public final void bLq()
  {
    AppMethodBeat.i(47962);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.nsl.size()) });
    while (!this.nsl.isEmpty()) {
      ((am.a)this.nsl.pollFirst()).run();
    }
    try
    {
      super.destroy();
      if (this.nsi != null)
      {
        this.nsi.cancel();
        this.nsi = null;
      }
      if (this.nqS != null)
      {
        this.nqS.a(null);
        this.nqS.release();
      }
      this.nqS = null;
    }
    catch (Exception localException1)
    {
      try
      {
        aG(getContext().getApplicationContext());
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
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(47957);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227322);
        am.a(am.this, paramString, paramValueCallback);
        AppMethodBeat.o(227322);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(47957);
      return;
    }
    MMHandlerThread.postToMainThread(paramString);
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
    return this.nqS;
  }
  
  public final String getUserAgentString()
  {
    return this.mUserAgent;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return this.nsk;
  }
  
  public final View getWrapperView()
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
    paramRunnable = new am.a(this, paramRunnable, (byte)0);
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
    if (this.nsf != null) {
      this.nsf.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(47970);
  }
  
  public final void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(47968);
    if (this.nsi != null)
    {
      this.nsi.cancel();
      this.nsi = null;
    }
    if (super.supportFeature(2005))
    {
      super.smoothScroll(getWebScrollX(), paramInt, paramLong);
      AppMethodBeat.o(47968);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getWebScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new am.7(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.nsi = localValueAnimator;
    AppMethodBeat.o(47968);
  }
  
  public final void setAppBrandInfo(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(227345);
    paramMap = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47916);
        am.c(am.this).setAppBrandInfo(paramMap);
        AppMethodBeat.o(47916);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramMap.run();
      AppMethodBeat.o(227345);
      return;
    }
    MMHandlerThread.postToMainThread(paramMap);
    AppMethodBeat.o(227345);
  }
  
  public final void setAppBrandWebViewClient(an paraman)
  {
    this.nsh = paraman;
  }
  
  public final void setFullscreenImpl(com.tencent.mm.plugin.appbrand.platform.window.d paramd)
  {
    this.nqS = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(as paramas)
  {
    this.nse = paramas;
  }
  
  public final void setOnTrimListener(aq paramaq)
  {
    this.nsg = paramaq;
  }
  
  public final void setWebViewLayoutListener(ap paramap)
  {
    this.nsf = paramap;
  }
  
  public final void setXWebKeyboardImpl(au paramau)
  {
    this.cKd = paramau;
  }
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47956);
    this.nsj = false;
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(47956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am
 * JD-Core Version:    0.7.0.1
 */