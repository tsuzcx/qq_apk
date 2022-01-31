package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class h$1
  implements Runnable
{
  h$1(h paramh, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(111536);
    com.tencent.mm.pluginsdk.model.app.f localf = g.bZ(this.npM.field_appId, false);
    if (g.a(ah.getContext(), localf))
    {
      ab.i("MicroMsg.GameSilentDownloader", "app is installed, appid = %s", new Object[] { this.npM.field_appId });
      f.O(this.npM.field_appId, 4, 0);
      al.d(new h.1.1(this));
      AppMethodBeat.o(111536);
      return;
    }
    al.d(new h.1.2(this));
    AppMethodBeat.o(111536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h.1
 * JD-Core Version:    0.7.0.1
 */