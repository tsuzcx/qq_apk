package com.tencent.mm.plugin.game.luggage.h;

import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class f
{
  com.tencent.luggage.d.f tVV;
  boolean tWo;
  boolean tWp;
  LinkedList<d> tWq;
  LinkedList<g> tWr;
  
  public f(com.tencent.luggage.d.f paramf)
  {
    AppMethodBeat.i(211725);
    this.tWq = new LinkedList();
    this.tWr = new LinkedList();
    this.tVV = paramf;
    AppMethodBeat.o(211725);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(211726);
    ad.i("MicroMsg.Page2JsCoreMsgDispatch", "dispatchEvent, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(this.tWp), Boolean.valueOf(this.tWo) });
    if (this.tWp)
    {
      AppMethodBeat.o(211726);
      return;
    }
    if (!this.tWo)
    {
      this.tWq.add(paramd);
      AppMethodBeat.o(211726);
      return;
    }
    this.tVV.a(paramd);
    AppMethodBeat.o(211726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.f
 * JD-Core Version:    0.7.0.1
 */