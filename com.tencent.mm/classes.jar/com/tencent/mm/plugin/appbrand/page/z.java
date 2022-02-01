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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class z
  extends b
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  private static final int mgj = 2131296686;
  public volatile boolean cla;
  private volatile boolean ga;
  private volatile boolean jCY;
  public com.tencent.mm.plugin.appbrand.platform.window.c jDa;
  private volatile AppBrandRuntime jDb;
  private List<com.tencent.mm.plugin.appbrand.menu.r> jFz;
  public ViewGroup kfr;
  public String kxv;
  bq lUV;
  private Context mContext;
  public ax mcJ;
  public String mcM;
  public FrameLayout mdY;
  private int[] mgA;
  private final AtomicBoolean mgB;
  private boolean mgC;
  private final int mgk;
  private ab mgl;
  private final Class<? extends ab> mgm;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d mgn;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b mgo;
  public al mgp;
  public bb mgq;
  public com.tencent.mm.plugin.appbrand.widget.actionbar.e.a mgs;
  private com.tencent.mm.plugin.appbrand.platform.window.d mgt;
  public final com.tencent.mm.plugin.appbrand.widget.e.b mgu;
  public q mgv;
  private ak mgw;
  boolean mgx;
  private final l mgy;
  protected boolean mgz;
  
  public z()
  {
    this(null);
  }
  
  protected z(Class<? extends ab> paramClass)
  {
    AppMethodBeat.i(135144);
    this.mgk = 2131296685;
    this.ga = false;
    this.jCY = false;
    this.cla = false;
    this.mgs = null;
    this.mgu = new com.tencent.mm.plugin.appbrand.widget.e.b(this);
    this.lUV = null;
    this.jDa = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    this.mgx = false;
    this.mgy = new l()
    {
      public final void h(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176625);
        if (paramAnonymousBoolean.booleanValue())
        {
          z.this.gk(false);
          AppMethodBeat.o(176625);
          return;
        }
        z.this.gk(true);
        AppMethodBeat.o(176625);
      }
    };
    this.mgz = false;
    this.mgA = new int[0];
    this.mgB = new AtomicBoolean(false);
    this.mgC = false;
    this.mgm = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(a.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.y.g.VI(paramd.jZg);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.y.g.ck(paramd.jZm, -1);
      }
    }
  }
  
  private void bti()
  {
    AppMethodBeat.i(135196);
    this.jCY = true;
    if (bvb() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.a.g)bvb().Q(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.a.g)localObject).bti();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { bvb().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> EN()
  {
    AppMethodBeat.i(135151);
    if (bvb() != null)
    {
      Map localMap = bvb().DJ();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  protected void Es()
  {
    AppMethodBeat.i(135169);
    this.mcJ.destroy();
    if (this.mgp != null) {
      this.mgp.removeAll();
    }
    if (this.mgo != null) {
      this.mgo.destroy();
    }
    if (this.kfr != null) {
      this.kfr.removeAllViewsInLayout();
    }
    if (this.mgn != null)
    {
      this.mgn.setActuallyVisible(false);
      this.mgn.removeAllViewsInLayout();
    }
    if (this.mdY != null) {
      this.mdY.removeAllViewsInLayout();
    }
    this.mgu.bGu();
    if (getRuntime() != null) {
      getRuntime().iGI.b(this.mgy);
    }
    this.mcJ = null;
    this.mgp = null;
    this.kfr = null;
    this.mgn = null;
    this.mdY = null;
    this.mgo = null;
    AppMethodBeat.o(135169);
  }
  
  public com.tencent.mm.plugin.appbrand.r Ey()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    com.tencent.mm.plugin.appbrand.r localr = getRuntime().Ey();
    AppMethodBeat.o(135152);
    return localr;
  }
  
  public final boolean FM()
  {
    return this.cla;
  }
  
  public final void K(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = bvh().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.r localr = (com.tencent.mm.plugin.appbrand.menu.r)localIterator.next();
      if ((localr != null) && (localr.id == paramInt))
      {
        localr.lXh = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public final void OC()
  {
    AppMethodBeat.i(135149);
    biL();
    bti();
    AppMethodBeat.o(135149);
  }
  
  public void PD(final String paramString)
  {
    AppMethodBeat.i(135181);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135123);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135123);
          return;
        }
        z.this.bvi().setMainTitle(paramString);
        AppMethodBeat.o(135123);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void PE(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135130);
        if (z.this.mgn == null)
        {
          AppMethodBeat.o(135130);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = z.this.mgn;
        if (com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.Wa(paramString) == com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.mZn) {}
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
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (bvb() != null)
    {
      paramClass = bvb().Q(paramClass);
      AppMethodBeat.o(135200);
      return paramClass;
    }
    AppMethodBeat.o(135200);
    return null;
  }
  
  protected final boolean TR(String paramString)
  {
    AppMethodBeat.i(207849);
    if (this.mgz)
    {
      int i = aXX();
      this.mgA = new int[0];
      aXX();
      int j = aXX();
      c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
      ae.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), this.kxv, paramString, Integer.valueOf(i), Integer.valueOf(j) });
      this.mgz = false;
      this.mgv.TO(paramString);
      this.mgv.a(br.mkk, null);
      this.mgv.buP();
      ae.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(aXX()) });
      AppMethodBeat.o(207849);
      return true;
    }
    ae.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), this.kxv, paramString });
    AppMethodBeat.o(207849);
    return false;
  }
  
  public final void TY(String paramString)
  {
    AppMethodBeat.i(207851);
    boolean bool = this.mgB.getAndSet(true);
    ae.i("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", new Object[] { getAppId(), this.kxv, paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(207851);
      return;
    }
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207846);
        if (!z.this.isRunning())
        {
          ae.e("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", new Object[] { z.this.getAppId(), z.this.kxv });
          AppMethodBeat.o(207846);
          return;
        }
        z.this.getRuntime().iGI.a(z.q(z.this));
        if (z.this.bvb() != null) {
          z.this.bvb().DK();
        }
        z.this.bvo();
        Iterator localIterator = z.this.mdk.ktO.iterator();
        while (localIterator.hasNext()) {
          ((f.f)localIterator.next()).onReady();
        }
        AppMethodBeat.o(207846);
      }
    });
    AppMethodBeat.o(207851);
  }
  
  public final void TZ(String paramString)
  {
    AppMethodBeat.i(135194);
    if ("dark".equalsIgnoreCase(paramString))
    {
      this.mgs = com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.mZn;
      AppMethodBeat.o(135194);
      return;
    }
    this.mgs = com.tencent.mm.plugin.appbrand.widget.actionbar.e.a.mZo;
    AppMethodBeat.o(135194);
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135146);
    this.mContext = paramContext;
    this.jDb = paramAppBrandRuntime;
    this.ga = true;
    a(paramAppBrandRuntime.getWindowAndroid());
    f(paramAppBrandRuntime.jzM);
    super.init();
    if (bvb() != null)
    {
      paramContext = (View)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onCreateView", new d.g.a.a() {});
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          z.a(z.this, new z.a(z.this, z.this.getContext()));
          View localView = z.this.j(z.k(z.this));
          RelativeLayout.LayoutParams localLayoutParams = z.this.bvb().cn(localView);
          if (localView != null) {
            z.k(z.this).addView(paramContext, z.k(z.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            z.this.bvb().cm(paramContext);
            AppMethodBeat.o(135134);
            return;
            z.k(z.this).addView(paramContext, localLayoutParams);
          }
        }
      });
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| initActionBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135135);
          z.l(z.this);
          z.this.mgn.ax(z.this.getContext());
          z.k(z.this).addView(z.this.mgn, -1, new ViewGroup.LayoutParams(-1, -2));
          z.this.bvb().b(z.this.mgo);
          if (z.this.mgo.getParent() != z.this.mgn)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.mdY = ((FrameLayout)paramContext);
      this.mgq = bvb().DF();
      this.mgp = bvb().DG();
    }
    paramContext = paramAppBrandRuntime.jzJ;
    p.h(this, "page");
    paramContext.mkO.a(this, new com.tencent.mm.plugin.appbrand.page.capsulebar.e.a(paramContext, this));
    ae.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (bvb() != null) {
      bvb().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(176631);
    this.jDa = paramc;
    if ((this.jDa != null) && (this.mgt != null))
    {
      this.mgt = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  public final void a(Map<String, Object> paramMap, br parambr)
  {
    AppMethodBeat.i(135147);
    if (this.mgz) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    ab localab = bvb();
    if (localab != null) {
      localab.a(paramMap, parambr);
    }
    AppMethodBeat.o(135147);
  }
  
  public final boolean aXP()
  {
    AppMethodBeat.i(135197);
    if (bvb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)bvb().Q(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.btk()))
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
  
  public final boolean aXQ()
  {
    AppMethodBeat.i(207852);
    if (bvb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.g localg = (com.tencent.mm.plugin.appbrand.page.a.g)bvb().Q(com.tencent.mm.plugin.appbrand.page.a.g.class);
      if ((localg != null) && (localg.aXQ()))
      {
        AppMethodBeat.o(207852);
        return true;
      }
      AppMethodBeat.o(207852);
      return false;
    }
    boolean bool = this.jCY;
    AppMethodBeat.o(207852);
    return bool;
  }
  
  public final String aXV()
  {
    return "AppBrandPageView";
  }
  
  public final int aXX()
  {
    AppMethodBeat.i(207850);
    if ((this.mgA == null) || (this.mgA.length <= 0)) {
      this.mgA = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
    }
    int i = this.mgA[0];
    AppMethodBeat.o(207850);
    return i;
  }
  
  protected void ax(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.mgn != null) {
      this.mgn.ax(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.jDb == null) || (this.jDb.Ey() == null))
    {
      ae.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((bvb() != null) && (bvb().y(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.jDb.Ey().c(paramString1, paramString2, aXX());
    AppMethodBeat.o(135165);
  }
  
  protected void bC(List<com.tencent.mm.plugin.appbrand.menu.r> paramList)
  {
    AppMethodBeat.i(135156);
    new r(this, new LinkedList(bvh()), false).aYM();
    AppMethodBeat.o(135156);
  }
  
  public String bhY()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.mgo;
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
  
  public void bhZ()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135129);
        if (z.this.mgn == null)
        {
          AppMethodBeat.o(135129);
          return;
        }
        z.this.mgn.bDh();
        AppMethodBeat.o(135129);
      }
    });
    AppMethodBeat.o(135190);
  }
  
  public void bt(final boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135128);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135128);
          return;
        }
        z.this.bvi().fE(paramBoolean);
        AppMethodBeat.o(135128);
      }
    });
    AppMethodBeat.o(135185);
  }
  
  public final boolean bvA()
  {
    return this.mgx;
  }
  
  protected final ab bvb()
  {
    AppMethodBeat.i(135145);
    if (this.mgm == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.mgl != null)
    {
      localab = this.mgl;
      AppMethodBeat.o(135145);
      return localab;
    }
    ab localab = (ab)org.a.a.bF(this.mgm).ai(new Object[] { this }).object;
    this.mgl = localab;
    AppMethodBeat.o(135145);
    return localab;
  }
  
  public final q bvc()
  {
    return this.mgv;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.e.b bvd()
  {
    return this.mgu;
  }
  
  public final ViewGroup bve()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.mgq.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final ad bvf()
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
  
  public List<com.tencent.mm.plugin.appbrand.menu.r> bvg()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.r> bvh()
  {
    AppMethodBeat.i(135158);
    if (this.jFz == null) {
      this.jFz = bvg();
    }
    List localList = this.jFz;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b bvi()
  {
    return this.mgo;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d bvj()
  {
    return this.mgn;
  }
  
  public final ax bvk()
  {
    return this.mcJ;
  }
  
  public final String bvl()
  {
    return this.mcM;
  }
  
  public void bvm()
  {
    AppMethodBeat.i(135163);
    a.d locald = (a.d)Objects.requireNonNull(getPageConfig());
    PD(locald.jZj);
    locald.getClass();
    r(1.0D);
    sD(a(locald));
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        z.this.bvi().setForegroundStyle(this.kpy);
        z.this.PE(this.kpy);
        AppMethodBeat.o(135124);
      }
    });
    hh(locald.beu());
    boolean bool = locald.jZw;
    if (bvb() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.a.f)bvb().Q(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.a.f)localObject).hi(bool);
      }
    }
    Object localObject = locald.jZy;
    String str = locald.jZm;
    if (bvb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)bvb().Q(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.el((String)localObject, str);
      }
    }
    if (!locald.jZu) {}
    for (bool = true;; bool = false)
    {
      bt(bool);
      if (this.mgx) {
        this.mgo.setNavHidden(true);
      }
      AppMethodBeat.o(135163);
      return;
    }
  }
  
  public final void bvn()
  {
    AppMethodBeat.i(135170);
    this.mgn.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void bvo() {}
  
  protected void bvp() {}
  
  protected void bvq() {}
  
  public boolean bvr()
  {
    return false;
  }
  
  protected void bvs()
  {
    this.ga = false;
  }
  
  public final void bvt()
  {
    AppMethodBeat.i(135177);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207847);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(207847);
          return;
        }
        z.this.hh(false);
        z.this.bvi().setFullscreenMode(false);
        AppMethodBeat.o(207847);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void bvu()
  {
    AppMethodBeat.i(135178);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160933);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(160933);
          return;
        }
        z.this.hh(true);
        z.this.bvi().setFullscreenMode(true);
        AppMethodBeat.o(160933);
      }
    });
    AppMethodBeat.o(135178);
  }
  
  public final void bvv()
  {
    AppMethodBeat.i(135187);
    if (bvb() != null)
    {
      com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)bvb().Q(com.tencent.mm.plugin.appbrand.page.a.f.class);
      if (localf != null) {
        localf.hk(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public View bvw()
  {
    AppMethodBeat.i(176633);
    AppMethodBeat.o(176633);
    return null;
  }
  
  public View bvx()
  {
    return null;
  }
  
  public final boolean bvy()
  {
    AppMethodBeat.i(135198);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb1 = com.tencent.mm.plugin.appbrand.platform.window.e.b.mtF;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb2 = com.tencent.mm.plugin.appbrand.platform.window.e.b.mtG;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb3 = com.tencent.mm.plugin.appbrand.platform.window.e.b.mtH;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb4 = com.tencent.mm.plugin.appbrand.platform.window.e.b.mtI;
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb5 = this.jDa.getOrientationHandler().aYg();
    boolean bool = org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public Bitmap bvz()
  {
    AppMethodBeat.i(135199);
    if (this.mcJ == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = bu.cK(this.mcJ.getWrapperView());
    if (localBitmap != null) {
      bu.a(bve(), new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (bvb() != null)
    {
      if (!bvb().b(paramString1, paramString2, paramInt)) {
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
    Es();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.mdk;
    localg.ktO.clear();
    localg.ktR.clear();
    localg.ktP.clear();
    localg.ktQ.clear();
    localg.ktS.clear();
    localg.ktT.clear();
    localg.ktV.clear();
    localg.ktU.clear();
    AppMethodBeat.o(135168);
  }
  
  public boolean dm(String paramString)
  {
    AppMethodBeat.i(135162);
    this.kxv = k.dt(paramString);
    this.mcM = paramString;
    this.mcJ.setXWebKeyboardImpl(new ar()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.c bcc()
      {
        AppMethodBeat.i(207845);
        com.tencent.mm.plugin.appbrand.r localr = z.this.Ey();
        AppMethodBeat.o(207845);
        return localr;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.e bvB()
      {
        return z.this;
      }
    });
    if (bvb() != null)
    {
      boolean bool = bvb().cZ(paramString);
      AppMethodBeat.o(135162);
      return bool;
    }
    bvm();
    if (!aWb().LN(this.kxv))
    {
      dn(paramString);
      TY("onPageScriptNotFound");
      AppMethodBeat.o(135162);
      return false;
    }
    AppMethodBeat.o(135162);
    return true;
  }
  
  protected void dn(String paramString) {}
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.jDa instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
    {
      localActivity = com.tencent.mm.sdk.f.a.jw(((com.tencent.mm.plugin.appbrand.platform.window.a.o)this.jDa).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final View getContentView()
  {
    return this.kfr;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.mgt != null)
    {
      locald = this.mgt;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.jDa == null)
    {
      ae.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), this.kxv });
      AppMethodBeat.o(176632);
      return null;
    }
    this.mgt = this.jDa.a(new d.b()
    {
      public final ViewGroup cI(View paramAnonymousView)
      {
        AppMethodBeat.i(207843);
        paramAnonymousView = z.p(z.this).bvS();
        AppMethodBeat.o(207843);
        return paramAnonymousView;
      }
    });
    this.mgt.a(new com.tencent.mm.plugin.appbrand.platform.window.b()
    {
      public final void DD()
      {
        AppMethodBeat.i(207844);
        z.this.bhZ();
        AppMethodBeat.o(207844);
      }
    });
    com.tencent.mm.plugin.appbrand.platform.window.d locald = this.mgt;
    AppMethodBeat.o(176632);
    return locald;
  }
  
  public final a.d getPageConfig()
  {
    AppMethodBeat.i(135161);
    if (!isRunning())
    {
      AppMethodBeat.o(135161);
      return null;
    }
    a.d locald = getRuntime().getAppConfig().NN(this.kxv);
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jDb;
  }
  
  public final String getURL()
  {
    return this.kxv;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.jDa;
  }
  
  public void gh(final boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135127);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135127);
          return;
        }
        z.this.bvi().setLoadingIconVisibility(paramBoolean);
        AppMethodBeat.o(135127);
      }
    });
    AppMethodBeat.o(135184);
  }
  
  public final void hh(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.mgC = paramBoolean;
    Object localObject = this.mgn.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.mdY.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.jAe)
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
      this.kfr.requestLayout();
      this.mgo.setFullscreenMode(this.mgC);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, mgj);
    }
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(135167);
    if ((this.ga) && (super.isRunning()))
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
    if (this.mgt.aYo())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if (bvb() != null) {
      bvb();
    }
    Iterator localIterator = this.mdk.ktS.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((f.a)localIterator.next()).onBackPressed()) {
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
    this.cla = false;
    if (bvb() != null) {
      bvb().DI();
    }
    bvq();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.mdk;
    Iterator localIterator = localg.ktP.iterator();
    while (localIterator.hasNext()) {
      ((f.b)localIterator.next()).onBackground();
    }
    localg.gk(false);
    AppMethodBeat.o(135173);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (bvb() != null) {
      bvb().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    bvs();
    if (bvb() != null) {
      bvb().dispatchDestroy();
    }
    Iterator localIterator = this.mdk.ktR.iterator();
    while (localIterator.hasNext()) {
      ((f.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    a(getRuntime().getWindowAndroid());
    this.cla = true;
    if (bvb() != null) {
      bvb().DH();
    }
    bvp();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.mdk;
    Iterator localIterator = localg.ktQ.iterator();
    while (localIterator.hasNext()) {
      ((f.d)localIterator.next()).onForeground();
    }
    localg.gk(true);
    AppMethodBeat.o(135172);
  }
  
  public final void r(final double paramDouble)
  {
    AppMethodBeat.i(135179);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135121);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        z.this.bvi().setBackgroundAlpha(paramDouble);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135179);
  }
  
  public void sD(final int paramInt)
  {
    AppMethodBeat.i(135180);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135122);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135122);
          return;
        }
        z.this.bvi().setBackgroundColor(paramInt);
        AppMethodBeat.o(135122);
      }
    });
    AppMethodBeat.o(135180);
  }
  
  public void sE(final int paramInt)
  {
    AppMethodBeat.i(135183);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (z.this.bvi() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        z.this.bvi().setForegroundColor(paramInt);
        AppMethodBeat.o(135126);
      }
    });
    AppMethodBeat.o(135183);
  }
  
  final void uR(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.mgC)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.mgn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mgn.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.mgn.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.r uS(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = bvh().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.r localr = (com.tencent.mm.plugin.appbrand.menu.r)localIterator.next();
      if ((localr != null) && (localr.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localr;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  final class a
    extends RelativeLayout
    implements bt
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean c(Canvas paramCanvas)
    {
      AppMethodBeat.i(135142);
      z.this.mgn.draw(paramCanvas);
      Bitmap localBitmap = z.this.bvz();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, z.j(z.this).getTop(), null);
      }
      AppMethodBeat.o(135142);
      return true;
    }
    
    public final void setBackgroundColor(int paramInt)
    {
      AppMethodBeat.i(178578);
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(178578);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */