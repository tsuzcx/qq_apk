package com.tencent.luggage.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.j;
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
  private ViewGroup enj;
  private ViewGroup enk;
  
  public final void G(String paramString1, String paramString2) {}
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void apO() {}
  
  public final boolean apP()
  {
    return false;
  }
  
  public final boolean apQ()
  {
    return false;
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(130625);
    if (this.enj == null) {
      this.enj = new FrameLayout(paramContext);
    }
    if (this.enk == null) {
      this.enk = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(130625);
  }
  
  public final void cZ(int paramInt1, int paramInt2) {}
  
  public final void destroy()
  {
    this.enj = null;
    this.enk = null;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final boolean g(Canvas paramCanvas)
  {
    return false;
  }
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.enk;
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
    return this.enj;
  }
  
  public final void k(Runnable paramRunnable)
  {
    AppMethodBeat.i(220155);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(220155);
  }
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(au paramau) {}
  
  public final void setOnTrimListener(ar paramar) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(aq paramaq) {}
  
  public final void setXWebKeyboardImpl(aw paramaw) {}
  
  public final void w(int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */