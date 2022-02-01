package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder_release"})
public final class e$e
{
  private static final int qGa = 19441;
  private static final long qGb = 1253L;
  public static final e qGc;
  
  static
  {
    AppMethodBeat.i(178399);
    qGc = new e();
    qGa = 19441;
    qGb = 1253L;
    AppMethodBeat.o(178399);
  }
  
  public static void Y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178398);
    h localh = h.vKh;
    int i = qGa;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    localh.f(i, new Object[] { str, paramString1, paramString2 });
    h.vKh.m(qGb, 33L, 1L);
    AppMethodBeat.o(178398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e.e
 * JD-Core Version:    0.7.0.1
 */