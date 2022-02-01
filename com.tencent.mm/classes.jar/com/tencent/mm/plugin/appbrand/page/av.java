package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "webview", "(Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;)V", "wrappedWebView", "getWrappedWebView", "()Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "addJavascriptInterface", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "canOverScroll", "", "destroy", "drawScreenshotOnCanvas", "Landroid/graphics/Canvas;", "evaluateJavascript", "Ljava/net/URL;", "p2", "Landroid/webkit/ValueCallback;", "p3", "", "p4", "p5", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getContentHeight", "getContentView", "Landroid/view/View;", "getFullscreenImpl", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "getHeight", "getUrl", "getUserAgentString", "getWebScrollX", "getWebScrollY", "getWidth", "getWrapperView", "isInspectorEnabled", "loadData", "url", "data", "onBackground", "onForeground", "postOnReRendered", "runnable", "Ljava/lang/Runnable;", "resetContext", "context", "Landroid/content/Context;", "scrollToTop", "setAppBrandInfo", "map", "", "", "setAppBrandWebViewContentsSize", "width", "height", "setBackgroundColor", "backgroundColor", "setFullscreenImpl", "impl", "setHorizontalScrollBarEnabled", "horizontalScrollBarEnabled", "setJsExceptionHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "setOnScrollChangedListener", "l", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewScrollListener;", "setOnTrimListener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOnTrimListener;", "setVerticalScrollBarEnabled", "verticalScrollBarEnabled", "setWebViewLayoutListener", "listener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewLayoutListener;", "setXWebKeyboardImpl", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandXWebKeyboard;", "smoothScrollTo", "top", "duration", "", "trimmed", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class av
  implements bd
{
  public final bd tzF;
  
  public av(bd parambd)
  {
    AppMethodBeat.i(176456);
    this.tzF = parambd;
    AppMethodBeat.o(176456);
  }
  
  public final void G(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140741);
    this.tzF.G(paramString1, paramString2);
    AppMethodBeat.o(140741);
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    AppMethodBeat.i(140755);
    paramClass = this.tzF.Z(paramClass);
    AppMethodBeat.o(140755);
    return paramClass;
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140751);
    this.tzF.a(paramURL, paramString, paramValueCallback);
    AppMethodBeat.o(140751);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140752);
    this.tzF.a(paramURL, paramString1, paramString2, paramInt, paramString3, paramValueCallback);
    AppMethodBeat.o(140752);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(140749);
    this.tzF.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(140749);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(140761);
    this.tzF.apO();
    AppMethodBeat.o(140761);
  }
  
  public final boolean apP()
  {
    AppMethodBeat.i(140765);
    boolean bool = this.tzF.apP();
    AppMethodBeat.o(140765);
    return bool;
  }
  
  public final boolean apQ()
  {
    AppMethodBeat.i(325197);
    boolean bool = this.tzF.apQ();
    AppMethodBeat.o(325197);
    return bool;
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(140737);
    this.tzF.bm(paramContext);
    AppMethodBeat.o(140737);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(325208);
    this.tzF.cZ(paramInt1, paramInt2);
    AppMethodBeat.o(325208);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140754);
    this.tzF.destroy();
    AppMethodBeat.o(140754);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140750);
    this.tzF.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(140750);
  }
  
  public final boolean g(Canvas paramCanvas)
  {
    AppMethodBeat.i(140768);
    s.u(paramCanvas, "p0");
    boolean bool = this.tzF.g(paramCanvas);
    AppMethodBeat.o(140768);
    return bool;
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(140746);
    int i = this.tzF.getContentHeight();
    AppMethodBeat.o(140746);
    return i;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(140739);
    View localView = this.tzF.getContentView();
    AppMethodBeat.o(140739);
    return localView;
  }
  
  public d getFullscreenImpl()
  {
    AppMethodBeat.i(176457);
    d locald = this.tzF.getFullscreenImpl();
    AppMethodBeat.o(176457);
    return locald;
  }
  
  public int getHeight()
  {
    AppMethodBeat.i(140745);
    int i = this.tzF.getHeight();
    AppMethodBeat.o(140745);
    return i;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(140742);
    String str = this.tzF.getUserAgentString();
    AppMethodBeat.o(140742);
    return str;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(140747);
    int i = this.tzF.getWebScrollX();
    AppMethodBeat.o(140747);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(140748);
    int i = this.tzF.getWebScrollY();
    AppMethodBeat.o(140748);
    return i;
  }
  
  public int getWidth()
  {
    AppMethodBeat.i(140744);
    int i = this.tzF.getWidth();
    AppMethodBeat.o(140744);
    return i;
  }
  
  public View getWrapperView()
  {
    AppMethodBeat.i(140738);
    View localView = this.tzF.getWrapperView();
    AppMethodBeat.o(140738);
    return localView;
  }
  
  public final void k(Runnable paramRunnable)
  {
    AppMethodBeat.i(140740);
    this.tzF.k(paramRunnable);
    AppMethodBeat.o(140740);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(140757);
    this.tzF.onBackground();
    AppMethodBeat.o(140757);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(140756);
    this.tzF.onForeground();
    AppMethodBeat.o(140756);
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(325205);
    this.tzF.setAppBrandInfo(paramMap);
    AppMethodBeat.o(325205);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(185200);
    this.tzF.setBackgroundColor(paramInt);
    AppMethodBeat.o(185200);
  }
  
  public void setFullscreenImpl(d paramd)
  {
    AppMethodBeat.i(176458);
    this.tzF.setFullscreenImpl(paramd);
    AppMethodBeat.o(176458);
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(140753);
    this.tzF.setJsExceptionHandler(paramh);
    AppMethodBeat.o(140753);
  }
  
  public void setOnScrollChangedListener(au paramau)
  {
    AppMethodBeat.i(140758);
    this.tzF.setOnScrollChangedListener(paramau);
    AppMethodBeat.o(140758);
  }
  
  public void setOnTrimListener(ar paramar)
  {
    AppMethodBeat.i(140760);
    this.tzF.setOnTrimListener(paramar);
    AppMethodBeat.o(140760);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(140767);
    this.tzF.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(140767);
  }
  
  public void setWebViewLayoutListener(aq paramaq)
  {
    AppMethodBeat.i(140759);
    this.tzF.setWebViewLayoutListener(paramaq);
    AppMethodBeat.o(140759);
  }
  
  public void setXWebKeyboardImpl(aw paramaw)
  {
    AppMethodBeat.i(140766);
    this.tzF.setXWebKeyboardImpl(paramaw);
    AppMethodBeat.o(140766);
  }
  
  public final void w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(140762);
    this.tzF.w(paramInt, paramLong);
    AppMethodBeat.o(140762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av
 * JD-Core Version:    0.7.0.1
 */