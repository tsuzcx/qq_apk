package midas.x;

final class oa
{
  static int a(ny paramny)
  {
    return a(paramny, true) + a(paramny, false);
  }
  
  private static int a(ny paramny, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = paramny.a();
    } else {
      m = paramny.b();
    }
    int n;
    if (paramBoolean) {
      n = paramny.b();
    } else {
      n = paramny.a();
    }
    paramny = paramny.c();
    int i1 = 0;
    int i = 0;
    while (i1 < m)
    {
      int i2 = 0;
      int i3 = 0;
      int i4;
      for (int k = -1; i2 < n; k = i4)
      {
        if (paramBoolean) {
          j = paramny[i1][i2];
        } else {
          j = paramny[i2][i1];
        }
        if (j == k)
        {
          j = i3 + 1;
          i4 = k;
        }
        else
        {
          k = i;
          if (i3 >= 5) {
            k = i + (i3 - 5 + 3);
          }
          i3 = 1;
          i4 = j;
          i = k;
          j = i3;
        }
        i2 += 1;
        i3 = j;
      }
      int j = i;
      if (i3 >= 5) {
        j = i + (i3 - 5 + 3);
      }
      i = j;
      i1 += 1;
    }
    return i;
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mask pattern: ");
      localStringBuilder.append(paramInt1);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 7: 
      paramInt1 = paramInt3 * paramInt2 % 3 + (paramInt3 + paramInt2 & 0x1) & 0x1;
      break;
    case 6: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3 & 0x1;
      break;
    case 5: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
      break;
    case 4: 
      paramInt1 = paramInt3 / 2 + paramInt2 / 3 & 0x1;
      break;
    case 3: 
      paramInt1 = (paramInt3 + paramInt2) % 3;
      break;
    case 2: 
      paramInt1 = paramInt2 % 3;
      break;
    case 1: 
      paramInt1 = paramInt3 & 0x1;
      break;
    case 0: 
      paramInt1 = paramInt3 + paramInt2 & 0x1;
    }
    return paramInt1 == 0;
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.min(paramInt2, paramArrayOfByte.length);
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] == 1) {
        return false;
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private static boolean a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = Math.max(paramInt2, 0);
    paramInt3 = Math.min(paramInt3, paramArrayOfByte.length);
    while (paramInt2 < paramInt3)
    {
      if (paramArrayOfByte[paramInt2][paramInt1] == 1) {
        return false;
      }
      paramInt2 += 1;
    }
    return true;
  }
  
  static int b(ny paramny)
  {
    byte[][] arrayOfByte = paramny.c();
    int i1 = paramny.b();
    int i2 = paramny.a();
    int j = 0;
    int i = 0;
    while (j < i2 - 1)
    {
      paramny = arrayOfByte[j];
      int m = 0;
      while (m < i1 - 1)
      {
        int i3 = paramny[m];
        int n = m + 1;
        int k = i;
        if (i3 == paramny[n])
        {
          int i4 = j + 1;
          k = i;
          if (i3 == arrayOfByte[i4][m])
          {
            k = i;
            if (i3 == arrayOfByte[i4][n]) {
              k = i + 1;
            }
          }
        }
        m = n;
        i = k;
      }
      j += 1;
    }
    return i * 3;
  }
  
  static int c(ny paramny)
  {
    byte[][] arrayOfByte = paramny.c();
    int n = paramny.b();
    int i1 = paramny.a();
    int k = 0;
    int i = 0;
    while (k < i1)
    {
      int m = 0;
      while (m < n)
      {
        paramny = arrayOfByte[k];
        int i2 = m + 6;
        int j = i;
        if (i2 < n)
        {
          j = i;
          if (paramny[m] == 1)
          {
            j = i;
            if (paramny[(m + 1)] == 0)
            {
              j = i;
              if (paramny[(m + 2)] == 1)
              {
                j = i;
                if (paramny[(m + 3)] == 1)
                {
                  j = i;
                  if (paramny[(m + 4)] == 1)
                  {
                    j = i;
                    if (paramny[(m + 5)] == 0)
                    {
                      j = i;
                      if (paramny[i2] == 1) {
                        if (!a(paramny, m - 4, m))
                        {
                          j = i;
                          if (!a(paramny, m + 7, m + 11)) {}
                        }
                        else
                        {
                          j = i + 1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i2 = k + 6;
        i = j;
        if (i2 < i1)
        {
          i = j;
          if (arrayOfByte[k][m] == 1)
          {
            i = j;
            if (arrayOfByte[(k + 1)][m] == 0)
            {
              i = j;
              if (arrayOfByte[(k + 2)][m] == 1)
              {
                i = j;
                if (arrayOfByte[(k + 3)][m] == 1)
                {
                  i = j;
                  if (arrayOfByte[(k + 4)][m] == 1)
                  {
                    i = j;
                    if (arrayOfByte[(k + 5)][m] == 0)
                    {
                      i = j;
                      if (arrayOfByte[i2][m] == 1) {
                        if (!a(arrayOfByte, m, k - 4, k))
                        {
                          i = j;
                          if (!a(arrayOfByte, m, k + 7, k + 11)) {}
                        }
                        else
                        {
                          i = j + 1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        m += 1;
      }
      k += 1;
    }
    return i * 40;
  }
  
  static int d(ny paramny)
  {
    byte[][] arrayOfByte = paramny.c();
    int n = paramny.b();
    int i1 = paramny.a();
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      byte[] arrayOfByte1 = arrayOfByte[j];
      int k = 0;
      while (k < n)
      {
        int m = i;
        if (arrayOfByte1[k] == 1) {
          m = i + 1;
        }
        k += 1;
        i = m;
      }
      j += 1;
    }
    j = paramny.a() * paramny.b();
    return Math.abs(i * 2 - j) * 10 / j * 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.oa
 * JD-Core Version:    0.7.0.1
 */