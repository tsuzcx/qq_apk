package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.r.a.d;
import com.tencent.mm.sdk.platformtools.ap;
import java.net.URL;

@JgClassChecked(author=10, fComment="checked", lastDate="20180817", reviewer=10, vComment={com.jg.EType.HTTPSCHECK})
public final class au
  extends WebView
  implements az
{
  private WebViewClient bWI;
  private WebChromeClient bWJ;
  private al lDR;
  private Animator lDS;
  private aq lEK;
  private an lEL;
  private d lEM;
  private String mUserAgent;
  
  public au(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public au(Context paramContext, al paramal)
  {
    super(paramContext);
    AppMethodBeat.i(135258);
    this.bWI = new au.3(this);
    this.bWJ = new DefaultWebViewImpl.4(this);
    this.lDR = paramal;
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
    setWebViewClient(this.bWI);
    setWebChromeClient(this.bWJ);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(135258);
  }
  
  public final void BO()
  {
    AppMethodBeat.i(135273);
    super.scrollTo(getScrollX(), 0);
    AppMethodBeat.o(135273);
  }
  
  public final boolean BP()
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
  
  public final void aw(Context paramContext)
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
        au.a(au.this, paramString, paramValueCallback);
        AppMethodBeat.o(135251);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(135265);
      return;
    }
    ap.f(paramString);
    AppMethodBeat.o(135265);
  }
  
  public final View getContentView()
  {
    return this;
  }
  
  public final d getFullscreenImpl()
  {
    return this.lEM;
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
    if (this.lEL != null) {
      this.lEL.d(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(135271);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135272);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.lEK != null) {
      this.lEK.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
    AppMethodBeat.o(135272);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(135274);
    if (this.lDS != null)
    {
      this.lDS.cancel();
      this.lDS = null;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getContentView().getScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135252);
        au.this.getContentView().setScrollY(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        AppMethodBeat.o(135252);
      }
    });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.lDS = localValueAnimator;
    AppMethodBeat.o(135274);
  }
  
  public final void setAppBrandWebViewClient(al paramal)
  {
    this.lDR = paramal;
  }
  
  public final void setFullscreenImpl(d paramd)
  {
    this.lEM = paramd;
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aq paramaq)
  {
    this.lEK = paramaq;
  }
  
  public final void setOnTrimListener(ao paramao) {}
  
  public final void setWebViewLayoutListener(an paraman)
  {
    this.lEL = paraman;
  }
  
  public final void setXWebKeyboardImpl(as paramas) {}
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135262);
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(135262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.au
 * JD-Core Version:    0.7.0.1
 */