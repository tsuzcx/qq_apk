package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class d
{
  public static boolean cGO()
  {
    AppMethodBeat.i(25325);
    if (az.afw())
    {
      if (g.Zd().getInt("WCOEntranceSwitch", 0) > 0)
      {
        az.arV();
        c.afk().set(ae.a.FiL, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      az.arV();
      c.afk().set(ae.a.FiL, Boolean.FALSE);
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