package com.tencent.mm.plugin.game.luggage.i;

import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
{
  boolean CDL;
  boolean CDM;
  LinkedList<d> CDN;
  LinkedList<g> CDO;
  com.tencent.luggage.d.f CDt;
  
  public f(com.tencent.luggage.d.f paramf)
  {
    AppMethodBeat.i(231727);
    this.CDN = new LinkedList();
    this.CDO = new LinkedList();
    this.CDt = paramf;
    AppMethodBeat.o(231727);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(231728);
    Log.i("MicroMsg.Page2JsCoreMsgDispatch", "dispatchEvent, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(this.CDM), Boolean.valueOf(this.CDL) });
    if (this.CDM)
    {
      AppMethodBeat.o(231728);
      return;
    }
    if (!this.CDL)
    {
      this.CDN.add(paramd);
      AppMethodBeat.o(231728);
      return;
    }
    this.CDt.a(paramd);
    AppMethodBeat.o(231728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.f
 * JD-Core Version:    0.7.0.1
 */