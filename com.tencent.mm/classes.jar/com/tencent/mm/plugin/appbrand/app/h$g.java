package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager.AppTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicateDisabled;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "()V", "isZombieTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$g
  implements h.c
{
  public static final g qCn;
  
  static
  {
    AppMethodBeat.i(317766);
    qCn = new g();
    AppMethodBeat.o(317766);
  }
  
  public final boolean b(ActivityManager.AppTask paramAppTask)
  {
    AppMethodBeat.i(317770);
    s.u(paramAppTask, "appTask");
    AppMethodBeat.o(317770);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.g
 * JD-Core Version:    0.7.0.1
 */