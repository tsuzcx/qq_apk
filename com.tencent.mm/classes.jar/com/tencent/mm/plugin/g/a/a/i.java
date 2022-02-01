package com.tencent.mm.plugin.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public final class i
{
  public static double A(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22471);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
      AppMethodBeat.o(22471);
      throw paramArrayOfInt;
    }
    double d = z(paramArrayOfInt);
    BigDecimal localBigDecimal = new BigDecimal(0.0D);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localBigDecimal = localBigDecimal.add(new BigDecimal(paramArrayOfInt[i]).subtract(new BigDecimal(d)).pow(2));
      i += 1;
    }
    d = Math.pow(localBigDecimal.divide(new BigDecimal(paramArrayOfInt.length - 1), 5, 4).doubleValue(), 0.5D);
    AppMethodBeat.o(22471);
    return d;
  }
  
  public static BigDecimal l(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(22469);
    BigDecimal localBigDecimal = new BigDecimal(paramDouble1).multiply(new BigDecimal(paramDouble2));
    AppMethodBeat.o(22469);
    return localBigDecimal;
  }
  
  public static double z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22470);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
      AppMethodBeat.o(22470);
      throw paramArrayOfInt;
    }
    int k = paramArrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = paramArrayOfInt[j];
      j += 1;
    }
    double d1 = i;
    double d2 = paramArrayOfInt.length;
    d1 = new BigDecimal(d1).divide(new BigDecimal(d2), 5, 4).doubleValue();
    AppMethodBeat.o(22470);
    return d1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.i
 * JD-Core Version:    0.7.0.1
 */