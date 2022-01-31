package com.tencent.mm.plugin.appbrand.task;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class b
{
  private static boolean iJU;
  public static final b iJV;
  
  static
  {
    AppMethodBeat.i(134962);
    iJV = new b();
    long l = bo.yB();
    int i = as.apq("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(bo.av(l)) });
      iJU = true;
      AppMethodBeat.o(134962);
      return;
    }
    ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(134962);
  }
  
  public static final boolean aLC()
  {
    AppMethodBeat.i(134959);
    ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(iJU) });
    boolean bool = iJU;
    AppMethodBeat.o(134959);
    return bool;
  }
  
  public static final void aLD()
  {
    AppMethodBeat.i(134960);
    ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    iJU = true;
    as localas = as.apq("appbrand_process_force_preload");
    localas.encode("appbrand_process_force_preload", 1);
    localas.apply();
    AppMethodBeat.o(134960);
  }
  
  public static final void aLE()
  {
    AppMethodBeat.i(134961);
    ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    iJU = false;
    as localas = as.apq("appbrand_process_force_preload");
    localas.encode("appbrand_process_force_preload", -1);
    localas.apply();
    AppMethodBeat.o(134961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.b
 * JD-Core Version:    0.7.0.1
 */