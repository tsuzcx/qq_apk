package midas.x;

final class mq
{
  private static final int[][] a;
  private static final int[][] b;
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt4 = { 1, 0, 1, 1, 1, 0, 1 };
    a = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt4, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 1, 1, 1, 1, 1 };
    arrayOfInt2 = new int[] { 1, 1, 1, 1, 1 };
    b = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, arrayOfInt2 };
    c = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, { 6, 26, 50, 74, 98, 122, -1 }, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 1 };
    arrayOfInt3 = new int[] { 8, 2 };
    arrayOfInt4 = new int[] { 8, 3 };
    int[] arrayOfInt5 = { 8, 4 };
    int[] arrayOfInt6 = { 8, 5 };
    int[] arrayOfInt7 = { 8, 7 };
    int[] arrayOfInt8 = { 8, 8 };
    int[] arrayOfInt9 = { 7, 8 };
    int[] arrayOfInt10 = { 5, 8 };
    int[] arrayOfInt11 = { 4, 8 };
    int[] arrayOfInt12 = { 3, 8 };
    int[] arrayOfInt13 = { 2, 8 };
    int[] arrayOfInt14 = { 0, 8 };
    d = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, { 1, 8 }, arrayOfInt14 };
  }
  
  static int a(int paramInt)
  {
    return 32 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      int i = a(paramInt2);
      paramInt1 <<= i - 1;
      while (a(paramInt1) >= i) {
        paramInt1 ^= paramInt2 << a(paramInt1) - i;
      }
      return paramInt1;
    }
    throw new IllegalArgumentException("0 polynomial");
  }
  
  private static void a(int paramInt1, int paramInt2, mn parammn)
    throws ma
  {
    int i = 0;
    while (i < 8)
    {
      int j = paramInt1 + i;
      if (b(parammn.a(j, paramInt2)))
      {
        parammn.a(j, paramInt2, 0);
        i += 1;
      }
      else
      {
        throw new ma();
      }
    }
  }
  
  static void a(mc parammc, int paramInt, mn parammn)
    throws ma
  {
    int k = parammn.b() - 1;
    int j = parammn.a() - 1;
    int i2 = 0;
    int m = -1;
    while (k > 0)
    {
      int n = k;
      int i = i2;
      int i1 = j;
      if (k == 6)
      {
        n = k - 1;
        i1 = j;
        i = i2;
      }
      while ((i1 >= 0) && (i1 < parammn.a()))
      {
        j = 0;
        while (j < 2)
        {
          k = n - j;
          if (b(parammn.a(k, i1)))
          {
            boolean bool1;
            if (i < parammc.a())
            {
              bool1 = parammc.a(i);
              i += 1;
            }
            else
            {
              bool1 = false;
            }
            boolean bool2 = bool1;
            if (paramInt != -1)
            {
              bool2 = bool1;
              if (mp.a(paramInt, k, i1)) {
                if (!bool1) {
                  bool2 = true;
                } else {
                  bool2 = false;
                }
              }
            }
            parammn.a(k, i1, bool2);
          }
          j += 1;
        }
        i1 += m;
      }
      m = -m;
      j = i1 + m;
      k = n - 2;
      i2 = i;
    }
    if (i2 == parammc.a()) {
      return;
    }
    parammn = new StringBuilder();
    parammn.append("Not all bits consumed: ");
    parammn.append(i2);
    parammn.append('/');
    parammn.append(parammc.a());
    throw new ma(parammn.toString());
  }
  
  static void a(mc parammc, mj parammj, ml paramml, int paramInt, mn parammn)
    throws ma
  {
    a(parammn);
    a(paramml, parammn);
    a(parammj, paramInt, parammn);
    b(paramml, parammn);
    a(parammc, paramInt, parammn);
  }
  
  static void a(mj parammj, int paramInt, mc parammc)
    throws ma
  {
    if (mr.b(paramInt))
    {
      paramInt = parammj.a() << 3 | paramInt;
      parammc.a(paramInt, 5);
      parammc.a(a(paramInt, 1335), 10);
      parammj = new mc();
      parammj.a(21522, 15);
      parammc.b(parammj);
      if (parammc.a() == 15) {
        return;
      }
      parammj = new StringBuilder();
      parammj.append("should not happen but we got: ");
      parammj.append(parammc.a());
      throw new ma(parammj.toString());
    }
    throw new ma("Invalid mask pattern");
  }
  
  static void a(mj parammj, int paramInt, mn parammn)
    throws ma
  {
    mc localmc = new mc();
    a(parammj, paramInt, localmc);
    paramInt = 0;
    while (paramInt < localmc.a())
    {
      boolean bool = localmc.a(localmc.a() - 1 - paramInt);
      parammj = d[paramInt];
      parammn.a(parammj[0], parammj[1], bool);
      if (paramInt < 8) {
        parammn.a(parammn.b() - paramInt - 1, 8, bool);
      } else {
        parammn.a(8, parammn.a() - 7 + (paramInt - 8), bool);
      }
      paramInt += 1;
    }
  }
  
  static void a(ml paramml, mc parammc)
    throws ma
  {
    parammc.a(paramml.a(), 6);
    parammc.a(a(paramml.a(), 7973), 12);
    if (parammc.a() == 18) {
      return;
    }
    paramml = new StringBuilder();
    paramml.append("should not happen but we got: ");
    paramml.append(parammc.a());
    throw new ma(paramml.toString());
  }
  
  static void a(ml paramml, mn parammn)
    throws ma
  {
    d(parammn);
    c(parammn);
    c(paramml, parammn);
    b(parammn);
  }
  
  static void a(mn parammn)
  {
    parammn.a((byte)-1);
  }
  
  private static void b(int paramInt1, int paramInt2, mn parammn)
    throws ma
  {
    int i = 0;
    while (i < 7)
    {
      int j = paramInt2 + i;
      if (b(parammn.a(paramInt1, j)))
      {
        parammn.a(paramInt1, j, 0);
        i += 1;
      }
      else
      {
        throw new ma();
      }
    }
  }
  
  static void b(ml paramml, mn parammn)
    throws ma
  {
    if (paramml.a() < 7) {
      return;
    }
    mc localmc = new mc();
    a(paramml, localmc);
    int j = 0;
    int i = 17;
    while (j < 6)
    {
      int k = 0;
      while (k < 3)
      {
        boolean bool = localmc.a(i);
        i -= 1;
        parammn.a(j, parammn.a() - 11 + k, bool);
        parammn.a(parammn.a() - 11 + k, j, bool);
        k += 1;
      }
      j += 1;
    }
  }
  
  private static void b(mn parammn)
  {
    int j;
    for (int i = 8; i < parammn.b() - 8; i = j)
    {
      j = i + 1;
      int k = j % 2;
      if (b(parammn.a(i, 6))) {
        parammn.a(i, 6, k);
      }
      if (b(parammn.a(6, i))) {
        parammn.a(6, i, k);
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void c(int paramInt1, int paramInt2, mn parammn)
  {
    int i = 0;
    while (i < 5)
    {
      int[] arrayOfInt = b[i];
      int j = 0;
      while (j < 5)
      {
        parammn.a(paramInt1 + j, paramInt2 + i, arrayOfInt[j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(ml paramml, mn parammn)
  {
    if (paramml.a() < 2) {
      return;
    }
    int i = paramml.a();
    paramml = c[(i - 1)];
    int k = paramml.length;
    i = 0;
    while (i < k)
    {
      int m = paramml[i];
      if (m >= 0)
      {
        int n = paramml.length;
        int j = 0;
        while (j < n)
        {
          int i1 = paramml[j];
          if ((i1 >= 0) && (b(parammn.a(i1, m)))) {
            c(i1 - 2, m - 2, parammn);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  private static void c(mn parammn)
    throws ma
  {
    if (parammn.a(8, parammn.a() - 8) != 0)
    {
      parammn.a(8, parammn.a() - 8, 1);
      return;
    }
    throw new ma();
  }
  
  private static void d(int paramInt1, int paramInt2, mn parammn)
  {
    int i = 0;
    while (i < 7)
    {
      int[] arrayOfInt = a[i];
      int j = 0;
      while (j < 7)
      {
        parammn.a(paramInt1 + j, paramInt2 + i, arrayOfInt[j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(mn parammn)
    throws ma
  {
    int i = a[0].length;
    d(0, 0, parammn);
    d(parammn.b() - i, 0, parammn);
    d(0, parammn.b() - i, parammn);
    a(0, 7, parammn);
    a(parammn.b() - 8, 7, parammn);
    a(0, parammn.b() - 8, parammn);
    b(7, 0, parammn);
    b(parammn.a() - 7 - 1, 0, parammn);
    b(7, parammn.a() - 7, parammn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mq
 * JD-Core Version:    0.7.0.1
 */