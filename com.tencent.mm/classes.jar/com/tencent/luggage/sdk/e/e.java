package com.tencent.luggage.sdk.e;

import android.content.res.Configuration;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/runtime/AppBrandWindowLayoutManagerDummy;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "()V", "init", "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"})
public final class e<C extends AppBrandInitConfigLU>
  implements f<C>
{
  public final void a(C paramC)
  {
    AppMethodBeat.i(241731);
    p.k(paramC, "initConfig");
    AppMethodBeat.o(241731);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(241734);
    p.k(paramb, "appConfig");
    AppMethodBeat.o(241734);
  }
  
  public final void b(C paramC)
  {
    AppMethodBeat.i(241733);
    p.k(paramC, "initConfig");
    AppMethodBeat.o(241733);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(241729);
    p.k(paramConfiguration, "newConfig");
    AppMethodBeat.o(241729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.e
 * JD-Core Version:    0.7.0.1
 */