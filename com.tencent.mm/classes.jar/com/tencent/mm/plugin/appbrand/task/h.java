package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandUILifeCycleSpeedProfile;", "", "()V", "TAG", "", "onAppBrandUILifeCycle", "", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "lifecycle", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h mDt;
  
  static
  {
    AppMethodBeat.i(51067);
    mDt = new h();
    AppMethodBeat.o(51067);
  }
  
  public static void b(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(51066);
    p.h(paramAppBrandUI, "ui");
    p.h(paramString, "lifecycle");
    try
    {
      ae.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.getLocalClassName() + ' ' + paramString);
      AppMethodBeat.o(51066);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.getClass().getSimpleName() + ' ' + paramString);
      AppMethodBeat.o(51066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.h
 * JD-Core Version:    0.7.0.1
 */