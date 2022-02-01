package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/auto/model/AutoReportLogic;", "", "()V", "IDKey", "", "getIDKey", "()J", "reportIdKey", "", "action", "app_release"})
public final class b
{
  private static final long rKv = 1496L;
  public static final b rKw;
  
  static
  {
    AppMethodBeat.i(275670);
    rKw = new b();
    rKv = 1496L;
    AppMethodBeat.o(275670);
  }
  
  public static void HG(long paramLong)
  {
    AppMethodBeat.i(275667);
    f.Iyx.idkeyStat(rKv, paramLong, 1L, false);
    AppMethodBeat.o(275667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.b
 * JD-Core Version:    0.7.0.1
 */