package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
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
public class aa
  extends c
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  private static final int mbQ = 2131296686;
  public volatile boolean ckY;
  private volatile boolean ga;
  private List<com.tencent.mm.plugin.appbrand.menu.q> jCB;
  private volatile boolean jzV;
  public com.tencent.mm.plugin.appbrand.r.a.c jzX;
  private volatile AppBrandRuntime jzY;
  public ViewGroup kca;
  public String kuf;
  br lQu;
  public ay lYc;
  public String lYf;
  public FrameLayout lZG;
  private Context mContext;
  private final int mbR;
  private ac mbS;
  private final Class<? extends ac> mbT;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d mbU;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b mbV;
  public am mbW;
  public bc mbX;
  public boolean mbY;
  protected CharSequence mbZ;
  protected int mca;
  private com.tencent.mm.plugin.appbrand.r.a.d mcb;
  public final com.tencent.mm.plugin.appbrand.widget.e.b mcc;
  public r mcd;
  private al mce;
  boolean mcf;
  private final l mcg;
  protected boolean mch;
  private int[] mci;
  private final AtomicBoolean mcj;
  private boolean mck;
  
  public aa()
  {
    this(null);
  }
  
  protected aa(Class<? extends ac> paramClass)
  {
    AppMethodBeat.i(135144);
    this.mbR = 2131296685;
    this.ga = false;
    this.jzV = false;
    this.ckY = false;
    this.mbY = false;
    this.mbZ = null;
    this.mca = -2147483648;
    this.mcc = new com.tencent.mm.plugin.appbrand.widget.e.b(this);
    this.lQu = null;
    this.jzX = new o();
    this.mcf = false;
    this.mcg = new aa.1(this);
    this.mch = false;
    this.mci = new int[0];
    this.mcj = new AtomicBoolean(false);
    this.mck = false;
    this.mbT = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(a.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.z.g.UX(paramd.jVR);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.z.g.cg(paramd.jVX, -1);
      }
    }
  }
  
  private void bsx()
  {
    AppMethodBeat.i(135196);
    this.jzV = true;
    if (buq() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.b.g)buq().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.b.g)localObject).bsx();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { buq().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  public final void B(CharSequence paramCharSequence)
  {
    this.mbZ = paramCharSequence;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> EL()
  {
    AppMethodBeat.i(135151);
    if (buq() != null)
    {
      Map localMap = buq().DG();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  public View Ep()
  {
    AppMethodBeat.i(176633);
    if (!TextUtils.isEmpty(this.mbZ))
    {
      View localView = LayoutInflater.from(this.mContext).inflate(2131493090, null);
      TextView localTextView = (TextView)localView.findViewById(2131296882);
      localTextView.setText(this.mbZ);
      g(localTextView);
      AppMethodBeat.o(176633);
      return localView;
    }
    AppMethodBeat.o(176633);
    return null;
  }
  
  protected void Eq()
  {
    AppMethodBeat.i(135169);
    this.lYc.destroy();
    if (this.mbW != null) {
      this.mbW.removeAll();
    }
    if (this.mbV != null) {
      this.mbV.destroy();
    }
    if (this.kca != null) {
      this.kca.removeAllViewsInLayout();
    }
    if (this.mbU != null)
    {
      this.mbU.setActuallyVisible(false);
      this.mbU.removeAllViewsInLayout();
    }
    if (this.lZG != null) {
      this.lZG.removeAllViewsInLayout();
    }
    this.mcc.bFz();
    if (getRuntime() != null) {
      getRuntime().iDP.b(this.mcg);
    }
    this.lYc = null;
    this.mbW = null;
    this.kca = null;
    this.mbU = null;
    this.lZG = null;
    this.mbV = null;
    AppMethodBeat.o(135169);
  }
  
  public com.tencent.mm.plugin.appbrand.q Ew()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    com.tencent.mm.plugin.appbrand.q localq = getRuntime().Ew();
    AppMethodBeat.o(135152);
    return localq;
  }
  
  public final boolean FG()
  {
    return this.ckY;
  }
  
  public final void J(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = buw().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.q localq = (com.tencent.mm.plugin.appbrand.menu.q)localIterator.next();
      if ((localq != null) && (localq.id == paramInt))
      {
        localq.lSG = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public final void OE()
  {
    AppMethodBeat.i(135149);
    bic();
    bsx();
    AppMethodBeat.o(135149);
  }
  
  public void OV(final String paramString)
  {
    AppMethodBeat.i(135181);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        aa.this.bux().setMainTitle(paramString);
        AppMethodBeat.o(135124);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void OW(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135131);
        if (aa.this.mbU == null)
        {
          AppMethodBeat.o(135131);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = aa.this.mbU;
        if (d.a.TA(paramString) == d.a.mfY) {}
        for (boolean bool = true;; bool = false)
        {
          locald.setStatusBarForegroundStyle(bool);
          AppMethodBeat.o(135131);
          return;
        }
      }
    });
    AppMethodBeat.o(135191);
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (buq() != null)
    {
      paramClass = buq().Q(paramClass);
      AppMethodBeat.o(135200);
      return paramClass;
    }
    AppMethodBeat.o(135200);
    return null;
  }
  
  protected final boolean Ti(String paramString)
  {
    AppMethodBeat.i(197334);
    if (this.mch)
    {
      int i = aXC();
      this.mci = new int[0];
      aXC();
      int j = aXC();
      c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), this.kuf, paramString, Integer.valueOf(i), Integer.valueOf(j) });
      this.mch = false;
      this.mcd.Tf(paramString);
      this.mcd.a(bs.mfP, null);
      this.mcd.bue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(aXC()) });
      AppMethodBeat.o(197334);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), this.kuf, paramString });
    AppMethodBeat.o(197334);
    return false;
  }
  
  public final void Tn(String paramString)
  {
    AppMethodBeat.i(197336);
    boolean bool = this.mcj.getAndSet(true);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", new Object[] { getAppId(), this.kuf, paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(197336);
      return;
    }
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197333);
        if (!aa.this.isRunning())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", new Object[] { aa.this.getAppId(), aa.this.kuf });
          AppMethodBeat.o(197333);
          return;
        }
        aa.this.getRuntime().iDP.a(aa.r(aa.this));
        if (aa.this.buq() != null) {
          aa.this.buq().DH();
        }
        aa.this.buD();
        Iterator localIterator = aa.this.lYR.kqz.iterator();
        while (localIterator.hasNext()) {
          ((f.f)localIterator.next()).onReady();
        }
        AppMethodBeat.o(197333);
      }
    });
    AppMethodBeat.o(197336);
  }
  
  public final void To(String paramString)
  {
    AppMethodBeat.i(135194);
    if (paramString.equalsIgnoreCase("dark"))
    {
      this.mbY = true;
      AppMethodBeat.o(135194);
      return;
    }
    this.mbY = false;
    AppMethodBeat.o(135194);
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135146);
    this.mContext = paramContext;
    this.jzY = paramAppBrandRuntime;
    this.ga = true;
    a(paramAppBrandRuntime.getWindowAndroid());
    f(paramAppBrandRuntime.jwO);
    super.init();
    if (buq() != null)
    {
      paramContext = (View)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onCreateView", new d.g.a.a() {});
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          aa.a(aa.this, new aa.a(aa.this, aa.this.getContext()));
          View localView = aa.this.j(aa.l(aa.this));
          RelativeLayout.LayoutParams localLayoutParams = aa.this.buq().cn(localView);
          if (localView != null) {
            aa.l(aa.this).addView(paramContext, aa.l(aa.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            aa.this.buq().cm(paramContext);
            AppMethodBeat.o(135134);
            return;
            aa.l(aa.this).addView(paramContext, localLayoutParams);
          }
        }
      });
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| initActionBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135135);
          aa.m(aa.this);
          aa.this.mbU.aw(aa.this.getContext());
          aa.l(aa.this).addView(aa.this.mbU, -1, new ViewGroup.LayoutParams(-1, -2));
          aa.this.buq().b(aa.this.mbV);
          if (aa.this.mbV.getParent() != aa.this.mbU)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.lZG = ((FrameLayout)paramContext);
      this.mbX = buq().DC();
      this.mbW = buq().DD();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (buq() != null) {
      buq().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(176631);
    this.jzX = paramc;
    if ((this.jzX != null) && (this.mcb != null))
    {
      this.mcb = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  public final void a(Map<String, Object> paramMap, bs parambs)
  {
    AppMethodBeat.i(135147);
    if (this.mch) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    ac localac = buq();
    if (localac != null) {
      localac.a(paramMap, parambs);
    }
    AppMethodBeat.o(135147);
  }
  
  public final String aXA()
  {
    return "AppBrandPageView";
  }
  
  public final int aXC()
  {
    AppMethodBeat.i(197335);
    if ((this.mci == null) || (this.mci.length <= 0)) {
      this.mci = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
    }
    int i = this.mci[0];
    AppMethodBeat.o(197335);
    return i;
  }
  
  public final boolean aXu()
  {
    AppMethodBeat.i(135197);
    if (buq() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.g localg = (com.tencent.mm.plugin.appbrand.page.b.g)buq().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if ((localg != null) && (localg.bsz()))
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
  
  public final boolean aXv()
  {
    AppMethodBeat.i(197337);
    if (buq() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.g localg = (com.tencent.mm.plugin.appbrand.page.b.g)buq().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if ((localg != null) && (localg.aXv()))
      {
        AppMethodBeat.o(197337);
        return true;
      }
      AppMethodBeat.o(197337);
      return false;
    }
    boolean bool = this.jzV;
    AppMethodBeat.o(197337);
    return bool;
  }
  
  protected void aw(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.mbU != null) {
      this.mbU.aw(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.jzY == null) || (this.jzY.Ew() == null))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((buq() != null) && (buq().y(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.jzY.Ew().c(paramString1, paramString2, aXC());
    AppMethodBeat.o(135165);
  }
  
  protected void bA(List<com.tencent.mm.plugin.appbrand.menu.q> paramList)
  {
    AppMethodBeat.i(135156);
    new s(this, new LinkedList(buw()), false).aYr();
    AppMethodBeat.o(135156);
  }
  
  public String bhq()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.mbV;
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
  
  public void bhr()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135130);
        if (aa.this.mbU == null)
        {
          AppMethodBeat.o(135130);
          return;
        }
        aa.this.mbU.bCp();
        AppMethodBeat.o(135130);
      }
    });
    AppMethodBeat.o(135190);
  }
  
  public void bt(final boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135129);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135129);
          return;
        }
        aa.this.bux().hK(paramBoolean);
        AppMethodBeat.o(135129);
      }
    });
    AppMethodBeat.o(135185);
  }
  
  public final String buA()
  {
    return this.lYf;
  }
  
  public void buB()
  {
    AppMethodBeat.i(135163);
    a.d locald = (a.d)Objects.requireNonNull(getPageConfig());
    OV(locald.jVU);
    locald.getClass();
    r(1.0D);
    sA(a(locald));
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        aa.this.bux().setForegroundStyle(this.kmi);
        aa.this.OW(this.kmi);
        AppMethodBeat.o(135126);
      }
    });
    hg(locald.bdO());
    boolean bool = locald.jWh;
    if (buq() != null)
    {
      localObject = (f)buq().Q(f.class);
      if (localObject != null) {
        ((f)localObject).hh(bool);
      }
    }
    Object localObject = locald.jWj;
    String str = locald.jVX;
    if (buq() != null)
    {
      f localf = (f)buq().Q(f.class);
      if (localf != null) {
        localf.ei((String)localObject, str);
      }
    }
    if (!locald.jWf) {}
    for (bool = true;; bool = false)
    {
      bt(bool);
      if (this.mcf) {
        this.mbV.setNavHidden(true);
      }
      AppMethodBeat.o(135163);
      return;
    }
  }
  
  public final void buC()
  {
    AppMethodBeat.i(135170);
    this.mbU.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void buD() {}
  
  protected void buE() {}
  
  protected void buF() {}
  
  public boolean buG()
  {
    return false;
  }
  
  protected void buH()
  {
    this.ga = false;
  }
  
  public final void buI()
  {
    AppMethodBeat.i(135177);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160933);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(160933);
          return;
        }
        aa.this.hg(false);
        aa.this.bux().setFullscreenMode(false);
        AppMethodBeat.o(160933);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void buJ()
  {
    AppMethodBeat.i(135178);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135121);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        aa.this.hg(true);
        aa.this.bux().setFullscreenMode(true);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135178);
  }
  
  public final void buK()
  {
    AppMethodBeat.i(135187);
    if (buq() != null)
    {
      f localf = (f)buq().Q(f.class);
      if (localf != null) {
        localf.hj(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public View buL()
  {
    return null;
  }
  
  public final boolean buM()
  {
    AppMethodBeat.i(135198);
    e.b localb1 = e.b.moI;
    e.b localb2 = e.b.moJ;
    e.b localb3 = e.b.moK;
    e.b localb4 = e.b.moL;
    e.b localb5 = this.jzX.getOrientationHandler().aXN();
    boolean bool = org.apache.commons.b.a.contains(new e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public Bitmap buN()
  {
    AppMethodBeat.i(135199);
    if (this.lYc == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = bu.cJ(this.lYc.getWrapperView());
    if (localBitmap != null) {
      bu.a(but(), new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public final boolean buO()
  {
    return this.mcf;
  }
  
  protected final ac buq()
  {
    AppMethodBeat.i(135145);
    if (this.mbT == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.mbS != null)
    {
      localac = this.mbS;
      AppMethodBeat.o(135145);
      return localac;
    }
    ac localac = (ac)org.a.a.bF(this.mbT).aj(new Object[] { this }).object;
    this.mbS = localac;
    AppMethodBeat.o(135145);
    return localac;
  }
  
  public final r bur()
  {
    return this.mcd;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.e.b bus()
  {
    return this.mcc;
  }
  
  public final ViewGroup but()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.mbX.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.ad buu()
  {
    AppMethodBeat.i(135154);
    if ((getContext() instanceof com.tencent.mm.plugin.appbrand.widget.input.ad))
    {
      com.tencent.mm.plugin.appbrand.widget.input.ad localad = (com.tencent.mm.plugin.appbrand.widget.input.ad)getContext();
      AppMethodBeat.o(135154);
      return localad;
    }
    AppMethodBeat.o(135154);
    return null;
  }
  
  public List<com.tencent.mm.plugin.appbrand.menu.q> buv()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.q> buw()
  {
    AppMethodBeat.i(135158);
    if (this.jCB == null) {
      this.jCB = buv();
    }
    List localList = this.jCB;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b bux()
  {
    return this.mbV;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d buy()
  {
    return this.mbU;
  }
  
  public final ay buz()
  {
    return this.lYc;
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (buq() != null)
    {
      if (!buq().b(paramString1, paramString2, paramInt)) {
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
    Eq();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.lYR;
    localg.kqz.clear();
    localg.kqC.clear();
    localg.kqA.clear();
    localg.kqB.clear();
    localg.kqD.clear();
    localg.kqE.clear();
    localg.kqG.clear();
    localg.kqF.clear();
    AppMethodBeat.o(135168);
  }
  
  public boolean dk(String paramString)
  {
    AppMethodBeat.i(135162);
    this.kuf = k.dr(paramString);
    this.lYf = paramString;
    this.lYc.setXWebKeyboardImpl(new as()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e buP()
      {
        return aa.this;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.c buQ()
      {
        AppMethodBeat.i(197332);
        com.tencent.mm.plugin.appbrand.q localq = aa.this.Ew();
        AppMethodBeat.o(197332);
        return localq;
      }
    });
    if (buq() != null)
    {
      boolean bool = buq().cX(paramString);
      AppMethodBeat.o(135162);
      return bool;
    }
    buB();
    if (!aVC().Lm(this.kuf))
    {
      dl(paramString);
      Tn("onPageScriptNotFound");
      AppMethodBeat.o(135162);
      return false;
    }
    AppMethodBeat.o(135162);
    return true;
  }
  
  protected void dl(String paramString) {}
  
  protected void g(TextView paramTextView) {}
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.jzX instanceof o))
    {
      localActivity = com.tencent.mm.sdk.f.a.jq(((o)this.jzX).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final View getContentView()
  {
    return this.kca;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.mcb != null)
    {
      locald = this.mcb;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.jzX == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), this.kuf });
      AppMethodBeat.o(176632);
      return null;
    }
    this.mcb = this.jzX.a(new d.b()
    {
      public final ViewGroup cH(View paramAnonymousView)
      {
        AppMethodBeat.i(176626);
        paramAnonymousView = aa.q(aa.this).bvh();
        AppMethodBeat.o(176626);
        return paramAnonymousView;
      }
    });
    this.mcb.a(new com.tencent.mm.plugin.appbrand.r.a.b()
    {
      public final void DA()
      {
        AppMethodBeat.i(197331);
        aa.this.bhr();
        AppMethodBeat.o(197331);
      }
    });
    com.tencent.mm.plugin.appbrand.r.a.d locald = this.mcb;
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
    a.d locald = getRuntime().getAppConfig().Ng(this.kuf);
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jzY;
  }
  
  public final String getURL()
  {
    return this.kuf;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.c getWindowAndroid()
  {
    return this.jzX;
  }
  
  public void gj(final boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135128);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135128);
          return;
        }
        aa.this.bux().setLoadingIconVisibility(paramBoolean);
        AppMethodBeat.o(135128);
      }
    });
    AppMethodBeat.o(135184);
  }
  
  public final void hg(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.mck = paramBoolean;
    Object localObject = this.mbU.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.lZG.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.jxf)
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
      this.kca.requestLayout();
      this.mbV.setFullscreenMode(this.mck);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, mbQ);
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
    if (this.mcb.aXV())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if (buq() != null) {
      buq();
    }
    Iterator localIterator = this.lYR.kqD.iterator();
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
    this.ckY = false;
    if (buq() != null) {
      buq().DF();
    }
    buF();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.lYR;
    Iterator localIterator = localg.kqA.iterator();
    while (localIterator.hasNext()) {
      ((f.b)localIterator.next()).onBackground();
    }
    localg.gm(false);
    AppMethodBeat.o(135173);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (buq() != null) {
      buq().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    buH();
    if (buq() != null) {
      buq().dispatchDestroy();
    }
    Iterator localIterator = this.lYR.kqC.iterator();
    while (localIterator.hasNext()) {
      ((f.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    a(getRuntime().getWindowAndroid());
    this.ckY = true;
    if (buq() != null) {
      buq().DE();
    }
    buE();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.lYR;
    Iterator localIterator = localg.kqB.iterator();
    while (localIterator.hasNext()) {
      ((f.d)localIterator.next()).onForeground();
    }
    localg.gm(true);
    AppMethodBeat.o(135172);
  }
  
  public final void r(double paramDouble)
  {
    AppMethodBeat.i(135179);
    M(new aa.9(this, paramDouble));
    AppMethodBeat.o(135179);
  }
  
  public void sA(final int paramInt)
  {
    AppMethodBeat.i(135180);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135123);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135123);
          return;
        }
        aa.this.bux().setBackgroundColor(paramInt);
        AppMethodBeat.o(135123);
      }
    });
    AppMethodBeat.o(135180);
  }
  
  public void sB(final int paramInt)
  {
    AppMethodBeat.i(135183);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135127);
        if (aa.this.bux() == null)
        {
          AppMethodBeat.o(135127);
          return;
        }
        aa.this.bux().setForegroundColor(paramInt);
        AppMethodBeat.o(135127);
      }
    });
    AppMethodBeat.o(135183);
  }
  
  final void uM(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.mck)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.mbU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mbU.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.mbU.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.q uN(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = buw().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.q localq = (com.tencent.mm.plugin.appbrand.menu.q)localIterator.next();
      if ((localq != null) && (localq.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localq;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  public final void uO(int paramInt)
  {
    this.mca = paramInt;
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
      aa.this.mbU.draw(paramCanvas);
      Bitmap localBitmap = aa.this.buN();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, aa.k(aa.this).getTop(), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa
 * JD-Core Version:    0.7.0.1
 */