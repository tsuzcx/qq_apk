package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
{
  public static <T extends a> boolean a(T paramT1, T paramT2)
  {
    AppMethodBeat.i(57066);
    if ((paramT1 == null) && (paramT2 == null))
    {
      paramT1 = new IllegalArgumentException("both null!!!");
      AppMethodBeat.o(57066);
      throw paramT1;
    }
    if (paramT1 == null)
    {
      AppMethodBeat.o(57066);
      return false;
    }
    if (paramT2 == null)
    {
      AppMethodBeat.o(57066);
      return false;
    }
    try
    {
      boolean bool = bo.isEqual(paramT1.toByteArray(), paramT2.toByteArray());
      AppMethodBeat.o(57066);
      return bool;
    }
    catch (Exception paramT1)
    {
      AppMethodBeat.o(57066);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.k
 * JD-Core Version:    0.7.0.1
 */