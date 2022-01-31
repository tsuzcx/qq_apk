package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.t.n;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import java.lang.reflect.Proxy;
import java.util.Map;
import org.json.JSONObject;

public abstract class a<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.page.b.b
{
  String hzM;
  private boolean iuA = false;
  String iuB;
  private ab iuC;
  private as iuD;
  af iuE;
  ax iuF;
  a<PAGE>.a iuG;
  public ViewGroup iux;
  ap iuy;
  boolean iuz = false;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void aIG()
  {
    if (this.iuF != null)
    {
      ((com.tencent.luggage.sdk.b.a.c)this.bDN).getActionBar().setNavLoadingIconVisibilityResetListener(null);
      ((com.tencent.luggage.sdk.b.a.c)this.bDN).getActionBar().setLoadingIconVisibility(this.iuF.izC);
      this.iuF.setVisibility(8);
      if (t.aw(this.iuF)) {
        ((ViewGroup)this.iuF.getParent()).removeView(this.iuF);
      }
    }
  }
  
  public void Ed(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)this.bDN).cd(paramString);
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected boolean aIE()
  {
    return true;
  }
  
  protected final void aIF()
  {
    if (this.iuz) {}
    String str;
    do
    {
      return;
      if (!wj().gPM.aIe()) {
        break;
      }
      str = com.tencent.mm.plugin.appbrand.appcache.ax.c(wj(), "app-wxss.js");
    } while (TextUtils.isEmpty(str));
    cN("app-wxss.js", str);
    for (;;)
    {
      this.iuz = true;
      return;
      cN("page-frame.html", w.Eo(com.tencent.mm.plugin.appbrand.appcache.ax.c(wj(), "page-frame.html")));
    }
  }
  
  public final ap ar(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.iuy = cX((Context)localObject);
    paramContext = this.iuy;
    localObject = new a.a(this, (Context)localObject);
    this.iuG = ((a.a)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.iuy;
  }
  
  final void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)this.bDN).b(paramJSONObject, paramString, paramObject);
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public boolean bX(String paramString)
  {
    this.hzM = h.cg(paramString);
    this.iuB = paramString;
    Object localObject1 = this.iuC;
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new a.4(this, (v)this.bDN, (ab)localObject1));
    this.iuE.a(new a.3(this));
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c)this.bDN).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)this.bDN).aJo();
    localObject1 = (at)x(at.class);
    localObject2 = ((a.d)localObject2).hhw;
    ((at)localObject1).izb.bEt = false;
    ((at)localObject1).bBU = ((String)localObject2);
    localObject1 = com.tencent.mm.plugin.appbrand.appcache.ax.c(wj(), this.hzM);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      com.tencent.luggage.g.d.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      Ed(paramString);
      ((com.tencent.luggage.sdk.b.a.c)this.bDN).onReady();
      return false;
    }
    if (aIE()) {
      this.iuF = new ax(getContext(), (v)this.bDN);
    }
    aIF();
    paramString = this.hzM;
    int i;
    int j;
    label369:
    String str;
    if (wj().gPM.aIe())
    {
      paramString = wj().gPM.DI(paramString);
      localObject2 = new StringBuilder().append(paramString);
      if (paramString.endsWith("/"))
      {
        paramString = "";
        paramString = paramString + "page-frame.js";
        this.iuy.evaluateJavascript(com.tencent.mm.plugin.appbrand.appcache.ax.c(wj(), paramString), null);
      }
    }
    else
    {
      localObject2 = this.hzM;
      com.tencent.luggage.g.d.i("Luggage.AbstractMPPageViewRenderer", "injectPage %s %d", new Object[] { localObject2, Integer.valueOf(((String)localObject1).length()) });
      i = ((String)localObject1).indexOf("<style>");
      j = ((String)localObject1).indexOf("</style>");
      if ((i != -1) && (j != -i)) {
        break label461;
      }
      paramString = "";
      str = Base64.encodeToString(paramString.getBytes(), 2);
      i = ((String)localObject1).indexOf("<page>");
      j = ((String)localObject1).indexOf("</page>");
      if ((i != -1) && (j != -i)) {
        break label475;
      }
    }
    label461:
    label475:
    for (paramString = "";; paramString = ((String)localObject1).substring(i + 6, j))
    {
      cN((String)localObject2, String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", new Object[] { str, Base64.encodeToString(paramString.getBytes(), 2), w.Eo((String)localObject1) }));
      return true;
      paramString = "/";
      break;
      paramString = ((String)localObject1).substring(i + 7, j);
      break label369;
    }
  }
  
  protected final void cN(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      com.tencent.luggage.g.d.w("Luggage.AbstractMPPageViewRenderer", "injectScript appId = %s, name = %s, source EMPTY", new Object[] { getAppId(), paramString1 });
      return;
    }
    long l = System.currentTimeMillis();
    n.a(((com.tencent.luggage.sdk.b.a.c)this.bDN).aAO(), paramString2, new a.5(this, paramString1, paramString2, l));
  }
  
  protected abstract ap cX(Context paramContext);
  
  public void ce(View paramView)
  {
    this.iux = ((FrameLayout)paramView);
    this.iux.addOnAttachStateChangeListener(new a.1(this));
    this.iuD = new al((v)this.bDN);
    if (this.iuy == null) {
      ((com.tencent.luggage.sdk.b.a.c)this.bDN).aBr();
    }
    this.iuy.ap(getContext());
    this.iuy.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)this.bDN).getFullscreenImpl());
    this.iuy.setOnScrollChangedListener(this.iuD);
    this.iuy.setWebViewLayoutListener(this.iuD);
    this.iuD.setupWebViewTouchInterceptor(this.iuy);
    paramView = this.iuy;
    this.iuC = new ab(getContext(), paramView);
    this.iuC.addView(this.iuD.getContainer());
    this.iuC.setOnPullDownOffsetListener(this.iuD);
    this.iuC.setOnPullDownListener(new ab.a()
    {
      public final void aIH()
      {
        AppMethodBeat.i(140858);
        ((com.tencent.luggage.sdk.b.a.c)a.this.bDN).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.bDN).hashCode() });
        AppMethodBeat.o(140858);
      }
    });
    this.iux.addView(this.iuC);
    this.iuE = new af(this.iuD.getContainer());
    this.iuE.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)this.bDN).getFullscreenImpl());
  }
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.iuy.destroy();
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.c.class, new at((v)this.bDN));
    super.b(f.class, new aw((v)this.bDN));
    a.6 local6 = new a.6();
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, (com.tencent.mm.plugin.appbrand.page.b.d)Proxy.newProxyInstance(com.tencent.mm.plugin.appbrand.page.b.d.class.getClassLoader(), new Class[] { com.tencent.mm.plugin.appbrand.page.b.d.class }, local6));
    com.tencent.luggage.sdk.b.a.b.b.a((v)this.bDN);
  }
  
  public final String getAppId()
  {
    return ((com.tencent.luggage.sdk.b.a.c)this.bDN).getAppId();
  }
  
  public final boolean isRunning()
  {
    return ((com.tencent.luggage.sdk.b.a.c)this.bDN).isRunning();
  }
  
  public final as vB()
  {
    return this.iuD;
  }
  
  public final af vC()
  {
    return this.iuE;
  }
  
  public void vD()
  {
    super.vD();
    this.iuy.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)this.bDN).wr();
    if (!this.iuA)
    {
      if (aIE()) {
        break label42;
      }
      aIG();
    }
    label42:
    while (this.iuF == null) {
      return;
    }
    Object localObject = (FrameLayout)this.iux;
    if (this.iuF.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)this.bDN).getActionBar().aOL();
      ((com.tencent.luggage.sdk.b.a.c)this.bDN).getActionBar().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)this.bDN).getActionBar().setNavLoadingIconVisibilityResetListener(this.iuF);
      this.iuF.izC = bool;
      if ((this.iuF.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.iuF.getParent()).removeView(this.iuF);
      }
      ((FrameLayout)localObject).addView(this.iuF, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.iuF;
    Context localContext = getContext();
    if (((ax)localObject).ixk != null) {
      ((ax)localObject).ixk.ap(localContext);
    }
    this.iuF.aJX();
    this.iuF.bringToFront();
  }
  
  public void vE()
  {
    super.vE();
    this.iuy.onBackground();
  }
  
  public Map<String, m> vF()
  {
    return new com.tencent.luggage.sdk.a().vT();
  }
  
  public void vG()
  {
    this.iuA = true;
    aIG();
  }
  
  public final <T> T x(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.x(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */