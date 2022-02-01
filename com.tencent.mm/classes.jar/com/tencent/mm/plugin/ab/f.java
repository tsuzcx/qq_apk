package com.tencent.mm.plugin.ab;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Object;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;)V", "canVideoAutoPlay", "", "getCacheDir", "", "getCanvas", "Lcom/eclipsesource/v8/V8Object;", "getElementId", "", "getFontSize", "", "getFps", "getHeight", "getId", "getOffsetHeight", "getOffsetTop", "getWidth", "isDarkMode", "isOnScreen", "measureText", "", "text", "fontWeight", "fontStyle", "fontSize", "fontFamily", "restore", "canvasId", "save", "", "left", "top", "width", "height", "layout", "setHeight", "setVideo", "bottom", "Companion", "webview-sdk_release"})
public final class f
  extends a<g>
{
  private static final kotlin.f IBb;
  private static final i IBc;
  public static final a IBd;
  
  static
  {
    AppMethodBeat.i(224802);
    IBd = new a((byte)0);
    IBb = kotlin.g.ah((kotlin.g.a.a)f.b.IBe);
    i locali = new i();
    locali.init(1024, 1024);
    IBc = locali;
    AppMethodBeat.o(224802);
  }
  
  public f(g paramg)
  {
    super("wxCanvas", (b)paramg);
    AppMethodBeat.i(224801);
    AppMethodBeat.o(224801);
  }
  
  @JavascriptInterface
  public final boolean canVideoAutoPlay()
  {
    AppMethodBeat.i(224798);
    boolean bool = ((g)this.IBa).canVideoAutoPlay();
    AppMethodBeat.o(224798);
    return bool;
  }
  
  @JavascriptInterface
  public final String getCacheDir()
  {
    AppMethodBeat.i(224789);
    Object localObject = m.IAG;
    localObject = m.fWH();
    AppMethodBeat.o(224789);
    return localObject;
  }
  
  @JavascriptInterface
  public final V8Object getCanvas()
  {
    AppMethodBeat.i(224784);
    V8Object localV8Object = ((g)this.IBa).getCanvas();
    AppMethodBeat.o(224784);
    return localV8Object;
  }
  
  @JavascriptInterface
  public final int getElementId()
  {
    AppMethodBeat.i(224785);
    int i = ((g)this.IBa).getElementId();
    AppMethodBeat.o(224785);
    return i;
  }
  
  @JavascriptInterface
  public final float getFontSize()
  {
    AppMethodBeat.i(224786);
    float f = ((g)this.IBa).getFontSize();
    AppMethodBeat.o(224786);
    return f;
  }
  
  @JavascriptInterface
  public final int getFps()
  {
    AppMethodBeat.i(224790);
    int i = ((g)this.IBa).getFps();
    AppMethodBeat.o(224790);
    return i;
  }
  
  @JavascriptInterface
  public final int getHeight()
  {
    AppMethodBeat.i(224793);
    int i = ((g)this.IBa).getHeight();
    AppMethodBeat.o(224793);
    return i;
  }
  
  @JavascriptInterface
  public final String getId()
  {
    AppMethodBeat.i(224783);
    String str = ((g)this.IBa).getId();
    AppMethodBeat.o(224783);
    return str;
  }
  
  @JavascriptInterface
  public final int getOffsetHeight()
  {
    AppMethodBeat.i(224795);
    int i = ((g)this.IBa).getOffsetHeight();
    AppMethodBeat.o(224795);
    return i;
  }
  
  @JavascriptInterface
  public final int getOffsetTop()
  {
    AppMethodBeat.i(224794);
    int i = ((g)this.IBa).getOffsetTop();
    AppMethodBeat.o(224794);
    return i;
  }
  
  @JavascriptInterface
  public final int getWidth()
  {
    AppMethodBeat.i(224792);
    int i = ((g)this.IBa).getWidth();
    AppMethodBeat.o(224792);
    return i;
  }
  
  @JavascriptInterface
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(224787);
    boolean bool = ao.isDarkMode();
    AppMethodBeat.o(224787);
    return bool;
  }
  
  @JavascriptInterface
  public final boolean isOnScreen()
  {
    AppMethodBeat.i(224791);
    boolean bool = ((g)this.IBa).isOnScreen();
    AppMethodBeat.o(224791);
    return bool;
  }
  
  @JavascriptInterface
  public final Number measureText(String paramString1, String paramString2, String paramString3, Number paramNumber, String paramString4)
  {
    AppMethodBeat.i(224788);
    p.h(paramString1, "text");
    p.h(paramString2, "fontWeight");
    p.h(paramString3, "fontStyle");
    p.h(paramNumber, "fontSize");
    p.h(paramString4, "fontFamily");
    i locali = IBc;
    if (BuildInfo.DEBUG) {
      Log.d(this.TAG, "measureText text=" + paramString1 + " fontWeight=" + paramString2 + ", fontStyle=" + paramString3 + ", fontSize=" + paramNumber + ", fontFamily=" + paramString4);
    }
    float f = paramNumber.floatValue();
    paramNumber = paramString3.toLowerCase();
    p.g(paramNumber, "(this as java.lang.String).toLowerCase()");
    boolean bool = p.j(paramNumber, "italic");
    paramString3 = paramString3.toLowerCase();
    p.g(paramString3, "(this as java.lang.String).toLowerCase()");
    locali.useFont(paramString4, paramString2, f, bool, p.j(paramString3, "bold"));
    paramString1 = (Number)Float.valueOf(locali.measureText(paramString1));
    AppMethodBeat.o(224788);
    return paramString1;
  }
  
  @JavascriptInterface
  public final String restore(String paramString)
  {
    AppMethodBeat.i(224800);
    p.h(paramString, "canvasId");
    paramString = ((g)this.IBa).restore(paramString);
    AppMethodBeat.o(224800);
    return paramString;
  }
  
  @JavascriptInterface
  public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
  {
    AppMethodBeat.i(224799);
    p.h(paramString1, "canvasId");
    p.h(paramNumber1, "left");
    p.h(paramNumber2, "top");
    p.h(paramNumber3, "width");
    p.h(paramNumber4, "height");
    p.h(paramString2, "layout");
    ((g)this.IBa).save(paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramString2);
    AppMethodBeat.o(224799);
  }
  
  @JavascriptInterface
  public final void setHeight(Number paramNumber)
  {
    AppMethodBeat.i(224796);
    p.h(paramNumber, "height");
    ((g)this.IBa).setHeight(paramNumber);
    AppMethodBeat.o(224796);
  }
  
  @JavascriptInterface
  public final void setVideo(Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(224797);
    p.h(paramNumber1, "top");
    p.h(paramNumber2, "bottom");
    Log.d(this.TAG, "setVideo:" + ((g)this.IBa).getId() + " to " + paramNumber1 + ' ' + paramNumber2);
    ((g)this.IBa).setVideo(paramNumber1, paramNumber2);
    AppMethodBeat.o(224797);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI$Companion;", "", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "devicePixelRatio", "", "getDevicePixelRatio", "()F", "devicePixelRatio$delegate", "Lkotlin/Lazy;", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/MBFontHandlerImpl;", "fontSize", "getFontSize", "isDarkMode", "", "()Z", "viewportHeight", "", "getViewportHeight", "()I", "viewportWidth", "getViewportWidth", "fromPixel", "", "toPixel", "webview-sdk_release"})
  public static final class a
  {
    public static int c(Number paramNumber)
    {
      AppMethodBeat.i(224780);
      p.h(paramNumber, "$this$toPixel");
      int i = kotlin.h.a.cR(paramNumber.floatValue() * getDevicePixelRatio());
      AppMethodBeat.o(224780);
      return i;
    }
    
    public static int d(Number paramNumber)
    {
      AppMethodBeat.i(224781);
      p.h(paramNumber, "$this$fromPixel");
      int i = kotlin.h.a.cR(paramNumber.floatValue() / getDevicePixelRatio());
      AppMethodBeat.o(224781);
      return i;
    }
    
    public static Context getAppContext()
    {
      AppMethodBeat.i(224779);
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      localContext = localContext.getApplicationContext();
      p.g(localContext, "MMApplicationContext.get…text().applicationContext");
      AppMethodBeat.o(224779);
      return localContext;
    }
    
    public static float getDevicePixelRatio()
    {
      AppMethodBeat.i(224782);
      kotlin.f localf = f.fWU();
      a locala = f.IBd;
      float f = ((Number)localf.getValue()).floatValue();
      AppMethodBeat.o(224782);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.f
 * JD-Core Version:    0.7.0.1
 */