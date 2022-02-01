package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class n
  implements m<IPCString, AppBrandSysConfigWC>
{
  private static AppBrandSysConfigWC d(IPCString paramIPCString)
  {
    AppMethodBeat.i(50878);
    Log.i("MicroMsg.AppBrand.FunctionalConfigAssembler", s.X("invoke GetSycConfigTask with ", paramIPCString));
    try
    {
      s.checkNotNull(paramIPCString);
      if (h.baC().aZN())
      {
        paramIPCString = ad.XH(paramIPCString.value);
        if (paramIPCString != null)
        {
          paramIPCString.eqf = AppBrandGlobalSystemConfig.ckD();
          AppMethodBeat.o(50878);
          return paramIPCString;
        }
      }
    }
    catch (Exception paramIPCString)
    {
      if (BuildInfo.DEBUG)
      {
        AppMethodBeat.o(50878);
        throw paramIPCString;
      }
      AppMethodBeat.o(50878);
      return null;
    }
    AppMethodBeat.o(50878);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.n
 * JD-Core Version:    0.7.0.1
 */