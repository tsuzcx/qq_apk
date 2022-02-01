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
import com.tencent.mm.plugin.appbrand.jsapi.f.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.s.c.a;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.m.a.a.a.a.a;
import com.tencent.mm.plugin.m.a.a.a.a.b;
import com.tencent.mm.plugin.m.a.b.a.a;
import d.o;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements ax
{
  private z ckP;
  public Context mContext;
  private i vNK;
  private l vNL;
  public LuggageNativeViewJni vNM;
  private com.tencent.mm.plugin.appbrand.platform.window.d vNN;
  public com.tencent.mm.plugin.m.a.a.a vNO;
  public com.tencent.mm.plugin.m.a.a.b.a vNP;
  private boolean vNQ;
  private final View.OnLayoutChangeListener vNR;
  
  public a(Context paramContext, z paramz, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(123753);
    this.vNQ = true;
    this.vNR = new View.OnLayoutChangeListener()
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
    c localc = c.muS;
    c.a locala = c.a.muW;
    long l;
    if (localc.muU.containsKey(locala))
    {
      l = ((Long)localc.muU.get(locala)).longValue();
      localc.muU.put(locala, Long.valueOf(c.bxP()));
      if (!localc.muT.containsKey(locala)) {
        break label351;
      }
      com.tencent.mm.sdk.platformtools.ae.w("LuggageNativeViewProfileCore", "luggage view performance (LuProfile, " + locala.toString() + ", " + (((Long)localc.muU.get(locala)).longValue() - l) + ", " + (((Long)localc.muU.get(locala)).longValue() - ((Long)localc.muT.get(locala)).longValue()) + "), desc: " + "construct LuggageNative");
    }
    for (;;)
    {
      this.mContext = paramContext;
      this.ckP = paramz;
      this.vNK = parami;
      this.vNM = new LuggageNativeViewJni();
      paramContext = this.vNM;
      paramContext.cmg = paramContext.createNativeRender();
      paramContext = (q)this.vNK.P(q.class);
      if (paramContext != null) {
        paramContext.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123741);
            v localv = (v)a.a(a.this).P(v.class);
            LuggageNativeViewJni localLuggageNativeViewJni = a.b(a.this);
            long l1 = localv.getIsolatePtr();
            long l2 = localv.Nz();
            if (localLuggageNativeViewJni.cmg <= 0L)
            {
              com.tencent.mm.sdk.platformtools.ae.e(LuggageNativeViewJni.TAG, "mRenderPtr <= 0");
              AppMethodBeat.o(123741);
              return;
            }
            localLuggageNativeViewJni.initJsBinding(localLuggageNativeViewJni.cmg, l1, l2);
            AppMethodBeat.o(123741);
          }
        });
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "init");
      if (this.vNL == null) {
        this.vNL = new l(this.ckP);
      }
      setHorizontalFadingEdgeEnabled(false);
      setVerticalScrollBarEnabled(false);
      setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(123753);
      return;
      l = 0L;
      break;
      label351:
      com.tencent.mm.sdk.platformtools.ae.w("LuggageNativeViewProfileCore", "luggage view performance (LuProfile, " + locala.toString() + ", start not yet, desc:" + "construct LuggageNative");
    }
  }
  
  public final void Dq()
  {
    AppMethodBeat.i(123767);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "scrollToTop");
    Object localObject2 = this.vNO;
    Object localObject1 = this.vNP;
    d.g.b.p.h(localObject1, "view");
    localObject2 = ((com.tencent.mm.plugin.m.a.a.a)localObject2).vNZ;
    d.g.b.p.h(localObject1, "view");
    localObject1 = d.a.ae.c(d.u.R("viewId", Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject1).getViewId())));
    localObject2 = ((com.tencent.mm.plugin.m.a.a.b.b)localObject2).vNY;
    d.g.b.p.h(localObject1, "arguments");
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.vOn;
    com.tencent.mm.plugin.m.a.a.a.a.dmP().g(((com.tencent.mm.plugin.m.a.a.a.a.d)localObject2).vOc, "scrollToTop", localObject1);
    AppMethodBeat.o(123767);
  }
  
  public final boolean Dr()
  {
    return this.vNQ;
  }
  
  public final boolean Ds()
  {
    return false;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123773);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript URL:%s script:%s ValueCallback:%s", new Object[] { paramURL.toString(), paramString, paramValueCallback.toString() });
    if (this.vNK != null)
    {
      this.vNK.a(paramURL, paramString, paramValueCallback);
      AppMethodBeat.o(123773);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
    AppMethodBeat.o(123773);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123777);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript");
    AppMethodBeat.o(123777);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(123772);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "addJavascriptInterface name:%s obj:%s", new Object[] { paramString, paramObject.toString() });
    if ((this.vNK != null) && (paramObject != null))
    {
      this.vNK.addJavascriptInterface(paramObject, paramString);
      AppMethodBeat.o(123772);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Luggage.LuggageNativeView", "addJavascriptInterface failed. runtime is null.");
    AppMethodBeat.o(123772);
  }
  
  public final void ax(Context paramContext)
  {
    AppMethodBeat.i(123754);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "resetContext");
    this.mContext = paramContext;
    AppMethodBeat.o(123754);
  }
  
  final void b(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(123771);
    if (this.vNK != null)
    {
      this.vNK.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(123771);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
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
    LuggageNativeViewJni localLuggageNativeViewJni = this.vNM;
    if (localLuggageNativeViewJni.cmg > 0L)
    {
      localLuggageNativeViewJni.destroyNativeRender(localLuggageNativeViewJni.cmg);
      localLuggageNativeViewJni.cmg = -1L;
    }
    if (this.vNK != null)
    {
      this.vNK.destroy();
      this.vNK = null;
    }
    for (;;)
    {
      if (this.vNO != null) {
        com.tencent.mm.plugin.m.a.a.a.a(this.vNP);
      }
      removeAllViewsInLayout();
      this.vNO = null;
      this.ckP = null;
      this.vNL = null;
      AppMethodBeat.o(123775);
      return;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
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
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    return this.vNN;
  }
  
  public final l getJsWebViewInterface()
  {
    return this.vNL;
  }
  
  public final z getPageView()
  {
    return this.ckP;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(123759);
    String str = ((ax)this.vNK).getUrl();
    AppMethodBeat.o(123759);
    return str;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(123758);
    String str = ((ax)this.vNK).getUserAgentString();
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "onBackground");
    if (this.vNO != null)
    {
      com.tencent.mm.plugin.m.a.a.a locala = this.vNO;
      Object localObject = this.vNP;
      d.g.b.p.h(localObject, "view");
      locala.vNX -= 1;
      locala.vNZ.c((com.tencent.mm.plugin.m.a.a.b.a)localObject);
      if (locala.vNX <= 0)
      {
        localObject = locala.cog;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.widget.input.u)localObject).b((u.c)locala);
        }
      }
    }
    this.vNP.b(this.vNR);
    AppMethodBeat.o(123763);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(123762);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "onForeground");
    com.tencent.mm.plugin.m.a.a.a locala;
    Object localObject1;
    com.tencent.mm.plugin.m.a.a.b.b localb;
    Object localObject2;
    if (this.vNO != null)
    {
      locala = this.vNO;
      localObject1 = this.vNP;
      d.g.b.p.h(localObject1, "view");
      d.g.b.p.h(this, "parent");
      locala.vNX += 1;
      localb = locala.vNZ;
      d.g.b.p.h(localObject1, "view");
      d.g.b.p.h(this, "parent");
      localb.d((com.tencent.mm.plugin.m.a.a.b.a)localObject1);
      if (localb.vOD.contains(localObject1)) {
        break label254;
      }
      if (!localb.vOD.empty())
      {
        localObject2 = localb.vOD.peek();
        d.g.b.p.g(localObject2, "viewStack.peek()");
        localb.c((com.tencent.mm.plugin.m.a.a.b.a)localObject2);
      }
      localb.vOD.push(localObject1);
      ((com.tencent.mm.plugin.m.a.a.b.a)localObject1).dmU();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.m.a.a.b.a)localObject1).onForeground();
      localObject2 = d.a.ae.c(d.u.R("viewId", Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject1).getViewId())));
      Object localObject3 = localb.vNY;
      Object localObject4 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
      com.tencent.mm.plugin.m.a.a.a.a.dmP().g(((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).vOc, "onForeground", localObject2);
      localb.a((com.tencent.mm.plugin.m.a.a.b.a)localObject1, this, true);
      localb.vOC = ((com.tencent.mm.plugin.m.a.a.b.a)localObject1);
      locala.cog = n.df((View)this);
      localObject1 = locala.cog;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.widget.input.u)localObject1).a((u.c)locala);
      }
      this.vNP.a(this.vNR);
      AppMethodBeat.o(123762);
      return;
      label254:
      do
      {
        localObject2 = (com.tencent.mm.plugin.m.a.a.b.a)localb.vOD.peek();
        if ((d.g.b.p.i(localObject2, localObject1) ^ true))
        {
          ((com.tencent.mm.plugin.m.a.a.b.a)localObject2).dmT();
          d.g.b.p.g(localObject2, "top");
          localb.c((com.tencent.mm.plugin.m.a.a.b.a)localObject2);
          d.g.b.p.h(localObject2, "view");
          ((com.tencent.mm.plugin.m.a.a.b.a)localObject2).onDestroy();
          localObject3 = d.a.ae.c(d.u.R("viewId", Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject2).getViewId())));
          localObject4 = localb.vNY;
          a.b localb1 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
          com.tencent.mm.plugin.m.a.a.a.a.dmP().g(((com.tencent.mm.plugin.m.a.a.a.a.d)localObject4).vOc, "onDestroy", localObject3);
          localb.vOB.remove(Long.valueOf(((com.tencent.mm.plugin.m.a.a.b.a)localObject2).getViewId()));
          localb.vOD.pop();
        }
      } while ((d.g.b.p.i(localObject2, localObject1) ^ true));
    }
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(123768);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "smoothScrollTo");
    AppMethodBeat.o(123768);
  }
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setFlutterRenderEngine(com.tencent.mm.plugin.m.a.a.a parama)
  {
    this.vNO = parama;
  }
  
  public final void setFullscreenImpl(com.tencent.mm.plugin.appbrand.platform.window.d paramd)
  {
    AppMethodBeat.i(176022);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "setFullscreenImpl");
    this.vNN = paramd;
    AppMethodBeat.o(176022);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(123774);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "setJsExceptionHandler");
    if (this.vNK != null)
    {
      this.vNK.setJsExceptionHandler(paramh);
      AppMethodBeat.o(123774);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Luggage.LuggageNativeView", "evaluateJavascript failed. runtime is null.");
    AppMethodBeat.o(123774);
  }
  
  public final void setOnScrollChangedListener(ap paramap)
  {
    AppMethodBeat.i(123764);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "setOnScrollChangedListener");
    AppMethodBeat.o(123764);
  }
  
  public final void setOnTrimListener(an paraman)
  {
    AppMethodBeat.i(123766);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "setOnTrimListener");
    AppMethodBeat.o(123766);
  }
  
  public final void setWebViewLayoutListener(am paramam)
  {
    AppMethodBeat.i(123765);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Luggage.LuggageNativeView", "setWebViewLayoutListener");
    AppMethodBeat.o(123765);
  }
  
  public final void setXWebKeyboardImpl(ar paramar) {}
  
  public final void x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123757);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Luggage.LuggageNativeView", paramString1);
    AppMethodBeat.o(123757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a
 * JD-Core Version:    0.7.0.1
 */