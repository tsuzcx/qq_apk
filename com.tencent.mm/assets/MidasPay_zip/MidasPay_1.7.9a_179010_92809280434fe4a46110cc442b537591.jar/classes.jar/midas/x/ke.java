package midas.x;

import java.util.Map;

public final class ke
  implements be
{
  public static fe a(te paramte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramte = paramte.a();
    if (paramte != null)
    {
      int k = paramte.c();
      int m = paramte.b();
      paramInt3 *= 2;
      int i = k + paramInt3;
      int j = paramInt3 + m;
      paramInt3 = Math.max(paramInt1, i);
      paramInt2 = Math.max(paramInt2, j);
      int n = Math.min(paramInt3 / i, paramInt2 / j);
      j = (paramInt3 - k * n) / 2;
      paramInt1 = (paramInt2 - m * n) / 2;
      fe localfe = new fe(paramInt3, paramInt2);
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        paramInt3 = j;
        i = 0;
        while (i < k)
        {
          if (paramte.a(i, paramInt2) == 1) {
            localfe.a(paramInt3, paramInt1, n, n);
          }
          i += 1;
          paramInt3 += n;
        }
        paramInt2 += 1;
        paramInt1 += n;
      }
      return localfe;
    }
    paramte = new IllegalStateException();
    for (;;)
    {
      throw paramte;
    }
  }
  
  public fe a(String paramString, yd paramyd, int paramInt1, int paramInt2, Map<zd, ?> paramMap)
    throws ce
  {
    if (!paramString.isEmpty())
    {
      if (paramyd == yd.l)
      {
        if ((paramInt1 >= 0) && (paramInt2 >= 0))
        {
          paramyd = le.b;
          int j = 4;
          int i = j;
          yd localyd = paramyd;
          if (paramMap != null)
          {
            if (paramMap.containsKey(zd.a)) {
              paramyd = le.valueOf(paramMap.get(zd.a).toString());
            }
            i = j;
            localyd = paramyd;
            if (paramMap.containsKey(zd.f))
            {
              i = Integer.parseInt(paramMap.get(zd.f).toString());
              localyd = paramyd;
            }
          }
          return a(qe.a(paramString, localyd, paramMap), paramInt1, paramInt2, i);
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
      paramString.append(paramyd);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ke
 * JD-Core Version:    0.7.0.1
 */