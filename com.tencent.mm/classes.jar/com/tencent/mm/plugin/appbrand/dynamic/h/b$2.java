package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class b$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(121427);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(121427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b.2
 * JD-Core Version:    0.7.0.1
 */