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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.s.a.d.b;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@SuppressLint({"ViewConstructor"})
public class aa
  extends c
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  private static final int laQ = 2131296686;
  private volatile boolean arf;
  public volatile boolean cdK;
  private volatile boolean iGS;
  public com.tencent.mm.plugin.appbrand.s.a.c iGU;
  private volatile AppBrandRuntime iGV;
  private List<p> iIP;
  public ViewGroup jhz;
  public String jzm;
  bx kPL;
  public bd kWU;
  public String kWX;
  public FrameLayout kYy;
  private final int laR;
  private ac laS;
  private final Class<? extends ac> laT;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d laU;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b laV;
  public ar laW;
  public bh laX;
  public boolean laY;
  protected CharSequence laZ;
  protected int lba;
  private com.tencent.mm.plugin.appbrand.s.a.d lbb;
  public final com.tencent.mm.plugin.appbrand.widget.e.b lbc;
  public q lbd;
  private aq lbe;
  boolean lbf;
  private final l lbg;
  protected boolean lbh;
  private int[] lbi;
  private boolean lbj;
  private Context mContext;
  
  public aa()
  {
    this(null);
  }
  
  protected aa(Class<? extends ac> paramClass)
  {
    AppMethodBeat.i(135144);
    this.laR = 2131296685;
    this.arf = false;
    this.iGS = false;
    this.cdK = false;
    this.laY = false;
    this.laZ = null;
    this.lba = -2147483648;
    this.lbc = new com.tencent.mm.plugin.appbrand.widget.e.b(this);
    this.kPL = null;
    this.iGU = new com.tencent.mm.plugin.appbrand.s.a.a.o();
    this.lbf = false;
    this.lbg = new aa.1(this);
    this.lbh = false;
    this.lbi = new int[0];
    this.lbj = false;
    this.laT = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(a.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.aa.g.Ni(paramd.jbU);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.aa.g.bY(paramd.jbK, -1);
      }
    }
  }
  
  private void bhE()
  {
    AppMethodBeat.i(135196);
    this.iGS = true;
    if (bjA() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.b.g)bjA().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.b.g)localObject).bhE();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { bjA().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  public final void B(CharSequence paramCharSequence)
  {
    this.laZ = paramCharSequence;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DJ()
  {
    AppMethodBeat.i(135151);
    if (bjA() != null)
    {
      Map localMap = bjA().CD();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  public View Dn()
  {
    AppMethodBeat.i(176633);
    if (!TextUtils.isEmpty(this.laZ))
    {
      View localView = LayoutInflater.from(this.mContext).inflate(2131493090, null);
      TextView localTextView = (TextView)localView.findViewById(2131296882);
      localTextView.setText(this.laZ);
      g(localTextView);
      AppMethodBeat.o(176633);
      return localView;
    }
    AppMethodBeat.o(176633);
    return null;
  }
  
  protected void Do()
  {
    AppMethodBeat.i(135169);
    this.kWU.destroy();
    if (this.laW != null) {
      this.laW.removeAll();
    }
    if (this.laV != null) {
      this.laV.destroy();
    }
    if (this.jhz != null) {
      this.jhz.removeAllViewsInLayout();
    }
    if (this.laU != null)
    {
      this.laU.setActuallyVisible(false);
      this.laU.removeAllViewsInLayout();
    }
    if (this.kYy != null) {
      this.kYy.removeAllViewsInLayout();
    }
    this.lbc.buA();
    if (getRuntime() != null) {
      getRuntime().hKb.b(this.lbg);
    }
    this.kWU = null;
    this.laW = null;
    this.jhz = null;
    this.laU = null;
    this.kYy = null;
    this.laV = null;
    AppMethodBeat.o(135169);
  }
  
  public com.tencent.mm.plugin.appbrand.q Du()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    com.tencent.mm.plugin.appbrand.q localq = getRuntime().Du();
    AppMethodBeat.o(135152);
    return localq;
  }
  
  public void Hx(final String paramString)
  {
    AppMethodBeat.i(135181);
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (aa.this.bjH() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        aa.this.bjH().setMainTitle(paramString);
        AppMethodBeat.o(135124);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void Hy(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135131);
        if (aa.this.laU == null)
        {
          AppMethodBeat.o(135131);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = aa.this.laU;
        if (d.a.LQ(paramString) == d.a.lgB) {}
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
  
  public final void J(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = bjG().iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((localp != null) && (localp.id == paramInt))
      {
        localp.kRX = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public final void LD(String paramString)
  {
    AppMethodBeat.i(135194);
    if (paramString.equalsIgnoreCase("dark"))
    {
      this.laY = true;
      AppMethodBeat.o(135194);
      return;
    }
    this.laY = false;
    AppMethodBeat.o(135194);
  }
  
  protected final boolean Lx(String paramString)
  {
    AppMethodBeat.i(194498);
    if (this.lbh)
    {
      int i = aOd();
      this.lbi = new int[0];
      aOd();
      int j = aOd();
      c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), this.jzm, paramString, Integer.valueOf(i), Integer.valueOf(j) });
      this.lbh = false;
      this.lbd.Lu(paramString);
      this.lbd.a(by.lgs, null);
      this.lbd.bjm();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(aOd()) });
      AppMethodBeat.o(194498);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), this.jzm, paramString });
    AppMethodBeat.o(194498);
    return false;
  }
  
  public final void MX()
  {
    AppMethodBeat.i(135149);
    aXB();
    bhE();
    AppMethodBeat.o(135149);
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (bjA() != null)
    {
      paramClass = bjA().Q(paramClass);
      AppMethodBeat.o(135200);
      return paramClass;
    }
    AppMethodBeat.o(135200);
    return null;
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135146);
    this.mContext = paramContext;
    this.iGV = paramAppBrandRuntime;
    this.arf = true;
    a(paramAppBrandRuntime.getWindowAndroid());
    f(paramAppBrandRuntime.iDG);
    super.init();
    if (bjA() != null)
    {
      paramContext = (View)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onCreateView", new d.g.a.a() {});
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          aa.a(aa.this, new aa.a(aa.this, aa.this.getContext()));
          View localView = aa.this.j(aa.l(aa.this));
          RelativeLayout.LayoutParams localLayoutParams = aa.this.bjA().cn(localView);
          if (localView != null) {
            aa.l(aa.this).addView(paramContext, aa.l(aa.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            aa.this.bjA().cm(paramContext);
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
          aa.this.laU.av(aa.this.getContext());
          aa.l(aa.this).addView(aa.this.laU, -1, new ViewGroup.LayoutParams(-1, -2));
          aa.this.bjA().b(aa.this.laV);
          if (aa.this.laV.getParent() != aa.this.laU)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.kYy = ((FrameLayout)paramContext);
      this.laX = bjA().Cz();
      this.laW = bjA().CA();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (bjA() != null) {
      bjA().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.s.a.c paramc)
  {
    AppMethodBeat.i(176631);
    this.iGU = paramc;
    if ((this.iGU != null) && (this.lbb != null))
    {
      this.lbb = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  public final void a(Map<String, Object> paramMap, by paramby)
  {
    AppMethodBeat.i(135147);
    if (this.lbh) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    ac localac = bjA();
    if (localac != null) {
      localac.a(paramMap, paramby);
    }
    AppMethodBeat.o(135147);
  }
  
  public final String aNA()
  {
    return "AppBrandPageView";
  }
  
  public final boolean aNv()
  {
    AppMethodBeat.i(135197);
    if (bjA() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.g localg = (com.tencent.mm.plugin.appbrand.page.b.g)bjA().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if ((localg != null) && (localg.bhG()))
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
  
  public final boolean aNw()
  {
    AppMethodBeat.i(194500);
    if (bjA() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.g localg = (com.tencent.mm.plugin.appbrand.page.b.g)bjA().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if ((localg != null) && (localg.aNw()))
      {
        AppMethodBeat.o(194500);
        return true;
      }
      AppMethodBeat.o(194500);
      return false;
    }
    boolean bool = this.iGS;
    AppMethodBeat.o(194500);
    return bool;
  }
  
  public final int aOd()
  {
    AppMethodBeat.i(194499);
    if ((this.lbi == null) || (this.lbi.length <= 0)) {
      this.lbi = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
    }
    int i = this.lbi[0];
    AppMethodBeat.o(194499);
    return i;
  }
  
  public String aWO()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.laV;
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
  
  public void aWP()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new aa.17(this));
    AppMethodBeat.o(135190);
  }
  
  protected void av(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.laU != null) {
      this.laU.av(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.iGV == null) || (this.iGV.Du() == null))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((bjA() != null) && (bjA().x(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.iGV.Du().c(paramString1, paramString2, aOd());
    AppMethodBeat.o(135165);
  }
  
  protected final ac bjA()
  {
    AppMethodBeat.i(135145);
    if (this.laT == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.laS != null)
    {
      localac = this.laS;
      AppMethodBeat.o(135145);
      return localac;
    }
    ac localac = (ac)org.a.a.bA(this.laT).ag(new Object[] { this }).object;
    this.laS = localac;
    AppMethodBeat.o(135145);
    return localac;
  }
  
  public final q bjB()
  {
    return this.lbd;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.e.b bjC()
  {
    return this.lbc;
  }
  
  public final ViewGroup bjD()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.laX.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.ad bjE()
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
  
  public List<p> bjF()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<p> bjG()
  {
    AppMethodBeat.i(135158);
    if (this.iIP == null) {
      this.iIP = bjF();
    }
    List localList = this.iIP;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b bjH()
  {
    return this.laV;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d bjI()
  {
    return this.laU;
  }
  
  public final String bjJ()
  {
    return this.kWX;
  }
  
  public void bjK()
  {
    AppMethodBeat.i(135163);
    a.d locald = getPageConfig();
    Hx(locald.jbQ);
    locald.getClass();
    s(1.0D);
    rl(a(locald));
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (aa.this.bjH() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        aa.this.bjH().setForegroundStyle(this.jrC);
        aa.this.Hy(this.jrC);
        AppMethodBeat.o(135126);
      }
    });
    gA(locald.aTr());
    boolean bool = locald.jbY;
    if (bjA() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.b.f)bjA().Q(com.tencent.mm.plugin.appbrand.page.b.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.b.f)localObject).gF(bool);
      }
    }
    Object localObject = locald.jca;
    String str = locald.jbK;
    if (bjA() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.f localf = (com.tencent.mm.plugin.appbrand.page.b.f)bjA().Q(com.tencent.mm.plugin.appbrand.page.b.f.class);
      if (localf != null) {
        localf.dM((String)localObject, str);
      }
    }
    if (!locald.jbW) {}
    for (bool = true;; bool = false)
    {
      bt(bool);
      if (this.lbf) {
        this.laV.setNavHidden(true);
      }
      AppMethodBeat.o(135163);
      return;
    }
  }
  
  public final void bjL()
  {
    AppMethodBeat.i(135170);
    this.laU.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void bjM() {}
  
  protected void bjN() {}
  
  protected void bjO() {}
  
  public boolean bjP()
  {
    return false;
  }
  
  protected void bjQ()
  {
    this.arf = false;
  }
  
  public final void bjR()
  {
    AppMethodBeat.i(135177);
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160933);
        if (aa.this.bjH() == null)
        {
          AppMethodBeat.o(160933);
          return;
        }
        aa.this.gA(false);
        aa.this.bjH().setFullscreenMode(false);
        AppMethodBeat.o(160933);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void bjS()
  {
    AppMethodBeat.i(135178);
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135121);
        if (aa.this.bjH() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        aa.this.gA(true);
        aa.this.bjH().setFullscreenMode(true);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135178);
  }
  
  public final void bjT()
  {
    AppMethodBeat.i(135187);
    if (bjA() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.f localf = (com.tencent.mm.plugin.appbrand.page.b.f)bjA().Q(com.tencent.mm.plugin.appbrand.page.b.f.class);
      if (localf != null) {
        localf.gH(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public View bjU()
  {
    return null;
  }
  
  public final boolean bjV()
  {
    AppMethodBeat.i(135198);
    e.b localb1 = e.b.lmQ;
    e.b localb2 = e.b.lmR;
    e.b localb3 = e.b.lmS;
    e.b localb4 = e.b.lmT;
    e.b localb5 = this.iGU.getOrientationHandler().aNL();
    boolean bool = org.apache.commons.b.a.contains(new e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public Bitmap bjW()
  {
    AppMethodBeat.i(135199);
    if (this.kWU == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = ca.cF(this.kWU.getWrapperView());
    if (localBitmap != null) {
      ca.a(bjD(), new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public final boolean bjX()
  {
    return this.lbf;
  }
  
  public final boolean bjz()
  {
    return this.cdK;
  }
  
  public void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    L(new aa.16(this, paramBoolean));
    AppMethodBeat.o(135185);
  }
  
  protected void by(List<p> paramList)
  {
    AppMethodBeat.i(135156);
    new r(this, new LinkedList(bjG()), false).aOh();
    AppMethodBeat.o(135156);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (bjA() != null)
    {
      if (!bjA().b(paramString1, paramString2, paramInt)) {
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
    Do();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.kXJ;
    localg.jvM.clear();
    localg.jvP.clear();
    localg.jvN.clear();
    localg.jvO.clear();
    localg.jvQ.clear();
    localg.jvR.clear();
    localg.jvT.clear();
    localg.jvS.clear();
    AppMethodBeat.o(135168);
  }
  
  public boolean ct(String paramString)
  {
    AppMethodBeat.i(135162);
    this.jzm = k.cA(paramString);
    this.kWX = paramString;
    this.kWU.setXWebKeyboardImpl(new ax()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e bjY()
      {
        return aa.this;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.c bjZ()
      {
        AppMethodBeat.i(194496);
        com.tencent.mm.plugin.appbrand.q localq = aa.this.Du();
        AppMethodBeat.o(194496);
        return localq;
      }
    });
    if (bjA() != null)
    {
      boolean bool = bjA().cn(paramString);
      AppMethodBeat.o(135162);
      return bool;
    }
    bjK();
    if (!aLz().DR(this.jzm))
    {
      cu(paramString);
      onReady();
      AppMethodBeat.o(135162);
      return false;
    }
    AppMethodBeat.o(135162);
    return true;
  }
  
  protected void cu(String paramString) {}
  
  public void fI(boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    L(new aa.15(this, paramBoolean));
    AppMethodBeat.o(135184);
  }
  
  protected void g(TextView paramTextView) {}
  
  protected final void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.lbj = paramBoolean;
    Object localObject = this.laU.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.kYy.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.iDV)
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
      this.jhz.requestLayout();
      this.laV.setFullscreenMode(this.lbj);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, laQ);
    }
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.iGU instanceof com.tencent.mm.plugin.appbrand.s.a.a.o))
    {
      localActivity = com.tencent.mm.sdk.f.a.iV(((com.tencent.mm.plugin.appbrand.s.a.a.o)this.iGU).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final View getContentView()
  {
    return this.jhz;
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.lbb != null)
    {
      locald = this.lbb;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.iGU == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), this.jzm });
      AppMethodBeat.o(176632);
      return null;
    }
    this.lbb = this.iGU.a(new d.b()
    {
      public final ViewGroup cD(View paramAnonymousView)
      {
        AppMethodBeat.i(176626);
        paramAnonymousView = aa.q(aa.this).bkr();
        AppMethodBeat.o(176626);
        return paramAnonymousView;
      }
    });
    this.lbb.a(new com.tencent.mm.plugin.appbrand.s.a.b()
    {
      public final void Cx()
      {
        AppMethodBeat.i(194495);
        aa.this.aWP();
        AppMethodBeat.o(194495);
      }
    });
    com.tencent.mm.plugin.appbrand.s.a.d locald = this.lbb;
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
    a.d locald = getRuntime().getAppConfig().FJ(this.jzm);
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.iGV;
  }
  
  public final String getURL()
  {
    return this.jzm;
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.c getWindowAndroid()
  {
    return this.iGU;
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(135167);
    if ((this.arf) && (super.isRunning()))
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
    if (this.lbb.aNT())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if (bjA() != null) {
      bjA();
    }
    Iterator localIterator = this.kXJ.jvQ.iterator();
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
    this.cdK = false;
    if (bjA() != null) {
      bjA().CC();
    }
    bjO();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.kXJ;
    Iterator localIterator = localg.jvN.iterator();
    while (localIterator.hasNext()) {
      ((f.b)localIterator.next()).onBackground();
    }
    localg.fL(false);
    AppMethodBeat.o(135173);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (bjA() != null) {
      bjA().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    bjQ();
    if (bjA() != null) {
      bjA().dispatchDestroy();
    }
    Iterator localIterator = this.kXJ.jvP.iterator();
    while (localIterator.hasNext()) {
      ((f.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    a(getRuntime().getWindowAndroid());
    this.cdK = true;
    if (bjA() != null) {
      bjA().CB();
    }
    bjN();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.kXJ;
    Iterator localIterator = localg.jvO.iterator();
    while (localIterator.hasNext()) {
      ((f.d)localIterator.next()).onForeground();
    }
    localg.fL(true);
    AppMethodBeat.o(135172);
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(135171);
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194497);
        if (!aa.this.isRunning())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandPageView", "onReady but not running, return, appId[%s] url[%s]", new Object[] { aa.this.getAppId(), aa.this.jzm });
          AppMethodBeat.o(194497);
          return;
        }
        aa.this.getRuntime().hKb.a(aa.r(aa.this));
        if (aa.this.bjA() != null) {
          aa.this.bjA().CE();
        }
        aa.this.bjM();
        Iterator localIterator = aa.this.kXJ.jvM.iterator();
        while (localIterator.hasNext()) {
          ((f.f)localIterator.next()).onReady();
        }
        AppMethodBeat.o(194497);
      }
    });
    AppMethodBeat.o(135171);
  }
  
  public void rl(int paramInt)
  {
    AppMethodBeat.i(135180);
    L(new aa.10(this, paramInt));
    AppMethodBeat.o(135180);
  }
  
  public void rm(int paramInt)
  {
    AppMethodBeat.i(135183);
    L(new aa.14(this, paramInt));
    AppMethodBeat.o(135183);
  }
  
  public final void s(double paramDouble)
  {
    AppMethodBeat.i(135179);
    L(new aa.9(this, paramDouble));
    AppMethodBeat.o(135179);
  }
  
  final void tr(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.lbj)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.laU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.laU.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.laU.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  public final p ts(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = bjG().iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((localp != null) && (localp.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localp;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  public final void tt(int paramInt)
  {
    this.lba = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa
 * JD-Core Version:    0.7.0.1
 */