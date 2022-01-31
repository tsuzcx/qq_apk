package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bg.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class m$1
  implements Runnable
{
  m$1(m paramm, bg parambg) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(42326);
    if (!bo.isNullOrNil(this.fBb.coI.filePath))
    {
      if (!m.aN(this.fBb.coI.subType, this.fBb.coI.filePath)) {
        break label140;
      }
      if (!m.eC(this.fBb.coI.subType, this.fBb.coI.coK)) {
        break label125;
      }
      ab.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "not retry");
    }
    for (;;)
    {
      b.c.dmg().e(this.fBb.coI.coJ, this.fBb.coI.subType, this.fBb.coI.coK, bool);
      AppMethodBeat.o(42326);
      return;
      label125:
      h.qsU.cT(991, 1);
      bool = false;
      continue;
      label140:
      h.qsU.cT(991, 2);
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m.1
 * JD-Core Version:    0.7.0.1
 */