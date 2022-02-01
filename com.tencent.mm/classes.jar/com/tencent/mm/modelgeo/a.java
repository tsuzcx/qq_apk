package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static boolean l(double paramDouble)
  {
    AppMethodBeat.i(150461);
    paramDouble = Math.abs(paramDouble);
    if ((paramDouble >= 0.0D) && (paramDouble <= 180.0D))
    {
      AppMethodBeat.o(150461);
      return true;
    }
    AppMethodBeat.o(150461);
    return false;
  }
  
  public static boolean m(double paramDouble)
  {
    AppMethodBeat.i(150462);
    paramDouble = Math.abs(paramDouble);
    if ((paramDouble >= 0.0D) && (paramDouble <= 90.0D))
    {
      AppMethodBeat.o(150462);
      return true;
    }
    AppMethodBeat.o(150462);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.a
 * JD-Core Version:    0.7.0.1
 */