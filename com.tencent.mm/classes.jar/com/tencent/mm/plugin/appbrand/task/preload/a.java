package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/preload/AppBrandPreloadDowngradeTestShortcut;", "", "()V", "MMKV_HARD_CODE_LEVEL_TAG", "", "NON_HARD_CODE", "", "hardcodeLevel", "setHardLevel", "", "level", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a nQO;
  
  static
  {
    AppMethodBeat.i(229448);
    nQO = new a();
    AppMethodBeat.o(229448);
  }
  
  public static int bWD()
  {
    AppMethodBeat.i(229446);
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", -2);
      AppMethodBeat.o(229446);
      return i;
    }
    AppMethodBeat.o(229446);
    return -2;
  }
  
  public static void zo(int paramInt)
  {
    AppMethodBeat.i(229447);
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    if (localMultiProcessMMKV == null) {
      p.hyc();
    }
    localMultiProcessMMKV.putInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", paramInt);
    AppMethodBeat.o(229447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.a
 * JD-Core Version:    0.7.0.1
 */