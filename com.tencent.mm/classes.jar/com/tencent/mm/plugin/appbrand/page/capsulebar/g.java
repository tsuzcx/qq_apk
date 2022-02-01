package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandHalfScreenCapsuleBarFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseAppBrandSingleCloseCapsuleBar;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "context", "Landroid/content/Context;", "forLoadingSplash", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g tCv;
  
  static
  {
    AppMethodBeat.i(325293);
    tCv = new g();
    AppMethodBeat.o(325293);
  }
  
  public static BaseAppBrandSingleCloseCapsuleBar a(w paramw, Context paramContext, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(325271);
    s.u(paramw, "runtime");
    s.u(paramContext, "context");
    HalfScreenConfig localHalfScreenConfig = paramw.getInitConfig().qAT;
    s.s(localHalfScreenConfig, "runtime.initConfig.halfScreenConfig");
    paramw = paramw.getAppConfig();
    boolean bool1;
    if (paramw == null)
    {
      bool1 = false;
      label47:
      if (!paramBoolean) {
        break label140;
      }
      paramBoolean = bool2;
      if (!localHalfScreenConfig.qkq)
      {
        if (localHalfScreenConfig.ckP() != HalfScreenConfig.f.raw) {
          break label135;
        }
        paramBoolean = bool2;
      }
    }
    for (;;)
    {
      paramw = localHalfScreenConfig.rac;
      switch (a.$EnumSwitchMapping$0[paramw.ordinal()])
      {
      default: 
        paramw = new p();
        AppMethodBeat.o(325271);
        throw paramw;
        bool1 = paramw.cks();
        break label47;
        label135:
        paramBoolean = false;
        continue;
        label140:
        paramBoolean = bool2;
        if (!localHalfScreenConfig.qkq)
        {
          paramBoolean = bool2;
          if (bool1) {
            paramBoolean = false;
          }
        }
        break;
      }
    }
    paramw = (BaseAppBrandSingleCloseCapsuleBar)new AppBrandSingleCloseCapsuleBar(paramContext, paramBoolean);
    AppMethodBeat.o(325271);
    return paramw;
    paramw = (BaseAppBrandSingleCloseCapsuleBar)new AppBrandeEmbedSingleCloseCapsuleBar(paramContext, paramBoolean);
    AppMethodBeat.o(325271);
    return paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.g
 * JD-Core Version:    0.7.0.1
 */