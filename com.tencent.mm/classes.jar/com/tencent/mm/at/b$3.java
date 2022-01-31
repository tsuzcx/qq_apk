package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Stack;

final class b$3
  extends com.tencent.mm.sdk.b.c<u>
{
  b$3(b paramb)
  {
    AppMethodBeat.i(78154);
    this.__eventId = u.class.getName().hashCode();
    AppMethodBeat.o(78154);
  }
  
  private boolean a(u arg1)
  {
    AppMethodBeat.i(78155);
    this.fDw.fDs = ???.cna.mode;
    ab.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.fDw.fDs);
    com.tencent.mm.modelcontrol.c.afT();
    if (!com.tencent.mm.modelcontrol.c.afU()) {}
    synchronized (this.fDw.fDi)
    {
      this.fDw.fDi.clear();
      AppMethodBeat.o(78155);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.b.3
 * JD-Core Version:    0.7.0.1
 */