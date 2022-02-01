package com.tencent.mm.plugin.appbrand.widget.c;

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
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.statusbar.c.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "ctx", "Landroid/content/Context;", "baseWindow", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "currentWindowStableInsetBottom", "", "isMonitorWindowInsets", "", "onApplyWindowInsetsListener", "com/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1", "getOnApplyWindowInsetsListener", "()Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1;", "onApplyWindowInsetsListener$delegate", "Lkotlin/Lazy;", "setupGestureController", "applyWindowConfig", "", "initConfig", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "init", "isLargeScreenWindow", "monitorWindowInsets", "monitor", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onApplyWindowInsets", "insets", "Landroid/view/WindowInsets;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "setSoftOrientation", "name", "", "setupWindowLayoutParams", "shouldInLargeScreenCompatMode", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.luggage.sdk.e.f<AppBrandInitConfigWC>, com.tencent.mm.plugin.appbrand.platform.window.g
{
  public static final a.a rsR;
  private final Context ctx;
  private final com.tencent.mm.plugin.appbrand.t nyQ;
  private int rsM;
  private boolean rsN;
  private volatile boolean rsO;
  private final kotlin.f rsP;
  private final com.tencent.mm.plugin.appbrand.platform.window.c rsQ;
  
  static
  {
    AppMethodBeat.i(271007);
    rsR = new a.a((byte)0);
    AppMethodBeat.o(271007);
  }
  
  public a(com.tencent.mm.plugin.appbrand.t paramt, Context paramContext, com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(271006);
    this.nyQ = paramt;
    this.ctx = paramContext;
    this.rsQ = paramc;
    this.rsP = kotlin.g.a(k.aazD, (kotlin.g.a.a)new d(this));
    AppMethodBeat.o(271006);
  }
  
  private final void b(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(270988);
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onApplyWindowInsets insets=" + paramWindowInsets + ", currentWindowStableInsetBottom=" + this.rsM);
    if (this.rsM != paramWindowInsets.getStableInsetBottom())
    {
      this.rsM = paramWindowInsets.getStableInsetBottom();
      paramWindowInsets = this.nyQ.bDy();
      p.j(paramWindowInsets, "rt.initConfig");
      k(paramWindowInsets);
    }
    AppMethodBeat.o(270988);
  }
  
  private final a.d.1 cnK()
  {
    AppMethodBeat.i(270984);
    a.d.1 local1 = (a.d.1)this.rsP.getValue();
    AppMethodBeat.o(270984);
    return local1;
  }
  
  private final void j(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(270980);
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "applyWindowConfig");
    k(paramAppBrandInitConfigWC);
    HalfScreenConfig localHalfScreenConfig = paramAppBrandInitConfigWC.nBE;
    p.j(localHalfScreenConfig, "initConfig.halfScreenConfig");
    paramAppBrandInitConfigWC = this.nyQ.bBZ();
    p.j(paramAppBrandInitConfigWC, "rt.contentView");
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.getParent();
    if (paramAppBrandInitConfigWC == null)
    {
      paramAppBrandInitConfigWC = new kotlin.t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(270980);
      throw paramAppBrandInitConfigWC;
    }
    Object localObject = (View)paramAppBrandInitConfigWC;
    if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.nZA))
    {
      Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "closeWhenClickEmptyArea appId:" + this.nyQ.getAppId() + " config:" + localHalfScreenConfig);
      paramAppBrandInitConfigWC = (View.OnClickListener)new a.b(this, localHalfScreenConfig);
      ((View)localObject).setOnClickListener(paramAppBrandInitConfigWC);
      localObject = this.nyQ.bBZ();
      if (!localHalfScreenConfig.isEnable()) {
        break label186;
      }
    }
    label186:
    for (paramAppBrandInitConfigWC = (d.a)new a.c(localHalfScreenConfig);; paramAppBrandInitConfigWC = null)
    {
      ((com.tencent.mm.plugin.appbrand.widget.d)localObject).setRoundCornerProvider(paramAppBrandInitConfigWC);
      AppMethodBeat.o(270980);
      return;
      paramAppBrandInitConfigWC = null;
      break;
    }
  }
  
  private final void k(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(270983);
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.nBE;
    p.j(paramAppBrandInitConfigWC, "initConfig.halfScreenConfig");
    int i;
    if (paramAppBrandInitConfigWC.isEnable()) {
      if (paramAppBrandInitConfigWC.height == -1)
      {
        i = -1;
        if ((paramAppBrandInitConfigWC.nZE) && (i != -1))
        {
          if (!this.rsO)
          {
            paramAppBrandInitConfigWC = this.nyQ.bBZ();
            Object localObject = i.rtx;
            localObject = i.a.T(this.nyQ);
            this.nyQ.bDM().rta = ((com.tencent.mm.plugin.appbrand.widget.i)localObject);
            paramAppBrandInitConfigWC.setWxaHalfScreenGestureController((com.tencent.mm.plugin.appbrand.widget.i)localObject);
            this.rsO = true;
          }
          paramAppBrandInitConfigWC = this.nyQ.bDM().rta;
          if (paramAppBrandInitConfigWC != null) {
            paramAppBrandInitConfigWC.Dw(i);
          }
        }
        paramAppBrandInitConfigWC = new WxaWindowLayoutParams(-1, i);
        paramAppBrandInitConfigWC.gravity = 80;
        this.nyQ.getWindowAndroid().a(this.ctx.getResources().getColor(au.c.transparent), (AppBrandRuntime)this.nyQ);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.nyQ.getWindowAndroid().a(paramAppBrandInitConfigWC, (AppBrandRuntime)this.nyQ);
      kj(bool);
      AppMethodBeat.o(270983);
      return;
      i = paramAppBrandInitConfigWC.height - this.rsM;
      break;
      this.nyQ.bBZ().setWxaHalfScreenGestureController(null);
      this.nyQ.bDM().rta = null;
      this.rsO = false;
      paramAppBrandInitConfigWC = new WxaWindowLayoutParams(-1, -1);
    }
  }
  
  private final void kj(boolean paramBoolean)
  {
    AppMethodBeat.i(270986);
    Object localObject2 = this.nyQ.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      Log.w("MicroMsg.AppBrandHalfWindowLayoutManager", "[monitorWindowInsets] runtime context is null!");
      AppMethodBeat.o(270986);
      return;
    }
    if (!paramBoolean)
    {
      this.rsN = false;
      com.tencent.mm.ui.statusbar.c.bA(localObject1).b((c.a)cnK());
      AppMethodBeat.o(270986);
      return;
    }
    if (this.rsN)
    {
      AppMethodBeat.o(270986);
      return;
    }
    this.rsN = true;
    localObject2 = as.bu(localObject1);
    if (localObject2 != null)
    {
      p.j(localObject2, "this");
      b((WindowInsets)localObject2);
    }
    com.tencent.mm.ui.statusbar.c.bA(localObject1).a((c.a)cnK());
    AppMethodBeat.o(270986);
  }
  
  public final boolean RZ()
  {
    return false;
  }
  
  public final boolean Sc()
  {
    AppMethodBeat.i(270981);
    HalfScreenConfig localHalfScreenConfig = this.nyQ.bDy().nBE;
    boolean bool1 = localHalfScreenConfig.isEnable();
    boolean bool2 = localHalfScreenConfig.nnk;
    AppMethodBeat.o(270981);
    return bool2 & bool1;
  }
  
  public final boolean Sd()
  {
    AppMethodBeat.i(270982);
    boolean bool = this.rsQ.Sd();
    AppMethodBeat.o(270982);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(271001);
    paramb = this.rsQ.a(paramb);
    p.j(paramb, "baseWindow.createFullscreenHandler(provider)");
    AppMethodBeat.o(271001);
    return paramb;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(270991);
    p.k(paramb, "appConfig");
    Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onAppConfigGot");
    AppMethodBeat.o(270991);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(270995);
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.rsQ.getOrientationHandler();
    p.j(locale, "baseWindow.orientationHandler");
    AppMethodBeat.o(270995);
    return locale;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(271003);
    float f = this.rsQ.getScale();
    AppMethodBeat.o(271003);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(270999);
    if (this.nyQ.bDy().nBE.isEnable())
    {
      localc = new c.c();
      localc.height = 0;
      localc.visibility = 8;
      AppMethodBeat.o(270999);
      return localc;
    }
    c.c localc = this.rsQ.getStatusBar();
    AppMethodBeat.o(270999);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(270997);
    if (this.nyQ.bDy().nBE.isEnable())
    {
      localDisplayMetrics = new DisplayMetrics();
      Resources localResources = this.ctx.getResources();
      p.j(localResources, "ctx.resources");
      localDisplayMetrics.setTo(localResources.getDisplayMetrics());
      localDisplayMetrics.heightPixels = this.nyQ.bDy().nBE.height;
      AppMethodBeat.o(270997);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.rsQ.getVDisplayMetrics();
    p.j(localDisplayMetrics, "baseWindow.vDisplayMetrics");
    AppMethodBeat.o(270997);
    return localDisplayMetrics;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(270979);
    p.k(paramConfiguration, "newConfig");
    AppMethodBeat.o(270979);
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(271004);
    this.rsQ.setSoftOrientation(paramString);
    AppMethodBeat.o(271004);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$onApplyWindowInsetsListener$2$1;"})
  static final class d
    extends q
    implements kotlin.g.a.a<1>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.a
 * JD-Core Version:    0.7.0.1
 */