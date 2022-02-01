package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class d
{
  public static boolean dZW()
  {
    AppMethodBeat.i(25325);
    if (bg.aAc())
    {
      if (h.aqJ().getInt("WCOEntranceSwitch", 0) > 0)
      {
        bg.aVF();
        c.azQ().set(ar.a.NVr, Boolean.TRUE);
        AppMethodBeat.o(25325);
        return true;
      }
      bg.aVF();
      c.azQ().set(ar.a.NVr, Boolean.FALSE);
      AppMethodBeat.o(25325);
      return false;
    }
    AppMethodBeat.o(25325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.d
 * JD-Core Version:    0.7.0.1
 */