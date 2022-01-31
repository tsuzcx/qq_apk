package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public final class i
{
  public static BigDecimal i(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(18358);
    BigDecimal localBigDecimal = new BigDecimal(paramDouble1).multiply(new BigDecimal(paramDouble2));
    AppMethodBeat.o(18358);
    return localBigDecimal;
  }
  
  public static double r(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(18359);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
      AppMethodBeat.o(18359);
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
    AppMethodBeat.o(18359);
    return d1;
  }
  
  public static double s(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(18360);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
      AppMethodBeat.o(18360);
      throw paramArrayOfInt;
    }
    double d = r(paramArrayOfInt);
    BigDecimal localBigDecimal = new BigDecimal(0.0D);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localBigDecimal = localBigDecimal.add(new BigDecimal(paramArrayOfInt[i]).subtract(new BigDecimal(d)).pow(2));
      i += 1;
    }
    d = Math.pow(localBigDecimal.divide(new BigDecimal(paramArrayOfInt.length - 1), 5, 4).doubleValue(), 0.5D);
    AppMethodBeat.o(18360);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.i
 * JD-Core Version:    0.7.0.1
 */