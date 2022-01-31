package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.MutableContextWrapper;
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
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.net.URL;

@JgClassChecked(author=10, fComment="checked", lastDate="20180817", reviewer=10, vComment={com.jg.EType.HTTPSCHECK})
public final class ac
  extends WebView
  implements af
{
  private WebViewClient bhV = new ac.3(this);
  private WebChromeClient bhW = new DefaultWebViewImpl.4(this);
  private ag gVD;
  private ab gVE;
  private Animator gVc;
  private String gVe;
  
  public ac(Context paramContext, ag paramag)
  {
    super(paramContext);
    this.gVD = paramag;
    getSettings().setDomStorageEnabled(true);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      getSettings().setMixedContentMode(0);
    }
    getSettings().setUserAgentString(getSettings().getUserAgentString() + "/ DEMO");
    this.gVe = getSettings().getUserAgentString();
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setWebViewClient(this.bhV);
    setWebChromeClient(this.bhW);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
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
    super.scrollTo(getScrollX(), 0);
  }
  
  public final boolean agC()
  {
    return false;
  }
  
  public final boolean agD()
  {
    return getWebScrollY() == 0;
  }
  
  public final void bt(String paramString1, String paramString2)
  {
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
  }
  
  public final void cf(Context paramContext)
  {
    if (!(getContext() instanceof MutableContextWrapper)) {
      return;
    }
    ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    paramString = new ac.1(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    ai.d(paramString);
  }
  
  public final View getContentView()
  {
    return this;
  }
  
  public final String getUserAgentString()
  {
    return this.gVe;
  }
  
  public final int getWebScrollY()
  {
    return getScrollY();
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
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getContentView().getScrollY(), paramInt });
    localValueAnimator.addUpdateListener(new ac.2(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
    this.gVc = localValueAnimator;
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.gVE != null) {
      this.gVE.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
  }
  
  public final void pY()
  {
    super.onResume();
  }
  
  public final void qa()
  {
    super.onPause();
  }
  
  public final void setFullscreenImpl(b paramb) {}
  
  public final void setJsExceptionHandler(e parame) {}
  
  public final void setOnScrollChangedListener(ab paramab)
  {
    this.gVE = paramab;
  }
  
  public final void setOnTrimListener(aa paramaa) {}
  
  public final void setTitle(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    evaluateJavascript("document.title=\"" + paramString + "\"", null);
  }
  
  public final void setWebViewLayoutListener(z paramz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */