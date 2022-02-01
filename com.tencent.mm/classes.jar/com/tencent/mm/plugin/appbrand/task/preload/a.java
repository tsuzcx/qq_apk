package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/preload/AppBrandPreloadDowngradeTestShortcut;", "", "()V", "MMKV_HARD_CODE_LEVEL_TAG", "", "NON_HARD_CODE", "", "hardcodeLevel", "setHardLevel", "", "level", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a qSt;
  
  static
  {
    AppMethodBeat.i(277735);
    qSt = new a();
    AppMethodBeat.o(277735);
  }
  
  public static void CQ(int paramInt)
  {
    AppMethodBeat.i(277734);
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV == null) {
      p.iCn();
    }
    localMultiProcessMMKV.putInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", paramInt);
    AppMethodBeat.o(277734);
  }
  
  public static int cji()
  {
    AppMethodBeat.i(277733);
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", -2);
      AppMethodBeat.o(277733);
      return i;
    }
    AppMethodBeat.o(277733);
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.a
 * JD-Core Version:    0.7.0.1
 */