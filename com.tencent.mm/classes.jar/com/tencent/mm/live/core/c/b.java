package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/report/LiveKVReporter;", "", "()V", "liveId64", "", "scene", "", "visitorMode", "reportDecodeErr", "", "moduleName", "", "eventCode", "eventMsg", "setup", "liveId", "plugin-core_release"})
public final class b
{
  private static int hEH;
  private static long hEI;
  public static final b hEJ;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(196714);
    hEJ = new b();
    Object localObject = e.f.hxS;
    scene = e.f.aCO();
    localObject = e.a.hxc;
    hEH = e.a.aCe();
    AppMethodBeat.o(196714);
  }
  
  public static void d(int paramInt1, int paramInt2, long paramLong)
  {
    scene = paramInt1;
    hEH = paramInt2;
    hEI = paramLong;
  }
  
  public static void h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(196713);
    fq localfq = new fq();
    localfq.sD(paramString1);
    localfq.pg(paramInt);
    localfq.sE(paramString2);
    localfq.pi(localfq.agC());
    localfq.pj(hEH);
    localfq.ph(hEI);
    localfq.bfK();
    AppMethodBeat.o(196713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */