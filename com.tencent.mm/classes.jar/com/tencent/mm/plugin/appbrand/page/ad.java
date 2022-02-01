package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.aq.1;
import com.tencent.mm.plugin.appbrand.aq.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsruntime.aa;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ah;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ad
  extends com.tencent.luggage.sdk.b.a.c
{
  private com.tencent.mm.plugin.appbrand.p jAF;
  private List<r> jFz;
  private AppBrandRecentView mgN;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.f mgO;
  public final com.tencent.mm.plugin.appbrand.report.g mgP;
  private boolean mgQ;
  public boolean mgR;
  public com.tencent.mm.plugin.appbrand.y.i<Boolean> mgS;
  private final AtomicBoolean mgT;
  public volatile boolean mgU;
  private s mgV;
  public ai mgW;
  private Boolean mgX;
  private final o mgY;
  
  public ad()
  {
    this(ac.class);
  }
  
  public ad(Class<? extends ab> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.mgP = new com.tencent.mm.plugin.appbrand.report.g(aXX());
    this.mgT = new AtomicBoolean(false);
    this.mgU = false;
    this.mgY = new o();
    if ((bv.fpT()) || (j.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.jAe = bool;
    AppMethodBeat.o(47884);
  }
  
  private boolean bvF()
  {
    AppMethodBeat.i(222872);
    String str = getRuntime().getAppConfig().NN(this.kxv).jZA.jZi;
    if (bu.isNullOrNil(str))
    {
      boolean bool = isDarkMode();
      AppMethodBeat.o(222872);
      return bool;
    }
    if (!e.a.mZn.name().equalsIgnoreCase(str))
    {
      AppMethodBeat.o(222872);
      return true;
    }
    AppMethodBeat.o(222872);
    return false;
  }
  
  private boolean isDarkMode()
  {
    AppMethodBeat.i(180349);
    if (this.mgX == null) {
      this.mgX = Boolean.valueOf(al.isDarkMode());
    }
    boolean bool = this.mgX.booleanValue();
    AppMethodBeat.o(180349);
    return bool;
  }
  
  public final void EL()
  {
    AppMethodBeat.i(222873);
    super.EL();
    if (aa.f(this))
    {
      ae.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.d.nwF) {
        break label183;
      }
      ae.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsruntime.i locali = aYB();
      int i = aXX();
      ae.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(i), getAppId(), Log.getStackTraceString(new Throwable()) });
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + i + "')", null);
      locali.evaluateJavascript("xweb.enableNativeTrans()", null);
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + i + "')", null);
      aa.a(aYB(), aXX(), getAppId());
      AppMethodBeat.o(222873);
      return;
      label183:
      ae.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      ah.FG(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.d.nwF = true;
    }
  }
  
  public void Es()
  {
    AppMethodBeat.i(47889);
    a(null);
    super.Es();
    if (this.mgN != null) {
      this.mgN.release();
    }
    if (this.mgO != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.f localf = this.mgO;
      localf.dismiss();
      if (localf.mZr != null)
      {
        localf.mZr.removeAllViews();
        localf.mZr = null;
      }
    }
    this.mgV = null;
    AppMethodBeat.o(47889);
  }
  
  public void Ex()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().aXo()) {
      bvi().setNavHidden(false);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.aa.g.am(this.jAF)) || (aq.o(getRuntime()))) {
        bvi().fC(true);
      }
      if ((this.mgR) && (bvi() != null) && (!bvi().isFullscreenMode())) {
        bvi().setNavHidden(this.mgU);
      }
      AppMethodBeat.o(47904);
      return;
      super.Ex();
    }
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    ae.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.mgQ = false;
    this.mgR = false;
    this.mgS = null;
    this.jAF = ((com.tencent.mm.plugin.appbrand.p)paramAppBrandRuntime);
    if (aWe() == null) {
      a(((com.tencent.mm.plugin.appbrand.p)paramAppBrandRuntime).aWe());
    }
    super.a(paramContext, paramAppBrandRuntime);
    paramContext = this.mgP;
    paramContext.mAppId = paramAppBrandRuntime.mAppId;
    paramContext.jDb = paramAppBrandRuntime;
    bvi().setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.appbrand.report.h.a(ad.this.getAppId(), ad.this.kxv, 22, "", bu.aRi(), 1, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47864);
      }
    });
    if ((paramAppBrandRuntime.jAe) && (((com.tencent.mm.plugin.appbrand.p)paramAppBrandRuntime).aXo())) {
      bvi().setNavButtonLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          ad.this.bvH();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(47871);
          return true;
        }
      });
    }
    this.ktB = new com.tencent.mm.plugin.appbrand.permission.a((com.tencent.mm.plugin.appbrand.p)paramAppBrandRuntime, this);
    if (aq.o(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.h.a(paramAppBrandRuntime, new aq.1(paramAppBrandRuntime, paramContext));
      if (this.jAF.aXx().Ee())
      {
        ae.i("MicroMsg.AppBrandPageViewWC", "decorateActionBarToSinglePageMode");
        if (this.mgo != null)
        {
          paramContext = getContext();
          this.mgo.fC(true);
          this.mgo.setNavResetStyleListener(new b.d()
          {
            public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
            {
              AppMethodBeat.i(222859);
              if (paramAnonymousImageView != null)
              {
                paramAnonymousImageView.clearColorFilter();
                if ((!ad.l(ad.this)) && (!ad.this.getRuntime().Ee())) {
                  break label92;
                }
              }
              label92:
              for (int i = 2131689499;; i = 2131689492)
              {
                paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(paramContext.getResources(), i));
                paramAnonymousView2 = paramAnonymousImageView.getLayoutParams();
                paramAnonymousView2.height = -1;
                paramAnonymousView2.width = -2;
                paramAnonymousImageView.setLayoutParams(paramAnonymousView2);
                if (paramAnonymousView1 != null) {
                  paramAnonymousView1.setBackground(null);
                }
                AppMethodBeat.o(222859);
                return;
              }
            }
            
            public final int bvI()
            {
              return mZd;
            }
          });
          if ((!isDarkMode()) && (!getRuntime().Ee())) {
            break label311;
          }
        }
      }
    }
    label311:
    for (int i = 2131689500;; i = 2131689493)
    {
      paramContext = com.tencent.mm.svg.a.a.h(paramContext.getResources(), i);
      this.mgo.a(paramContext, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(222860);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ad.this.bC(ad.this.bvh());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(222860);
        }
      });
      this.mgo.fE(false);
      this.mgo.bDc();
      ae.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
      AppMethodBeat.o(47885);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175037);
    long l;
    if (paramc == null)
    {
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).ca;
      if ((this.mgY.getContext() == paramc) && (this.mgY == this.jDa))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = bu.HQ();
      this.mgY.ax(paramc);
      super.a(this.mgY);
      ax(paramc);
      ae.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), this.kxv, Boolean.valueOf(isRunning()), Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.jDa) != 0)
    {
      l = bu.HQ();
      super.a(paramc);
      if ((getRuntime() != null) && (com.tencent.mm.sdk.f.a.jw(getRuntime().mContext) != null)) {
        ax(com.tencent.mm.sdk.f.a.jw(getRuntime().mContext));
      }
      ae.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.jDa, paramc, getAppId(), this.kxv, Long.valueOf(bu.aO(l)), Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aXz()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.Er();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  protected final void ax(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.ax(paramContext);
    if (this.mcJ != null) {
      this.mcJ.ax(paramContext);
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = bvG();
    if (locala != null)
    {
      if (paramContext == null)
      {
        AppMethodBeat.o(47886);
        return;
      }
      if ((locala.getContext() instanceof MutableContextWrapper)) {
        ((MutableContextWrapper)locala.getContext()).setBaseContext(paramContext);
      }
      locala.hLV.ax(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  protected final void bC(List<r> paramList)
  {
    AppMethodBeat.i(47905);
    this.mgV = new s(this, paramList);
    this.mgV.aYM();
    AppMethodBeat.o(47905);
  }
  
  protected void bta()
  {
    AppMethodBeat.i(47890);
    com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    if (getRuntime().aXo())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.mgN = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(getContext(), d.b.ntE, new d.a()
      {
        public final LocalUsageInfo bvJ()
        {
          AppMethodBeat.i(47877);
          if (!ad.this.isRunning())
          {
            AppMethodBeat.o(47877);
            return null;
          }
          LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(ad.this.getRuntime().aXx().username, ad.this.getRuntime().aXw().appId, ad.this.getRuntime().aXw().kbw.jLV, ad.this.getRuntime().aXw().kbw.pkgVersion, ad.this.getRuntime().aXw().dpI, ad.this.getRuntime().aXw().cmF, ad.this.getRuntime().aXw().iCT, ad.this.getRuntime().aXw().cnj);
          AppMethodBeat.o(47877);
          return localLocalUsageInfo;
        }
      });
      if (this.mgN == null)
      {
        AppMethodBeat.o(47890);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localException, "appId[%s]", new Object[] { getAppId() });
      }
      this.mgO = new com.tencent.mm.plugin.appbrand.widget.actionbar.f(getContext());
      this.mgO.setWidth(-1);
      this.mgO.setBackgroundDrawable(new ColorDrawable());
      this.mgN.refresh();
      this.mgO.setHeight(this.mgN.getLayoutParams().height);
      this.mgN.setBackground(com.tencent.mm.cb.a.l(getContext(), 2131230981));
      this.mgO.setContentView(this.mgN);
      this.mgN.setOnItemClickListener(new AppBrandRecentView.b()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(47879);
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47878);
              ad.k(ad.this).dismiss();
              AppMethodBeat.o(47878);
            }
          }, 100L);
          if (paramAnonymousa.type == 1)
          {
            paramAnonymousView = paramAnonymousa.ndd;
            paramAnonymousa = new AppBrandStatObject();
            paramAnonymousa.scene = 1090;
            paramAnonymousa.dlj = ad.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.e.f.lSd.a(ad.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.hSZ, -1, paramAnonymousa, null, null);
            AppMethodBeat.o(47879);
            return true;
          }
          AppMethodBeat.o(47879);
          return false;
        }
        
        public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          return false;
        }
      });
      AppMethodBeat.o(47890);
    }
  }
  
  public final aj bvC()
  {
    AppMethodBeat.i(47903);
    if ((bvb() instanceof ac))
    {
      aj localaj = ((ac)bvb()).bvC();
      AppMethodBeat.o(47903);
      return localaj;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.g bvE()
  {
    return this.mgP;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.ac.a bvG()
  {
    AppMethodBeat.i(47896);
    try
    {
      Object localObject = this.kfr.findViewById(2131296782);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.ac.a))
      {
        localObject = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject;
        AppMethodBeat.o(47896);
        return localObject;
      }
      AppMethodBeat.o(47896);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47896);
    }
    return null;
  }
  
  public final void bvH()
  {
    AppMethodBeat.i(47906);
    if ((this.jFz == null) || (this.jFz.size() <= 0))
    {
      ae.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.kxv });
      AppMethodBeat.o(47906);
      return;
    }
    bC(this.jFz);
    AppMethodBeat.o(47906);
  }
  
  public final List<r> bvg()
  {
    AppMethodBeat.i(47897);
    if (aq.o(getRuntime()))
    {
      bool = getRuntime().Ee();
      localLinkedList = new LinkedList();
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXl.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXm.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXK.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXL.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXv.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXG.ordinal(), false, false);
      if (bool) {
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXH.ordinal(), false, false);
      }
      this.jFz = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXl.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXm.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXK.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXu.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.a.KJ((String)localObject);
    if ((!com.tencent.mm.sdk.a.b.fnF()) && ((localObject == null) || (((k)localObject).kbw.jLV == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXt.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXL.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXM.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXj.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXE.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXF.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXs.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXG.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXJ.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXH.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.s.lXI.ordinal(), false, false);
      this.jFz = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  public final void bvm()
  {
    AppMethodBeat.i(47891);
    super.bvm();
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().cpU.a(this, c.a.class);
    boolean bool1;
    if ((!((a.d)localObject).jZu) || (!bool2))
    {
      bool1 = true;
      super.bt(bool1);
      if ((bool2) && (((a.d)localObject).jZu) && (getRuntime().aXx().cmt == 7) && (!bvi().isFullscreenMode())) {
        break label189;
      }
      ae.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((a.d)localObject).jZu + " appServiceType:" + getRuntime().aXx().cmt + " isFullscreenMode:" + bvi().isFullscreenMode());
    }
    for (;;)
    {
      if (!aq.o(getRuntime())) {
        break label228;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222863);
          ae.i("MicroMsg.AppBrandPageViewWC", "customActionBarIfNeed decorateActionBarToSinglePageMode");
          if (ad.this.mgo == null)
          {
            AppMethodBeat.o(222863);
            return;
          }
          Object localObject = ad.this.getContext();
          ad.this.mgo.setNavResetStyleListener(new b.d()
          {
            public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
            {
              AppMethodBeat.i(222861);
              if (paramAnonymous2ImageView != null)
              {
                paramAnonymous2ImageView.clearColorFilter();
                if ((!ad.m(ad.this)) && (!ad.this.getRuntime().Ee())) {
                  break label98;
                }
              }
              label98:
              for (int i = 2131689499;; i = 2131689492)
              {
                paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(this.val$context.getResources(), i));
                paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                paramAnonymous2View2.height = -1;
                paramAnonymous2View2.width = -2;
                paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                if (paramAnonymous2View1 != null) {
                  paramAnonymous2View1.setBackground(null);
                }
                AppMethodBeat.o(222861);
                return;
              }
            }
            
            public final int bvI()
            {
              return mZd;
            }
          });
          int i;
          if ((ad.m(ad.this)) || (ad.this.getRuntime().Ee()))
          {
            i = 2131689500;
            localObject = com.tencent.mm.svg.a.a.h(((Context)localObject).getResources(), i);
            ad.this.mgo.a((Bitmap)localObject, new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(222862);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ad.this.bC(ad.this.bvh());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(222862);
              }
            });
            if ("squeezed".equals(ad.n(ad.this))) {
              break label186;
            }
          }
          label186:
          for (boolean bool = true;; bool = false)
          {
            ad.this.hh(bool);
            ad.this.mgo.fE(false);
            ad.this.mgo.setFullscreenMode(false);
            ad.this.mgo.fC(true);
            ad.o(ad.this);
            AppMethodBeat.o(222863);
            return;
            i = 2131689493;
            break;
          }
        }
      });
      AppMethodBeat.o(47891);
      return;
      bool1 = false;
      break;
      label189:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((a.d)localObject).jZt, new com.tencent.mm.plugin.appbrand.widget.tabbar.c()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(47881);
          super.a(paramAnonymousString, paramAnonymousd);
          ae.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(47881);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).a(new com.tencent.mm.plugin.appbrand.widget.tabbar.e()
      {
        public final void a(Bitmap paramAnonymousBitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(47883);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          ad.this.bvi().a(paramAnonymousBitmap, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(47882);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
              com.tencent.mm.plugin.appbrand.page.c.d.g(ad.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(47882);
            }
          });
          AppMethodBeat.o(47883);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).bGG();
    }
    label228:
    if (com.tencent.mm.plugin.appbrand.aa.g.am(getRuntime()))
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180330);
          if (ad.this.mgo != null)
          {
            ae.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
            ad.this.mgo.setNavResetStyleListener(new b.d()
            {
              public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
              {
                AppMethodBeat.i(222864);
                if (paramAnonymous2ImageView != null)
                {
                  paramAnonymous2ImageView.clearColorFilter();
                  paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(ad.this.getContext().getResources(), 2131689682));
                  paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                  paramAnonymous2View2.height = -1;
                  paramAnonymous2View2.width = -2;
                  paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                }
                if (paramAnonymous2View1 != null) {
                  paramAnonymous2View1.setBackground(null);
                }
                AppMethodBeat.o(222864);
              }
              
              public final int bvI()
              {
                return mZd;
              }
            });
            ad.this.mgo.setFullscreenMode(true);
            ad.this.mgo.setForegroundStyle(false);
            ad.this.mgo.fE(false);
            ad.this.mgo.fC(true);
            ad.this.mgo.setBackButtonClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(222865);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ae.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
                com.tencent.mm.plugin.appbrand.aa.g.bCN();
                if (ad.h(ad.this) != null)
                {
                  com.tencent.mm.plugin.appbrand.h.a(ad.this.getAppId(), h.d.jzh);
                  ad.h(ad.this).close();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(222865);
              }
            });
          }
          if (ad.this.mgn != null) {
            ad.this.mgn.setForceTopInsetsHeight(ad.this.getContext().getResources().getDimensionPixelSize(2131165880));
          }
          ad.p(ad.this);
          AppMethodBeat.o(180330);
        }
      });
      AppMethodBeat.o(47891);
      return;
    }
    if ((getRuntime() != null) && (getRuntime().aXo())) {
      bvi().setNavHidden(false);
    }
    AppMethodBeat.o(47891);
  }
  
  protected final void bvo()
  {
    AppMethodBeat.i(47899);
    super.bvo();
    Object localObject = this.mgP;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).mxp = (bu.fpO() - ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).mxo);
    if (aWe().compareTo(getRuntime().aWe()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), aWe().aZK(), getRuntime().aWe().aZK() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void bvp()
  {
    AppMethodBeat.i(47900);
    super.bvp();
    Object localObject2;
    Object localObject1;
    if (getRuntime().Ee())
    {
      localObject2 = this.mgP;
      if (getRuntime().jzT)
      {
        localObject1 = getRuntime().aWx();
        ((com.tencent.mm.plugin.appbrand.report.g)localObject2).UQ((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = getRuntime().jzJ;
      localObject1 = new View.OnLongClickListener()
      {
        private void cJ(View paramAnonymousView)
        {
          AppMethodBeat.i(47875);
          if ((ad.j(ad.this) == null) || (ad.j(ad.this).getCount() == 0))
          {
            AppMethodBeat.o(47875);
            return;
          }
          ad.j(ad.this).refresh();
          ad.k(ad.this).showAsDropDown(paramAnonymousView);
          com.tencent.mm.plugin.appbrand.report.h.a(ad.this.getAppId(), ad.this.kxv, 21, "", bu.aRi(), 1, 0);
          AppMethodBeat.o(47875);
        }
        
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(47874);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          if (!ad.i(ad.this).getAndSet(true))
          {
            ad.this.bta();
            if (ad.j(ad.this) != null)
            {
              ad.j(ad.this).setRefreshListener(new AppBrandRecentView.e()
              {
                public final void uT(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(47873);
                  ad.j(ad.this).setRefreshListener(null);
                  ad.10.a(ad.10.this, paramAnonymousView);
                  AppMethodBeat.o(47873);
                }
              });
              ad.j(ad.this).refresh();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(47874);
            return true;
            cJ(paramAnonymousView);
          }
        }
      };
      localObject2 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject2).mkL;
      if (localObject2 == null) {
        d.g.b.p.bdF("capsuleBarView");
      }
      ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject2).getCapsuleHomeButton().setOnLongClickListener((View.OnLongClickListener)localObject1);
      AppMethodBeat.o(47900);
      return;
      localObject1 = getRuntime().aXy().getCurrentUrl();
      break;
      this.mgP.onForeground();
    }
  }
  
  protected final void bvq()
  {
    AppMethodBeat.i(47901);
    super.bvq();
    if (this.mgO != null) {
      this.mgO.dismiss();
    }
    this.mgP.onBackground();
    AppMethodBeat.o(47901);
  }
  
  public final boolean bvr()
  {
    AppMethodBeat.i(47895);
    if (this.mgQ)
    {
      AppMethodBeat.o(47895);
      return true;
    }
    boolean bool = super.bvr();
    AppMethodBeat.o(47895);
    return bool;
  }
  
  protected final void bvs()
  {
    AppMethodBeat.i(47902);
    super.bvs();
    this.mgP.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View bvw()
  {
    AppMethodBeat.i(175036);
    if (aq.o(getRuntime()))
    {
      AppMethodBeat.o(175036);
      return null;
    }
    AppBrandMenuHeader localAppBrandMenuHeader = new AppBrandMenuHeader(getContext());
    localAppBrandMenuHeader.setPage(this);
    AppMethodBeat.o(175036);
    return localAppBrandMenuHeader;
  }
  
  public final View bvx()
  {
    AppMethodBeat.i(47893);
    if (com.tencent.mm.plugin.appbrand.ad.e.d(this))
    {
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.b();
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).source = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).type = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.Er());
      localObject = new AppBrandMenuFooter(getContext());
      ((AppBrandMenuFooter)localObject).setPageView(this);
      ((AppBrandMenuFooter)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47880);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.appbrand.ad.e.c(ad.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47880);
        }
      });
      AppMethodBeat.o(47893);
      return localObject;
    }
    Object localObject = super.bvx();
    AppMethodBeat.o(47893);
    return localObject;
  }
  
  public final Bitmap bvz()
  {
    AppMethodBeat.i(222871);
    Object localObject1 = (com.tencent.luggage.game.page.d)Q(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.bvz();
      AppMethodBeat.o(222871);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).getMagicBrushView().getMagicBrush().cxs.h(((com.tencent.luggage.game.page.d)localObject1).getMagicBrushView().getVirtualElementId(), -1, true);
      AppMethodBeat.o(222871);
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localNullPointerException, "hy: exception in get snapshot", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.FFH));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGM(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGT(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGP(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGW(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGS(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGR(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGX()));
    c(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGO()));
    AppMethodBeat.o(47907);
  }
  
  public final boolean dm(String paramString)
  {
    AppMethodBeat.i(47898);
    ae.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL");
    com.tencent.mm.plugin.appbrand.report.g localg = this.mgP;
    localg.mxo = bu.fpO();
    localg.mxn = paramString;
    a(getRuntime().getWindowAndroid());
    boolean bool = super.dm(paramString);
    AppMethodBeat.o(47898);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.p getRuntime()
  {
    AppMethodBeat.i(47887);
    com.tencent.mm.plugin.appbrand.p localp = (com.tencent.mm.plugin.appbrand.p)super.Eq();
    AppMethodBeat.o(47887);
    return localp;
  }
  
  public void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(47894);
    ae.i("MicroMsg.AppBrandPageViewWC", "setHideHomeButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((com.tencent.mm.plugin.appbrand.aa.g.am(getRuntime())) || (aq.o(getRuntime())))
    {
      ae.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, weishi app");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.mgo == null)
    {
      ae.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, ActionBar hasn't init");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.mgo.isFullscreenMode())
    {
      ae.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, is in fullscreen mode now");
      AppMethodBeat.o(47894);
      return;
    }
    this.mgU = paramBoolean;
    if (this.mgS != null) {
      this.mgU = ((Boolean)this.mgS.value).booleanValue();
    }
    if (!this.mgR)
    {
      if (this.mgo != null)
      {
        ae.i("MicroMsg.AppBrandPageViewWC", "not homepage enter customActionBar");
        this.mgo.setNavResetStyleListener(new ad.6(this));
        this.mgo.setBackButtonClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(222868);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
            if (ad.this.bvi().bDe())
            {
              ae.i("MicroMsg.AppBrandPageViewWC", "pageview click close button, but nav area is hidden");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(222868);
              return;
            }
            if (ad.h(ad.this) != null) {
              ad.h(ad.this).aXy().buR();
            }
            if ((ad.this.mcJ != null) && (ad.h(ad.this) != null)) {
              com.tencent.mm.plugin.appbrand.report.h.F(ad.h(ad.this).mAppId, ad.this.kxv, 3);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(222868);
          }
        });
        this.mgo.bDc();
        this.mgQ = true;
      }
      if (this.jAF == null)
      {
        str = "";
        com.tencent.mm.plugin.appbrand.report.h.F(str, this.kxv, 1);
        this.mgR = true;
      }
    }
    else
    {
      bvi().setNavHidden(this.mgU);
      if ((this.mgU) && (this.mcJ != null)) {
        if (this.jAF != null) {
          break label293;
        }
      }
    }
    label293:
    for (String str = "";; str = this.jAF.mAppId)
    {
      com.tencent.mm.plugin.appbrand.report.h.F(str, this.kxv, 2);
      AppMethodBeat.o(47894);
      return;
      str = this.jAF.mAppId;
      break;
    }
  }
  
  protected final View j(ViewGroup paramViewGroup)
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(180347);
    if ((this.jAF == null) || (!aq.o(this.jAF)) || (!(paramViewGroup instanceof RelativeLayout)))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.mgW == null) {
      this.mgW = new ai(getContext());
    }
    Object localObject1 = this.mgW;
    Object localObject2 = this.jAF.aXx().iconUrl;
    String str1 = this.jAF.aXx().dpI;
    String str2 = com.tencent.mm.plugin.appbrand.appcache.e.rS(this.jAF.aXw().kbw.jLV);
    boolean bool = this.jAF.aXx().Ee();
    int j;
    if (this.jAF.aXx().originalFlag == 1)
    {
      com.tencent.mm.modelappbrand.a.b.aEl().a(((ai)localObject1).kEm, (String)localObject2, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
      localObject2 = ((ai)localObject1).mhH;
      if (!bool) {
        break label310;
      }
      j = 2131759360;
      label175:
      ((Button)localObject2).setText(j);
      ((ai)localObject1).kEn.setText(str1);
      if (!bu.isNullOrNil(str2)) {
        break label323;
      }
      ((ai)localObject1).mhG.setVisibility(8);
      localObject1 = ((ai)localObject1).mhI;
      if (i == 0) {
        break label317;
      }
      i = k;
      label223:
      ((ImageView)localObject1).setVisibility(i);
    }
    for (;;)
    {
      this.mgW.setJumpBtnOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(222869);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = ad.h(ad.this);
          localObject = ad.this.mcM;
          aq.a locala = new aq.a();
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("currentPath", localObject);
          locala.H(localHashMap).g(paramAnonymousView.aXz()).bja();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(222869);
        }
      });
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (-getContext().getResources().getDimensionPixelSize(2131165852));
      paramViewGroup.addView(this.mgW, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup = this.mgW;
      AppMethodBeat.o(180347);
      return paramViewGroup;
      i = 0;
      break;
      label310:
      j = 2131756060;
      break label175;
      label317:
      i = 8;
      break label223;
      label323:
      ((ai)localObject1).mhG.setText(str2);
      ((ai)localObject1).mhG.setVisibility(0);
      ((ai)localObject1).mhI.setVisibility(8);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.jAF != null) && (aq.o(this.jAF)))
    {
      ae.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.h.a(getAppId(), h.d.jzi);
      this.jAF.close();
      AppMethodBeat.o(180348);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(180348);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */