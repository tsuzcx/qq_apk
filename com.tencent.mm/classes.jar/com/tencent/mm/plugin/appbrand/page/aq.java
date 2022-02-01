package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import d.g.b.p;
import d.l;
import java.net.URL;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "webview", "(Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;)V", "wrappedWebView", "getWrappedWebView", "()Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "addJavascriptInterface", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "canOverScroll", "", "destroy", "drawScreenshotOnCanvas", "Landroid/graphics/Canvas;", "evaluateJavascript", "Ljava/net/URL;", "p2", "Landroid/webkit/ValueCallback;", "p3", "", "p4", "p5", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getContentHeight", "getContentView", "Landroid/view/View;", "getFullscreenImpl", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "getHeight", "getUrl", "getUserAgentString", "getWebScrollX", "getWebScrollY", "getWidth", "getWrapperView", "isInspectorEnabled", "loadData", "url", "data", "onBackground", "onForeground", "postOnReRendered", "runnable", "Ljava/lang/Runnable;", "resetContext", "context", "Landroid/content/Context;", "scrollToTop", "setAppBrandInfo", "map", "", "", "setBackgroundColor", "backgroundColor", "setFullscreenImpl", "impl", "setHorizontalScrollBarEnabled", "horizontalScrollBarEnabled", "setJsExceptionHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "setOnScrollChangedListener", "l", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewScrollListener;", "setOnTrimListener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOnTrimListener;", "setVerticalScrollBarEnabled", "verticalScrollBarEnabled", "setWebViewLayoutListener", "listener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewLayoutListener;", "setXWebKeyboardImpl", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandXWebKeyboard;", "smoothScrollTo", "top", "duration", "", "trimmed", "luggage-wxa-app_release"})
public class aq
  implements ax
{
  public final ax miB;
  
  public aq(ax paramax)
  {
    AppMethodBeat.i(176456);
    this.miB = paramax;
    AppMethodBeat.o(176456);
  }
  
  public final void Dq()
  {
    AppMethodBeat.i(140761);
    this.miB.Dq();
    AppMethodBeat.o(140761);
  }
  
  public final boolean Dr()
  {
    AppMethodBeat.i(140765);
    boolean bool = this.miB.Dr();
    AppMethodBeat.o(140765);
    return bool;
  }
  
  public final boolean Ds()
  {
    AppMethodBeat.i(208075);
    boolean bool = this.miB.Ds();
    AppMethodBeat.o(208075);
    return bool;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    AppMethodBeat.i(140755);
    paramClass = this.miB.P(paramClass);
    AppMethodBeat.o(140755);
    return paramClass;
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140751);
    this.miB.a(paramURL, paramString, paramValueCallback);
    AppMethodBeat.o(140751);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140752);
    this.miB.a(paramURL, paramString1, paramString2, paramInt, paramString3, paramValueCallback);
    AppMethodBeat.o(140752);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(140749);
    this.miB.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(140749);
  }
  
  public final void ax(Context paramContext)
  {
    AppMethodBeat.i(140737);
    this.miB.ax(paramContext);
    AppMethodBeat.o(140737);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(140768);
    p.h(paramCanvas, "p0");
    boolean bool = this.miB.c(paramCanvas);
    AppMethodBeat.o(140768);
    return bool;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140754);
    this.miB.destroy();
    AppMethodBeat.o(140754);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140750);
    this.miB.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(140750);
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(140746);
    int i = this.miB.getContentHeight();
    AppMethodBeat.o(140746);
    return i;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(140739);
    View localView = this.miB.getContentView();
    AppMethodBeat.o(140739);
    return localView;
  }
  
  public d getFullscreenImpl()
  {
    AppMethodBeat.i(176457);
    d locald = this.miB.getFullscreenImpl();
    AppMethodBeat.o(176457);
    return locald;
  }
  
  public int getHeight()
  {
    AppMethodBeat.i(140745);
    int i = this.miB.getHeight();
    AppMethodBeat.o(140745);
    return i;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(140743);
    String str = this.miB.getUrl();
    AppMethodBeat.o(140743);
    return str;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(140742);
    String str = this.miB.getUserAgentString();
    AppMethodBeat.o(140742);
    return str;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(140747);
    int i = this.miB.getWebScrollX();
    AppMethodBeat.o(140747);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(140748);
    int i = this.miB.getWebScrollY();
    AppMethodBeat.o(140748);
    return i;
  }
  
  public int getWidth()
  {
    AppMethodBeat.i(140744);
    int i = this.miB.getWidth();
    AppMethodBeat.o(140744);
    return i;
  }
  
  public View getWrapperView()
  {
    AppMethodBeat.i(140738);
    View localView = this.miB.getWrapperView();
    AppMethodBeat.o(140738);
    return localView;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(140740);
    this.miB.j(paramRunnable);
    AppMethodBeat.o(140740);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(140757);
    this.miB.onBackground();
    AppMethodBeat.o(140757);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(140756);
    this.miB.onForeground();
    AppMethodBeat.o(140756);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(140762);
    this.miB.q(paramInt, paramLong);
    AppMethodBeat.o(140762);
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(208076);
    this.miB.setAppBrandInfo(paramMap);
    AppMethodBeat.o(208076);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(185200);
    this.miB.setBackgroundColor(paramInt);
    AppMethodBeat.o(185200);
  }
  
  public void setFullscreenImpl(d paramd)
  {
    AppMethodBeat.i(176458);
    this.miB.setFullscreenImpl(paramd);
    AppMethodBeat.o(176458);
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(140753);
    this.miB.setJsExceptionHandler(paramh);
    AppMethodBeat.o(140753);
  }
  
  public void setOnScrollChangedListener(ap paramap)
  {
    AppMethodBeat.i(140758);
    this.miB.setOnScrollChangedListener(paramap);
    AppMethodBeat.o(140758);
  }
  
  public void setOnTrimListener(an paraman)
  {
    AppMethodBeat.i(140760);
    this.miB.setOnTrimListener(paraman);
    AppMethodBeat.o(140760);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(140767);
    this.miB.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(140767);
  }
  
  public void setWebViewLayoutListener(am paramam)
  {
    AppMethodBeat.i(140759);
    this.miB.setWebViewLayoutListener(paramam);
    AppMethodBeat.o(140759);
  }
  
  public void setXWebKeyboardImpl(ar paramar)
  {
    AppMethodBeat.i(140766);
    this.miB.setXWebKeyboardImpl(paramar);
    AppMethodBeat.o(140766);
  }
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140741);
    this.miB.x(paramString1, paramString2);
    AppMethodBeat.o(140741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aq
 * JD-Core Version:    0.7.0.1
 */