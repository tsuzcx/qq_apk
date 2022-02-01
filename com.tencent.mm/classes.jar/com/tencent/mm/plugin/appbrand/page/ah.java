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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.core.g.z;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.bj.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.config.b.g;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.x;
import com.tencent.mm.plugin.appbrand.n.aa;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
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
import com.tencent.mm.ui.aw;
import com.tencent.xweb.ao;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.s;
import org.json.JSONObject;

public class ah
  extends com.tencent.luggage.sdk.b.a.c
{
  private List<com.tencent.mm.plugin.appbrand.menu.w> qAp;
  private com.tencent.mm.plugin.appbrand.w qts;
  private AppBrandRecentView txO;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.g txP;
  public final com.tencent.mm.plugin.appbrand.report.i txQ;
  private final AtomicBoolean txR;
  private w txS;
  public am txT;
  public com.tencent.mm.plugin.appbrand.widget.actionbar.e txU;
  private Boolean txV;
  private final com.tencent.mm.plugin.appbrand.platform.window.a.o txW;
  
  public ah()
  {
    this(ag.class);
  }
  
  public ah(Class<? extends af> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.txQ = new com.tencent.mm.plugin.appbrand.report.i(getComponentId());
    this.txR = new AtomicBoolean(false);
    this.txU = null;
    this.txW = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.qsQ = bool;
    AppMethodBeat.o(47884);
  }
  
  private String cFe()
  {
    AppMethodBeat.i(325222);
    if (!this.txc.cOX())
    {
      AppMethodBeat.o(325222);
      return "squeezed";
    }
    Object localObject2 = getRuntime().getAppConfig().Xk(cgR()).qWA.qWd;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = getRuntime().getAppConfig().ckt().qWA.qWd;
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = "float";
    }
    AppMethodBeat.o(325222);
    return localObject2;
  }
  
  private boolean cFf()
  {
    AppMethodBeat.i(180349);
    String str = getRuntime().getAppConfig().Xk(cgR()).qWA.qWg;
    if (Util.isNullOrNil(str))
    {
      if (this.txV == null) {
        this.txV = Boolean.valueOf(aw.isDarkMode());
      }
      boolean bool = this.txV.booleanValue();
      AppMethodBeat.o(180349);
      return bool;
    }
    if (!f.a.uzf.name().equalsIgnoreCase(str))
    {
      AppMethodBeat.o(180349);
      return true;
    }
    AppMethodBeat.o(180349);
    return false;
  }
  
  private void cFh()
  {
    AppMethodBeat.i(325232);
    HalfScreenConfig localHalfScreenConfig = getRuntime().getInitConfig().qAT;
    if ((localHalfScreenConfig.isEnable()) && (!localHalfScreenConfig.raa) && (getRuntime().ccN().getPageCount() == 1))
    {
      cEC().setNavHidden(true);
      AppMethodBeat.o(325232);
      return;
    }
    cEC().setNavHidden(false);
    AppMethodBeat.o(325232);
  }
  
  private void cFk()
  {
    AppMethodBeat.i(325235);
    Object localObject = cEx();
    if (localObject != null)
    {
      localObject = ((af)localObject).getCustomViewContainer();
      if (localObject != null) {
        ((ap)localObject).setFullscreenImpl(getFullscreenImpl());
      }
    }
    if (this.tti != null) {
      this.tti.setFullscreenImpl(getFullscreenImpl());
    }
    AppMethodBeat.o(325235);
  }
  
  private void cFl()
  {
    AppMethodBeat.i(325241);
    boolean bool;
    if (this.txc != null)
    {
      this.txc.setVisibility(4);
      this.txc.hZ(false);
      this.txc.ia(false);
      if (!"squeezed".equals(cFe()))
      {
        bool = true;
        kq(bool);
        this.txc.setFullscreenMode(false);
      }
    }
    else
    {
      if (this.txU != null) {
        break label357;
      }
      if ((!cFf()) && (!getRuntime().aqJ())) {
        break label338;
      }
      bool = true;
      label90:
      this.txU = new com.tencent.mm.plugin.appbrand.widget.actionbar.e(getContext());
      this.txb.addView(this.txU, new ViewGroup.LayoutParams(-1, -1));
      this.txb.setStatusBarForegroundStyle(bool);
      this.txU.lm(bool);
      this.txU.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(325194);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ah.this.a(ah.this.cEB(), null, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(325194);
        }
      });
      this.txU.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47870);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.appbrand.k.a(ah.this.getAppId(), k.d.qrG);
          ah.k(ah.this).close();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47870);
        }
      });
      if (cEC() != null) {
        this.txU.setMainTitle(cEC().getMainTitle());
      }
      if (getRuntime().getInitConfig().opX == 0) {
        break label353;
      }
      if ((getRuntime().getInitConfig().opX & 0x2) != 2) {
        break label343;
      }
      this.txU.cPb();
    }
    for (;;)
    {
      this.txU.setForwardOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(325196);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bj.a(ah.k(ah.this), ah.this.cEE());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(325196);
        }
      });
      String str2 = this.qts.ccM().epy;
      String str1 = str2;
      if (Util.isNullOrNil(str2))
      {
        str2 = this.qts.ccw();
        str1 = str2;
        if (str2.length() > 5) {
          str1 = String.format("%s...", new Object[] { str2.substring(0, 4) });
        }
      }
      this.txU.setForwardText(getContext().getString(ba.i.appbrand_single_page_mode_forward_title, new Object[] { str1 }));
      AppMethodBeat.o(325241);
      return;
      bool = false;
      break;
      label338:
      bool = false;
      break label90;
      label343:
      this.txU.cPa();
    }
    label353:
    cFm();
    label357:
    AppMethodBeat.o(325241);
  }
  
  private void cFm()
  {
    AppMethodBeat.i(325247);
    Object localObject = getRuntime().getAppConfig().Xk(cgR()).qWA;
    String str = ((b.g)localObject).qWe;
    if (!Util.isNullOrNil(str)) {}
    try
    {
      int i = com.tencent.mm.plugin.appbrand.af.i.agw(str);
      this.txU.setBackgroundColor(i);
      double d = ((b.g)localObject).qWf;
      if (d >= 0.0D) {
        this.txU.setBackgroundAlpha(d);
      }
      localObject = ((b.g)localObject).qWh;
      if (!Util.isNullOrNil((String)localObject)) {
        this.txU.setMainTitle((CharSequence)localObject);
      }
      AppMethodBeat.o(325247);
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
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.appbrand.n.o paramo)
  {
    AppMethodBeat.i(325418);
    if ((getInterceptor() instanceof com.tencent.mm.plugin.appbrand.permission.a))
    {
      locala = (com.tencent.mm.plugin.appbrand.permission.a)getInterceptor();
      if ((locala == null) || (!locala.da(paramString1, paramInt))) {
        break label85;
      }
    }
    for (i = 1;; i = 0)
    {
      try
      {
        paramString2 = super.a(paramString1, paramString2, paramString3, paramInt, paramBoolean, paramo);
        return paramString2;
      }
      finally
      {
        label85:
        if (i == 0) {
          break label105;
        }
        locala.db(paramString1, paramInt);
        AppMethodBeat.o(325418);
      }
      locala = null;
      break;
    }
  }
  
  public void a(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.qts = ((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime);
    if (cbl() == null) {
      b(((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime).cbl());
    }
    super.a(paramContext, paramAppBrandRuntime);
    paramContext = this.txQ;
    paramContext.mAppId = paramAppBrandRuntime.mAppId;
    paramContext.qwG = paramAppBrandRuntime;
    cEC().setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.a(ah.this.getAppId(), ah.this.cgR(), 22, "", Util.nowSecond(), 1, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47864);
      }
    });
    if ((paramAppBrandRuntime.qsQ) && (((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime).ccB())) {
      cEC().setNavButtonLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          ah.this.cFi();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(47871);
          return true;
        }
      });
    }
    setInterceptor(new com.tencent.mm.plugin.appbrand.permission.a((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime, this));
    if (bj.x(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.k.a(paramAppBrandRuntime, new bj.1(paramAppBrandRuntime, paramContext));
      if (this.qts.getInitConfig().aqJ()) {
        cFl();
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
    AppMethodBeat.o(47885);
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(325287);
    if ((cEx() instanceof ag)) {
      ((ag)cEx()).txK.add(paramat);
    }
    AppMethodBeat.o(325287);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175037);
    long l;
    if (paramc == null)
    {
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP;
      if ((this.txW.getContext() == paramc) && (this.txW == this.qwF))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = Util.currentTicks();
      this.txW.bm(paramc);
      super.a(this.txW);
      bm(paramc);
      cFk();
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), cgR(), Boolean.valueOf(isRunning()), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.qwF) != 0)
    {
      l = Util.currentTicks();
      super.a(paramc);
      if ((getRuntime() != null) && (AndroidContextUtil.castActivityOrNull(getRuntime().mContext) != null)) {
        bm(AndroidContextUtil.castActivityOrNull(getRuntime().mContext));
      }
      cFk();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.qwF, paramc, getAppId(), cgR(), Long.valueOf(Util.ticksToNow(l)), android.util.Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  protected final void a(List<com.tencent.mm.plugin.appbrand.menu.w> paramList, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(325398);
    if (this.txS != null) {
      this.txS.cen();
    }
    this.txS = new w(this, paramList);
    this.txS.ap(paramRunnable1);
    this.txS.ar(paramRunnable2);
    this.txS.cem();
    AppMethodBeat.o(325398);
  }
  
  public void arb()
  {
    AppMethodBeat.i(47889);
    a(null);
    super.arb();
    if (this.txO != null) {
      this.txO.release();
    }
    if (this.txP != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.g localg = this.txP;
      localg.dismiss();
      if (localg.uzj != null)
      {
        localg.uzj.removeAllViews();
        localg.uzj = null;
      }
    }
    this.txS = null;
    AppMethodBeat.o(47889);
  }
  
  public void arg()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().ccB()) {
      cFh();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.weishi.h.aD(this.qts)) || (bj.x(getRuntime()))) {
        cEC().ia(true);
      }
      AppMethodBeat.o(47904);
      return;
      super.arg();
    }
  }
  
  public final void ary()
  {
    AppMethodBeat.i(325408);
    super.ary();
    if (aa.f(this))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.f.uTO) {
        break label183;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.n.i locali = getJsRuntime();
      int i = getComponentId();
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(i), getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + i + "')", null);
      locali.evaluateJavascript("xweb.enableNativeTrans()", null);
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + i + "')", null);
      aa.a(getJsRuntime(), getComponentId(), getAppId());
      AppMethodBeat.o(325408);
      return;
      label183:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      ao.bindNativeTrans(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.f.uTO = true;
    }
  }
  
  public final void b(at paramat)
  {
    AppMethodBeat.i(325296);
    if ((cEx() instanceof ag)) {
      ((ag)cEx()).txK.remove(paramat);
    }
    AppMethodBeat.o(325296);
  }
  
  protected final boolean b(View paramView, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(325414);
    if ((this.txm) && (!z.ay(paramView)) && (getRuntime() != null) && (getRuntime().asE()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(325414);
      return true;
    }
    boolean bool = super.b(paramView, paramRunnable, paramLong);
    AppMethodBeat.o(325414);
    return bool;
  }
  
  protected final void bm(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.bm(paramContext);
    if ((cEx() instanceof a))
    {
      localObject = (a)cEx();
      if (((a)localObject).ttr != null) {
        ((a)localObject).ttr.setBaseContext(paramContext);
      }
    }
    if ((cEx() instanceof com.tencent.luggage.game.page.h)) {
      ((com.tencent.luggage.game.page.h)cEx()).bm(paramContext);
    }
    if (this.tti != null) {
      this.tti.bm(paramContext);
    }
    Object localObject = cFg();
    if (localObject != null) {
      ((g.c)localObject).bm(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  public void c(cb paramcb)
  {
    AppMethodBeat.i(325356);
    super.c(paramcb);
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().evw.a(this, c.a.class);
    boolean bool1;
    if ((!((b.d)localObject).qWs) || (!bool2))
    {
      bool1 = true;
      super.cN(bool1);
      if ((bool2) && (((b.d)localObject).qWs) && (getRuntime().getInitConfig().appServiceType == 7) && (!cEC().cOX())) {
        break label206;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((b.d)localObject).qWs + " appServiceType:" + getRuntime().getInitConfig().appServiceType + " isFullscreenMode:" + cEC().cOX());
      label160:
      if (!bj.x(getRuntime())) {
        break label249;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324953);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "customActionBarIfNeed toSinglePageModeActionBar");
          ah.o(ah.this);
          AppMethodBeat.o(324953);
        }
      });
    }
    for (;;)
    {
      getRuntime().qvN.a(this, paramcb);
      AppMethodBeat.o(325356);
      return;
      bool1 = false;
      break;
      label206:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((b.d)localObject).qWr, new com.tencent.mm.plugin.appbrand.widget.tabbar.c()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(324950);
          super.a(paramAnonymousString, paramAnonymousd);
          com.tencent.mm.sdk.platformtools.Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(324950);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).a(new com.tencent.mm.plugin.appbrand.widget.tabbar.e()
      {
        public final void a(Bitmap paramAnonymousBitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramAnonymousd)
        {
          AppMethodBeat.i(324955);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          ah.this.cEC().a(paramAnonymousBitmap, new ah.12.1(this));
          AppMethodBeat.o(324955);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).cSY();
      break label160;
      label249:
      if (com.tencent.mm.plugin.appbrand.weishi.h.aD(getRuntime())) {
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47867);
            if (ah.this.txc != null)
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
              ah.this.txc.setNavResetStyleListener(new b.a()
              {
                public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
                {
                  AppMethodBeat.i(47865);
                  if (paramAnonymous2ImageView != null)
                  {
                    paramAnonymous2ImageView.clearColorFilter();
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] set close button");
                    paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.i(ah.this.getContext().getResources(), ba.h.app_brand_weishi_video_btn_close));
                    paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                    paramAnonymous2View2.height = -1;
                    paramAnonymous2View2.width = -2;
                    paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                  }
                  if (paramAnonymous2View1 != null) {
                    paramAnonymous2View1.setBackground(null);
                  }
                  AppMethodBeat.o(47865);
                }
                
                public final int cDN()
                {
                  return uyR;
                }
              });
              ah.this.txc.setFullscreenMode(true);
              ah.this.txc.setForegroundStyle(false);
              ah.this.txc.hZ(false);
              ah.this.txc.ia(true);
              ah.this.txc.setBackButtonClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(47866);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$10$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] pageview click close button");
                  com.tencent.mm.plugin.appbrand.weishi.h.cOB();
                  if (ah.k(ah.this) != null)
                  {
                    com.tencent.mm.plugin.appbrand.k.a(ah.this.getAppId(), k.d.qrG);
                    ah.k(ah.this).close();
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$10$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(47866);
                }
              });
            }
            if (ah.this.txb != null) {
              ah.this.txb.setForceTopInsetsHeight(ah.this.getContext().getResources().getDimensionPixelSize(ba.d.app_brand_weishi_close_button_margin_top));
            }
            AppMethodBeat.o(47867);
          }
        });
      } else if ((getRuntime() != null) && (getRuntime().ccB())) {
        cFh();
      }
    }
  }
  
  public final boolean c(String paramString, cb paramcb)
  {
    AppMethodBeat.i(325382);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL appId:%s, url:%s, stack:%s", new Object[] { getAppId(), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    com.tencent.mm.plugin.appbrand.report.i locali = this.txQ;
    locali.tPh = Util.nowMilliSecond();
    locali.tPg = paramString;
    a(getRuntime().getWindowAndroid());
    boolean bool = super.c(paramString, paramcb);
    AppMethodBeat.o(325382);
    return bool;
  }
  
  protected void cBp()
  {
    AppMethodBeat.i(47890);
    if (!((com.tencent.mm.plugin.appbrand.widget.recent.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.widget.recent.k.class)).cSP())
    {
      AppMethodBeat.o(47890);
      return;
    }
    if (getRuntime().ccB())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.txO = ((com.tencent.mm.plugin.appbrand.widget.recent.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.widget.recent.k.class)).a(getContext(), k.b.uQz, new k.a()
      {
        public final LocalUsageInfo cFo()
        {
          AppMethodBeat.i(47877);
          if (!ah.this.isRunning())
          {
            AppMethodBeat.o(47877);
            return null;
          }
          LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(ah.this.getRuntime().getInitConfig().username, ah.this.getRuntime().ccM().appId, ah.this.getRuntime().ccM().qYY.qHO, ah.this.getRuntime().ccM().qYY.pkgVersion, ah.this.getRuntime().ccM().hEy, ah.this.getRuntime().ccM().epy, ah.this.getRuntime().ccM().phA, ah.this.getRuntime().ccM().eqh);
          AppMethodBeat.o(47877);
          return localLocalUsageInfo;
        }
      });
      if (this.txO == null)
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
      this.txP = new com.tencent.mm.plugin.appbrand.widget.actionbar.g(getContext());
      this.txP.setWidth(-1);
      this.txP.setBackgroundDrawable(new ColorDrawable());
      this.txO.bDL();
      this.txP.setHeight(this.txO.getLayoutParams().height);
      this.txO.setBackground(com.tencent.mm.cd.a.m(getContext(), ba.e.app_brand_game_recent_popwindow_background));
      this.txP.setContentView(this.txO);
      this.txO.setOnItemClickListener(new AppBrandRecentView.a()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recent.e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(324952);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47878);
              ah.n(ah.this).dismiss();
              AppMethodBeat.o(47878);
            }
          }, 100L);
          if (paramAnonymouse.type == 1)
          {
            paramAnonymousView = paramAnonymouse.uAl;
            paramAnonymouse = new AppBrandStatObject();
            paramAnonymouse.scene = 1090;
            paramAnonymouse.hzx = ah.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.precondition.f.teH.a(ah.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.euz, -1, paramAnonymouse, null, null);
            AppMethodBeat.o(324952);
            return true;
          }
          AppMethodBeat.o(324952);
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
  
  public final List<com.tencent.mm.plugin.appbrand.menu.w> cEA()
  {
    AppMethodBeat.i(47897);
    if (bj.x(getRuntime()))
    {
      bool = getRuntime().aqJ();
      int i = getRuntime().getInitConfig().opX;
      localLinkedList = new LinkedList();
      if (i != 0)
      {
        WxaMenuHelper.a(localLinkedList, x.tku.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, x.tkF.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, x.tkP.ordinal(), true, false);
      }
      for (;;)
      {
        this.qAp = localLinkedList;
        AppMethodBeat.o(47897);
        return localLinkedList;
        WxaMenuHelper.a(localLinkedList, x.tkk.ordinal(), true, true);
        WxaMenuHelper.a(localLinkedList, x.tkl.ordinal(), true, true);
        WxaMenuHelper.a(localLinkedList, x.tkJ.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, x.tkK.ordinal(), true, false);
        WxaMenuHelper.a(localLinkedList, x.tkN.ordinal(), true, true);
        WxaMenuHelper.a(localLinkedList, x.tku.ordinal(), false, false);
        WxaMenuHelper.a(localLinkedList, x.tkF.ordinal(), false, false);
        WxaMenuHelper.a(localLinkedList, x.tkP.ordinal(), false, false);
        if (bool) {
          WxaMenuHelper.a(localLinkedList, x.tkG.ordinal(), false, false);
        }
      }
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, x.tkk.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, x.tkl.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, x.tkJ.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, x.tkt.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, x.tkO.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.d.Ud((String)localObject);
    if ((!CrashReportFactory.hasDebuger()) && ((localObject == null) || (((n)localObject).qYY.qHO == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, x.tks.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, x.tkK.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, x.tkL.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, x.tkN.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, x.tkh.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkj.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkD.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkE.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkr.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkF.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkP.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkI.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkM.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkG.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, x.tkH.ordinal(), false, false);
      this.qAp = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  protected final void cEM()
  {
    AppMethodBeat.i(47899);
    super.cEM();
    Object localObject = this.txQ;
    ((com.tencent.mm.plugin.appbrand.report.model.c)localObject).tPi = (Util.nowMilliSecond() - ((com.tencent.mm.plugin.appbrand.report.model.c)localObject).tPh);
    if (cbl().compareTo(getRuntime().cbl()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), cbl().cfD(), getRuntime().cbl().cfD() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void cEN()
  {
    AppMethodBeat.i(47900);
    super.cEN();
    Object localObject2;
    Object localObject1;
    if (getRuntime().aqJ())
    {
      localObject2 = this.txQ;
      if (getRuntime().qsG)
      {
        localObject1 = getRuntime().cby();
        ((com.tencent.mm.plugin.appbrand.report.i)localObject2).afL((String)localObject1);
      }
    }
    for (;;)
    {
      localObject1 = getRuntime().qsp;
      View.OnLongClickListener local8 = new View.OnLongClickListener()
      {
        private void dC(View paramAnonymousView)
        {
          AppMethodBeat.i(47875);
          if ((ah.m(ah.this) == null) || (ah.m(ah.this).getCount() == 0))
          {
            AppMethodBeat.o(47875);
            return;
          }
          ah.m(ah.this).bDL();
          ah.n(ah.this).showAsDropDown(paramAnonymousView);
          j.a(ah.this.getAppId(), ah.this.cgR(), 21, "", Util.nowSecond(), 1, 0);
          AppMethodBeat.o(47875);
        }
        
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(47874);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          if (com.tencent.mm.plugin.appbrand.k.a.a.F(ah.this.getRuntime()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(47874);
            return true;
          }
          if (!ah.l(ah.this).getAndSet(true))
          {
            ah.this.cBp();
            if (ah.m(ah.this) != null)
            {
              ah.m(ah.this).setRefreshListener(new AppBrandRecentView.d()
              {
                public final void cFn()
                {
                  AppMethodBeat.i(324815);
                  ah.m(ah.this).setRefreshListener(null);
                  ah.8.a(ah.8.this, paramAnonymousView);
                  AppMethodBeat.o(324815);
                }
              });
              ah.m(ah.this).bDL();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(47874);
            return true;
            dC(paramAnonymousView);
          }
        }
      };
      localObject2 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject1).tCd;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("capsuleBarView");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject1).getCapsuleHomeButton().setOnLongClickListener(local8);
      AppMethodBeat.o(47900);
      return;
      localObject1 = getRuntime().ccN().getCurrentUrl();
      break;
      this.txQ.onForeground();
    }
  }
  
  protected final void cEO()
  {
    AppMethodBeat.i(47901);
    super.cEO();
    if (this.txP != null) {
      this.txP.dismiss();
    }
    this.txQ.onBackground();
    AppMethodBeat.o(47901);
  }
  
  protected final void cEP()
  {
    AppMethodBeat.i(47902);
    super.cEP();
    this.txQ.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View cEU()
  {
    AppMethodBeat.i(175036);
    View localView = fc(getContext());
    AppMethodBeat.o(175036);
    return localView;
  }
  
  public final Bitmap cEW()
  {
    AppMethodBeat.i(325339);
    Object localObject1 = (com.tencent.luggage.game.page.d)aa(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.cEW();
      AppMethodBeat.o(325339);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).apS().getMagicBrush().eHE.j(((com.tencent.luggage.game.page.d)localObject1).apS().getVirtualElementId(), -1, true);
      AppMethodBeat.o(325339);
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
  
  public final void cEX()
  {
    AppMethodBeat.i(325415);
    super.cEX();
    if (this.qts == null) {}
    for (String str = "";; str = this.qts.mAppId)
    {
      j.N(str, cgR(), 1);
      AppMethodBeat.o(325415);
      return;
    }
  }
  
  public final void cEZ()
  {
    AppMethodBeat.i(325416);
    super.cEZ();
    if ((this.tti != null) && (this.txg != null)) {
      if (this.qts != null) {
        break label51;
      }
    }
    label51:
    for (String str = "";; str = this.qts.mAppId)
    {
      j.N(str, cgR(), 2);
      AppMethodBeat.o(325416);
      return;
    }
  }
  
  protected final c cFa()
  {
    AppMethodBeat.i(325417);
    d locald = new d(this);
    AppMethodBeat.o(325417);
    return locald;
  }
  
  public final an cFc()
  {
    AppMethodBeat.i(47903);
    if ((cEx() instanceof ag))
    {
      an localan = ((ag)cEx()).cFc();
      AppMethodBeat.o(47903);
      return localan;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  public final g.c cFg()
  {
    AppMethodBeat.i(325366);
    try
    {
      Object localObject = ((View)Objects.requireNonNull(getContentView())).findViewById(ba.f.app_brand_pageview_html_webview);
      if ((localObject instanceof g.c))
      {
        localObject = (g.c)localObject;
        AppMethodBeat.o(325366);
        return localObject;
      }
      AppMethodBeat.o(325366);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(325366);
    }
    return null;
  }
  
  public final void cFi()
  {
    AppMethodBeat.i(47906);
    cEB();
    if ((this.qAp == null) || (this.qAp.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), cgR() });
      AppMethodBeat.o(47906);
      return;
    }
    a(this.qAp, null, null);
    AppMethodBeat.o(47906);
  }
  
  public final void cFj()
  {
    AppMethodBeat.i(325403);
    if (this.txS != null) {
      this.txS.cen();
    }
    AppMethodBeat.o(325403);
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c ccO()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.ara();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  public void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.f(paramJSONObject);
    d(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.Yxh));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTd(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTl(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTh(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTs(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTn(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTo(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTk(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTj(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTq(), paramJSONObject);
    d(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTp()));
    d(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTf()));
    d(paramJSONObject, "useNewXWebCanvasToTFP", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTg()));
    AppMethodBeat.o(47907);
  }
  
  protected final boolean f(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(325413);
    if ((this.txm) && (!z.ay(paramView)) && (getRuntime() != null) && (getRuntime().asE()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(325413);
      return true;
    }
    boolean bool = super.f(paramView, paramRunnable);
    AppMethodBeat.o(325413);
    return bool;
  }
  
  public final View fc(Context paramContext)
  {
    AppMethodBeat.i(325360);
    if (bj.x(getRuntime()))
    {
      AppMethodBeat.o(325360);
      return null;
    }
    paramContext = new AppBrandMenuHeader(paramContext);
    paramContext.setPage(this);
    AppMethodBeat.o(325360);
    return paramContext;
  }
  
  public com.tencent.mm.plugin.appbrand.w getRuntime()
  {
    AppMethodBeat.i(47887);
    com.tencent.mm.plugin.appbrand.w localw = (com.tencent.mm.plugin.appbrand.w)super.aqZ();
    AppMethodBeat.o(47887);
    return localw;
  }
  
  protected final View n(ViewGroup paramViewGroup)
  {
    boolean bool1 = true;
    AppMethodBeat.i(180347);
    if ((this.qts == null) || (!bj.x(this.qts)) || (!(paramViewGroup instanceof RelativeLayout)) || (this.qts.getInitConfig().opX != 0))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.txT == null) {
      this.txT = new am(this.qts.mContext);
    }
    this.txT.setJumpBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(325210);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        bj.a(ah.k(ah.this), ah.this.cEE());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(325210);
      }
    });
    Object localObject = this.txT;
    String str1 = this.qts.getInitConfig().iconUrl;
    String str2 = this.qts.getInitConfig().hEy;
    String str3 = com.tencent.mm.plugin.appbrand.appcache.e.zm(this.qts.ccM().qYY.qHO);
    boolean bool2 = this.qts.getInitConfig().aqJ();
    if (this.qts.getInitConfig().originalFlag == 1) {}
    for (;;)
    {
      ((am)localObject).b(str1, str2, str3, bool2, bool1);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (-getContext().getResources().getDimensionPixelSize(ba.d.app_brand_single_page_mode_footer_corner_size));
      paramViewGroup.addView(this.txT, (ViewGroup.LayoutParams)localObject);
      paramViewGroup = this.txT;
      AppMethodBeat.o(180347);
      return paramViewGroup;
      bool1 = false;
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.qts != null) && (bj.x(this.qts)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.k.a(getAppId(), k.d.qrH);
      this.qts.close();
      AppMethodBeat.o(180348);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(180348);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */