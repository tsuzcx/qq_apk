package com.tencent.mm.plugin.ax;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.webkit.JavascriptInterface;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.magicbrush.handler.glfont.c;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;)V", "canVideoAutoPlay", "", "getCacheDir", "", "getCanvas", "Lcom/eclipsesource/mmv8/V8Object;", "getElementId", "", "getFontSize", "", "getFps", "getHeight", "getId", "getOffsetHeight", "getOffsetTop", "getWidth", "isDarkMode", "isOnScreen", "measureText", "", "text", "fontWeight", "fontStyle", "fontSize", "fontFamily", "restore", "canvasId", "save", "", "left", "top", "width", "height", "layout", "setHeight", "setVideo", "bottom", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a<g>
{
  private static final j<Float> SLt;
  public static final a WlF;
  private static final i WlG;
  private static final c WlH;
  
  static
  {
    AppMethodBeat.i(260812);
    WlF = new a((byte)0);
    SLt = kotlin.k.cm((kotlin.g.a.a)b.WlI);
    i locali = new i();
    locali.a(WlH);
    locali.init(1024, 1024);
    WlG = locali;
    WlH = f..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(260812);
  }
  
  public f(g paramg)
  {
    super("wxCanvas", (b)paramg);
    AppMethodBeat.i(260787);
    AppMethodBeat.o(260787);
  }
  
  private static final void a(Paint paramPaint, Typeface paramTypeface, String paramString, float paramFloat1, boolean paramBoolean1, float paramFloat2, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(260799);
    if (s.p(paramString, "500"))
    {
      paramPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramPaint.setStrokeWidth(0.8F);
      Log.d("MicroMsg.WxCanvasAPI", "paintConfigCallback fontWeight=" + paramString + ", fontSize=" + paramFloat1);
      AppMethodBeat.o(260799);
      return;
    }
    if (s.p(paramString, "700"))
    {
      paramPaint.setFakeBoldText(true);
      Log.d("MicroMsg.WxCanvasAPI", "paintConfigCallback fontWeight=" + paramString + ", fontSize=" + paramFloat1);
    }
    AppMethodBeat.o(260799);
  }
  
  @JavascriptInterface
  public final boolean canVideoAutoPlay()
  {
    AppMethodBeat.i(260900);
    boolean bool = ((g)this.WlE).canVideoAutoPlay();
    AppMethodBeat.o(260900);
    return bool;
  }
  
  @JavascriptInterface
  public final String getCacheDir()
  {
    AppMethodBeat.i(260854);
    Object localObject = com.tencent.mm.plugin.webcanvas.k.WkZ;
    localObject = com.tencent.mm.plugin.webcanvas.k.ioK();
    AppMethodBeat.o(260854);
    return localObject;
  }
  
  @JavascriptInterface
  public final V8Object getCanvas()
  {
    AppMethodBeat.i(260835);
    V8Object localV8Object = ((g)this.WlE).getCanvas();
    AppMethodBeat.o(260835);
    return localV8Object;
  }
  
  @JavascriptInterface
  public final int getElementId()
  {
    AppMethodBeat.i(260839);
    int i = ((g)this.WlE).getElementId();
    AppMethodBeat.o(260839);
    return i;
  }
  
  @JavascriptInterface
  public final float getFontSize()
  {
    AppMethodBeat.i(260842);
    float f = ((g)this.WlE).getFontSize();
    AppMethodBeat.o(260842);
    return f;
  }
  
  @JavascriptInterface
  public final int getFps()
  {
    AppMethodBeat.i(260859);
    int i = ((g)this.WlE).getFps();
    AppMethodBeat.o(260859);
    return i;
  }
  
  @JavascriptInterface
  public final int getHeight()
  {
    AppMethodBeat.i(260874);
    int i = ((g)this.WlE).getHeight();
    AppMethodBeat.o(260874);
    return i;
  }
  
  @JavascriptInterface
  public final String getId()
  {
    AppMethodBeat.i(260829);
    String str = ((g)this.WlE).getId();
    AppMethodBeat.o(260829);
    return str;
  }
  
  @JavascriptInterface
  public final int getOffsetHeight()
  {
    AppMethodBeat.i(260883);
    int i = ((g)this.WlE).getOffsetHeight();
    AppMethodBeat.o(260883);
    return i;
  }
  
  @JavascriptInterface
  public final int getOffsetTop()
  {
    AppMethodBeat.i(260878);
    int i = ((g)this.WlE).getOffsetTop();
    AppMethodBeat.o(260878);
    return i;
  }
  
  @JavascriptInterface
  public final int getWidth()
  {
    AppMethodBeat.i(260871);
    int i = ((g)this.WlE).getWidth();
    AppMethodBeat.o(260871);
    return i;
  }
  
  @JavascriptInterface
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(260845);
    boolean bool = aw.isDarkMode();
    AppMethodBeat.o(260845);
    return bool;
  }
  
  @JavascriptInterface
  public final boolean isOnScreen()
  {
    AppMethodBeat.i(260863);
    boolean bool = ((g)this.WlE).isOnScreen();
    AppMethodBeat.o(260863);
    return bool;
  }
  
  @JavascriptInterface
  public final Number measureText(String paramString1, String paramString2, String paramString3, Number paramNumber, String paramString4)
  {
    AppMethodBeat.i(260851);
    s.u(paramString1, "text");
    s.u(paramString2, "fontWeight");
    s.u(paramString3, "fontStyle");
    s.u(paramNumber, "fontSize");
    s.u(paramString4, "fontFamily");
    i locali = WlG;
    if (BuildInfo.DEBUG) {
      Log.d(getTAG(), "measureText text=" + paramString1 + " fontWeight=" + paramString2 + ", fontStyle=" + paramString3 + ", fontSize=" + paramNumber + ", fontFamily=" + paramString4);
    }
    float f = paramNumber.floatValue();
    paramNumber = paramString3.toLowerCase();
    s.s(paramNumber, "(this as java.lang.String).toLowerCase()");
    boolean bool = s.p(paramNumber, "italic");
    paramString3 = paramString3.toLowerCase();
    s.s(paramString3, "(this as java.lang.String).toLowerCase()");
    locali.useFont(paramString4, paramString2, f, bool, s.p(paramString3, "bold"));
    paramString1 = (Number)Float.valueOf(locali.measureText(paramString1));
    AppMethodBeat.o(260851);
    return paramString1;
  }
  
  @JavascriptInterface
  public final String restore(String paramString)
  {
    AppMethodBeat.i(260911);
    s.u(paramString, "canvasId");
    paramString = ((g)this.WlE).restore(paramString);
    AppMethodBeat.o(260911);
    return paramString;
  }
  
  @JavascriptInterface
  public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
  {
    AppMethodBeat.i(260906);
    s.u(paramString1, "canvasId");
    s.u(paramNumber1, "left");
    s.u(paramNumber2, "top");
    s.u(paramNumber3, "width");
    s.u(paramNumber4, "height");
    s.u(paramString2, "layout");
    ((g)this.WlE).save(paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramString2);
    AppMethodBeat.o(260906);
  }
  
  @JavascriptInterface
  public final void setHeight(Number paramNumber)
  {
    AppMethodBeat.i(260890);
    s.u(paramNumber, "height");
    ((g)this.WlE).setHeight(paramNumber);
    AppMethodBeat.o(260890);
  }
  
  @JavascriptInterface
  public final void setVideo(Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(260898);
    s.u(paramNumber1, "top");
    s.u(paramNumber2, "bottom");
    Log.d(getTAG(), "setVideo:" + ((g)this.WlE).getId() + " to " + paramNumber1 + ' ' + paramNumber2);
    ((g)this.WlE).setVideo(paramNumber1, paramNumber2);
    AppMethodBeat.o(260898);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPI$Companion;", "", "()V", "TAG", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "devicePixelRatio", "", "getDevicePixelRatio", "()F", "devicePixelRatio$delegate", "Lkotlin/Lazy;", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/MBFontHandlerImpl;", "fontSize", "getFontSize", "isDarkMode", "", "()Z", "paintConfigCallback", "Lcom/tencent/magicbrush/handler/glfont/IPaintConfigCallback;", "getPaintConfigCallback", "()Lcom/tencent/magicbrush/handler/glfont/IPaintConfigCallback;", "viewportHeight", "", "getViewportHeight", "()I", "viewportWidth", "getViewportWidth", "fromPixel", "", "toPixel", "withoutNavigationBarHeight", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static int asQ(int paramInt)
    {
      AppMethodBeat.i(260762);
      a locala = f.WlF;
      if (getAppContext().getResources().getConfiguration().orientation == 2) {}
      for (int i = 1; i != 0; i = 0)
      {
        locala = f.WlF;
        if (!bf.bg(getAppContext())) {
          break;
        }
        locala = f.WlF;
        i = bf.bk(getAppContext());
        AppMethodBeat.o(260762);
        return paramInt - i;
      }
      AppMethodBeat.o(260762);
      return paramInt;
    }
    
    public static int d(Number paramNumber)
    {
      AppMethodBeat.i(260753);
      s.u(paramNumber, "<this>");
      int i = kotlin.h.a.eH(paramNumber.floatValue() * getDevicePixelRatio());
      AppMethodBeat.o(260753);
      return i;
    }
    
    public static int e(Number paramNumber)
    {
      AppMethodBeat.i(260758);
      s.u(paramNumber, "<this>");
      int i = kotlin.h.a.eH(paramNumber.floatValue() / getDevicePixelRatio());
      AppMethodBeat.o(260758);
      return i;
    }
    
    public static Context getAppContext()
    {
      AppMethodBeat.i(260745);
      Context localContext = MMApplicationContext.getContext().getApplicationContext();
      s.s(localContext, "getContext().applicationContext");
      AppMethodBeat.o(260745);
      return localContext;
    }
    
    public static float getDevicePixelRatio()
    {
      AppMethodBeat.i(260765);
      float f = ((Number)f.ioV().getValue()).floatValue();
      AppMethodBeat.o(260765);
      return f;
    }
    
    public static int hBY()
    {
      AppMethodBeat.i(260771);
      int i = e((Number)Integer.valueOf(asQ(ao.mX(getAppContext()).width)));
      AppMethodBeat.o(260771);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Float>
  {
    public static final b WlI;
    
    static
    {
      AppMethodBeat.i(260742);
      WlI = new b();
      AppMethodBeat.o(260742);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.f
 * JD-Core Version:    0.7.0.1
 */