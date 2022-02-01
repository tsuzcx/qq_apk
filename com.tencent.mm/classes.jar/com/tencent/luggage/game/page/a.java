package com.tencent.luggage.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;

public final class a
  implements bd
{
  private ViewGroup cvl;
  private ViewGroup cvm;
  
  public final void B(String paramString1, String paramString2) {}
  
  public final void PE() {}
  
  public final boolean PF()
  {
    return false;
  }
  
  public final boolean PG()
  {
    return false;
  }
  
  public final <T extends j> T Q(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(130625);
    if (this.cvl == null) {
      this.cvl = new FrameLayout(paramContext);
    }
    if (this.cvm == null) {
      this.cvm = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(130625);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void cl(int paramInt1, int paramInt2) {}
  
  public final boolean d(Canvas paramCanvas)
  {
    return false;
  }
  
  public final void destroy()
  {
    this.cvl = null;
    this.cvm = null;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.cvm;
  }
  
  public final d getFullscreenImpl()
  {
    return null;
  }
  
  public final int getHeight()
  {
    return 0;
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
    return this.cvl;
  }
  
  public final void i(Runnable paramRunnable)
  {
    AppMethodBeat.i(247452);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(247452);
  }
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void s(int paramInt, long paramLong) {}
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(au paramau) {}
  
  public final void setOnTrimListener(ar paramar) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(aq paramaq) {}
  
  public final void setXWebKeyboardImpl(aw paramaw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */