package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.luggage.l.g;
import com.tencent.luggage.l.k;
import com.tencent.luggage.sdk.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.vendor.HuaweiKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.l.o;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCenterInsideWindowLayoutManagerWc;", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "base", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "isBlacklisting", "", "Ljava/lang/Boolean;", "mayDisableInHuaWeiDevices", "checkIsBlackListing", "blackList", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "shouldInLargeScreenCompatMode", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a<AppBrandInitConfigWC>
{
  public static final a tYN;
  private static final g<Boolean> tYQ;
  private static final g<Boolean> tYR;
  private final com.tencent.mm.plugin.appbrand.platform.window.c tLq;
  private Boolean tYO;
  private Boolean tYP;
  
  static
  {
    AppMethodBeat.i(322103);
    tYN = new a((byte)0);
    tYQ = new g(Boolean.FALSE);
    tYR = new g(Boolean.FALSE);
    AppMethodBeat.o(322103);
  }
  
  public b(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame, com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    super(paramAppBrandRuntime, paramContext, parame);
    AppMethodBeat.i(322095);
    this.tLq = paramc;
    AppMethodBeat.o(322095);
  }
  
  public final boolean asq()
  {
    AppMethodBeat.i(322111);
    if (tYN.cKF())
    {
      AppMethodBeat.o(322111);
      return true;
    }
    if (tYN.cKG())
    {
      AppMethodBeat.o(322111);
      return false;
    }
    Object localObject1;
    if (this.euQ != null)
    {
      localObject1 = this.euQ;
      s.checkNotNull(localObject1);
      if (!((AppBrandInitConfigWC)localObject1).qYd)
      {
        localObject1 = this.euQ;
        s.checkNotNull(localObject1);
        if (!((AppBrandInitConfigWC)localObject1).aqJ()) {}
      }
      else
      {
        AppMethodBeat.o(322111);
        return false;
      }
    }
    if (aso())
    {
      AppMethodBeat.o(322111);
      return false;
    }
    Object localObject2;
    if (this.tYP == null)
    {
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTT, "null");
      s.s(localObject1, "service(IExptService::cl…_mode_black_list, \"null\")");
      localObject2 = Locale.US;
      s.s(localObject2, "US");
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(322111);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((String)localObject1).toLowerCase((Locale)localObject2);
      s.s(localObject1, "(this as java.lang.String).toLowerCase(locale)");
      localObject1 = n.b((CharSequence)localObject1, new String[] { ";" });
      if (!((List)localObject1).contains("all")) {
        break label239;
      }
      bool = true;
    }
    for (;;)
    {
      this.tYP = Boolean.valueOf(bool);
      localObject1 = this.tYP;
      s.checkNotNull(localObject1);
      if (!((Boolean)localObject1).booleanValue()) {
        break;
      }
      AppMethodBeat.o(322111);
      return false;
      label239:
      if (!((List)localObject1).contains("null"))
      {
        localObject2 = q.aPo();
        s.s(localObject2, "getModel()");
        Locale localLocale = Locale.US;
        s.s(localLocale, "US");
        localObject2 = ((String)localObject2).toLowerCase(localLocale);
        s.s(localObject2, "(this as java.lang.String).toLowerCase(locale)");
        if (((List)localObject1).contains(localObject2))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
    if (this.tYO == null) {
      if ((!HuaweiKt.hasHuaweiMagicWindowFeature()) || (k.exm.atn())) {
        break label360;
      }
    }
    label360:
    for (boolean bool = true;; bool = false)
    {
      this.tYO = Boolean.valueOf(bool);
      localObject1 = this.tYO;
      s.checkNotNull(localObject1);
      if (!((Boolean)localObject1).booleanValue()) {
        break;
      }
      AppMethodBeat.o(322111);
      return false;
    }
    if (k.exm.ato())
    {
      AppMethodBeat.o(322111);
      return true;
    }
    bool = super.asq();
    AppMethodBeat.o(322111);
    return bool;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(322115);
    c.c localc = this.tLq.getStatusBar();
    AppMethodBeat.o(322115);
    return localc;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCenterInsideWindowLayoutManagerWc$Companion;", "", "()V", "<set-?>", "", "forceCenterInside", "getForceCenterInside", "()Z", "setForceCenterInside", "(Z)V", "forceCenterInside$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "forceNotCenterInside", "getForceNotCenterInside", "setForceNotCenterInside", "forceNotCenterInside$delegate", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(321917);
      aYe = new o[] { (o)ai.a((z)new aa(a.class, "forceCenterInside", "getForceCenterInside()Z", 0)), (o)ai.a((z)new aa(a.class, "forceNotCenterInside", "getForceNotCenterInside()Z", 0)) };
      AppMethodBeat.o(321917);
    }
    
    public final boolean cKF()
    {
      AppMethodBeat.i(321920);
      boolean bool = ((Boolean)b.cKD().a(this, aYe[0])).booleanValue();
      AppMethodBeat.o(321920);
      return bool;
    }
    
    public final boolean cKG()
    {
      AppMethodBeat.i(321922);
      boolean bool = ((Boolean)b.cKE().a(this, aYe[1])).booleanValue();
      AppMethodBeat.o(321922);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */