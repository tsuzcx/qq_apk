package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.storage.MStorage;

final class c$4
  extends d
{
  c$4(c paramc)
  {
    AppMethodBeat.i(161115);
    AppMethodBeat.o(161115);
  }
  
  public final IEvent azl(String paramString)
  {
    AppMethodBeat.i(204075);
    ix localix = new ix();
    localix.dNB.event = paramString;
    AppMethodBeat.o(204075);
    return localix;
  }
  
  public final MStorage dSG()
  {
    AppMethodBeat.i(204076);
    e locale = ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXb();
    AppMethodBeat.o(204076);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.4
 * JD-Core Version:    0.7.0.1
 */