package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder_release"})
public final class i$e
{
  private static final int ryU = 19441;
  private static final long ryV = 1253L;
  public static final e ryW;
  
  static
  {
    AppMethodBeat.i(178399);
    ryW = new e();
    ryU = 19441;
    ryV = 1253L;
    AppMethodBeat.o(178399);
  }
  
  public static void Y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178398);
    h localh = h.wUl;
    int i = ryU;
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
    h.wUl.n(ryV, 33L, 1L);
    AppMethodBeat.o(178398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i.e
 * JD-Core Version:    0.7.0.1
 */