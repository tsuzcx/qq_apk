package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.e.i.h;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.ae;

final class aa$1
  implements h
{
  public final String getKey()
  {
    return "PkgNetworkOpt.triggerPreConnect";
  }
  
  public final void run()
  {
    AppMethodBeat.i(44303);
    try
    {
      String str = AppBrandGlobalSystemConfig.bez().jZO;
      boolean bool = TextUtils.isEmpty(str);
      if (bool) {
        return;
      }
      aa.uC(str);
      aa.LU(k.ds(str));
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
      return;
    }
    finally
    {
      aa.bay();
      AppMethodBeat.o(44303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa.1
 * JD-Core Version:    0.7.0.1
 */