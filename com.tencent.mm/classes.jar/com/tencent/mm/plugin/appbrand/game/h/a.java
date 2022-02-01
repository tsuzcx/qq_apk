package com.tencent.mm.plugin.appbrand.game.h;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart;", "", "()V", "prepare_restart", "", "selfRestart", "suicide", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a rug;
  
  static
  {
    AppMethodBeat.i(50397);
    rug = new a();
    AppMethodBeat.o(50397);
  }
  
  public static void cpp()
  {
    AppMethodBeat.i(50396);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = PendingIntent.getActivity((Context)localObject2, -1, ((Context)localObject2).getPackageManager().getLaunchIntentForPackage(((Context)localObject2).getPackageName()), 268435456);
    localObject2 = (AlarmManager)((Context)localObject2).getSystemService("alarm");
    s.checkNotNull(localObject2);
    localObject1 = c.a(1, c.a(System.currentTimeMillis() + 100L, new com.tencent.mm.hellhoundlib.b.a().cG(localObject1)));
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "prepare_restart", "()V", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    ((AlarmManager)localObject2).set(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue(), ((Long)c.a((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(1)).longValue(), (PendingIntent)c.aYk().sb(2));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "prepare_restart", "()V", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    AppMethodBeat.o(50396);
  }
  
  public static void suicide()
  {
    AppMethodBeat.i(50395);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(50395);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    s.s(localObject1, "am.runningAppProcesses");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      Object localObject3 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
      s.s(localObject3, "it.processName");
      if (n.i((CharSequence)localObject3, (CharSequence)s.X(MMApplicationContext.getPackageName(), ":")))
      {
        localObject2 = c.a(((ActivityManager.RunningAppProcessInfo)localObject2).pid, new com.tencent.mm.hellhoundlib.b.a());
        localObject3 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(50395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.a
 * JD-Core Version:    0.7.0.1
 */