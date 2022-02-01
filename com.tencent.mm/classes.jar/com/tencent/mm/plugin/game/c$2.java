package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;

final class c$2
  extends d
{
  c$2(c paramc) {}
  
  public final b agM(String paramString)
  {
    AppMethodBeat.i(40825);
    ia localia = new ia();
    localia.djd.cZV = paramString;
    AppMethodBeat.o(40825);
    return localia;
  }
  
  public final k cOj()
  {
    AppMethodBeat.i(40826);
    s locals = ((e)g.ab(e.class)).cOm();
    AppMethodBeat.o(40826);
    return locals;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.2
 * JD-Core Version:    0.7.0.1
 */