package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicateBase;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "()V", "isZombieTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$f
  implements h.c
{
  public static final f qCm;
  
  static
  {
    AppMethodBeat.i(317768);
    qCm = new f();
    AppMethodBeat.o(317768);
  }
  
  public final boolean b(ActivityManager.AppTask paramAppTask)
  {
    AppMethodBeat.i(317773);
    s.u(paramAppTask, "appTask");
    paramAppTask = paramAppTask.getTaskInfo();
    if ((paramAppTask != null) && (paramAppTask.id == -1))
    {
      AppMethodBeat.o(317773);
      return true;
    }
    AppMethodBeat.o(317773);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.f
 * JD-Core Version:    0.7.0.1
 */