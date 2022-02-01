package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jg;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/report/LiveKVReporter;", "", "()V", "liveId64", "", "scene", "", "visitorMode", "reportDecodeErr", "", "moduleName", "", "eventCode", "eventMsg", "sdkLiveId", "anchorNickname", "setup", "liveId", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b mWD;
  private static int mWE;
  private static long mWF;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(247521);
    mWD = new b();
    Object localObject = e.h.mKY;
    scene = e.h.bdi();
    localObject = e.b.mKf;
    mWE = e.b.bct();
    AppMethodBeat.o(247521);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(247513);
    s.u(paramString3, "anchorNickname");
    jg localjg = new jg();
    localjg.rZ(paramString1);
    localjg.iSo = paramInt1;
    localjg.sa(paramString2);
    localjg.iuA = localjg.iuA;
    localjg.iSq = mWE;
    localjg.iDB = mWF;
    localjg.iSt = paramInt2;
    localjg.sb(paramString3);
    localjg.bMH();
    AppMethodBeat.o(247513);
  }
  
  public static void d(int paramInt1, int paramInt2, long paramLong)
  {
    scene = paramInt1;
    mWE = paramInt2;
    mWF = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */