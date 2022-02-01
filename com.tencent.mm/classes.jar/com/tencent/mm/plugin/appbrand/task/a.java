package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class a
{
  private static boolean mxh;
  public static final a mxi;
  
  static
  {
    AppMethodBeat.i(51065);
    mxi = new a();
    long l = bt.HI();
    int i = ax.aQz("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
      mxh = true;
      AppMethodBeat.o(51065);
      return;
    }
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(51065);
  }
  
  public static final boolean bym()
  {
    AppMethodBeat.i(51062);
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(mxh) });
    boolean bool = mxh;
    AppMethodBeat.o(51062);
    return bool;
  }
  
  public static final void byn()
  {
    AppMethodBeat.i(51063);
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    mxh = true;
    ax localax = ax.aQz("appbrand_process_force_preload");
    localax.encode("appbrand_process_force_preload", 1);
    localax.apply();
    AppMethodBeat.o(51063);
  }
  
  public static final void byo()
  {
    AppMethodBeat.i(51064);
    ad.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    mxh = false;
    ax localax = ax.aQz("appbrand_process_force_preload");
    localax.encode("appbrand_process_force_preload", -1);
    localax.apply();
    AppMethodBeat.o(51064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a
 * JD-Core Version:    0.7.0.1
 */