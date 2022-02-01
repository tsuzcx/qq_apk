package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class b
{
  private static final av jnH;
  
  static
  {
    AppMethodBeat.i(121434);
    jnH = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(121426);
        BaseIPCService localBaseIPCService = j.adw().qs("com.tencent.mm:support");
        if (localBaseIPCService != null) {
          localBaseIPCService.dv(false);
        }
        AppMethodBeat.o(121426);
        return false;
      }
    }, true);
    AppMethodBeat.o(121434);
  }
  
  public static void aVI()
  {
    AppMethodBeat.i(121431);
    if (!g.qp("com.tencent.mm:support"))
    {
      ad.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121431);
      return;
    }
    int i = b.a.adL().size();
    if (i != 0)
    {
      ad.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(121431);
      return;
    }
    ad.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    jnH.av(60000L, 60000L);
    AppMethodBeat.o(121431);
  }
  
  public static void aVJ()
  {
    AppMethodBeat.i(121432);
    if (!g.qp("com.tencent.mm:support"))
    {
      ad.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(121432);
      return;
    }
    ad.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    jnH.postDelayed(new b.2(), 500L);
    AppMethodBeat.o(121432);
  }
  
  public static void aVK()
  {
    AppMethodBeat.i(121433);
    ad.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    if (com.tencent.mm.ipcinvoker.c.ads().qn("com.tencent.mm:tools")) {
      h.a("com.tencent.mm:tools", null, c.class, new d() {});
    }
    if (com.tencent.mm.ipcinvoker.c.ads().qn("com.tencent.mm:toolsmp")) {
      h.a("com.tencent.mm:toolsmp", null, c.class, new d() {});
    }
    if (com.tencent.mm.ipcinvoker.c.ads().qn("com.tencent.mm:support")) {
      h.a("com.tencent.mm:support", null, c.class, new d() {});
    }
    AppMethodBeat.o(121433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */