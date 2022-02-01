package midas.x;

import java.util.HashMap;
import java.util.Map;

public enum ge
{
  public static final Map<Integer, ge> D;
  public static final Map<String, ge> E;
  public final int[] a;
  public final String[] b;
  
  static
  {
    A = new ge("Big5", 24, 28);
    B = new ge("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    C = new ge("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    F = new ge[] { c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C };
    D = new HashMap();
    E = new HashMap();
    ge[] arrayOfge = values();
    int i3 = arrayOfge.length;
    int i1 = 0;
    while (i1 < i3)
    {
      ge localge = arrayOfge[i1];
      Object localObject1 = localge.a;
      int i4 = localObject1.length;
      int i2 = 0;
      while (i2 < i4)
      {
        int i5 = localObject1[i2];
        D.put(Integer.valueOf(i5), localge);
        i2 += 1;
      }
      E.put(localge.name(), localge);
      localObject1 = localge.b;
      i4 = localObject1.length;
      i2 = 0;
      while (i2 < i4)
      {
        Object localObject2 = localObject1[i2];
        E.put(localObject2, localge);
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public ge(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }
  
  public ge(int paramInt, String... paramVarArgs)
  {
    this.a = new int[] { paramInt };
    this.b = paramVarArgs;
  }
  
  public ge(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.a = paramArrayOfInt;
    this.b = paramVarArgs;
  }
  
  public static ge a(String paramString)
  {
    return (ge)E.get(paramString);
  }
  
  public int a()
  {
    return this.a[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ge
 * JD-Core Version:    0.7.0.1
 */