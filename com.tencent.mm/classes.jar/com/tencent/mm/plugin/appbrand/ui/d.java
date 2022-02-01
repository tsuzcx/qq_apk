package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Build;
import com.tencent.luggage.h.i;
import com.tencent.luggage.sdk.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.List;
import java.util.Locale;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCenterInsideWindowLayoutManagerWc;", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "isBlacklisting", "", "Ljava/lang/Boolean;", "mayDisableInHuaWeiDevices", "checkIsBlackListing", "blackList", "", "shouldInLargeScreenCompatMode", "plugin-appbrand-integration_release"})
public final class d
  extends a<AppBrandInitConfigWC>
{
  private Boolean mFA;
  private Boolean mFB;
  
  public d(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame)
  {
    super(paramAppBrandRuntime, paramContext, parame);
    AppMethodBeat.i(223887);
    AppMethodBeat.o(223887);
  }
  
  public final boolean EX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(223886);
    Object localObject1;
    if (this.cpo != null)
    {
      localObject1 = this.cpo;
      if (localObject1 == null) {
        p.gkB();
      }
      if (!((AppBrandInitConfigWC)localObject1).kaJ)
      {
        localObject1 = this.cpo;
        if (localObject1 == null) {
          p.gkB();
        }
        if (!((AppBrandInitConfigWC)localObject1).Ee()) {}
      }
      else
      {
        AppMethodBeat.o(223886);
        return false;
      }
    }
    if (this.cpl)
    {
      AppMethodBeat.o(223886);
      return false;
    }
    if ((!j.DEBUG) && (!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_BLUE) && (!bv.fpR()))
    {
      if (this.mFA == null) {
        if ((!i.cre.FB()) || (i.cre.FA())) {
          break label164;
        }
      }
      label164:
      for (bool1 = true;; bool1 = false)
      {
        this.mFA = Boolean.valueOf(bool1);
        localObject1 = this.mFA;
        if (localObject1 == null) {
          p.gkB();
        }
        if (!((Boolean)localObject1).booleanValue()) {
          break;
        }
        AppMethodBeat.o(223886);
        return false;
      }
    }
    Object localObject2;
    if (this.mFB == null)
    {
      localObject1 = ((b)g.ab(b.class)).a(b.a.qED, "null");
      p.g(localObject1, "MMKernel.service(IExptSe…_mode_black_list, \"null\")");
      localObject2 = Locale.US;
      p.g(localObject2, "Locale.US");
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(223886);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((String)localObject1).toLowerCase((Locale)localObject2);
      p.g(localObject1, "(this as java.lang.String).toLowerCase(locale)");
      localObject1 = n.a((CharSequence)localObject1, new String[] { ";" });
      if (!((List)localObject1).contains("all")) {
        break label311;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.mFB = Boolean.valueOf(bool1);
      localObject1 = this.mFB;
      if (localObject1 == null) {
        p.gkB();
      }
      if (!((Boolean)localObject1).booleanValue()) {
        break;
      }
      AppMethodBeat.o(223886);
      return false;
      label311:
      if (!((List)localObject1).contains("null"))
      {
        localObject2 = Build.MODEL;
        p.g(localObject2, "Build.MODEL");
        Locale localLocale = Locale.US;
        p.g(localLocale, "Locale.US");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(223886);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject2).toLowerCase(localLocale);
        p.g(localObject2, "(this as java.lang.String).toLowerCase(locale)");
        bool1 = bool2;
        if (((List)localObject1).contains(localObject2)) {}
      }
      else
      {
        bool1 = false;
      }
    }
    boolean bool1 = super.EX();
    AppMethodBeat.o(223886);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */