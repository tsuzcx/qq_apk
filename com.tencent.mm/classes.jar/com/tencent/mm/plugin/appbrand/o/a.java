package com.tencent.mm.plugin.appbrand.o;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ap;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "ctx", "Landroid/content/Context;", "baseWindow", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "currentWindowStableInsetBottom", "", "isMonitorWindowInsets", "", "onApplyWindowInsetsListener", "com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1", "getOnApplyWindowInsetsListener", "()Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1;", "onApplyWindowInsetsListener$delegate", "Lkotlin/Lazy;", "applyWindowConfig", "", "initConfig", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "init", "monitorWindowInsets", "monitor", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onApplyWindowInsets", "insets", "Landroid/view/WindowInsets;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "setSoftOrientation", "name", "", "setupWindowLayoutParams", "shouldInLargeScreenCompatMode", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.luggage.sdk.d.f<AppBrandInitConfigWC>, com.tencent.mm.plugin.appbrand.platform.window.g
{
  public static final a mZG;
  private final Context ctx;
  private final com.tencent.mm.plugin.appbrand.q kFk;
  private int mZC;
  private boolean mZD;
  private final kotlin.f mZE;
  private final com.tencent.mm.plugin.appbrand.platform.window.c mZF;
  
  static
  {
    AppMethodBeat.i(228820);
    mZG = new a((byte)0);
    AppMethodBeat.o(228820);
  }
  
  public a(com.tencent.mm.plugin.appbrand.q paramq, Context paramContext, com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(228819);
    this.kFk = paramq;
    this.ctx = paramContext;
    this.mZF = paramc;
    this.mZE = kotlin.g.a(k.SWR, (kotlin.g.a.a)new d(this));
    AppMethodBeat.o(228819);
  }
  
  private final a.d.1 bOo()
  {
    AppMethodBeat.i(228807);
    a.d.1 local1 = (a.d.1)this.mZE.getValue();
    AppMethodBeat.o(228807);
    return local1;
  }
  
  private final void f(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(228804);
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "applyWindowConfig");
    g(paramAppBrandInitConfigWC);
    HalfScreenConfig localHalfScreenConfig = paramAppBrandInitConfigWC.kHL;
    p.g(localHalfScreenConfig, "initConfig.halfScreenConfig");
    paramAppBrandInitConfigWC = this.kFk.brj();
    p.g(paramAppBrandInitConfigWC, "rt.contentView");
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.getParent();
    if (paramAppBrandInitConfigWC == null)
    {
      paramAppBrandInitConfigWC = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(228804);
      throw paramAppBrandInitConfigWC;
    }
    Object localObject = (View)paramAppBrandInitConfigWC;
    if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.lfo))
    {
      Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "closeWhenClickEmptyArea appId:" + this.kFk.getAppId() + " config:" + localHalfScreenConfig);
      paramAppBrandInitConfigWC = (View.OnClickListener)new a.b(this, localHalfScreenConfig);
      ((View)localObject).setOnClickListener(paramAppBrandInitConfigWC);
      localObject = this.kFk.brj();
      if (!localHalfScreenConfig.isEnable()) {
        break label184;
      }
    }
    label184:
    for (paramAppBrandInitConfigWC = (com.tencent.mm.plugin.appbrand.widget.c.a)new a.c(localHalfScreenConfig);; paramAppBrandInitConfigWC = null)
    {
      ((com.tencent.mm.plugin.appbrand.widget.c)localObject).setRoundCornerProvider(paramAppBrandInitConfigWC);
      AppMethodBeat.o(228804);
      return;
      paramAppBrandInitConfigWC = null;
      break;
    }
  }
  
  private final void g(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(228806);
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.kHL;
    p.g(paramAppBrandInitConfigWC, "initConfig.halfScreenConfig");
    if (paramAppBrandInitConfigWC.isEnable())
    {
      paramAppBrandInitConfigWC = new WxaWindowLayoutParams(-1, paramAppBrandInitConfigWC.height - this.mZC);
      paramAppBrandInitConfigWC.gravity = 80;
      this.kFk.getWindowAndroid().a(this.ctx.getResources().getColor(2131101287), (AppBrandRuntime)this.kFk);
      hZ(true);
    }
    for (;;)
    {
      this.kFk.getWindowAndroid().a(paramAppBrandInitConfigWC, (AppBrandRuntime)this.kFk);
      AppMethodBeat.o(228806);
      return;
      paramAppBrandInitConfigWC = new WxaWindowLayoutParams(-1, -1);
      hZ(false);
    }
  }
  
  private final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(228808);
    Object localObject2 = this.kFk.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      Log.w("MicroMsg.AppBrandHalfWindowLayoutManager", "[monitorWindowInsets] runtime context is null!");
      AppMethodBeat.o(228808);
      return;
    }
    if (!paramBoolean)
    {
      this.mZD = false;
      com.tencent.mm.ui.statusbar.c.bt(localObject1).b((com.tencent.mm.ui.statusbar.c.a)bOo());
      AppMethodBeat.o(228808);
      return;
    }
    if (this.mZD)
    {
      AppMethodBeat.o(228808);
      return;
    }
    this.mZD = true;
    localObject2 = ap.bo(localObject1);
    if (localObject2 != null)
    {
      p.g(localObject2, "this");
      onApplyWindowInsets((WindowInsets)localObject2);
    }
    com.tencent.mm.ui.statusbar.c.bt(localObject1).a((com.tencent.mm.ui.statusbar.c.a)bOo());
    AppMethodBeat.o(228808);
  }
  
  private final void onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(228809);
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onApplyWindowInsets insets=" + paramWindowInsets + ", currentWindowStableInsetBottom=" + this.mZC);
    if (this.mZC != paramWindowInsets.getStableInsetBottom())
    {
      this.mZC = paramWindowInsets.getStableInsetBottom();
      paramWindowInsets = this.kFk.bsC();
      p.g(paramWindowInsets, "rt.initConfig");
      g(paramWindowInsets);
    }
    AppMethodBeat.o(228809);
  }
  
  public final boolean OD()
  {
    return false;
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(228805);
    HalfScreenConfig localHalfScreenConfig = this.kFk.bsC().kHL;
    boolean bool1 = localHalfScreenConfig.isEnable();
    boolean bool2 = localHalfScreenConfig.kuZ;
    AppMethodBeat.o(228805);
    return bool2 & bool1;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(228815);
    paramb = this.mZF.a(paramb);
    p.g(paramb, "baseWindow.createFullscreenHandler(provider)");
    AppMethodBeat.o(228815);
    return paramb;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(228810);
    p.h(paramb, "appConfig");
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onAppConfigGot");
    AppMethodBeat.o(228810);
  }
  
  public final e getOrientationHandler()
  {
    AppMethodBeat.i(228812);
    e locale = this.mZF.getOrientationHandler();
    p.g(locale, "baseWindow.orientationHandler");
    AppMethodBeat.o(228812);
    return locale;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(228816);
    float f = this.mZF.getScale();
    AppMethodBeat.o(228816);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(228814);
    if (this.kFk.bsC().kHL.isEnable())
    {
      localc = new c.c();
      localc.height = 0;
      localc.visibility = 8;
      AppMethodBeat.o(228814);
      return localc;
    }
    c.c localc = this.mZF.getStatusBar();
    AppMethodBeat.o(228814);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(228813);
    if (this.kFk.bsC().kHL.isEnable())
    {
      localDisplayMetrics = new DisplayMetrics();
      Resources localResources = this.ctx.getResources();
      p.g(localResources, "ctx.resources");
      localDisplayMetrics.setTo(localResources.getDisplayMetrics());
      localDisplayMetrics.heightPixels = this.kFk.bsC().kHL.height;
      AppMethodBeat.o(228813);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.mZF.getVDisplayMetrics();
    p.g(localDisplayMetrics, "baseWindow.vDisplayMetrics");
    AppMethodBeat.o(228813);
    return localDisplayMetrics;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(228803);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(228803);
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(228817);
    this.mZF.setSoftOrientation(paramString);
    AppMethodBeat.o(228817);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1;"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<1>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.a
 * JD-Core Version:    0.7.0.1
 */