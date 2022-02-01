package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mm.plugin.appbrand.bb.1;
import com.tencent.mm.plugin.appbrand.bb.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.config.b.f;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.m.aa;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recent.l.a;
import com.tencent.mm.plugin.appbrand.widget.recent.l.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ah;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import org.json.JSONObject;

public class ag
  extends com.tencent.luggage.sdk.b.a.c
{
  private q kBw;
  private List<t> kHj;
  private AppBrandRecentView nrq;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.f nrr;
  public final com.tencent.mm.plugin.appbrand.report.h nrs;
  private final AtomicBoolean nrt;
  private v nru;
  public al nrv;
  private Boolean nrw;
  private final o nrx;
  
  public ag()
  {
    this(af.class);
  }
  
  public ag(Class<? extends ae> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.nrs = new com.tencent.mm.plugin.appbrand.report.h(getComponentId());
    this.nrt = new AtomicBoolean(false);
    this.nrx = new o();
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.kAU = bool;
    AppMethodBeat.o(47884);
  }
  
  private boolean bRL()
  {
    AppMethodBeat.i(227300);
    String str = getRuntime().getAppConfig().WV(this.lBI).lcC.lck;
    if (Util.isNullOrNil(str))
    {
      boolean bool = isDarkMode();
      AppMethodBeat.o(227300);
      return bool;
    }
    if (!e.a.oms.name().equalsIgnoreCase(str))
    {
      AppMethodBeat.o(227300);
      return true;
    }
    AppMethodBeat.o(227300);
    return false;
  }
  
  private boolean isDarkMode()
  {
    AppMethodBeat.i(180349);
    if (this.nrw == null) {
      this.nrw = Boolean.valueOf(ao.isDarkMode());
    }
    boolean bool = this.nrw.booleanValue();
    AppMethodBeat.o(180349);
    return bool;
  }
  
  public void NR()
  {
    AppMethodBeat.i(47889);
    b(null);
    super.NR();
    if (this.nrq != null) {
      this.nrq.release();
    }
    if (this.nrr != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.f localf = this.nrr;
      localf.dismiss();
      if (localf.omw != null)
      {
        localf.omw.removeAllViews();
        localf.omw = null;
      }
    }
    this.nru = null;
    AppMethodBeat.o(47889);
  }
  
  public void NW()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().bsr()) {
      bRi().setNavHidden(false);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.af.g.an(this.kBw)) || (com.tencent.mm.plugin.appbrand.bb.r(getRuntime()))) {
        bRi().gx(true);
      }
      AppMethodBeat.o(47904);
      return;
      super.NW();
    }
  }
  
  public final void On()
  {
    AppMethodBeat.i(227301);
    super.On();
    if (aa.f(this))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.d.oGJ) {
        break label183;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.m.i locali = getJsRuntime();
      int i = getComponentId();
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(i), getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + i + "')", null);
      locali.evaluateJavascript("xweb.enableNativeTrans()", null);
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + i + "')", null);
      aa.a(getJsRuntime(), getComponentId(), getAppId());
      AppMethodBeat.o(227301);
      return;
      label183:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      ah.ON(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.d.oGJ = true;
    }
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.kBw = ((q)paramAppBrandRuntime);
    if (bqZ() == null) {
      a(((q)paramAppBrandRuntime).bqZ());
    }
    super.a(paramContext, paramAppBrandRuntime);
    paramContext = this.nrs;
    paramContext.mAppId = paramAppBrandRuntime.mAppId;
    paramContext.kEc = paramAppBrandRuntime;
    bRi().setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.appbrand.report.i.a(ag.this.getAppId(), ag.this.lBI, 22, "", Util.nowSecond(), 1, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47864);
      }
    });
    if ((paramAppBrandRuntime.kAU) && (((q)paramAppBrandRuntime).bsr())) {
      bRi().setNavButtonLongClickListener(new ag.6(this));
    }
    this.lxr = new com.tencent.mm.plugin.appbrand.permission.a((q)paramAppBrandRuntime, this);
    if (com.tencent.mm.plugin.appbrand.bb.r(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.h.a(paramAppBrandRuntime, new bb.1(paramAppBrandRuntime, paramContext));
      if (this.kBw.bsC().NA())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "decorateActionBarToSinglePageMode");
        if (this.nqM != null)
        {
          paramContext = getContext();
          this.nqM.gx(true);
          this.nqM.setNavResetStyleListener(new b.a()
          {
            public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
            {
              AppMethodBeat.i(227289);
              if (paramAnonymousImageView != null)
              {
                paramAnonymousImageView.clearColorFilter();
                if ((!ag.m(ag.this)) && (!ag.this.getRuntime().NA())) {
                  break label92;
                }
              }
              label92:
              for (int i = 2131689501;; i = 2131689494)
              {
                paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(paramContext.getResources(), i));
                paramAnonymousView2 = paramAnonymousImageView.getLayoutParams();
                paramAnonymousView2.height = -1;
                paramAnonymousView2.width = -2;
                paramAnonymousImageView.setLayoutParams(paramAnonymousView2);
                if (paramAnonymousView1 != null) {
                  paramAnonymousView1.setBackground(null);
                }
                AppMethodBeat.o(227289);
                return;
              }
            }
            
            public final int bQz()
            {
              return omi;
            }
          });
          if ((!isDarkMode()) && (!getRuntime().NA())) {
            break label296;
          }
        }
      }
    }
    label296:
    for (int i = 2131689502;; i = 2131689495)
    {
      paramContext = com.tencent.mm.svg.a.a.i(paramContext.getResources(), i);
      this.nqM.a(paramContext, new ag.3(this));
      this.nqM.gz(false);
      this.nqM.cad();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
      AppMethodBeat.o(47885);
      return;
    }
  }
  
  protected final void aG(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.aG(paramContext);
    if ((bRb() instanceof a))
    {
      localObject = (a)bRb();
      if (((a)localObject).nng != null) {
        ((a)localObject).nng.setBaseContext(paramContext);
      }
    }
    if (this.nmX != null) {
      this.nmX.aG(paramContext);
    }
    Object localObject = bRM();
    if (localObject != null)
    {
      if (paramContext == null)
      {
        AppMethodBeat.o(47886);
        return;
      }
      if ((((com.tencent.mm.plugin.appbrand.jsapi.af.a)localObject).getContext() instanceof MutableContextWrapper)) {
        ((MutableContextWrapper)((com.tencent.mm.plugin.appbrand.jsapi.af.a)localObject).getContext()).setBaseContext(paramContext);
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.af.a)localObject).iGY.aG(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175037);
    long l;
    if (paramc == null)
    {
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).ca;
      if ((this.nrx.getContext() == paramc) && (this.nrx == this.kEb))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = Util.currentTicks();
      this.nrx.aG(paramc);
      super.b(this.nrx);
      aG(paramc);
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), this.lBI, Boolean.valueOf(isRunning()), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.kEb) != 0)
    {
      l = Util.currentTicks();
      super.b(paramc);
      if ((getRuntime() != null) && (AndroidContextUtil.castActivityOrNull(getRuntime().mContext) != null)) {
        aG(AndroidContextUtil.castActivityOrNull(getRuntime().mContext));
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.kEb, paramc, getAppId(), this.lBI, Long.valueOf(Util.ticksToNow(l)), android.util.Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  protected final boolean b(View paramView, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(227303);
    if ((this.nqW) && (!android.support.v4.view.u.aD(paramView)) && (getRuntime() != null) && (getRuntime().OS()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(227303);
      return true;
    }
    boolean bool = super.b(paramView, paramRunnable, paramLong);
    AppMethodBeat.o(227303);
    return bool;
  }
  
  protected void bOE()
  {
    AppMethodBeat.i(47890);
    com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.widget.recent.l.class);
    if (getRuntime().bsr())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.nrq = ((com.tencent.mm.plugin.appbrand.widget.recent.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.widget.recent.l.class)).a(getContext(), l.b.oDH, new l.a()
      {
        public final LocalUsageInfo bRO()
        {
          AppMethodBeat.i(47877);
          if (!ag.this.isRunning())
          {
            AppMethodBeat.o(47877);
            return null;
          }
          LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(ag.this.getRuntime().bsC().username, ag.this.getRuntime().bsB().appId, ag.this.getRuntime().bsB().leE.kNW, ag.this.getRuntime().bsB().leE.pkgVersion, ag.this.getRuntime().bsB().brandName, ag.this.getRuntime().bsB().cyB, ag.this.getRuntime().bsB().jyi, ag.this.getRuntime().bsB().czf);
          AppMethodBeat.o(47877);
          return localLocalUsageInfo;
        }
      });
      if (this.nrq == null)
      {
        AppMethodBeat.o(47890);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localException, "appId[%s]", new Object[] { getAppId() });
      }
      this.nrr = new com.tencent.mm.plugin.appbrand.widget.actionbar.f(getContext());
      this.nrr.setWidth(-1);
      this.nrr.setBackgroundDrawable(new ColorDrawable());
      this.nrq.refresh();
      this.nrr.setHeight(this.nrq.getLayoutParams().height);
      this.nrq.setBackground(com.tencent.mm.cb.a.l(getContext(), 2131231010));
      this.nrr.setContentView(this.nrq);
      this.nrq.setOnItemClickListener(new AppBrandRecentView.b()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recent.e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(227298);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47878);
              ag.l(ag.this).dismiss();
              AppMethodBeat.o(47878);
            }
          }, 100L);
          if (paramAnonymouse.type == 1)
          {
            paramAnonymousView = paramAnonymouse.ooj;
            paramAnonymouse = new AppBrandStatObject();
            paramAnonymouse.scene = 1090;
            paramAnonymouse.dCw = ag.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(ag.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.iOo, -1, paramAnonymouse, null, null);
            AppMethodBeat.o(227298);
            return true;
          }
          AppMethodBeat.o(227298);
          return false;
        }
        
        public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recent.e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          return false;
        }
      });
      AppMethodBeat.o(47890);
    }
  }
  
  public void bOF()
  {
    boolean bool2 = true;
    AppMethodBeat.i(47891);
    super.bOF();
    Object localObject = getPageConfig();
    boolean bool3 = getRuntime().cCn.a(this, c.a.class);
    if ((!((b.d)localObject).lcw) || (!bool3))
    {
      bool1 = true;
      super.bV(bool1);
      if ((bool3) && (((b.d)localObject).lcw) && (getRuntime().bsC().cyo == 7) && (!bRi().isFullscreenMode())) {
        break label195;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool3 + " navigationBarRightButtonHide:" + ((b.d)localObject).lcw + " appServiceType:" + getRuntime().bsC().cyo + " isFullscreenMode:" + bRi().isFullscreenMode());
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.appbrand.bb.r(getRuntime())) {
        break label238;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227293);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "customActionBarIfNeed decorateActionBarToSinglePageMode");
          if (ag.this.nqM == null)
          {
            AppMethodBeat.o(227293);
            return;
          }
          Object localObject = ag.this.getContext();
          ag.this.nqM.setNavResetStyleListener(new b.a()
          {
            public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
            {
              AppMethodBeat.i(227291);
              if (paramAnonymous2ImageView != null)
              {
                paramAnonymous2ImageView.clearColorFilter();
                if ((!ag.n(ag.this)) && (!ag.this.getRuntime().NA())) {
                  break label98;
                }
              }
              label98:
              for (int i = 2131689501;; i = 2131689494)
              {
                paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(this.val$context.getResources(), i));
                paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                paramAnonymous2View2.height = -1;
                paramAnonymous2View2.width = -2;
                paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                if (paramAnonymous2View1 != null) {
                  paramAnonymous2View1.setBackground(null);
                }
                AppMethodBeat.o(227291);
                return;
              }
            }
            
            public final int bQz()
            {
              return omi;
            }
          });
          int i;
          if ((ag.n(ag.this)) || (ag.this.getRuntime().NA()))
          {
            i = 2131689502;
            localObject = com.tencent.mm.svg.a.a.i(((Context)localObject).getResources(), i);
            ag.this.nqM.a((Bitmap)localObject, new ag.4.2(this));
            if ("squeezed".equals(ag.o(ag.this))) {
              break label186;
            }
          }
          label186:
          for (boolean bool = true;; bool = false)
          {
            ag.this.ii(bool);
            ag.this.nqM.gz(false);
            ag.this.nqM.setFullscreenMode(false);
            ag.this.nqM.gx(true);
            ag.p(ag.this);
            AppMethodBeat.o(227293);
            return;
            i = 2131689495;
            break;
          }
        }
      });
      AppMethodBeat.o(47891);
      return;
      bool1 = false;
      break;
      label195:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((b.d)localObject).lcv, new com.tencent.mm.plugin.appbrand.widget.tabbar.c()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(47881);
          super.a(paramAnonymousString, paramAnonymousd);
          com.tencent.mm.sdk.platformtools.Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(47881);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).a(new com.tencent.mm.plugin.appbrand.widget.tabbar.e()
      {
        public final void a(Bitmap paramAnonymousBitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(47883);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          ag.this.bRi().a(paramAnonymousBitmap, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(47882);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
              com.tencent.mm.plugin.appbrand.page.c.d.h(ag.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(47882);
            }
          });
          AppMethodBeat.o(47883);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).cdf();
    }
    label238:
    if (com.tencent.mm.plugin.appbrand.af.g.an(getRuntime()))
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180330);
          if (ag.this.nqM != null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
            ag.this.nqM.setNavResetStyleListener(new b.a()
            {
              public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
              {
                AppMethodBeat.i(227294);
                if (paramAnonymous2ImageView != null)
                {
                  paramAnonymous2ImageView.clearColorFilter();
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] set close button");
                  paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(ag.this.getContext().getResources(), 2131689687));
                  paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                  paramAnonymous2View2.height = -1;
                  paramAnonymous2View2.width = -2;
                  paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                }
                if (paramAnonymous2View1 != null) {
                  paramAnonymous2View1.setBackground(null);
                }
                AppMethodBeat.o(227294);
              }
              
              public final int bQz()
              {
                return omi;
              }
            });
            ag.this.nqM.setFullscreenMode(true);
            ag.this.nqM.setForegroundStyle(false);
            ag.this.nqM.gz(false);
            ag.this.nqM.gx(true);
            ag.this.nqM.setBackButtonClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(227295);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] pageview click close button");
                com.tencent.mm.plugin.appbrand.af.g.bZS();
                if (ag.i(ag.this) != null)
                {
                  com.tencent.mm.plugin.appbrand.h.a(ag.this.getAppId(), h.d.kzP);
                  ag.i(ag.this).close();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227295);
              }
            });
          }
          if (ag.this.nqL != null) {
            ag.this.nqL.setForceTopInsetsHeight(ag.this.getContext().getResources().getDimensionPixelSize(2131165906));
          }
          AppMethodBeat.o(180330);
        }
      });
      AppMethodBeat.o(47891);
      return;
    }
    if ((getRuntime() != null) && (getRuntime().bsr()))
    {
      bRi().setNavHidden(false);
      AppMethodBeat.o(47891);
      return;
    }
    if (getRuntime().bsN())
    {
      localObject = this.nqM;
      if (getRuntime().bsO()) {
        break label340;
      }
    }
    label340:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).gz(bool1);
      AppMethodBeat.o(47891);
      return;
    }
  }
  
  protected final void bP(List<t> paramList)
  {
    AppMethodBeat.i(47905);
    this.nru = new v(this, paramList);
    this.nru.btY();
    AppMethodBeat.o(47905);
  }
  
  public final Bitmap bRB()
  {
    AppMethodBeat.i(227299);
    Object localObject1 = (com.tencent.luggage.game.page.d)S(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.bRB();
      AppMethodBeat.o(227299);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).MQ().getMagicBrush().cLA.h(((com.tencent.luggage.game.page.d)localObject1).MQ().getVirtualElementId(), -1, true);
      AppMethodBeat.o(227299);
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localNullPointerException, "hy: exception in get snapshot", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(227304);
    super.bRD();
    if (this.kBw == null) {}
    for (String str = "";; str = this.kBw.mAppId)
    {
      com.tencent.mm.plugin.appbrand.report.i.E(str, this.lBI, 1);
      AppMethodBeat.o(227304);
      return;
    }
  }
  
  public final void bRF()
  {
    AppMethodBeat.i(227305);
    super.bRF();
    if ((this.nmX != null) && (this.nqQ != null)) {
      if (this.kBw != null) {
        break label51;
      }
    }
    label51:
    for (String str = "";; str = this.kBw.mAppId)
    {
      com.tencent.mm.plugin.appbrand.report.i.E(str, this.lBI, 2);
      AppMethodBeat.o(227305);
      return;
    }
  }
  
  protected final b bRG()
  {
    AppMethodBeat.i(227306);
    c localc = new c(this);
    AppMethodBeat.o(227306);
    return localc;
  }
  
  public final am bRI()
  {
    AppMethodBeat.i(47903);
    if ((bRb() instanceof af))
    {
      am localam = ((af)bRb()).bRI();
      AppMethodBeat.o(47903);
      return localam;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.h bRK()
  {
    return this.nrs;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.af.a bRM()
  {
    AppMethodBeat.i(47896);
    try
    {
      Object localObject = getContentView().findViewById(2131296864);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.af.a))
      {
        localObject = (com.tencent.mm.plugin.appbrand.jsapi.af.a)localObject;
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
  
  public final void bRN()
  {
    AppMethodBeat.i(47906);
    if ((this.kHj == null) || (this.kHj.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.lBI });
      AppMethodBeat.o(47906);
      return;
    }
    bP(this.kHj);
    AppMethodBeat.o(47906);
  }
  
  public final List<t> bRg()
  {
    AppMethodBeat.i(47897);
    if (com.tencent.mm.plugin.appbrand.bb.r(getRuntime()))
    {
      bool = getRuntime().NA();
      localLinkedList = new LinkedList();
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.neY.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.neZ.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfx.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfy.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfi.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nft.ordinal(), false, false);
      if (bool) {
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfu.ordinal(), false, false);
      }
      this.kHj = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.neY.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.neZ.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfx.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfh.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.a.TR((String)localObject);
    if ((!CrashReportFactory.hasDebuger()) && ((localObject == null) || (((com.tencent.mm.plugin.appbrand.config.l)localObject).leE.kNW == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfg.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfy.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfz.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.neV.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.neX.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfr.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfs.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nff.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nft.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfw.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfA.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfu.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.u.nfv.ordinal(), false, false);
      this.kHj = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  protected final void bRq()
  {
    AppMethodBeat.i(47899);
    super.bRq();
    Object localObject = this.nrs;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).nIt = (Util.nowMilliSecond() - ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).nIs);
    if (bqZ().compareTo(getRuntime().bqZ()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), bqZ().bvb(), getRuntime().bqZ().bvb() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void bRr()
  {
    AppMethodBeat.i(47900);
    super.bRr();
    Object localObject2;
    Object localObject1;
    if (getRuntime().NA())
    {
      localObject2 = this.nrs;
      if (getRuntime().kAK)
      {
        localObject1 = getRuntime().brs();
        ((com.tencent.mm.plugin.appbrand.report.h)localObject2).aeF((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = getRuntime().kAx;
      localObject1 = new View.OnLongClickListener()
      {
        private void cC(View paramAnonymousView)
        {
          AppMethodBeat.i(47875);
          if ((ag.k(ag.this) == null) || (ag.k(ag.this).getCount() == 0))
          {
            AppMethodBeat.o(47875);
            return;
          }
          ag.k(ag.this).refresh();
          ag.l(ag.this).showAsDropDown(paramAnonymousView);
          com.tencent.mm.plugin.appbrand.report.i.a(ag.this.getAppId(), ag.this.lBI, 21, "", Util.nowSecond(), 1, 0);
          AppMethodBeat.o(47875);
        }
        
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(47874);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          if (!ag.j(ag.this).getAndSet(true))
          {
            ag.this.bOE();
            if (ag.k(ag.this) != null)
            {
              ag.k(ag.this).setRefreshListener(new AppBrandRecentView.e()
              {
                public final void yL(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(47873);
                  ag.k(ag.this).setRefreshListener(null);
                  ag.8.a(ag.8.this, paramAnonymousView);
                  AppMethodBeat.o(47873);
                }
              });
              ag.k(ag.this).refresh();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(47874);
            return true;
            cC(paramAnonymousView);
          }
        }
      };
      localObject2 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject2).nvi;
      if (localObject2 == null) {
        p.btv("capsuleBarView");
      }
      ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject2).getCapsuleHomeButton().setOnLongClickListener((View.OnLongClickListener)localObject1);
      AppMethodBeat.o(47900);
      return;
      localObject1 = getRuntime().bsD().getCurrentUrl();
      break;
      this.nrs.onForeground();
    }
  }
  
  protected final void bRs()
  {
    AppMethodBeat.i(47901);
    super.bRs();
    if (this.nrr != null) {
      this.nrr.dismiss();
    }
    this.nrs.onBackground();
    AppMethodBeat.o(47901);
  }
  
  protected final void bRt()
  {
    AppMethodBeat.i(47902);
    super.bRt();
    this.nrs.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View bRy()
  {
    AppMethodBeat.i(175036);
    if (com.tencent.mm.plugin.appbrand.bb.r(getRuntime()))
    {
      AppMethodBeat.o(175036);
      return null;
    }
    AppBrandMenuHeader localAppBrandMenuHeader = new AppBrandMenuHeader(getContext());
    localAppBrandMenuHeader.setPage(this);
    AppMethodBeat.o(175036);
    return localAppBrandMenuHeader;
  }
  
  public final View bRz()
  {
    AppMethodBeat.i(47893);
    if (com.tencent.mm.plugin.appbrand.ad.e.d(this))
    {
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.b();
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).source = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).type = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).d((com.tencent.mm.plugin.appbrand.service.c)super.NQ());
      localObject = new AppBrandMenuFooter(getContext());
      ((AppBrandMenuFooter)localObject).setPageView(this);
      ((AppBrandMenuFooter)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47880);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.appbrand.ad.e.c(ag.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47880);
        }
      });
      AppMethodBeat.o(47893);
      return localObject;
    }
    Object localObject = super.bRz();
    AppMethodBeat.o(47893);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c bsE()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.NQ();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdk(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.cds(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdo(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdz(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdu(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdv(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdr(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdq(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdx(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdw()));
    c(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdm()));
    c(paramJSONObject, "useNewXWebCanvasToTFP", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdn()));
    AppMethodBeat.o(47907);
  }
  
  public final boolean dE(String paramString)
  {
    AppMethodBeat.i(47898);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL appId:%s, url:%s, stack:%s", new Object[] { getAppId(), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    com.tencent.mm.plugin.appbrand.report.h localh = this.nrs;
    localh.nIs = Util.nowMilliSecond();
    localh.nIr = paramString;
    b(getRuntime().getWindowAndroid());
    boolean bool = super.dE(paramString);
    AppMethodBeat.o(47898);
    return bool;
  }
  
  protected final boolean f(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(227302);
    if ((this.nqW) && (!android.support.v4.view.u.aD(paramView)) && (getRuntime() != null) && (getRuntime().OS()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(227302);
      return true;
    }
    boolean bool = super.f(paramView, paramRunnable);
    AppMethodBeat.o(227302);
    return bool;
  }
  
  public q getRuntime()
  {
    AppMethodBeat.i(47887);
    q localq = (q)super.NP();
    AppMethodBeat.o(47887);
    return localq;
  }
  
  protected final View j(ViewGroup paramViewGroup)
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(180347);
    if ((this.kBw == null) || (!com.tencent.mm.plugin.appbrand.bb.r(this.kBw)) || (!(paramViewGroup instanceof RelativeLayout)))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.nrv == null) {
      this.nrv = new al(getContext());
    }
    Object localObject1 = this.nrv;
    Object localObject2 = this.kBw.bsC().iconUrl;
    String str1 = this.kBw.bsC().brandName;
    String str2 = com.tencent.mm.plugin.appbrand.appcache.e.vO(this.kBw.bsB().leE.kNW);
    boolean bool = this.kBw.bsC().NA();
    int j;
    if (this.kBw.bsC().originalFlag == 1)
    {
      com.tencent.mm.modelappbrand.a.b.aXY().a(((al)localObject1).lIM, (String)localObject2, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
      localObject2 = ((al)localObject1).nsc;
      if (!bool) {
        break label310;
      }
      j = 2131756179;
      label175:
      ((Button)localObject2).setText(j);
      ((al)localObject1).jVh.setText(str1);
      if (!Util.isNullOrNil(str2)) {
        break label323;
      }
      ((al)localObject1).nsb.setVisibility(8);
      localObject1 = ((al)localObject1).nsd;
      if (i == 0) {
        break label317;
      }
      i = k;
      label223:
      ((ImageView)localObject1).setVisibility(i);
    }
    for (;;)
    {
      this.nrv.setJumpBtnOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(227296);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = ag.i(ag.this);
          localObject = ag.this.nna;
          bb.a locala = new bb.a();
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("currentPath", localObject);
          locala.K(localHashMap).g(paramAnonymousView.bsE()).bEo();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(227296);
        }
      });
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (-getContext().getResources().getDimensionPixelSize(2131165878));
      paramViewGroup.addView(this.nrv, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup = this.nrv;
      AppMethodBeat.o(180347);
      return paramViewGroup;
      i = 0;
      break;
      label310:
      j = 2131756178;
      break label175;
      label317:
      i = 8;
      break label223;
      label323:
      ((al)localObject1).nsb.setText(str2);
      ((al)localObject1).nsb.setVisibility(0);
      ((al)localObject1).nsd.setVisibility(8);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.kBw != null) && (com.tencent.mm.plugin.appbrand.bb.r(this.kBw)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.h.a(getAppId(), h.d.kzQ);
      this.kBw.close();
      AppMethodBeat.o(180348);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(180348);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */