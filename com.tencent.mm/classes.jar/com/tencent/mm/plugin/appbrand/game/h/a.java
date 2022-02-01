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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart;", "", "()V", "prepare_restart", "", "selfRestart", "suicide", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lvA;
  
  static
  {
    AppMethodBeat.i(50397);
    lvA = new a();
    AppMethodBeat.o(50397);
  }
  
  public static void bDC()
  {
    AppMethodBeat.i(50396);
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "context");
    PendingIntent localPendingIntent = PendingIntent.getActivity((Context)localObject, -1, ((Context)localObject).getPackageManager().getLaunchIntentForPackage(((Context)localObject).getPackageName()), 268435456);
    localObject = (AlarmManager)((Context)localObject).getSystemService("alarm");
    if (localObject == null) {
      p.hyc();
    }
    ((AlarmManager)localObject).set(1, System.currentTimeMillis() + 100L, localPendingIntent);
    AppMethodBeat.o(50396);
  }
  
  public static void suicide()
  {
    AppMethodBeat.i(50395);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(50395);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    p.g(localObject1, "am.runningAppProcesses");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      Object localObject3 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
      p.g(localObject3, "it.processName");
      if (n.e((CharSequence)localObject3, (CharSequence)(MMApplicationContext.getPackageName() + ":")))
      {
        localObject2 = c.a(((ActivityManager.RunningAppProcessInfo)localObject2).pid, new com.tencent.mm.hellhoundlib.b.a());
        localObject3 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(50395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.a
 * JD-Core Version:    0.7.0.1
 */