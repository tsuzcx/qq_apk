package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.launching.bd;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
      public final void brA()
      {
        AppMethodBeat.i(47422);
        a.2.this.lNm.finish();
        AppMethodBeat.o(47422);
      }
      
      public final void onReady()
      {
        AppMethodBeat.i(47423);
        a.2.this.jzJ.run();
        AppMethodBeat.o(47423);
      }
    };
    AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)this.lNm.getBaseContext();
    com.tencent.mm.plugin.expansions.a.cmP();
    int i = XWalkEnvironment.getInstalledNewstVersion(aj.getContext());
    if (i > 400)
    {
      ad.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
      local1.onReady();
      AppMethodBeat.o(47424);
      return;
    }
    long l = g.ajC().ajl().a(al.a.IvT, 0L);
    if (Math.abs(bt.aQJ() - l) < 1800L)
    {
      ad.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
      local1.brB();
      AppMethodBeat.o(47424);
      return;
    }
    g.ajC().ajl().set(al.a.IvT, Long.valueOf(bt.aQJ()));
    l = bt.flT();
    ad.d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", new Object[] { Long.valueOf(bt.flT() - l), Integer.valueOf(i) });
    if ((localAppBrandLaunchProxyUI == null) || (!localAppBrandLaunchProxyUI.bqI()))
    {
      local1.brB();
      AppMethodBeat.o(47424);
      return;
    }
    localAppBrandLaunchProxyUI.a(local1, new Intent().setClass(localAppBrandLaunchProxyUI.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), local1.requestCode);
    AppMethodBeat.o(47424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a.2
 * JD-Core Version:    0.7.0.1
 */