package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/preload/AppBrandPreloadDowngradeTestShortcut;", "", "()V", "MMKV_HARD_CODE_LEVEL_TAG", "", "NON_HARD_CODE", "", "hardcodeLevel", "setHardLevel", "", "level", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tWY;
  
  static
  {
    AppMethodBeat.i(318713);
    tWY = new a();
    AppMethodBeat.o(318713);
  }
  
  public static void Dj(int paramInt)
  {
    AppMethodBeat.i(318710);
    Object localObject = f.qBv;
    localObject = f.aBP();
    s.checkNotNull(localObject);
    ((MultiProcessMMKV)localObject).putInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", paramInt);
    AppMethodBeat.o(318710);
  }
  
  public static int cKi()
  {
    AppMethodBeat.i(318706);
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null)
    {
      AppMethodBeat.o(318706);
      return -2;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", -2);
    AppMethodBeat.o(318706);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.a
 * JD-Core Version:    0.7.0.1
 */