package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class v$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(129397);
    try
    {
      String str = AppBrandGlobalSystemConfig.ayt().hhH;
      if (bo.isNullOrNil(str)) {
        str = "res.servicewechat.com";
      }
      for (;;)
      {
        ArrayList localArrayList = new ArrayList();
        g.RK().eHt.ftA.getHostByName(str, localArrayList);
        CdnLogic.triggerPreConnect(str, (String[])localArrayList.toArray(new String[0]), true);
        ab.i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, host %s", new Object[] { str });
        AppMethodBeat.o(129397);
        return;
        str = Uri.parse(str).getHost();
        if (bo.isNullOrNil(str)) {
          str = "res.servicewechat.com";
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
      AppMethodBeat.o(129397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v.1
 * JD-Core Version:    0.7.0.1
 */