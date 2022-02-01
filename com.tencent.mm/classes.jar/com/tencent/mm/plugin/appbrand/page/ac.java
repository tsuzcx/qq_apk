package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
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
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
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

@SuppressLint({"ViewConstructor"})
public class ac
  extends d
  implements com.tencent.mm.plugin.appbrand.jsapi.h
{
  private static final int nqH = 2131296775;
  public volatile boolean cwV;
  private volatile boolean gc;
  private volatile boolean kDZ;
  public com.tencent.mm.plugin.appbrand.platform.window.c kEb;
  private volatile AppBrandRuntime kEc;
  private List<com.tencent.mm.plugin.appbrand.menu.t> kHj;
  public String lBI;
  private ViewGroup lja;
  private Context mContext;
  public bb nmX;
  public String nna;
  public FrameLayout noq;
  bw npk;
  private final int nqI;
  private ae nqJ;
  private final Class<? extends ae> nqK;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d nqL;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b nqM;
  public ao nqN;
  public bf nqO;
  private com.tencent.mm.plugin.appbrand.n.a nqP;
  protected b nqQ;
  public com.tencent.mm.plugin.appbrand.widget.actionbar.e.a nqR;
  private com.tencent.mm.plugin.appbrand.platform.window.d nqS;
  public final com.tencent.mm.plugin.appbrand.widget.f.b nqT;
  public t nqU;
  private an nqV;
  boolean nqW;
  private final com.tencent.mm.plugin.appbrand.widget.dialog.l nqX;
  private String nqY;
  protected boolean nqZ;
  private final Object nra;
  private int[] nrb;
  private int[] nrc;
  private final AtomicBoolean nrd;
  private boolean nre;
  
  public ac()
  {
    this(null);
  }
  
  protected ac(Class<? extends ae> paramClass)
  {
    AppMethodBeat.i(135144);
    this.nqI = 2131296774;
    this.gc = false;
    this.kDZ = false;
    this.cwV = false;
    this.nqR = null;
    this.nqT = new com.tencent.mm.plugin.appbrand.widget.f.b(this);
    this.npk = null;
    this.kEb = new o();
    this.nqW = false;
    this.nqX = new com.tencent.mm.plugin.appbrand.widget.dialog.l()
    {
      public final void h(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176625);
        if (paramAnonymousBoolean.booleanValue())
        {
          ac.this.hh(false);
          AppMethodBeat.o(176625);
          return;
        }
        ac.this.hh(true);
        AppMethodBeat.o(176625);
      }
    };
    this.nqZ = false;
    this.nra = new byte[0];
    this.nrb = new int[0];
    this.nrc = new int[0];
    this.nrd = new AtomicBoolean(false);
    this.nre = false;
    this.nqK = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(b.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.ac.g.afE(paramd.lci);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.ac.g.cu(paramd.lco, -1);
      }
    }
  }
  
  private void bRA()
  {
    AppMethodBeat.i(135196);
    this.kDZ = true;
    if (bRb() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.g)bRb().S(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.a.g)localObject).bRA();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { bRb().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  private int bRn()
  {
    AppMethodBeat.i(219440);
    synchronized (this.nra)
    {
      getComponentId();
      int i = this.nrb[0];
      AppMethodBeat.o(219440);
      return i;
    }
  }
  
  protected void NR()
  {
    AppMethodBeat.i(135169);
    this.nmX.destroy();
    if (this.nqN != null) {
      this.nqN.removeAll();
    }
    if (this.nqM != null) {
      this.nqM.destroy();
    }
    if (this.lja != null) {
      this.lja.removeAllViewsInLayout();
    }
    if (this.nqL != null)
    {
      this.nqL.setActuallyVisible(false);
      this.nqL.removeAllViewsInLayout();
    }
    if (this.noq != null) {
      this.noq.removeAllViewsInLayout();
    }
    this.nqT.ccK();
    if (getRuntime() != null) {
      getRuntime().jCK.b(this.nqX);
    }
    this.nmX = null;
    this.nqN = null;
    this.lja = null;
    this.nqL = null;
    this.noq = null;
    this.nqM = null;
    this.nqQ = null;
    if (this.nqP != null)
    {
      com.tencent.mm.plugin.appbrand.n.a locala = this.nqP;
      Log.i("MicroMsg.AppBrandKeyBoardComponentView", "destroy view containers");
      Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear views");
      com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(locala.mOq);
      locala.kGU = null;
      locala.mOo = null;
      this.nqP = null;
    }
    AppMethodBeat.o(135169);
  }
  
  public s NY()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    s locals = getRuntime().NY();
    AppMethodBeat.o(135152);
    return locals;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Op()
  {
    AppMethodBeat.i(135151);
    if (bRb() != null)
    {
      Map localMap = bRb().Nf();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  public final void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = bRh().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.t localt = (com.tencent.mm.plugin.appbrand.menu.t)localIterator.next();
      if ((localt != null) && (localt.id == paramInt))
      {
        localt.neT = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public final boolean Pv()
  {
    return this.cwV;
  }
  
  public final <T> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (bRb() != null)
    {
      paramClass = bRb().S(paramClass);
      AppMethodBeat.o(135200);
      return paramClass;
    }
    AppMethodBeat.o(135200);
    return null;
  }
  
  public void YO(final String paramString)
  {
    AppMethodBeat.i(135181);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135123);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135123);
          return;
        }
        ac.this.bRi().setMainTitle(paramString);
        AppMethodBeat.o(135123);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void YP(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135130);
        if (ac.this.nqL == null)
        {
          AppMethodBeat.o(135130);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = ac.this.nqL;
        if (com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.afW(paramString) == com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.oms) {}
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
  
  public final void YU()
  {
    AppMethodBeat.i(135149);
    bEb();
    bRA();
    AppMethodBeat.o(135149);
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135146);
    this.mContext = paramContext;
    this.kEc = paramAppBrandRuntime;
    this.gc = true;
    this.nqQ = bRG();
    b(paramAppBrandRuntime.getWindowAndroid());
    f(paramAppBrandRuntime.kAA);
    super.init();
    if (bRb() != null)
    {
      paramContext = getRuntime().mContext;
      final View localView = (View)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onCreateView", new kotlin.g.a.a() {});
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          ac.a(ac.this, new ac.a(ac.this, paramContext));
          View localView = ac.this.j(ac.n(ac.this));
          RelativeLayout.LayoutParams localLayoutParams = ac.this.bRb().cc(localView);
          if (localView != null) {
            ac.n(ac.this).addView(localView, ac.n(ac.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            ac.this.bRb().cb(localView);
            AppMethodBeat.o(135134);
            return;
            ac.n(ac.this).addView(localView, localLayoutParams);
          }
        }
      });
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| initActionBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135135);
          ac.o(ac.this);
          ac.this.nqL.aG(ac.this.getContext());
          ac.n(ac.this).addView(ac.this.nqL, -1, new ViewGroup.LayoutParams(-1, -2));
          ac.this.bRb().b(ac.this.nqM);
          if (ac.this.nqM.getParent() != ac.this.nqL)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.noq = ((FrameLayout)localView);
      this.nqO = bRb().Nc();
      this.nqN = bRb().getCustomViewContainer();
    }
    paramContext = paramAppBrandRuntime.kAx;
    kotlin.g.b.p.h(this, "page");
    paramContext.nvm.a(this, new com.tencent.mm.plugin.appbrand.page.capsulebar.e.a(paramContext, this));
    Log.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (bRb() != null) {
      bRb().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  public final void a(Map<String, Object> paramMap, bx parambx)
  {
    AppMethodBeat.i(135147);
    if (this.nqZ) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    if (bx.nuH == parambx) {
      paramMap.put("originalWebviewId", Integer.valueOf(bRn()));
    }
    ae localae = bRb();
    if (localae != null) {
      localae.a(paramMap, parambx);
    }
    AppMethodBeat.o(135147);
  }
  
  protected void aG(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.nqL != null) {
      this.nqL.aG(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  protected final boolean adL(String paramString)
  {
    AppMethodBeat.i(219438);
    if (this.nqZ) {
      synchronized (this.nra)
      {
        this.nrc = new int[0];
        getComponentId();
        int i = bRn();
        int j = getComponentId();
        c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
        Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), this.lBI, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        this.nqZ = false;
        this.nqU.adB(paramString);
        this.nqU.a(bx.nuH, null);
        this.nqU.b(bx.nuH);
        Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(getComponentId()) });
        AppMethodBeat.o(219438);
        return true;
      }
    }
    Log.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), this.lBI, paramString });
    AppMethodBeat.o(219438);
    return false;
  }
  
  public final void adM(String paramString)
  {
    AppMethodBeat.i(219442);
    boolean bool = this.nrd.getAndSet(true);
    Log.i("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", new Object[] { getAppId(), this.lBI, paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(219442);
      return;
    }
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219433);
        if (!ac.this.isRunning())
        {
          Log.e("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", new Object[] { ac.this.getAppId(), ac.this.lBI });
          AppMethodBeat.o(219433);
          return;
        }
        ac.this.getRuntime().jCK.a(ac.t(ac.this));
        if (ac.this.bRb() != null) {
          ac.this.bRb().Ng();
        }
        ac.this.bRq();
        Iterator localIterator = ac.this.nnC.lxE.iterator();
        while (localIterator.hasNext()) {
          ((i.f)localIterator.next()).onReady();
        }
        AppMethodBeat.o(219433);
      }
    });
    AppMethodBeat.o(219442);
  }
  
  public final void adN(String paramString)
  {
    AppMethodBeat.i(135194);
    if ("dark".equalsIgnoreCase(paramString))
    {
      this.nqR = com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.oms;
      AppMethodBeat.o(135194);
      return;
    }
    this.nqR = com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.omt;
    AppMethodBeat.o(135194);
  }
  
  public void b(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(176631);
    this.kEb = paramc;
    if ((this.kEb != null) && (this.nqS != null))
    {
      this.nqS.btC();
      this.nqS = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.kEc == null) || (this.kEc.NY() == null))
    {
      Log.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((bRb() != null) && (bRb().y(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.kEc.NY().c(paramString1, paramString2, getComponentId());
    AppMethodBeat.o(135165);
  }
  
  protected boolean b(View paramView, Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  public String bDn()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.nqM;
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
  
  public void bDo()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135129);
        if (ac.this.nqL == null)
        {
          AppMethodBeat.o(135129);
          return;
        }
        ac.this.nqL.cah();
        AppMethodBeat.o(135129);
      }
    });
    AppMethodBeat.o(135190);
  }
  
  public void bOF()
  {
    AppMethodBeat.i(135163);
    b.d locald = (b.d)Objects.requireNonNull(getPageConfig());
    YO(locald.lcl);
    locald.getClass();
    s(1.0D);
    wz(a(locald));
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        ac.this.bRi().setForegroundStyle(this.lth);
        ac.this.YP(this.lth);
        AppMethodBeat.o(135124);
      }
    });
    ii(locald.bzL());
    boolean bool = locald.lcy;
    if (bRb() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.a.f)bRb().S(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.a.f)localObject).ij(bool);
      }
    }
    Object localObject = locald.lcA;
    String str = locald.lco;
    if (bRb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)bRb().S(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.eE((String)localObject, str);
      }
    }
    if (!locald.lcw) {}
    for (bool = true;; bool = false)
    {
      bV(bool);
      if (this.nqW) {
        this.nqM.setNavHidden(true);
      }
      AppMethodBeat.o(135163);
      return;
    }
  }
  
  protected void bP(List<com.tencent.mm.plugin.appbrand.menu.t> paramList)
  {
    AppMethodBeat.i(135156);
    new u(this, new LinkedList(bRh()), false).btY();
    AppMethodBeat.o(135156);
  }
  
  public Bitmap bRB()
  {
    AppMethodBeat.i(135199);
    if (this.nmX == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = ca.cD(this.nmX.getWrapperView());
    if (localBitmap != null)
    {
      ViewGroup localViewGroup = bRe();
      ca.a(localViewGroup, localViewGroup, new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public final boolean bRC()
  {
    return this.nqW;
  }
  
  public void bRD()
  {
    AppMethodBeat.i(219445);
    if (this.nqQ == null)
    {
      AppMethodBeat.o(219445);
      return;
    }
    this.nqM.setNavResetStyleListener(this.nqQ);
    this.nqM.setNavHidden(false);
    if (this.nqQ.nno) {
      bRF();
    }
    AppMethodBeat.o(219445);
  }
  
  public final void bRE()
  {
    if (this.nqQ != null) {
      this.nqQ.nno = true;
    }
  }
  
  public void bRF()
  {
    AppMethodBeat.i(219446);
    if (this.nqQ != null)
    {
      if (this.nqQ.nnp) {
        this.nqM.setNavHidden(true);
      }
      bRE();
    }
    AppMethodBeat.o(219446);
  }
  
  protected b bRG()
  {
    AppMethodBeat.i(219447);
    Assert.assertTrue(MMHandlerThread.isMainThread());
    b localb = new b(this);
    AppMethodBeat.o(219447);
    return localb;
  }
  
  protected final ae bRb()
  {
    AppMethodBeat.i(135145);
    if (this.nqK == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.nqJ != null)
    {
      localae = this.nqJ;
      AppMethodBeat.o(135145);
      return localae;
    }
    ae localae = (ae)org.a.a.bF(this.nqK).ak(new Object[] { this }).object;
    this.nqJ = localae;
    AppMethodBeat.o(135145);
    return localae;
  }
  
  public final t bRc()
  {
    return this.nqU;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.f.b bRd()
  {
    return this.nqT;
  }
  
  public final ViewGroup bRe()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.nqO.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final ad bRf()
  {
    AppMethodBeat.i(135154);
    if ((getContext() instanceof ad))
    {
      ad localad = (ad)getContext();
      AppMethodBeat.o(135154);
      return localad;
    }
    AppMethodBeat.o(135154);
    return null;
  }
  
  public List<com.tencent.mm.plugin.appbrand.menu.t> bRg()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.t> bRh()
  {
    AppMethodBeat.i(135158);
    if (this.kHj == null) {
      this.kHj = bRg();
    }
    List localList = this.kHj;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi()
  {
    return this.nqM;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d bRj()
  {
    return this.nqL;
  }
  
  public final bb bRk()
  {
    return this.nmX;
  }
  
  public final String bRl()
  {
    return this.nqY;
  }
  
  public final String bRm()
  {
    return this.nna;
  }
  
  public final com.tencent.mm.plugin.appbrand.n.a bRo()
  {
    AppMethodBeat.i(219441);
    if (this.nqP != null)
    {
      Log.d("MicroMsg.AppBrandPageView", "return keyBoardComponentView(AppBrandKeyBoardComponentView)");
      localObject = this.nqP;
      AppMethodBeat.o(219441);
      return localObject;
    }
    if (getRuntime() == null) {}
    for (Object localObject = getContext();; localObject = getRuntime().mContext)
    {
      this.nqP = new com.tencent.mm.plugin.appbrand.n.a((Context)localObject, this);
      Log.d("MicroMsg.AppBrandPageView", "make new keyBoardComponentView(AppBrandKeyBoardComponentView)");
      localObject = this.nqP;
      AppMethodBeat.o(219441);
      return localObject;
    }
  }
  
  public final void bRp()
  {
    AppMethodBeat.i(135170);
    this.nqL.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void bRq() {}
  
  protected void bRr() {}
  
  protected void bRs() {}
  
  protected void bRt()
  {
    this.gc = false;
  }
  
  public final void bRu()
  {
    AppMethodBeat.i(135177);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219434);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(219434);
          return;
        }
        ac.this.ii(false);
        ac.this.bRi().setFullscreenMode(false);
        AppMethodBeat.o(219434);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void bRv()
  {
    AppMethodBeat.i(135178);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160933);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(160933);
          return;
        }
        ac.this.ii(true);
        ac.this.bRi().setFullscreenMode(true);
        AppMethodBeat.o(160933);
      }
    });
    AppMethodBeat.o(135178);
  }
  
  public final void bRw()
  {
    AppMethodBeat.i(135187);
    if (bRb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)bRb().S(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.il(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public final String bRx()
  {
    AppMethodBeat.i(219443);
    Object localObject = (com.tencent.mm.plugin.appbrand.page.a.d)S(com.tencent.mm.plugin.appbrand.page.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).MZ();
      AppMethodBeat.o(219443);
      return localObject;
    }
    AppMethodBeat.o(219443);
    return null;
  }
  
  public View bRy()
  {
    AppMethodBeat.i(176633);
    AppMethodBeat.o(176633);
    return null;
  }
  
  public View bRz()
  {
    return null;
  }
  
  public void bV(final boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135128);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135128);
          return;
        }
        ac.this.bRi().gz(paramBoolean);
        AppMethodBeat.o(135128);
      }
    });
    AppMethodBeat.o(135185);
  }
  
  public final boolean bsW()
  {
    AppMethodBeat.i(135197);
    if (bRb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)bRb().S(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.bSg()))
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
  
  public final boolean bsX()
  {
    AppMethodBeat.i(219444);
    if (bRb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)bRb().S(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.bsX()))
      {
        AppMethodBeat.o(219444);
        return true;
      }
      AppMethodBeat.o(219444);
      return false;
    }
    boolean bool = this.kDZ;
    AppMethodBeat.o(219444);
    return bool;
  }
  
  public final boolean btO()
  {
    AppMethodBeat.i(135198);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb1 = com.tencent.mm.plugin.appbrand.platform.window.e.b.nEn;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb2 = com.tencent.mm.plugin.appbrand.platform.window.e.b.nEo;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb3 = com.tencent.mm.plugin.appbrand.platform.window.e.b.nEp;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb4 = com.tencent.mm.plugin.appbrand.platform.window.e.b.nEq;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb5 = this.kEb.getOrientationHandler().btm();
    boolean bool = org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public final String btc()
  {
    return "AppBrandPageView";
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (bRb() != null)
    {
      if (!bRb().b(paramString1, paramString2, paramInt)) {
        super.c(paramString1, paramString2, paramInt);
      }
      AppMethodBeat.o(135166);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(135166);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135168);
    super.cleanup();
    NR();
    j localj = this.nnC;
    localj.lxE.clear();
    localj.lxH.clear();
    localj.lxF.clear();
    localj.lxG.clear();
    localj.lxI.clear();
    localj.lxJ.clear();
    localj.lxL.clear();
    localj.lxK.clear();
    AppMethodBeat.o(135168);
  }
  
  public boolean dE(String paramString)
  {
    AppMethodBeat.i(135162);
    if (this.nqY == null) {
      this.nqY = Util.nullAsNil(paramString);
    }
    this.lBI = com.tencent.luggage.h.l.dM(paramString);
    this.nna = paramString;
    this.nmX.setXWebKeyboardImpl(new au()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.h bRH()
      {
        return ac.this;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.f bxr()
      {
        AppMethodBeat.i(219432);
        s locals = ac.this.NY();
        AppMethodBeat.o(219432);
        return locals;
      }
    });
    if (bRb() != null)
    {
      boolean bool = bRb().dy(paramString);
      AppMethodBeat.o(135162);
      return bool;
    }
    bOF();
    if (!bqY().UW(this.lBI))
    {
      dF(paramString);
      adM("onPageScriptNotFound");
      AppMethodBeat.o(135162);
      return false;
    }
    AppMethodBeat.o(135162);
    return true;
  }
  
  protected void dF(String paramString) {}
  
  protected boolean f(View paramView, Runnable paramRunnable)
  {
    return false;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.kEb instanceof o))
    {
      localActivity = AndroidContextUtil.castActivityOrNull(((o)this.kEb).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(219439);
    synchronized (this.nra)
    {
      if ((this.nrc == null) || (this.nrc.length <= 0))
      {
        this.nrc = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
        if ((this.nrb == null) || (this.nrb.length <= 0)) {
          this.nrb = new int[] { this.nrc[0] };
        }
      }
      int i = this.nrc[0];
      AppMethodBeat.o(219439);
      return i;
    }
  }
  
  public final View getContentView()
  {
    return this.lja;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.nqS != null)
    {
      locald = this.nqS;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.kEb == null)
    {
      Log.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), this.lBI });
      AppMethodBeat.o(176632);
      return null;
    }
    this.nqS = this.kEb.a(new d.b()
    {
      public final ViewGroup cB(View paramAnonymousView)
      {
        AppMethodBeat.i(219430);
        paramAnonymousView = ac.s(ac.this).bRX();
        AppMethodBeat.o(219430);
        return paramAnonymousView;
      }
    });
    this.nqS.a(new com.tencent.mm.plugin.appbrand.platform.window.b()
    {
      public final void Na()
      {
        AppMethodBeat.i(219431);
        ac.this.bDo();
        AppMethodBeat.o(219431);
      }
    });
    com.tencent.mm.plugin.appbrand.platform.window.d locald = this.nqS;
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
    b.d locald = getRuntime().getAppConfig().WV(this.lBI);
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.kEc;
  }
  
  public final String getURL()
  {
    return this.lBI;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.kEb;
  }
  
  public void he(final boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135127);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135127);
          return;
        }
        ac.this.bRi().setLoadingIconVisibility(paramBoolean);
        AppMethodBeat.o(135127);
      }
    });
    AppMethodBeat.o(135184);
  }
  
  public final void ii(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.nre = paramBoolean;
    Object localObject = this.nqL.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.noq.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.kAU)
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
      this.lja.requestLayout();
      this.nqM.setFullscreenMode(this.nre);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, nqH);
    }
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(135167);
    if ((this.gc) && (super.isRunning()))
    {
      AppMethodBeat.o(135167);
      return true;
    }
    AppMethodBeat.o(135167);
    return false;
  }
  
  protected View j(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(135174);
    if (this.nqS.btC())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if (bRb() != null) {
      bRb();
    }
    Iterator localIterator = this.nnC.lxI.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((i.a)localIterator.next()).onBackPressed()) {
        break label92;
      }
      bool = true;
    }
    label92:
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
    this.cwV = false;
    if (bRb() != null) {
      bRb().Ne();
    }
    bRs();
    j localj = this.nnC;
    Iterator localIterator = localj.lxF.iterator();
    while (localIterator.hasNext()) {
      ((i.b)localIterator.next()).onBackground();
    }
    localj.hh(false);
    AppMethodBeat.o(135173);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (bRb() != null) {
      bRb().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    bRt();
    if (bRb() != null) {
      bRb().dispatchDestroy();
    }
    Iterator localIterator = this.nnC.lxH.iterator();
    while (localIterator.hasNext()) {
      ((i.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    b(getRuntime().getWindowAndroid());
    this.cwV = true;
    if (bRb() != null) {
      bRb().Nd();
    }
    bRr();
    Object localObject = this.nnC;
    Iterator localIterator = ((j)localObject).lxG.iterator();
    while (localIterator.hasNext()) {
      ((i.d)localIterator.next()).onForeground();
    }
    ((j)localObject).hh(true);
    localObject = (b.d)Objects.requireNonNull(getPageConfig());
    if ((getActivity() != null) && (getActivity().getWindow() != null))
    {
      if ("hidden".equals(((b.d)localObject).lcD))
      {
        getActivity().getWindow().addFlags(8192);
        AppMethodBeat.o(135172);
        return;
      }
      getActivity().getWindow().clearFlags(8192);
    }
    AppMethodBeat.o(135172);
  }
  
  public final void s(final double paramDouble)
  {
    AppMethodBeat.i(135179);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135121);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        ac.this.bRi().setBackgroundAlpha(paramDouble);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135179);
  }
  
  public void wA(final int paramInt)
  {
    AppMethodBeat.i(135183);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        ac.this.bRi().setForegroundColor(paramInt);
        ac.this.YP(com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.zP(paramInt).name());
        AppMethodBeat.o(135126);
      }
    });
    AppMethodBeat.o(135183);
  }
  
  public void wz(final int paramInt)
  {
    AppMethodBeat.i(135180);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135122);
        if (ac.this.bRi() == null)
        {
          AppMethodBeat.o(135122);
          return;
        }
        ac.this.bRi().setBackgroundColor(paramInt);
        AppMethodBeat.o(135122);
      }
    });
    AppMethodBeat.o(135180);
  }
  
  final void yJ(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.nre)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.nqL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.nqL.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.nqL.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.t yK(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = bRh().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.t localt = (com.tencent.mm.plugin.appbrand.menu.t)localIterator.next();
      if ((localt != null) && (localt.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localt;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  final class a
    extends RelativeLayout
    implements bz
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean c(Canvas paramCanvas)
    {
      AppMethodBeat.i(135142);
      Bitmap localBitmap = ac.this.bRB();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, ac.m(ac.this).getTop(), null);
      }
      if ((ac.this.nqM != null) && (!ac.this.nqM.isFullscreenMode())) {
        ac.this.nqL.draw(paramCanvas);
      }
      AppMethodBeat.o(135142);
      return true;
    }
    
    public final boolean post(Runnable paramRunnable)
    {
      AppMethodBeat.i(219436);
      if (paramRunnable == null)
      {
        AppMethodBeat.o(219436);
        return false;
      }
      if (ac.this.f(this, paramRunnable))
      {
        AppMethodBeat.o(219436);
        return true;
      }
      boolean bool = super.post(paramRunnable);
      AppMethodBeat.o(219436);
      return bool;
    }
    
    public final boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(219437);
      if (paramRunnable == null)
      {
        AppMethodBeat.o(219437);
        return false;
      }
      if (ac.this.b(this, paramRunnable, paramLong))
      {
        AppMethodBeat.o(219437);
        return true;
      }
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(219437);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */