package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.luggage.sdk.processes.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.plugin.expansions.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.xweb.ao;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class av
  implements aa, MMActivity.a
{
  private final int hPm;
  
  protected av()
  {
    AppMethodBeat.i(47308);
    this.hPm = (av.class.hashCode() & 0xFFFF);
    AppMethodBeat.o(47308);
  }
  
  private void cAr()
  {
    AppMethodBeat.i(47309);
    if (d.rb(17)) {
      onReady();
    }
    AppMethodBeat.o(47309);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(320762);
    int i = ao.getInstalledNewstVersion(MMApplicationContext.getContext());
    if (i > 400)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
      onReady();
      AppMethodBeat.o(320762);
      return;
    }
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acNN, 0L);
    if (Math.abs(Util.nowSecond() - l) < 1800L)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
      cAr();
      AppMethodBeat.o(320762);
      return;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acNN, Long.valueOf(Util.nowSecond()));
    l = Util.nowMilliSecond();
    Log.d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l), Integer.valueOf(i) });
    if ((paramab == null) || (!paramab.czG()))
    {
      cAr();
      AppMethodBeat.o(320762);
      return;
    }
    paramab.a(this, new Intent().setClass(paramab.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), this.hPm);
    AppMethodBeat.o(320762);
  }
  
  public void cAq() {}
  
  public final boolean czJ()
  {
    return true;
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47310);
    if (this.hPm != paramInt1)
    {
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == -1)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
      g.cJV().b(b.etO);
      onReady();
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == 2)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
      cAq();
      AppMethodBeat.o(47310);
      return;
    }
    Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(366L, 8L, 1L, false);
    cAr();
    AppMethodBeat.o(47310);
  }
  
  public void onReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av
 * JD-Core Version:    0.7.0.1
 */