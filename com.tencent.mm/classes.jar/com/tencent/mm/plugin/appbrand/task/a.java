package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class a
{
  private static boolean lXs;
  public static final a lXt;
  
  static
  {
    AppMethodBeat.i(51065);
    lXt = new a();
    long l = bs.Gn();
    int i = aw.aKT("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      ac.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
      lXs = true;
      AppMethodBeat.o(51065);
      return;
    }
    ac.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(51065);
  }
  
  public static final boolean buh()
  {
    AppMethodBeat.i(51062);
    ac.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(lXs) });
    boolean bool = lXs;
    AppMethodBeat.o(51062);
    return bool;
  }
  
  public static final void bui()
  {
    AppMethodBeat.i(51063);
    ac.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    lXs = true;
    aw localaw = aw.aKT("appbrand_process_force_preload");
    localaw.encode("appbrand_process_force_preload", 1);
    localaw.apply();
    AppMethodBeat.o(51063);
  }
  
  public static final void buj()
  {
    AppMethodBeat.i(51064);
    ac.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    lXs = false;
    aw localaw = aw.aKT("appbrand_process_force_preload");
    localaw.encode("appbrand_process_force_preload", -1);
    localaw.apply();
    AppMethodBeat.o(51064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a
 * JD-Core Version:    0.7.0.1
 */