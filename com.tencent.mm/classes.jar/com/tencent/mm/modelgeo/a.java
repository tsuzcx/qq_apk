package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static boolean p(double paramDouble)
  {
    AppMethodBeat.i(78104);
    paramDouble = Math.abs(paramDouble);
    if ((paramDouble >= 0.0D) && (paramDouble <= 180.0D))
    {
      AppMethodBeat.o(78104);
      return true;
    }
    AppMethodBeat.o(78104);
    return false;
  }
  
  public static boolean q(double paramDouble)
  {
    AppMethodBeat.i(78105);
    paramDouble = Math.abs(paramDouble);
    if ((paramDouble >= 0.0D) && (paramDouble <= 90.0D))
    {
      AppMethodBeat.o(78105);
      return true;
    }
    AppMethodBeat.o(78105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.a
 * JD-Core Version:    0.7.0.1
 */