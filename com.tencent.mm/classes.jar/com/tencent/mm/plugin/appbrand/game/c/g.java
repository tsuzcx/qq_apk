package com.tencent.mm.plugin.appbrand.game.c;

public final class g
{
  public static double a(Double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length <= 0)) {
      return -1.0D;
    }
    double d = 0.0D;
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      d += paramArrayOfDouble[i].doubleValue();
      i += 1;
    }
    return d / j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.g
 * JD-Core Version:    0.7.0.1
 */