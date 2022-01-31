package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  public static boolean Cc()
  {
    AppMethodBeat.i(15617);
    if (!d.ahR("translate"))
    {
      AppMethodBeat.o(15617);
      return false;
    }
    String str = g.Nq().getValue("TranslateMsgOff");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(15617);
      return true;
    }
    if (bo.apV(str) != 0)
    {
      AppMethodBeat.o(15617);
      return false;
    }
    AppMethodBeat.o(15617);
    return true;
  }
  
  public static boolean Cd()
  {
    AppMethodBeat.i(15618);
    if (!d.ahR("translate"))
    {
      AppMethodBeat.o(15618);
      return false;
    }
    String str = g.Nq().getValue("ReTranslateSwitch");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(15618);
      return true;
    }
    if (bo.apV(str) != 0)
    {
      AppMethodBeat.o(15618);
      return false;
    }
    AppMethodBeat.o(15618);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.c
 * JD-Core Version:    0.7.0.1
 */