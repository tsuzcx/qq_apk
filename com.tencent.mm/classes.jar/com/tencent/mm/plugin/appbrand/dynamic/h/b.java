package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static final am fWY = new am(new b.1(), true);
  
  public static void afx()
  {
    if (!e.fE("com.tencent.mm:support"))
    {
      y.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      return;
    }
    int i = b.a.Cg().size();
    if (i != 0)
    {
      y.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[] { Integer.valueOf(i) });
      return;
    }
    y.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
    fWY.S(60000L, 60000L);
  }
  
  public static void afy()
  {
    if (!e.fE("com.tencent.mm:support"))
    {
      y.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
      return;
    }
    y.i("MicroMsg.DynamicProcessPerformance", "kill support process");
    fWY.postDelayed(new b.2(), 500L);
  }
  
  public static void afz()
  {
    y.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
    if (com.tencent.mm.ipcinvoker.b.BT().fC("com.tencent.mm:tools")) {
      f.a("com.tencent.mm:tools", null, c.class, new b.3());
    }
    if (com.tencent.mm.ipcinvoker.b.BT().fC("com.tencent.mm:toolsmp")) {
      f.a("com.tencent.mm:toolsmp", null, c.class, new b.4());
    }
    if (com.tencent.mm.ipcinvoker.b.BT().fC("com.tencent.mm:support")) {
      f.a("com.tencent.mm:support", null, c.class, new b.5());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b
 * JD-Core Version:    0.7.0.1
 */