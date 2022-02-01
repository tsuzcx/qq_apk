package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandUILifeCycleSpeedProfile;", "", "()V", "TAG", "", "onAppBrandUILifeCycle", "", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "lifecycle", "plugin-appbrand-integration_release"})
public final class l
{
  public static final l nQh;
  
  static
  {
    AppMethodBeat.i(51067);
    nQh = new l();
    AppMethodBeat.o(51067);
  }
  
  public static void b(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(51066);
    p.h(paramAppBrandUI, "ui");
    p.h(paramString, "lifecycle");
    try
    {
      Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getLocalClassName() + ' ' + paramString);
      AppMethodBeat.o(51066);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getClass().getSimpleName() + ' ' + paramString);
      AppMethodBeat.o(51066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.l
 * JD-Core Version:    0.7.0.1
 */