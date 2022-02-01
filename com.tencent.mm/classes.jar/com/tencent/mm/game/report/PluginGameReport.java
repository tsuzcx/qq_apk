package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.a;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;

public class PluginGameReport
  extends f
  implements c
{
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(108252);
    if ((paramg.aIE()) || (paramg.MY(":tools")) || (paramg.MY(":toolsmp")))
    {
      com.tencent.mm.game.report.api.a.jTp = new b();
      h.b(com.tencent.mm.game.report.a.b.class, new a());
    }
    AppMethodBeat.o(108252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.PluginGameReport
 * JD-Core Version:    0.7.0.1
 */