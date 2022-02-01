package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ab;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizRecFeedReport;", "", "()V", "reportIdKey1590", "", "value", "", "reportKv22101", "actionType", "", "position", "reportKvRefreshData", "plugin-biz_release"})
public final class o
{
  public static final o lrA;
  
  static
  {
    AppMethodBeat.i(206727);
    lrA = new o();
    AppMethodBeat.o(206727);
  }
  
  public static void Gh(long paramLong)
  {
    AppMethodBeat.i(206720);
    h.IzE.idkeyStat(1590L, paramLong, 1L, false);
    AppMethodBeat.o(206720);
  }
  
  public static void dF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206722);
    int i = ab.getSessionId();
    h.IzE.a(22101, new Object[] { String.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(206722);
  }
  
  public static void dG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206725);
    int i = ab.getSessionId();
    h.IzE.a(22718, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), String.valueOf(i) });
    AppMethodBeat.o(206725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.o
 * JD-Core Version:    0.7.0.1
 */