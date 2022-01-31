package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ValueCallback;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.f;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import java.net.URL;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkView;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public final class w
  extends MMWebView
  implements af
{
  private o gGh = new o()
  {
    public final void alk()
    {
      w.this.cJU();
    }
    
    public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
    {
      return w.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
    }
    
    @TargetApi(9)
    public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      w.this.e(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
    }
    
    public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
    {
      if (w.c(w.this) != null) {
        w.c(w.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
      }
      w.a(w.this);
      w.this.F(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
    }
    
    public final boolean v(MotionEvent paramAnonymousMotionEvent)
    {
      return w.this.L(paramAnonymousMotionEvent);
    }
    
    public final boolean w(MotionEvent paramAnonymousMotionEvent)
    {
      return w.this.M(paramAnonymousMotionEvent);
    }
    
    public final boolean x(MotionEvent paramAnonymousMotionEvent)
    {
      return w.this.N(paramAnonymousMotionEvent);
    }
  };
  private com.tencent.xweb.x5.a.a.a.a.b gGi = new w.8(this);
  private p gIG = new w.5(this);
  private b gTQ;
  private ab gUY;
  private z gUZ = null;
  private aa gVa;
  private x gVb;
  private Animator gVc;
  private boolean gVd = false;
  private String gVe;
  private f gVf;
  private j gVg = new w.6(this);
  
  public w(Context paramContext, x paramx)
  {
    super(new MutableContextWrapper(paramContext));
    this.dyX = true;
    boolean bool;
    if (getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      this.isX5Kernel = bool;
      this.gVb = paramx;
      hi(getContext());
      getSettings().cSs();
      getSettings().setJavaScriptEnabled(true);
      getSettings().setMediaPlaybackRequiresUserGesture(false);
      getSettings().cSu();
      getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.s.aX(getContext(), getSettings().getUserAgentString()));
      this.gVe = getSettings().getUserAgentString();
      getView().setHorizontalScrollBarEnabled(false);
      getView().setVerticalScrollBarEnabled(false);
      setWebViewClient(this.gIG);
      setWebChromeClient(this.gVg);
      setWebViewCallbackClient(this.gGh);
      if (getIsX5Kernel()) {
        setWebViewClientExtension(this.gGi);
      }
      try
      {
        org.b.a.cz(getX5WebViewExtension()).y("setEnableAutoPageDiscarding", new Object[] { Boolean.valueOf(false) });
        org.b.a.cz(getX5WebViewExtension()).y("setEnableAutoPageRestoration", new Object[] { Boolean.valueOf(false) });
        paramContext = new Bundle(1);
        paramContext.putInt("flag", 1);
        org.b.a.cz(getX5WebViewExtension()).y("invokeMiscMethod", new Object[] { "setMiniProgramFlag", paramContext });
        getSettings().setUsingForAppBrand(1);
        y.i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
        if (com.tencent.mm.plugin.appbrand.e.b.fYq == null) {
          com.tencent.mm.plugin.appbrand.e.b.fYq = new com.tencent.mm.plugin.appbrand.e.b();
        }
        paramContext = com.tencent.mm.plugin.appbrand.e.b.fYq;
        if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand())
        {
          y.w("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
          paramContext = null;
          this.gVf = ((f)paramContext);
          if (this.gVf != null)
          {
            paramContext = this.gVf;
            if (c.fYr == null) {
              c.fYr = new c();
            }
            paramContext.a(c.fYr);
          }
          setBackgroundColor(-1);
          setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          setOnLongClickListener(new w.1(this));
          setDownloadListener(new w.2(this));
          return;
          bool = false;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandWebView", "DisableAutoPageDiscarding error " + paramContext);
          continue;
          if (isXWalkKernel())
          {
            y.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, webview(%s) is xweb kernel", new Object[] { Integer.valueOf(hashCode()) });
            paramx = getWebViewUI();
            if ((paramx != null) && ((paramx instanceof XWalkView)) && (paramContext != null))
            {
              paramx = (XWalkView)paramx;
              paramContext = paramContext.qA();
              com.tencent.luggage.m.a.e locale = new com.tencent.luggage.m.a.e(paramx);
              locale.bkf = paramContext;
              paramContext.a(locale);
              paramx.setExtendPluginClient(locale);
              y.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
            }
            else
            {
              y.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
            }
          }
          else
          {
            y.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
          }
        }
      }
    }
  }
  
  public final <T extends g> T I(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString3, paramValueCallback);
  }
  
  public final void agB()
  {
    getView().scrollTo(getView().getScrollX(), 0);
  }
  
  public final boolean agC()
  {
    return this.gVd;
  }
  
  public final boolean agD()
  {
    return getWebScrollY() == 0;
  }
  
  public final void bt(String paramString1, String paramString2)
  {
    this.gVd = false;
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
  }
  
  public final void cf(Context paramContext)
  {
    if (!(getContext() instanceof MutableContextWrapper)) {
      return;
    }
    ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    com.tencent.xweb.s.q("BASE_CONTEXT_CHANGED", getContext());
  }
  
  public final void destroy()
  {
    super.destroy();
    if (this.gVc != null)
    {
      this.gVc.cancel();
      this.gVc = null;
    }
    if (this.gVf != null) {
      this.gVf.c(this);
    }
    if (this.gTQ != null) {
      this.gTQ.gSw.clear();
    }
    this.gTQ = null;
    cf(getContext().getApplicationContext());
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    paramString = new w.3(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    ai.d(paramString);
  }
  
  public final View getContentView()
  {
    return super.getView();
  }
  
  public final String getUserAgentString()
  {
    return this.gVe;
  }
  
  public final f getWebViewPluginClientProxy()
  {
    return this.gVf;
  }
  
  public final View getWrapperView()
  {
    return this;
  }
  
  public final void o(int paramInt, long paramLong)
  {
    if (this.gVc != null)
    {
      this.gVc.cancel();
      this.gVc = null;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getView().getScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new w.4(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.gVc = localValueAnimator;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.gUZ != null) {
      this.gUZ.b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final void pY()
  {
    onResume();
    if (this.gVf != null) {
      this.gVf.a(this);
    }
  }
  
  public final void qa()
  {
    onPause();
    if (this.gVf != null) {
      this.gVf.b(this);
    }
  }
  
  public final void setFullscreenImpl(b paramb)
  {
    this.gTQ = paramb;
  }
  
  public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.i.e parame) {}
  
  public final void setOnScrollChangedListener(ab paramab)
  {
    this.gUY = paramab;
  }
  
  public final void setOnTrimListener(aa paramaa)
  {
    this.gVa = paramaa;
  }
  
  public final void setTitle(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    evaluateJavascript("document.title=\"" + paramString + "\"", null);
  }
  
  public final void setWebViewLayoutListener(z paramz)
  {
    this.gUZ = paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */