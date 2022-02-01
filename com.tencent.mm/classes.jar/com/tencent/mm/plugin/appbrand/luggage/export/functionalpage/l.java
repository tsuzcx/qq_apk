package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.sdk.platformtools.ad;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class l
  implements com.tencent.mm.ipcinvoker.k<IPCString, AppBrandSysConfigWC>
{
  private static AppBrandSysConfigWC b(IPCString paramIPCString)
  {
    AppMethodBeat.i(50878);
    ad.i("MicroMsg.AppBrand.FunctionalConfigAssembler", "invoke GetSycConfigTask with ".concat(String.valueOf(paramIPCString)));
    if (paramIPCString == null) {}
    try
    {
      d.g.b.k.fvU();
      if (g.afz().aeI())
      {
        paramIPCString = u.Ge(paramIPCString.value);
        if (paramIPCString != null)
        {
          paramIPCString.cfR = AppBrandGlobalSystemConfig.aTv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */