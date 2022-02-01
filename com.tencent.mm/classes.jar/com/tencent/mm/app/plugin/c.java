package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
{
  public static boolean Ly()
  {
    AppMethodBeat.i(19663);
    if (!d.aCT("translate"))
    {
      AppMethodBeat.o(19663);
      return false;
    }
    String str = g.ZY().getValue("TranslateMsgOff");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(19663);
      return true;
    }
    if (bs.aLy(str) != 0)
    {
      AppMethodBeat.o(19663);
      return false;
    }
    AppMethodBeat.o(19663);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.c
 * JD-Core Version:    0.7.0.1
 */