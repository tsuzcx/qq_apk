package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import java.util.Collection;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;", "INSTANCE$annotations", "getINSTANCE", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;", "setINSTANCE", "(Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;)V", "TAG", "", "getAllStaticProcessNames", "", "()[Ljava/lang/String;", "inject", "", "instance", "stripSceneNote", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class i$a
{
  public static i cjb()
  {
    AppMethodBeat.i(275678);
    i locali = i.cja();
    if (locali == null) {
      p.bGy("INSTANCE");
    }
    AppMethodBeat.o(275678);
    return locali;
  }
  
  public static String[] cjc()
  {
    AppMethodBeat.i(275681);
    Object localObject1 = c.cBt;
    localObject1 = c.a.U(AppBrandUI.class);
    Object localObject2 = c.cBt;
    localObject2 = c.a.U(AppBrandUI1.class);
    Object localObject3 = c.cBt;
    localObject3 = c.a.U(AppBrandUI2.class);
    Object localObject4 = c.cBt;
    localObject4 = c.a.U(AppBrandUI3.class);
    c.a locala = c.cBt;
    localObject1 = ((Collection)j.t((Iterable)j.t((Collection)e.X(new String[] { localObject1, localObject2, localObject3, localObject4, c.a.U(AppBrandUI4.class) })))).toArray(new String[0]);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(275681);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String[])localObject1;
    AppMethodBeat.o(275681);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i.a
 * JD-Core Version:    0.7.0.1
 */