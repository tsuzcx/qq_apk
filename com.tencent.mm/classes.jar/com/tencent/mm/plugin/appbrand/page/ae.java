package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.ao.1;
import com.tencent.mm.plugin.appbrand.ao.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.backgroundrunning.a.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ah;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ae
  extends com.tencent.luggage.sdk.b.a.c
{
  private com.tencent.mm.plugin.appbrand.o jez;
  private List<com.tencent.mm.plugin.appbrand.menu.p> jiT;
  private AppBrandRecentView lCT;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.g lCU;
  public final com.tencent.mm.plugin.appbrand.report.f lCV;
  private boolean lCW;
  public boolean lCX;
  public com.tencent.mm.plugin.appbrand.z.i<Boolean> lCY;
  private final AtomicBoolean lCZ;
  public volatile boolean lDa;
  private t lDb;
  public aj lDc;
  private Boolean lDd;
  private final com.tencent.mm.plugin.appbrand.r.a.a.o lDe;
  
  public ae()
  {
    this(ad.class);
  }
  
  public ae(Class<? extends ac> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.lCV = new com.tencent.mm.plugin.appbrand.report.f(aUT());
    this.lCZ = new AtomicBoolean(false);
    this.lDa = false;
    this.lDe = new com.tencent.mm.plugin.appbrand.r.a.a.o();
    if ((bt.eWo()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.jdX = bool;
    AppMethodBeat.o(47884);
  }
  
  private boolean DT()
  {
    AppMethodBeat.i(180349);
    if (this.lDd == null) {
      this.lDd = Boolean.valueOf(com.tencent.mm.ui.aj.DT());
    }
    boolean bool = this.lDd.booleanValue();
    AppMethodBeat.o(180349);
    return bool;
  }
  
  public final View CQ()
  {
    AppMethodBeat.i(175036);
    if (ao.w(getRuntime()))
    {
      AppMethodBeat.o(175036);
      return null;
    }
    AppBrandMenuHeader localAppBrandMenuHeader = new AppBrandMenuHeader(getContext());
    localAppBrandMenuHeader.setPage(this);
    AppMethodBeat.o(175036);
    return localAppBrandMenuHeader;
  }
  
  public void CR()
  {
    AppMethodBeat.i(47889);
    a(null);
    super.CR();
    if (this.lCT != null) {
      this.lCT.release();
    }
    if (this.lCU != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.g localg = this.lCU;
      localg.dismiss();
      if (localg.mtE != null)
      {
        localg.mtE.removeAllViews();
        localg.mtE = null;
      }
    }
    this.lDb = null;
    AppMethodBeat.o(47889);
  }
  
  public final void CW()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().aTJ()) {
      bqy().setNavHidden(false);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.ab.g.as(this.jez)) || (ao.w(getRuntime()))) {
        bqy().hM(true);
      }
      if ((this.lCX) && (bqy() != null) && (!bqy().isFullscreenMode())) {
        bqy().setNavHidden(this.lDa);
      }
      AppMethodBeat.o(47904);
      return;
      super.CW();
    }
  }
  
  public final void Dk()
  {
    AppMethodBeat.i(186903);
    super.Dk();
    if (z.f(this))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.d.mQM) {
        break label183;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsruntime.i locali = aUV();
      int i = aUT();
      com.tencent.mm.sdk.platformtools.ac.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(i), getAppId(), Log.getStackTraceString(new Throwable()) });
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + i + "')", null);
      locali.evaluateJavascript("xweb.enableNativeTrans()", null);
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + i + "')", null);
      z.a(aUV(), aUT(), getAppId());
      AppMethodBeat.o(186903);
      return;
      label183:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      ah.Cc(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.d.mQM = true;
    }
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.lCW = false;
    this.lCX = false;
    this.lCY = null;
    this.jez = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    if (aSt() == null) {
      a(((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aSt());
    }
    super.a(paramContext, paramAppBrandRuntime);
    paramContext = this.lCV;
    paramContext.mAppId = paramAppBrandRuntime.mAppId;
    paramContext.jgY = paramAppBrandRuntime;
    bqy().setCapsuleHomeButtonLongClickListener(new View.OnLongClickListener()
    {
      private void cG(View paramAnonymousView)
      {
        AppMethodBeat.i(47875);
        if ((ae.j(ae.this) == null) || (ae.j(ae.this).getCount() == 0))
        {
          AppMethodBeat.o(47875);
          return;
        }
        ae.j(ae.this).refresh();
        ae.k(ae.this).showAsDropDown(paramAnonymousView);
        com.tencent.mm.plugin.appbrand.report.g.a(ae.this.getAppId(), ae.this.jZJ, 21, "", bs.aNx(), 1, 0);
        AppMethodBeat.o(47875);
      }
      
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(47874);
        if (!ae.i(ae.this).getAndSet(true))
        {
          ae.this.box();
          if (ae.j(ae.this) != null)
          {
            ae.j(ae.this).setRefreshListener(new AppBrandRecentView.e()
            {
              public final void ul(int paramAnonymous2Int)
              {
                AppMethodBeat.i(47873);
                ae.j(ae.this).setRefreshListener(null);
                ae.10.a(ae.10.this, paramAnonymousView);
                AppMethodBeat.o(47873);
              }
            });
            ae.j(ae.this).refresh();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(47874);
          return true;
          cG(paramAnonymousView);
        }
      }
    });
    bqy().setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47864);
        com.tencent.mm.plugin.appbrand.report.g.a(ae.this.getAppId(), ae.this.jZJ, 22, "", bs.aNx(), 1, 0);
        AppMethodBeat.o(47864);
      }
    });
    if ((paramAppBrandRuntime.jdX) && (((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aTJ())) {
      bqy().setNavButtonLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47871);
          ae.this.bqV();
          AppMethodBeat.o(47871);
          return true;
        }
      });
    }
    this.jVY = new com.tencent.mm.plugin.appbrand.permission.a((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime, this);
    if (ao.w(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.g.a(paramAppBrandRuntime, new ao.1(paramAppBrandRuntime, paramContext));
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "decorateActionBarToSinglePageMode");
      if (this.lCu != null)
      {
        paramContext = getContext();
        this.lCu.hM(true);
        this.lCu.setNavResetStyleListener(new b.c()
        {
          public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
          {
            AppMethodBeat.i(186892);
            if (paramAnonymousImageView != null)
            {
              paramAnonymousImageView.clearColorFilter();
              if ((!ae.l(ae.this)) && (!ae.this.getRuntime().CC())) {
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
              AppMethodBeat.o(186892);
              return;
            }
          }
          
          public final int bqW()
          {
            return mts;
          }
        });
        if ((!DT()) && (!getRuntime().CC())) {
          break label313;
        }
      }
    }
    label313:
    for (int i = 2131689500;; i = 2131689493)
    {
      paramContext = com.tencent.mm.svg.a.a.h(paramContext.getResources(), i);
      this.lCu.a(paramContext, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186893);
          ae.this.by(ae.this.bqx());
          AppMethodBeat.o(186893);
        }
      });
      this.lCu.hA(false);
      this.lCu.bye();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
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
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ca;
      if ((this.lDe.getContext() == paramc) && (this.lDe == this.jgX))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = bs.Gn();
      this.lDe.aw(paramc);
      super.a(this.lDe);
      aw(paramc);
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), this.jZJ, Boolean.valueOf(isRunning()), Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.jgX) != 0)
    {
      l = bs.Gn();
      super.a(paramc);
      if ((getRuntime() != null) && (com.tencent.mm.sdk.f.a.jg(getRuntime().mContext) != null)) {
        aw(com.tencent.mm.sdk.f.a.jg(getRuntime().mContext));
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.jgX, paramc, getAppId(), this.jZJ, Long.valueOf(bs.aO(l)), Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aTU()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.CP();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  protected final void aw(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.aw(paramContext);
    if (this.lyE != null) {
      this.lyE.aw(paramContext);
    }
    com.tencent.mm.plugin.appbrand.jsapi.y.a locala = bqU();
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
      locala.hqK.aw(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  protected void box()
  {
    AppMethodBeat.i(47890);
    com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    if (getRuntime().aTJ())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.lCT = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(getContext(), d.b.mNX, new d.a()
      {
        public final LocalUsageInfo bqX()
        {
          AppMethodBeat.i(47877);
          if (!ae.this.isRunning())
          {
            AppMethodBeat.o(47877);
            return null;
          }
          LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(ae.this.getRuntime().aTS().username, ae.this.getRuntime().aTR().appId, ae.this.getRuntime().aTR().jEg.jpa, ae.this.getRuntime().aTR().jEg.pkgVersion, ae.this.getRuntime().aTR().ddh, ae.this.getRuntime().aTR().ccm, ae.this.getRuntime().aTR().igG, false, ae.this.getRuntime().aTR().ccQ, 0L);
          AppMethodBeat.o(47877);
          return localLocalUsageInfo;
        }
      });
      if (this.lCT == null)
      {
        AppMethodBeat.o(47890);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localException, "appId[%s]", new Object[] { getAppId() });
      }
      this.lCU = new com.tencent.mm.plugin.appbrand.widget.actionbar.g(getContext());
      this.lCU.setWidth(-1);
      this.lCU.setBackgroundDrawable(new ColorDrawable());
      this.lCT.refresh();
      this.lCU.setHeight(this.lCT.getLayoutParams().height);
      this.lCT.setBackground(com.tencent.mm.cc.a.l(getContext(), 2131230981));
      this.lCU.setContentView(this.lCT);
      this.lCT.setOnItemClickListener(new AppBrandRecentView.b()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(47879);
          ap.n(new Runnable()
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
            paramAnonymousView = paramAnonymousa.mxs;
            paramAnonymousa = new AppBrandStatObject();
            paramAnonymousa.scene = 1090;
            paramAnonymousa.cYP = ae.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.e.f.lqh.a(ae.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.hxM, -1, paramAnonymousa, null, null);
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
  
  public final void bqB()
  {
    AppMethodBeat.i(47891);
    super.bqB();
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().cfa.a(this, new c.a());
    boolean bool1;
    if ((!((a.d)localObject).jCj) || (!bool2))
    {
      bool1 = true;
      super.bs(bool1);
      if ((bool2) && (((a.d)localObject).jCj) && (getRuntime().aTS().cca == 7) && (!bqy().isFullscreenMode())) {
        break label193;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((a.d)localObject).jCj + " appServiceType:" + getRuntime().aTS().cca + " isFullscreenMode:" + bqy().isFullscreenMode());
    }
    for (;;)
    {
      if (!ao.w(getRuntime())) {
        break label232;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186894);
          ae.this.LB(ae.this.getRuntime().aTS().jjq);
          if (!"squeezed".equals(ae.m(ae.this))) {}
          for (boolean bool = true;; bool = false)
          {
            ae.this.gX(bool);
            ae.this.lCu.hA(false);
            ae.this.lCu.setFullscreenMode(false);
            ae.this.lCu.hM(true);
            if (!ae.l(ae.this)) {
              break;
            }
            ae.this.lCu.setForegroundStyle(false);
            ae.this.lCu.vn(ae.this.getContext().getResources().getColor(2131099967));
            AppMethodBeat.o(186894);
            return;
          }
          ae.this.lCu.setForegroundStyle(true);
          ae.this.lCu.vn(ae.this.getContext().getResources().getColor(2131099968));
          AppMethodBeat.o(186894);
        }
      });
      AppMethodBeat.o(47891);
      return;
      bool1 = false;
      break;
      label193:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((a.d)localObject).jCi, new com.tencent.mm.plugin.appbrand.widget.tabbar.c()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(47881);
          super.a(paramAnonymousString, paramAnonymousd);
          com.tencent.mm.sdk.platformtools.ac.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(47881);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).a(new com.tencent.mm.plugin.appbrand.widget.tabbar.e()
      {
        public final void a(Bitmap paramAnonymousBitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(47883);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          ae.this.bqy().a(paramAnonymousBitmap, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(47882);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
              com.tencent.mm.plugin.appbrand.page.d.d.h(ae.this);
              AppMethodBeat.o(47882);
            }
          });
          AppMethodBeat.o(47883);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).bBJ();
    }
    label232:
    if (com.tencent.mm.plugin.appbrand.ab.g.as(getRuntime())) {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180330);
          if (ae.this.lCu != null)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
            ae.this.lCu.setNavResetStyleListener(new b.c()
            {
              public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
              {
                AppMethodBeat.i(186895);
                if (paramAnonymous2ImageView != null)
                {
                  paramAnonymous2ImageView.clearColorFilter();
                  paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(ae.this.getContext().getResources(), 2131689682));
                  paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                  paramAnonymous2View2.height = -1;
                  paramAnonymous2View2.width = -2;
                  paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                }
                if (paramAnonymous2View1 != null) {
                  paramAnonymous2View1.setBackground(null);
                }
                AppMethodBeat.o(186895);
              }
              
              public final int bqW()
              {
                return mts;
              }
            });
            ae.this.lCu.setFullscreenMode(true);
            ae.this.lCu.setForegroundStyle(false);
            ae.this.lCu.hA(false);
            ae.this.lCu.hM(true);
            ae.this.lCu.setBackButtonClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(186896);
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
                com.tencent.mm.plugin.appbrand.ab.g.bxO();
                if (ae.h(ae.this) != null)
                {
                  com.tencent.mm.plugin.appbrand.g.a(ae.this.getAppId(), g.d.jdc);
                  ae.h(ae.this).close();
                }
                AppMethodBeat.o(186896);
              }
            });
          }
          if (ae.this.lCt != null) {
            ae.this.lCt.setForceTopInsetsHeight(ae.this.getContext().getResources().getDimensionPixelSize(2131165880));
          }
          ae.n(ae.this);
          AppMethodBeat.o(180330);
        }
      });
    }
    AppMethodBeat.o(47891);
  }
  
  protected final void bqD()
  {
    AppMethodBeat.i(47899);
    super.bqD();
    Object localObject = this.lCV;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).lSB = (bs.eWj() - ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).lSA);
    if (aSt().compareTo(getRuntime().aSt()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), aSt().aVS(), getRuntime().aSt().aVS() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void bqE()
  {
    AppMethodBeat.i(47900);
    super.bqE();
    if (getRuntime().CC())
    {
      com.tencent.mm.plugin.appbrand.report.f localf = this.lCV;
      if (getRuntime().jdN) {}
      for (String str = getRuntime().aSI();; str = getRuntime().aTT().getCurrentUrl())
      {
        localf.QA(str);
        AppMethodBeat.o(47900);
        return;
      }
    }
    this.lCV.onForeground();
    AppMethodBeat.o(47900);
  }
  
  protected final void bqF()
  {
    AppMethodBeat.i(47901);
    super.bqF();
    if (this.lCU != null) {
      this.lCU.dismiss();
    }
    this.lCV.onBackground();
    AppMethodBeat.o(47901);
  }
  
  public final boolean bqG()
  {
    AppMethodBeat.i(47895);
    if (this.lCW)
    {
      AppMethodBeat.o(47895);
      return true;
    }
    boolean bool = super.bqG();
    AppMethodBeat.o(47895);
    return bool;
  }
  
  protected final void bqH()
  {
    AppMethodBeat.i(47902);
    super.bqH();
    this.lCV.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View bqL()
  {
    AppMethodBeat.i(47893);
    if (com.tencent.mm.plugin.appbrand.ad.d.d(this))
    {
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.b();
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).source = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).type = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.CP());
      localObject = new AppBrandMenuFooter(getContext());
      ((AppBrandMenuFooter)localObject).setPageView(this);
      ((AppBrandMenuFooter)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47880);
          com.tencent.mm.plugin.appbrand.ad.d.c(ae.this);
          AppMethodBeat.o(47880);
        }
      });
      AppMethodBeat.o(47893);
      return localObject;
    }
    Object localObject = super.bqL();
    AppMethodBeat.o(47893);
    return localObject;
  }
  
  public final Bitmap bqN()
  {
    AppMethodBeat.i(186902);
    Object localObject1 = (com.tencent.luggage.game.page.d)Q(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.bqN();
      AppMethodBeat.o(186902);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).BR().getMagicBrush().cml.h(((com.tencent.luggage.game.page.d)localObject1).BR().getVirtualElementId(), -1, true);
      AppMethodBeat.o(186902);
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localNullPointerException, "hy: exception in get snapshot", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  public final ak bqR()
  {
    AppMethodBeat.i(47903);
    if ((bqr() instanceof ad))
    {
      ak localak = ((ad)bqr()).bqR();
      AppMethodBeat.o(47903);
      return localak;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.f bqT()
  {
    return this.lCV;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.y.a bqU()
  {
    AppMethodBeat.i(47896);
    try
    {
      Object localObject = this.jHO.findViewById(2131296782);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.y.a))
      {
        localObject = (com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject;
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
  
  public final void bqV()
  {
    AppMethodBeat.i(47906);
    if ((this.jiT == null) || (this.jiT.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.jZJ });
      AppMethodBeat.o(47906);
      return;
    }
    by(this.jiT);
    AppMethodBeat.o(47906);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.p> bqw()
  {
    AppMethodBeat.i(47897);
    if (ao.w(getRuntime()))
    {
      bool = getRuntime().CC();
      localLinkedList = new LinkedList();
      WxaMenuHelper.a(localLinkedList, q.ltB.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, q.ltC.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, q.lua.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, q.ltL.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltW.ordinal(), false, false);
      if (bool) {
        WxaMenuHelper.a(localLinkedList, q.ltX.ordinal(), false, false);
      }
      this.jiT = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, q.ltB.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, q.ltC.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, q.lua.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, q.ltK.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.a.GV((String)localObject);
    if ((!com.tencent.mm.sdk.a.b.eUk()) && ((localObject == null) || (((k)localObject).jEg.jpa == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, q.ltJ.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, q.ltz.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltU.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltV.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltI.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltW.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltZ.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltX.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.ltY.ordinal(), false, false);
      this.jiT = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  protected final void by(List<com.tencent.mm.plugin.appbrand.menu.p> paramList)
  {
    AppMethodBeat.i(47905);
    this.lDb = new t(this, paramList);
    this.lDb.aUX();
    AppMethodBeat.o(47905);
  }
  
  public final boolean ci(String paramString)
  {
    AppMethodBeat.i(47898);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL");
    com.tencent.mm.plugin.appbrand.report.f localf = this.lCV;
    localf.lSA = bs.eWj();
    localf.lSz = paramString;
    a(getRuntime().getWindowAndroid());
    boolean bool = super.ci(paramString);
    AppMethodBeat.o(47898);
    return bool;
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.DIc));
    com.tencent.mm.plugin.appbrand.i.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBN(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBT(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBP(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBW(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBS(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBR(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBX()));
    AppMethodBeat.o(47907);
  }
  
  protected final void g(TextView paramTextView)
  {
    AppMethodBeat.i(47908);
    Object localObject = this.lCy;
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
  
  public final void gY(boolean paramBoolean)
  {
    AppMethodBeat.i(47894);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "setHideHomeButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((com.tencent.mm.plugin.appbrand.ab.g.as(getRuntime())) || (ao.w(getRuntime())))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, weishi app");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.lCu == null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, ActionBar hasn't init");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.lCu.isFullscreenMode())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, is in fullscreen mode now");
      AppMethodBeat.o(47894);
      return;
    }
    this.lDa = paramBoolean;
    if (this.lCY != null) {
      this.lDa = ((Boolean)this.lCY.value).booleanValue();
    }
    if (!this.lCX)
    {
      if (this.lCu != null)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "not homepage enter customActionBar");
        this.lCu.setNavResetStyleListener(new b.c()
        {
          public final void a(ImageView paramAnonymousImageView, final View paramAnonymousView1, View paramAnonymousView2)
          {
            AppMethodBeat.i(186898);
            if (paramAnonymousImageView != null)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAnonymousImageView.getLayoutParams();
              i = ae.this.getContext().getResources().getDimensionPixelOffset(2131165746);
              localLayoutParams.height = i;
              localLayoutParams.width = i;
              localLayoutParams.gravity = 17;
              paramAnonymousImageView.setLayoutParams(localLayoutParams);
              localLayoutParams.leftMargin = 0;
              localLayoutParams.rightMargin = 0;
              paramAnonymousImageView.clearColorFilter();
              paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(ae.this.getContext().getResources(), 2131689590));
              paramAnonymousImageView.setColorFilter(ae.this.lCu.getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
              paramAnonymousImageView.setBackgroundResource(2131230957);
              i = ae.this.getContext().getResources().getDimensionPixelOffset(2131165568);
              paramAnonymousImageView.setPadding(i, paramAnonymousImageView.getPaddingTop(), i, paramAnonymousImageView.getPaddingBottom());
            }
            if (paramAnonymousView1 != null)
            {
              paramAnonymousImageView = (LinearLayout.LayoutParams)paramAnonymousView1.getLayoutParams();
              i = ae.this.getContext().getResources().getDimensionPixelOffset(2131165743);
              paramAnonymousImageView.height = i;
              paramAnonymousImageView.width = i;
              paramAnonymousImageView.gravity = 17;
              paramAnonymousImageView.leftMargin = ae.this.getContext().getResources().getDimensionPixelOffset(2131165744);
              paramAnonymousImageView.rightMargin = ae.this.getContext().getResources().getDimensionPixelOffset(2131165745);
              paramAnonymousView1.setLayoutParams(paramAnonymousImageView);
              if (ae.this.lCu.getForegroundColor() != -1) {
                break label290;
              }
            }
            label290:
            for (int i = 2131230978;; i = 2131230979)
            {
              paramAnonymousView1.setBackgroundResource(i);
              if (paramAnonymousView2 != null) {
                paramAnonymousView2.setOnTouchListener(new View.OnTouchListener()
                {
                  public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
                  {
                    AppMethodBeat.i(186897);
                    if (paramAnonymousView1 != null)
                    {
                      paramAnonymousView1.onTouchEvent(paramAnonymous2MotionEvent);
                      AppMethodBeat.o(186897);
                      return true;
                    }
                    AppMethodBeat.o(186897);
                    return false;
                  }
                });
              }
              AppMethodBeat.o(186898);
              return;
            }
          }
          
          public final int bqW()
          {
            return 2131165744;
          }
        });
        this.lCu.setBackButtonClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186899);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
            if (ae.this.bqy().byg())
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "pageview click close button, but nav area is hidden");
              AppMethodBeat.o(186899);
              return;
            }
            if (ae.h(ae.this) != null) {
              ae.h(ae.this).aTT().bqg();
            }
            if ((ae.this.lyE != null) && (ae.h(ae.this) != null)) {
              com.tencent.mm.plugin.appbrand.report.g.E(ae.h(ae.this).mAppId, ae.this.jZJ, 3);
            }
            AppMethodBeat.o(186899);
          }
        });
        this.lCu.bye();
        this.lCW = true;
      }
      if (this.jez == null)
      {
        str = "";
        com.tencent.mm.plugin.appbrand.report.g.E(str, this.jZJ, 1);
        this.lCX = true;
      }
    }
    else
    {
      bqy().setNavHidden(this.lDa);
      if ((this.lDa) && (this.lyE != null)) {
        if (this.jez != null) {
          break label293;
        }
      }
    }
    label293:
    for (String str = "";; str = this.jez.mAppId)
    {
      com.tencent.mm.plugin.appbrand.report.g.E(str, this.jZJ, 2);
      AppMethodBeat.o(47894);
      return;
      str = this.jez.mAppId;
      break;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.o getRuntime()
  {
    AppMethodBeat.i(47887);
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.CO();
    AppMethodBeat.o(47887);
    return localo;
  }
  
  protected final View j(ViewGroup paramViewGroup)
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(180347);
    if ((this.jez == null) || (!ao.w(this.jez)) || (!(paramViewGroup instanceof RelativeLayout)))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.lDc == null) {
      this.lDc = new aj(getContext());
    }
    Object localObject1 = this.lDc;
    Object localObject2 = this.jez.aTS().iconUrl;
    String str1 = this.jez.aTS().ddh;
    String str2 = com.tencent.mm.plugin.appbrand.appcache.e.rp(this.jez.aTR().jEg.jpa);
    boolean bool = this.jez.aTS().CC();
    int j;
    if (this.jez.aTS().originalFlag == 1)
    {
      com.tencent.mm.modelappbrand.a.b.aAS().a(((aj)localObject1).kgj, (String)localObject2, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
      localObject2 = ((aj)localObject1).lDM;
      if (!bool) {
        break label310;
      }
      j = 2131759360;
      label175:
      ((Button)localObject2).setText(j);
      ((aj)localObject1).kgk.setText(str1);
      if (!bs.isNullOrNil(str2)) {
        break label323;
      }
      ((aj)localObject1).lDL.setVisibility(8);
      localObject1 = ((aj)localObject1).lDN;
      if (i == 0) {
        break label317;
      }
      i = k;
      label223:
      ((ImageView)localObject1).setVisibility(i);
    }
    for (;;)
    {
      this.lDc.setJumpBtnOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186900);
          paramAnonymousView = ae.h(ae.this);
          String str = ae.this.lyH;
          ao.a locala = new ao.a();
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("currentPath", str);
          locala.A(localHashMap).g(paramAnonymousView.aTU()).beN();
          AppMethodBeat.o(186900);
        }
      });
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (-getContext().getResources().getDimensionPixelSize(2131165852));
      paramViewGroup.addView(this.lDc, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup = this.lDc;
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
      ((aj)localObject1).lDL.setText(str2);
      ((aj)localObject1).lDL.setVisibility(0);
      ((aj)localObject1).lDN.setVisibility(8);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.jez != null) && (ao.w(this.jez)))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.g.a(getAppId(), g.d.jdd);
      this.jez.close();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae
 * JD-Core Version:    0.7.0.1
 */