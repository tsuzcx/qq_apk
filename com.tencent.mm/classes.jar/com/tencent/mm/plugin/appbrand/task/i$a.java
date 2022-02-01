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
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;", "setINSTANCE", "(Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;)V", "TAG", "", "getAllStaticProcessNames", "", "()[Ljava/lang/String;", "inject", "", "instance", "stripSceneNote", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$a
{
  public static i cJV()
  {
    AppMethodBeat.i(318523);
    i locali = i.tWs;
    if (locali != null)
    {
      AppMethodBeat.o(318523);
      return locali;
    }
    s.bIx("INSTANCE");
    AppMethodBeat.o(318523);
    return null;
  }
  
  public static String[] cJW()
  {
    AppMethodBeat.i(318528);
    Object localObject1 = c.etU;
    localObject1 = c.a.ad(AppBrandUI.class);
    Object localObject2 = c.etU;
    localObject2 = c.a.ad(AppBrandUI1.class);
    Object localObject3 = c.etU;
    localObject3 = c.a.ad(AppBrandUI2.class);
    Object localObject4 = c.etU;
    localObject4 = c.a.ad(AppBrandUI3.class);
    c.a locala = c.etU;
    localObject1 = ((Collection)p.t((Iterable)p.J((Collection)k.ab(new String[] { localObject1, localObject2, localObject3, localObject4, c.a.ad(AppBrandUI4.class) })))).toArray(new String[0]);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(318528);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String[])localObject1;
    AppMethodBeat.o(318528);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i.a
 * JD-Core Version:    0.7.0.1
 */