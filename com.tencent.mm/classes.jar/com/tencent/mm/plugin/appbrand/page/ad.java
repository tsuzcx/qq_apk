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
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
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
import kotlin.g.b.p;

@SuppressLint({"ViewConstructor"})
public class ad
  extends d
  implements com.tencent.mm.plugin.appbrand.jsapi.g
{
  private static final int qst = a.d.app_brand_action_bar_container;
  private volatile boolean Tb;
  public volatile boolean cvA;
  private Context mContext;
  private List<com.tencent.mm.plugin.appbrand.menu.v> nBd;
  private volatile boolean nxp;
  public c nxr;
  private volatile AppBrandRuntime nxs;
  private ViewGroup odJ;
  public String oxe;
  public bd qoF;
  public String qoI;
  public FrameLayout qpZ;
  bz qqW;
  public bh qsA;
  private com.tencent.mm.plugin.appbrand.n.a qsB;
  protected b qsC;
  public f.a qsD;
  private com.tencent.mm.plugin.appbrand.platform.window.d qsE;
  public final com.tencent.mm.plugin.appbrand.widget.g.b qsF;
  public u qsG;
  private ao qsH;
  boolean qsI;
  private final com.tencent.mm.plugin.appbrand.widget.dialog.k qsJ;
  private String qsK;
  private boolean qsL;
  private final Object qsM;
  private int[] qsN;
  private int[] qsO;
  private final AtomicBoolean qsP;
  private boolean qsQ;
  private final int qsu;
  private af qsv;
  private final Class<? extends af> qsw;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d qsx;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b qsy;
  public ap qsz;
  
  public ad()
  {
    this(null);
  }
  
  protected ad(Class<? extends af> paramClass)
  {
    AppMethodBeat.i(135144);
    this.qsu = a.d.app_brand_action_bar;
    this.Tb = false;
    this.nxp = false;
    this.cvA = false;
    this.qsD = null;
    this.qsF = new com.tencent.mm.plugin.appbrand.widget.g.b(this);
    this.qqW = null;
    this.nxr = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    this.qsI = false;
    this.qsJ = new com.tencent.mm.plugin.appbrand.widget.dialog.k()
    {
      public final void l(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176625);
        if (paramAnonymousBoolean.booleanValue())
        {
          ad.this.hX(false);
          AppMethodBeat.o(176625);
          return;
        }
        ad.this.hX(true);
        AppMethodBeat.o(176625);
      }
    };
    this.qsL = false;
    this.qsM = new byte[0];
    this.qsN = new int[0];
    this.qsO = new int[0];
    this.qsP = new AtomicBoolean(false);
    this.qsQ = false;
    this.qsw = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(b.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.ac.g.ang(paramd.nWr);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.ac.g.cO(paramd.nWx, -1);
      }
    }
  }
  
  private int cee()
  {
    AppMethodBeat.i(246009);
    synchronized (this.qsM)
    {
      getComponentId();
      int i = this.qsN[0];
      AppMethodBeat.o(246009);
      return i;
    }
  }
  
  private void cer()
  {
    AppMethodBeat.i(135196);
    this.nxp = true;
    if (cdR() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.g)cdR().R(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.a.g)localObject).cer();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { cdR().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  final void Co(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.qsQ)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.qsx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.qsx.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.qsx.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.v Cp(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = cdX().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.v localv = (com.tencent.mm.plugin.appbrand.menu.v)localIterator.next();
      if ((localv != null) && (localv.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localv;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  protected void QO()
  {
    AppMethodBeat.i(135169);
    this.qoF.destroy();
    if (this.qsz != null) {
      this.qsz.removeAll();
    }
    if (this.qsy != null) {
      this.qsy.destroy();
    }
    if (this.odJ != null) {
      this.odJ.removeAllViewsInLayout();
    }
    if (this.qsx != null)
    {
      this.qsx.setActuallyVisible(false);
      this.qsx.removeAllViewsInLayout();
    }
    if (this.qpZ != null) {
      this.qpZ.removeAllViewsInLayout();
    }
    this.qsF.cqb();
    if (getRuntime() != null) {
      getRuntime().msX.b(this.qsJ);
    }
    this.qoF = null;
    this.qsz = null;
    this.odJ = null;
    this.qsx = null;
    this.qpZ = null;
    this.qsy = null;
    this.qsC = null;
    if (this.qsB != null)
    {
      com.tencent.mm.plugin.appbrand.n.a locala = this.qsB;
      Log.i("MicroMsg.AppBrandKeyBoardComponentView", "destroy view containers");
      Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear views");
      m.runOnUiThread(locala.pPj);
      locala.nAB = null;
      locala.pPh = null;
      this.qsB = null;
    }
    AppMethodBeat.o(135169);
  }
  
  public boolean QT()
  {
    return false;
  }
  
  public com.tencent.mm.plugin.appbrand.v QW()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    com.tencent.mm.plugin.appbrand.v localv = getRuntime().QW();
    AppMethodBeat.o(135152);
    return localv;
  }
  
  public final <T> T R(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (cdR() != null)
    {
      paramClass = cdR().R(paramClass);
      AppMethodBeat.o(135200);
      return paramClass;
    }
    AppMethodBeat.o(135200);
    return null;
  }
  
  public final void R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = cdX().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.v localv = (com.tencent.mm.plugin.appbrand.menu.v)localIterator.next();
      if ((localv != null) && (localv.id == paramInt))
      {
        localv.qfB = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> Rm()
  {
    AppMethodBeat.i(135151);
    if (cdR() != null)
    {
      Map localMap = cdR().PX();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  public final boolean SV()
  {
    return this.cvA;
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135146);
    this.mContext = paramContext;
    this.nxs = paramAppBrandRuntime;
    this.Tb = true;
    this.qsC = cex();
    b(paramAppBrandRuntime.getWindowAndroid());
    f(paramAppBrandRuntime.ntK);
    super.init();
    if (cdR() != null)
    {
      paramContext = getRuntime().mContext;
      final View localView = (View)com.tencent.luggage.sdk.h.d.a("AppBrandPageViewProfile| onCreateView", new kotlin.g.a.a() {});
      com.tencent.luggage.sdk.h.d.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          ad.a(ad.this, new ad.a(ad.this, paramContext));
          View localView = ad.this.k(ad.n(ad.this));
          RelativeLayout.LayoutParams localLayoutParams = ad.this.cdR().cu(localView);
          if (localView != null) {
            ad.n(ad.this).addView(localView, ad.n(ad.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            ad.this.cdR().ct(localView);
            AppMethodBeat.o(135134);
            return;
            ad.n(ad.this).addView(localView, localLayoutParams);
          }
        }
      });
      com.tencent.luggage.sdk.h.d.a("AppBrandPageViewProfile| initActionBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135135);
          ad.o(ad.this);
          ad.this.qsx.aD(ad.this.getContext());
          ad.n(ad.this).addView(ad.this.qsx, -1, new ViewGroup.LayoutParams(-1, -2));
          ad.this.cdR().b(ad.this.qsy);
          if (ad.this.qsy.getParent() != ad.this.qsx)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.qpZ = ((FrameLayout)localView);
      this.qsA = cdR().PU();
      this.qsz = cdR().getCustomViewContainer();
    }
    paramContext = paramAppBrandRuntime.ntG;
    p.k(this, "page");
    paramContext.qxi.a(this, new e.a(paramContext, this));
    Log.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (cdR() != null) {
      cdR().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  protected void a(List<com.tencent.mm.plugin.appbrand.menu.v> paramList, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(246002);
    new v(this, new LinkedList(paramList), paramRunnable1) {}.bEY();
    AppMethodBeat.o(246002);
  }
  
  public final void a(Map<String, Object> paramMap, ca paramca)
  {
    AppMethodBeat.i(135147);
    if (this.qsL) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    if (ca.qwB == paramca) {
      paramMap.put("originalWebviewId", Integer.valueOf(cee()));
    }
    af localaf = cdR();
    if (localaf != null) {
      localaf.a(paramMap, paramca);
    }
    AppMethodBeat.o(135147);
  }
  
  protected void aD(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.qsx != null) {
      this.qsx.aD(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  public final void adD()
  {
    AppMethodBeat.i(135149);
    bPz();
    cer();
    AppMethodBeat.o(135149);
  }
  
  public void agC(final String paramString)
  {
    AppMethodBeat.i(135181);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135123);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135123);
          return;
        }
        ad.this.cdY().setMainTitle(paramString);
        AppMethodBeat.o(135123);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void agD(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135130);
        if (ad.this.qsx == null)
        {
          AppMethodBeat.o(135130);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = ad.this.qsx;
        if (f.a.anB(paramString) == f.a.roU) {}
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
  
  protected final boolean alG(String paramString)
  {
    AppMethodBeat.i(246003);
    if (this.qsL) {
      synchronized (this.qsM)
      {
        this.qsO = new int[0];
        getComponentId();
        int i = cee();
        int j = getComponentId();
        c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
        Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), this.oxe, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        this.qsL = false;
        this.qsG.alw(paramString);
        this.qsG.a(ca.qwB, null);
        this.qsG.c(ca.qwB);
        Log.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(getComponentId()) });
        AppMethodBeat.o(246003);
        return true;
      }
    }
    Log.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), this.oxe, paramString });
    AppMethodBeat.o(246003);
    return false;
  }
  
  public final void alH(String paramString)
  {
    AppMethodBeat.i(246015);
    boolean bool = this.qsP.getAndSet(true);
    Log.i("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", new Object[] { getAppId(), this.oxe, paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(246015);
      return;
    }
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243532);
        if (!ad.this.isRunning())
        {
          Log.e("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", new Object[] { ad.this.getAppId(), ad.this.oxe });
          AppMethodBeat.o(243532);
          return;
        }
        ad.this.getRuntime().msX.a(ad.t(ad.this));
        if (ad.this.cdR() != null) {
          ad.this.cdR().PY();
        }
        ad.this.ceh();
        Iterator localIterator = ad.this.qpj.osr.iterator();
        while (localIterator.hasNext()) {
          ((h.f)localIterator.next()).NR();
        }
        AppMethodBeat.o(243532);
      }
    });
    AppMethodBeat.o(246015);
  }
  
  public final void alI(String paramString)
  {
    AppMethodBeat.i(135194);
    if ("dark".equalsIgnoreCase(paramString))
    {
      this.qsD = f.a.roU;
      AppMethodBeat.o(135194);
      return;
    }
    this.qsD = f.a.roV;
    AppMethodBeat.o(135194);
  }
  
  public void b(ca paramca)
  {
    AppMethodBeat.i(246012);
    paramca = (b.d)Objects.requireNonNull(getPageConfig());
    agC(paramca.nWu);
    paramca.getClass();
    s(1.0D);
    zM(a(paramca));
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        ad.this.cdY().setForegroundStyle(this.ooe);
        ad.this.agD(this.ooe);
        AppMethodBeat.o(135124);
      }
    });
    jf(paramca.bLa());
    boolean bool = paramca.nWH;
    if (cdR() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.a.f)cdR().R(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.a.f)localObject).jg(bool);
      }
    }
    Object localObject = paramca.nWJ;
    String str = paramca.nWx;
    if (cdR() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)cdR().R(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.eS((String)localObject, str);
      }
    }
    if (!paramca.nWF) {}
    for (bool = true;; bool = false)
    {
      cg(bool);
      if (this.qsI) {
        this.qsy.setNavHidden(true);
      }
      AppMethodBeat.o(246012);
      return;
    }
  }
  
  public void b(c paramc)
  {
    AppMethodBeat.i(176631);
    this.nxr = paramc;
    if ((this.nxr != null) && (this.qsE != null))
    {
      this.qsE.bEz();
      this.qsE = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.nxs == null) || (this.nxs.QW() == null))
    {
      Log.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((cdR() != null) && (cdR().C(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.nxs.QW().c(paramString1, paramString2, getComponentId());
    AppMethodBeat.o(135165);
  }
  
  protected boolean b(View paramView, Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  public final boolean bDU()
  {
    AppMethodBeat.i(135197);
    if (cdR() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)cdR().R(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.cfg()))
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
  
  public final boolean bDV()
  {
    AppMethodBeat.i(246018);
    if (cdR() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)cdR().R(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.bDV()))
      {
        AppMethodBeat.o(246018);
        return true;
      }
      AppMethodBeat.o(246018);
      return false;
    }
    boolean bool = this.nxp;
    AppMethodBeat.o(246018);
    return bool;
  }
  
  public final boolean bEN()
  {
    AppMethodBeat.i(135198);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb1 = com.tencent.mm.plugin.appbrand.platform.window.e.b.qGx;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb2 = com.tencent.mm.plugin.appbrand.platform.window.e.b.qGy;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb3 = com.tencent.mm.plugin.appbrand.platform.window.e.b.qGz;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb4 = com.tencent.mm.plugin.appbrand.platform.window.e.b.qGA;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb5 = this.nxr.getOrientationHandler().cgS();
    boolean bool = org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public final String bEa()
  {
    return "AppBrandPageView";
  }
  
  public String bOK()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.qsy;
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
  
  public void bOL()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135129);
        if (ad.this.qsx == null)
        {
          AppMethodBeat.o(135129);
          return;
        }
        ad.this.qsx.cnf();
        AppMethodBeat.o(135129);
      }
    });
    AppMethodBeat.o(135190);
  }
  
  public final String btD()
  {
    return this.oxe;
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (cdR() != null)
    {
      if (!cdR().b(paramString1, paramString2, paramInt)) {
        super.c(paramString1, paramString2, paramInt);
      }
      AppMethodBeat.o(135166);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(135166);
  }
  
  public boolean c(String paramString, ca paramca)
  {
    AppMethodBeat.i(246011);
    if (this.qsK == null) {
      this.qsK = Util.nullAsNil(paramString);
    }
    this.oxe = com.tencent.luggage.k.l.eo(paramString);
    this.qoI = paramString;
    this.qoF.setXWebKeyboardImpl(new aw()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e bIF()
      {
        AppMethodBeat.i(242699);
        com.tencent.mm.plugin.appbrand.v localv = ad.this.QW();
        AppMethodBeat.o(242699);
        return localv;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.g cey()
      {
        return ad.this;
      }
    });
    if (cdR() != null)
    {
      boolean bool = cdR().b(paramString, paramca);
      AppMethodBeat.o(246011);
      return bool;
    }
    b(paramca);
    if (!bBO().acG(this.oxe))
    {
      dY(paramString);
      alH("onPageScriptNotFound");
      AppMethodBeat.o(246011);
      return false;
    }
    AppMethodBeat.o(246011);
    return true;
  }
  
  protected final af cdR()
  {
    AppMethodBeat.i(135145);
    if (this.qsw == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.qsv != null)
    {
      localaf = this.qsv;
      AppMethodBeat.o(135145);
      return localaf;
    }
    af localaf = (af)org.a.a.ce(this.qsw).ao(new Object[] { this }).object;
    this.qsv = localaf;
    AppMethodBeat.o(135145);
    return localaf;
  }
  
  public final u cdS()
  {
    return this.qsG;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.g.b cdT()
  {
    return this.qsF;
  }
  
  public final ViewGroup cdU()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.qsA.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final ah cdV()
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
  
  public List<com.tencent.mm.plugin.appbrand.menu.v> cdW()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.v> cdX()
  {
    AppMethodBeat.i(135158);
    if (this.nBd == null) {
      this.nBd = cdW();
    }
    List localList = this.nBd;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b cdY()
  {
    return this.qsy;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d cdZ()
  {
    return this.qsx;
  }
  
  public final bd cea()
  {
    return this.qoF;
  }
  
  public final String ceb()
  {
    return this.qsK;
  }
  
  public final String cec()
  {
    return this.qoI;
  }
  
  protected final void ced()
  {
    this.qsL = true;
  }
  
  public final com.tencent.mm.plugin.appbrand.n.a cef()
  {
    AppMethodBeat.i(246013);
    if (this.qsB != null)
    {
      Log.d("MicroMsg.AppBrandPageView", "return keyBoardComponentView(AppBrandKeyBoardComponentView)");
      localObject = this.qsB;
      AppMethodBeat.o(246013);
      return localObject;
    }
    if (getRuntime() == null) {}
    for (Object localObject = getContext();; localObject = getRuntime().mContext)
    {
      this.qsB = new com.tencent.mm.plugin.appbrand.n.a((Context)localObject, this);
      Log.d("MicroMsg.AppBrandPageView", "make new keyBoardComponentView(AppBrandKeyBoardComponentView)");
      localObject = this.qsB;
      AppMethodBeat.o(246013);
      return localObject;
    }
  }
  
  public final void ceg()
  {
    AppMethodBeat.i(135170);
    this.qsx.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void ceh() {}
  
  protected void cei() {}
  
  protected void cej() {}
  
  protected void cek()
  {
    this.Tb = false;
  }
  
  public final void cel()
  {
    AppMethodBeat.i(135177);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244883);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(244883);
          return;
        }
        ad.this.jf(false);
        ad.this.cdY().setFullscreenMode(false);
        AppMethodBeat.o(244883);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void cem()
  {
    AppMethodBeat.i(135178);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160933);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(160933);
          return;
        }
        ad.this.jf(true);
        ad.this.cdY().setFullscreenMode(true);
        AppMethodBeat.o(160933);
      }
    });
    AppMethodBeat.o(135178);
  }
  
  public final void cen()
  {
    AppMethodBeat.i(135187);
    if (cdR() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)cdR().R(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.ji(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public final String ceo()
  {
    AppMethodBeat.i(246017);
    Object localObject = (com.tencent.mm.plugin.appbrand.page.a.d)R(com.tencent.mm.plugin.appbrand.page.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).PR();
      AppMethodBeat.o(246017);
      return localObject;
    }
    AppMethodBeat.o(246017);
    return null;
  }
  
  public View cep()
  {
    AppMethodBeat.i(176633);
    AppMethodBeat.o(176633);
    return null;
  }
  
  public View ceq()
  {
    return null;
  }
  
  public Bitmap ces()
  {
    AppMethodBeat.i(135199);
    if (this.qoF == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = cd.cW(this.qoF.getWrapperView());
    if (localBitmap != null)
    {
      ViewGroup localViewGroup = cdU();
      cd.a(localViewGroup, localViewGroup, new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public final boolean cet()
  {
    return this.qsI;
  }
  
  public void ceu()
  {
    AppMethodBeat.i(246019);
    if (this.qsC == null)
    {
      AppMethodBeat.o(246019);
      return;
    }
    this.qsy.setNavResetStyleListener(this.qsC);
    this.qsy.setNavHidden(false);
    if (this.qsC.qmt) {
      cew();
    }
    AppMethodBeat.o(246019);
  }
  
  public final void cev()
  {
    if (this.qsC != null) {
      this.qsC.qmt = true;
    }
  }
  
  public void cew()
  {
    AppMethodBeat.i(246022);
    if (this.qsC != null)
    {
      if (this.qsC.qoW) {
        this.qsy.setNavHidden(true);
      }
      cev();
    }
    AppMethodBeat.o(246022);
  }
  
  protected b cex()
  {
    AppMethodBeat.i(246023);
    Assert.assertTrue(MMHandlerThread.isMainThread());
    b localb = new b(this);
    AppMethodBeat.o(246023);
    return localb;
  }
  
  public void cg(final boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135128);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135128);
          return;
        }
        ad.this.cdY().hk(paramBoolean);
        AppMethodBeat.o(135128);
      }
    });
    AppMethodBeat.o(135185);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135168);
    super.cleanup();
    QO();
    i locali = this.qpj;
    locali.osr.clear();
    locali.osu.clear();
    locali.oss.clear();
    locali.ost.clear();
    locali.osv.clear();
    locali.osw.clear();
    locali.osy.clear();
    locali.osx.clear();
    AppMethodBeat.o(135168);
  }
  
  protected void dY(String paramString) {}
  
  protected boolean f(View paramView, Runnable paramRunnable)
  {
    return false;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.nxr instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
    {
      localActivity = AndroidContextUtil.castActivityOrNull(((com.tencent.mm.plugin.appbrand.platform.window.a.o)this.nxr).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(246007);
    synchronized (this.qsM)
    {
      if ((this.qsO == null) || (this.qsO.length <= 0))
      {
        this.qsO = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
        if ((this.qsN == null) || (this.qsN.length <= 0)) {
          this.qsN = new int[] { this.qsO[0] };
        }
      }
      int i = this.qsO[0];
      AppMethodBeat.o(246007);
      return i;
    }
  }
  
  public final View getContentView()
  {
    return this.odJ;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.qsE != null)
    {
      locald = this.qsE;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.nxr == null)
    {
      Log.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), this.oxe });
      AppMethodBeat.o(176632);
      return null;
    }
    this.qsE = this.nxr.a(new d.b()
    {
      public final ViewGroup cU(View paramAnonymousView)
      {
        AppMethodBeat.i(244330);
        paramAnonymousView = ad.s(ad.this).ceU();
        AppMethodBeat.o(244330);
        return paramAnonymousView;
      }
    });
    this.qsE.a(new com.tencent.mm.plugin.appbrand.platform.window.b()
    {
      public final void PS()
      {
        AppMethodBeat.i(243265);
        ad.this.bOL();
        AppMethodBeat.o(243265);
      }
    });
    com.tencent.mm.plugin.appbrand.platform.window.d locald = this.qsE;
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
    b.d locald = getRuntime().getAppConfig().aeI(this.oxe);
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.nxs;
  }
  
  public final c getWindowAndroid()
  {
    return this.nxr;
  }
  
  public void hV(final boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135127);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135127);
          return;
        }
        ad.this.cdY().setLoadingIconVisibility(paramBoolean);
        AppMethodBeat.o(135127);
      }
    });
    AppMethodBeat.o(135184);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(135167);
    if ((this.Tb) && (super.isRunning()))
    {
      AppMethodBeat.o(135167);
      return true;
    }
    AppMethodBeat.o(135167);
    return false;
  }
  
  public final void jf(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.qsQ = paramBoolean;
    Object localObject = this.qsx.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.qpZ.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.nug)
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
      this.odJ.requestLayout();
      this.qsy.setFullscreenMode(this.qsQ);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, qst);
    }
  }
  
  protected View k(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(135174);
    if (this.qsE.bEz())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if (cdR() != null) {
      cdR();
    }
    Iterator localIterator = this.qpj.osv.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((h.a)localIterator.next()).onBackPressed()) {
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
    this.cvA = false;
    if (cdR() != null) {
      cdR().PW();
    }
    cej();
    i locali = this.qpj;
    Iterator localIterator = locali.oss.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).onBackground();
    }
    locali.hX(false);
    AppMethodBeat.o(135173);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (cdR() != null) {
      cdR().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    cek();
    if (cdR() != null) {
      cdR().dispatchDestroy();
    }
    Iterator localIterator = this.qpj.osu.iterator();
    while (localIterator.hasNext()) {
      ((h.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    b(getRuntime().getWindowAndroid());
    this.cvA = true;
    if (cdR() != null) {
      cdR().PV();
    }
    cei();
    Object localObject = this.qpj;
    Iterator localIterator = ((i)localObject).ost.iterator();
    while (localIterator.hasNext()) {
      ((h.d)localIterator.next()).onForeground();
    }
    ((i)localObject).hX(true);
    localObject = (b.d)Objects.requireNonNull(getPageConfig());
    if ((getActivity() != null) && (getActivity().getWindow() != null))
    {
      if ("hidden".equals(((b.d)localObject).nWM))
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
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        ad.this.cdY().setBackgroundAlpha(paramDouble);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135179);
  }
  
  public void zM(final int paramInt)
  {
    AppMethodBeat.i(135180);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135122);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135122);
          return;
        }
        ad.this.cdY().setBackgroundColor(paramInt);
        AppMethodBeat.o(135122);
      }
    });
    AppMethodBeat.o(135180);
  }
  
  public void zN(final int paramInt)
  {
    AppMethodBeat.i(135183);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (ad.this.cdY() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        ad.this.cdY().setForegroundColor(paramInt);
        ad.this.agD(f.a.Dy(paramInt).name());
        AppMethodBeat.o(135126);
      }
    });
    AppMethodBeat.o(135183);
  }
  
  final class a
    extends RelativeLayout
    implements cc
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean d(Canvas paramCanvas)
    {
      AppMethodBeat.i(135142);
      Bitmap localBitmap = ad.this.ces();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, ad.m(ad.this).getTop(), null);
      }
      if ((ad.this.qsy != null) && (!ad.this.qsy.cne())) {
        ad.this.qsx.draw(paramCanvas);
      }
      AppMethodBeat.o(135142);
      return true;
    }
    
    public final boolean post(Runnable paramRunnable)
    {
      AppMethodBeat.i(244318);
      if (paramRunnable == null)
      {
        AppMethodBeat.o(244318);
        return false;
      }
      if (ad.this.f(this, paramRunnable))
      {
        AppMethodBeat.o(244318);
        return true;
      }
      boolean bool = super.post(paramRunnable);
      AppMethodBeat.o(244318);
      return bool;
    }
    
    public final boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(244319);
      if (paramRunnable == null)
      {
        AppMethodBeat.o(244319);
        return false;
      }
      if (ad.this.b(this, paramRunnable, paramLong))
      {
        AppMethodBeat.o(244319);
        return true;
      }
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(244319);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */