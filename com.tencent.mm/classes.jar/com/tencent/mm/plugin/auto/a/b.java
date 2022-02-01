package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/auto/model/AutoReportLogic;", "", "()V", "IDKey", "", "getIDKey", "()J", "reportIdKey", "", "action", "app_release"})
public final class b
{
  private static final long nxH = 1496L;
  public static final b nxI;
  
  static
  {
    AppMethodBeat.i(188243);
    nxI = new b();
    nxH = 1496L;
    AppMethodBeat.o(188243);
  }
  
  public static void tn(long paramLong)
  {
    AppMethodBeat.i(188242);
    e.ywz.idkeyStat(nxH, paramLong, 1L, false);
    AppMethodBeat.o(188242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.b
 * JD-Core Version:    0.7.0.1
 */