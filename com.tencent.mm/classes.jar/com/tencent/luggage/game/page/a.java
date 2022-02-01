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
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.s.a.d;
import java.net.URL;

public final class a
  implements bd
{
  private ViewGroup cdw;
  private ViewGroup cdx;
  
  public final void Ck() {}
  
  public final boolean Cl()
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
  
  public final void av(Context paramContext)
  {
    AppMethodBeat.i(130625);
    if (this.cdw == null) {
      this.cdw = new FrameLayout(paramContext);
    }
    if (this.cdx == null) {
      this.cdx = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(130625);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    return false;
  }
  
  public final void destroy()
  {
    this.cdw = null;
    this.cdx = null;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.cdx;
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
    return this.cdw;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(194657);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(194657);
  }
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void r(int paramInt, long paramLong) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(av paramav) {}
  
  public final void setOnTrimListener(at paramat) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(as paramas) {}
  
  public final void setXWebKeyboardImpl(ax paramax) {}
  
  public final void u(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */