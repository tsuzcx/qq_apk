package midas.x;

import java.util.Map;

public final class ae
  implements be
{
  public fe a(String paramString, yd paramyd, int paramInt1, int paramInt2, Map<zd, ?> paramMap)
    throws ce
  {
    if (a.a[paramyd.ordinal()] == 1) {
      return new ke().a(paramString, paramyd, paramInt1, paramInt2, paramMap);
    }
    paramString = new StringBuilder();
    paramString.append("No encoder available for format ");
    paramString.append(paramyd);
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ae
 * JD-Core Version:    0.7.0.1
 */