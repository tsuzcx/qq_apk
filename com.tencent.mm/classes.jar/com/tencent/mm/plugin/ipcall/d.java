package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class d
{
  public static boolean eIU()
  {
    AppMethodBeat.i(25325);
    if (bh.aHB())
    {
      if (h.axc().getInt("WCOEntranceSwitch", 0) > 0)
      {
        bh.beI();
        c.aHp().set(ar.a.Vjr, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      bh.beI();
      c.aHp().set(ar.a.Vjr, Boolean.FALSE);
      AppMethodBeat.o(25325);
      return false;
    }
    AppMethodBeat.o(25325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.d
 * JD-Core Version:    0.7.0.1
 */