package com.tencent.mm.plugin.appbrand.widget.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import com.tencent.luggage.sdk.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.d.a.c.b;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "ctx", "Landroid/content/Context;", "baseWindow", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "currentWindowStableInsetBottom", "", "currentWindowStableInsetRight", "isMonitorWindowInsets", "", "lastOrientation", "onApplyWindowInsetsListener", "com/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1", "getOnApplyWindowInsetsListener", "()Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1;", "onApplyWindowInsetsListener$delegate", "Lkotlin/Lazy;", "setupGestureController", "wxaHalfScreenEmptyAreaClickHandler", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenEmptyAreaClickHandler;", "applyWindowConfig", "", "initConfig", "reason", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$ReasonConfigHalfScreen;", "configGesture", "halfScreenConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "configHalfScreenConfig", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "init", "isLargeScreenWindow", "makeLayoutParams", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "isLandScape", "monitorWindowInsets", "monitor", "navigationBarHeightToConsume", "navigationBarWidthToConsume", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onApplyWindowInsets", "insets", "Landroid/view/WindowInsets;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "setSoftOrientation", "name", "", "shouldInLargeScreenCompatMode", "Companion", "ReasonConfigHalfScreen", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f<AppBrandInitConfigWC>, com.tencent.mm.plugin.appbrand.platform.window.g
{
  public static final a.a uDm;
  private final Context ctx;
  private int lastOrientation;
  private final w qxY;
  private final com.tencent.mm.plugin.appbrand.platform.window.c uDn;
  private int uDo;
  private int uDp;
  private boolean uDq;
  private e uDr;
  private volatile boolean uDs;
  private final j uDt;
  
  static
  {
    AppMethodBeat.i(324413);
    uDm = new a.a((byte)0);
    AppMethodBeat.o(324413);
  }
  
  public a(w paramw, Context paramContext, com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(324306);
    this.qxY = paramw;
    this.ctx = paramContext;
    this.uDn = paramc;
    this.uDr = new e(this.qxY);
    this.uDt = kotlin.k.a(o.aiuH, (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(324306);
  }
  
  private final WxaWindowLayoutParams a(HalfScreenConfig paramHalfScreenConfig, boolean paramBoolean)
  {
    int j = -1;
    AppMethodBeat.i(324363);
    int k;
    if (paramBoolean)
    {
      if ((paramHalfScreenConfig.qZX == -2) || (paramHalfScreenConfig.qZX == -1))
      {
        i = -1;
        k = i;
        if (paramHalfScreenConfig.rac == HalfScreenConfig.g.raA) {
          k = i - MMApplicationContext.getResources().getDimensionPixelOffset(ba.d.DefaultActionbarHeight);
        }
        if (paramHalfScreenConfig.qZY != -1) {
          break label162;
        }
        i = j;
      }
      for (;;)
      {
        paramHalfScreenConfig = new WxaWindowLayoutParams(i, k);
        paramHalfScreenConfig.gravity = 85;
        Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "[makeLayoutParams] height=[" + paramHalfScreenConfig.height + "]  width=[" + paramHalfScreenConfig.width + "]  isLandScape=[" + paramBoolean + ']');
        AppMethodBeat.o(324363);
        return paramHalfScreenConfig;
        i = Math.min(paramHalfScreenConfig.qZX, bf.bf(MMApplicationContext.getContext()).y);
        break;
        label162:
        if (paramHalfScreenConfig.qZY == -2) {
          i = bf.bf(MMApplicationContext.getContext()).x * 3 / 4 - d(paramHalfScreenConfig);
        } else {
          i = Math.min(paramHalfScreenConfig.qZY, bf.bf(MMApplicationContext.getContext()).x) - d(paramHalfScreenConfig);
        }
      }
    }
    if (paramHalfScreenConfig.height == -1)
    {
      i = -1;
      label230:
      k = i;
      if (paramHalfScreenConfig.rac == HalfScreenConfig.g.raA) {
        k = i - MMApplicationContext.getResources().getDimensionPixelOffset(ba.d.DefaultActionbarHeight);
      }
      i = j;
      if (paramHalfScreenConfig.width != -1) {
        if (paramHalfScreenConfig.width != -2) {
          break label357;
        }
      }
    }
    label357:
    for (int i = j;; i = Math.min(paramHalfScreenConfig.width, bf.bf(MMApplicationContext.getContext()).x))
    {
      paramHalfScreenConfig = new WxaWindowLayoutParams(i, k);
      paramHalfScreenConfig.gravity = 81;
      break;
      if (paramHalfScreenConfig.height == -2)
      {
        i = bf.bf(MMApplicationContext.getContext()).y * 3 / 4 - c(paramHalfScreenConfig);
        break label230;
      }
      i = Math.min(paramHalfScreenConfig.height, bf.bf(MMApplicationContext.getContext()).y) - c(paramHalfScreenConfig);
      break label230;
    }
  }
  
  private final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, a.b paramb)
  {
    AppMethodBeat.i(324316);
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "applyWindowConfig");
    b(paramAppBrandInitConfigWC, paramb);
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.qAT;
    s.s(paramAppBrandInitConfigWC, "initConfig.halfScreenConfig");
    paramb = this.qxY.qvN.uDE;
    if (paramb != null) {
      paramb.a((com.tencent.mm.plugin.appbrand.widget.k)this.uDr);
    }
    paramb = this.qxY.qsk;
    if (paramAppBrandInitConfigWC.isEnable()) {}
    for (paramAppBrandInitConfigWC = new a..ExternalSyntheticLambda0(paramAppBrandInitConfigWC);; paramAppBrandInitConfigWC = null)
    {
      paramb.setRoundCornerProvider(paramAppBrandInitConfigWC);
      AppMethodBeat.o(324316);
      return;
    }
  }
  
  private static final float[] a(HalfScreenConfig paramHalfScreenConfig, Context paramContext)
  {
    float f9 = 0.0F;
    float f8 = 0.0F;
    AppMethodBeat.i(324397);
    s.u(paramHalfScreenConfig, "$config");
    paramHalfScreenConfig = paramHalfScreenConfig.qZL;
    s.s(paramContext, "context");
    s.u(paramContext, "context");
    float f1;
    float f2;
    label76:
    float f3;
    label89:
    float f4;
    label102:
    float f5;
    label115:
    float f6;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      if (paramHalfScreenConfig.raj)
      {
        f1 = paramHalfScreenConfig.dwJ;
        if (!paramHalfScreenConfig.raj) {
          break label210;
        }
        f2 = paramHalfScreenConfig.dwJ;
        if (!paramHalfScreenConfig.ral) {
          break label215;
        }
        f3 = paramHalfScreenConfig.dwJ;
        if (!paramHalfScreenConfig.ral) {
          break label221;
        }
        f4 = paramHalfScreenConfig.dwJ;
        if (!paramHalfScreenConfig.rak) {
          break label227;
        }
        f5 = paramHalfScreenConfig.dwJ;
        if (!paramHalfScreenConfig.rak) {
          break label233;
        }
        f6 = paramHalfScreenConfig.dwJ;
        label128:
        if (!paramHalfScreenConfig.rai) {
          break label239;
        }
      }
      label210:
      label215:
      label221:
      label227:
      label233:
      label239:
      for (f7 = paramHalfScreenConfig.dwJ;; f7 = 0.0F)
      {
        if (paramHalfScreenConfig.rai) {
          f8 = paramHalfScreenConfig.dwJ;
        }
        AppMethodBeat.o(324397);
        return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
        f1 = 0.0F;
        break;
        f2 = 0.0F;
        break label76;
        f3 = 0.0F;
        break label89;
        f4 = 0.0F;
        break label102;
        f5 = 0.0F;
        break label115;
        f6 = 0.0F;
        break label128;
      }
    }
    if (paramHalfScreenConfig.rai)
    {
      f1 = paramHalfScreenConfig.dwJ;
      if (!paramHalfScreenConfig.rai) {
        break label407;
      }
      f2 = paramHalfScreenConfig.dwJ;
      label269:
      if (!paramHalfScreenConfig.raj) {
        break label412;
      }
      f3 = paramHalfScreenConfig.dwJ;
      label282:
      if (!paramHalfScreenConfig.raj) {
        break label418;
      }
      f4 = paramHalfScreenConfig.dwJ;
      label295:
      if (!paramHalfScreenConfig.ral) {
        break label424;
      }
      f5 = paramHalfScreenConfig.dwJ;
      label308:
      if (!paramHalfScreenConfig.ral) {
        break label430;
      }
      f6 = paramHalfScreenConfig.dwJ;
      label321:
      if (!paramHalfScreenConfig.rak) {
        break label436;
      }
    }
    label407:
    label412:
    label418:
    label424:
    label430:
    label436:
    for (float f7 = paramHalfScreenConfig.dwJ;; f7 = 0.0F)
    {
      f8 = f9;
      if (paramHalfScreenConfig.rak) {
        f8 = paramHalfScreenConfig.dwJ;
      }
      AppMethodBeat.o(324397);
      return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label269;
      f3 = 0.0F;
      break label282;
      f4 = 0.0F;
      break label295;
      f5 = 0.0F;
      break label308;
      f6 = 0.0F;
      break label321;
    }
  }
  
  private final void b(WindowInsets paramWindowInsets)
  {
    int j = 1;
    AppMethodBeat.i(324389);
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onApplyWindowInsets insets=" + paramWindowInsets + ", currentWindowStableInsetBottom=" + this.uDo);
    int i = 0;
    if (this.uDo != paramWindowInsets.getStableInsetBottom())
    {
      this.uDo = paramWindowInsets.getStableInsetBottom();
      i = 1;
    }
    if (this.uDp != paramWindowInsets.getStableInsetRight())
    {
      this.uDp = paramWindowInsets.getStableInsetRight();
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramWindowInsets = this.qxY.getInitConfig();
        s.s(paramWindowInsets, "rt.initConfig");
        b(paramWindowInsets, a.b.uDu);
      }
      AppMethodBeat.o(324389);
      return;
    }
  }
  
  private final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, a.b paramb)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(324333);
    HalfScreenConfig localHalfScreenConfig = paramAppBrandInitConfigWC.qAT;
    s.s(localHalfScreenConfig, "initConfig.halfScreenConfig");
    if (localHalfScreenConfig.isEnable())
    {
      if (AndroidContextUtil.castActivityOrNull(this.qxY.mContext) == null)
      {
        AppMethodBeat.o(324333);
        return;
      }
      paramAppBrandInitConfigWC = AndroidContextUtil.castActivityOrNull(this.qxY.mContext);
      s.checkNotNull(paramAppBrandInitConfigWC);
      if (paramAppBrandInitConfigWC.getResources().getConfiguration().orientation == 2) {
        bool1 = true;
      }
      paramAppBrandInitConfigWC = a(localHalfScreenConfig, bool1);
      if (this.qxY.qvN.cQd())
      {
        if (!this.uDs)
        {
          localObject1 = this.qxY.qsk;
          Object localObject2 = g.uEg;
          localObject2 = g.a.ac(this.qxY);
          this.qxY.qvN.uDE = ((l)localObject2);
          ah localah = ah.aiuX;
          ((com.tencent.mm.plugin.appbrand.widget.e)localObject1).setWxaHalfScreenGestureController((l)localObject2);
          this.uDs = true;
        }
        Object localObject1 = this.qxY.qvN.uDE;
        if (localObject1 != null) {
          ((l)localObject1).DV(paramAppBrandInitConfigWC.height);
        }
        e(localHalfScreenConfig);
      }
      if ((localHalfScreenConfig.rac == HalfScreenConfig.g.raA) && (this.qxY.qvN.uDF.cQu() != c.b.uEB))
      {
        this.qxY.qvN.a((com.tencent.mm.plugin.appbrand.widget.d.a.c)new com.tencent.mm.plugin.appbrand.widget.d.a.b(this.qxY, this.ctx.getResources().getColor(ba.c.UN_BW_0_Alpha_0_4)));
        if (paramb != a.b.uDu)
        {
          if (!localHalfScreenConfig.qZV) {
            break label436;
          }
          this.qxY.qvN.uDF.reset();
        }
        label297:
        this.qxY.getWindowAndroid().a(this.ctx.getResources().getColor(ba.c.transparent), (AppBrandRuntime)this.qxY);
      }
    }
    for (bool1 = bool2;; bool1 = false)
    {
      this.qxY.getWindowAndroid().a(paramAppBrandInitConfigWC, (AppBrandRuntime)this.qxY);
      lt(bool1);
      AppMethodBeat.o(324333);
      return;
      if ((localHalfScreenConfig.rac != HalfScreenConfig.g.raz) || (this.qxY.qvN.uDF.cQu() == c.b.uEA)) {
        break;
      }
      this.qxY.qvN.a((com.tencent.mm.plugin.appbrand.widget.d.a.c)new com.tencent.mm.plugin.appbrand.widget.d.a.a(this.qxY, this.ctx.getResources().getColor(ba.c.UN_BW_0_Alpha_0_4)));
      break;
      label436:
      this.qxY.qvN.uDF.cQs();
      break label297;
      this.qxY.qsk.setWxaHalfScreenGestureController(null);
      this.qxY.qvN.uDE = null;
      paramAppBrandInitConfigWC = this.qxY.qvN;
      paramb = com.tencent.mm.plugin.appbrand.widget.d.a.c.uEw;
      paramAppBrandInitConfigWC.a(com.tencent.mm.plugin.appbrand.widget.d.a.c.a.cQv());
      this.uDs = false;
      paramAppBrandInitConfigWC = new WxaWindowLayoutParams(-1, -1);
    }
  }
  
  private final int c(HalfScreenConfig paramHalfScreenConfig)
  {
    if (paramHalfScreenConfig.rab) {
      return this.uDo;
    }
    return 0;
  }
  
  private final a.c.1 cPV()
  {
    AppMethodBeat.i(324369);
    a.c.1 local1 = (a.c.1)this.uDt.getValue();
    AppMethodBeat.o(324369);
    return local1;
  }
  
  private final int d(HalfScreenConfig paramHalfScreenConfig)
  {
    if (paramHalfScreenConfig.rab) {
      return this.uDp;
    }
    return 0;
  }
  
  private final void e(HalfScreenConfig paramHalfScreenConfig)
  {
    boolean bool2 = true;
    AppMethodBeat.i(324352);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.qxY.mContext);
    s.checkNotNull(localObject);
    int i;
    boolean bool1;
    if (((Activity)localObject).getResources().getConfiguration().orientation == 2)
    {
      i = 1;
      localObject = this.qxY.qvN.uDE;
      if (localObject != null)
      {
        if ((i != 0) || (!paramHalfScreenConfig.qZO)) {
          break label106;
        }
        bool1 = true;
        label73:
        if ((i != 0) || (!paramHalfScreenConfig.qZT)) {
          break label111;
        }
      }
    }
    for (;;)
    {
      ((l)localObject).G(bool1, bool2);
      AppMethodBeat.o(324352);
      return;
      i = 0;
      break;
      label106:
      bool1 = false;
      break label73;
      label111:
      bool2 = false;
    }
  }
  
  private final void lt(boolean paramBoolean)
  {
    AppMethodBeat.i(324377);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.qxY.mContext);
    if ((localActivity instanceof Activity)) {}
    while (localActivity == null)
    {
      Log.w("MicroMsg.AppBrandHalfWindowLayoutManager", "[monitorWindowInsets] runtime context is null!");
      AppMethodBeat.o(324377);
      return;
      localActivity = null;
    }
    if (!paramBoolean)
    {
      this.uDq = false;
      com.tencent.mm.ui.statusbar.c.ch(localActivity).b((com.tencent.mm.ui.statusbar.c.a)cPV());
      AppMethodBeat.o(324377);
      return;
    }
    if (this.uDq)
    {
      AppMethodBeat.o(324377);
      return;
    }
    this.uDq = true;
    WindowInsets localWindowInsets = ay.bY(localActivity);
    if (localWindowInsets != null) {
      b(localWindowInsets);
    }
    com.tencent.mm.ui.statusbar.c.ch(localActivity).a((com.tencent.mm.ui.statusbar.c.a)cPV());
    AppMethodBeat.o(324377);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(324452);
    paramb = this.uDn.a(paramb);
    s.s(paramb, "baseWindow.createFullscreenHandler(provider)");
    AppMethodBeat.o(324452);
    return paramb;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.config.b paramb)
  {
    AppMethodBeat.i(324433);
    s.u(paramb, "appConfig");
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onAppConfigGot");
    AppMethodBeat.o(324433);
  }
  
  public final boolean asq()
  {
    return false;
  }
  
  public final boolean ast()
  {
    AppMethodBeat.i(324426);
    HalfScreenConfig localHalfScreenConfig = this.qxY.getInitConfig().qAT;
    boolean bool1 = localHalfScreenConfig.isEnable();
    boolean bool2 = localHalfScreenConfig.qkq;
    AppMethodBeat.o(324426);
    return bool2 & bool1;
  }
  
  public final boolean asu()
  {
    AppMethodBeat.i(324429);
    boolean bool = this.uDn.asu();
    AppMethodBeat.o(324429);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(324436);
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.uDn.getOrientationHandler();
    s.s(locale, "baseWindow.orientationHandler");
    AppMethodBeat.o(324436);
    return locale;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(324455);
    float f = this.uDn.getScale();
    AppMethodBeat.o(324455);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(324445);
    if (this.qxY.getInitConfig().qAT.isEnable())
    {
      localc = new c.c();
      localc.height = 0;
      localc.visibility = 8;
      AppMethodBeat.o(324445);
      return localc;
    }
    c.c localc = this.uDn.getStatusBar();
    AppMethodBeat.o(324445);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(324440);
    if (this.qxY.getInitConfig().qAT.isEnable())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.ctx.getResources().getDisplayMetrics());
      localDisplayMetrics.heightPixels = this.qxY.getInitConfig().qAT.height;
      AppMethodBeat.o(324440);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.uDn.getVDisplayMetrics();
    s.s(localDisplayMetrics, "baseWindow.vDisplayMetrics");
    AppMethodBeat.o(324440);
    return localDisplayMetrics;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool2 = false;
    AppMethodBeat.i(324422);
    s.u(paramConfiguration, "newConfig");
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onConfigurationChanged  new[" + paramConfiguration.orientation + "]  last[" + this.lastOrientation + ']');
    if (paramConfiguration.orientation == this.lastOrientation)
    {
      AppMethodBeat.o(324422);
      return;
    }
    if (this.qxY.ccX())
    {
      bool1 = bool2;
      switch (paramConfiguration.orientation)
      {
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      Object localObject = this.qxY.getWindowAndroid();
      HalfScreenConfig localHalfScreenConfig = this.qxY.getInitConfig().qAT;
      s.s(localHalfScreenConfig, "rt.initConfig.halfScreenConfig");
      ((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).a(a(localHalfScreenConfig, bool1), (AppBrandRuntime)this.qxY);
      localObject = this.qxY.getInitConfig().qAT;
      s.s(localObject, "rt.initConfig.halfScreenConfig");
      e((HalfScreenConfig)localObject);
      this.lastOrientation = paramConfiguration.orientation;
      AppMethodBeat.o(324422);
      return;
    }
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(324460);
    this.uDn.setSoftOrientation(paramString);
    AppMethodBeat.o(324460);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<1>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a
 * JD-Core Version:    0.7.0.1
 */