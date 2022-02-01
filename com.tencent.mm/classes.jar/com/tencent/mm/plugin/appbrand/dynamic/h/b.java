package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;

public final class b
{
  private static final aw klu;
  
  static
  {
    AppMethodBeat.i(121434);
    klu = new aw(new b.1(), true);
    AppMethodBeat.o(121434);
  }
  
  public static void bgS()
  {
    AppMethodBeat.i(121431);
    if (!g.xd("com.tencent.mm:support"))
    {
      ae.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121431);
      return;
    }
    int i = b.a.aic().size();
    if (i != 0)
    {
      ae.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(121431);
      return;
    }
    ae.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    klu.ay(60000L, 60000L);
    AppMethodBeat.o(121431);
  }
  
  public static void bgT()
  {
    AppMethodBeat.i(121432);
    if (!g.xd("com.tencent.mm:support"))
    {
      ae.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121432);
      return;
    }
    ae.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    klu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121427);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(121427);
      }
    }, 500L);
    AppMethodBeat.o(121432);
  }
  
  public static void bgU()
  {
    AppMethodBeat.i(121433);
    ae.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    if (com.tencent.mm.ipcinvoker.c.ahJ().xb("com.tencent.mm:tools")) {
      h.a("com.tencent.mm:tools", null, c.class, new d() {});
    }
    if (com.tencent.mm.ipcinvoker.c.ahJ().xb("com.tencent.mm:toolsmp")) {
      h.a("com.tencent.mm:toolsmp", null, c.class, new d() {});
    }
    if (com.tencent.mm.ipcinvoker.c.ahJ().xb("com.tencent.mm:support")) {
      h.a("com.tencent.mm:support", null, c.class, new d() {});
    }
    AppMethodBeat.o(121433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */