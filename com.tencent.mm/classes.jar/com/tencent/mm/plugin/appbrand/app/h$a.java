package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$AppBrandTaskPredicate;", "", "()V", "isAppBrandTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$a
{
  public static final a qBY;
  
  static
  {
    AppMethodBeat.i(317782);
    qBY = new a();
    AppMethodBeat.o(317782);
  }
  
  public static boolean a(ActivityManager.AppTask paramAppTask)
  {
    int i = 1;
    AppMethodBeat.i(317777);
    s.u(paramAppTask, "appTask");
    paramAppTask = paramAppTask.getTaskInfo();
    if (paramAppTask == null) {}
    for (paramAppTask = null; paramAppTask == null; paramAppTask = paramAppTask.baseIntent)
    {
      AppMethodBeat.o(317777);
      return false;
    }
    if (!s.p(paramAppTask.getAction(), "android.intent.action.MAIN"))
    {
      localObject = paramAppTask.getCategories();
      if ((localObject == null) || (((Set)localObject).contains("android.intent.category.LAUNCHER") != true)) {
        break label87;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(317777);
      return false;
      label87:
      i = 0;
    }
    paramAppTask = paramAppTask.getComponent();
    if (paramAppTask == null)
    {
      AppMethodBeat.o(317777);
      return false;
    }
    paramAppTask = paramAppTask.getClassName();
    s.s(paramAppTask, "cmp.className");
    Object localObject = AppBrandUI.class.getName();
    s.s(localObject, "AppBrandUI::class.java.name");
    boolean bool = n.U(paramAppTask, (String)localObject, false);
    AppMethodBeat.o(317777);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.a
 * JD-Core Version:    0.7.0.1
 */