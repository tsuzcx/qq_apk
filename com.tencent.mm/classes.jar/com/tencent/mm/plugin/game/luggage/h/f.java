package com.tencent.mm.plugin.game.luggage.h;

import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class f
{
  com.tencent.luggage.d.f ugT;
  boolean uhm;
  boolean uhn;
  LinkedList<d> uho;
  LinkedList<g> uhp;
  
  public f(com.tencent.luggage.d.f paramf)
  {
    AppMethodBeat.i(193124);
    this.uho = new LinkedList();
    this.uhp = new LinkedList();
    this.ugT = paramf;
    AppMethodBeat.o(193124);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(193125);
    ae.i("MicroMsg.Page2JsCoreMsgDispatch", "dispatchEvent, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(this.uhn), Boolean.valueOf(this.uhm) });
    if (this.uhn)
    {
      AppMethodBeat.o(193125);
      return;
    }
    if (!this.uhm)
    {
      this.uho.add(paramd);
      AppMethodBeat.o(193125);
      return;
    }
    this.ugT.a(paramd);
    AppMethodBeat.o(193125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.f
 * JD-Core Version:    0.7.0.1
 */