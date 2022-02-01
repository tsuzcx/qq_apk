package midas.x;

public final class se
{
  public static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  public static final int[][] b = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
  public static final int[][] c;
  public static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt2 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt3 = { 6, 30, 58, 86, 114, 142, -1 };
    c = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, arrayOfInt1, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, arrayOfInt2, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, arrayOfInt3, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
    arrayOfInt1 = new int[] { 8, 3 };
    arrayOfInt2 = new int[] { 8, 4 };
    arrayOfInt3 = new int[] { 8, 7 };
    int[] arrayOfInt4 = { 5, 8 };
    int[] arrayOfInt5 = { 4, 8 };
    int[] arrayOfInt6 = { 2, 8 };
    int[] arrayOfInt7 = { 1, 8 };
    int[] arrayOfInt8 = { 0, 8 };
    d = new int[][] { { 8, 0 }, { 8, 1 }, { 8, 2 }, arrayOfInt1, arrayOfInt2, { 8, 5 }, arrayOfInt3, { 8, 8 }, { 7, 8 }, arrayOfInt4, arrayOfInt5, { 3, 8 }, arrayOfInt6, arrayOfInt7, arrayOfInt8 };
  }
  
  public static int a(int paramInt)
  {
    return 32 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2)
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
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("0 polynomial");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, pe parampe)
    throws ce
  {
    int i = 0;
    while (i < 8)
    {
      int j = paramInt1 + i;
      if (b(parampe.a(j, paramInt2)))
      {
        parampe.a(j, paramInt2, 0);
        i += 1;
      }
      else
      {
        throw new ce();
      }
    }
  }
  
  public static void a(ee paramee, int paramInt, pe parampe)
    throws ce
  {
    int k = parampe.c() - 1;
    int j = parampe.b() - 1;
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
      while ((i1 >= 0) && (i1 < parampe.b()))
      {
        j = 0;
        while (j < 2)
        {
          k = n - j;
          if (b(parampe.a(k, i1)))
          {
            boolean bool1;
            if (i < paramee.a())
            {
              bool1 = paramee.b(i);
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
              if (re.a(paramInt, k, i1)) {
                bool2 = bool1 ^ true;
              }
            }
            parampe.a(k, i1, bool2);
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
    if (i2 == paramee.a()) {
      return;
    }
    parampe = new StringBuilder();
    parampe.append("Not all bits consumed: ");
    parampe.append(i2);
    parampe.append('/');
    parampe.append(paramee.a());
    paramee = new ce(parampe.toString());
    for (;;)
    {
      throw paramee;
    }
  }
  
  public static void a(ee paramee, le paramle, ne paramne, int paramInt, pe parampe)
    throws ce
  {
    a(parampe);
    a(paramne, parampe);
    a(paramle, paramInt, parampe);
    c(paramne, parampe);
    a(paramee, paramInt, parampe);
  }
  
  public static void a(le paramle, int paramInt, ee paramee)
    throws ce
  {
    if (te.b(paramInt))
    {
      paramInt = paramle.a() << 3 | paramInt;
      paramee.a(paramInt, 5);
      paramee.a(a(paramInt, 1335), 10);
      paramle = new ee();
      paramle.a(21522, 15);
      paramee.b(paramle);
      if (paramee.a() == 15) {
        return;
      }
      paramle = new StringBuilder();
      paramle.append("should not happen but we got: ");
      paramle.append(paramee.a());
      throw new ce(paramle.toString());
    }
    throw new ce("Invalid mask pattern");
  }
  
  public static void a(le paramle, int paramInt, pe parampe)
    throws ce
  {
    ee localee = new ee();
    a(paramle, paramInt, localee);
    paramInt = 0;
    while (paramInt < localee.a())
    {
      boolean bool = localee.b(localee.a() - 1 - paramInt);
      paramle = d[paramInt];
      parampe.a(paramle[0], paramle[1], bool);
      if (paramInt < 8) {
        parampe.a(parampe.c() - paramInt - 1, 8, bool);
      } else {
        parampe.a(8, parampe.b() - 7 + (paramInt - 8), bool);
      }
      paramInt += 1;
    }
  }
  
  public static void a(ne paramne, ee paramee)
    throws ce
  {
    paramee.a(paramne.c(), 6);
    paramee.a(a(paramne.c(), 7973), 12);
    if (paramee.a() == 18) {
      return;
    }
    paramne = new StringBuilder();
    paramne.append("should not happen but we got: ");
    paramne.append(paramee.a());
    throw new ce(paramne.toString());
  }
  
  public static void a(ne paramne, pe parampe)
    throws ce
  {
    c(parampe);
    b(parampe);
    b(paramne, parampe);
    d(parampe);
  }
  
  public static void a(pe parampe)
  {
    parampe.a((byte)-1);
  }
  
  public static void b(int paramInt1, int paramInt2, pe parampe)
  {
    int i = 0;
    while (i < 5)
    {
      int[] arrayOfInt = b[i];
      int j = 0;
      while (j < 5)
      {
        parampe.a(paramInt1 + j, paramInt2 + i, arrayOfInt[j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void b(ne paramne, pe parampe)
  {
    if (paramne.c() < 2) {
      return;
    }
    int i = paramne.c();
    paramne = c[(i - 1)];
    int k = paramne.length;
    i = 0;
    while (i < k)
    {
      int m = paramne[i];
      if (m >= 0)
      {
        int n = paramne.length;
        int j = 0;
        while (j < n)
        {
          int i1 = paramne[j];
          if ((i1 >= 0) && (b(parampe.a(i1, m)))) {
            b(i1 - 2, m - 2, parampe);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public static void b(pe parampe)
    throws ce
  {
    if (parampe.a(8, parampe.b() - 8) != 0)
    {
      parampe.a(8, parampe.b() - 8, 1);
      return;
    }
    throw new ce();
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == -1;
  }
  
  public static void c(int paramInt1, int paramInt2, pe parampe)
  {
    int i = 0;
    while (i < 7)
    {
      int[] arrayOfInt = a[i];
      int j = 0;
      while (j < 7)
      {
        parampe.a(paramInt1 + j, paramInt2 + i, arrayOfInt[j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void c(ne paramne, pe parampe)
    throws ce
  {
    if (paramne.c() < 7) {
      return;
    }
    ee localee = new ee();
    a(paramne, localee);
    int j = 0;
    int i = 17;
    while (j < 6)
    {
      int k = 0;
      while (k < 3)
      {
        boolean bool = localee.b(i);
        i -= 1;
        parampe.a(j, parampe.b() - 11 + k, bool);
        parampe.a(parampe.b() - 11 + k, j, bool);
        k += 1;
      }
      j += 1;
    }
  }
  
  public static void c(pe parampe)
    throws ce
  {
    int i = a[0].length;
    c(0, 0, parampe);
    c(parampe.c() - i, 0, parampe);
    c(0, parampe.c() - i, parampe);
    a(0, 7, parampe);
    a(parampe.c() - 8, 7, parampe);
    a(0, parampe.c() - 8, parampe);
    d(7, 0, parampe);
    d(parampe.b() - 7 - 1, 0, parampe);
    d(7, parampe.b() - 7, parampe);
  }
  
  public static void d(int paramInt1, int paramInt2, pe parampe)
    throws ce
  {
    int i = 0;
    while (i < 7)
    {
      int j = paramInt2 + i;
      if (b(parampe.a(paramInt1, j)))
      {
        parampe.a(paramInt1, j, 0);
        i += 1;
      }
      else
      {
        throw new ce();
      }
    }
  }
  
  public static void d(pe parampe)
  {
    int j;
    for (int i = 8; i < parampe.c() - 8; i = j)
    {
      j = i + 1;
      int k = j % 2;
      if (b(parampe.a(i, 6))) {
        parampe.a(i, 6, k);
      }
      if (b(parampe.a(6, i))) {
        parampe.a(6, i, k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.se
 * JD-Core Version:    0.7.0.1
 */