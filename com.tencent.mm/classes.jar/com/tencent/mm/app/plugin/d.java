package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static boolean aDO()
  {
    AppMethodBeat.i(19663);
    if (!c.blq("translate"))
    {
      AppMethodBeat.o(19663);
      return false;
    }
    String str = i.aRC().getValue("TranslateMsgOff");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.d
 * JD-Core Version:    0.7.0.1
 */