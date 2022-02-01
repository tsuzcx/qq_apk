package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class d
{
  public static boolean ddk()
  {
    AppMethodBeat.i(25325);
    if (ba.ajx())
    {
      if (g.acA().getInt("WCOEntranceSwitch", 0) > 0)
      {
        ba.aBQ();
        c.ajl().set(al.a.IsS, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      ba.aBQ();
      c.ajl().set(al.a.IsS, Boolean.FALSE);
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