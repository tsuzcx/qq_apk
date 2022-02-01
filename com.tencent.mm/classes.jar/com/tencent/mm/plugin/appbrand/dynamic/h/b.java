package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class b
{
  private static final au jNT;
  
  static
  {
    AppMethodBeat.i(121434);
    jNT = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(121426);
        BaseIPCService localBaseIPCService = j.aeM().tH("com.tencent.mm:support");
        if (localBaseIPCService != null) {
          localBaseIPCService.dv(false);
        }
        AppMethodBeat.o(121426);
        return false;
      }
    }, true);
    AppMethodBeat.o(121434);
  }
  
  public static void bcG()
  {
    AppMethodBeat.i(121431);
    if (!g.tE("com.tencent.mm:support"))
    {
      ac.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121431);
      return;
    }
    int i = b.a.afb().size();
    if (i != 0)
    {
      ac.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(121431);
      return;
    }
    ac.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    jNT.au(60000L, 60000L);
    AppMethodBeat.o(121431);
  }
  
  public static void bcH()
  {
    AppMethodBeat.i(121432);
    if (!g.tE("com.tencent.mm:support"))
    {
      ac.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121432);
      return;
    }
    ac.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    jNT.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121427);
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(121427);
      }
    }, 500L);
    AppMethodBeat.o(121432);
  }
  
  public static void bcI()
  {
    AppMethodBeat.i(121433);
    ac.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    if (com.tencent.mm.ipcinvoker.c.aeI().tC("com.tencent.mm:tools")) {
      h.a("com.tencent.mm:tools", null, c.class, new d() {});
    }
    if (com.tencent.mm.ipcinvoker.c.aeI().tC("com.tencent.mm:toolsmp")) {
      h.a("com.tencent.mm:toolsmp", null, c.class, new d() {});
    }
    if (com.tencent.mm.ipcinvoker.c.aeI().tC("com.tencent.mm:support")) {
      h.a("com.tencent.mm:support", null, c.class, new d() {});
    }
    AppMethodBeat.o(121433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */