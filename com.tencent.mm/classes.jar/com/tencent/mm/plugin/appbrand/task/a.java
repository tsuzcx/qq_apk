package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class a
{
  private static boolean mCe;
  public static final a mCf;
  
  static
  {
    AppMethodBeat.i(51065);
    mCf = new a();
    long l = bu.HQ();
    int i = ay.aRW("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
    if (i == 1)
    {
      ae.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
      mCe = true;
      AppMethodBeat.o(51065);
      return;
    }
    ae.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", new Object[] { Integer.valueOf(i), Boolean.FALSE, Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(51065);
  }
  
  public static final boolean bzf()
  {
    AppMethodBeat.i(51062);
    ae.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", new Object[] { Boolean.valueOf(mCe) });
    boolean bool = mCe;
    AppMethodBeat.o(51062);
    return bool;
  }
  
  public static final void bzg()
  {
    AppMethodBeat.i(51063);
    ae.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
    mCe = true;
    ay localay = ay.aRW("appbrand_process_force_preload");
    localay.encode("appbrand_process_force_preload", 1);
    localay.apply();
    AppMethodBeat.o(51063);
  }
  
  public static final void bzh()
  {
    AppMethodBeat.i(51064);
    ae.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
    mCe = false;
    ay localay = ay.aRW("appbrand_process_force_preload");
    localay.encode("appbrand_process_force_preload", -1);
    localay.apply();
    AppMethodBeat.o(51064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a
 * JD-Core Version:    0.7.0.1
 */