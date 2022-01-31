package com.tencent.mm.game.report;

import com.tencent.mm.game.report.api.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginGameReport
  extends f
  implements e
{
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    if ((paramg.Ex()) || (paramg.gn(":tools")))
    {
      com.tencent.mm.game.report.api.c.dCx = new b();
      com.tencent.mm.game.report.api.b.dCw = new a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.game.report.PluginGameReport
 * JD-Core Version:    0.7.0.1
 */