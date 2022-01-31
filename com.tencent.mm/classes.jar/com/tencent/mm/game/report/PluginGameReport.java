package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.kernel.b.f;

public class PluginGameReport
  extends f
  implements c
{
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(59584);
    if ((paramg.SD()) || (paramg.mI(":tools")))
    {
      com.tencent.mm.game.report.api.a.ezM = new a();
      com.tencent.mm.kernel.g.b(b.class, new com.tencent.mm.game.report.a.a());
    }
    AppMethodBeat.o(59584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.PluginGameReport
 * JD-Core Version:    0.7.0.1
 */