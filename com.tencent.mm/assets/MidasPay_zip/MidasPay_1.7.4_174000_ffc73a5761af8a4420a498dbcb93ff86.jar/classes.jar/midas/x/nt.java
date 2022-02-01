package midas.x;

import java.util.Map;

public final class nt
  implements nk
{
  private static no a(oc paramoc, int paramInt1, int paramInt2, int paramInt3)
  {
    paramoc = paramoc.a();
    if (paramoc != null)
    {
      int k = paramoc.b();
      int m = paramoc.a();
      paramInt3 *= 2;
      int i = k + paramInt3;
      int j = paramInt3 + m;
      paramInt3 = Math.max(paramInt1, i);
      paramInt2 = Math.max(paramInt2, j);
      int n = Math.min(paramInt3 / i, paramInt2 / j);
      j = (paramInt3 - k * n) / 2;
      paramInt1 = (paramInt2 - m * n) / 2;
      no localno = new no(paramInt3, paramInt2);
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        paramInt3 = j;
        i = 0;
        while (i < k)
        {
          if (paramoc.a(i, paramInt2) == 1) {
            localno.a(paramInt3, paramInt1, n, n);
          }
          i += 1;
          paramInt3 += n;
        }
        paramInt2 += 1;
        paramInt1 += n;
      }
      return localno;
    }
    throw new IllegalStateException();
  }
  
  public no a(String paramString, nh paramnh, int paramInt1, int paramInt2, Map<ni, ?> paramMap)
    throws nl
  {
    if (!paramString.isEmpty())
    {
      if (paramnh == nh.l)
      {
        if ((paramInt1 >= 0) && (paramInt2 >= 0))
        {
          paramnh = nu.a;
          int j = 4;
          int i = j;
          nh localnh = paramnh;
          if (paramMap != null)
          {
            if (paramMap.containsKey(ni.a)) {
              paramnh = nu.valueOf(paramMap.get(ni.a).toString());
            }
            i = j;
            localnh = paramnh;
            if (paramMap.containsKey(ni.f))
            {
              i = Integer.parseInt(paramMap.get(ni.f).toString());
              localnh = paramnh;
            }
          }
          return a(nz.a(paramString, localnh, paramMap), paramInt1, paramInt2, i);
        }
        paramString = new StringBuilder();
        paramString.append("Requested dimensions are too small: ");
        paramString.append(paramInt1);
        paramString.append('x');
        paramString.append(paramInt2);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("Can only encode QR_CODE, but got ");
      paramString.append(paramnh);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nt
 * JD-Core Version:    0.7.0.1
 */