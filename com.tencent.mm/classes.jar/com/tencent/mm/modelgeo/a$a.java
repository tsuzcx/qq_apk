package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  private static double a = 6378245.0D;
  private static double iVa = 3.141592653589793D;
  private static double iVb = 0.006693421622965943D;
  
  public static double[] c(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150460);
    int i;
    if ((paramDouble1 < 72.004000000000005D) || (paramDouble1 > 137.8347D)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(150460);
      return new double[] { paramDouble1, paramDouble2 };
      if ((paramDouble2 < 0.8293D) || (paramDouble2 > 55.827100000000002D)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    double d1 = paramDouble1 - 105.0D;
    double d2 = paramDouble2 - 35.0D;
    double d3 = Math.sqrt(Math.abs(d1));
    double d4 = Math.sin(6.0D * d1 * iVa);
    double d9 = (Math.sin(d1 * 2.0D * iVa) * 20.0D + 20.0D * d4) * 2.0D / 3.0D;
    double d10 = (20.0D * Math.sin(iVa * d2) + 40.0D * Math.sin(d2 / 3.0D * iVa)) * 2.0D / 3.0D;
    d4 = Math.sin(d2 / 12.0D * iVa);
    double d13 = (Math.sin(d2 * iVa / 30.0D) * 320.0D + 160.0D * d4) * 2.0D / 3.0D;
    d4 = paramDouble1 - 105.0D;
    double d5 = paramDouble2 - 35.0D;
    double d6 = Math.sqrt(Math.abs(d4));
    double d7 = (20.0D * Math.sin(6.0D * d4 * iVa) + 20.0D * Math.sin(2.0D * d4 * iVa)) * 2.0D / 3.0D;
    double d8 = (20.0D * Math.sin(iVa * d4) + 40.0D * Math.sin(d4 / 3.0D * iVa)) * 2.0D / 3.0D;
    double d11 = Math.sin(d4 / 12.0D * iVa);
    d11 = (Math.sin(d4 / 30.0D * iVa) * 300.0D + 150.0D * d11) * 2.0D / 3.0D;
    double d12 = paramDouble2 / 180.0D * iVa;
    double d14 = Math.sin(d12);
    double d15 = 1.0D - d14 * (iVb * d14);
    d14 = Math.sqrt(d15);
    d1 = (d9 + (-100.0D + 2.0D * d1 + 3.0D * d2 + 0.2D * d2 * d2 + 0.1D * d1 * d2 + 0.2D * d3) + d10 + d13) * 180.0D / (a * (1.0D - iVb) / (d15 * d14) * iVa);
    d2 = a / d14;
    d2 = (d11 + (d5 * (0.1D * d4) + (300.0D + d4 + 2.0D * d5 + 0.1D * d4 * d4) + 0.1D * d6 + d7 + d8)) * 180.0D / (Math.cos(d12) * d2 * iVa);
    AppMethodBeat.o(150460);
    return new double[] { 2.0D * paramDouble1 - (d2 + paramDouble1), 2.0D * paramDouble2 - (paramDouble2 + d1) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.a.a
 * JD-Core Version:    0.7.0.1
 */