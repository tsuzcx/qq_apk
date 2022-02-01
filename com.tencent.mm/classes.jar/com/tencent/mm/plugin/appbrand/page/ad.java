package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.l.m;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.menu.w;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.utils.am;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
  extends e
  implements h
{
  private static final int twX = a.d.app_brand_action_bar_container;
  private volatile boolean bzr;
  public volatile boolean eny;
  private ViewGroup ewc;
  private Context mContext;
  private List<w> qAp;
  private volatile boolean qwD;
  public com.tencent.mm.plugin.appbrand.platform.window.c qwF;
  private volatile AppBrandRuntime qwG;
  private String rAF;
  public bd tti;
  private String ttl;
  public FrameLayout tuD;
  protected ca tvz;
  private final int twY;
  private af twZ;
  private final Class<? extends af> txa;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d txb;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b txc;
  public ap txd;
  public bh txe;
  private com.tencent.mm.plugin.appbrand.o.a txf;
  protected c txg;
  public f.a txh;
  private com.tencent.mm.plugin.appbrand.platform.window.d txi;
  public final com.tencent.mm.plugin.appbrand.widget.h.b txj;
  public u txk;
  private ao txl;
  public boolean txm;
  private final com.tencent.mm.plugin.appbrand.widget.dialog.p txn;
  public String txo;
  private boolean txp;
  private final Object txq;
  private int[] txr;
  private int[] txs;
  private ce txu;
  private final AtomicBoolean txv;
  private boolean txw;
  
  public ad()
  {
    this(null);
  }
  
  protected ad(Class<? extends af> paramClass)
  {
    AppMethodBeat.i(135144);
    this.twY = a.d.app_brand_action_bar;
    this.bzr = false;
    this.qwD = false;
    this.eny = false;
    this.txh = null;
    this.txj = new com.tencent.mm.plugin.appbrand.widget.h.b(this);
    this.tvz = null;
    this.qwF = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    this.txm = false;
    this.txn = new com.tencent.mm.plugin.appbrand.widget.dialog.p()
    {
      public final void n(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176625);
        if (paramAnonymousBoolean.booleanValue())
        {
          ad.this.iW(false);
          AppMethodBeat.o(176625);
          return;
        }
        ad.this.iW(true);
        AppMethodBeat.o(176625);
      }
    };
    this.txp = false;
    this.txq = new byte[0];
    this.txr = new int[0];
    this.txs = new int[0];
    this.txv = new AtomicBoolean(false);
    this.txw = false;
    this.txa = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(b.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.af.i.agw(paramd.qWe);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.af.i.dq(paramd.qWk, -1);
      }
    }
  }
  
  private void asX()
  {
    AppMethodBeat.i(135196);
    this.qwD = true;
    if (cEx() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.g)cEx().aa(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.a.g)localObject).asX();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { cEx().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  private int cEG()
  {
    AppMethodBeat.i(325200);
    synchronized (this.txq)
    {
      getComponentId();
      int i = this.txr[0];
      AppMethodBeat.o(325200);
      return i;
    }
  }
  
  public static View cEV()
  {
    return null;
  }
  
  private void f(cb paramcb)
  {
    boolean bool2 = false;
    AppMethodBeat.i(325202);
    int i;
    synchronized (this.txq)
    {
      if (cb.tBt == paramcb) {
        break label158;
      }
      if ((cb.tBm == paramcb) && ((this.txk instanceof n))) {
        break label158;
      }
      while (this.txu == null) {
        if (i != 0)
        {
          paramcb = new bx();
          this.txu = paramcb;
          label69:
          AppMethodBeat.o(325202);
          return;
          i = 0;
        }
        else
        {
          paramcb = new ci();
        }
      }
    }
    boolean bool1;
    if ((cb.tBq != paramcb) && ((i == 0) || (!(this.txu instanceof bx))))
    {
      bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if ((this.txu instanceof ci)) {
          break label163;
        }
      }
    }
    for (;;)
    {
      Assert.assertTrue(bool1);
      break label69;
      label158:
      i = 1;
      break;
      label163:
      bool1 = true;
    }
  }
  
  public void Ad(final int paramInt)
  {
    AppMethodBeat.i(135180);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135122);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135122);
          return;
        }
        ad.this.cEC().setBackgroundColor(paramInt);
        AppMethodBeat.o(135122);
      }
    });
    AppMethodBeat.o(135180);
  }
  
  public void Ae(final int paramInt)
  {
    AppMethodBeat.i(135183);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        ad.this.cEC().setForegroundColor(paramInt);
        ad.this.Zz(f.a.DX(paramInt).name());
        AppMethodBeat.o(135126);
      }
    });
    AppMethodBeat.o(135183);
  }
  
  final void CD(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.txw)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.txb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.txb.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.txb.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  final boolean CE(int paramInt)
  {
    AppMethodBeat.i(325391);
    synchronized (this.txq)
    {
      if (this.txu == null)
      {
        AppMethodBeat.o(325391);
        return false;
      }
      Iterator localIterator = this.txu.iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((cd)localIterator.next()).tBy)
        {
          AppMethodBeat.o(325391);
          return true;
        }
      }
      AppMethodBeat.o(325391);
      return false;
    }
  }
  
  public final w CF(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = cEB().iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      if ((localw != null) && (localw.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localw;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  public final void J(final double paramDouble)
  {
    AppMethodBeat.i(135179);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135121);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        ad.this.cEC().setBackgroundAlpha(paramDouble);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135179);
  }
  
  public void Zy(final String paramString)
  {
    AppMethodBeat.i(135181);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135123);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135123);
          return;
        }
        ad.this.cEC().setMainTitle(paramString);
        AppMethodBeat.o(135123);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void Zz(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135130);
        if (ad.this.txb == null)
        {
          AppMethodBeat.o(135130);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = ad.this.txb;
        if (f.a.agY(paramString) == f.a.uzf) {}
        for (boolean bool = true;; bool = false)
        {
          locald.setStatusBarForegroundStyle(bool);
          AppMethodBeat.o(135130);
          return;
        }
      }
    });
    AppMethodBeat.o(135191);
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135146);
    this.mContext = paramContext;
    this.qwG = paramAppBrandRuntime;
    this.bzr = true;
    this.txg = cFa();
    a(paramAppBrandRuntime.getWindowAndroid());
    u(paramAppBrandRuntime.qst);
    super.init();
    if (cEx() != null)
    {
      paramContext = getRuntime().mContext;
      final View localView = (View)com.tencent.luggage.sdk.h.d.b("AppBrandPageViewProfile| onCreateView", new kotlin.g.a.a() {});
      com.tencent.luggage.sdk.h.d.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          ad.a(ad.this, new ad.b(ad.this, paramContext));
          View localView = ad.this.n(ad.o(ad.this));
          RelativeLayout.LayoutParams localLayoutParams = ad.this.cEx().cP(localView);
          if (localView != null) {
            ad.o(ad.this).addView(localView, ad.o(ad.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            ad.this.cEx().onViewCreated(localView);
            AppMethodBeat.o(135134);
            return;
            ad.o(ad.this).addView(localView, localLayoutParams);
          }
        }
      });
      com.tencent.luggage.sdk.h.d.a("AppBrandPageViewProfile| initActionBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135135);
          ad.p(ad.this);
          ad.this.txb.bm(ad.this.getContext());
          ad.o(ad.this).addView(ad.this.txb, -1, new ViewGroup.LayoutParams(-1, -2));
          ad.this.cEx().b(ad.this.txc);
          if (ad.this.txc.getParent() != ad.this.txb)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.tuD = ((FrameLayout)localView);
      this.txe = cEx().aqd();
      this.txd = cEx().getCustomViewContainer();
    }
    paramContext = paramAppBrandRuntime.qsp;
    kotlin.g.b.s.u(this, "page");
    paramContext.tCi.a(this, new e.a(paramContext, this));
    Log.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (cEx() != null) {
      cEx().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(325402);
    if ((isRunning()) && (getRuntime() != null))
    {
      x localx = getRuntime().getPageContainer();
      synchronized (localx.tvs)
      {
        localx.tvv.push(parama);
        AppMethodBeat.o(325402);
        return;
      }
    }
    AppMethodBeat.o(325402);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(176631);
    this.qwF = paramc;
    if ((this.qwF != null) && (this.txi != null))
    {
      this.txi.cdL();
      this.txi = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  protected void a(List<w> paramList, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(325320);
    new v(this, new LinkedList(paramList), paramRunnable1) {}.cem();
    AppMethodBeat.o(325320);
  }
  
  public final void a(Map<String, Object> paramMap, cb paramcb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325246);
    if (this.txp) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    if (cb.tBq == paramcb) {
      paramMap.put("originalWebviewId", Integer.valueOf(cEG()));
    }
    ??? = cEx();
    if (??? != null) {
      ((af)???).a(paramMap, paramcb);
    }
    int i;
    if (cEI())
    {
      String str = (String)paramMap.get("rawPath");
      synchronized (this.txq)
      {
        if (getCurrentRenderPagesCount() <= 0) {
          a(str, paramcb, paramJSONObject, false);
        }
        i = cEH();
        paramcb = paramJSONObject;
        if (paramJSONObject == null) {
          paramcb = new JSONObject();
        }
      }
    }
    try
    {
      paramcb.put("pageId", i);
      paramcb.put("windowId", getComponentId());
      paramMap.put("singlePageData", paramcb);
      AppMethodBeat.o(325246);
      return;
      paramMap = finally;
      AppMethodBeat.o(325246);
      throw paramMap;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandPageView", "dispatchRouteImpl, event:%s, type:%s, put viewId for customRoute, get exception:%s", new Object[] { paramJSONObject });
      }
    }
  }
  
  protected boolean a(String paramString, cb paramcb, JSONObject arg3, boolean paramBoolean)
  {
    AppMethodBeat.i(325397);
    for (;;)
    {
      synchronized (this.txq)
      {
        f(paramcb);
        if ((cb.tBt == paramcb) && (((bx)this.txu).aeZ(paramString)))
        {
          AppMethodBeat.o(325397);
          return true;
        }
        int i;
        if (this.txu.isEmpty()) {
          i = getComponentId();
        }
        switch (18.enn[paramcb.ordinal()])
        {
        case 1: 
          switch (18.enn[paramcb.ordinal()])
          {
          case 4: 
            this.txu.a(new cd(paramString, i));
            AppMethodBeat.o(325397);
            return true;
            i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) });
            continue;
            this.txu.aom();
          }
          break;
        }
      }
      this.txu.clear();
      continue;
      paramString = new UnsupportedOperationException("Unsupported openType:" + paramcb.name());
      AppMethodBeat.o(325397);
      throw paramString;
    }
  }
  
  public final void aFB()
  {
    AppMethodBeat.i(135149);
    cpF();
    asX();
    AppMethodBeat.o(135149);
  }
  
  public final <T> T aa(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (cEx() != null)
    {
      paramClass = cEx().aa(paramClass);
      AppMethodBeat.o(135200);
      return paramClass;
    }
    AppMethodBeat.o(135200);
    return null;
  }
  
  protected final boolean aeM(String paramString)
  {
    AppMethodBeat.i(325372);
    Assert.assertFalse(cEI());
    if (this.txp) {
      synchronized (this.txq)
      {
        this.txs = new int[0];
        getComponentId();
        int i = cEG();
        int j = getComponentId();
        f("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
        Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), cgR(), paramString, Integer.valueOf(i), Integer.valueOf(j) });
        this.txp = false;
        this.txk.aeA(paramString);
        this.txk.a(cb.tBq, null);
        this.txk.e(cb.tBq);
        Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(getComponentId()) });
        AppMethodBeat.o(325372);
        return true;
      }
    }
    Log.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), cgR(), paramString });
    AppMethodBeat.o(325372);
    return false;
  }
  
  public final void aeN(String paramString)
  {
    AppMethodBeat.i(325420);
    boolean bool = this.txv.getAndSet(true);
    Log.i("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", new Object[] { getAppId(), cgR(), paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(325420);
      return;
    }
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(325054);
        if (!ad.this.isRunning())
        {
          Log.e("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", new Object[] { ad.this.getAppId(), ad.this.cgR() });
          AppMethodBeat.o(325054);
          return;
        }
        ad.this.getRuntime().pmu.a(ad.u(ad.this));
        if (ad.this.cEx() != null) {
          ad.this.cEx().aqi();
        }
        ad.this.cEM();
        Object localObject = ad.this.ttM;
        ((j)localObject).rwu.set(true);
        localObject = ((j)localObject).rwl.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i.f)((Iterator)localObject).next()).onReady();
        }
        AppMethodBeat.o(325054);
      }
    });
    AppMethodBeat.o(325420);
  }
  
  public final void aeO(String paramString)
  {
    AppMethodBeat.i(135194);
    if ("dark".equalsIgnoreCase(paramString))
    {
      this.txh = f.a.uzf;
      AppMethodBeat.o(135194);
      return;
    }
    this.txh = f.a.uzg;
    AppMethodBeat.o(135194);
  }
  
  protected int ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(325400);
    Assert.assertTrue(cEI());
    synchronized (this.txq)
    {
      int i = Math.min(getCurrentRenderPagesCount() - 1, Math.max(paramInt, 0));
      paramInt = 0;
      while (paramInt < i)
      {
        ((ce)Objects.requireNonNull(this.txu)).aom();
        paramInt += 1;
      }
      AppMethodBeat.o(325400);
      return i;
    }
  }
  
  public final void ah(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = cEB().iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      if ((localw != null) && (localw.id == paramInt))
      {
        localw.disable = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> arA()
  {
    AppMethodBeat.i(135151);
    if (cEx() != null)
    {
      Map localMap = cEx().aqh();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  protected void arb()
  {
    AppMethodBeat.i(135169);
    this.tti.destroy();
    if (this.txd != null) {
      this.txd.removeAll();
    }
    if (this.txc != null) {
      this.txc.destroy();
    }
    if (this.ewc != null) {
      this.ewc.removeAllViewsInLayout();
    }
    if (this.txb != null)
    {
      this.txb.setActuallyVisible(false);
      this.txb.removeAllViewsInLayout();
    }
    if (this.tuD != null) {
      this.tuD.removeAllViewsInLayout();
    }
    this.txj.lL(true);
    if (getRuntime() != null) {
      getRuntime().pmu.b(this.txn);
    }
    this.tti = null;
    if (this.txd != null) {
      this.txd.clear();
    }
    this.txd = null;
    this.ewc = null;
    this.txb = null;
    this.tuD = null;
    this.txc = null;
    this.txg = null;
    if (this.txf != null)
    {
      com.tencent.mm.plugin.appbrand.o.a locala = this.txf;
      Log.i("MicroMsg.AppBrandKeyBoardComponentView", "destroy view containers");
      Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear views");
      com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(locala.sTJ);
      locala.qzG = null;
      locala.sTH = null;
      this.txf = null;
    }
    AppMethodBeat.o(135169);
  }
  
  public y ari()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    y localy = getRuntime().ari();
    AppMethodBeat.o(135152);
    return localy;
  }
  
  protected boolean asU()
  {
    return false;
  }
  
  public final boolean asZ()
  {
    AppMethodBeat.i(325423);
    if (cEx() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)cEx().aa(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.asZ()))
      {
        AppMethodBeat.o(325423);
        return true;
      }
      AppMethodBeat.o(325423);
      return false;
    }
    boolean bool = this.qwD;
    AppMethodBeat.o(325423);
    return bool;
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.qwG == null) || (this.qwG.ari() == null))
    {
      Log.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((cEx() != null) && (cEx().H(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.qwG.ari().f(paramString1, paramString2, getComponentId());
    AppMethodBeat.o(135165);
  }
  
  protected boolean b(View paramView, Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  protected void bm(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.txb != null) {
      this.txb.bm(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  public void c(cb paramcb)
  {
    AppMethodBeat.i(325407);
    paramcb = (b.d)Objects.requireNonNull(getPageConfig());
    Zy(paramcb.qWh);
    Objects.requireNonNull(paramcb);
    J(1.0D);
    Ad(a(paramcb));
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        ad.this.cEC().setForegroundStyle(this.rrN);
        ad.this.Zz(this.rrN);
        AppMethodBeat.o(135124);
      }
    });
    kq(paramcb.cky());
    boolean bool = paramcb.qWv;
    if (cEx() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.a.f)cEx().aa(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.a.f)localObject).kr(bool);
      }
    }
    Object localObject = paramcb.qWx;
    String str = paramcb.qWk;
    if (cEx() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)cEx().aa(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.fj((String)localObject, str);
      }
    }
    if (!paramcb.qWs) {}
    for (bool = true;; bool = false)
    {
      cN(bool);
      if (this.txm) {
        this.txc.setNavHidden(true);
      }
      AppMethodBeat.o(325407);
      return;
    }
  }
  
  public boolean c(String paramString, cb paramcb)
  {
    AppMethodBeat.i(325388);
    label263:
    label312:
    for (;;)
    {
      synchronized (this.txq)
      {
        f(paramcb);
        Objects.requireNonNull(this.txu);
        int j;
        if (this.txo == null)
        {
          this.txo = Util.nullAsNil(paramString);
          Iterator localIterator = this.txu.iterator();
          int i = 1;
          if (localIterator.hasNext())
          {
            cd localcd = (cd)localIterator.next();
            if ((!org.apache.commons.c.i.qA(localcd.tBx, paramString)) || (localcd.tBy != getComponentId())) {
              break label312;
            }
            i = 0;
            break label312;
          }
          j = i;
          if (i != 0)
          {
            Assert.assertTrue(this.txu.isEmpty());
            j = i;
          }
          if (j != 0)
          {
            if (cEI()) {
              a(paramString, paramcb, null, false);
            }
          }
          else
          {
            this.rAF = m.fL(paramString);
            this.ttl = paramString;
            this.tti.setXWebKeyboardImpl(new aw()
            {
              public final h cFb()
              {
                return ad.this;
              }
              
              public final com.tencent.mm.plugin.appbrand.jsapi.f cik()
              {
                AppMethodBeat.i(325142);
                y localy = ad.this.ari();
                AppMethodBeat.o(325142);
                return localy;
              }
            });
            if (cEx() == null) {
              break label263;
            }
            boolean bool = cEx().b(paramString, paramcb);
            AppMethodBeat.o(325388);
            return bool;
          }
        }
        else
        {
          this.txu.clear();
          j = 1;
          continue;
        }
        this.txu.a(new cd(paramString, getComponentId()));
      }
      c(paramcb);
      if (!cbk().Vf(this.rAF))
      {
        fo(paramString);
        aeN("onPageScriptNotFound");
        AppMethodBeat.o(325388);
        return false;
      }
      AppMethodBeat.o(325388);
      return true;
    }
  }
  
  public List<w> cEA()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<w> cEB()
  {
    AppMethodBeat.i(135158);
    if (this.qAp == null) {
      this.qAp = cEA();
    }
    List localList = this.qAp;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b cEC()
  {
    return this.txc;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d cED()
  {
    return this.txb;
  }
  
  public final String cEE()
  {
    AppMethodBeat.i(325361);
    synchronized (this.txq)
    {
      if (getCurrentRenderPagesCount() > 1)
      {
        String str = ((cd)Objects.requireNonNull(this.txu.cDM())).tBx;
        AppMethodBeat.o(325361);
        return str;
      }
      ??? = this.ttl;
      AppMethodBeat.o(325361);
      return ???;
    }
  }
  
  protected final void cEF()
  {
    this.txp = true;
  }
  
  protected final int cEH()
  {
    AppMethodBeat.i(325383);
    synchronized (this.txq)
    {
      Objects.requireNonNull(this.txu);
      int i = ((cd)Objects.requireNonNull(this.txu.cDM())).tBy;
      AppMethodBeat.o(325383);
      return i;
    }
  }
  
  public boolean cEI()
  {
    return false;
  }
  
  public boolean cEJ()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.o.a cEK()
  {
    AppMethodBeat.i(325410);
    if (this.txf != null)
    {
      Log.d("MicroMsg.AppBrandPageView", "return keyBoardComponentView(AppBrandKeyBoardComponentView)");
      localObject = this.txf;
      AppMethodBeat.o(325410);
      return localObject;
    }
    if (getRuntime() == null) {}
    for (Object localObject = getContext();; localObject = getRuntime().mContext)
    {
      this.txf = new com.tencent.mm.plugin.appbrand.o.a((Context)localObject, this);
      Log.d("MicroMsg.AppBrandPageView", "make new keyBoardComponentView(AppBrandKeyBoardComponentView)");
      localObject = this.txf;
      AppMethodBeat.o(325410);
      return localObject;
    }
  }
  
  public final void cEL()
  {
    AppMethodBeat.i(135170);
    this.txb.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void cEM() {}
  
  protected void cEN() {}
  
  protected void cEO() {}
  
  protected void cEP()
  {
    this.bzr = false;
  }
  
  public final void cEQ()
  {
    AppMethodBeat.i(135177);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(325052);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(325052);
          return;
        }
        ad.this.kq(false);
        ad.this.cEC().setFullscreenMode(false);
        AppMethodBeat.o(325052);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void cER()
  {
    AppMethodBeat.i(135187);
    if (cEx() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)cEx().aa(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.kt(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public final String cES()
  {
    AppMethodBeat.i(325421);
    Object localObject = (com.tencent.mm.plugin.appbrand.page.a.d)aa(com.tencent.mm.plugin.appbrand.page.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).aqa();
      AppMethodBeat.o(325421);
      return localObject;
    }
    AppMethodBeat.o(325421);
    return null;
  }
  
  final boolean cET()
  {
    AppMethodBeat.i(325422);
    com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)aa(com.tencent.mm.plugin.appbrand.page.a.d.class);
    if ((locald != null) && (locald.apZ()))
    {
      AppMethodBeat.o(325422);
      return true;
    }
    AppMethodBeat.o(325422);
    return false;
  }
  
  public View cEU()
  {
    AppMethodBeat.i(176633);
    AppMethodBeat.o(176633);
    return null;
  }
  
  public Bitmap cEW()
  {
    AppMethodBeat.i(135199);
    if (this.tti == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = ch.dD(this.tti.getWrapperView());
    if (localBitmap != null)
    {
      ViewGroup localViewGroup = cEy();
      ch.a(localViewGroup, localViewGroup, new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public void cEX()
  {
    AppMethodBeat.i(325424);
    if (this.txg == null)
    {
      AppMethodBeat.o(325424);
      return;
    }
    this.txc.setNavResetStyleListener(this.txg);
    this.txc.setNavHidden(false);
    if (this.txg.trn) {
      cEZ();
    }
    AppMethodBeat.o(325424);
  }
  
  public final void cEY()
  {
    if (this.txg != null) {
      this.txg.trn = true;
    }
  }
  
  public void cEZ()
  {
    AppMethodBeat.i(325425);
    if (this.txg != null)
    {
      if (this.txg.ttC) {
        this.txc.setNavHidden(true);
      }
      cEY();
    }
    AppMethodBeat.o(325425);
  }
  
  protected void cEb() {}
  
  protected final af cEx()
  {
    AppMethodBeat.i(135145);
    if (this.txa == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.twZ != null)
    {
      localaf = this.twZ;
      AppMethodBeat.o(135145);
      return localaf;
    }
    af localaf = (af)org.a.a.cQ(this.txa).av(new Object[] { this }).object;
    this.twZ = localaf;
    AppMethodBeat.o(135145);
    return localaf;
  }
  
  public final ViewGroup cEy()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.txe.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final ah cEz()
  {
    AppMethodBeat.i(135154);
    if ((getContext() instanceof ah))
    {
      ah localah = (ah)getContext();
      AppMethodBeat.o(135154);
      return localah;
    }
    AppMethodBeat.o(135154);
    return null;
  }
  
  protected c cFa()
  {
    AppMethodBeat.i(325426);
    Assert.assertTrue(MMHandlerThread.isMainThread());
    c localc = new c(this);
    AppMethodBeat.o(325426);
    return localc;
  }
  
  public void cN(final boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135128);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135128);
          return;
        }
        ad.this.cEC().hZ(paramBoolean);
        AppMethodBeat.o(135128);
      }
    });
    AppMethodBeat.o(135185);
  }
  
  public final boolean cdZ()
  {
    AppMethodBeat.i(135198);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb1 = com.tencent.mm.plugin.appbrand.platform.window.e.b.tLj;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb2 = com.tencent.mm.plugin.appbrand.platform.window.e.b.tLk;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb3 = com.tencent.mm.plugin.appbrand.platform.window.e.b.tLl;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb4 = com.tencent.mm.plugin.appbrand.platform.window.e.b.tLm;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb5 = this.qwF.getOrientationHandler().cHQ();
    boolean bool = org.apache.commons.c.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public final boolean cdi()
  {
    AppMethodBeat.i(135197);
    if (cEx() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)cEx().aa(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.atb()))
      {
        AppMethodBeat.o(135197);
        return true;
      }
      AppMethodBeat.o(135197);
      return false;
    }
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135197);
      return true;
    }
    AppMethodBeat.o(135197);
    return false;
  }
  
  public final String cdm()
  {
    return "AppBrandPageView";
  }
  
  public final String cgR()
  {
    AppMethodBeat.i(325358);
    synchronized (this.txq)
    {
      if (getCurrentRenderPagesCount() > 1)
      {
        String str = ((cd)Objects.requireNonNull(this.txu.cDM())).url;
        AppMethodBeat.o(325358);
        return str;
      }
      ??? = this.rAF;
      AppMethodBeat.o(325358);
      return ???;
    }
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135168);
    super.cleanup();
    arb();
    j localj = this.ttM;
    localj.rwl.clear();
    localj.rwo.clear();
    localj.rwm.clear();
    localj.rwn.clear();
    localj.rwp.clear();
    localj.rwq.clear();
    localj.rws.clear();
    localj.rwr.clear();
    AppMethodBeat.o(135168);
  }
  
  public String coY()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.txc;
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).getMainTitle())
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(135182);
      return localObject;
    }
    AppMethodBeat.o(135182);
    return "";
  }
  
  public void coZ()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135129);
        if (ad.this.txb == null)
        {
          AppMethodBeat.o(135129);
          return;
        }
        ad.this.txb.cOY();
        AppMethodBeat.o(135129);
      }
    });
    AppMethodBeat.o(135190);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (cEx() != null)
    {
      if (!cEx().e(paramString1, paramString2, paramInt)) {
        super.f(paramString1, paramString2, paramInt);
      }
      AppMethodBeat.o(135166);
      return;
    }
    super.f(paramString1, paramString2, paramInt);
    AppMethodBeat.o(135166);
  }
  
  protected boolean f(View paramView, Runnable paramRunnable)
  {
    return false;
  }
  
  public View fc(Context paramContext)
  {
    return null;
  }
  
  protected void fo(String paramString) {}
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.qwF instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
    {
      localActivity = AndroidContextUtil.castActivityOrNull(((com.tencent.mm.plugin.appbrand.platform.window.a.o)this.qwF).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(325377);
    synchronized (this.txq)
    {
      if ((this.txs == null) || (this.txs.length <= 0))
      {
        this.txs = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
        if ((this.txr == null) || (this.txr.length <= 0)) {
          this.txr = new int[] { this.txs[0] };
        }
      }
      int i = this.txs[0];
      AppMethodBeat.o(325377);
      return i;
    }
  }
  
  public final View getContentView()
  {
    return this.ewc;
  }
  
  protected final int getCurrentRenderPagesCount()
  {
    AppMethodBeat.i(325405);
    synchronized (this.txq)
    {
      if (this.txu == null)
      {
        i = 0;
        AppMethodBeat.o(325405);
        return i;
      }
      int i = this.txu.size();
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.txi != null)
    {
      locald = this.txi;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.qwF == null)
    {
      Log.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), cgR() });
      AppMethodBeat.o(176632);
      return null;
    }
    this.txi = this.qwF.a(new d.b()
    {
      public final ViewGroup dB(View paramAnonymousView)
      {
        AppMethodBeat.i(325134);
        paramAnonymousView = ad.t(ad.this).cFJ();
        AppMethodBeat.o(325134);
        return paramAnonymousView;
      }
    });
    this.txi.a(new com.tencent.mm.plugin.appbrand.platform.window.b()
    {
      public final void aqb()
      {
        AppMethodBeat.i(325135);
        ad.this.coZ();
        AppMethodBeat.o(325135);
      }
    });
    com.tencent.mm.plugin.appbrand.platform.window.d locald = this.txi;
    AppMethodBeat.o(176632);
    return locald;
  }
  
  public final b.d getPageConfig()
  {
    AppMethodBeat.i(135161);
    if (!isRunning())
    {
      AppMethodBeat.o(135161);
      return null;
    }
    b.d locald = getRuntime().getAppConfig().Xk(cgR());
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.qwG;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.qwF;
  }
  
  public void iU(final boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135127);
        if (ad.this.cEC() == null)
        {
          AppMethodBeat.o(135127);
          return;
        }
        ad.this.cEC().setLoadingIconVisibility(paramBoolean);
        AppMethodBeat.o(135127);
      }
    });
    AppMethodBeat.o(135184);
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(135167);
    if ((this.bzr) && (super.isRunning()))
    {
      AppMethodBeat.o(135167);
      return true;
    }
    AppMethodBeat.o(135167);
    return false;
  }
  
  public final void kq(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.txw = paramBoolean;
    Object localObject = this.txb.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.tuD.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.qsQ)
      {
        localObject = new IllegalStateException("ActionBarContainer and Renderer's PageArea should be in RelativeLayout");
        AppMethodBeat.o(135186);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(135186);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localLayoutParams).removeRule(3);
    }
    for (;;)
    {
      this.ewc.requestLayout();
      this.txc.setFullscreenMode(this.txw);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, twX);
    }
  }
  
  protected View n(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(135174);
    if (this.txi.cdL())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if ((cEx() != null) && (cEx().aqg()))
    {
      AppMethodBeat.o(135174);
      return true;
    }
    Iterator localIterator = this.ttM.rwp.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((i.a)localIterator.next()).onBackPressed()) {
        break label107;
      }
      bool = true;
    }
    label107:
    for (;;)
    {
      break;
      AppMethodBeat.o(135174);
      return bool;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(135173);
    this.eny = false;
    if (cEx() != null) {
      cEx().aqf();
    }
    cEO();
    cDO();
    AppMethodBeat.o(135173);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (cEx() != null) {
      cEx().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    cEP();
    if (cEx() != null) {
      cEx().dispatchDestroy();
    }
    Iterator localIterator = this.ttM.rwo.iterator();
    while (localIterator.hasNext()) {
      ((i.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    a(getRuntime().getWindowAndroid());
    this.eny = true;
    if (cEx() != null) {
      cEx().aqe();
    }
    cEN();
    cDP();
    am localam = am.l(this);
    if (localam == null)
    {
      AppMethodBeat.o(135172);
      return;
    }
    boolean bool1 = "hidden".equals(((b.d)Objects.requireNonNull(getPageConfig())).qWB);
    boolean bool2 = localam.urL;
    Log.i(localam.djQ, "setHiddenInBackgroundSwitch, runtimeSwitch: " + bool2 + ", pageSwitch: " + bool1);
    if (bool2)
    {
      localam.cNG();
      AppMethodBeat.o(135172);
      return;
    }
    if (bool1)
    {
      localam.cNG();
      AppMethodBeat.o(135172);
      return;
    }
    localam.cNH();
    AppMethodBeat.o(135172);
  }
  
  protected void t(u paramu)
  {
    this.txk = paramu;
  }
  
  public static abstract interface a
    extends x.c
  {}
  
  final class b
    extends RelativeLayout
    implements cg
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public final boolean g(Canvas paramCanvas)
    {
      AppMethodBeat.i(135142);
      Bitmap localBitmap = ad.this.cEW();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, ad.n(ad.this).getTop(), null);
      }
      if ((ad.this.txc != null) && (!ad.this.txc.cOX())) {
        ad.this.txb.draw(paramCanvas);
      }
      AppMethodBeat.o(135142);
      return true;
    }
    
    public final boolean post(Runnable paramRunnable)
    {
      AppMethodBeat.i(325177);
      if (paramRunnable == null)
      {
        AppMethodBeat.o(325177);
        return false;
      }
      if (ad.this.f(this, paramRunnable))
      {
        AppMethodBeat.o(325177);
        return true;
      }
      boolean bool = super.post(paramRunnable);
      AppMethodBeat.o(325177);
      return bool;
    }
    
    public final boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(325183);
      if (paramRunnable == null)
      {
        AppMethodBeat.o(325183);
        return false;
      }
      if (ad.this.b(this, paramRunnable, paramLong))
      {
        AppMethodBeat.o(325183);
        return true;
      }
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(325183);
      return bool;
    }
    
    public final void setBackgroundColor(int paramInt)
    {
      AppMethodBeat.i(178578);
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(178578);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */