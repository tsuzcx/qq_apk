package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ad;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizRecFeedReport;", "", "()V", "reportIdKey1590", "", "value", "", "reportKv22101", "actionType", "", "position", "reportKvRefreshData", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o ojb;
  
  static
  {
    AppMethodBeat.i(241884);
    ojb = new o();
    AppMethodBeat.o(241884);
  }
  
  public static void eA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241880);
    int i = ad.getSessionId();
    h.OAn.b(22718, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), String.valueOf(i) });
    AppMethodBeat.o(241880);
  }
  
  public static void ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241876);
    int i = ad.getSessionId();
    h.OAn.b(22101, new Object[] { String.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(241876);
  }
  
  public static void ir(long paramLong)
  {
    AppMethodBeat.i(241871);
    h.OAn.idkeyStat(1590L, paramLong, 1L, false);
    AppMethodBeat.o(241871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.model.o
 * JD-Core Version:    0.7.0.1
 */