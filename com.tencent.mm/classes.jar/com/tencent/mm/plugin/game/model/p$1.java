package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class p$1
  implements Runnable
{
  public p$1(String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(111299);
    ab.i("MicroMsg.GameMessageParser", "MicroMsg.Wepkg message pkgid:%s, downloadTriggerType:%d", new Object[] { this.nom, Integer.valueOf(this.non) });
    if (!bo.isNullOrNil(this.nom))
    {
      wi localwi = new wi();
      localwi.cNO.coO = 1;
      localwi.cNO.cNP = this.nom;
      localwi.cNO.cNS = this.non;
      a.ymk.l(localwi);
      h.qsU.idkeyStat(858L, 15L, 1L, false);
    }
    AppMethodBeat.o(111299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p.1
 * JD-Core Version:    0.7.0.1
 */