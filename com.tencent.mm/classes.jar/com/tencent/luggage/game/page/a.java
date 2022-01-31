package com.tencent.luggage.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.j;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.d;
import java.net.URL;

public final class a
  implements ap
{
  private ViewGroup bBI;
  private ViewGroup bBJ;
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public final boolean a(Canvas paramCanvas)
  {
    return false;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void ap(Context paramContext)
  {
    AppMethodBeat.i(140484);
    if (this.bBI == null) {
      this.bBI = new FrameLayout(paramContext);
    }
    if (this.bBJ == null) {
      this.bBJ = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(140484);
  }
  
  public final void destroy() {}
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.bBJ;
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
    return this.bBI;
  }
  
  public final void h(Runnable paramRunnable) {}
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void q(int paramInt, long paramLong) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(aj paramaj) {}
  
  public final void setOnTrimListener(ah paramah) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(ag paramag) {}
  
  public final void t(String paramString1, String paramString2) {}
  
  public final <T extends j> T v(Class<T> paramClass)
  {
    return null;
  }
  
  public final void vp() {}
  
  public final boolean vq()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */