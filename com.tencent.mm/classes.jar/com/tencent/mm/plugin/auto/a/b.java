package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/auto/model/AutoReportLogic;", "", "()V", "IDKey", "", "getIDKey", "()J", "reportIdKey", "", "action", "app_release"})
public final class b
{
  private static final long oIF = 1496L;
  public static final b oIG;
  
  static
  {
    AppMethodBeat.i(230598);
    oIG = new b();
    oIF = 1496L;
    AppMethodBeat.o(230598);
  }
  
  public static void Bt(long paramLong)
  {
    AppMethodBeat.i(230597);
    e.Cxv.idkeyStat(oIF, paramLong, 1L, false);
    AppMethodBeat.o(230597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.b
 * JD-Core Version:    0.7.0.1
 */