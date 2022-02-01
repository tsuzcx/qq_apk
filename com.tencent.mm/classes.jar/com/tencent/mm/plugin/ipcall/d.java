package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class d
{
  public static boolean fQV()
  {
    AppMethodBeat.i(25325);
    if (bh.baz())
    {
      if (i.aRC().getInt("WCOEntranceSwitch", 0) > 0)
      {
        bh.bCz();
        c.ban().set(at.a.acKL, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      bh.bCz();
      c.ban().set(at.a.acKL, Boolean.FALSE);
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