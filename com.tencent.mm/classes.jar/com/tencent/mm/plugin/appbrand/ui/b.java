package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Build;
import com.tencent.luggage.k.j;
import com.tencent.luggage.sdk.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.vendor.HuaweiKt;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCenterInsideWindowLayoutManagerWc;", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "base", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "isBlacklisting", "", "Ljava/lang/Boolean;", "mayDisableInHuaWeiDevices", "checkIsBlackListing", "blackList", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "shouldInLargeScreenCompatMode", "plugin-appbrand-integration_release"})
public final class b
  extends a<AppBrandInitConfigWC>
{
  private final c qGE;
  private Boolean qTQ;
  private Boolean qTR;
  
  public b(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame, c paramc)
  {
    super(paramAppBrandRuntime, paramContext, parame);
    AppMethodBeat.i(278788);
    this.qGE = paramc;
    AppMethodBeat.o(278788);
  }
  
  public final boolean RZ()
  {
    AppMethodBeat.i(278786);
    Object localObject1;
    if (this.cCk != null)
    {
      localObject1 = this.cCk;
      if (localObject1 == null) {
        p.iCn();
      }
      if (!((AppBrandInitConfigWC)localObject1).nYb)
      {
        localObject1 = this.cCk;
        if (localObject1 == null) {
          p.iCn();
        }
        if (!((AppBrandInitConfigWC)localObject1).Qv()) {}
      }
      else
      {
        AppMethodBeat.o(278786);
        return false;
      }
    }
    if (RY())
    {
      AppMethodBeat.o(278786);
      return false;
    }
    Object localObject2;
    if (this.qTR == null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEE, "null");
      p.j(localObject1, "MMKernel.service(IExptSe…_mode_black_list, \"null\")");
      localObject2 = Locale.US;
      p.j(localObject2, "Locale.US");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(278786);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((String)localObject1).toLowerCase((Locale)localObject2);
      p.j(localObject1, "(this as java.lang.String).toLowerCase(locale)");
      localObject1 = n.a((CharSequence)localObject1, new String[] { ";" });
      if (!((List)localObject1).contains("all")) {
        break label216;
      }
      bool = true;
    }
    for (;;)
    {
      this.qTR = Boolean.valueOf(bool);
      localObject1 = this.qTR;
      if (localObject1 == null) {
        p.iCn();
      }
      if (!((Boolean)localObject1).booleanValue()) {
        break;
      }
      AppMethodBeat.o(278786);
      return false;
      label216:
      if (!((List)localObject1).contains("null"))
      {
        localObject2 = Build.MODEL;
        p.j(localObject2, "Build.MODEL");
        Locale localLocale = Locale.US;
        p.j(localLocale, "Locale.US");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(278786);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject2).toLowerCase(localLocale);
        p.j(localObject2, "(this as java.lang.String).toLowerCase(locale)");
        if (((List)localObject1).contains(localObject2))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
    if (this.qTQ == null) {
      if ((!HuaweiKt.hasHuaweiMagicWindowFeature()) || (j.cEc.SJ())) {
        break label361;
      }
    }
    label361:
    for (boolean bool = true;; bool = false)
    {
      this.qTQ = Boolean.valueOf(bool);
      localObject1 = this.qTQ;
      if (localObject1 == null) {
        p.iCn();
      }
      if (!((Boolean)localObject1).booleanValue()) {
        break;
      }
      AppMethodBeat.o(278786);
      return false;
    }
    if (j.cEc.SJ())
    {
      AppMethodBeat.o(278786);
      return true;
    }
    bool = super.RZ();
    AppMethodBeat.o(278786);
    return bool;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(278787);
    c.c localc = this.qGE.getStatusBar();
    AppMethodBeat.o(278787);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */