package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class c$13
  extends n.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(206791);
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      a.aiE();
    }
    AppMethodBeat.o(206791);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(206790);
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      if (!a.aiE())
      {
        paramString = Long.valueOf(bt.g((Long)g.ajC().ajl().get(al.a.IAm, Long.valueOf(0L))));
        if ((paramString.longValue() != 0L) && (bt.aQJ() > paramString.longValue())) {
          b.cWV().mW(true);
        }
      }
    }
    AppMethodBeat.o(206790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.13
 * JD-Core Version:    0.7.0.1
 */