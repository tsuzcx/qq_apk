package com.tencent.mm.plugin.f.a.a;

import java.math.BigDecimal;

public final class i
{
  public static BigDecimal g(double paramDouble1, double paramDouble2)
  {
    return new BigDecimal(paramDouble1).multiply(new BigDecimal(paramDouble2));
  }
  
  public static double i(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new NullPointerException("null == dataGroup || 0 == dataGroup.length");
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
    return new BigDecimal(d1).divide(new BigDecimal(d2), 5, 4).doubleValue();
  }
  
  public static double j(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new NullPointerException("null == dataGroup || 0 == dataGroup.length");
    }
    double d = i(paramArrayOfInt);
    BigDecimal localBigDecimal = new BigDecimal(0.0D);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localBigDecimal = localBigDecimal.add(new BigDecimal(paramArrayOfInt[i]).subtract(new BigDecimal(d)).pow(2));
      i += 1;
    }
    return Math.pow(localBigDecimal.divide(new BigDecimal(paramArrayOfInt.length - 1), 5, 4).doubleValue(), 0.5D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.i
 * JD-Core Version:    0.7.0.1
 */