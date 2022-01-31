package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class d
{
  public static boolean bIT()
  {
    AppMethodBeat.i(21702);
    if (aw.RG())
    {
      if (g.Nq().getInt("WCOEntranceSwitch", 0) > 0)
      {
        aw.aaz();
        c.Ru().set(ac.a.yAp, Boolean.TRUE);
        AppMethodBeat.o(21702);
        return true;
      }
      aw.aaz();
      c.Ru().set(ac.a.yAp, Boolean.FALSE);
      AppMethodBeat.o(21702);
      return false;
    }
    AppMethodBeat.o(21702);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.d
 * JD-Core Version:    0.7.0.1
 */