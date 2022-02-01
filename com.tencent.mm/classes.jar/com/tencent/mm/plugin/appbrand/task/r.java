package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandUILifeCycleSpeedProfile;", "", "()V", "TAG", "", "onAppBrandUILifeCycle", "", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "lifecycle", "plugin-appbrand-integration_release"})
public final class r
{
  public static final r qRZ;
  
  static
  {
    AppMethodBeat.i(51067);
    qRZ = new r();
    AppMethodBeat.o(51067);
  }
  
  public static void b(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(51066);
    p.k(paramAppBrandUI, "ui");
    p.k(paramString, "lifecycle");
    try
    {
      if (p.h("finish", paramString))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getLocalClassName() + " finish, stack:" + android.util.Log.getStackTraceString(new Throwable()));
        AppMethodBeat.o(51066);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getLocalClassName() + ' ' + paramString);
      AppMethodBeat.o(51066);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getClass().getSimpleName() + ' ' + paramString);
      AppMethodBeat.o(51066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.r
 * JD-Core Version:    0.7.0.1
 */