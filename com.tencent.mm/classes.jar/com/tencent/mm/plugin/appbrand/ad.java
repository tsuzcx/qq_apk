package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/FakeNativeRuntimeAutoReLaunchLogic;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "initialConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "appId", "", "kotlin.jvm.PlatformType", "getAppId", "()Ljava/lang/String;", "mCurrentConfig", "mLastAcceptableEnterScene", "", "scene", "getScene", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class ad
  implements ah
{
  @Deprecated
  public static final a jDJ;
  private AppBrandInitConfigWC jDH;
  private int jDI;
  
  static
  {
    AppMethodBeat.i(175104);
    jDJ = new a((byte)0);
    AppMethodBeat.o(175104);
  }
  
  public ad(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175103);
    this.jDH = paramAppBrandInitConfigWC;
    this.jDI = paramAppBrandInitConfigWC.Ed().scene;
    AppMethodBeat.o(175103);
  }
  
  public final Boolean b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175101);
    p.h(paramAppBrandInitConfigWC, "newConfig");
    if (!this.jDH.kaJ)
    {
      AppMethodBeat.o(175101);
      return null;
    }
    label318:
    for (;;)
    {
      try
      {
        if (1038 == paramAppBrandInitConfigWC.Ed().scene)
        {
          ae.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return false. appId[" + this.jDH.appId + "], reason=1038 back from other MiniProgram");
          localObject1 = Boolean.FALSE;
          return localObject1;
        }
        Object localObject1 = (CharSequence)paramAppBrandInitConfigWC.jFL;
        if (localObject1 != null)
        {
          if (((CharSequence)localObject1).length() == 0)
          {
            break label318;
            if (i == 0)
            {
              ae.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return true appId[" + this.jDH.appId + "] enterPath[" + paramAppBrandInitConfigWC.jFL + ']');
              localObject1 = Boolean.TRUE;
              return localObject1;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.jDI != paramAppBrandInitConfigWC.Ed().scene)
          {
            bool = true;
            localObject1 = Boolean.valueOf(bool);
            bool = ((Boolean)localObject1).booleanValue();
            ae.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return " + bool + " appId[" + this.jDH.appId + "] mLastAcceptableScene[" + this.jDI + "] newScene[" + paramAppBrandInitConfigWC.Ed().scene + ']');
            return localObject1;
          }
          boolean bool = false;
          continue;
        }
        int i = 1;
      }
      finally
      {
        c(paramAppBrandInitConfigWC);
        AppMethodBeat.o(175101);
      }
    }
  }
  
  public final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175102);
    p.h(paramAppBrandInitConfigWC, "newConfig");
    this.jDH = paramAppBrandInitConfigWC;
    if (1038 != paramAppBrandInitConfigWC.Ed().scene) {
      this.jDI = paramAppBrandInitConfigWC.Ed().scene;
    }
    AppMethodBeat.o(175102);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/FakeNativeRuntimeAutoReLaunchLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad
 * JD-Core Version:    0.7.0.1
 */