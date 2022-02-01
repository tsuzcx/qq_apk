package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static boolean Xn()
  {
    AppMethodBeat.i(19663);
    if (!com.tencent.mm.br.c.aZU("translate"))
    {
      AppMethodBeat.o(19663);
      return false;
    }
    String str = h.aqJ().getValue("TranslateMsgOff");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(19663);
      return true;
    }
    if (Util.safeParseInt(str) != 0)
    {
      AppMethodBeat.o(19663);
      return false;
    }
    AppMethodBeat.o(19663);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.c
 * JD-Core Version:    0.7.0.1
 */