package com.tencent.mm.plugin.m.a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.u.c;
import com.tencent.mm.plugin.appbrand.u.c.a;
import com.tencent.mm.plugin.m.a.a.a.a.a;
import com.tencent.mm.plugin.m.a.a.a.a.b;
import com.tencent.mm.plugin.m.a.b.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.g.b.k;
import d.o;
import d.u;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements bd
{
  private aa cdz;
  public Context mContext;
  public com.tencent.mm.plugin.m.a.a.b.a sOm;
  public com.tencent.mm.plugin.m.a.a.a sOn;
  private i tqM;
  private l tqN;
  public LuggageNativeViewJni tqO;
  private com.tencent.mm.plugin.appbrand.s.a.d tqP;
  private boolean tqQ;
  private final View.OnLayoutChangeListener tqR;
  
  public a(Context paramContext, aa paramaa, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(123753);
    this.tqQ = true;
    this.tqR = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(123740);
        if ((paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) || (paramAnonymousInt4 - paramAnonymousInt2 != paramAnonymousInt8 - paramAnonymousInt6)) {
          a.a(a.this, paramAnonymousView.getWidth(), paramAnonymousView.getHeight());
        }
        AppMethodBeat.o(123740);
      }
    };
    c localc = c.lod;
    c.a locala = c.a.loi;
    long l;
    if (localc.lof.containsKey(locala))
    {
      l = ((Long)localc.lof.get(locala)).longValue();
      localc.lof.put(locala, Long.valueOf(c.blW()));
      if (!localc.loe.containsKey(locala)) {
        break label345;
      }
      ad.w("LuggageNativeViewProfileCore", "luggage view performance (LuProfile, " + locala.toString() + ", " + (((Long)localc.lof.get(locala)).longValue() - l) + ", " + (((Long)localc.lof.get(locala)).longValue() - ((Long)localc.loe.get(locala)).longValue()) + "), desc: " + "construct LuggageNative");
    }
    for (;;)
    {
      this.mContext = paramContext;
      this.cdz = paramaa;
      this.tqM = parami;
      this.tqO = new LuggageNativeViewJni();
      this.tqO.init();
      paramContext = (q)this.tqM.P(q.class);
      if (paramContext != null) {
        paramContext.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123741);
            v localv = (v)a.a(a.this).P(v.class);
            a.b(a.this).s(localv.getIsolatePtr(), localv.LU());
            AppMethodBeat.o(123741);
          }
        });
      }
      ad.d("MicroMsg.Luggage.LuggageNativeView", "init");
      if (this.tqN == null) {
        this.tqN = new l(this.cdz);
      }
      setHorizontalFadingEdgeEnabled(false);
      setVerticalScrollBarEnabled(false);
      setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(123753);
      return;
      l = 0L;
      break;
      label345:
      ad.w("LuggageNativeViewProfileCore", "luggage view performance (LuProfile, " + locala.toString() + ", start not yet, desc:" + "construct LuggageNative");
    }
  }
  
  public final void Ck()
  {
    AppMethodBeat.i(123767);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "scrollToTop");
    Object localObject2 = this.sOn;
    Object localObject1 = this.sOm;
    k.h(localObject1, "view");
    localObject2 = ((com.tencent.mm.plugin.m.a.a.a)localObject2).tra;
    k.h(localObject1, "view");
    localObject1 = ae.b(u.P("viewId", Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject1).getViewId())));
    localObject2 = ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).tqZ;
    k.h(localObject1, "arguments");
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.tro;
    com.tencent.mm.plugin.m.a.a.a.a.cMW().f(((com.tencent.mm.plugin.m.a.a.a.a.d)localObject2).trd, "scrollToTop", localObject1);
    AppMethodBeat.o(123767);
  }
  
  public final boolean Cl()
  {
    return this.tqQ;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123773);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript URL:%s script:%s ValueCallback:%s", new Object[] { paramURL.toString(), paramString, paramValueCallback.toString() });
    if (this.tqM != null)
    {
      this.tqM.a(paramURL, paramString, paramValueCallback);
      AppMethodBeat.o(123773);
      return;
    }
    ad.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
    AppMethodBeat.o(123773);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123777);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript");
    AppMethodBeat.o(123777);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(123772);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "addJavascriptInterface name:%s obj:%s", new Object[] { paramString, paramObject.toString() });
    if ((this.tqM != null) && (paramObject != null))
    {
      this.tqM.addJavascriptInterface(paramObject, paramString);
      AppMethodBeat.o(123772);
      return;
    }
    ad.e("MicroMsg.Luggage.LuggageNativeView", "addJavascriptInterface failed. runtime is null.");
    AppMethodBeat.o(123772);
  }
  
  public final void av(Context paramContext)
  {
    AppMethodBeat.i(123754);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "resetContext");
    this.mContext = paramContext;
    AppMethodBeat.o(123754);
  }
  
  final void b(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123771);
    if (this.tqM != null)
    {
      this.tqM.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(123771);
      return;
    }
    ad.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
    AppMethodBeat.o(123771);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(123755);
    draw(paramCanvas);
    AppMethodBeat.o(123755);
    return true;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(123775);
    this.tqO.uninit();
    if (this.tqM != null)
    {
      this.tqM.destroy();
      this.tqM = null;
    }
    for (;;)
    {
      if (this.sOn != null) {
        com.tencent.mm.plugin.m.a.a.a.b(this.sOm);
      }
      removeAllViewsInLayout();
      this.sOn = null;
      this.cdz = null;
      this.tqN = null;
      AppMethodBeat.o(123775);
      return;
      ad.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
    }
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123770);
    Object localObject = paramString;
    int i;
    int j;
    if (!paramString.startsWith(";var __WANativeRenderingStartTime__"))
    {
      if (paramString.startsWith(" \t\t\tvar __mainPageFrameReady__")) {
        break label178;
      }
      i = paramString.indexOf("document.dispatchEvent");
      localObject = paramString;
      if (i >= 0)
      {
        j = paramString.indexOf(";", i);
        localObject = paramString;
        if (j >= 0)
        {
          int k = paramString.indexOf("$gwx");
          localObject = paramString;
          if (k >= 0)
          {
            int m = paramString.indexOf(")", k);
            localObject = paramString;
            if (m >= 0)
            {
              localObject = paramString.substring(k, m + 1);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString.substring(0, i)).append("window.__wxAppCodeReadyCallback__(").append((String)localObject).append(");").append(paramString.substring(j));
              localObject = localStringBuilder.toString();
            }
          }
        }
      }
    }
    for (;;)
    {
      b((String)localObject, paramValueCallback);
      AppMethodBeat.o(123770);
      return;
      label178:
      i = paramString.indexOf("var rewritor = function(suffix, opt, style){");
      localObject = paramString;
      if (i >= 0)
      {
        j = paramString.indexOf("return rewritor;", i);
        localObject = paramString;
        if (j >= 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.substring(0, i)).append("var rewritor = function(suffix, opt, style){\n  opt = opt || {};\n  suffix = suffix || \"\";\n  opt.suffix = suffix;\n  if ( opt.allowIllegalSelector != undefined && _xcInvalid != undefined ) {\n    if ( opt.allowIllegalSelector ) {\n\t  console.warn( \"For developer:\" + _xcInvalid );\n    } else {\n      console.error( _xcInvalid );\n    }\n  }\n  Ca={};\n  css = makeup(file, opt);\n  window.__styleSheetManager__.setCss(info.path, css)\n}\nwindow.__styleSheetManager__.addPath(info.path)\nreturn rewritor;").append(paramString.substring("return rewritor;".length() + j));
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(123760);
    int i = getHeight();
    AppMethodBeat.o(123760);
    return i;
  }
  
  public final View getContentView()
  {
    return this;
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.d getFullscreenImpl()
  {
    return this.tqP;
  }
  
  public final l getJsWebViewInterface()
  {
    return this.tqN;
  }
  
  public final aa getPageView()
  {
    return this.cdz;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(123759);
    String str = ((bd)this.tqM).getUrl();
    AppMethodBeat.o(123759);
    return str;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(123758);
    String str = ((bd)this.tqM).getUserAgentString();
    AppMethodBeat.o(123758);
    return str;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(123761);
    int i = getScrollX();
    AppMethodBeat.o(123761);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(123776);
    int i = getScrollY();
    AppMethodBeat.o(123776);
    return i;
  }
  
  public final View getWrapperView()
  {
    return this;
  }
  
  public final void j(Runnable paramRunnable)
  {
    AppMethodBeat.i(123756);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(123756);
      return;
    }
    postOnAnimation(paramRunnable);
    AppMethodBeat.o(123756);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(123763);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "onBackground");
    if (this.sOn != null) {
      this.sOn.a(this.sOm);
    }
    this.sOm.b(this.tqR);
    AppMethodBeat.o(123763);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(123762);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "onForeground");
    if (this.sOn != null) {
      this.sOn.a(this.sOm, this);
    }
    this.sOm.a(this.tqR);
    AppMethodBeat.o(123762);
  }
  
  public final void r(int paramInt, long paramLong)
  {
    AppMethodBeat.i(123768);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "smoothScrollTo");
    AppMethodBeat.o(123768);
  }
  
  public final void setFlutterRenderEngine(com.tencent.mm.plugin.m.a.a.a parama)
  {
    this.sOn = parama;
  }
  
  public final void setFullscreenImpl(com.tencent.mm.plugin.appbrand.s.a.d paramd)
  {
    AppMethodBeat.i(176022);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "setFullscreenImpl");
    this.tqP = paramd;
    AppMethodBeat.o(176022);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(123774);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "setJsExceptionHandler");
    if (this.tqM != null)
    {
      this.tqM.setJsExceptionHandler(paramh);
      AppMethodBeat.o(123774);
      return;
    }
    ad.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
    AppMethodBeat.o(123774);
  }
  
  public final void setOnScrollChangedListener(av paramav)
  {
    AppMethodBeat.i(123764);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "setOnScrollChangedListener");
    AppMethodBeat.o(123764);
  }
  
  public final void setOnTrimListener(at paramat)
  {
    AppMethodBeat.i(123766);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "setOnTrimListener");
    AppMethodBeat.o(123766);
  }
  
  public final void setWebViewLayoutListener(as paramas)
  {
    AppMethodBeat.i(123765);
    ad.d("MicroMsg.Luggage.LuggageNativeView", "setWebViewLayoutListener");
    AppMethodBeat.o(123765);
  }
  
  public final void setXWebKeyboardImpl(ax paramax) {}
  
  public final void u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123757);
    ad.i("MicroMsg.Luggage.LuggageNativeView", paramString1);
    AppMethodBeat.o(123757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a
 * JD-Core Version:    0.7.0.1
 */