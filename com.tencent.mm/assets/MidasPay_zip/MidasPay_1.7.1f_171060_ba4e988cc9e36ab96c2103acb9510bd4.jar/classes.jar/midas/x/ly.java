package midas.x;

import java.util.Map;

public final class ly
  implements lz
{
  public md a(String paramString, lw paramlw, int paramInt1, int paramInt2, Map<lx, ?> paramMap)
    throws ma
  {
    if (1.a[paramlw.ordinal()] == 1) {
      return new mi().a(paramString, paramlw, paramInt1, paramInt2, paramMap);
    }
    paramString = new StringBuilder();
    paramString.append("No encoder available for format ");
    paramString.append(paramlw);
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ly
 * JD-Core Version:    0.7.0.1
 */