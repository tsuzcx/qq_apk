package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class aj$3
  implements c
{
  aj$3(String paramString, List paramList, aj.a parama) {}
  
  public final void cZ(boolean paramVarArgs)
  {
    AppMethodBeat.i(151885);
    ab.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramVarArgs), this.lgT });
    aj.b(this.npk, this.npl);
    AppMethodBeat.o(151885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj.3
 * JD-Core Version:    0.7.0.1
 */