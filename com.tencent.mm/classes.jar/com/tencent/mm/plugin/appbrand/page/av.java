package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "webview", "(Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;)V", "wrappedWebView", "getWrappedWebView", "()Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "addJavascriptInterface", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "canOverScroll", "", "destroy", "drawScreenshotOnCanvas", "Landroid/graphics/Canvas;", "evaluateJavascript", "Ljava/net/URL;", "p2", "Landroid/webkit/ValueCallback;", "p3", "", "p4", "p5", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getContentHeight", "getContentView", "Landroid/view/View;", "getFullscreenImpl", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "getHeight", "getUrl", "getUserAgentString", "getWebScrollX", "getWebScrollY", "getWidth", "getWrapperView", "isInspectorEnabled", "loadData", "url", "data", "onBackground", "onForeground", "postOnReRendered", "runnable", "Ljava/lang/Runnable;", "resetContext", "context", "Landroid/content/Context;", "scrollToTop", "setAppBrandInfo", "map", "", "", "setAppBrandWebViewContentsOffset", "xOffset", "yOffset", "setBackgroundColor", "backgroundColor", "setFullscreenImpl", "impl", "setHorizontalScrollBarEnabled", "horizontalScrollBarEnabled", "setJsExceptionHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "setOnScrollChangedListener", "l", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewScrollListener;", "setOnTrimListener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOnTrimListener;", "setVerticalScrollBarEnabled", "verticalScrollBarEnabled", "setWebViewLayoutListener", "listener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewLayoutListener;", "setXWebKeyboardImpl", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandXWebKeyboard;", "smoothScrollTo", "top", "duration", "", "trimmed", "luggage-wxa-app_release"})
public class av
  implements bd
{
  public final bd quO;
  
  public av(bd parambd)
  {
    AppMethodBeat.i(176456);
    this.quO = parambd;
    AppMethodBeat.o(176456);
  }
  
  public final void B(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140741);
    this.quO.B(paramString1, paramString2);
    AppMethodBeat.o(140741);
  }
  
  public final void PE()
  {
    AppMethodBeat.i(140761);
    this.quO.PE();
    AppMethodBeat.o(140761);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(140765);
    boolean bool = this.quO.PF();
    AppMethodBeat.o(140765);
    return bool;
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(244494);
    boolean bool = this.quO.PG();
    AppMethodBeat.o(244494);
    return bool;
  }
  
  public final <T extends j> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(140755);
    paramClass = this.quO.Q(paramClass);
    AppMethodBeat.o(140755);
    return paramClass;
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140751);
    this.quO.a(paramURL, paramString, paramValueCallback);
    AppMethodBeat.o(140751);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140752);
    this.quO.a(paramURL, paramString1, paramString2, paramInt, paramString3, paramValueCallback);
    AppMethodBeat.o(140752);
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(140737);
    this.quO.aD(paramContext);
    AppMethodBeat.o(140737);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(140749);
    this.quO.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(140749);
  }
  
  public final void cl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244497);
    this.quO.cl(paramInt1, paramInt2);
    AppMethodBeat.o(244497);
  }
  
  public final boolean d(Canvas paramCanvas)
  {
    AppMethodBeat.i(140768);
    p.k(paramCanvas, "p0");
    boolean bool = this.quO.d(paramCanvas);
    AppMethodBeat.o(140768);
    return bool;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140754);
    this.quO.destroy();
    AppMethodBeat.o(140754);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140750);
    this.quO.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(140750);
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(140746);
    int i = this.quO.getContentHeight();
    AppMethodBeat.o(140746);
    return i;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(140739);
    View localView = this.quO.getContentView();
    AppMethodBeat.o(140739);
    return localView;
  }
  
  public d getFullscreenImpl()
  {
    AppMethodBeat.i(176457);
    d locald = this.quO.getFullscreenImpl();
    AppMethodBeat.o(176457);
    return locald;
  }
  
  public int getHeight()
  {
    AppMethodBeat.i(140745);
    int i = this.quO.getHeight();
    AppMethodBeat.o(140745);
    return i;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(140742);
    String str = this.quO.getUserAgentString();
    AppMethodBeat.o(140742);
    return str;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(140747);
    int i = this.quO.getWebScrollX();
    AppMethodBeat.o(140747);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(140748);
    int i = this.quO.getWebScrollY();
    AppMethodBeat.o(140748);
    return i;
  }
  
  public int getWidth()
  {
    AppMethodBeat.i(140744);
    int i = this.quO.getWidth();
    AppMethodBeat.o(140744);
    return i;
  }
  
  public View getWrapperView()
  {
    AppMethodBeat.i(140738);
    View localView = this.quO.getWrapperView();
    AppMethodBeat.o(140738);
    return localView;
  }
  
  public final void i(Runnable paramRunnable)
  {
    AppMethodBeat.i(140740);
    this.quO.i(paramRunnable);
    AppMethodBeat.o(140740);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(140757);
    this.quO.onBackground();
    AppMethodBeat.o(140757);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(140756);
    this.quO.onForeground();
    AppMethodBeat.o(140756);
  }
  
  public final void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(140762);
    this.quO.s(paramInt, paramLong);
    AppMethodBeat.o(140762);
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(244496);
    this.quO.setAppBrandInfo(paramMap);
    AppMethodBeat.o(244496);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(185200);
    this.quO.setBackgroundColor(paramInt);
    AppMethodBeat.o(185200);
  }
  
  public void setFullscreenImpl(d paramd)
  {
    AppMethodBeat.i(176458);
    this.quO.setFullscreenImpl(paramd);
    AppMethodBeat.o(176458);
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(140753);
    this.quO.setJsExceptionHandler(paramh);
    AppMethodBeat.o(140753);
  }
  
  public void setOnScrollChangedListener(au paramau)
  {
    AppMethodBeat.i(140758);
    this.quO.setOnScrollChangedListener(paramau);
    AppMethodBeat.o(140758);
  }
  
  public void setOnTrimListener(ar paramar)
  {
    AppMethodBeat.i(140760);
    this.quO.setOnTrimListener(paramar);
    AppMethodBeat.o(140760);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(140767);
    this.quO.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(140767);
  }
  
  public void setWebViewLayoutListener(aq paramaq)
  {
    AppMethodBeat.i(140759);
    this.quO.setWebViewLayoutListener(paramaq);
    AppMethodBeat.o(140759);
  }
  
  public void setXWebKeyboardImpl(aw paramaw)
  {
    AppMethodBeat.i(140766);
    this.quO.setXWebKeyboardImpl(paramaw);
    AppMethodBeat.o(140766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av
 * JD-Core Version:    0.7.0.1
 */