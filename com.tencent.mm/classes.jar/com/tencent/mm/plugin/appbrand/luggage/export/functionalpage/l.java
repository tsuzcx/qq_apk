package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class l
  implements i<IPCString, AppBrandSysConfigWC>
{
  private static AppBrandSysConfigWC b(IPCString paramIPCString)
  {
    AppMethodBeat.i(134749);
    ab.i("MicroMsg.AppBrand.FunctionalConfigAssembler", "invoke GetSycConfigTask with ".concat(String.valueOf(paramIPCString)));
    if (paramIPCString == null) {}
    try
    {
      j.ebi();
      if (g.RJ().QU())
      {
        paramIPCString = q.An(paramIPCString.value);
        if (paramIPCString != null)
        {
          paramIPCString.bDI = AppBrandGlobalSystemConfig.ayt();
          AppMethodBeat.o(134749);
          return paramIPCString;
        }
      }
    }
    catch (Exception paramIPCString)
    {
      AppMethodBeat.o(134749);
      return null;
    }
    AppMethodBeat.o(134749);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */