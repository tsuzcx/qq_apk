package com.tencent.mm.plugin.game.luggage.h;

import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
{
  boolean IxQ;
  boolean IxR;
  LinkedList<d> IxS;
  LinkedList<g> IxT;
  com.tencent.luggage.d.f Ixy;
  
  public f(com.tencent.luggage.d.f paramf)
  {
    AppMethodBeat.i(276967);
    this.IxS = new LinkedList();
    this.IxT = new LinkedList();
    this.Ixy = paramf;
    AppMethodBeat.o(276967);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(276974);
    Log.i("MicroMsg.Page2JsCoreMsgDispatch", "dispatchEvent, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(this.IxR), Boolean.valueOf(this.IxQ) });
    if (this.IxR)
    {
      AppMethodBeat.o(276974);
      return;
    }
    if (!this.IxQ)
    {
      this.IxS.add(paramd);
      AppMethodBeat.o(276974);
      return;
    }
    this.Ixy.a(paramd);
    AppMethodBeat.o(276974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.f
 * JD-Core Version:    0.7.0.1
 */