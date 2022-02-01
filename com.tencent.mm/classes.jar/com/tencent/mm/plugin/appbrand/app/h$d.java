package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicateApi23;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "()V", "isZombieTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$d
  implements h.c
{
  public static final d qCk;
  
  static
  {
    AppMethodBeat.i(317781);
    qCk = new d();
    AppMethodBeat.o(317781);
  }
  
  public final boolean b(ActivityManager.AppTask paramAppTask)
  {
    AppMethodBeat.i(317785);
    s.u(paramAppTask, "appTask");
    paramAppTask = paramAppTask.getTaskInfo();
    if (paramAppTask == null)
    {
      AppMethodBeat.o(317785);
      return false;
    }
    if (paramAppTask.numActivities <= 0)
    {
      AppMethodBeat.o(317785);
      return true;
    }
    AppMethodBeat.o(317785);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.d
 * JD-Core Version:    0.7.0.1
 */