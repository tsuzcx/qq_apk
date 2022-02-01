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
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.r.a.d;
import java.net.URL;

public final class a
  implements ay
{
  private ViewGroup cat;
  private ViewGroup cau;
  
  public final void BO() {}
  
  public final boolean BP()
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
  
  public final void aw(Context paramContext)
  {
    AppMethodBeat.i(130625);
    if (this.cat == null) {
      this.cat = new FrameLayout(paramContext);
    }
    if (this.cau == null) {
      this.cau = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(130625);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    return false;
  }
  
  public final void destroy()
  {
    this.cat = null;
    this.cau = null;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.cau;
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
    return this.cat;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(206105);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(206105);
  }
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void q(int paramInt, long paramLong) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aq paramaq) {}
  
  public final void setOnTrimListener(ao paramao) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(an paraman) {}
  
  public final void setXWebKeyboardImpl(as paramas) {}
  
  public final void x(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */