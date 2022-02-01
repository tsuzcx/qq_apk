package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class a
{
  private static boolean lvy;
  public static final a lvz;
  
  static
  {
    AppMethodBeat.i(51065);
    lvz = new a();
    long l = bt.GC();
    int i = ax.aFC("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(bt.aS(l)) });
      lvy = true;
      AppMethodBeat.o(51065);
      return;
    }
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(51065);
  }
  
  public static final boolean bnl()
  {
    AppMethodBeat.i(51062);
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(lvy) });
    boolean bool = lvy;
    AppMethodBeat.o(51062);
    return bool;
  }
  
  public static final void bnm()
  {
    AppMethodBeat.i(51063);
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    lvy = true;
    ax localax = ax.aFC("appbrand_process_force_preload");
    localax.encode("appbrand_process_force_preload", 1);
    localax.apply();
    AppMethodBeat.o(51063);
  }
  
  public static final void bnn()
  {
    AppMethodBeat.i(51064);
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    lvy = false;
    ax localax = ax.aFC("appbrand_process_force_preload");
    localax.encode("appbrand_process_force_preload", -1);
    localax.apply();
    AppMethodBeat.o(51064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a
 * JD-Core Version:    0.7.0.1
 */