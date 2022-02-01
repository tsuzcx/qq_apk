package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static boolean Ng()
  {
    AppMethodBeat.i(19663);
    if (!d.aIu("translate"))
    {
      AppMethodBeat.o(19663);
      return false;
    }
    String str = g.acA().getValue("TranslateMsgOff");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(19663);
      return true;
    }
    if (bt.aRe(str) != 0)
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