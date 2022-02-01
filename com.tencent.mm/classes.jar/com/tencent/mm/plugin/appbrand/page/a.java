package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.f.a;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Deque;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.page.b.c
{
  public String jZJ;
  public ViewGroup lyD;
  protected ay lyE;
  boolean lyF = false;
  private boolean lyG = false;
  String lyH;
  private ah lyI;
  private bc lyJ;
  am lyK;
  private bm lyL;
  boolean lyM;
  a<PAGE>.d lyN;
  private bb lyO;
  private a lyP;
  be lyQ;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private a Pu(String paramString)
  {
    if (this.lyP == null) {
      if (!((y)((com.tencent.luggage.sdk.b.a.c)CM()).ar(y.class)).bqp()) {
        break label94;
      }
    }
    label94:
    for (Object localObject = new b((byte)0);; localObject = new c((byte)0))
    {
      this.lyP = ((a)localObject);
      localObject = be.lES;
      this.lyQ = be.a.d(this);
      ac.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.lyP.name(), getAppId(), paramString });
      return this.lyP;
    }
  }
  
  private void bpM()
  {
    if (this.lyL != null)
    {
      this.lyL.setVisibility(8);
      if (t.aC(this.lyL))
      {
        ((com.tencent.luggage.sdk.b.a.c)CM()).bqy().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)CM()).bqy().setLoadingIconVisibility(this.lyL.lFU);
        ((ViewGroup)this.lyL.getParent()).removeView(this.lyL);
        ac.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.jZJ });
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)CM()).c(paramJSONObject, paramString, paramObject);
  }
  
  public final bc Cd()
  {
    return this.lyJ;
  }
  
  public final am Ce()
  {
    return this.lyK;
  }
  
  public void Cf()
  {
    ac.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.jZJ, Boolean.valueOf(this.lyG) });
    super.Cf();
    this.lyE.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)CM()).CW();
    if (!this.lyG)
    {
      if (bpG()) {
        break label77;
      }
      bpM();
    }
    label77:
    while (this.lyL == null) {
      return;
    }
    Object localObject = (FrameLayout)this.lyD;
    if (this.lyL.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)CM()).bqy().byi();
      ((com.tencent.luggage.sdk.b.a.c)CM()).bqy().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)CM()).bqy().setNavLoadingIconVisibilityResetListener(this.lyL);
      this.lyL.lFU = bool;
      if ((this.lyL.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.lyL.getParent()).removeView(this.lyL);
      }
      ((FrameLayout)localObject).addView(this.lyL, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.lyL;
    Context localContext = getContext();
    if (((bm)localObject).lCt != null) {
      ((bm)localObject).lCt.aw(localContext);
    }
    this.lyL.brw();
    this.lyL.bringToFront();
    ac.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.jZJ });
  }
  
  public void Cg()
  {
    super.Cg();
    this.lyE.onBackground();
  }
  
  public Map<String, m> Ch()
  {
    return new com.tencent.luggage.sdk.a().Cv();
  }
  
  public void Ci()
  {
    ac.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.jZJ });
    this.lyG = true;
    bpM();
  }
  
  public final JSONObject Do()
  {
    JSONObject localJSONObject = CO().CX().Do();
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)CM()).lCE);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      ac.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { getAppId(), localJSONException });
    }
    return localJSONObject;
  }
  
  public void Pv(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)CM()).cj(paramString);
  }
  
  public <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)CM()).aSt());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final ay ay(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.lyE = dH((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (bt.eWo()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
    {
      ac.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.lyE.addJavascriptInterface(bpI(), "PageLongTaskReporter");
      this.lyM = true;
    }
    paramContext = this.lyE;
    localObject = new d((Context)localObject);
    this.lyN = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.lyE;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.b.a.class, new bh((aa)CM()));
    super.b(paramb);
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected bb boB()
  {
    return null;
  }
  
  protected boolean bpG()
  {
    return (CM() == null) || (!((com.tencent.luggage.sdk.b.a.c)CM()).lCE);
  }
  
  protected final void bpH()
  {
    Object localObject = new JSONObject();
    DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)CM()).jgX.getVDisplayMetrics();
    c((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density)));
    c((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
    localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
    ((com.tencent.luggage.sdk.b.a.c)CM()).aUV().evaluateJavascript((String)localObject, null);
  }
  
  protected com.tencent.mm.plugin.appbrand.performance.g bpI()
  {
    new com.tencent.mm.plugin.appbrand.performance.g()
    {
      public final void notifyLongTask(long paramAnonymousLong)
      {
        AppMethodBeat.i(206171);
        ac.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(206171);
      }
    };
  }
  
  protected final bb bpJ()
  {
    if (this.lyO == null)
    {
      this.lyO = boB();
      if (this.lyO == null) {
        this.lyO = new bf(this);
      }
    }
    return this.lyO;
  }
  
  protected final void bpK()
  {
    if (this.lyF) {
      return;
    }
    try
    {
      Pu("injectAppSharedPageFrameScript").bpK();
      this.lyF = true;
      return;
    }
    catch (ao localao) {}
  }
  
  protected void bpL() {}
  
  public boolean cd(String paramString)
  {
    this.jZJ = ((com.tencent.luggage.sdk.b.a.c)CM()).jZJ;
    this.lyH = ((com.tencent.luggage.sdk.b.a.c)CM()).lyH;
    Object localObject1 = this.lyI;
    super.b(f.class, new bj((aa)CM(), (ah)localObject1)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(206170);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.CM() == null)
        {
          AppMethodBeat.o(206170);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.CM()).N(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206168);
            if ((a.this.CM() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.CM()).jHO != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.CM()).jHO.setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(206168);
          }
        });
        AppMethodBeat.o(206170);
      }
      
      public final void dY(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(206169);
        boolean bool = a.this.CO().getAppConfig().bai();
        Resources localResources = a.this.CO().mContext.getResources();
        if (bool) {}
        for (int i = 2131099650;; i = 2131099828)
        {
          i = com.tencent.mm.plugin.appbrand.z.g.cd(paramAnonymousString2, localResources.getColor(i));
          a(f.a.aw(paramAnonymousString1, bool), i);
          AppMethodBeat.o(206169);
          return;
        }
      }
    });
    this.lyK.a(new ba()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.CM()).lCC == null)
        {
          ac.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.jZJ });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.CM()).lCC.a((aa)a.this.CM(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    if (CO().jdW != null) {
      CO().jdW.a(new ba()
      {
        public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
        {
          AppMethodBeat.i(206167);
          if (((com.tencent.luggage.sdk.b.a.c)a.this.CM()).lCC == null)
          {
            ac.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.jZJ });
            AppMethodBeat.o(206167);
            return;
          }
          ((com.tencent.luggage.sdk.b.a.c)a.this.CM()).lCC.a((aa)a.this.CM(), paramAnonymousAppBrandPageFullScreenView);
          AppMethodBeat.o(206167);
        }
      });
    }
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c)CM()).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)CM()).bqB();
    localObject1 = (bi)Q(bi.class);
    localObject2 = ((com.tencent.mm.plugin.appbrand.config.a.d)localObject2).jCo;
    ((bi)localObject1).lFe.cef = false;
    ((bi)localObject1).caG = ((String)localObject2);
    if (!((com.tencent.luggage.sdk.b.a.c)CM()).aSq().HU(this.jZJ))
    {
      ac.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      Pv(paramString);
      return false;
    }
    if (bpG()) {
      this.lyL = new bm(getContext(), (aa)CM());
    }
    bpL();
    bpK();
    paramString = this.jZJ;
    try
    {
      Pu(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).Pw(paramString);
      paramString = this.jZJ;
    }
    catch (ao localao1)
    {
      try
      {
        Pu(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).Px(paramString);
        return true;
        localao1 = localao1;
        ac.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        CO().finish();
      }
      catch (ao localao2)
      {
        for (;;)
        {
          ac.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
          CO().finish();
        }
      }
    }
  }
  
  public void cm(View paramView)
  {
    this.lyD = ((FrameLayout)paramView);
    this.lyD.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.lyK;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((am)localObject).lEd.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((am.b)((Iterator)localObject).next()).lEz.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.lyJ = new al((aa)CM());
    if (this.lyE == null) {
      ((com.tencent.luggage.sdk.b.a.c)CM()).bey();
    }
    this.lyE.aw(getContext());
    this.lyE.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)CM()).getFullscreenImpl());
    this.lyE.setOnScrollChangedListener(this.lyJ);
    this.lyE.setWebViewLayoutListener(this.lyJ);
    this.lyJ.setupWebViewTouchInterceptor(this.lyE);
    paramView = this.lyE;
    this.lyI = new ah(getContext(), paramView);
    this.lyI.addView(this.lyJ.getContainer());
    this.lyI.setOnPullDownOffsetListener(this.lyJ);
    this.lyI.setOnPullDownListener(new ah.a()
    {
      public final void bpN()
      {
        AppMethodBeat.i(147414);
        if (a.this.CM() == null)
        {
          AppMethodBeat.o(147414);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.CM()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.CM()).aUT() });
        AppMethodBeat.o(147414);
      }
    });
    this.lyD.addView(this.lyI);
    this.lyK = new am(this.lyJ.getContainer());
    this.lyK.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)CM()).getFullscreenImpl());
    if (CO().jdW != null) {
      CO().jdW.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)CM()).getFullscreenImpl());
    }
  }
  
  public final RelativeLayout.LayoutParams cn(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramView != null)
    {
      if (paramView.getId() == -1) {
        paramView.setId(2131296780);
      }
      localLayoutParams.addRule(2, paramView.getId());
    }
    return localLayoutParams;
  }
  
  protected abstract ay dH(Context paramContext);
  
  protected final void dX(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ac.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.jZJ, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.cde = paramString2;
    locala.cdf = paramString2.length();
    final long l = System.currentTimeMillis();
    ac.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.jZJ, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        ac.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.jZJ });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      com.tencent.mm.plugin.appbrand.utils.q.a(((com.tencent.luggage.sdk.b.a.c)CM()).aUV(), paramString1, paramString2, new q.a()
      {
        private void dd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(206174);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(206174);
        }
        
        public final void bZ(String paramAnonymousString)
        {
          AppMethodBeat.i(206173);
          dd(false);
          AppMethodBeat.o(206173);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(206172);
          dd(true);
          AppMethodBeat.o(206172);
        }
      });
      return;
      paramString1 = new URL("https", "servicewechat.com", paramString1);
    }
  }
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.lyJ.a(this.lyE);
    this.lyE.destroy();
    this.lyE = null;
    this.lyD.removeAllViewsInLayout();
    this.lyI.removeAllViewsInLayout();
    this.lyI = null;
    this.lyJ = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new bi((aa)CM()));
    super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new bl((aa)CM()));
    l local8 = new l()
    {
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(206175);
        ac.e("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", new Object[] { paramAnonymousMethod.getName(), org.apache.commons.b.a.toString(paramAnonymousArrayOfObject, "NULL") });
        paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
        AppMethodBeat.o(206175);
        return paramAnonymousObject;
      }
    };
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local8));
    com.tencent.luggage.sdk.b.a.b.b.a((aa)CM());
    if (((com.tencent.luggage.sdk.b.a.c)CM()).CO().getAppConfig().bai())
    {
      this.lyE.setBackgroundColor(android.support.v4.content.b.n(getContext(), 2131099726));
      return;
    }
    this.lyE.setBackgroundColor(-1);
  }
  
  public final String getAppId()
  {
    com.tencent.mm.plugin.appbrand.jsapi.c localc = CM();
    if (localc == null)
    {
      ac.printErrStackTrace("Luggage.AbstractMPPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return localc.getAppId();
  }
  
  protected final String getURL()
  {
    return this.jZJ;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)CM();
    return (localc != null) && (localc.isRunning());
  }
  
  public boolean y(String paramString1, String paramString2)
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void Pw(String paramString);
    
    public abstract void Px(String paramString);
    
    public abstract void bpK();
    
    public abstract String name();
  }
  
  final class b
    implements a.a
  {
    private b() {}
    
    private void Py(String paramString)
    {
      AppMethodBeat.i(147423);
      String str = a.this.bpJ().OF(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramString = new ao(paramString);
        AppMethodBeat.o(147423);
        throw paramString;
      }
      a.this.dX(paramString, str);
      AppMethodBeat.o(147423);
    }
    
    public final void Pw(String paramString)
    {
      AppMethodBeat.i(147425);
      if (!a.this.CO().jdL.bpc())
      {
        AppMethodBeat.o(147425);
        return;
      }
      paramString = a.this.CO().jdL.OY(paramString);
      if ("__APP__".equals(paramString))
      {
        AppMethodBeat.o(147425);
        return;
      }
      a.c(a.this).av(paramString, true);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString;
        Py(paramString + "common.app.js");
        Py(paramString + "webview.app.js");
        AppMethodBeat.o(147425);
        return;
      }
    }
    
    public final void Px(String paramString) {}
    
    public final void bpK()
    {
      AppMethodBeat.i(147424);
      a.c(a.this).av("__APP__", true);
      Py("common.app.js");
      Py("webview.app.js");
      AppMethodBeat.o(147424);
    }
    
    public final String name()
    {
      return "LazyCodeLoading";
    }
  }
  
  final class c
    implements a.a
  {
    private c() {}
    
    public final void Pw(String paramString)
    {
      AppMethodBeat.i(147427);
      if (!a.this.CO().jdL.bpc())
      {
        AppMethodBeat.o(147427);
        return;
      }
      String str = a.this.CO().jdL.OY(paramString);
      Object localObject = new StringBuilder().append(str);
      if (str.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString + "page-frame.js";
        localObject = a.this.bpJ().OF(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString = new ao(paramString);
        AppMethodBeat.o(147427);
        throw paramString;
      }
      a.c(a.this).av(str, false);
      a.this.dX(paramString, (String)localObject);
      AppMethodBeat.o(147427);
    }
    
    public final void Px(String paramString)
    {
      AppMethodBeat.i(147428);
      String str = a.this.bpJ().OF(paramString);
      a.this.dX(paramString, str);
      AppMethodBeat.o(147428);
    }
    
    public final void bpK()
    {
      AppMethodBeat.i(147426);
      a.c(a.this).av("__APP__", false);
      if (a.this.CO().jdL.bpc())
      {
        localObject = a.this.bpJ().OF("app-wxss.js");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new ao("app-wxss.js");
          AppMethodBeat.o(147426);
          throw ((Throwable)localObject);
        }
        a.this.dX("app-wxss.js", (String)localObject);
        AppMethodBeat.o(147426);
        return;
      }
      Object localObject = a.this.bpJ().OF("page-frame.html");
      a.this.dX("page-frame.html", (String)localObject);
      AppMethodBeat.o(147426);
    }
    
    public final String name()
    {
      return "Legacy";
    }
  }
  
  final class d
    extends av
  {
    public d(Context paramContext)
    {
      super();
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      AppMethodBeat.i(147429);
      float f1 = (float)Math.ceil(a.this.CO().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        ac.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
      AppMethodBeat.o(147429);
      return f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */