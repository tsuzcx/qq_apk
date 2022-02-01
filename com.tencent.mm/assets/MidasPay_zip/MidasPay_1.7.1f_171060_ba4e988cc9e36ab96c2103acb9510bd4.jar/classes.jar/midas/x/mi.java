package midas.x;

import java.util.Map;

public final class mi
  implements lz
{
  private static md a(mr parammr, int paramInt1, int paramInt2, int paramInt3)
  {
    parammr = parammr.a();
    if (parammr != null)
    {
      int k = parammr.b();
      int m = parammr.a();
      paramInt3 *= 2;
      int i = k + paramInt3;
      int j = paramInt3 + m;
      paramInt3 = Math.max(paramInt1, i);
      paramInt2 = Math.max(paramInt2, j);
      int n = Math.min(paramInt3 / i, paramInt2 / j);
      j = (paramInt3 - k * n) / 2;
      paramInt1 = (paramInt2 - m * n) / 2;
      md localmd = new md(paramInt3, paramInt2);
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        paramInt3 = j;
        i = 0;
        while (i < k)
        {
          if (parammr.a(i, paramInt2) == 1) {
            localmd.a(paramInt3, paramInt1, n, n);
          }
          i += 1;
          paramInt3 += n;
        }
        paramInt2 += 1;
        paramInt1 += n;
      }
      return localmd;
    }
    throw new IllegalStateException();
  }
  
  public md a(String paramString, lw paramlw, int paramInt1, int paramInt2, Map<lx, ?> paramMap)
    throws ma
  {
    if (!paramString.isEmpty())
    {
      if (paramlw == lw.l)
      {
        if ((paramInt1 >= 0) && (paramInt2 >= 0))
        {
          paramlw = mj.a;
          int j = 4;
          int i = j;
          lw locallw = paramlw;
          if (paramMap != null)
          {
            if (paramMap.containsKey(lx.a)) {
              paramlw = mj.valueOf(paramMap.get(lx.a).toString());
            }
            i = j;
            locallw = paramlw;
            if (paramMap.containsKey(lx.f))
            {
              i = Integer.parseInt(paramMap.get(lx.f).toString());
              locallw = paramlw;
            }
          }
          return a(mo.a(paramString, locallw, paramMap), paramInt1, paramInt2, i);
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
      paramString.append(paramlw);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mi
 * JD-Core Version:    0.7.0.1
 */