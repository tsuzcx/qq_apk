package midas.x;

import java.util.HashMap;
import java.util.Map;

public enum np
{
  private static final Map<Integer, np> B;
  private static final Map<String, np> C;
  private final int[] D;
  private final String[] E;
  
  static
  {
    A = new np("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    F = new np[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A };
    B = new HashMap();
    C = new HashMap();
    np[] arrayOfnp = values();
    int i3 = arrayOfnp.length;
    int i1 = 0;
    while (i1 < i3)
    {
      np localnp = arrayOfnp[i1];
      Object localObject1 = localnp.D;
      int i4 = localObject1.length;
      int i2 = 0;
      while (i2 < i4)
      {
        int i5 = localObject1[i2];
        B.put(Integer.valueOf(i5), localnp);
        i2 += 1;
      }
      C.put(localnp.name(), localnp);
      localObject1 = localnp.E;
      i4 = localObject1.length;
      i2 = 0;
      while (i2 < i4)
      {
        Object localObject2 = localObject1[i2];
        C.put(localObject2, localnp);
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private np(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }
  
  private np(int paramInt, String... paramVarArgs)
  {
    this.D = new int[] { paramInt };
    this.E = paramVarArgs;
  }
  
  private np(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.D = paramArrayOfInt;
    this.E = paramVarArgs;
  }
  
  public static np a(String paramString)
  {
    return (np)C.get(paramString);
  }
  
  public int a()
  {
    return this.D[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.np
 * JD-Core Version:    0.7.0.1
 */