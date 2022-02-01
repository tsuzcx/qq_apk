package com.google.b;

final class dg
{
  private static final b cca;
  
  static
  {
    int i;
    if ((df.Js()) && (df.Jt()))
    {
      i = 1;
      if ((i == 0) || (e.An())) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new e();; localObject = new c())
    {
      cca = (b)localObject;
      return;
      i = 0;
      break;
    }
  }
  
  private static int B(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  static int B(CharSequence paramCharSequence)
  {
    int k = 0;
    int n = paramCharSequence.length();
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      if (j < n)
      {
        int m = paramCharSequence.charAt(j);
        if (m < 2048)
        {
          i += (127 - m >>> 31);
          j += 1;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (j < i2)
          {
            int i3 = paramCharSequence.charAt(j);
            if (i3 < 2048)
            {
              k += (127 - i3 >>> 31);
              m = j;
            }
            for (;;)
            {
              j = m + 1;
              break;
              int i1 = k + 2;
              k = i1;
              m = j;
              if (55296 <= i3)
              {
                k = i1;
                m = j;
                if (i3 <= 57343)
                {
                  if (Character.codePointAt(paramCharSequence, j) < 65536) {
                    throw new dg.d(j, i2);
                  }
                  m = j + 1;
                  k = i1;
                }
              }
            }
          }
          i = k + i;
        }
      }
      else
      {
        for (;;)
        {
          if (i < n) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i + 4294967296L));
          }
          return i;
        }
        i = n;
      }
    }
  }
  
  public static boolean D(byte[] paramArrayOfByte)
  {
    return cca.s(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return cca.b(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int bR(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
  
  private static int hM(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  public static boolean s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return cca.s(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static String t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return cca.t(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static final class a
  {
    private static boolean h(byte paramByte)
    {
      return paramByte > -65;
    }
  }
  
  static abstract class b
  {
    abstract int b(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    final boolean s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return v(paramArrayOfByte, paramInt1, paramInt2) == 0;
    }
    
    abstract String t(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    abstract int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  static final class c
    extends dg.b
  {
    final int b(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int k = paramCharSequence.length();
      int j = 0;
      int m = paramInt1 + paramInt2;
      paramInt2 = j;
      while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
      {
        j = paramCharSequence.charAt(paramInt2);
        if (j >= 128) {
          break;
        }
        paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
        paramInt2 += 1;
      }
      if (paramInt2 == k) {
        return paramInt1 + k;
      }
      paramInt1 += paramInt2;
      if (paramInt2 < k)
      {
        int i = paramCharSequence.charAt(paramInt2);
        if ((i < 128) && (paramInt1 < m))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)i);
          paramInt1 = j;
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          if ((i < 2048) && (paramInt1 <= m - 2))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
            paramInt1 = j + 1;
            paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            int n;
            if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
            {
              j = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
              n = j + 1;
              paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
              paramInt1 = n + 1;
              paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
            }
            else
            {
              if (paramInt1 > m - 4) {
                break label446;
              }
              j = paramInt2;
              char c;
              if (paramInt2 + 1 != paramCharSequence.length())
              {
                paramInt2 += 1;
                c = paramCharSequence.charAt(paramInt2);
                if (!Character.isSurrogatePair(i, c)) {
                  j = paramInt2;
                }
              }
              else
              {
                throw new dg.d(j - 1, k);
              }
              j = Character.toCodePoint(i, c);
              n = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
              paramInt1 = n + 1;
              paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
              n = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
              paramInt1 = n + 1;
              paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
            }
          }
        }
        label446:
        if ((55296 <= i) && (i <= 57343) && ((paramInt2 + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2 + 1))))) {
          throw new dg.d(paramInt2, k);
        }
        throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
      }
      return paramInt1;
    }
    
    final String t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt1 - paramInt2) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      int m = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      int i = 0;
      paramInt2 = paramInt1;
      paramInt1 = i;
      byte b1;
      if (paramInt2 < m)
      {
        b1 = paramArrayOfByte[paramInt2];
        if (b1 >= 0) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramInt2 += 1;
            dg.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break;
            i = 0;
            continue;
            paramInt2 = i + 1;
            dg.a.a(b1, paramArrayOfByte[i], arrayOfChar, paramInt1);
            paramInt1 += 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt2 < m)
        {
          i = paramInt2 + 1;
          b1 = paramArrayOfByte[paramInt2];
          if (b1 >= 0)
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label248;
            }
            dg.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            paramInt2 = i;
            label182:
            j = paramInt1;
            i = paramInt2;
            if (paramInt2 >= m) {
              break label385;
            }
            b1 = paramArrayOfByte[paramInt2];
            if (b1 < 0) {
              break label242;
            }
          }
          label242:
          for (int k = 1;; k = 0)
          {
            j = paramInt1;
            i = paramInt2;
            if (k == 0) {
              break label385;
            }
            paramInt2 += 1;
            dg.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break label182;
            paramInt2 = 0;
            break;
          }
          label248:
          if (dg.a.i(b1))
          {
            if (i < m) {
              break;
            }
            throw bf.Iu();
          }
          if (dg.a.j(b1))
          {
            if (i >= m - 1) {
              throw bf.Iu();
            }
            j = i + 1;
            b2 = paramArrayOfByte[i];
            paramInt2 = j + 1;
            dg.a.a(b1, b2, paramArrayOfByte[j], arrayOfChar, paramInt1);
            paramInt1 += 1;
            continue;
          }
          if (i >= m - 2) {
            throw bf.Iu();
          }
          paramInt2 = i + 1;
          byte b2 = paramArrayOfByte[i];
          i = paramInt2 + 1;
          dg.a.a(b1, b2, paramArrayOfByte[paramInt2], paramArrayOfByte[i], arrayOfChar, paramInt1);
          int j = paramInt1 + 1 + 1;
          i += 1;
          label385:
          paramInt1 = j;
          paramInt2 = i;
          continue;
        }
        return new String(arrayOfChar, 0, paramInt1);
      }
    }
    
    final int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      while ((i < paramInt2) && (paramArrayOfByte[i] >= 0)) {
        i += 1;
      }
      paramInt1 = i;
      if (i >= paramInt2)
      {
        paramInt1 = 0;
        return paramInt1;
        label38:
        paramInt1 = i;
      }
      label100:
      label102:
      do
      {
        int j;
        int k;
        do
        {
          do
          {
            if (paramInt1 >= paramInt2) {
              return 0;
            }
            i = paramInt1 + 1;
            j = paramArrayOfByte[paramInt1];
            if (j >= 0) {
              break label38;
            }
            if (j >= -32) {
              break label102;
            }
            paramInt1 = j;
            if (i >= paramInt2) {
              break;
            }
            if (j < -62) {
              break label100;
            }
            paramInt1 = i + 1;
          } while (paramArrayOfByte[i] <= -65);
          return -1;
          if (j >= -16) {
            break label184;
          }
          if (i >= paramInt2 - 1) {
            return dg.u(paramArrayOfByte, i, paramInt2);
          }
          k = i + 1;
          paramInt1 = paramArrayOfByte[i];
          if ((paramInt1 > -65) || ((j == -32) && (paramInt1 < -96)) || ((j == -19) && (paramInt1 >= -96))) {
            break label182;
          }
          paramInt1 = k + 1;
        } while (paramArrayOfByte[k] <= -65);
        return -1;
        if (i >= paramInt2 - 2) {
          return dg.u(paramArrayOfByte, i, paramInt2);
        }
        paramInt1 = i + 1;
        i = paramArrayOfByte[i];
        if ((i > -65) || ((j << 28) + (i + 112) >> 30 != 0)) {
          break label262;
        }
        i = paramInt1 + 1;
        if (paramArrayOfByte[paramInt1] > -65) {
          break label262;
        }
        paramInt1 = i + 1;
      } while (paramArrayOfByte[i] <= -65);
      label182:
      label184:
      return -1;
    }
  }
  
  static final class e
    extends dg.b
  {
    private static int a(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        throw new AssertionError();
      case 0: 
        return dg.hN(paramInt1);
      case 1: 
        return dg.bS(paramInt1, df.d(paramArrayOfByte, paramLong));
      }
      return dg.C(paramInt1, df.d(paramArrayOfByte, paramLong), df.d(paramArrayOfByte, 1L + paramLong));
    }
    
    private static int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
    {
      int i;
      if (paramInt < 16)
      {
        i = 0;
        paramLong = i + paramLong;
        paramInt -= i;
      }
      long l1;
      label97:
      label247:
      label249:
      do
      {
        long l2;
        do
        {
          do
          {
            i = 0;
            for (;;)
            {
              l1 = paramLong;
              if (paramInt <= 0) {
                break;
              }
              l1 = 1L + paramLong;
              i = df.d(paramArrayOfByte, paramLong);
              if (i < 0) {
                break;
              }
              paramInt -= 1;
              paramLong = l1;
            }
            j = 0;
            for (l1 = paramLong;; l1 = 1L + l1)
            {
              if (j >= paramInt) {
                break label97;
              }
              i = j;
              if (df.d(paramArrayOfByte, l1) < 0) {
                break;
              }
              j += 1;
            }
            i = paramInt;
            break;
            if (paramInt == 0) {
              return 0;
            }
            paramInt -= 1;
            if (i >= -32) {
              break label156;
            }
            if (paramInt == 0) {
              return i;
            }
            paramInt -= 1;
            if (i < -62) {
              break label154;
            }
            paramLong = 1L + l1;
          } while (df.d(paramArrayOfByte, l1) <= -65);
          return -1;
          if (i >= -16) {
            break label249;
          }
          if (paramInt < 2) {
            return a(paramArrayOfByte, i, l1, paramInt);
          }
          paramInt -= 2;
          l2 = l1 + 1L;
          j = df.d(paramArrayOfByte, l1);
          if ((j > -65) || ((i == -32) && (j < -96)) || ((i == -19) && (j >= -96))) {
            break label247;
          }
          paramLong = 1L + l2;
        } while (df.d(paramArrayOfByte, l2) <= -65);
        return -1;
        if (paramInt < 3) {
          return a(paramArrayOfByte, i, l1, paramInt);
        }
        paramInt -= 3;
        paramLong = 1L + l1;
        int j = df.d(paramArrayOfByte, l1);
        if ((j > -65) || ((i << 28) + (j + 112) >> 30 != 0)) {
          break label336;
        }
        l1 = 1L + paramLong;
        if (df.d(paramArrayOfByte, paramLong) > -65) {
          break label336;
        }
        paramLong = 1L + l1;
      } while (df.d(paramArrayOfByte, l1) <= -65);
      label154:
      label156:
      label336:
      return -1;
    }
    
    final int b(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      long l1 = paramInt1;
      long l3 = l1 + paramInt2;
      int j = paramCharSequence.length();
      if ((j > paramInt2) || (paramArrayOfByte.length - paramInt2 < paramInt1)) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + paramCharSequence.charAt(j - 1) + " at index " + (paramInt1 + paramInt2));
      }
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        paramInt2 = paramCharSequence.charAt(paramInt1);
        if (paramInt2 >= 128) {
          break;
        }
        df.a(paramArrayOfByte, l1, (byte)paramInt2);
        paramInt1 += 1;
        l1 = 1L + l1;
      }
      if (paramInt1 == j) {
        return (int)l1;
      }
      for (;;)
      {
        if (paramInt1 < j)
        {
          int i = paramCharSequence.charAt(paramInt1);
          long l2;
          if ((i < 128) && (l1 < l3))
          {
            l2 = 1L + l1;
            df.a(paramArrayOfByte, l1, (byte)i);
            l1 = l2;
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((i < 2048) && (l1 <= l3 - 2L))
            {
              l2 = l1 + 1L;
              df.a(paramArrayOfByte, l1, (byte)(i >>> 6 | 0x3C0));
              l1 = 1L + l2;
              df.a(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
            }
            else if (((i < 55296) || (57343 < i)) && (l1 <= l3 - 3L))
            {
              l2 = 1L + l1;
              df.a(paramArrayOfByte, l1, (byte)(i >>> 12 | 0x1E0));
              long l4 = 1L + l2;
              df.a(paramArrayOfByte, l2, (byte)(i >>> 6 & 0x3F | 0x80));
              l1 = 1L + l4;
              df.a(paramArrayOfByte, l4, (byte)(i & 0x3F | 0x80));
            }
            else
            {
              if (l1 > l3 - 4L) {
                break label529;
              }
              paramInt2 = paramInt1;
              char c;
              if (paramInt1 + 1 != j)
              {
                paramInt1 += 1;
                c = paramCharSequence.charAt(paramInt1);
                if (!Character.isSurrogatePair(i, c)) {
                  paramInt2 = paramInt1;
                }
              }
              else
              {
                throw new dg.d(paramInt2 - 1, j);
              }
              paramInt2 = Character.toCodePoint(i, c);
              l2 = 1L + l1;
              df.a(paramArrayOfByte, l1, (byte)(paramInt2 >>> 18 | 0xF0));
              l1 = 1L + l2;
              df.a(paramArrayOfByte, l2, (byte)(paramInt2 >>> 12 & 0x3F | 0x80));
              l2 = l1 + 1L;
              df.a(paramArrayOfByte, l1, (byte)(paramInt2 >>> 6 & 0x3F | 0x80));
              l1 = 1L + l2;
              df.a(paramArrayOfByte, l2, (byte)(paramInt2 & 0x3F | 0x80));
            }
          }
          label529:
          if ((55296 <= i) && (i <= 57343) && ((paramInt1 + 1 == j) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt1 + 1))))) {
            throw new dg.d(paramInt1, j);
          }
          throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + l1);
        }
        return (int)l1;
      }
    }
    
    final String t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt1 - paramInt2) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      int m = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      int i = 0;
      paramInt2 = paramInt1;
      paramInt1 = i;
      byte b1;
      if (paramInt2 < m)
      {
        b1 = df.d(paramArrayOfByte, paramInt2);
        if (b1 >= 0) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramInt2 += 1;
            dg.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break;
            i = 0;
            continue;
            paramInt2 = i + 1;
            dg.a.a(b1, df.d(paramArrayOfByte, i), arrayOfChar, paramInt1);
            paramInt1 += 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt2 < m)
        {
          i = paramInt2 + 1;
          b1 = df.d(paramArrayOfByte, paramInt2);
          if (b1 >= 0)
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label260;
            }
            dg.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            paramInt2 = i;
            label191:
            j = paramInt1;
            i = paramInt2;
            if (paramInt2 >= m) {
              break label412;
            }
            b1 = df.d(paramArrayOfByte, paramInt2);
            if (b1 < 0) {
              break label254;
            }
          }
          label254:
          for (int k = 1;; k = 0)
          {
            j = paramInt1;
            i = paramInt2;
            if (k == 0) {
              break label412;
            }
            paramInt2 += 1;
            dg.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break label191;
            paramInt2 = 0;
            break;
          }
          label260:
          if (dg.a.i(b1))
          {
            if (i < m) {
              break;
            }
            throw bf.Iu();
          }
          if (dg.a.j(b1))
          {
            if (i >= m - 1) {
              throw bf.Iu();
            }
            j = i + 1;
            b2 = df.d(paramArrayOfByte, i);
            paramInt2 = j + 1;
            dg.a.a(b1, b2, df.d(paramArrayOfByte, j), arrayOfChar, paramInt1);
            paramInt1 += 1;
            continue;
          }
          if (i >= m - 2) {
            throw bf.Iu();
          }
          paramInt2 = i + 1;
          byte b2 = df.d(paramArrayOfByte, i);
          i = paramInt2 + 1;
          dg.a.a(b1, b2, df.d(paramArrayOfByte, paramInt2), df.d(paramArrayOfByte, i), arrayOfChar, paramInt1);
          int j = paramInt1 + 1 + 1;
          i += 1;
          label412:
          paramInt1 = j;
          paramInt2 = i;
          continue;
        }
        return new String(arrayOfChar, 0, paramInt1);
      }
    }
    
    final int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt2) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      long l = paramInt1;
      return a(paramArrayOfByte, l, (int)(paramInt2 - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.dg
 * JD-Core Version:    0.7.0.1
 */