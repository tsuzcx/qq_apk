package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class g$3
  implements Runnable
{
  g$3(g paramg) {}
  
  public final void run()
  {
    if ((g.a(this.iHa) != null) && (g.b(this.iHa)) && (g.c(this.iHa) == null))
    {
      y.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
      h.nFQ.a(699L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.3
 * JD-Core Version:    0.7.0.1
 */