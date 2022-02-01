package com.tencent.luggage.sdk.d;

import android.content.res.Configuration;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/runtime/AppBrandWindowLayoutManagerDummy;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "()V", "init", "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"})
public final class e<C extends AppBrandInitConfigLU>
  implements f<C>
{
  public final void a(C paramC)
  {
    AppMethodBeat.i(230038);
    p.h(paramC, "initConfig");
    AppMethodBeat.o(230038);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(230040);
    p.h(paramb, "appConfig");
    AppMethodBeat.o(230040);
  }
  
  public final void b(C paramC)
  {
    AppMethodBeat.i(230039);
    p.h(paramC, "initConfig");
    AppMethodBeat.o(230039);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(230037);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(230037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.e
 * JD-Core Version:    0.7.0.1
 */