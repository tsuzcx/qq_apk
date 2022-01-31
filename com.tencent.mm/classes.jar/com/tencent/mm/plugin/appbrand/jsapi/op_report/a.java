package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;

final class a
  extends p
{
  private static final int CTRL_INDEX = 246;
  private static final String NAME = "onStartReportPageData";
  private static final a hVp;
  
  static
  {
    AppMethodBeat.i(102004);
    hVp = new a();
    AppMethodBeat.o(102004);
  }
  
  static void k(c paramc)
  {
    try
    {
      AppMethodBeat.i(102003);
      hVp.i(paramc).aBz();
      AppMethodBeat.o(102003);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.a
 * JD-Core Version:    0.7.0.1
 */