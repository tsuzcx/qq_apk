package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g$1
  implements Runnable
{
  public g$1(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(275444);
    Log.i("MicroMsg.GameControlCmdParser", "MicroMsg.Wepkg message pkgid:%s, downloadTriggerType:%d, downloadType:%d", new Object[] { this.ICM, Integer.valueOf(this.ICN), Integer.valueOf(this.ICO) });
    if (!Util.isNullOrNil(this.ICM))
    {
      aee localaee = new aee();
      localaee.iiI.hAf = 1;
      localaee.iiI.iiJ = this.ICM;
      localaee.iiI.iiM = this.ICN;
      localaee.iiI.iiN = this.ICO;
      localaee.publish();
      if (this.ICP) {
        h.OAn.idkeyStat(858L, 15L, 1L, false);
      }
    }
    AppMethodBeat.o(275444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g.1
 * JD-Core Version:    0.7.0.1
 */