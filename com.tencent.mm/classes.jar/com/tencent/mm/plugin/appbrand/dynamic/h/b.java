package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class b
{
  private static final MTimerHandler lpf;
  
  static
  {
    AppMethodBeat.i(121434);
    lpf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(121426);
        BaseIPCService localBaseIPCService = j.aya().Fs(SupportProcessIPCService.dkO);
        if (localBaseIPCService != null) {
          localBaseIPCService.eo(false);
        }
        AppMethodBeat.o(121426);
        return false;
      }
    }, true);
    AppMethodBeat.o(121434);
  }
  
  public static void bCl()
  {
    AppMethodBeat.i(121431);
    if (!g.Fp(SupportProcessIPCService.dkO))
    {
      Log.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121431);
      return;
    }
    int i = b.a.ayr().size();
    if (i != 0)
    {
      Log.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(121431);
      return;
    }
    Log.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    lpf.startTimer(60000L);
    AppMethodBeat.o(121431);
  }
  
  public static void bCm()
  {
    AppMethodBeat.i(121432);
    if (!g.Fp(SupportProcessIPCService.dkO))
    {
      Log.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121432);
      return;
    }
    Log.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    lpf.postDelayed(new b.2(), 500L);
    AppMethodBeat.o(121432);
  }
  
  public static void bCn()
  {
    AppMethodBeat.i(121433);
    Log.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    String str = ToolsProcessIPCService.dkO;
    if (com.tencent.mm.ipcinvoker.c.axW().Fo(str)) {
      h.a(ToolsProcessIPCService.dkO, null, c.class, new d() {});
    }
    str = ToolsMpProcessIPCService.dkO;
    if (com.tencent.mm.ipcinvoker.c.axW().Fo(str)) {
      h.a(ToolsMpProcessIPCService.dkO, null, c.class, new d() {});
    }
    str = SupportProcessIPCService.dkO;
    if (com.tencent.mm.ipcinvoker.c.axW().Fo(str)) {
      h.a(SupportProcessIPCService.dkO, null, c.class, new d() {});
    }
    AppMethodBeat.o(121433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */