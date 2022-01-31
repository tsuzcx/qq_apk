package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.j;
import java.net.URL;

@JgClassChecked(author=10, fComment="checked", lastDate="20180817", reviewer=10, vComment={com.jg.EType.HTTPSCHECK})
public final class al
  extends WebView
  implements aq
{
  private WebViewClient byv;
  private WebChromeClient byw;
  private aj iyT;
  private ag iyU;
  private ae iyl;
  private Animator iym;
  private String iyo;
  
  public al(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public al(Context paramContext, ae paramae)
  {
    super(paramContext);
    AppMethodBeat.i(87321);
    this.byv = new al.3(this);
    this.byw = new DefaultWebViewImpl.4(this);
    this.iyl = paramae;
    getSettings().setDomStorageEnabled(true);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      getSettings().setMixedContentMode(0);
    }
    getSettings().setUserAgentString(getSettings().getUserAgentString() + "/ DEMO");
    this.iyo = getSettings().getUserAgentString();
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setWebViewClient(this.byv);
    setWebChromeClient(this.byw);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(87321);
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(87330);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(87330);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(87331);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(87331);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    AppMethodBeat.i(87323);
    draw(paramCanvas);
    AppMethodBeat.o(87323);
    return true;
  }
  
  public final void ap(Context paramContext)
  {
    AppMethodBeat.i(87322);
    if (!(getContext() instanceof MutableContextWrapper))
    {
      AppMethodBeat.o(87322);
      return;
    }
    ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    AppMethodBeat.o(87322);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(87332);
    super.destroy();
    AppMethodBeat.o(87332);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(87329);
    paramString = new al.1(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      AppMethodBeat.o(87329);
      return;
    }
    com.tencent.mm.sdk.platformtools.al.d(paramString);
    AppMethodBeat.o(87329);
  }
  
  public final View getContentView()
  {
    return this;
  }
  
  public final d getFullscreenImpl()
  {
    return null;
  }
  
  public final String getUserAgentString()
  {
    return this.iyo;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(87326);
    int i = getScrollX();
    AppMethodBeat.o(87326);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(87327);
    int i = getScrollY();
    AppMethodBeat.o(87327);
    return i;
  }
  
  public final View getWrapperView()
  {
    return this;
  }
  
  public final void h(Runnable paramRunnable)
  {
    AppMethodBeat.i(87324);
    if (paramRunnable != null) {
      postOnAnimation(paramRunnable);
    }
    AppMethodBeat.o(87324);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(87334);
    super.onPause();
    AppMethodBeat.o(87334);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(87333);
    super.onResume();
    AppMethodBeat.o(87333);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(87335);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.iyU != null) {
      this.iyU.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(87335);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(87336);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.iyT != null) {
      this.iyT.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
    AppMethodBeat.o(87336);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(87338);
    if (this.iym != null)
    {
      this.iym.cancel();
      this.iym = null;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getContentView().getScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new al.2(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.iym = localValueAnimator;
    AppMethodBeat.o(87338);
  }
  
  public final void setAppBrandWebViewClient(ae paramae)
  {
    this.iyl = paramae;
  }
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aj paramaj)
  {
    this.iyT = paramaj;
  }
  
  public final void setOnTrimListener(ah paramah) {}
  
  public final void setWebViewLayoutListener(ag paramag)
  {
    this.iyU = paramag;
  }
  
  public final void t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87325);
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
    AppMethodBeat.o(87325);
  }
  
  public final <T extends j> T v(Class<T> paramClass)
  {
    return null;
  }
  
  public final void vp()
  {
    AppMethodBeat.i(87337);
    super.scrollTo(getScrollX(), 0);
    AppMethodBeat.o(87337);
  }
  
  public final boolean vq()
  {
    AppMethodBeat.i(87339);
    if (getWebScrollY() == 0)
    {
      AppMethodBeat.o(87339);
      return true;
    }
    AppMethodBeat.o(87339);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */