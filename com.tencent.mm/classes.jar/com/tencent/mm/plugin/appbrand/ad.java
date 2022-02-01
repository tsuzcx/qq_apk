package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/FakeNativeRuntimeAutoReLaunchLogic;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "initialConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "appId", "", "kotlin.jvm.PlatformType", "getAppId", "()Ljava/lang/String;", "mCurrentConfig", "mLastAcceptableEnterScene", "", "scene", "getScene", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class ad
  implements ah
{
  @Deprecated
  public static final a jAY;
  private AppBrandInitConfigWC jAW;
  private int jAX;
  
  static
  {
    AppMethodBeat.i(175104);
    jAY = new a((byte)0);
    AppMethodBeat.o(175104);
  }
  
  public ad(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175103);
    this.jAW = paramAppBrandInitConfigWC;
    this.jAX = paramAppBrandInitConfigWC.Ea().scene;
    AppMethodBeat.o(175103);
  }
  
  public final Boolean b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175101);
    p.h(paramAppBrandInitConfigWC, "newConfig");
    if (!this.jAW.jXu)
    {
      AppMethodBeat.o(175101);
      return null;
    }
    label318:
    for (;;)
    {
      try
      {
        if (1038 == paramAppBrandInitConfigWC.Ea().scene)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return false. appId[" + this.jAW.appId + "], reason=1038 back from other MiniProgram");
          localObject1 = Boolean.FALSE;
          return localObject1;
        }
        Object localObject1 = (CharSequence)paramAppBrandInitConfigWC.jCN;
        if (localObject1 != null)
        {
          if (((CharSequence)localObject1).length() == 0)
          {
            break label318;
            if (i == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return true appId[" + this.jAW.appId + "] enterPath[" + paramAppBrandInitConfigWC.jCN + ']');
              localObject1 = Boolean.TRUE;
              return localObject1;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.jAX != paramAppBrandInitConfigWC.Ea().scene)
          {
            bool = true;
            localObject1 = Boolean.valueOf(bool);
            bool = ((Boolean)localObject1).booleanValue();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return " + bool + " appId[" + this.jAW.appId + "] mLastAcceptableScene[" + this.jAX + "] newScene[" + paramAppBrandInitConfigWC.Ea().scene + ']');
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
    this.jAW = paramAppBrandInitConfigWC;
    if (1038 != paramAppBrandInitConfigWC.Ea().scene) {
      this.jAX = paramAppBrandInitConfigWC.Ea().scene;
    }
    AppMethodBeat.o(175102);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/FakeNativeRuntimeAutoReLaunchLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad
 * JD-Core Version:    0.7.0.1
 */