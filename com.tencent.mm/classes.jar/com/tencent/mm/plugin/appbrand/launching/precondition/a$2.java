package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.af;
import com.tencent.mm.plugin.appbrand.launching.p;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.xwalk.core.XWalkEnvironment;

final class a$2
  implements Runnable
{
  a$2(a parama, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(132049);
    a.2.1 local1 = new a.2.1(this);
    AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)this.inO.getBaseContext();
    if (com.tencent.mm.sdk.platformtools.g.dsn())
    {
      ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, gp version, just return");
      local1.aHf();
      AppMethodBeat.o(132049);
      return;
    }
    int i = XWalkEnvironment.getInstalledNewstVersion(ah.getContext());
    if (i > 400)
    {
      ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
      local1.onReady();
      AppMethodBeat.o(132049);
      return;
    }
    long l = com.tencent.mm.kernel.g.RL().Ru().a(ac.a.yDo, 0L);
    if (Math.abs(bo.aox() - l) < 7200L)
    {
      ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
      local1.aHf();
      AppMethodBeat.o(132049);
      return;
    }
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDo, Long.valueOf(bo.aox()));
    l = bo.aoy();
    ab.d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", new Object[] { Long.valueOf(bo.aoy() - l), Integer.valueOf(i) });
    if ((localAppBrandLaunchProxyUI == null) || (!localAppBrandLaunchProxyUI.aGH()))
    {
      local1.aHf();
      AppMethodBeat.o(132049);
      return;
    }
    localAppBrandLaunchProxyUI.a(local1, new Intent().setClass(localAppBrandLaunchProxyUI.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), local1.requestCode);
    AppMethodBeat.o(132049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a.2
 * JD-Core Version:    0.7.0.1
 */