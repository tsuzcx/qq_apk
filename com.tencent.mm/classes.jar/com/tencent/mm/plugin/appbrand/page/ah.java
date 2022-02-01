package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
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
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.bd.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.config.b.f;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.m.aa;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.v;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.d;
import com.tencent.mm.plugin.appbrand.widget.recent.k.a;
import com.tencent.mm.plugin.appbrand.widget.recent.k.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
import com.tencent.xweb.aj;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import org.json.JSONObject;

public class ah
  extends com.tencent.luggage.sdk.b.a.c
{
  private List<v> nBd;
  private t nuJ;
  private AppBrandRecentView qti;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.g qtj;
  public final com.tencent.mm.plugin.appbrand.report.i qtk;
  private final AtomicBoolean qtl;
  private w qtm;
  public am qtn;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.e qto;
  private Boolean qtp;
  private final o qtq;
  
  public ah()
  {
    this(ag.class);
  }
  
  public ah(Class<? extends af> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.qtk = new com.tencent.mm.plugin.appbrand.report.i(getComponentId());
    this.qtl = new AtomicBoolean(false);
    this.qto = null;
    this.qtq = new o();
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.nug = bool;
    AppMethodBeat.o(47884);
  }
  
  private String ceC()
  {
    AppMethodBeat.i(278214);
    if (!this.qsy.cne())
    {
      AppMethodBeat.o(278214);
      return "squeezed";
    }
    Object localObject2 = getRuntime().getAppConfig().aeI(this.oxe).nWL.nWq;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = getRuntime().getAppConfig().bKU().nWL.nWq;
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = "float";
    }
    AppMethodBeat.o(278214);
    return localObject2;
  }
  
  private boolean ceD()
  {
    AppMethodBeat.i(180349);
    String str = getRuntime().getAppConfig().aeI(this.oxe).nWL.nWt;
    if (Util.isNullOrNil(str))
    {
      if (this.qtp == null) {
        this.qtp = Boolean.valueOf(ar.isDarkMode());
      }
      boolean bool = this.qtp.booleanValue();
      AppMethodBeat.o(180349);
      return bool;
    }
    if (!f.a.roU.name().equalsIgnoreCase(str))
    {
      AppMethodBeat.o(180349);
      return true;
    }
    AppMethodBeat.o(180349);
    return false;
  }
  
  private void ceG()
  {
    AppMethodBeat.i(278221);
    Object localObject = cdR();
    if (localObject != null)
    {
      localObject = ((af)localObject).getCustomViewContainer();
      if (localObject != null) {
        ((ap)localObject).setFullscreenImpl(getFullscreenImpl());
      }
    }
    AppMethodBeat.o(278221);
  }
  
  private void ceI()
  {
    AppMethodBeat.i(278228);
    boolean bool;
    if (this.qsy != null)
    {
      this.qsy.setVisibility(4);
      this.qsy.hk(false);
      this.qsy.hi(false);
      if (!"squeezed".equals(ceC()))
      {
        bool = true;
        jf(bool);
        this.qsy.setFullscreenMode(false);
      }
    }
    else
    {
      if (this.qto != null) {
        break label355;
      }
      if ((!ceD()) && (!getRuntime().Qv())) {
        break label336;
      }
      bool = true;
      label89:
      this.qto = new com.tencent.mm.plugin.appbrand.widget.actionbar.e(getContext());
      this.qsx.addView(this.qto, new ViewGroup.LayoutParams(-1, -1));
      this.qsx.setStatusBarForegroundStyle(bool);
      this.qto.kb(bool);
      this.qto.setOptionButtonClickListener(new ah.4(this));
      this.qto.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276063);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.appbrand.k.a(ah.this.getAppId(), k.d.ntb);
          ah.j(ah.this).close();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276063);
        }
      });
      if (cdY() != null) {
        this.qto.setMainTitle(cdY().getMainTitle());
      }
      if (getRuntime().bDy().lyw == 0) {
        break label351;
      }
      if ((getRuntime().bDy().lyw & 0x2) != 2) {
        break label341;
      }
      this.qto.cni();
    }
    for (;;)
    {
      this.qto.setForwardOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(272978);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.appbrand.bd.a(ah.j(ah.this), ah.this.qoI);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(272978);
        }
      });
      String str2 = this.nuJ.bDx().cxg;
      String str1 = str2;
      if (Util.isNullOrNil(str2))
      {
        str2 = this.nuJ.bDg();
        str1 = str2;
        if (str2.length() > 5) {
          str1 = String.format("%s...", new Object[] { str2.substring(0, 4) });
        }
      }
      this.qto.setForwardText(getContext().getString(au.i.appbrand_single_page_mode_forward_title, new Object[] { str1 }));
      AppMethodBeat.o(278228);
      return;
      bool = false;
      break;
      label336:
      bool = false;
      break label89;
      label341:
      this.qto.cnh();
    }
    label351:
    ceJ();
    label355:
    AppMethodBeat.o(278228);
  }
  
  private void ceJ()
  {
    AppMethodBeat.i(278229);
    Object localObject = getRuntime().getAppConfig().aeI(this.oxe).nWL;
    String str = ((b.f)localObject).nWr;
    if (!Util.isNullOrNil(str)) {}
    try
    {
      int i = com.tencent.mm.plugin.appbrand.ac.g.ang(str);
      this.qto.setBackgroundColor(i);
      double d = ((b.f)localObject).nWs;
      if (d >= 0.0D) {
        this.qto.setBackgroundAlpha(d);
      }
      localObject = ((b.f)localObject).nWu;
      if (!Util.isNullOrNil((String)localObject)) {
        this.qto.setMainTitle((CharSequence)localObject);
      }
      AppMethodBeat.o(278229);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandPageViewWC", "decorateSinglePageModeNavigationBarFromPageConfig color parse error");
      }
    }
  }
  
  public void QO()
  {
    AppMethodBeat.i(47889);
    b(null);
    super.QO();
    if (this.qti != null) {
      this.qti.release();
    }
    if (this.qtj != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.g localg = this.qtj;
      localg.dismiss();
      if (localg.roY != null)
      {
        localg.roY.removeAllViews();
        localg.roY = null;
      }
    }
    this.qtm = null;
    AppMethodBeat.o(47889);
  }
  
  public void QU()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().bDl()) {
      cdY().setNavHidden(false);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.ag.g.ap(this.nuJ)) || (com.tencent.mm.plugin.appbrand.bd.s(getRuntime()))) {
        cdY().hi(true);
      }
      AppMethodBeat.o(47904);
      return;
      super.QU();
    }
  }
  
  public final void Rk()
  {
    AppMethodBeat.i(278220);
    super.Rk();
    if (aa.f(this))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.f.rIz) {
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
      AppMethodBeat.o(278220);
      return;
      label183:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      aj.Xd(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.f.rIz = true;
    }
  }
  
  public void a(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.nuJ = ((t)paramAppBrandRuntime);
    if (bBP() == null) {
      a(((t)paramAppBrandRuntime).bBP());
    }
    super.a(paramContext, paramAppBrandRuntime);
    paramContext = this.qtk;
    paramContext.mAppId = paramAppBrandRuntime.mAppId;
    paramContext.nxs = paramAppBrandRuntime;
    cdY().setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        j.a(ah.this.getAppId(), ah.this.oxe, 22, "", Util.nowSecond(), 1, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47864);
      }
    });
    if ((paramAppBrandRuntime.nug) && (((t)paramAppBrandRuntime).bDl())) {
      cdY().setNavButtonLongClickListener(new ah.7(this));
    }
    setInterceptor(new com.tencent.mm.plugin.appbrand.permission.a((t)paramAppBrandRuntime, this));
    if (com.tencent.mm.plugin.appbrand.bd.s(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.k.a(paramAppBrandRuntime, new bd.1(paramAppBrandRuntime, paramContext));
      if (this.nuJ.bDy().Qv()) {
        ceI();
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
    AppMethodBeat.o(47885);
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(278207);
    if ((cdR() instanceof ag)) {
      ((ag)cdR()).qte.add(paramat);
    }
    AppMethodBeat.o(278207);
  }
  
  protected final void a(List<v> paramList, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(278218);
    if (this.qtm != null) {
      this.qtm.bEZ();
    }
    this.qtm = new w(this, paramList);
    this.qtm.qqE = paramRunnable1;
    this.qtm.qqF = paramRunnable2;
    this.qtm.bEY();
    AppMethodBeat.o(278218);
  }
  
  protected final void aD(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.aD(paramContext);
    if ((cdR() instanceof a))
    {
      localObject = (a)cdR();
      if (((a)localObject).qoO != null) {
        ((a)localObject).qoO.setBaseContext(paramContext);
      }
    }
    if ((cdR() instanceof com.tencent.luggage.game.page.h)) {
      ((com.tencent.luggage.game.page.h)cdR()).aD(paramContext);
    }
    if (this.qoF != null) {
      this.qoF.aD(paramContext);
    }
    Object localObject = ceE();
    if (localObject != null) {
      ((g.c)localObject).aD(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  public final void b(at paramat)
  {
    AppMethodBeat.i(278208);
    if ((cdR() instanceof ag)) {
      ((ag)cdR()).qte.remove(paramat);
    }
    AppMethodBeat.o(278208);
  }
  
  public void b(ca paramca)
  {
    AppMethodBeat.i(278213);
    super.b(paramca);
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().cCQ.a(this, c.a.class);
    boolean bool1;
    if ((!((b.d)localObject).nWF) || (!bool2))
    {
      bool1 = true;
      super.cg(bool1);
      if ((bool2) && (((b.d)localObject).nWF) && (getRuntime().bDy().cwR == 7) && (!cdY().cne())) {
        break label204;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((b.d)localObject).nWF + " appServiceType:" + getRuntime().bDy().cwR + " isFullscreenMode:" + cdY().cne());
      label160:
      if (!com.tencent.mm.plugin.appbrand.bd.s(getRuntime())) {
        break label247;
      }
      runOnUiThread(new ah.2(this));
    }
    for (;;)
    {
      getRuntime();
      com.tencent.mm.plugin.appbrand.widget.c.e.a(this, paramca);
      AppMethodBeat.o(278213);
      return;
      bool1 = false;
      break;
      label204:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((b.d)localObject).nWE, new com.tencent.mm.plugin.appbrand.widget.tabbar.c()
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
          ah.this.cdY().a(paramAnonymousBitmap, new ah.14.1(this));
          AppMethodBeat.o(47883);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).cqr();
      break label160;
      label247:
      if (com.tencent.mm.plugin.appbrand.ag.g.ap(getRuntime())) {
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(253050);
            if (ah.this.qsy != null)
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
              ah.this.qsy.setNavResetStyleListener(new b.a()
              {
                public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
                {
                  AppMethodBeat.i(272059);
                  if (paramAnonymous2ImageView != null)
                  {
                    paramAnonymous2ImageView.clearColorFilter();
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] set close button");
                    paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(ah.this.getContext().getResources(), au.h.app_brand_weishi_video_btn_close));
                    paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                    paramAnonymous2View2.height = -1;
                    paramAnonymous2View2.width = -2;
                    paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                  }
                  if (paramAnonymous2View1 != null) {
                    paramAnonymous2View1.setBackground(null);
                  }
                  AppMethodBeat.o(272059);
                }
                
                public final int cdp()
                {
                  return roL;
                }
              });
              ah.this.qsy.setFullscreenMode(true);
              ah.this.qsy.setForegroundStyle(false);
              ah.this.qsy.hk(false);
              ah.this.qsy.hi(true);
              ah.this.qsy.setBackButtonClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(277559);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] pageview click close button");
                  com.tencent.mm.plugin.appbrand.ag.g.cmN();
                  if (ah.j(ah.this) != null)
                  {
                    com.tencent.mm.plugin.appbrand.k.a(ah.this.getAppId(), k.d.ntb);
                    ah.j(ah.this).close();
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(277559);
                }
              });
            }
            if (ah.this.qsx != null) {
              ah.this.qsx.setForceTopInsetsHeight(ah.this.getContext().getResources().getDimensionPixelSize(au.d.app_brand_weishi_close_button_margin_top));
            }
            AppMethodBeat.o(253050);
          }
        });
      } else if ((getRuntime() != null) && (getRuntime().bDl())) {
        cdY().setNavHidden(false);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175037);
    long l;
    if (paramc == null)
    {
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw;
      if ((this.qtq.getContext() == paramc) && (this.qtq == this.nxr))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = Util.currentTicks();
      this.qtq.aD(paramc);
      super.b(this.qtq);
      aD(paramc);
      ceG();
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), this.oxe, Boolean.valueOf(isRunning()), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.nxr) != 0)
    {
      l = Util.currentTicks();
      super.b(paramc);
      if ((getRuntime() != null) && (AndroidContextUtil.castActivityOrNull(getRuntime().mContext) != null)) {
        aD(AndroidContextUtil.castActivityOrNull(getRuntime().mContext));
      }
      ceG();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.nxr, paramc, getAppId(), this.oxe, Long.valueOf(Util.ticksToNow(l)), android.util.Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  protected final boolean b(View paramView, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(278223);
    if ((this.qsI) && (!androidx.core.g.w.al(paramView)) && (getRuntime() != null) && (getRuntime().So()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(278223);
      return true;
    }
    boolean bool = super.b(paramView, paramRunnable, paramLong);
    AppMethodBeat.o(278223);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c bDA()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.QN();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  public final boolean c(String paramString, ca paramca)
  {
    AppMethodBeat.i(278216);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL appId:%s, url:%s, stack:%s", new Object[] { getAppId(), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    com.tencent.mm.plugin.appbrand.report.i locali = this.qtk;
    locali.qKE = Util.nowMilliSecond();
    locali.qKD = paramString;
    b(getRuntime().getWindowAndroid());
    boolean bool = super.c(paramString, paramca);
    AppMethodBeat.o(278216);
    return bool;
  }
  
  protected void caV()
  {
    AppMethodBeat.i(47890);
    com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.widget.recent.k.class);
    if (getRuntime().bDl())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.qti = ((com.tencent.mm.plugin.appbrand.widget.recent.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.widget.recent.k.class)).a(getContext(), k.b.rFn, new k.a()
      {
        public final LocalUsageInfo ceL()
        {
          AppMethodBeat.i(47877);
          if (!ah.this.isRunning())
          {
            AppMethodBeat.o(47877);
            return null;
          }
          LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(ah.this.getRuntime().bDy().username, ah.this.getRuntime().bDx().appId, ah.this.getRuntime().bDx().nYR.nHY, ah.this.getRuntime().bDx().nYR.pkgVersion, ah.this.getRuntime().bDx().fzM, ah.this.getRuntime().bDx().cxg, ah.this.getRuntime().bDx().mnM, ah.this.getRuntime().bDx().cxN);
          AppMethodBeat.o(47877);
          return localLocalUsageInfo;
        }
      });
      if (this.qti == null)
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
      this.qtj = new com.tencent.mm.plugin.appbrand.widget.actionbar.g(getContext());
      this.qtj.setWidth(-1);
      this.qtj.setBackgroundDrawable(new ColorDrawable());
      this.qti.bfU();
      this.qtj.setHeight(this.qti.getLayoutParams().height);
      this.qti.setBackground(com.tencent.mm.ci.a.m(getContext(), au.e.app_brand_game_recent_popwindow_background));
      this.qtj.setContentView(this.qti);
      this.qti.setOnItemClickListener(new AppBrandRecentView.a()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recent.e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(272389);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47878);
              ah.m(ah.this).dismiss();
              AppMethodBeat.o(47878);
            }
          }, 100L);
          if (paramAnonymouse.type == 1)
          {
            paramAnonymousView = paramAnonymouse.rqa;
            paramAnonymouse = new AppBrandStatObject();
            paramAnonymouse.scene = 1090;
            paramAnonymouse.fvd = ah.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.e.f.pZN.a(ah.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.cBU, -1, paramAnonymouse, null, null);
            AppMethodBeat.o(272389);
            return true;
          }
          AppMethodBeat.o(272389);
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
  
  public final List<v> cdW()
  {
    AppMethodBeat.i(47897);
    if (com.tencent.mm.plugin.appbrand.bd.s(getRuntime()))
    {
      bool = getRuntime().Qv();
      int i = getRuntime().bDy().lyw;
      localLinkedList = new LinkedList();
      if (i != 0)
      {
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfQ.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgb.ordinal(), true, false);
      }
      for (;;)
      {
        this.nBd = localLinkedList;
        AppMethodBeat.o(47897);
        return localLinkedList;
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfG.ordinal(), true, true);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfH.ordinal(), true, true);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgf.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgg.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgj.ordinal(), true, true);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfQ.ordinal(), false, false);
        WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgb.ordinal(), false, false);
        if (bool) {
          WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgc.ordinal(), false, false);
        }
      }
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfG.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfH.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgf.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfP.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgk.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.d.abB((String)localObject);
    if ((!CrashReportFactory.hasDebuger()) && ((localObject == null) || (((l)localObject).nYR.nHY == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfO.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgg.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgh.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgj.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfD.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfF.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfZ.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qga.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qfN.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgb.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qge.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgi.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgc.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, com.tencent.mm.plugin.appbrand.menu.w.qgd.ordinal(), false, false);
      this.nBd = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.report.i ceB()
  {
    return this.qtk;
  }
  
  public final g.c ceE()
  {
    AppMethodBeat.i(278215);
    try
    {
      Object localObject = ((View)Objects.requireNonNull(getContentView())).findViewById(au.f.app_brand_pageview_html_webview);
      if ((localObject instanceof g.c))
      {
        localObject = (g.c)localObject;
        AppMethodBeat.o(278215);
        return localObject;
      }
      AppMethodBeat.o(278215);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(278215);
    }
    return null;
  }
  
  public final void ceF()
  {
    AppMethodBeat.i(47906);
    cdX();
    if ((this.nBd == null) || (this.nBd.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.oxe });
      AppMethodBeat.o(47906);
      return;
    }
    a(this.nBd, null, null);
    AppMethodBeat.o(47906);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.e ceH()
  {
    return this.qto;
  }
  
  protected final void ceh()
  {
    AppMethodBeat.i(47899);
    super.ceh();
    Object localObject = this.qtk;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).qKF = (Util.nowMilliSecond() - ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).qKE);
    if (bBP().compareTo(getRuntime().bBP()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), bBP().bGg(), getRuntime().bBP().bGg() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void cei()
  {
    AppMethodBeat.i(47900);
    super.cei();
    Object localObject2;
    Object localObject1;
    if (getRuntime().Qv())
    {
      localObject2 = this.qtk;
      if (getRuntime().ntW)
      {
        localObject1 = getRuntime().bCi();
        ((com.tencent.mm.plugin.appbrand.report.i)localObject2).amz((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = getRuntime().ntG;
      localObject1 = new View.OnLongClickListener()
      {
        private void cV(View paramAnonymousView)
        {
          AppMethodBeat.i(47875);
          if ((ah.l(ah.this) == null) || (ah.l(ah.this).getCount() == 0))
          {
            AppMethodBeat.o(47875);
            return;
          }
          ah.l(ah.this).bfU();
          ah.m(ah.this).showAsDropDown(paramAnonymousView);
          j.a(ah.this.getAppId(), ah.this.oxe, 21, "", Util.nowSecond(), 1, 0);
          AppMethodBeat.o(47875);
        }
        
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(47874);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          if (!ah.k(ah.this).getAndSet(true))
          {
            ah.this.caV();
            if (ah.l(ah.this) != null)
            {
              ah.l(ah.this).setRefreshListener(new AppBrandRecentView.d()
              {
                public final void ceK()
                {
                  AppMethodBeat.i(271200);
                  ah.l(ah.this).setRefreshListener(null);
                  ah.9.a(ah.9.this, paramAnonymousView);
                  AppMethodBeat.o(271200);
                }
              });
              ah.l(ah.this).bfU();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(47874);
            return true;
            cV(paramAnonymousView);
          }
        }
      };
      localObject2 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject2).qxe;
      if (localObject2 == null) {
        p.bGy("capsuleBarView");
      }
      ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject2).getCapsuleHomeButton().setOnLongClickListener((View.OnLongClickListener)localObject1);
      AppMethodBeat.o(47900);
      return;
      localObject1 = getRuntime().bDz().getCurrentUrl();
      break;
      this.qtk.onForeground();
    }
  }
  
  protected final void cej()
  {
    AppMethodBeat.i(47901);
    super.cej();
    if (this.qtj != null) {
      this.qtj.dismiss();
    }
    this.qtk.onBackground();
    AppMethodBeat.o(47901);
  }
  
  protected final void cek()
  {
    AppMethodBeat.i(47902);
    super.cek();
    this.qtk.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View cep()
  {
    AppMethodBeat.i(175036);
    if (com.tencent.mm.plugin.appbrand.bd.s(getRuntime()))
    {
      AppMethodBeat.o(175036);
      return null;
    }
    AppBrandMenuHeader localAppBrandMenuHeader = new AppBrandMenuHeader(getContext());
    localAppBrandMenuHeader.setPage(this);
    AppMethodBeat.o(175036);
    return localAppBrandMenuHeader;
  }
  
  public final View ceq()
  {
    AppMethodBeat.i(47893);
    if (com.tencent.mm.plugin.appbrand.ad.e.d(this))
    {
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.b();
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).source = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).type = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).a((com.tencent.mm.plugin.appbrand.service.c)super.QN());
      localObject = new AppBrandMenuFooter(getContext());
      ((AppBrandMenuFooter)localObject).setPageView(this);
      ((AppBrandMenuFooter)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47880);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.appbrand.ad.e.c(ah.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47880);
        }
      });
      AppMethodBeat.o(47893);
      return localObject;
    }
    Object localObject = super.ceq();
    AppMethodBeat.o(47893);
    return localObject;
  }
  
  public final Bitmap ces()
  {
    AppMethodBeat.i(278211);
    Object localObject1 = (com.tencent.luggage.game.page.d)R(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.ces();
      AppMethodBeat.o(278211);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).PI().getMagicBrush().cMk.j(((com.tencent.luggage.game.page.d)localObject1).PI().getVirtualElementId(), -1, true);
      AppMethodBeat.o(278211);
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
  
  public final void ceu()
  {
    AppMethodBeat.i(278224);
    super.ceu();
    if (this.nuJ == null) {}
    for (String str = "";; str = this.nuJ.mAppId)
    {
      j.H(str, this.oxe, 1);
      AppMethodBeat.o(278224);
      return;
    }
  }
  
  public final void cew()
  {
    AppMethodBeat.i(278226);
    super.cew();
    if ((this.qoF != null) && (this.qsC != null)) {
      if (this.nuJ != null) {
        break label51;
      }
    }
    label51:
    for (String str = "";; str = this.nuJ.mAppId)
    {
      j.H(str, this.oxe, 2);
      AppMethodBeat.o(278226);
      return;
    }
  }
  
  protected final b cex()
  {
    AppMethodBeat.i(278227);
    c localc = new c(this);
    AppMethodBeat.o(278227);
    return localc;
  }
  
  public final an cez()
  {
    AppMethodBeat.i(47903);
    if ((cdR() instanceof ag))
    {
      an localan = ((ag)cdR()).cez();
      AppMethodBeat.o(47903);
      return localan;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  protected final boolean f(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(278222);
    if ((this.qsI) && (!androidx.core.g.w.al(paramView)) && (getRuntime() != null) && (getRuntime().So()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(278222);
      return true;
    }
    boolean bool = super.f(paramView, paramRunnable);
    AppMethodBeat.o(278222);
    return bool;
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.g(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.RAD));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqw(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqE(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqA(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqL(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqG(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqH(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqD(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqC(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqJ(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqI()));
    c(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqy()));
    c(paramJSONObject, "useNewXWebCanvasToTFP", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqz()));
    AppMethodBeat.o(47907);
  }
  
  public t getRuntime()
  {
    AppMethodBeat.i(47887);
    t localt = (t)super.QM();
    AppMethodBeat.o(47887);
    return localt;
  }
  
  protected final View k(ViewGroup paramViewGroup)
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(180347);
    if ((this.nuJ == null) || (!com.tencent.mm.plugin.appbrand.bd.s(this.nuJ)) || (!(paramViewGroup instanceof RelativeLayout)) || (this.nuJ.bDy().lyw != 0))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.qtn == null) {
      this.qtn = new am(this.nuJ.mContext);
    }
    Object localObject1 = this.qtn;
    Object localObject2 = this.nuJ.bDy().iconUrl;
    String str1 = this.nuJ.bDy().fzM;
    String str2 = com.tencent.mm.plugin.appbrand.appcache.e.yZ(this.nuJ.bDx().nYR.nHY);
    boolean bool = this.nuJ.bDy().Qv();
    int j;
    if (this.nuJ.bDy().originalFlag == 1)
    {
      com.tencent.mm.modelappbrand.a.b.bhh().a(((am)localObject1).oFa, (String)localObject2, com.tencent.mm.modelappbrand.a.a.bhg(), com.tencent.mm.modelappbrand.a.g.lzF);
      localObject2 = ((am)localObject1).qtU;
      if (!bool) {
        break label326;
      }
      j = au.i.appbrand_single_page_mode_footer_jump_btn_title_game;
      label191:
      ((Button)localObject2).setText(j);
      ((am)localObject1).mMu.setText(str1);
      if (!Util.isNullOrNil(str2)) {
        break label339;
      }
      ((am)localObject1).qtT.setVisibility(8);
      localObject1 = ((am)localObject1).qtV;
      if (i == 0) {
        break label333;
      }
      i = k;
      label239:
      ((ImageView)localObject1).setVisibility(i);
    }
    for (;;)
    {
      this.qtn.setJumpBtnOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(284672);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.appbrand.bd.a(ah.j(ah.this), ah.this.qoI);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(284672);
        }
      });
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (-getContext().getResources().getDimensionPixelSize(au.d.app_brand_single_page_mode_footer_corner_size));
      paramViewGroup.addView(this.qtn, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup = this.qtn;
      AppMethodBeat.o(180347);
      return paramViewGroup;
      i = 0;
      break;
      label326:
      j = au.i.appbrand_single_page_mode_footer_jump_btn_title;
      break label191;
      label333:
      i = 8;
      break label239;
      label339:
      ((am)localObject1).qtT.setText(str2);
      ((am)localObject1).qtT.setVisibility(0);
      ((am)localObject1).qtV.setVisibility(8);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.nuJ != null) && (com.tencent.mm.plugin.appbrand.bd.s(this.nuJ)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.k.a(getAppId(), k.d.ntc);
      this.nuJ.close();
      AppMethodBeat.o(180348);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(180348);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */