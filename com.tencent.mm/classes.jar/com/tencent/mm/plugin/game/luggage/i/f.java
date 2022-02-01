package com.tencent.mm.plugin.game.luggage.i;

import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
{
  boolean xzG;
  boolean xzH;
  LinkedList<d> xzI;
  LinkedList<g> xzJ;
  com.tencent.luggage.d.f xzo;
  
  public f(com.tencent.luggage.d.f paramf)
  {
    AppMethodBeat.i(187021);
    this.xzI = new LinkedList();
    this.xzJ = new LinkedList();
    this.xzo = paramf;
    AppMethodBeat.o(187021);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(187022);
    Log.i("MicroMsg.Page2JsCoreMsgDispatch", "dispatchEvent, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(this.xzH), Boolean.valueOf(this.xzG) });
    if (this.xzH)
    {
      AppMethodBeat.o(187022);
      return;
    }
    if (!this.xzG)
    {
      this.xzI.add(paramd);
      AppMethodBeat.o(187022);
      return;
    }
    this.xzo.a(paramd);
    AppMethodBeat.o(187022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.f
 * JD-Core Version:    0.7.0.1
 */