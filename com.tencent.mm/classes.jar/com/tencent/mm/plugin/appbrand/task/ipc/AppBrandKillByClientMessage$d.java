package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class AppBrandKillByClientMessage$d
  implements Runnable
{
  public static final d qSi;
  
  static
  {
    AppMethodBeat.i(282854);
    qSi = new d();
    AppMethodBeat.o(282854);
  }
  
  public final void run()
  {
    AppMethodBeat.i(282853);
    b.bgM();
    AppBrandProcessSuicideLogic.bFq();
    Log.appenderFlushSync();
    Object localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage$silentKill$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage$silentKill$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage$silentKill$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage$silentKill$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    AppMethodBeat.o(282853);
    throw ((Throwable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage.d
 * JD-Core Version:    0.7.0.1
 */