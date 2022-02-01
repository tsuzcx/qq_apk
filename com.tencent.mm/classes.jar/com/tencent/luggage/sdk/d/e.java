package com.tencent.luggage.sdk.d;

import android.content.res.Configuration;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/runtime/AppBrandWindowLayoutManagerDummy;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "()V", "init", "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"})
public final class e<C extends AppBrandInitConfigLU>
  implements f<C>
{
  public final void a(C paramC)
  {
    AppMethodBeat.i(220928);
    p.h(paramC, "initConfig");
    AppMethodBeat.o(220928);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(220930);
    p.h(parama, "appConfig");
    AppMethodBeat.o(220930);
  }
  
  public final void b(C paramC)
  {
    AppMethodBeat.i(220929);
    p.h(paramC, "initConfig");
    AppMethodBeat.o(220929);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(220927);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(220927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.e
 * JD-Core Version:    0.7.0.1
 */