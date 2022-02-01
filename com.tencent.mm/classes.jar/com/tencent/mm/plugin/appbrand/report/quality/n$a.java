package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
 enum n$a
{
  static
  {
    AppMethodBeat.i(189596);
    a locala1 = new a("START", 0);
    mwd = locala1;
    a locala2 = new a("OK", 1);
    mwe = locala2;
    a locala3 = new a("FAIL", 2);
    mwf = locala3;
    mwg = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(189596);
  }
  
  private n$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.n.a
 * JD-Core Version:    0.7.0.1
 */