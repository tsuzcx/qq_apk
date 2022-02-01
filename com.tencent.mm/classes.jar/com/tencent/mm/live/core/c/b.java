package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hi;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/report/LiveKVReporter;", "", "()V", "liveId64", "", "scene", "", "visitorMode", "reportDecodeErr", "", "moduleName", "", "eventCode", "eventMsg", "sdkLiveId", "anchorNickname", "setup", "liveId", "plugin-core_release"})
public final class b
{
  private static int ksM;
  private static long ksN;
  public static final b ksO;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(199253);
    ksO = new b();
    Object localObject = e.g.kkm;
    scene = e.g.aKs();
    localObject = e.b.kjz;
    ksM = e.b.aJJ();
    AppMethodBeat.o(199253);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(199252);
    p.k(paramString3, "anchorNickname");
    hi localhi = new hi();
    localhi.wq(paramString1);
    localhi.rt(paramInt1);
    localhi.wr(paramString2);
    localhi.rv(localhi.alF());
    localhi.rw(ksM);
    localhi.ru(ksN);
    localhi.rz(paramInt2);
    localhi.ws(paramString3);
    localhi.bpa();
    AppMethodBeat.o(199252);
  }
  
  public static void d(int paramInt1, int paramInt2, long paramLong)
  {
    scene = paramInt1;
    ksM = paramInt2;
    ksN = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */