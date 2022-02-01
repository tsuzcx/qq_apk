package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
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
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.performance.g;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.widget.input.aq;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Deque;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.c.a<PAGE>
  implements com.tencent.luggage.sdk.b.a.d
{
  String rAF;
  ViewGroup tth;
  bd tti;
  boolean ttj = false;
  private boolean ttk = false;
  String ttl;
  private ak ttm;
  private bh ttn;
  ap tto;
  private br ttp;
  boolean ttq;
  a<PAGE>.d ttr;
  private bg tts;
  private a ttt;
  bj ttu;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public boolean H(String paramString1, String paramString2)
  {
    return false;
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext().getApplicationContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public <T> T aa(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)aqX()).cbl());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.aa(paramClass);
  }
  
  protected final a aeu(String paramString)
  {
    if (this.ttt == null)
    {
      this.ttt = cDG();
      this.ttu = cDF();
      Log.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.ttt.name(), getAppId(), paramString });
    }
    return this.ttt;
  }
  
  public void aev(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)aqX()).fo(paramString);
  }
  
  public final bh aqd()
  {
    return this.ttn;
  }
  
  public void aqe()
  {
    Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.rAF, Boolean.valueOf(this.ttk) });
    super.aqe();
    this.tti.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)aqX()).arg();
    if ((!this.ttk) && (this.ttp != null))
    {
      Object localObject = (FrameLayout)this.tth;
      if (this.ttp.getParent() != localObject)
      {
        boolean bool = ((com.tencent.luggage.sdk.b.a.c)aqX()).cEC().cOW();
        ((com.tencent.luggage.sdk.b.a.c)aqX()).cEC().setLoadingIconVisibility(true);
        ((com.tencent.luggage.sdk.b.a.c)aqX()).cEC().setNavLoadingIconVisibilityResetListener(this.ttp);
        this.ttp.tAX = bool;
        if ((this.ttp.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.ttp.getParent()).removeView(this.ttp);
        }
        ((FrameLayout)localObject).addView(this.ttp, new FrameLayout.LayoutParams(-1, -1));
      }
      localObject = this.ttp;
      Context localContext = getContext();
      if (((br)localObject).txb != null) {
        ((br)localObject).txb.bm(localContext);
      }
      this.ttp.cGb();
      this.ttp.bringToFront();
      Log.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.rAF });
    }
  }
  
  public void aqf()
  {
    super.aqf();
    this.tti.onBackground();
  }
  
  public final boolean aqg()
  {
    return false;
  }
  
  public Map<String, p> aqh()
  {
    return new com.tencent.luggage.sdk.a().aqy();
  }
  
  public void aqi()
  {
    Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.rAF });
    this.ttk = true;
    if (this.ttp != null)
    {
      this.ttp.setVisibility(8);
      if (androidx.core.g.z.ay(this.ttp))
      {
        ((com.tencent.luggage.sdk.b.a.c)aqX()).cEC().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)aqX()).cEC().setLoadingIconVisibility(this.ttp.tAX);
        ((ViewGroup)this.ttp.getParent()).removeView(this.ttp);
        Log.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.rAF });
      }
    }
  }
  
  public final JSONObject arC()
  {
    JSONObject localJSONObject = com.tencent.luggage.sdk.h.c.h(aqZ().ari().arC());
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)aqX()).txm);
      try
      {
        if (aqZ().asA().epm != e.etJ) {
          break label112;
        }
        bool = true;
        localJSONObject.put("prerender", bool);
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          boolean bool;
          Log.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put prerender e=%s", new Object[] { getAppId(), localJSONException2 });
        }
      }
      localJSONObject.remove("permission");
      localJSONObject.remove("subpackages");
      localJSONObject.remove("pages");
      return localJSONObject;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Log.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { getAppId(), localJSONException1 });
        continue;
        label112:
        bool = false;
      }
    }
  }
  
  protected final void atd()
  {
    if (this.ttj) {
      return;
    }
    try
    {
      aeu("injectAppSharedPageFrameScript").atd();
      this.ttj = true;
      return;
    }
    catch (as localas) {}
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.a.a.class, new bm((ad)aqX()));
    super.b(paramb);
  }
  
  public boolean b(String paramString, cb paramcb)
  {
    this.rAF = ((com.tencent.luggage.sdk.b.a.c)aqX()).cgR();
    this.ttl = ((com.tencent.luggage.sdk.b.a.c)aqX()).cEE();
    Object localObject = this.ttm;
    super.b(f.class, new bo((ad)aqX(), (ak)localObject)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(147418);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.aqX() == null)
        {
          AppMethodBeat.o(147418);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147416);
            if ((a.this.aqX() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).getContentView() != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).getContentView().setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(147416);
          }
        });
        AppMethodBeat.o(147418);
      }
      
      public final void fj(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(147417);
        boolean bool = a.this.aqZ().getAppConfig().ckr();
        if (a.this.aqZ().asA().aqE() == com.tencent.mm.plugin.appbrand.config.z.raW)
        {
          i = 0;
          a(f.a.aN(paramAnonymousString1, bool), i);
          AppMethodBeat.o(147417);
          return;
        }
        Resources localResources = a.this.aqZ().mContext.getResources();
        if (bool) {}
        for (int i = com.tencent.luggage.m.a.a.BG_2;; i = com.tencent.luggage.m.a.a.White)
        {
          i = i.dq(paramAnonymousString2, localResources.getColor(i));
          break;
        }
      }
    });
    this.tto.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).txk == null)
        {
          Log.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.rAF });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).txk.a((ad)a.this.aqX(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    ((com.tencent.luggage.sdk.b.a.c)aqX()).c(paramcb);
    int j;
    if (isRunning())
    {
      Objects.requireNonNull((com.tencent.luggage.sdk.b.a.c)aqX());
      Objects.requireNonNull(((com.tencent.luggage.sdk.b.a.c)aqX()).getPageConfig());
      Objects.requireNonNull(((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ());
      if (((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ().asA().aqE() != com.tencent.mm.plugin.appbrand.config.z.raW) {
        break label297;
      }
      i = 0;
      j = i.dq(((com.tencent.luggage.sdk.b.a.c)aqX()).getPageConfig().qWt, i);
      if (((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ().asA().aqE() != com.tencent.mm.plugin.appbrand.config.z.raW) {
        break label335;
      }
    }
    label297:
    label335:
    for (int i = 0;; i = -16777216)
    {
      this.tti.setBackgroundColor(i | j);
      localObject = (bn)aa(bn.class);
      String str = cDJ();
      ((bn)localObject).tAi.esd = false;
      ((bn)localObject).enx = str;
      if (((com.tencent.luggage.sdk.b.a.c)aqX()).cbk().an(this.rAF, true)) {
        break label342;
      }
      Log.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      aev(paramString);
      return false;
      if (((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ().getAppConfig().ckr())
      {
        i = androidx.core.content.a.w(getContext(), com.tencent.luggage.m.a.a.Dark_0);
        break;
      }
      i = -1;
      break;
    }
    label342:
    if (d(paramcb)) {
      this.ttp = new br(aqZ().mContext, (ad)aqX());
    }
    cDK();
    atd();
    paramString = this.rAF;
    try
    {
      aeu(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).fF(paramString);
      paramString = this.rAF;
    }
    catch (as paramcb)
    {
      try
      {
        aeu(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).fE(paramString);
        return true;
        paramcb = paramcb;
        Log.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
      }
      catch (as paramcb)
      {
        for (;;)
        {
          Log.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        }
      }
    }
  }
  
  public final bd bo(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.tti = eC((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      Log.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.tti.addJavascriptInterface(cDE(), "PageLongTaskReporter");
      this.ttq = true;
    }
    paramContext = this.tti;
    localObject = new d((Context)localObject);
    this.ttr = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.tti;
  }
  
  protected g cDE()
  {
    new g()
    {
      public final void notifyLongTask(long paramAnonymousLong)
      {
        AppMethodBeat.i(169500);
        Log.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(169500);
      }
    };
  }
  
  protected bj cDF()
  {
    bj.a locala = bj.tzS;
    return bj.a.d(this);
  }
  
  protected a cDG()
  {
    if (((ab)((com.tencent.luggage.sdk.b.a.c)aqX()).aN(ab.class)).cEw()) {
      return new b((byte)0);
    }
    return new c((byte)0);
  }
  
  protected final bg cDH()
  {
    if (this.tts == null)
    {
      this.tts = cDI();
      if (this.tts == null) {
        this.tts = new bk(this);
      }
    }
    return this.tts;
  }
  
  protected bg cDI()
  {
    return null;
  }
  
  protected String cDJ()
  {
    return ((com.tencent.luggage.sdk.b.a.c)aqX()).getPageConfig().qWy;
  }
  
  protected void cDK() {}
  
  public final RelativeLayout.LayoutParams cP(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramView != null)
    {
      if (paramView.getId() == -1) {
        paramView.setId(com.tencent.luggage.m.a.d.app_brand_page_view_footer);
      }
      localLayoutParams.addRule(2, paramView.getId());
    }
    return localLayoutParams;
  }
  
  final void d(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)aqX()).d(paramJSONObject, paramString, paramObject);
  }
  
  protected boolean d(cb paramcb)
  {
    if ((aqX() != null) && (((com.tencent.luggage.sdk.b.a.c)aqX()).txm)) {
      return false;
    }
    if (((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ().asA().aqE() == com.tencent.mm.plugin.appbrand.config.z.raW) {
      return false;
    }
    return cb.tBs == paramcb;
  }
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.ttn.a(this.tti);
    this.tti.destroy();
    this.tti = null;
    this.tth.removeAllViewsInLayout();
    this.ttm.removeAllViewsInLayout();
    this.ttm = null;
    this.ttn = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new bn((ad)aqX()));
    super.b(h.class, new bq((ad)aqX()));
    a.7 local7 = new a.7();
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local7));
    com.tencent.luggage.sdk.b.a.c.b.a((ad)aqX());
  }
  
  public boolean e(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected abstract bd eC(Context paramContext);
  
  protected final void fi(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      Log.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.rAF, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.eqP = paramString2;
    locala.eqQ = paramString2.length();
    final long l = System.currentTimeMillis();
    Log.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.rAF, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        Log.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.rAF });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      com.tencent.mm.plugin.appbrand.utils.z.a(((com.tencent.luggage.sdk.b.a.c)aqX()).getJsRuntime(), paramString1, paramString2, new z.a()
      {
        private void fb(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(169503);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(169503);
        }
        
        public final void eW(String paramAnonymousString)
        {
          AppMethodBeat.i(169502);
          fb(false);
          AppMethodBeat.o(169502);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(169501);
          fb(true);
          AppMethodBeat.o(169501);
        }
      });
      return;
      paramString1 = new URL("https", WeChatHosts.domainString(a.g.host_servicewechat_com), paramString1);
    }
  }
  
  public final ap getCustomViewContainer()
  {
    return this.tto;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)aqX();
    return (localc != null) && (localc.isRunning());
  }
  
  public void onViewCreated(View paramView)
  {
    this.tth = ((FrameLayout)paramView);
    this.tth.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.tto;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((ap)localObject).tzf.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((ap.b)((Iterator)localObject).next()).tzB.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.ttn = new aq((ad)aqX());
    if (this.tti == null) {
      ((com.tencent.luggage.sdk.b.a.c)aqX()).cpF();
    }
    this.tti.bm(getContext());
    this.tti.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)aqX()).getFullscreenImpl());
    this.tti.setOnScrollChangedListener(this.ttn);
    this.tti.setWebViewLayoutListener(this.ttn);
    this.ttn.setupWebViewTouchInterceptor(this.tti);
    bd localbd = this.tti;
    if (aqZ() != null) {}
    for (paramView = aqZ().mContext;; paramView = getContext())
    {
      this.ttm = new ak(paramView, localbd);
      this.ttm.addView(this.ttn.getContainer());
      this.ttm.setOnPullDownOffsetListener(this.ttn);
      this.ttm.setOnPullDownListener(new ak.a()
      {
        public final void cDL()
        {
          AppMethodBeat.i(147414);
          if (a.this.aqX() == null)
          {
            AppMethodBeat.o(147414);
            return;
          }
          ((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.aqX()).getComponentId() });
          AppMethodBeat.o(147414);
        }
      });
      this.tth.addView(this.ttm);
      this.tto = new ap(this.ttn.getContainer());
      this.tto.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)aqX()).getFullscreenImpl());
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void atd();
    
    public abstract void fE(String paramString);
    
    public abstract void fF(String paramString);
    
    public abstract boolean fG(String paramString);
    
    public abstract String name();
  }
  
  final class b
    implements a.a
  {
    private b() {}
    
    private void aew(String paramString)
    {
      AppMethodBeat.i(147423);
      String str = a.this.cDH().aeU(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramString = new as(paramString);
        AppMethodBeat.o(147423);
        throw paramString;
      }
      a.this.fi(paramString, str);
      AppMethodBeat.o(147423);
    }
    
    public final void atd()
    {
      AppMethodBeat.i(147424);
      a.c(a.this).l("__APP__", true);
      aew("common.app.js");
      aew("webview.app.js");
      AppMethodBeat.o(147424);
    }
    
    public final void fE(String paramString) {}
    
    public final void fF(String paramString)
    {
      AppMethodBeat.i(147425);
      if (!a.this.aqZ().qsC.cBX())
      {
        AppMethodBeat.o(147425);
        return;
      }
      paramString = a.this.aqZ().qsC.adN(paramString);
      if ("__APP__".equals(paramString))
      {
        AppMethodBeat.o(147425);
        return;
      }
      a.c(a.this).l(paramString, true);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString;
        aew(paramString + "common.app.js");
        aew(paramString + "webview.app.js");
        AppMethodBeat.o(147425);
        return;
      }
    }
    
    public final boolean fG(String paramString)
    {
      AppMethodBeat.i(324956);
      boolean bool = "webview.app.js".equals(paramString);
      AppMethodBeat.o(324956);
      return bool;
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
    
    public final void atd()
    {
      AppMethodBeat.i(147426);
      a.c(a.this).l("__APP__", false);
      if (a.this.aqZ().qsC.cBX())
      {
        localObject = a.this.cDH().aeU("app-wxss.js");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new as("app-wxss.js");
          AppMethodBeat.o(147426);
          throw ((Throwable)localObject);
        }
        a.this.fi("app-wxss.js", (String)localObject);
        AppMethodBeat.o(147426);
        return;
      }
      Object localObject = a.this.cDH().aeU("page-frame.html");
      a.this.fi("page-frame.html", (String)localObject);
      AppMethodBeat.o(147426);
    }
    
    public final void fE(String paramString)
    {
      AppMethodBeat.i(147428);
      String str = a.this.cDH().aeU(paramString);
      a.this.fi(paramString, str);
      AppMethodBeat.o(147428);
    }
    
    public final void fF(String paramString)
    {
      AppMethodBeat.i(147427);
      if (!a.this.aqZ().qsC.cBX())
      {
        AppMethodBeat.o(147427);
        return;
      }
      String str = a.this.aqZ().qsC.adN(paramString);
      Object localObject = new StringBuilder().append(str);
      if (str.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString + "page-frame.js";
        localObject = a.this.cDH().aeU(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString = new as(paramString);
        AppMethodBeat.o(147427);
        throw paramString;
      }
      a.c(a.this).l(str, false);
      a.this.fi(paramString, (String)localObject);
      AppMethodBeat.o(147427);
    }
    
    public final boolean fG(String paramString)
    {
      AppMethodBeat.i(324951);
      if (("app-wxss.js".equals(paramString)) || ("page-frame.html".equals(paramString)))
      {
        AppMethodBeat.o(324951);
        return true;
      }
      AppMethodBeat.o(324951);
      return false;
    }
    
    public final String name()
    {
      return "Legacy";
    }
  }
  
  final class d
    extends ba
  {
    public d(Context paramContext)
    {
      super();
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      AppMethodBeat.i(147429);
      float f1 = (float)Math.ceil(a.this.aqZ().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        Log.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
      AppMethodBeat.o(147429);
      return f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */