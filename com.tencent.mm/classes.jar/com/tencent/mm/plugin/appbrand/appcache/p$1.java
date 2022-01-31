package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class p$1
  implements Runnable
{
  public final void run()
  {
    try
    {
      String str = AppBrandGlobalSystemConfig.aec().fOH;
      if (bk.bl(str)) {
        str = "res.servicewechat.com";
      }
      for (;;)
      {
        ArrayList localArrayList = new ArrayList();
        g.DO().dJT.edx.getHostByName(str, localArrayList);
        CdnLogic.triggerPreConnect(str, (String[])localArrayList.toArray(new String[0]), true);
        y.i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, host %s", new Object[] { str });
        return;
        str = Uri.parse(str).getHost();
        if (bk.bl(str)) {
          str = "res.servicewechat.com";
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.p.1
 * JD-Core Version:    0.7.0.1
 */