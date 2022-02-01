package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ab;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizRecFeedReport;", "", "()V", "reportIdKey1590", "", "value", "", "reportKv22101", "actionType", "", "position", "plugin-biz_release"})
public final class o
{
  public static final o iBV;
  
  static
  {
    AppMethodBeat.i(212379);
    iBV = new o();
    AppMethodBeat.o(212379);
  }
  
  public static void Aa(long paramLong)
  {
    AppMethodBeat.i(212377);
    h.CyF.idkeyStat(1590L, paramLong, 1L, false);
    AppMethodBeat.o(212377);
  }
  
  public static void dk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212378);
    int i = ab.getSessionId();
    h.CyF.a(22101, new Object[] { String.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(212378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.o
 * JD-Core Version:    0.7.0.1
 */