package com.tencent.mm.plugin.auto.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/auto/model/AutoReportLogic;", "", "()V", "IDKey", "", "getIDKey", "()J", "reportIdKey", "", "action", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b uVJ;
  private static final long uVK;
  
  static
  {
    AppMethodBeat.i(260345);
    uVJ = new b();
    uVK = 1496L;
    AppMethodBeat.o(260345);
  }
  
  public static void jX(long paramLong)
  {
    AppMethodBeat.i(260343);
    f.Ozc.idkeyStat(uVK, paramLong, 1L, false);
    AppMethodBeat.o(260343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.model.b
 * JD-Core Version:    0.7.0.1
 */