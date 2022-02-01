package midas.x;

import java.util.Map;

public final class nj
  implements nk
{
  public no a(String paramString, nh paramnh, int paramInt1, int paramInt2, Map<ni, ?> paramMap)
    throws nl
  {
    if (1.a[paramnh.ordinal()] == 1) {
      return new nt().a(paramString, paramnh, paramInt1, paramInt2, paramMap);
    }
    paramString = new StringBuilder();
    paramString.append("No encoder available for format ");
    paramString.append(paramnh);
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nj
 * JD-Core Version:    0.7.0.1
 */