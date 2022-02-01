package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.e.i.h;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.Log;

final class ab$1
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
      String str = AppBrandGlobalSystemConfig.bLe().nXa;
      boolean bool = TextUtils.isEmpty(str);
      if (bool) {
        return;
      }
      ab.JI(str);
      ab.acN(l.en(str));
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
      return;
    }
    finally
    {
      ab.bfm();
      AppMethodBeat.o(44303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab.1
 * JD-Core Version:    0.7.0.1
 */