package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static void a(a.a parama)
  {
    AppMethodBeat.i(54958);
    ab.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    h.qsU.e(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.cpt) });
    AppMethodBeat.o(54958);
  }
  
  public static void a(a.b paramb, String paramString)
  {
    AppMethodBeat.i(54957);
    h localh = h.qsU;
    int j = paramb.scene;
    if (paramb.eUJ) {}
    for (int i = 2;; i = 1)
    {
      localh.e(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.oKq), Integer.valueOf(paramb.oKr), Integer.valueOf(paramb.oKt), Boolean.valueOf(paramb.oKs), Integer.valueOf(paramb.ect), Integer.valueOf(paramb.oKo), Integer.valueOf(paramb.oKp), Integer.valueOf(paramb.oKu), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(bo.aox()) });
      ab.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(54957);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */