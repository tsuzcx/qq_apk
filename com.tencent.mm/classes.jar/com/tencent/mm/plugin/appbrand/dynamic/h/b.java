package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  private static final ap hqy;
  
  static
  {
    AppMethodBeat.i(10953);
    hqy = new ap(new b.1(), true);
    AppMethodBeat.o(10953);
  }
  
  public static void aAb()
  {
    AppMethodBeat.i(10950);
    if (!e.lZ("com.tencent.mm:support"))
    {
      ab.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(10950);
      return;
    }
    int i = b.a.PY().size();
    if (i != 0)
    {
      ab.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(10950);
      return;
    }
    ab.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    hqy.ag(60000L, 60000L);
    AppMethodBeat.o(10950);
  }
  
  public static void aAc()
  {
    AppMethodBeat.i(10951);
    if (!e.lZ("com.tencent.mm:support"))
    {
      ab.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      AppMethodBeat.o(10951);
      return;
    }
    ab.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    hqy.postDelayed(new b.2(), 500L);
    AppMethodBeat.o(10951);
  }
  
  public static void aAd()
  {
    AppMethodBeat.i(10952);
    ab.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    if (com.tencent.mm.ipcinvoker.b.PK().lX("com.tencent.mm:tools")) {
      f.a("com.tencent.mm:tools", null, c.class, new b.3());
    }
    if (com.tencent.mm.ipcinvoker.b.PK().lX("com.tencent.mm:toolsmp")) {
      f.a("com.tencent.mm:toolsmp", null, c.class, new b.4());
    }
    if (com.tencent.mm.ipcinvoker.b.PK().lX("com.tencent.mm:support")) {
      f.a("com.tencent.mm:support", null, c.class, new b.5());
    }
    AppMethodBeat.o(10952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */