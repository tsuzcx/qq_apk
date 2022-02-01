package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;

final class a
  extends s
{
  private static final int CTRL_INDEX = 246;
  private static final String NAME = "onStartReportPageData";
  private static final a snc;
  
  static
  {
    AppMethodBeat.i(147208);
    snc = new a();
    AppMethodBeat.o(147208);
  }
  
  static void q(f paramf)
  {
    try
    {
      AppMethodBeat.i(147207);
      snc.h(paramf).cpV();
      AppMethodBeat.o(147207);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.a
 * JD-Core Version:    0.7.0.1
 */