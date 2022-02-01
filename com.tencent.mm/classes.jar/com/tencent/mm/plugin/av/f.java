package com.tencent.mm.plugin.av;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;)V", "canVideoAutoPlay", "", "getCacheDir", "", "getCanvas", "Lcom/eclipsesource/mmv8/V8Object;", "getElementId", "", "getFontSize", "", "getFps", "getHeight", "getId", "getOffsetHeight", "getOffsetTop", "getWidth", "isDarkMode", "isOnScreen", "measureText", "", "text", "fontWeight", "fontStyle", "fontSize", "fontFamily", "restore", "canvasId", "save", "", "left", "top", "width", "height", "layout", "setHeight", "setVideo", "bottom", "Companion", "webview-sdk_release"})
public final class f
  extends a<g>
{
  private static final kotlin.f Pvk;
  private static final i Pvl;
  public static final a Pvm;
  
  static
  {
    AppMethodBeat.i(209734);
    Pvm = new a((byte)0);
    Pvk = kotlin.g.ar((kotlin.g.a.a)b.Pvn);
    i locali = new i();
    locali.init(1024, 1024);
    Pvl = locali;
    AppMethodBeat.o(209734);
  }
  
  public f(g paramg)
  {
    super("wxCanvas", (b)paramg);
    AppMethodBeat.i(209732);
    AppMethodBeat.o(209732);
  }
  
  @JavascriptInterface
  public final boolean canVideoAutoPlay()
  {
    AppMethodBeat.i(209726);
    boolean bool = ((g)this.Pvj).canVideoAutoPlay();
    AppMethodBeat.o(209726);
    return bool;
  }
  
  @JavascriptInterface
  public final String getCacheDir()
  {
    AppMethodBeat.i(209711);
    Object localObject = m.PuL;
    localObject = m.gPp();
    AppMethodBeat.o(209711);
    return localObject;
  }
  
  @JavascriptInterface
  public final V8Object getCanvas()
  {
    AppMethodBeat.i(209702);
    V8Object localV8Object = ((g)this.Pvj).getCanvas();
    AppMethodBeat.o(209702);
    return localV8Object;
  }
  
  @JavascriptInterface
  public final int getElementId()
  {
    AppMethodBeat.i(209704);
    int i = ((g)this.Pvj).getElementId();
    AppMethodBeat.o(209704);
    return i;
  }
  
  @JavascriptInterface
  public final float getFontSize()
  {
    AppMethodBeat.i(209706);
    float f = ((g)this.Pvj).getFontSize();
    AppMethodBeat.o(209706);
    return f;
  }
  
  @JavascriptInterface
  public final int getFps()
  {
    AppMethodBeat.i(209714);
    int i = ((g)this.Pvj).getFps();
    AppMethodBeat.o(209714);
    return i;
  }
  
  @JavascriptInterface
  public final int getHeight()
  {
    AppMethodBeat.i(209719);
    int i = ((g)this.Pvj).getHeight();
    AppMethodBeat.o(209719);
    return i;
  }
  
  @JavascriptInterface
  public final String getId()
  {
    AppMethodBeat.i(209698);
    String str = ((g)this.Pvj).getId();
    AppMethodBeat.o(209698);
    return str;
  }
  
  @JavascriptInterface
  public final int getOffsetHeight()
  {
    AppMethodBeat.i(209723);
    int i = ((g)this.Pvj).getOffsetHeight();
    AppMethodBeat.o(209723);
    return i;
  }
  
  @JavascriptInterface
  public final int getOffsetTop()
  {
    AppMethodBeat.i(209720);
    int i = ((g)this.Pvj).getOffsetTop();
    AppMethodBeat.o(209720);
    return i;
  }
  
  @JavascriptInterface
  public final int getWidth()
  {
    AppMethodBeat.i(209717);
    int i = ((g)this.Pvj).getWidth();
    AppMethodBeat.o(209717);
    return i;
  }
  
  @JavascriptInterface
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(209707);
    boolean bool = ar.isDarkMode();
    AppMethodBeat.o(209707);
    return bool;
  }
  
  @JavascriptInterface
  public final boolean isOnScreen()
  {
    AppMethodBeat.i(209716);
    boolean bool = ((g)this.Pvj).isOnScreen();
    AppMethodBeat.o(209716);
    return bool;
  }
  
  @JavascriptInterface
  public final Number measureText(String paramString1, String paramString2, String paramString3, Number paramNumber, String paramString4)
  {
    AppMethodBeat.i(209710);
    p.k(paramString1, "text");
    p.k(paramString2, "fontWeight");
    p.k(paramString3, "fontStyle");
    p.k(paramNumber, "fontSize");
    p.k(paramString4, "fontFamily");
    i locali = Pvl;
    if (BuildInfo.DEBUG) {
      Log.d(this.TAG, "measureText text=" + paramString1 + " fontWeight=" + paramString2 + ", fontStyle=" + paramString3 + ", fontSize=" + paramNumber + ", fontFamily=" + paramString4);
    }
    float f = paramNumber.floatValue();
    paramNumber = paramString3.toLowerCase();
    p.j(paramNumber, "(this as java.lang.String).toLowerCase()");
    boolean bool = p.h(paramNumber, "italic");
    paramString3 = paramString3.toLowerCase();
    p.j(paramString3, "(this as java.lang.String).toLowerCase()");
    locali.useFont(paramString4, paramString2, f, bool, p.h(paramString3, "bold"));
    paramString1 = (Number)Float.valueOf(locali.measureText(paramString1));
    AppMethodBeat.o(209710);
    return paramString1;
  }
  
  @JavascriptInterface
  public final String restore(String paramString)
  {
    AppMethodBeat.i(209729);
    p.k(paramString, "canvasId");
    paramString = ((g)this.Pvj).restore(paramString);
    AppMethodBeat.o(209729);
    return paramString;
  }
  
  @JavascriptInterface
  public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
  {
    AppMethodBeat.i(209728);
    p.k(paramString1, "canvasId");
    p.k(paramNumber1, "left");
    p.k(paramNumber2, "top");
    p.k(paramNumber3, "width");
    p.k(paramNumber4, "height");
    p.k(paramString2, "layout");
    ((g)this.Pvj).save(paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramString2);
    AppMethodBeat.o(209728);
  }
  
  @JavascriptInterface
  public final void setHeight(Number paramNumber)
  {
    AppMethodBeat.i(209724);
    p.k(paramNumber, "height");
    ((g)this.Pvj).setHeight(paramNumber);
    AppMethodBeat.o(209724);
  }
  
  @JavascriptInterface
  public final void setVideo(Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(209725);
    p.k(paramNumber1, "top");
    p.k(paramNumber2, "bottom");
    Log.d(this.TAG, "setVideo:" + ((g)this.Pvj).getId() + " to " + paramNumber1 + ' ' + paramNumber2);
    ((g)this.Pvj).setVideo(paramNumber1, paramNumber2);
    AppMethodBeat.o(209725);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI$Companion;", "", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "devicePixelRatio", "", "getDevicePixelRatio", "()F", "devicePixelRatio$delegate", "Lkotlin/Lazy;", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/MBFontHandlerImpl;", "fontSize", "getFontSize", "isDarkMode", "", "()Z", "viewportHeight", "", "getViewportHeight", "()I", "viewportWidth", "getViewportWidth", "fromPixel", "", "toPixel", "webview-sdk_release"})
  public static final class a
  {
    public static int d(Number paramNumber)
    {
      AppMethodBeat.i(213826);
      p.k(paramNumber, "$this$toPixel");
      int i = kotlin.h.a.dm(paramNumber.floatValue() * getDevicePixelRatio());
      AppMethodBeat.o(213826);
      return i;
    }
    
    public static int e(Number paramNumber)
    {
      AppMethodBeat.i(213829);
      p.k(paramNumber, "$this$fromPixel");
      int i = kotlin.h.a.dm(paramNumber.floatValue() / getDevicePixelRatio());
      AppMethodBeat.o(213829);
      return i;
    }
    
    public static Context getAppContext()
    {
      AppMethodBeat.i(213824);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localContext = localContext.getApplicationContext();
      p.j(localContext, "MMApplicationContext.get…text().applicationContext");
      AppMethodBeat.o(213824);
      return localContext;
    }
    
    public static float getDevicePixelRatio()
    {
      AppMethodBeat.i(213831);
      kotlin.f localf = f.gPC();
      a locala = f.Pvm;
      float f = ((Number)localf.getValue()).floatValue();
      AppMethodBeat.o(213831);
      return f;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Float>
  {
    public static final b Pvn;
    
    static
    {
      AppMethodBeat.i(211490);
      Pvn = new b();
      AppMethodBeat.o(211490);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.f
 * JD-Core Version:    0.7.0.1
 */