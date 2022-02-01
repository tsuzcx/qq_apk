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
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
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
  private static final int lCp = 2131296686;
  public volatile boolean caH;
  private volatile boolean eg;
  public ViewGroup jHO;
  public String jZJ;
  private volatile boolean jgV;
  public com.tencent.mm.plugin.appbrand.r.a.c jgX;
  private volatile AppBrandRuntime jgY;
  private List<com.tencent.mm.plugin.appbrand.menu.p> jiT;
  public FrameLayout lAi;
  private com.tencent.mm.plugin.appbrand.r.a.d lCA;
  public final com.tencent.mm.plugin.appbrand.widget.e.b lCB;
  public r lCC;
  private al lCD;
  boolean lCE;
  private final l lCF;
  protected boolean lCG;
  private int[] lCH;
  private boolean lCI;
  private final int lCq;
  private ac lCr;
  private final Class<? extends ac> lCs;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d lCt;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b lCu;
  public am lCv;
  public bc lCw;
  public boolean lCx;
  protected CharSequence lCy;
  protected int lCz;
  bs lrk;
  public ay lyE;
  public String lyH;
  private Context mContext;
  
  public aa()
  {
    this(null);
  }
  
  protected aa(Class<? extends ac> paramClass)
  {
    AppMethodBeat.i(135144);
    this.lCq = 2131296685;
    this.eg = false;
    this.jgV = false;
    this.caH = false;
    this.lCx = false;
    this.lCy = null;
    this.lCz = -2147483648;
    this.lCB = new com.tencent.mm.plugin.appbrand.widget.e.b(this);
    this.lrk = null;
    this.jgX = new o();
    this.lCE = false;
    this.lCF = new l()
    {
      public final void f(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176625);
        if (paramAnonymousBoolean.booleanValue())
        {
          aa.this.gh(false);
          AppMethodBeat.o(176625);
          return;
        }
        aa.this.gh(true);
        AppMethodBeat.o(176625);
      }
    };
    this.lCG = false;
    this.lCH = new int[0];
    this.lCI = false;
    this.lCs = paramClass;
    AppMethodBeat.o(135144);
  }
  
  private static int a(a.d paramd)
  {
    AppMethodBeat.i(135164);
    try
    {
      i = com.tencent.mm.plugin.appbrand.z.g.Rr(paramd.jCh);
      AppMethodBeat.o(135164);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.z.g.cd(paramd.jBX, -1);
      }
    }
  }
  
  private void boy()
  {
    AppMethodBeat.i(135196);
    this.jgV = true;
    if (bqr() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.b.g)bqr().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.b.g)localObject).boy();
        AppMethodBeat.o(135196);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { bqr().getClass().getName() }));
      AppMethodBeat.o(135196);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(135196);
  }
  
  public final void B(CharSequence paramCharSequence)
  {
    this.lCy = paramCharSequence;
  }
  
  public View CQ()
  {
    AppMethodBeat.i(176633);
    if (!TextUtils.isEmpty(this.lCy))
    {
      View localView = LayoutInflater.from(this.mContext).inflate(2131493090, null);
      TextView localTextView = (TextView)localView.findViewById(2131296882);
      localTextView.setText(this.lCy);
      g(localTextView);
      AppMethodBeat.o(176633);
      return localView;
    }
    AppMethodBeat.o(176633);
    return null;
  }
  
  protected void CR()
  {
    AppMethodBeat.i(135169);
    this.lyE.destroy();
    if (this.lCv != null) {
      this.lCv.removeAll();
    }
    if (this.lCu != null) {
      this.lCu.destroy();
    }
    if (this.jHO != null) {
      this.jHO.removeAllViewsInLayout();
    }
    if (this.lCt != null)
    {
      this.lCt.setActuallyVisible(false);
      this.lCt.removeAllViewsInLayout();
    }
    if (this.lAi != null) {
      this.lAi.removeAllViewsInLayout();
    }
    this.lCB.bBx();
    if (getRuntime() != null) {
      getRuntime().iky.b(this.lCF);
    }
    this.lyE = null;
    this.lCv = null;
    this.jHO = null;
    this.lCt = null;
    this.lAi = null;
    this.lCu = null;
    AppMethodBeat.o(135169);
  }
  
  public com.tencent.mm.plugin.appbrand.q CX()
  {
    AppMethodBeat.i(135152);
    if (getRuntime() == null)
    {
      AppMethodBeat.o(135152);
      return null;
    }
    com.tencent.mm.plugin.appbrand.q localq = getRuntime().CX();
    AppMethodBeat.o(135152);
    return localq;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Dm()
  {
    AppMethodBeat.i(135151);
    if (bqr() != null)
    {
      Map localMap = bqr().Ch();
      AppMethodBeat.o(135151);
      return localMap;
    }
    AppMethodBeat.o(135151);
    return null;
  }
  
  public final void J(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135188);
    Iterator localIterator = bqx().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.p localp = (com.tencent.mm.plugin.appbrand.menu.p)localIterator.next();
      if ((localp != null) && (localp.id == paramInt))
      {
        localp.ltx = paramBoolean;
        AppMethodBeat.o(135188);
        return;
      }
    }
    AppMethodBeat.o(135188);
  }
  
  public void LB(final String paramString)
  {
    AppMethodBeat.i(135181);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135124);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135124);
          return;
        }
        aa.this.bqy().setMainTitle(paramString);
        AppMethodBeat.o(135124);
      }
    });
    AppMethodBeat.o(135181);
  }
  
  public void LC(final String paramString)
  {
    AppMethodBeat.i(135191);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135131);
        if (aa.this.lCt == null)
        {
          AppMethodBeat.o(135131);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = aa.this.lCt;
        if (d.a.PW(paramString) == d.a.lGv) {}
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
  
  public final void MV()
  {
    AppMethodBeat.i(135149);
    bey();
    boy();
    AppMethodBeat.o(135149);
  }
  
  protected final boolean PF(String paramString)
  {
    AppMethodBeat.i(193418);
    if (this.lCG)
    {
      int i = aUT();
      this.lCH = new int[0];
      aUT();
      int j = aUT();
      c("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(j) }), 0);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), this.jZJ, paramString, Integer.valueOf(i), Integer.valueOf(j) });
      this.lCG = false;
      this.lCC.PC(paramString);
      this.lCC.a(bt.lGm, null);
      this.lCC.bqe();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(aUT()) });
      AppMethodBeat.o(193418);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), this.jZJ, paramString });
    AppMethodBeat.o(193418);
    return false;
  }
  
  public final void PK(String paramString)
  {
    AppMethodBeat.i(135194);
    if (paramString.equalsIgnoreCase("dark"))
    {
      this.lCx = true;
      AppMethodBeat.o(135194);
      return;
    }
    this.lCx = false;
    AppMethodBeat.o(135194);
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(135200);
    if (bqr() != null)
    {
      paramClass = bqr().Q(paramClass);
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
    this.jgY = paramAppBrandRuntime;
    this.eg = true;
    a(paramAppBrandRuntime.getWindowAndroid());
    f(paramAppBrandRuntime.jdG);
    super.init();
    if (bqr() != null)
    {
      paramContext = (View)com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onCreateView", new d.g.a.a() {});
      com.tencent.luggage.sdk.g.c.a("AppBrandPageViewProfile| onViewCreated", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135134);
          aa.a(aa.this, new aa.a(aa.this, aa.this.getContext()));
          View localView = aa.this.j(aa.l(aa.this));
          RelativeLayout.LayoutParams localLayoutParams = aa.this.bqr().cn(localView);
          if (localView != null) {
            aa.l(aa.this).addView(paramContext, aa.l(aa.this).getChildCount() - 1, localLayoutParams);
          }
          for (;;)
          {
            aa.this.bqr().cm(paramContext);
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
          aa.this.lCt.aw(aa.this.getContext());
          aa.l(aa.this).addView(aa.this.lCt, -1, new ViewGroup.LayoutParams(-1, -2));
          aa.this.bqr().b(aa.this.lCu);
          if (aa.this.lCu.getParent() != aa.this.lCt)
          {
            IllegalAccessError localIllegalAccessError = new IllegalAccessError("You should not modify actionbar's view hierarchy");
            AppMethodBeat.o(135135);
            throw localIllegalAccessError;
          }
          AppMethodBeat.o(135135);
        }
      });
      this.lAi = ((FrameLayout)paramContext);
      this.lCw = bqr().Cd();
      this.lCv = bqr().Ce();
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (bqr() != null) {
      bqr().dispatchStart();
    }
    AppMethodBeat.o(135146);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(176631);
    this.jgX = paramc;
    if ((this.jgX != null) && (this.lCA != null))
    {
      this.lCA = null;
      getFullscreenImpl();
    }
    AppMethodBeat.o(176631);
  }
  
  public final void a(Map<String, Object> paramMap, bt parambt)
  {
    AppMethodBeat.i(135147);
    if (this.lCG) {
      paramMap.put("notFound", Boolean.TRUE);
    }
    ac localac = bqr();
    if (localac != null) {
      localac.a(paramMap, parambt);
    }
    AppMethodBeat.o(135147);
  }
  
  public final int aUT()
  {
    AppMethodBeat.i(193419);
    if ((this.lCH == null) || (this.lCH.length <= 0)) {
      this.lCH = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
    }
    int i = this.lCH[0];
    AppMethodBeat.o(193419);
    return i;
  }
  
  public final boolean aUl()
  {
    AppMethodBeat.i(135197);
    if (bqr() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.g localg = (com.tencent.mm.plugin.appbrand.page.b.g)bqr().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if ((localg != null) && (localg.boA()))
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
  
  public final boolean aUm()
  {
    AppMethodBeat.i(193420);
    if (bqr() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.g localg = (com.tencent.mm.plugin.appbrand.page.b.g)bqr().Q(com.tencent.mm.plugin.appbrand.page.b.g.class);
      if ((localg != null) && (localg.aUm()))
      {
        AppMethodBeat.o(193420);
        return true;
      }
      AppMethodBeat.o(193420);
      return false;
    }
    boolean bool = this.jgV;
    AppMethodBeat.o(193420);
    return bool;
  }
  
  public final String aUq()
  {
    return "AppBrandPageView";
  }
  
  protected void aw(Context paramContext)
  {
    AppMethodBeat.i(135148);
    this.mContext = paramContext;
    if (this.lCt != null) {
      this.lCt.aw(paramContext);
    }
    AppMethodBeat.o(135148);
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135165);
    if ((this.jgY == null) || (this.jgY.CX() == null))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(135165);
      return;
    }
    if ((bqr() != null) && (bqr().y(paramString1, paramString2)))
    {
      AppMethodBeat.o(135165);
      return;
    }
    this.jgY.CX().c(paramString1, paramString2, aUT());
    AppMethodBeat.o(135165);
  }
  
  public String bdM()
  {
    AppMethodBeat.i(135182);
    Object localObject = this.lCu;
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
  
  public void bdN()
  {
    AppMethodBeat.i(135190);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135130);
        if (aa.this.lCt == null)
        {
          AppMethodBeat.o(135130);
          return;
        }
        aa.this.lCt.byj();
        AppMethodBeat.o(135130);
      }
    });
    AppMethodBeat.o(135190);
  }
  
  public final String bqA()
  {
    return this.lyH;
  }
  
  public void bqB()
  {
    AppMethodBeat.i(135163);
    a.d locald = getPageConfig();
    LB(locald.jCd);
    locald.getClass();
    r(1.0D);
    rY(a(locald));
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135126);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135126);
          return;
        }
        aa.this.bqy().setForegroundStyle(this.jRU);
        aa.this.LC(this.jRU);
        AppMethodBeat.o(135126);
      }
    });
    gX(locald.bap());
    boolean bool = locald.jCl;
    if (bqr() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.b.f)bqr().Q(com.tencent.mm.plugin.appbrand.page.b.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.b.f)localObject).gZ(bool);
      }
    }
    Object localObject = locald.jCn;
    String str = locald.jBX;
    if (bqr() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.f localf = (com.tencent.mm.plugin.appbrand.page.b.f)bqr().Q(com.tencent.mm.plugin.appbrand.page.b.f.class);
      if (localf != null) {
        localf.dY((String)localObject, str);
      }
    }
    if (!locald.jCj) {}
    for (bool = true;; bool = false)
    {
      bs(bool);
      if (this.lCE) {
        this.lCu.setNavHidden(true);
      }
      AppMethodBeat.o(135163);
      return;
    }
  }
  
  public final void bqC()
  {
    AppMethodBeat.i(135170);
    this.lCt.setActuallyVisible(true);
    AppMethodBeat.o(135170);
  }
  
  protected void bqD() {}
  
  protected void bqE() {}
  
  protected void bqF() {}
  
  public boolean bqG()
  {
    return false;
  }
  
  protected void bqH()
  {
    this.eg = false;
  }
  
  public final void bqI()
  {
    AppMethodBeat.i(135177);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160933);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(160933);
          return;
        }
        aa.this.gX(false);
        aa.this.bqy().setFullscreenMode(false);
        AppMethodBeat.o(160933);
      }
    });
    AppMethodBeat.o(135177);
  }
  
  public final void bqJ()
  {
    AppMethodBeat.i(135178);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135121);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135121);
          return;
        }
        aa.this.gX(true);
        aa.this.bqy().setFullscreenMode(true);
        AppMethodBeat.o(135121);
      }
    });
    AppMethodBeat.o(135178);
  }
  
  public final void bqK()
  {
    AppMethodBeat.i(135187);
    if (bqr() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.f localf = (com.tencent.mm.plugin.appbrand.page.b.f)bqr().Q(com.tencent.mm.plugin.appbrand.page.b.f.class);
      if (localf != null) {
        localf.hb(false);
      }
      AppMethodBeat.o(135187);
      return;
    }
    AppMethodBeat.o(135187);
  }
  
  public View bqL()
  {
    return null;
  }
  
  public final boolean bqM()
  {
    AppMethodBeat.i(135198);
    e.b localb1 = e.b.lOS;
    e.b localb2 = e.b.lOT;
    e.b localb3 = e.b.lOU;
    e.b localb4 = e.b.lOV;
    e.b localb5 = this.jgX.getOrientationHandler().aUB();
    boolean bool = org.apache.commons.b.a.contains(new e.b[] { localb1, localb2, localb3, localb4 }, localb5);
    AppMethodBeat.o(135198);
    return bool;
  }
  
  public Bitmap bqN()
  {
    AppMethodBeat.i(135199);
    if (this.lyE == null)
    {
      AppMethodBeat.o(135199);
      return null;
    }
    Bitmap localBitmap = bv.cH(this.lyE.getWrapperView());
    if (localBitmap != null) {
      bv.a(bqu(), new Canvas(localBitmap));
    }
    AppMethodBeat.o(135199);
    return localBitmap;
  }
  
  public final boolean bqO()
  {
    return this.lCE;
  }
  
  public final boolean bqq()
  {
    return this.caH;
  }
  
  protected final ac bqr()
  {
    AppMethodBeat.i(135145);
    if (this.lCs == null)
    {
      AppMethodBeat.o(135145);
      return null;
    }
    if (this.lCr != null)
    {
      localac = this.lCr;
      AppMethodBeat.o(135145);
      return localac;
    }
    ac localac = (ac)org.a.a.bD(this.lCs).ai(new Object[] { this }).object;
    this.lCr = localac;
    AppMethodBeat.o(135145);
    return localac;
  }
  
  public final r bqs()
  {
    return this.lCC;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.e.b bqt()
  {
    return this.lCB;
  }
  
  public final ViewGroup bqu()
  {
    AppMethodBeat.i(135153);
    ViewGroup localViewGroup = this.lCw.getContainer();
    AppMethodBeat.o(135153);
    return localViewGroup;
  }
  
  public final ad bqv()
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
  
  public List<com.tencent.mm.plugin.appbrand.menu.p> bqw()
  {
    AppMethodBeat.i(135157);
    List localList = Collections.emptyList();
    AppMethodBeat.o(135157);
    return localList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.p> bqx()
  {
    AppMethodBeat.i(135158);
    if (this.jiT == null) {
      this.jiT = bqw();
    }
    List localList = this.jiT;
    AppMethodBeat.o(135158);
    return localList;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b bqy()
  {
    return this.lCu;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d bqz()
  {
    return this.lCt;
  }
  
  public void bs(final boolean paramBoolean)
  {
    AppMethodBeat.i(135185);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135129);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135129);
          return;
        }
        aa.this.bqy().hA(paramBoolean);
        AppMethodBeat.o(135129);
      }
    });
    AppMethodBeat.o(135185);
  }
  
  protected void by(List<com.tencent.mm.plugin.appbrand.menu.p> paramList)
  {
    AppMethodBeat.i(135156);
    new s(this, new LinkedList(bqx()), false).aUX();
    AppMethodBeat.o(135156);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135166);
    if (bqr() != null)
    {
      if (!bqr().b(paramString1, paramString2, paramInt)) {
        super.c(paramString1, paramString2, paramInt);
      }
      AppMethodBeat.o(135166);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(135166);
  }
  
  public boolean ci(String paramString)
  {
    AppMethodBeat.i(135162);
    this.jZJ = k.cp(paramString);
    this.lyH = paramString;
    this.lyE.setXWebKeyboardImpl(new as()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.e bqP()
      {
        return aa.this;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.c bqQ()
      {
        AppMethodBeat.i(193416);
        com.tencent.mm.plugin.appbrand.q localq = aa.this.CX();
        AppMethodBeat.o(193416);
        return localq;
      }
    });
    if (bqr() != null)
    {
      boolean bool = bqr().cd(paramString);
      AppMethodBeat.o(135162);
      return bool;
    }
    bqB();
    if (!aSq().HU(this.jZJ))
    {
      cj(paramString);
      onReady();
      AppMethodBeat.o(135162);
      return false;
    }
    AppMethodBeat.o(135162);
    return true;
  }
  
  protected void cj(String paramString) {}
  
  public final void cleanup()
  {
    AppMethodBeat.i(135168);
    super.cleanup();
    CR();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.lzt;
    localg.jWi.clear();
    localg.jWl.clear();
    localg.jWj.clear();
    localg.jWk.clear();
    localg.jWm.clear();
    localg.jWn.clear();
    localg.jWp.clear();
    localg.jWo.clear();
    AppMethodBeat.o(135168);
  }
  
  protected void g(TextView paramTextView) {}
  
  protected final void gX(boolean paramBoolean)
  {
    AppMethodBeat.i(135186);
    this.lCI = paramBoolean;
    Object localObject = this.lCt.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.lAi.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.jdX)
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
      this.jHO.requestLayout();
      this.lCu.setFullscreenMode(this.lCI);
      AppMethodBeat.o(135186);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, lCp);
    }
  }
  
  public void ge(final boolean paramBoolean)
  {
    AppMethodBeat.i(135184);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135128);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135128);
          return;
        }
        aa.this.bqy().setLoadingIconVisibility(paramBoolean);
        AppMethodBeat.o(135128);
      }
    });
    AppMethodBeat.o(135184);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(164053);
    if ((this.jgX instanceof o))
    {
      localActivity = com.tencent.mm.sdk.f.a.jg(((o)this.jgX).mContext);
      AppMethodBeat.o(164053);
      return localActivity;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(getContext());
    AppMethodBeat.o(164053);
    return localActivity;
  }
  
  public final View getContentView()
  {
    return this.jHO;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d getFullscreenImpl()
  {
    AppMethodBeat.i(176632);
    if (this.lCA != null)
    {
      locald = this.lCA;
      AppMethodBeat.o(176632);
      return locald;
    }
    if (this.jgX == null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), this.jZJ });
      AppMethodBeat.o(176632);
      return null;
    }
    this.lCA = this.jgX.a(new d.b()
    {
      public final ViewGroup cF(View paramAnonymousView)
      {
        AppMethodBeat.i(176626);
        paramAnonymousView = aa.q(aa.this).brg();
        AppMethodBeat.o(176626);
        return paramAnonymousView;
      }
    });
    this.lCA.a(new com.tencent.mm.plugin.appbrand.r.a.b()
    {
      public final void Cb()
      {
        AppMethodBeat.i(193415);
        aa.this.bdN();
        AppMethodBeat.o(193415);
      }
    });
    com.tencent.mm.plugin.appbrand.r.a.d locald = this.lCA;
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
    a.d locald = getRuntime().getAppConfig().JN(this.jZJ);
    AppMethodBeat.o(135161);
    return locald;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jgY;
  }
  
  public final String getURL()
  {
    return this.jZJ;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.c getWindowAndroid()
  {
    return this.jgX;
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(135167);
    if ((this.eg) && (super.isRunning()))
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
    if (this.lCA.aUJ())
    {
      AppMethodBeat.o(135174);
      return true;
    }
    if (bqr() != null) {
      bqr();
    }
    Iterator localIterator = this.lzt.jWm.iterator();
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
    this.caH = false;
    if (bqr() != null) {
      bqr().Cg();
    }
    bqF();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.lzt;
    Iterator localIterator = localg.jWj.iterator();
    while (localIterator.hasNext()) {
      ((f.b)localIterator.next()).onBackground();
    }
    localg.gh(false);
    AppMethodBeat.o(135173);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135175);
    if (bqr() != null) {
      bqr().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(135175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135176);
    bqH();
    if (bqr() != null) {
      bqr().dispatchDestroy();
    }
    Iterator localIterator = this.lzt.jWl.iterator();
    while (localIterator.hasNext()) {
      ((f.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(135176);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(135172);
    a(getRuntime().getWindowAndroid());
    this.caH = true;
    if (bqr() != null) {
      bqr().Cf();
    }
    bqE();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.lzt;
    Iterator localIterator = localg.jWk.iterator();
    while (localIterator.hasNext()) {
      ((f.d)localIterator.next()).onForeground();
    }
    localg.gh(true);
    AppMethodBeat.o(135172);
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(135171);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193417);
        if (!aa.this.isRunning())
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandPageView", "onReady but not running, return, appId[%s] url[%s]", new Object[] { aa.this.getAppId(), aa.this.jZJ });
          AppMethodBeat.o(193417);
          return;
        }
        aa.this.getRuntime().iky.a(aa.r(aa.this));
        if (aa.this.bqr() != null) {
          aa.this.bqr().Ci();
        }
        aa.this.bqD();
        Iterator localIterator = aa.this.lzt.jWi.iterator();
        while (localIterator.hasNext()) {
          ((f.f)localIterator.next()).onReady();
        }
        AppMethodBeat.o(193417);
      }
    });
    AppMethodBeat.o(135171);
  }
  
  public final void r(final double paramDouble)
  {
    AppMethodBeat.i(135179);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135122);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135122);
          return;
        }
        aa.this.bqy().setBackgroundAlpha(paramDouble);
        AppMethodBeat.o(135122);
      }
    });
    AppMethodBeat.o(135179);
  }
  
  public void rY(final int paramInt)
  {
    AppMethodBeat.i(135180);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135123);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135123);
          return;
        }
        aa.this.bqy().setBackgroundColor(paramInt);
        AppMethodBeat.o(135123);
      }
    });
    AppMethodBeat.o(135180);
  }
  
  public void rZ(final int paramInt)
  {
    AppMethodBeat.i(135183);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135127);
        if (aa.this.bqy() == null)
        {
          AppMethodBeat.o(135127);
          return;
        }
        aa.this.bqy().setForegroundColor(paramInt);
        AppMethodBeat.o(135127);
      }
    });
    AppMethodBeat.o(135183);
  }
  
  final void ui(int paramInt)
  {
    AppMethodBeat.i(135160);
    if (this.lCI)
    {
      AppMethodBeat.o(135160);
      return;
    }
    if ((this.lCt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lCt.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.lCt.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(135160);
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.p uj(int paramInt)
  {
    AppMethodBeat.i(135189);
    Iterator localIterator = bqx().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.menu.p localp = (com.tencent.mm.plugin.appbrand.menu.p)localIterator.next();
      if ((localp != null) && (localp.id == paramInt))
      {
        AppMethodBeat.o(135189);
        return localp;
      }
    }
    AppMethodBeat.o(135189);
    return null;
  }
  
  public final void uk(int paramInt)
  {
    this.lCz = paramInt;
  }
  
  final class a
    extends RelativeLayout
    implements bu
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean c(Canvas paramCanvas)
    {
      AppMethodBeat.i(135142);
      aa.this.lCt.draw(paramCanvas);
      Bitmap localBitmap = aa.this.bqN();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa
 * JD-Core Version:    0.7.0.1
 */