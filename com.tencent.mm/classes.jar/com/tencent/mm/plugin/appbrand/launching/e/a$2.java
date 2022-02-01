package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.launching.bd;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import org.xwalk.core.XWalkEnvironment;

final class a$2
  implements Runnable
{
  a$2(a parama, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(47424);
    bd local1 = new bd()
    {
      public final void bsl()
      {
        AppMethodBeat.i(47422);
        a.2.this.lRN.finish();
        AppMethodBeat.o(47422);
      }
      
      public final void onReady()
      {
        AppMethodBeat.i(47423);
        a.2.this.jCM.run();
        AppMethodBeat.o(47423);
      }
    };
    AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)this.lRN.getBaseContext();
    com.tencent.mm.plugin.expansions.a.cof();
    int i = XWalkEnvironment.getInstalledNewstVersion(ak.getContext());
    if (i > 400)
    {
      ae.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
      local1.onReady();
      AppMethodBeat.o(47424);
      return;
    }
    long l = g.ajR().ajA().a(am.a.IQr, 0L);
    if (Math.abs(bu.aRi() - l) < 1800L)
    {
      ae.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
      local1.bsm();
      AppMethodBeat.o(47424);
      return;
    }
    g.ajR().ajA().set(am.a.IQr, Long.valueOf(bu.aRi()));
    l = bu.fpO();
    ae.d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", new Object[] { Long.valueOf(bu.fpO() - l), Integer.valueOf(i) });
    if ((localAppBrandLaunchProxyUI == null) || (!localAppBrandLaunchProxyUI.brs()))
    {
      local1.bsm();
      AppMethodBeat.o(47424);
      return;
    }
    localAppBrandLaunchProxyUI.a(local1, new Intent().setClass(localAppBrandLaunchProxyUI.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), local1.requestCode);
    AppMethodBeat.o(47424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a.2
 * JD-Core Version:    0.7.0.1
 */