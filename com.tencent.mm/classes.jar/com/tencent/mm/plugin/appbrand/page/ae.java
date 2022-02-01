package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.ap.1;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.backgroundrunning.a.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ah;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ae
  extends com.tencent.luggage.sdk.b.a.c
{
  private List<q> jCB;
  private com.tencent.mm.plugin.appbrand.o jxG;
  public com.tencent.mm.plugin.appbrand.z.i<Boolean> mcA;
  private final AtomicBoolean mcB;
  public volatile boolean mcC;
  private t mcD;
  public aj mcE;
  private Boolean mcF;
  private final com.tencent.mm.plugin.appbrand.r.a.a.o mcG;
  private AppBrandRecentView mcv;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.g mcw;
  public final com.tencent.mm.plugin.appbrand.report.g mcx;
  private boolean mcy;
  public boolean mcz;
  
  public ae()
  {
    this(ad.class);
  }
  
  public ae(Class<? extends ac> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.mcx = new com.tencent.mm.plugin.appbrand.report.g(aXC());
    this.mcB = new AtomicBoolean(false);
    this.mcC = false;
    this.mcG = new com.tencent.mm.plugin.appbrand.r.a.a.o();
    if ((bu.flY()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.jxf = bool;
    AppMethodBeat.o(47884);
  }
  
  private boolean buU()
  {
    AppMethodBeat.i(180349);
    String str = getRuntime().getAppConfig().Ng(this.kuf).jWl.jVT;
    if (bt.isNullOrNil(str))
    {
      boolean bool = isDarkMode();
      AppMethodBeat.o(180349);
      return bool;
    }
    if (!com.tencent.mm.plugin.appbrand.page.a.d.a.mfY.name().equalsIgnoreCase(str))
    {
      AppMethodBeat.o(180349);
      return true;
    }
    AppMethodBeat.o(180349);
    return false;
  }
  
  private boolean isDarkMode()
  {
    AppMethodBeat.i(221305);
    if (this.mcF == null) {
      this.mcF = Boolean.valueOf(al.isDarkMode());
    }
    boolean bool = this.mcF.booleanValue();
    AppMethodBeat.o(221305);
    return bool;
  }
  
  public final void EJ()
  {
    AppMethodBeat.i(188697);
    super.EJ();
    if (z.f(this))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.d.nrm) {
        break label183;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsruntime.i locali = aYh();
      int i = aXC();
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(i), getAppId(), Log.getStackTraceString(new Throwable()) });
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + i + "')", null);
      locali.evaluateJavascript("xweb.enableNativeTrans()", null);
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + i + "')", null);
      z.a(aYh(), aXC(), getAppId());
      AppMethodBeat.o(188697);
      return;
      label183:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      ah.Fe(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.d.nrm = true;
    }
  }
  
  public final View Ep()
  {
    AppMethodBeat.i(175036);
    if (ap.n(getRuntime()))
    {
      AppMethodBeat.o(175036);
      return null;
    }
    AppBrandMenuHeader localAppBrandMenuHeader = new AppBrandMenuHeader(getContext());
    localAppBrandMenuHeader.setPage(this);
    AppMethodBeat.o(175036);
    return localAppBrandMenuHeader;
  }
  
  public void Eq()
  {
    AppMethodBeat.i(47889);
    a(null);
    super.Eq();
    if (this.mcv != null) {
      this.mcv.release();
    }
    if (this.mcw != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.g localg = this.mcw;
      localg.dismiss();
      if (localg.mUk != null)
      {
        localg.mUk.removeAllViews();
        localg.mUk = null;
      }
    }
    this.mcD = null;
    AppMethodBeat.o(47889);
  }
  
  public void Ev()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().aWT()) {
      bux().setNavHidden(false);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.ab.g.am(this.jxG)) || (ap.n(getRuntime()))) {
        bux().hW(true);
      }
      if ((this.mcz) && (bux() != null) && (!bux().isFullscreenMode())) {
        bux().setNavHidden(this.mcC);
      }
      AppMethodBeat.o(47904);
      return;
      super.Ev();
    }
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.mcy = false;
    this.mcz = false;
    this.mcA = null;
    this.jxG = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    if (aVF() == null) {
      a(((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aVF());
    }
    super.a(paramContext, paramAppBrandRuntime);
    paramContext = this.mcx;
    paramContext.mAppId = paramAppBrandRuntime.mAppId;
    paramContext.jzY = paramAppBrandRuntime;
    bux().setCapsuleHomeButtonLongClickListener(new View.OnLongClickListener()
    {
      private void cI(View paramAnonymousView)
      {
        AppMethodBeat.i(47875);
        if ((ae.j(ae.this) == null) || (ae.j(ae.this).getCount() == 0))
        {
          AppMethodBeat.o(47875);
          return;
        }
        ae.j(ae.this).refresh();
        ae.k(ae.this).showAsDropDown(paramAnonymousView);
        com.tencent.mm.plugin.appbrand.report.h.a(ae.this.getAppId(), ae.this.kuf, 21, "", bt.aQJ(), 1, 0);
        AppMethodBeat.o(47875);
      }
      
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(47874);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (!ae.i(ae.this).getAndSet(true))
        {
          ae.this.bsp();
          if (ae.j(ae.this) != null)
          {
            ae.j(ae.this).setRefreshListener(new AppBrandRecentView.e()
            {
              public final void uP(int paramAnonymous2Int)
              {
                AppMethodBeat.i(47873);
                ae.j(ae.this).setRefreshListener(null);
                ae.8.a(ae.8.this, paramAnonymousView);
                AppMethodBeat.o(47873);
              }
            });
            ae.j(ae.this).refresh();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(47874);
          return true;
          cI(paramAnonymousView);
        }
      }
    });
    bux().setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.appbrand.report.h.a(ae.this.getAppId(), ae.this.kuf, 22, "", bt.aQJ(), 1, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47864);
      }
    });
    if ((paramAppBrandRuntime.jxf) && (((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aWT())) {
      bux().setNavButtonLongClickListener(new ae.6(this));
    }
    this.kqm = new com.tencent.mm.plugin.appbrand.permission.a((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime, this);
    if (ap.n(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.g.a(paramAppBrandRuntime, new ap.1(paramAppBrandRuntime, paramContext));
      if (this.jxG.aXc().Eb())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "decorateActionBarToSinglePageMode");
        if (this.mbV != null)
        {
          paramContext = getContext();
          this.mbV.hW(true);
          this.mbV.setNavResetStyleListener(new b.c()
          {
            public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
            {
              AppMethodBeat.i(221295);
              if (paramAnonymousImageView != null)
              {
                paramAnonymousImageView.clearColorFilter();
                if ((!ae.l(ae.this)) && (!ae.this.getRuntime().Eb())) {
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
                AppMethodBeat.o(221295);
                return;
              }
            }
            
            public final int buX()
            {
              return mTY;
            }
          });
          if ((!isDarkMode()) && (!getRuntime().Eb())) {
            break label326;
          }
        }
      }
    }
    label326:
    for (int i = 2131689500;; i = 2131689493)
    {
      paramContext = com.tencent.mm.svg.a.a.h(paramContext.getResources(), i);
      this.mbV.a(paramContext, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(221296);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ae.this.bA(ae.this.buw());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(221296);
        }
      });
      this.mbV.hK(false);
      this.mbV.bCk();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
      AppMethodBeat.o(47885);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(175037);
    long l;
    if (paramc == null)
    {
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca;
      if ((this.mcG.getContext() == paramc) && (this.mcG == this.jzX))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = bt.HI();
      this.mcG.aw(paramc);
      super.a(this.mcG);
      aw(paramc);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), this.kuf, Boolean.valueOf(isRunning()), Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.jzX) != 0)
    {
      l = bt.HI();
      super.a(paramc);
      if ((getRuntime() != null) && (com.tencent.mm.sdk.f.a.jq(getRuntime().mContext) != null)) {
        aw(com.tencent.mm.sdk.f.a.jq(getRuntime().mContext));
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.jzX, paramc, getAppId(), this.kuf, Long.valueOf(bt.aO(l)), Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aXe()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.Eo();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  protected final void aw(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.aw(paramContext);
    if (this.lYc != null) {
      this.lYc.aw(paramContext);
    }
    com.tencent.mm.plugin.appbrand.jsapi.ab.a locala = buV();
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
      locala.hJc.aw(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  protected final void bA(List<q> paramList)
  {
    AppMethodBeat.i(47905);
    this.mcD = new t(this, paramList);
    this.mcD.aYr();
    AppMethodBeat.o(47905);
  }
  
  protected void bsp()
  {
    AppMethodBeat.i(47890);
    com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    if (getRuntime().aWT())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.mcv = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(getContext(), d.b.nou, new com.tencent.mm.plugin.appbrand.widget.recentview.d.a()
      {
        public final LocalUsageInfo buY()
        {
          AppMethodBeat.i(47877);
          if (!ae.this.isRunning())
          {
            AppMethodBeat.o(47877);
            return null;
          }
          LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(ae.this.getRuntime().aXc().username, ae.this.getRuntime().aXb().appId, ae.this.getRuntime().aXb().jYh.jIU, ae.this.getRuntime().aXb().jYh.pkgVersion, ae.this.getRuntime().aXb().doD, ae.this.getRuntime().aXb().cmD, ae.this.getRuntime().aXb().iAa, ae.this.getRuntime().aXb().cnh);
          AppMethodBeat.o(47877);
          return localLocalUsageInfo;
        }
      });
      if (this.mcv == null)
      {
        AppMethodBeat.o(47890);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localException, "appId[%s]", new Object[] { getAppId() });
      }
      this.mcw = new com.tencent.mm.plugin.appbrand.widget.actionbar.g(getContext());
      this.mcw.setWidth(-1);
      this.mcw.setBackgroundDrawable(new ColorDrawable());
      this.mcv.refresh();
      this.mcw.setHeight(this.mcv.getLayoutParams().height);
      this.mcv.setBackground(com.tencent.mm.cc.a.l(getContext(), 2131230981));
      this.mcw.setContentView(this.mcv);
      this.mcv.setOnItemClickListener(new AppBrandRecentView.b()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(47879);
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47878);
              ae.k(ae.this).dismiss();
              AppMethodBeat.o(47878);
            }
          }, 100L);
          if (paramAnonymousa.type == 1)
          {
            paramAnonymousView = paramAnonymousa.mXW;
            paramAnonymousa = new AppBrandStatObject();
            paramAnonymousa.scene = 1090;
            paramAnonymousa.dkh = ae.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.e.f.lNC.a(ae.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.hQh, -1, paramAnonymousa, null, null);
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
  
  public final void buB()
  {
    AppMethodBeat.i(47891);
    super.buB();
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().cpr.a(this, c.a.class);
    boolean bool1;
    if ((!((a.d)localObject).jWf) || (!bool2))
    {
      bool1 = true;
      super.bt(bool1);
      if ((bool2) && (((a.d)localObject).jWf) && (getRuntime().aXc().cmr == 7) && (!bux().isFullscreenMode())) {
        break label189;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((a.d)localObject).jWf + " appServiceType:" + getRuntime().aXc().cmr + " isFullscreenMode:" + bux().isFullscreenMode());
    }
    for (;;)
    {
      if (!ap.n(getRuntime())) {
        break label228;
      }
      runOnUiThread(new ae.4(this));
      AppMethodBeat.o(47891);
      return;
      bool1 = false;
      break;
      label189:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((a.d)localObject).jWe, new ae.12(this));
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).a(new ae.13(this));
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).bFL();
    }
    label228:
    if (com.tencent.mm.plugin.appbrand.ab.g.am(getRuntime()))
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180330);
          if (ae.this.mbV != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
            ae.this.mbV.setNavResetStyleListener(new ae.5.1(this));
            ae.this.mbV.setFullscreenMode(true);
            ae.this.mbV.setForegroundStyle(false);
            ae.this.mbV.hK(false);
            ae.this.mbV.hW(true);
            ae.this.mbV.setBackButtonClickListener(new ae.5.2(this));
          }
          if (ae.this.mbU != null) {
            ae.this.mbU.setForceTopInsetsHeight(ae.this.getContext().getResources().getDimensionPixelSize(2131165880));
          }
          ae.z(ae.this);
          AppMethodBeat.o(180330);
        }
      });
      AppMethodBeat.o(47891);
      return;
    }
    if ((getRuntime() != null) && (getRuntime().aWT())) {
      bux().setNavHidden(false);
    }
    AppMethodBeat.o(47891);
  }
  
  protected final void buD()
  {
    AppMethodBeat.i(47899);
    super.buD();
    Object localObject = this.mcx;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).mss = (bt.flT() - ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).msr);
    if (aVF().compareTo(getRuntime().aVF()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), aVF().aZn(), getRuntime().aVF().aZn() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void buE()
  {
    AppMethodBeat.i(47900);
    super.buE();
    if (getRuntime().Eb())
    {
      com.tencent.mm.plugin.appbrand.report.g localg = this.mcx;
      if (getRuntime().jwV) {}
      for (String str = getRuntime().aVW();; str = getRuntime().aXd().getCurrentUrl())
      {
        localg.Ug(str);
        AppMethodBeat.o(47900);
        return;
      }
    }
    this.mcx.onForeground();
    AppMethodBeat.o(47900);
  }
  
  protected final void buF()
  {
    AppMethodBeat.i(47901);
    super.buF();
    if (this.mcw != null) {
      this.mcw.dismiss();
    }
    this.mcx.onBackground();
    AppMethodBeat.o(47901);
  }
  
  public final boolean buG()
  {
    AppMethodBeat.i(47895);
    if (this.mcy)
    {
      AppMethodBeat.o(47895);
      return true;
    }
    boolean bool = super.buG();
    AppMethodBeat.o(47895);
    return bool;
  }
  
  protected final void buH()
  {
    AppMethodBeat.i(47902);
    super.buH();
    this.mcx.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View buL()
  {
    AppMethodBeat.i(47893);
    if (com.tencent.mm.plugin.appbrand.ad.d.d(this))
    {
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.b();
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).source = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).type = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.Eo());
      localObject = new AppBrandMenuFooter(getContext());
      ((AppBrandMenuFooter)localObject).setPageView(this);
      ((AppBrandMenuFooter)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47880);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.appbrand.ad.d.c(ae.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47880);
        }
      });
      AppMethodBeat.o(47893);
      return localObject;
    }
    Object localObject = super.buL();
    AppMethodBeat.o(47893);
    return localObject;
  }
  
  public final Bitmap buN()
  {
    AppMethodBeat.i(188696);
    Object localObject1 = (com.tencent.luggage.game.page.d)Q(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.buN();
      AppMethodBeat.o(188696);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).getMagicBrushView().getMagicBrush().cwN.h(((com.tencent.luggage.game.page.d)localObject1).getMagicBrushView().getVirtualElementId(), -1, true);
      AppMethodBeat.o(188696);
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localNullPointerException, "hy: exception in get snapshot", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  public final ak buR()
  {
    AppMethodBeat.i(47903);
    if ((buq() instanceof ad))
    {
      ak localak = ((ad)buq()).buR();
      AppMethodBeat.o(47903);
      return localak;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.g buT()
  {
    return this.mcx;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.ab.a buV()
  {
    AppMethodBeat.i(47896);
    try
    {
      Object localObject = this.kca.findViewById(2131296782);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.ab.a))
      {
        localObject = (com.tencent.mm.plugin.appbrand.jsapi.ab.a)localObject;
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
  
  public final void buW()
  {
    AppMethodBeat.i(47906);
    if ((this.jCB == null) || (this.jCB.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.kuf });
      AppMethodBeat.o(47906);
      return;
    }
    bA(this.jCB);
    AppMethodBeat.o(47906);
  }
  
  public final List<q> buv()
  {
    AppMethodBeat.i(47897);
    if (ap.n(getRuntime()))
    {
      bool = getRuntime().Eb();
      localLinkedList = new LinkedList();
      WxaMenuHelper.a(localLinkedList, r.lSK.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, r.lSL.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, r.lTj.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, r.lTk.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, r.lSU.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTf.ordinal(), false, false);
      if (bool) {
        WxaMenuHelper.a(localLinkedList, r.lTg.ordinal(), false, false);
      }
      this.jCB = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, r.lSK.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, r.lSL.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, r.lTj.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, r.lST.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.a.Kk((String)localObject);
    if ((!com.tencent.mm.sdk.a.b.fjN()) && ((localObject == null) || (((k)localObject).jYh.jIU == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, r.lSS.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, r.lTk.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, r.lSI.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTd.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTe.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lSR.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTf.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTi.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTg.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, r.lTh.ordinal(), false, false);
      this.jCB = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.Fnj));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFQ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFX(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFT(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGd(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGa(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFW(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFV(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGb()));
    c(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFS()));
    AppMethodBeat.o(47907);
  }
  
  public final boolean dk(String paramString)
  {
    AppMethodBeat.i(47898);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL");
    com.tencent.mm.plugin.appbrand.report.g localg = this.mcx;
    localg.msr = bt.flT();
    localg.msq = paramString;
    a(getRuntime().getWindowAndroid());
    boolean bool = super.dk(paramString);
    AppMethodBeat.o(47898);
    return bool;
  }
  
  protected final void g(TextView paramTextView)
  {
    AppMethodBeat.i(47908);
    Object localObject = this.mbZ;
    if ((paramTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localObject = new a.1(this);
      Drawable localDrawable = com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131689598);
      paramTextView.setCompoundDrawablePadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 4));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramTextView.setOnClickListener((View.OnClickListener)localObject);
    }
    AppMethodBeat.o(47908);
  }
  
  public com.tencent.mm.plugin.appbrand.o getRuntime()
  {
    AppMethodBeat.i(47887);
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.En();
    AppMethodBeat.o(47887);
    return localo;
  }
  
  public void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(47894);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "setHideHomeButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((com.tencent.mm.plugin.appbrand.ab.g.am(getRuntime())) || (ap.n(getRuntime())))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, weishi app");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.mbV == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, ActionBar hasn't init");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.mbV.isFullscreenMode())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, is in fullscreen mode now");
      AppMethodBeat.o(47894);
      return;
    }
    this.mcC = paramBoolean;
    if (this.mcA != null) {
      this.mcC = ((Boolean)this.mcA.value).booleanValue();
    }
    if (!this.mcz)
    {
      if (this.mbV != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "not homepage enter customActionBar");
        this.mbV.setNavResetStyleListener(new ae.14(this));
        this.mbV.setBackButtonClickListener(new ae.15(this));
        this.mbV.bCk();
        this.mcy = true;
      }
      if (this.jxG == null)
      {
        str = "";
        com.tencent.mm.plugin.appbrand.report.h.F(str, this.kuf, 1);
        this.mcz = true;
      }
    }
    else
    {
      bux().setNavHidden(this.mcC);
      if ((this.mcC) && (this.lYc != null)) {
        if (this.jxG != null) {
          break label293;
        }
      }
    }
    label293:
    for (String str = "";; str = this.jxG.mAppId)
    {
      com.tencent.mm.plugin.appbrand.report.h.F(str, this.kuf, 2);
      AppMethodBeat.o(47894);
      return;
      str = this.jxG.mAppId;
      break;
    }
  }
  
  protected final View j(ViewGroup paramViewGroup)
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(180347);
    if ((this.jxG == null) || (!ap.n(this.jxG)) || (!(paramViewGroup instanceof RelativeLayout)))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.mcE == null) {
      this.mcE = new aj(getContext());
    }
    Object localObject1 = this.mcE;
    Object localObject2 = this.jxG.aXc().iconUrl;
    String str1 = this.jxG.aXc().doD;
    String str2 = e.rP(this.jxG.aXb().jYh.jIU);
    boolean bool = this.jxG.aXc().Eb();
    int j;
    if (this.jxG.aXc().originalFlag == 1)
    {
      com.tencent.mm.modelappbrand.a.b.aDV().a(((aj)localObject1).kAX, (String)localObject2, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
      localObject2 = ((aj)localObject1).mdp;
      if (!bool) {
        break label310;
      }
      j = 2131759360;
      label175:
      ((Button)localObject2).setText(j);
      ((aj)localObject1).kAY.setText(str1);
      if (!bt.isNullOrNil(str2)) {
        break label323;
      }
      ((aj)localObject1).mdo.setVisibility(8);
      localObject1 = ((aj)localObject1).mdq;
      if (i == 0) {
        break label317;
      }
      i = k;
      label223:
      ((ImageView)localObject1).setVisibility(i);
    }
    for (;;)
    {
      this.mcE.setJumpBtnOnClickListener(new ae.7(this));
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (-getContext().getResources().getDimensionPixelSize(2131165852));
      paramViewGroup.addView(this.mcE, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup = this.mcE;
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
      ((aj)localObject1).mdo.setText(str2);
      ((aj)localObject1).mdo.setVisibility(0);
      ((aj)localObject1).mdq.setVisibility(8);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.jxG != null) && (ap.n(this.jxG)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.g.a(getAppId(), g.d.jwm);
      this.jxG.close();
      AppMethodBeat.o(180348);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(180348);
    return bool;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180350);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(180350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae
 * JD-Core Version:    0.7.0.1
 */