package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicateApi29;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "()V", "isZombieTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$e
  implements h.c
{
  public static final e qCl;
  
  static
  {
    AppMethodBeat.i(317780);
    qCl = new e();
    AppMethodBeat.o(317780);
  }
  
  public final boolean b(ActivityManager.AppTask paramAppTask)
  {
    AppMethodBeat.i(317783);
    s.u(paramAppTask, "appTask");
    paramAppTask = paramAppTask.getTaskInfo();
    if ((paramAppTask != null) && (!paramAppTask.isRunning))
    {
      AppMethodBeat.o(317783);
      return true;
    }
    AppMethodBeat.o(317783);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.e
 * JD-Core Version:    0.7.0.1
 */