package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Build;
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCenterInsideWindowLayoutManagerWc;", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "base", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "isBlacklisting", "", "Ljava/lang/Boolean;", "mayDisableInHuaWeiDevices", "checkIsBlackListing", "blackList", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "shouldInLargeScreenCompatMode", "plugin-appbrand-integration_release"})
public final class d
  extends a<AppBrandInitConfigWC>
{
  private final c nEu;
  private Boolean nSn;
  private Boolean nSo;
  
  public d(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame, c paramc)
  {
    super(paramAppBrandRuntime, paramContext, parame);
    AppMethodBeat.i(229455);
    this.nEu = paramc;
    AppMethodBeat.o(229455);
  }
  
  public final boolean OD()
  {
    boolean bool2 = true;
    AppMethodBeat.i(229453);
    Object localObject1;
    if (this.cBI != null)
    {
      localObject1 = this.cBI;
      if (localObject1 == null) {
        p.hyc();
      }
      if (!((AppBrandInitConfigWC)localObject1).ldN)
      {
        localObject1 = this.cBI;
        if (localObject1 == null) {
          p.hyc();
        }
        if (!((AppBrandInitConfigWC)localObject1).NA()) {}
      }
      else
      {
        AppMethodBeat.o(229453);
        return false;
      }
    }
    if (this.cBF)
    {
      AppMethodBeat.o(229453);
      return false;
    }
    Object localObject2;
    if (this.nSo == null)
    {
      localObject1 = ((b)g.af(b.class)).a(b.a.rXM, "null");
      p.g(localObject1, "MMKernel.service(IExptSe…_mode_black_list, \"null\")");
      localObject2 = Locale.US;
      p.g(localObject2, "Locale.US");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(229453);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((String)localObject1).toLowerCase((Locale)localObject2);
      p.g(localObject1, "(this as java.lang.String).toLowerCase(locale)");
      localObject1 = n.a((CharSequence)localObject1, new String[] { ";" });
      if (!((List)localObject1).contains("all")) {
        break label221;
      }
      bool1 = true;
    }
    for (;;)
    {
      this.nSo = Boolean.valueOf(bool1);
      localObject1 = this.nSo;
      if (localObject1 == null) {
        p.hyc();
      }
      if (!((Boolean)localObject1).booleanValue()) {
        break;
      }
      AppMethodBeat.o(229453);
      return false;
      label221:
      if (!((List)localObject1).contains("null"))
      {
        localObject2 = Build.MODEL;
        p.g(localObject2, "Build.MODEL");
        Locale localLocale = Locale.US;
        p.g(localLocale, "Locale.US");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(229453);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject2).toLowerCase(localLocale);
        p.g(localObject2, "(this as java.lang.String).toLowerCase(locale)");
        if (((List)localObject1).contains(localObject2))
        {
          bool1 = true;
          continue;
        }
      }
      bool1 = false;
    }
    if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_BLUE) && (!WeChatEnvironment.isCoolassistEnv()))
    {
      if (this.nSn == null) {
        if ((!j.cDv.Pk()) || (j.cDv.Pj())) {
          break label400;
        }
      }
      label400:
      for (bool1 = bool2;; bool1 = false)
      {
        this.nSn = Boolean.valueOf(bool1);
        localObject1 = this.nSn;
        if (localObject1 == null) {
          p.hyc();
        }
        if (!((Boolean)localObject1).booleanValue()) {
          break;
        }
        AppMethodBeat.o(229453);
        return false;
      }
    }
    boolean bool1 = super.OD();
    AppMethodBeat.o(229453);
    return bool1;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(229454);
    c.c localc = this.nEu.getStatusBar();
    AppMethodBeat.o(229454);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */