package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandUILifeCycleSpeedProfile;", "", "()V", "TAG", "", "onAppBrandUILifeCycle", "", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "lifecycle", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h lYF;
  
  static
  {
    AppMethodBeat.i(51067);
    lYF = new h();
    AppMethodBeat.o(51067);
  }
  
  public static void b(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(51066);
    k.h(paramAppBrandUI, "ui");
    k.h(paramString, "lifecycle");
    try
    {
      ac.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.getLocalClassName() + ' ' + paramString);
      AppMethodBeat.o(51066);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.getClass().getSimpleName() + ' ' + paramString);
      AppMethodBeat.o(51066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.h
 * JD-Core Version:    0.7.0.1
 */