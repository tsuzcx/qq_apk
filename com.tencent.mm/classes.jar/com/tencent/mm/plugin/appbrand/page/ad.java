package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ValueCallback;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.j;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import com.tencent.xweb.t;
import com.tencent.xweb.v;
import com.tencent.xweb.w;
import java.net.URL;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkView;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author=10000, fComment="checked", lastDate="20180919", reviewer=10000, vComment={com.jg.EType.HTTPSCHECK})
public final class ad
  extends MMWebView
  implements com.tencent.luggage.xweb_ext.extendplugin.b, aq
{
  private v igO;
  private com.tencent.xweb.x5.a.a.a.a.b igP;
  private d ixq;
  private aj iyi;
  private ag iyj;
  private ah iyk;
  private ae iyl;
  private Animator iym;
  private boolean iyn;
  private String iyo;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c iyp;
  private w iyq;
  private p iyr;
  private boolean mDestroyed;
  
  private ad(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(143514);
    this.iyj = null;
    this.iyn = false;
    this.mDestroyed = false;
    this.iyq = new ad.5(this);
    this.iyr = new ad.6(this);
    this.igO = new ad.7(this);
    this.igP = new com.tencent.xweb.x5.a.a.a.a.b()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(132467);
        ad.d(ad.this).aGl();
        AppMethodBeat.o(132467);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(132463);
        boolean bool = ad.d(ad.this).B(paramAnonymousMotionEvent);
        AppMethodBeat.o(132463);
        return bool;
      }
      
      public final void hasDiscardCurrentPage(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(132471);
        ad.a(ad.this, paramAnonymousBoolean);
        if ((paramAnonymousBoolean) && ((ad.e(ad.this) instanceof ai))) {
          ad.e(ad.this);
        }
        AppMethodBeat.o(132471);
      }
      
      public final void invalidate() {}
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(132462);
        boolean bool = ad.d(ad.this).C(paramAnonymousMotionEvent);
        AppMethodBeat.o(132462);
        return bool;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(132469);
        if ((bo.isNullOrNil(paramAnonymousString)) || (paramAnonymousBundle == null))
        {
          AppMethodBeat.o(132469);
          return null;
        }
        ab.i("MicroMsg.AppBrandWebView", "method = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(132469);
        return null;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(132466);
        ad.d(ad.this).d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(132466);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(132465);
        ad.d(ad.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(132465);
      }
      
      public final boolean onShowLongClickPopupMenu()
      {
        AppMethodBeat.i(132468);
        if (WebView.getUsingTbsCoreVersion(ad.this.getContext()) >= 43011)
        {
          AppMethodBeat.o(132468);
          return false;
        }
        AppMethodBeat.o(132468);
        return true;
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(132461);
        boolean bool = ad.d(ad.this).A(paramAnonymousMotionEvent);
        AppMethodBeat.o(132461);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(132464);
        paramAnonymousBoolean = ad.d(ad.this).b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(132464);
        return paramAnonymousBoolean;
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(132470);
        if (ad.e(ad.this) == null)
        {
          AppMethodBeat.o(132470);
          return false;
        }
        boolean bool2 = ad.e(ad.this).aJL();
        if ((bool2) && (!ad.f(ad.this))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ab.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
          if ((!bool2) || (ad.f(ad.this))) {
            break;
          }
          AppMethodBeat.o(132470);
          return true;
        }
        AppMethodBeat.o(132470);
        return false;
      }
    };
    this.inited = true;
    this.iyl = null;
    getSettings().dYx();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    getSettings().dYz();
    getSettings().setUserAgentString(u.bD(getContext(), getSettings().getUserAgentString()));
    this.iyo = getSettings().getUserAgentString();
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.iyq);
    setWebChromeClient(this.iyr);
    setWebViewCallbackClient(this.igO);
    setWebViewClientExtension(this.igP);
    getIsX5Kernel();
    getSettings().setUsingForAppBrand(1);
    ab.i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
    if (com.tencent.luggage.xweb_ext.extendplugin.b.b.bJd == null) {
      com.tencent.luggage.xweb_ext.extendplugin.b.b.bJd = new com.tencent.luggage.xweb_ext.extendplugin.b.b();
    }
    paramContext = com.tencent.luggage.xweb_ext.extendplugin.b.b.bJd;
    if (com.tencent.mm.plugin.appbrand.f.d.hrG == null) {
      com.tencent.mm.plugin.appbrand.f.d.hrG = new com.tencent.mm.plugin.appbrand.f.d();
    }
    com.tencent.mm.plugin.appbrand.f.d locald = com.tencent.mm.plugin.appbrand.f.d.hrG;
    if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand()) {
      ab.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
    }
    for (;;)
    {
      paramContext = null;
      for (;;)
      {
        this.iyp = paramContext;
        setBackgroundColor(-1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setOnLongClickListener(new ad.1(this));
        setDownloadListener(new ad.2(this));
        AppMethodBeat.o(143514);
        return;
        if (!isXWalkKernel()) {
          break label443;
        }
        Object localObject = getWebViewUI();
        if ((!(localObject instanceof XWalkView)) || (paramContext == null)) {
          break;
        }
        localObject = (XWalkView)localObject;
        paramContext = paramContext.yj();
        com.tencent.luggage.xweb_ext.extendplugin.c localc = new com.tencent.luggage.xweb_ext.extendplugin.c((XWalkView)localObject);
        localc.bFS = paramContext;
        paramContext.a(localc);
        ((XWalkView)localObject).setExtendPluginClient(localc);
        if (locald != null) {
          paramContext.a(locald);
        }
        ab.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
      }
      ab.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
      continue;
      label443:
      ab.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    }
  }
  
  public ad(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(132480);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(132480);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(132481);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(132481);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    AppMethodBeat.i(132475);
    if (isXWalkKernel()) {
      drawCanvas(paramCanvas);
    }
    for (;;)
    {
      AppMethodBeat.o(132475);
      return true;
      draw(paramCanvas);
    }
  }
  
  public final void ap(Context paramContext)
  {
    AppMethodBeat.i(132473);
    if (!(getContext() instanceof MutableContextWrapper))
    {
      AppMethodBeat.o(132473);
      return;
    }
    ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    AppMethodBeat.o(132473);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(132483);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(132483);
      return;
    }
    try
    {
      super.destroy();
      if (this.iym != null)
      {
        this.iym.cancel();
        this.iym = null;
      }
      if (this.ixq != null)
      {
        d locald = this.ixq;
        locald.ivp.clear();
        locald.ivi = null;
      }
      this.ixq = null;
      ap(getContext().getApplicationContext());
      this.mDestroyed = true;
      AppMethodBeat.o(132483);
      return;
    }
    catch (Exception localException)
    {
      while ((!bp.dud()) && (com.tencent.mm.protocal.d.whI)) {}
      AppMethodBeat.o(132483);
      throw localException;
    }
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(132479);
    paramString = new ad.3(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(132479);
      return;
    }
    al.d(paramString);
    AppMethodBeat.o(132479);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(132474);
    View localView = super.getView();
    AppMethodBeat.o(132474);
    return localView;
  }
  
  public final d getFullscreenImpl()
  {
    return this.ixq;
  }
  
  public final String getUserAgentString()
  {
    return this.iyo;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return this.iyp;
  }
  
  public final View getWrapperView()
  {
    return this;
  }
  
  public final void h(Runnable paramRunnable)
  {
    AppMethodBeat.i(132476);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(132476);
      return;
    }
    if (isXWalkKernel())
    {
      postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(132476);
      return;
    }
    postOnAnimation(paramRunnable);
    AppMethodBeat.o(132476);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(132482);
    try
    {
      super.onAttachedToWindow();
      AppMethodBeat.o(132482);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      AppMethodBeat.o(132482);
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(132485);
    onPause();
    AppMethodBeat.o(132485);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(132484);
    onResume();
    AppMethodBeat.o(132484);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(132489);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.iyj != null) {
      this.iyj.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(132489);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132487);
    if (this.iym != null)
    {
      this.iym.cancel();
      this.iym = null;
    }
    if (super.supportFeature(2005))
    {
      super.smoothScroll(getWebScrollX(), paramInt, paramLong);
      AppMethodBeat.o(132487);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getWebScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new ad.4(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.iym = localValueAnimator;
    AppMethodBeat.o(132487);
  }
  
  public final void setAppBrandWebViewClient(ae paramae)
  {
    this.iyl = paramae;
  }
  
  public final void setFullscreenImpl(d paramd)
  {
    this.ixq = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aj paramaj)
  {
    this.iyi = paramaj;
  }
  
  public final void setOnTrimListener(ah paramah)
  {
    this.iyk = paramah;
  }
  
  public final void setWebViewLayoutListener(ag paramag)
  {
    this.iyj = paramag;
  }
  
  public final void t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132477);
    this.iyn = false;
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(132477);
  }
  
  public final <T extends j> T v(Class<T> paramClass)
  {
    return null;
  }
  
  public final void vp()
  {
    AppMethodBeat.i(132486);
    getView().scrollTo(getWebScrollX(), 0);
    AppMethodBeat.o(132486);
  }
  
  public final boolean vq()
  {
    AppMethodBeat.i(132488);
    if ((isXWalkKernel()) && (XWalkEnvironment.getAvailableVersion() >= 472))
    {
      boolean bool = isOverScrollStart();
      AppMethodBeat.o(132488);
      return bool;
    }
    if (getWebScrollY() == 0)
    {
      AppMethodBeat.o(132488);
      return true;
    }
    AppMethodBeat.o(132488);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */