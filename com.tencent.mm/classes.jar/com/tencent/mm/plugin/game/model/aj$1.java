package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class aj$1
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(111416);
    g.Rc().b(2641, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
      al.d(new aj.1.1(this, ((aj)paramm).bGU()));
      AppMethodBeat.o(111416);
      return;
    }
    ab.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
    AppMethodBeat.o(111416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj.1
 * JD-Core Version:    0.7.0.1
 */