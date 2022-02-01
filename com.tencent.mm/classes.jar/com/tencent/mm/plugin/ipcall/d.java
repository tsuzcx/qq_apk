package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class d
{
  public static boolean dgc()
  {
    AppMethodBeat.i(25325);
    if (bc.ajM())
    {
      if (g.acL().getInt("WCOEntranceSwitch", 0) > 0)
      {
        bc.aCg();
        c.ajA().set(am.a.INo, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      bc.aCg();
      c.ajA().set(am.a.INo, Boolean.FALSE);
      AppMethodBeat.o(25325);
      return false;
    }
    AppMethodBeat.o(25325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.d
 * JD-Core Version:    0.7.0.1
 */