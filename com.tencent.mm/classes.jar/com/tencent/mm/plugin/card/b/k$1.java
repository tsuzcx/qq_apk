package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;

final class k$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(87739);
    ab.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
    g.RL().Ru().set(ac.a.yyT, "");
    g.RL().Ru().set(ac.a.yyZ, Integer.valueOf(0));
    g.RL().Ru().set(ac.a.yyW, "");
    g.RL().Ru().set(ac.a.yyX, "");
    g.RL().Ru().set(ac.a.yyY, "");
    g.RL().Ru().set(ac.a.yzk, "");
    g.RL().Ru().set(ac.a.yzl, Boolean.FALSE);
    if (c.PJ().cd(262152, 266256)) {
      c.PJ().y(262152, false);
    }
    if (c.PJ().cc(262152, 266256)) {
      c.PJ().x(262152, false);
    }
    if (c.PJ().a(ac.a.yyN, ac.a.yyP)) {
      c.PJ().a(ac.a.yyN, false);
    }
    if (c.PJ().a(ac.a.yyO, ac.a.yyQ)) {
      c.PJ().a(ac.a.yyO, false);
    }
    ab.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    AppMethodBeat.o(87739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k.1
 * JD-Core Version:    0.7.0.1
 */