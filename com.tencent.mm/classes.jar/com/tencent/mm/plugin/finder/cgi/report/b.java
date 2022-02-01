package com.tencent.mm.plugin.finder.cgi.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "", "(Ljava/lang/String;I)V", "Default", "Enable", "Disable", "plugin-finder_release"})
public enum b
{
  static
  {
    AppMethodBeat.i(242685);
    b localb1 = new b("Default", 0);
    tyd = localb1;
    b localb2 = new b("Enable", 1);
    tye = localb2;
    b localb3 = new b("Disable", 2);
    tyf = localb3;
    tyg = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(242685);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.report.b
 * JD-Core Version:    0.7.0.1
 */