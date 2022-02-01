package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class b
{
  private static final MTimerHandler ojP;
  
  static
  {
    AppMethodBeat.i(121434);
    ojP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(121426);
        BaseIPCService localBaseIPCService = l.aFs().Ms(SupportProcessIPCService.PROCESS_NAME);
        if (localBaseIPCService != null) {
          localBaseIPCService.eM(false);
        }
        AppMethodBeat.o(121426);
        return false;
      }
    }, true);
    AppMethodBeat.o(121434);
  }
  
  public static void RP()
  {
    AppMethodBeat.i(121432);
    if (!i.Mo(SupportProcessIPCService.PROCESS_NAME))
    {
      Log.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121432);
      return;
    }
    Log.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    ojP.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121427);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(121427);
      }
    }, 500L);
    AppMethodBeat.o(121432);
  }
  
  public static void bNH()
  {
    AppMethodBeat.i(121431);
    if (!i.Mo(SupportProcessIPCService.PROCESS_NAME))
    {
      Log.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121431);
      return;
    }
    int i = b.a.aFK().size();
    if (i != 0)
    {
      Log.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(121431);
      return;
    }
    Log.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    ojP.startTimer(60000L);
    AppMethodBeat.o(121431);
  }
  
  public static void bNI()
  {
    AppMethodBeat.i(121433);
    Log.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    String str = ToolsProcessIPCService.PROCESS_NAME;
    if (e.aFo().Ml(str)) {
      j.a(ToolsProcessIPCService.PROCESS_NAME, null, c.class, new f() {});
    }
    str = ToolsMpProcessIPCService.PROCESS_NAME;
    if (e.aFo().Ml(str)) {
      j.a(ToolsMpProcessIPCService.PROCESS_NAME, null, c.class, new f() {});
    }
    str = SupportProcessIPCService.PROCESS_NAME;
    if (e.aFo().Ml(str)) {
      j.a(SupportProcessIPCService.PROCESS_NAME, null, c.class, new f() {});
    }
    AppMethodBeat.o(121433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */