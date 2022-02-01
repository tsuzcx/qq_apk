package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class b
{
  private static boolean qQL;
  public static final b qQM;
  
  static
  {
    AppMethodBeat.i(51065);
    qQM = new b();
    long l = Util.currentTicks();
    int i = MultiProcessMMKV.getMMKV("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      qQL = true;
      AppMethodBeat.o(51065);
      return;
    }
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(51065);
  }
  
  public static final boolean ciL()
  {
    AppMethodBeat.i(51062);
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(qQL) });
    boolean bool = qQL;
    AppMethodBeat.o(51062);
    return bool;
  }
  
  public static final void ciM()
  {
    AppMethodBeat.i(51063);
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    qQL = true;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("appbrand_process_force_preload");
    localMultiProcessMMKV.encode("appbrand_process_force_preload", 1);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(51063);
  }
  
  public static final void ciN()
  {
    AppMethodBeat.i(51064);
    Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    qQL = false;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("appbrand_process_force_preload");
    localMultiProcessMMKV.encode("appbrand_process_force_preload", -1);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(51064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.b
 * JD-Core Version:    0.7.0.1
 */