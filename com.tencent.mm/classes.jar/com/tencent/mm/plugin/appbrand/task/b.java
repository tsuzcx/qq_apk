package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class b
{
  private static boolean nOn;
  public static final b nOo;
  
  static
  {
    AppMethodBeat.i(51065);
    nOo = new b();
    long l = Util.currentTicks();
    int i = MultiProcessMMKV.getMMKV("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      nOn = true;
      AppMethodBeat.o(51065);
      return;
    }
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(51065);
  }
  
  public static final boolean bVE()
  {
    AppMethodBeat.i(51062);
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(nOn) });
    boolean bool = nOn;
    AppMethodBeat.o(51062);
    return bool;
  }
  
  public static final void bVF()
  {
    AppMethodBeat.i(51063);
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    nOn = true;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("appbrand_process_force_preload");
    localMultiProcessMMKV.encode("appbrand_process_force_preload", 1);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(51063);
  }
  
  public static final void bVG()
  {
    AppMethodBeat.i(51064);
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    nOn = false;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("appbrand_process_force_preload");
    localMultiProcessMMKV.encode("appbrand_process_force_preload", -1);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(51064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.b
 * JD-Core Version:    0.7.0.1
 */