package com.google.d;

import java.nio.ByteBuffer;

final class dt
{
  private static final b dWB;
  
  static
  {
    int i;
    if ((ds.ajO()) && (ds.ajP()))
    {
      i = 1;
      if ((i == 0) || (e.ZR())) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new e();; localObject = new c())
    {
      dWB = (b)localObject;
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean F(byte[] paramArrayOfByte)
  {
    return dWB.t(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  static int H(CharSequence paramCharSequence)
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
                    throw new dt.d(j, i2);
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
  
  private static int T(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  static int a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    return dWB.a(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return dWB.b(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static String a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    b localb = dWB;
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      return localb.u(paramByteBuffer.array(), i + paramInt1, paramInt2);
    }
    if (paramByteBuffer.isDirect()) {
      return localb.d(paramByteBuffer, paramInt1, paramInt2);
    }
    return b.e(paramByteBuffer, paramInt1, paramInt2);
  }
  
  public static int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return dWB.c(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  private static int cS(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
  
  static boolean k(ByteBuffer paramByteBuffer)
  {
    boolean bool = false;
    if (dWB.a(0, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static int lB(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  public static boolean t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return dWB.t(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static String u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return dWB.u(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static final class a
  {
    private static boolean j(byte paramByte)
    {
      return paramByte > -65;
    }
  }
  
  static abstract class b
  {
    static int c(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      int i = paramInt2;
      int m;
      int j;
      int k;
      if (paramInt1 != 0)
      {
        if (paramInt2 >= paramInt3) {
          return paramInt1;
        }
        m = (byte)paramInt1;
        if (m < -32)
        {
          if ((m < -62) || (paramByteBuffer.get(paramInt2) > -65)) {
            return -1;
          }
        }
        else
        {
          if (m < -16)
          {
            i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
            if (i == 0)
            {
              i = paramInt2 + 1;
              j = paramByteBuffer.get(paramInt2);
              paramInt2 = j;
              paramInt1 = i;
              if (i >= paramInt3) {
                return dt.cT(m, j);
              }
            }
            else
            {
              paramInt1 = paramInt2;
              paramInt2 = i;
            }
            if ((paramInt2 <= -65) && ((m != -32) || (paramInt2 >= -96)) && ((m != -19) || (paramInt2 < -96)))
            {
              i = paramInt1 + 1;
              if (paramByteBuffer.get(paramInt1) <= -65) {
                break label290;
              }
            }
            return -1;
          }
          i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          j = 0;
          if (i == 0)
          {
            k = paramInt2 + 1;
            i = paramByteBuffer.get(paramInt2);
            if (k < paramInt3) {
              break label298;
            }
            return dt.cT(m, i);
          }
          paramInt1 = (byte)(paramInt1 >> 16);
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          j = paramInt2 + 1;
          k = paramByteBuffer.get(paramInt2);
          paramInt1 = k;
          paramInt2 = j;
          if (j >= paramInt3) {
            return dt.U(m, i, k);
          }
        }
        if ((i <= -65) && ((m << 28) + (i + 112) >> 30 == 0) && (paramInt1 <= -65))
        {
          i = paramInt2 + 1;
          if (paramByteBuffer.get(paramInt2) <= -65) {}
        }
        else
        {
          return -1;
          i = paramInt2 + 1;
        }
        label290:
        return c(paramByteBuffer, i, paramInt3);
        label298:
        paramInt1 = j;
        paramInt2 = k;
      }
    }
    
    private static int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      paramInt1 = dt.b(paramByteBuffer, paramInt1, paramInt2) + paramInt1;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          paramInt1 = 0;
        }
        int j;
        int i;
        do
        {
          return paramInt1;
          j = paramInt1 + 1;
          i = paramByteBuffer.get(paramInt1);
          if (i >= 0) {
            break label251;
          }
          if (i >= -32) {
            break;
          }
          paramInt1 = i;
        } while (j >= paramInt2);
        if ((i < -62) || (paramByteBuffer.get(j) > -65)) {
          return -1;
        }
        paramInt1 = j + 1;
        continue;
        if (i < -16)
        {
          if (j >= paramInt2 - 1) {
            return dt.b(paramByteBuffer, i, j, paramInt2 - j);
          }
          paramInt1 = j + 1;
          j = paramByteBuffer.get(j);
          if ((j > -65) || ((i == -32) && (j < -96)) || ((i == -19) && (j >= -96)) || (paramByteBuffer.get(paramInt1) > -65)) {
            return -1;
          }
          paramInt1 += 1;
        }
        else
        {
          if (j >= paramInt2 - 2) {
            return dt.b(paramByteBuffer, i, j, paramInt2 - j);
          }
          paramInt1 = j + 1;
          j = paramByteBuffer.get(j);
          if ((j <= -65) && ((i << 28) + (j + 112) >> 30 == 0))
          {
            i = paramInt1 + 1;
            if (paramByteBuffer.get(paramInt1) <= -65)
            {
              paramInt1 = i + 1;
              if (paramByteBuffer.get(i) <= -65) {
                continue;
              }
            }
          }
          return -1;
          label251:
          paramInt1 = j;
        }
      }
    }
    
    static String e(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      if ((paramInt1 | paramInt2 | paramByteBuffer.limit() - paramInt1 - paramInt2) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      int m = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      int i = 0;
      paramInt2 = paramInt1;
      paramInt1 = i;
      byte b1;
      if (paramInt2 < m)
      {
        b1 = paramByteBuffer.get(paramInt2);
        if (b1 >= 0) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramInt2 += 1;
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break;
            i = 0;
            continue;
            paramInt2 = i + 1;
            dt.a.a(b1, paramByteBuffer.get(i), arrayOfChar, paramInt1);
            paramInt1 += 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt2 < m)
        {
          i = paramInt2 + 1;
          b1 = paramByteBuffer.get(paramInt2);
          if (b1 >= 0)
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label250;
            }
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            paramInt2 = i;
            label185:
            j = paramInt1;
            i = paramInt2;
            if (paramInt2 >= m) {
              break label393;
            }
            b1 = paramByteBuffer.get(paramInt2);
            if (b1 < 0) {
              break label244;
            }
          }
          label244:
          for (int k = 1;; k = 0)
          {
            j = paramInt1;
            i = paramInt2;
            if (k == 0) {
              break label393;
            }
            paramInt2 += 1;
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break label185;
            paramInt2 = 0;
            break;
          }
          label250:
          if (dt.a.k(b1))
          {
            if (i < m) {
              break;
            }
            throw bk.ais();
          }
          if (dt.a.l(b1))
          {
            if (i >= m - 1) {
              throw bk.ais();
            }
            j = i + 1;
            b2 = paramByteBuffer.get(i);
            paramInt2 = j + 1;
            dt.a.a(b1, b2, paramByteBuffer.get(j), arrayOfChar, paramInt1);
            paramInt1 += 1;
            continue;
          }
          if (i >= m - 2) {
            throw bk.ais();
          }
          paramInt2 = i + 1;
          byte b2 = paramByteBuffer.get(i);
          i = paramInt2 + 1;
          dt.a.a(b1, b2, paramByteBuffer.get(paramInt2), paramByteBuffer.get(i), arrayOfChar, paramInt1);
          int j = paramInt1 + 1 + 1;
          i += 1;
          label393:
          paramInt1 = j;
          paramInt2 = i;
          continue;
        }
        return new String(arrayOfChar, 0, paramInt1);
      }
    }
    
    final int a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer.hasArray())
      {
        int i = paramByteBuffer.arrayOffset();
        return c(paramInt1, paramByteBuffer.array(), i + paramInt2, i + paramInt3);
      }
      if (paramByteBuffer.isDirect()) {
        return b(paramInt1, paramByteBuffer, paramInt2, paramInt3);
      }
      return c(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
    
    abstract int b(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
    
    abstract int b(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    abstract int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
    
    abstract String d(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
    
    final boolean t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      boolean bool = false;
      if (c(0, paramArrayOfByte, paramInt1, paramInt2) == 0) {
        bool = true;
      }
      return bool;
    }
    
    abstract String u(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  static final class c
    extends dt.b
  {
    final int b(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      return c(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
    
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
                throw new dt.d(j - 1, k);
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
          throw new dt.d(paramInt2, k);
        }
        throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
      }
      return paramInt1;
    }
    
    final int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      int i = paramInt2;
      int m;
      int j;
      if (paramInt1 != 0)
      {
        if (paramInt2 >= paramInt3) {
          return paramInt1;
        }
        m = (byte)paramInt1;
        if (m < -32)
        {
          if ((m < -62) || (paramArrayOfByte[paramInt2] > -65)) {
            return -1;
          }
        }
        else
        {
          if (m < -16)
          {
            i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
            if (i == 0)
            {
              i = paramInt2 + 1;
              j = paramArrayOfByte[paramInt2];
              paramInt2 = j;
              paramInt1 = i;
              if (i >= paramInt3) {
                return dt.cT(m, j);
              }
            }
            else
            {
              paramInt1 = paramInt2;
              paramInt2 = i;
            }
            if ((paramInt2 <= -65) && ((m != -32) || (paramInt2 >= -96)) && ((m != -19) || (paramInt2 < -96)))
            {
              i = paramInt1 + 1;
              if (paramArrayOfByte[paramInt1] <= -65) {
                break label279;
              }
            }
            return -1;
          }
          i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (i == 0)
          {
            j = paramInt2 + 1;
            i = paramArrayOfByte[paramInt2];
            if (j < paramInt3) {
              break label524;
            }
            return dt.cT(m, i);
          }
          paramInt1 = (byte)(paramInt1 >> 16);
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          j = paramInt2 + 1;
          int k = paramArrayOfByte[paramInt2];
          paramInt1 = k;
          paramInt2 = j;
          if (j >= paramInt3) {
            return dt.U(m, i, k);
          }
        }
        if ((i <= -65) && ((m << 28) + (i + 112) >> 30 == 0) && (paramInt1 <= -65))
        {
          i = paramInt2 + 1;
          if (paramArrayOfByte[paramInt2] <= -65) {}
        }
        else
        {
          return -1;
          i = paramInt2 + 1;
        }
        label279:
        paramInt2 = i;
        while ((paramInt2 < paramInt3) && (paramArrayOfByte[paramInt2] >= 0)) {
          paramInt2 += 1;
        }
        paramInt1 = paramInt2;
        if (paramInt2 >= paramInt3)
        {
          return 0;
          label311:
          paramInt1 = paramInt2;
        }
        label370:
        label372:
        do
        {
          do
          {
            do
            {
              if (paramInt1 >= paramInt3) {
                return 0;
              }
              paramInt2 = paramInt1 + 1;
              i = paramArrayOfByte[paramInt1];
              if (i >= 0) {
                break label311;
              }
              if (i >= -32) {
                break label372;
              }
              paramInt1 = i;
              if (paramInt2 >= paramInt3) {
                break;
              }
              if (i < -62) {
                break label370;
              }
              paramInt1 = paramInt2 + 1;
            } while (paramArrayOfByte[paramInt2] <= -65);
            return -1;
            if (i >= -16) {
              break label452;
            }
            if (paramInt2 >= paramInt3 - 1) {
              return dt.v(paramArrayOfByte, paramInt2, paramInt3);
            }
            j = paramInt2 + 1;
            paramInt1 = paramArrayOfByte[paramInt2];
            if ((paramInt1 > -65) || ((i == -32) && (paramInt1 < -96)) || ((i == -19) && (paramInt1 >= -96))) {
              break label450;
            }
            paramInt1 = j + 1;
          } while (paramArrayOfByte[j] <= -65);
          return -1;
          if (paramInt2 >= paramInt3 - 2) {
            return dt.v(paramArrayOfByte, paramInt2, paramInt3);
          }
          paramInt1 = paramInt2 + 1;
          paramInt2 = paramArrayOfByte[paramInt2];
          if ((paramInt2 > -65) || (paramInt2 + 112 + (i << 28) >> 30 != 0)) {
            break label522;
          }
          paramInt2 = paramInt1 + 1;
          if (paramArrayOfByte[paramInt1] > -65) {
            break label522;
          }
          paramInt1 = paramInt2 + 1;
        } while (paramArrayOfByte[paramInt2] <= -65);
        label450:
        label452:
        return -1;
        label522:
        label524:
        paramInt1 = 0;
        paramInt2 = j;
      }
    }
    
    final String d(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      return e(paramByteBuffer, paramInt1, paramInt2);
    }
    
    final String u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break;
            i = 0;
            continue;
            paramInt2 = i + 1;
            dt.a.a(b1, paramArrayOfByte[i], arrayOfChar, paramInt1);
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
            dt.a.a(b1, arrayOfChar, paramInt1);
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
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break label182;
            paramInt2 = 0;
            break;
          }
          label248:
          if (dt.a.k(b1))
          {
            if (i < m) {
              break;
            }
            throw bk.ais();
          }
          if (dt.a.l(b1))
          {
            if (i >= m - 1) {
              throw bk.ais();
            }
            j = i + 1;
            b2 = paramArrayOfByte[i];
            paramInt2 = j + 1;
            dt.a.a(b1, b2, paramArrayOfByte[j], arrayOfChar, paramInt1);
            paramInt1 += 1;
            continue;
          }
          if (i >= m - 2) {
            throw bk.ais();
          }
          paramInt2 = i + 1;
          byte b2 = paramArrayOfByte[i];
          i = paramInt2 + 1;
          dt.a.a(b1, b2, paramArrayOfByte[paramInt2], paramArrayOfByte[i], arrayOfChar, paramInt1);
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
  }
  
  static final class e
    extends dt.b
  {
    private static int a(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        throw new AssertionError();
      case 0: 
        return dt.lC(paramInt1);
      case 1: 
        return dt.cT(paramInt1, ds.d(paramArrayOfByte, paramLong));
      }
      return dt.U(paramInt1, ds.d(paramArrayOfByte, paramLong), ds.d(paramArrayOfByte, 1L + paramLong));
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
              i = ds.d(paramArrayOfByte, paramLong);
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
              if (ds.d(paramArrayOfByte, l1) < 0) {
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
          } while (ds.d(paramArrayOfByte, l1) <= -65);
          return -1;
          if (i >= -16) {
            break label249;
          }
          if (paramInt < 2) {
            return a(paramArrayOfByte, i, l1, paramInt);
          }
          paramInt -= 2;
          l2 = l1 + 1L;
          j = ds.d(paramArrayOfByte, l1);
          if ((j > -65) || ((i == -32) && (j < -96)) || ((i == -19) && (j >= -96))) {
            break label247;
          }
          paramLong = 1L + l2;
        } while (ds.d(paramArrayOfByte, l2) <= -65);
        return -1;
        if (paramInt < 3) {
          return a(paramArrayOfByte, i, l1, paramInt);
        }
        paramInt -= 3;
        paramLong = 1L + l1;
        int j = ds.d(paramArrayOfByte, l1);
        if ((j > -65) || ((i << 28) + (j + 112) >> 30 != 0)) {
          break label336;
        }
        l1 = 1L + paramLong;
        if (ds.d(paramArrayOfByte, paramLong) > -65) {
          break label336;
        }
        paramLong = 1L + l1;
      } while (ds.d(paramArrayOfByte, l1) <= -65);
      label154:
      label156:
      label336:
      return -1;
    }
    
    private static int b(long paramLong, int paramInt1, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        throw new AssertionError();
      case 0: 
        return dt.lC(paramInt1);
      case 1: 
        return dt.cT(paramInt1, ds.de(paramLong));
      }
      return dt.U(paramInt1, ds.de(paramLong), ds.de(1L + paramLong));
    }
    
    private static int j(long paramLong, int paramInt)
    {
      int i;
      if (paramInt < 16)
      {
        i = 0;
        paramLong = i + paramLong;
        paramInt -= i;
      }
      long l1;
      label99:
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
              i = ds.de(paramLong);
              if (i < 0) {
                break;
              }
              paramInt -= 1;
              paramLong = l1;
            }
            j = 8 - ((int)paramLong & 0x7);
            i = j;
            for (l1 = paramLong;; l1 = 1L + l1)
            {
              if (i <= 0) {
                break label99;
              }
              if (ds.de(l1) < 0)
              {
                i = j - i;
                break;
              }
              i -= 1;
            }
            i = paramInt - j;
            while ((i >= 8) && ((ds.df(l1) & 0x80808080) == 0L))
            {
              l1 += 8L;
              i -= 8;
            }
            i = paramInt - i;
            break;
            if (paramInt == 0) {
              return 0;
            }
            paramInt -= 1;
            if (i >= -32) {
              break label196;
            }
            if (paramInt == 0) {
              return i;
            }
            paramInt -= 1;
            if (i < -62) {
              break label194;
            }
            paramLong = 1L + l1;
          } while (ds.de(l1) <= -65);
          return -1;
          if (i >= -16) {
            break label282;
          }
          if (paramInt < 2) {
            return b(l1, i, paramInt);
          }
          paramInt -= 2;
          l2 = l1 + 1L;
          j = ds.de(l1);
          if ((j > -65) || ((i == -32) && (j < -96)) || ((i == -19) && (j >= -96))) {
            break label280;
          }
          paramLong = 1L + l2;
        } while (ds.de(l2) <= -65);
        return -1;
        if (paramInt < 3) {
          return b(l1, i, paramInt);
        }
        paramInt -= 3;
        paramLong = 1L + l1;
        int j = ds.de(l1);
        if ((j > -65) || ((i << 28) + (j + 112) >> 30 != 0)) {
          break label363;
        }
        l1 = 1L + paramLong;
        if (ds.de(paramLong) > -65) {
          break label363;
        }
        paramLong = 1L + l1;
      } while (ds.de(l1) <= -65);
      label194:
      label196:
      label363:
      return -1;
    }
    
    final int b(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      if ((paramInt2 | paramInt3 | paramByteBuffer.limit() - paramInt3) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      long l1 = ds.j(paramByteBuffer);
      long l2 = paramInt2 + l1;
      long l3 = l2 + (paramInt3 - paramInt2);
      int i;
      if (paramInt1 != 0)
      {
        if (l2 >= l3) {
          return paramInt1;
        }
        i = (byte)paramInt1;
        if (i < -32)
        {
          if (i >= -62)
          {
            l1 = 1L + l2;
            if (ds.de(l2) <= -65) {
              break label364;
            }
          }
          return -1;
        }
        if (i < -16)
        {
          paramInt1 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (paramInt1 != 0) {
            break label389;
          }
          l1 = 1L + l2;
          paramInt1 = ds.de(l2);
          if (l1 >= l3) {
            return dt.cT(i, paramInt1);
          }
          l2 = l1;
        }
      }
      label389:
      for (;;)
      {
        if ((paramInt1 <= -65) && ((i != -32) || (paramInt1 >= -96)) && ((i != -19) || (paramInt1 < -96)))
        {
          l1 = 1L + l2;
          if (ds.de(l2) <= -65) {}
        }
        else
        {
          return -1;
          paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          paramInt3 = 0;
          if (paramInt2 == 0)
          {
            l1 = 1L + l2;
            paramInt2 = ds.de(l2);
            if (l1 < l3) {
              break label379;
            }
            return dt.cT(i, paramInt2);
          }
        }
        for (paramInt1 = (byte)(paramInt1 >> 16);; paramInt1 = paramInt3)
        {
          if (paramInt1 == 0)
          {
            l1 = 1L + l2;
            paramInt1 = ds.de(l2);
            if (l1 >= l3) {
              return dt.U(i, paramInt2, paramInt1);
            }
            l2 = l1;
          }
          for (;;)
          {
            if ((paramInt2 <= -65) && ((i << 28) + (paramInt2 + 112) >> 30 == 0) && (paramInt1 <= -65))
            {
              l1 = 1L + l2;
              if (ds.de(l2) <= -65) {}
            }
            else
            {
              return -1;
              l1 = l2;
            }
            label364:
            return j(l1, (int)(l3 - l1));
          }
          label379:
          l2 = l1;
        }
      }
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
        ds.a(paramArrayOfByte, l1, (byte)paramInt2);
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
            ds.a(paramArrayOfByte, l1, (byte)i);
            l1 = l2;
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((i < 2048) && (l1 <= l3 - 2L))
            {
              l2 = l1 + 1L;
              ds.a(paramArrayOfByte, l1, (byte)(i >>> 6 | 0x3C0));
              l1 = 1L + l2;
              ds.a(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
            }
            else if (((i < 55296) || (57343 < i)) && (l1 <= l3 - 3L))
            {
              l2 = 1L + l1;
              ds.a(paramArrayOfByte, l1, (byte)(i >>> 12 | 0x1E0));
              long l4 = 1L + l2;
              ds.a(paramArrayOfByte, l2, (byte)(i >>> 6 & 0x3F | 0x80));
              l1 = 1L + l4;
              ds.a(paramArrayOfByte, l4, (byte)(i & 0x3F | 0x80));
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
                throw new dt.d(paramInt2 - 1, j);
              }
              paramInt2 = Character.toCodePoint(i, c);
              l2 = 1L + l1;
              ds.a(paramArrayOfByte, l1, (byte)(paramInt2 >>> 18 | 0xF0));
              l1 = 1L + l2;
              ds.a(paramArrayOfByte, l2, (byte)(paramInt2 >>> 12 & 0x3F | 0x80));
              l2 = l1 + 1L;
              ds.a(paramArrayOfByte, l1, (byte)(paramInt2 >>> 6 & 0x3F | 0x80));
              l1 = 1L + l2;
              ds.a(paramArrayOfByte, l2, (byte)(paramInt2 & 0x3F | 0x80));
            }
          }
          label529:
          if ((55296 <= i) && (i <= 57343) && ((paramInt1 + 1 == j) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt1 + 1))))) {
            throw new dt.d(paramInt1, j);
          }
          throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + l1);
        }
        return (int)l1;
      }
    }
    
    final int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      if ((paramInt2 | paramInt3 | paramArrayOfByte.length - paramInt3) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      long l2 = paramInt2;
      long l4 = paramInt3;
      int j;
      long l1;
      if (paramInt1 != 0)
      {
        if (l2 >= l4) {
          return paramInt1;
        }
        j = (byte)paramInt1;
        if (j < -32)
        {
          if (j >= -62)
          {
            l1 = 1L + l2;
            if (ds.d(paramArrayOfByte, l2) <= -65) {
              break label377;
            }
          }
          return -1;
        }
        if (j < -16)
        {
          paramInt1 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (paramInt1 != 0) {
            break label390;
          }
          l1 = 1L + l2;
          paramInt1 = ds.d(paramArrayOfByte, l2);
          if (l1 >= l4) {
            return dt.cT(j, paramInt1);
          }
          l2 = l1;
        }
      }
      label390:
      for (;;)
      {
        if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
        {
          l1 = 1L + l2;
          if (ds.d(paramArrayOfByte, l2) <= -65) {}
        }
        else
        {
          return -1;
          paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          paramInt3 = 0;
          long l3;
          if (paramInt2 == 0)
          {
            l3 = 1L + l2;
            int i = ds.d(paramArrayOfByte, l2);
            paramInt1 = paramInt3;
            paramInt2 = i;
            l1 = l3;
            if (l3 >= l4) {
              return dt.cT(j, i);
            }
          }
          else
          {
            paramInt1 = (byte)(paramInt1 >> 16);
            l1 = l2;
          }
          if (paramInt1 == 0)
          {
            l3 = 1L + l1;
            paramInt3 = ds.d(paramArrayOfByte, l1);
            paramInt1 = paramInt3;
            l2 = l3;
            if (l3 >= l4) {
              return dt.U(j, paramInt2, paramInt3);
            }
          }
          else
          {
            l2 = l1;
          }
          if ((paramInt2 <= -65) && (paramInt2 + 112 + (j << 28) >> 30 == 0) && (paramInt1 <= -65))
          {
            l1 = 1L + l2;
            if (ds.d(paramArrayOfByte, l2) <= -65) {}
          }
          else
          {
            return -1;
            l1 = l2;
          }
        }
        label377:
        return a(paramArrayOfByte, l1, (int)(l4 - l1));
      }
    }
    
    final String d(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      if ((paramInt1 | paramInt2 | paramByteBuffer.limit() - paramInt1 - paramInt2) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      long l2 = ds.j(paramByteBuffer) + paramInt1;
      long l3 = l2 + paramInt2;
      paramByteBuffer = new char[paramInt2];
      paramInt2 = 0;
      long l1 = l2;
      paramInt1 = paramInt2;
      byte b1;
      int i;
      if (l2 < l3)
      {
        b1 = ds.de(l2);
        if (b1 >= 0) {}
        for (i = 1;; i = 0)
        {
          l1 = l2;
          paramInt1 = paramInt2;
          if (i == 0) {
            break label166;
          }
          l2 += 1L;
          dt.a.a(b1, paramByteBuffer, paramInt2);
          paramInt2 += 1;
          break;
        }
        dt.a.a(b1, ds.de(l2), paramByteBuffer, paramInt1);
        l1 = 1L + l2;
        paramInt1 += 1;
      }
      for (;;)
      {
        label166:
        if (l1 >= l3) {
          break label439;
        }
        l2 = l1 + 1L;
        b1 = ds.de(l1);
        if (b1 >= 0)
        {
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label286;
          }
          paramInt2 = paramInt1 + 1;
          dt.a.a(b1, paramByteBuffer, paramInt1);
          l1 = l2;
          paramInt1 = paramInt2;
          label215:
          l2 = l1;
          paramInt2 = paramInt1;
          if (l1 >= l3) {
            break label430;
          }
          b1 = ds.de(l1);
          if (b1 < 0) {
            break label280;
          }
        }
        label280:
        for (i = 1;; i = 0)
        {
          l2 = l1;
          paramInt2 = paramInt1;
          if (i == 0) {
            break label430;
          }
          l1 += 1L;
          dt.a.a(b1, paramByteBuffer, paramInt1);
          paramInt1 += 1;
          break label215;
          paramInt2 = 0;
          break;
        }
        label286:
        if (dt.a.k(b1))
        {
          if (l2 < l3) {
            break;
          }
          throw bk.ais();
        }
        if (dt.a.l(b1))
        {
          if (l2 >= l3 - 1L) {
            throw bk.ais();
          }
          l1 = l2 + 1L;
          dt.a.a(b1, ds.de(l2), ds.de(l1), paramByteBuffer, paramInt1);
          l1 = 1L + l1;
          paramInt1 += 1;
        }
        else
        {
          if (l2 >= l3 - 2L) {
            throw bk.ais();
          }
          l1 = 1L + l2;
          byte b2 = ds.de(l2);
          l2 = l1 + 1L;
          dt.a.a(b1, b2, ds.de(l1), ds.de(l2), paramByteBuffer, paramInt1);
          paramInt2 = paramInt1 + 1 + 1;
          l2 = 1L + l2;
          label430:
          paramInt1 = paramInt2;
          l1 = l2;
        }
      }
      label439:
      return new String(paramByteBuffer, 0, paramInt1);
    }
    
    final String u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        b1 = ds.d(paramArrayOfByte, paramInt2);
        if (b1 >= 0) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramInt2 += 1;
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break;
            i = 0;
            continue;
            paramInt2 = i + 1;
            dt.a.a(b1, ds.d(paramArrayOfByte, i), arrayOfChar, paramInt1);
            paramInt1 += 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt2 < m)
        {
          i = paramInt2 + 1;
          b1 = ds.d(paramArrayOfByte, paramInt2);
          if (b1 >= 0)
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label260;
            }
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            paramInt2 = i;
            label191:
            j = paramInt1;
            i = paramInt2;
            if (paramInt2 >= m) {
              break label412;
            }
            b1 = ds.d(paramArrayOfByte, paramInt2);
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
            dt.a.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
            break label191;
            paramInt2 = 0;
            break;
          }
          label260:
          if (dt.a.k(b1))
          {
            if (i < m) {
              break;
            }
            throw bk.ais();
          }
          if (dt.a.l(b1))
          {
            if (i >= m - 1) {
              throw bk.ais();
            }
            j = i + 1;
            b2 = ds.d(paramArrayOfByte, i);
            paramInt2 = j + 1;
            dt.a.a(b1, b2, ds.d(paramArrayOfByte, j), arrayOfChar, paramInt1);
            paramInt1 += 1;
            continue;
          }
          if (i >= m - 2) {
            throw bk.ais();
          }
          paramInt2 = i + 1;
          byte b2 = ds.d(paramArrayOfByte, i);
          i = paramInt2 + 1;
          dt.a.a(b1, b2, ds.d(paramArrayOfByte, paramInt2), ds.d(paramArrayOfByte, i), arrayOfChar, paramInt1);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.dt
 * JD-Core Version:    0.7.0.1
 */