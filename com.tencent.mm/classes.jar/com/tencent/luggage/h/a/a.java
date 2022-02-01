package com.tencent.luggage.h.a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.page.bs.a;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/BaseSkylineViewRenderEngine;", "Lcom/tencent/mm/plugin/appbrand/page/MPWebViewRenderEngine;", "()V", "addJavascriptInterface", "", "obj", "", "name", "", "canOverScroll", "", "destroy", "dispatchInit", "dispatchPageReload", "dispatchPreload", "drawScreenshotOnCanvas", "canvas", "Landroid/graphics/Canvas;", "evaluateJavascript", "sourceURL", "Ljava/net/URL;", "script", "cb", "Landroid/webkit/ValueCallback;", "cacheCategory", "cacheKey", "cacheType", "", "executeOrDeferEvaluation", "runnable", "Ljava/lang/Runnable;", "callback", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "addon", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getContentHeight", "getContentView", "Landroid/view/View;", "getFullscreenImpl", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "getHeight", "getUrl", "getUserAgentString", "getWebScrollX", "getWebScrollY", "getWidth", "getWrapperView", "isDoingPreload", "isInspectorEnabled", "isPageFrameReady", "isPreloaded", "loadData", "url", "data", "onBackground", "onForeground", "postOnReRendered", "resetContext", "context", "Landroid/content/Context;", "resetHost", "delegate", "Lcom/tencent/mm/plugin/appbrand/page/MPWebViewRenderEngine$RendererDelegate;", "scrollToTop", "setAppBrandInfo", "map", "", "setAppBrandWebViewContentsSize", "width", "height", "setBackgroundColor", "backgroundColor", "setFullscreenImpl", "impl", "setHorizontalScrollBarEnabled", "horizontalScrollBarEnabled", "setJsExceptionHandler", "handler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "setOnScrollChangedListener", "l", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewScrollListener;", "setOnTrimListener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOnTrimListener;", "setVerticalScrollBarEnabled", "verticalScrollBarEnabled", "setWebViewLayoutListener", "listener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewLayoutListener;", "setXWebKeyboardImpl", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandXWebKeyboard;", "smoothScrollTo", "top", "duration", "", "trimmed", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements bs
{
  public final void G(String paramString1, String paramString2) {}
  
  public <T extends j> T Z(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(bs.a parama)
  {
    s.u(parama, "delegate");
  }
  
  public final void a(String paramString, ValueCallback<String> paramValueCallback)
  {
    s.u(paramString, "script");
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void apO() {}
  
  public final boolean apP()
  {
    return false;
  }
  
  public final boolean apQ()
  {
    return false;
  }
  
  public final boolean aru()
  {
    return false;
  }
  
  public final void asX() {}
  
  public void asY() {}
  
  public final boolean asZ()
  {
    return false;
  }
  
  public final boolean ata()
  {
    return false;
  }
  
  public final boolean atb()
  {
    return false;
  }
  
  public final void bm(Context paramContext) {}
  
  public final void cZ(int paramInt1, int paramInt2) {}
  
  public void destroy() {}
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final boolean g(Canvas paramCanvas)
  {
    s.u(paramCanvas, "canvas");
    return false;
  }
  
  public int getContentHeight()
  {
    return -1;
  }
  
  public View getContentView()
  {
    return null;
  }
  
  public d getFullscreenImpl()
  {
    return null;
  }
  
  public int getHeight()
  {
    return -1;
  }
  
  public String getUserAgentString()
  {
    return "";
  }
  
  public int getWebScrollX()
  {
    return -1;
  }
  
  public int getWebScrollY()
  {
    return -1;
  }
  
  public int getWidth()
  {
    return -1;
  }
  
  public View getWrapperView()
  {
    return null;
  }
  
  public void k(Runnable paramRunnable) {}
  
  public final void n(Runnable paramRunnable)
  {
    s.u(paramRunnable, "runnable");
  }
  
  public void onBackground() {}
  
  public void onForeground() {}
  
  public void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setFullscreenImpl(d paramd) {}
  
  public void setJsExceptionHandler(h paramh) {}
  
  public void setOnScrollChangedListener(au paramau) {}
  
  public void setOnTrimListener(ar paramar) {}
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean) {}
  
  public void setWebViewLayoutListener(aq paramaq) {}
  
  public void setXWebKeyboardImpl(aw paramaw) {}
  
  public final void w(int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.a.a
 * JD-Core Version:    0.7.0.1
 */