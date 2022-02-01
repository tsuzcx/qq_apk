package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class d
{
  public static boolean cTZ()
  {
    AppMethodBeat.i(25325);
    if (az.agM())
    {
      if (g.ZY().getInt("WCOEntranceSwitch", 0) > 0)
      {
        az.ayM();
        c.agA().set(ah.a.GGA, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      az.ayM();
      c.agA().set(ah.a.GGA, Boolean.FALSE);
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