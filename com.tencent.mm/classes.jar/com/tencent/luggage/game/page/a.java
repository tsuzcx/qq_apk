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
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;

public final class a
  implements bb
{
  private ViewGroup cwH;
  private ViewGroup cwI;
  
  public final void MM() {}
  
  public final boolean MN()
  {
    return false;
  }
  
  public final boolean MO()
  {
    return false;
  }
  
  public final <T extends j> T R(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public final void aG(Context paramContext)
  {
    AppMethodBeat.i(130625);
    if (this.cwH == null) {
      this.cwH = new FrameLayout(paramContext);
    }
    if (this.cwI == null) {
      this.cwI = new FrameLayout(paramContext);
    }
    AppMethodBeat.o(130625);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final boolean c(Canvas paramCanvas)
  {
    return false;
  }
  
  public final void destroy()
  {
    this.cwH = null;
    this.cwI = null;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.cwI;
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
    return this.cwH;
  }
  
  public final void i(Runnable paramRunnable)
  {
    AppMethodBeat.i(222886);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(222886);
  }
  
  public final void onBackground() {}
  
  public final void onForeground() {}
  
  public final void s(int paramInt, long paramLong) {}
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setFullscreenImpl(d paramd) {}
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setOnScrollChangedListener(as paramas) {}
  
  public final void setOnTrimListener(aq paramaq) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public final void setWebViewLayoutListener(ap paramap) {}
  
  public final void setXWebKeyboardImpl(au paramau) {}
  
  public final void x(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.a
 * JD-Core Version:    0.7.0.1
 */