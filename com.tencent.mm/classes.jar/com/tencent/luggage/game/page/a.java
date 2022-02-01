package com.tencent.luggage.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;

public final class a
  implements ax
{
  private ViewGroup ckM;
  private ViewGroup ckN;
  
  public final void Dq() {}
  
  public final boolean Dr()
  {
    return false;
  }
  
  public final boolean Ds()
  {
    return false;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void ax(Context paramContext)
  {
    AppMethodBeat.i(130625);
    if (this.ckM == null) {
      this.ckM = new FrameLayout(paramContext);
    }
    if (this.ckN == null) {
      this.ckN = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(130625);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    return false;
  }
  
  public final void destroy()
  {
    this.ckM = null;
    this.ckN = null;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.ckN;
  }
  
  public final d getFullscreenImpl()
  {
    return null;
  }
  
  public final int getHeight()
  {
    return 0;
  }
  
  public final String getUrl()
  {
    return "MiniGame";
  }
  
  public final String getUserAgentString()
  {
    return "MiniGame";
  }
  
  public final int getWebScrollX()
  {
    return 0;
  }
  
  public final int getWebScrollY()
  {
    return 0;
  }
  
  public final int getWidth()
  {
    return 0;
  }
  
  public final View getWrapperView()
  {
    return this.ckM;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(220730);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(220730);
  }
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void q(int paramInt, long paramLong) {}
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(ap paramap) {}
  
  public final void setOnTrimListener(an paraman) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(am paramam) {}
  
  public final void setXWebKeyboardImpl(ar paramar) {}
  
  public final void x(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */