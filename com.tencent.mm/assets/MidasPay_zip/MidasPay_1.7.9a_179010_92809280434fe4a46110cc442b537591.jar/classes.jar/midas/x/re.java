package midas.x;

public final class re
{
  public static int a(pe parampe)
  {
    return a(parampe, true) + a(parampe, false);
  }
  
  public static int a(pe parampe, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = parampe.b();
    } else {
      m = parampe.c();
    }
    int n;
    if (paramBoolean) {
      n = parampe.c();
    } else {
      n = parampe.b();
    }
    parampe = parampe.a();
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
          j = parampe[i1][i2];
        } else {
          j = parampe[i2][i1];
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
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    int j = paramInt3;
    int k = paramInt3;
    switch (paramInt1)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mask pattern: ");
      localStringBuilder.append(paramInt1);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 7: 
      paramInt1 = paramInt3 * paramInt2 % 3 + (paramInt3 + paramInt2 & 0x1);
      break;
    case 6: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
      paramInt1 &= 0x1;
      break;
    case 5: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
      break;
    case 4: 
      j = paramInt3 / 2;
      i = paramInt2 / 3;
      break;
    case 3: 
      paramInt1 = (paramInt3 + paramInt2) % 3;
      break;
    case 2: 
      paramInt1 = paramInt2 % 3;
      break;
    case 0: 
      k = j + i;
    }
    paramInt1 = k & 0x1;
    return paramInt1 == 0;
  }
  
  public static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
  
  public static boolean a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
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
  
  public static int b(pe parampe)
  {
    byte[][] arrayOfByte = parampe.a();
    int i1 = parampe.c();
    int i2 = parampe.b();
    int j = 0;
    int i = 0;
    while (j < i2 - 1)
    {
      parampe = arrayOfByte[j];
      int m = 0;
      while (m < i1 - 1)
      {
        int i3 = parampe[m];
        int n = m + 1;
        int k = i;
        if (i3 == parampe[n])
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
  
  public static int c(pe parampe)
  {
    byte[][] arrayOfByte = parampe.a();
    int n = parampe.c();
    int i1 = parampe.b();
    int k = 0;
    int i = 0;
    while (k < i1)
    {
      int m = 0;
      while (m < n)
      {
        parampe = arrayOfByte[k];
        int i2 = m + 6;
        int j = i;
        if (i2 < n)
        {
          j = i;
          if (parampe[m] == 1)
          {
            j = i;
            if (parampe[(m + 1)] == 0)
            {
              j = i;
              if (parampe[(m + 2)] == 1)
              {
                j = i;
                if (parampe[(m + 3)] == 1)
                {
                  j = i;
                  if (parampe[(m + 4)] == 1)
                  {
                    j = i;
                    if (parampe[(m + 5)] == 0)
                    {
                      j = i;
                      if (parampe[i2] == 1) {
                        if (!a(parampe, m - 4, m))
                        {
                          j = i;
                          if (!a(parampe, m + 7, m + 11)) {}
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
  
  public static int d(pe parampe)
  {
    byte[][] arrayOfByte = parampe.a();
    int n = parampe.c();
    int i1 = parampe.b();
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
    j = parampe.b() * parampe.c();
    return Math.abs(i * 2 - j) * 10 / j * 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.re
 * JD-Core Version:    0.7.0.1
 */