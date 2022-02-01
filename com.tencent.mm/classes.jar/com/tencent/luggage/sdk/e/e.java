package com.tencent.luggage.sdk.e;

import android.content.res.Configuration;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/AppBrandWindowLayoutManagerDummy;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "()V", "init", "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<C extends AppBrandInitConfigLU>
  implements f<C>
{
  public final void a(C paramC)
  {
    AppMethodBeat.i(220208);
    s.u(paramC, "initConfig");
    AppMethodBeat.o(220208);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(220214);
    s.u(paramb, "appConfig");
    AppMethodBeat.o(220214);
  }
  
  public final void b(C paramC)
  {
    AppMethodBeat.i(220209);
    s.u(paramC, "initConfig");
    AppMethodBeat.o(220209);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(220207);
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(220207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.e
 * JD-Core Version:    0.7.0.1
 */