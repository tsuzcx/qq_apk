package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class c$13
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(195600);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      a.aiT();
    }
    AppMethodBeat.o(195600);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(195599);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!a.aiT())
      {
        paramString = Long.valueOf(bu.i((Long)g.ajR().ajA().get(am.a.IUL, Long.valueOf(0L))));
        if ((paramString.longValue() != 0L) && (bu.aRi() > paramString.longValue())) {
          b.cZC().na(true);
        }
      }
    }
    AppMethodBeat.o(195599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.13
 * JD-Core Version:    0.7.0.1
 */