package midas.x;

import java.util.HashMap;
import java.util.Map;

public enum me
{
  private static final Map<Integer, me> B;
  private static final Map<String, me> C;
  private final int[] D;
  private final String[] E;
  
  static
  {
    A = new me("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    F = new me[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A };
    B = new HashMap();
    C = new HashMap();
    me[] arrayOfme = values();
    int i3 = arrayOfme.length;
    int i1 = 0;
    while (i1 < i3)
    {
      me localme = arrayOfme[i1];
      Object localObject1 = localme.D;
      int i4 = localObject1.length;
      int i2 = 0;
      while (i2 < i4)
      {
        int i5 = localObject1[i2];
        B.put(Integer.valueOf(i5), localme);
        i2 += 1;
      }
      C.put(localme.name(), localme);
      localObject1 = localme.E;
      i4 = localObject1.length;
      i2 = 0;
      while (i2 < i4)
      {
        Object localObject2 = localObject1[i2];
        C.put(localObject2, localme);
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private me(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }
  
  private me(int paramInt, String... paramVarArgs)
  {
    this.D = new int[] { paramInt };
    this.E = paramVarArgs;
  }
  
  private me(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.D = paramArrayOfInt;
    this.E = paramVarArgs;
  }
  
  public static me a(String paramString)
  {
    return (me)C.get(paramString);
  }
  
  public int a()
  {
    return this.D[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.me
 * JD-Core Version:    0.7.0.1
 */