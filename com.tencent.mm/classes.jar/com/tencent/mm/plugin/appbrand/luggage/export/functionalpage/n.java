package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class n
  implements k<IPCString, AppBrandSysConfigWC>
{
  private static AppBrandSysConfigWC b(IPCString paramIPCString)
  {
    AppMethodBeat.i(50878);
    Log.i("MicroMsg.AppBrand.FunctionalConfigAssembler", "invoke GetSycConfigTask with ".concat(String.valueOf(paramIPCString)));
    if (paramIPCString == null) {}
    try
    {
      p.hyc();
      if (g.aAf().azp())
      {
        paramIPCString = y.Xu(paramIPCString.value);
        if (paramIPCString != null)
        {
          paramIPCString.czd = AppBrandGlobalSystemConfig.bzP();
          AppMethodBeat.o(50878);
          return paramIPCString;
        }
      }
    }
    catch (Exception paramIPCString)
    {
      AppMethodBeat.o(50878);
      return null;
    }
    AppMethodBeat.o(50878);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.n
 * JD-Core Version:    0.7.0.1
 */