package com.tencent.mm.plugin.appbrand.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  public static <T extends a> boolean a(T paramT1, T paramT2)
  {
    AppMethodBeat.i(146131);
    if ((paramT1 == null) && (paramT2 == null))
    {
      paramT1 = new IllegalArgumentException("both null!!!");
      AppMethodBeat.o(146131);
      throw paramT1;
    }
    if (paramT1 == null)
    {
      AppMethodBeat.o(146131);
      return false;
    }
    if (paramT2 == null)
    {
      AppMethodBeat.o(146131);
      return false;
    }
    try
    {
      boolean bool = Util.isEqual(paramT1.toByteArray(), paramT2.toByteArray());
      AppMethodBeat.o(146131);
      return bool;
    }
    catch (Exception paramT1)
    {
      AppMethodBeat.o(146131);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.l
 * JD-Core Version:    0.7.0.1
 */