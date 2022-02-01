package com.google.c.e.a;

import com.google.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

final class g
{
  private static final byte[] bKh;
  private static final byte[] bKi;
  private static final byte[] bKj;
  private static final byte[] bKk;
  private static final Charset bKl;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(12403);
    bKh = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
    bKi = new byte[] { 59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
    bKj = new byte[''];
    bKk = new byte[''];
    bKl = Charset.forName("ISO-8859-1");
    Arrays.fill(bKj, (byte)-1);
    int i = 0;
    while (i < bKh.length)
    {
      int k = bKh[i];
      if (k > 0) {
        bKj[k] = ((byte)i);
      }
      i += 1;
    }
    Arrays.fill(bKk, (byte)-1);
    i = j;
    while (i < bKi.length)
    {
      j = bKi[i];
      if (j > 0) {
        bKk[j] = ((byte)i);
      }
      i += 1;
    }
    AppMethodBeat.o(12403);
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    AppMethodBeat.i(12397);
    StringBuilder localStringBuilder = new StringBuilder(paramInt2);
    int j = 0;
    int i;
    label81:
    do
    {
      i = paramCharSequence.charAt(paramInt1 + j);
      switch (paramInt3)
      {
      default: 
        if (!m(i)) {
          break label520;
        }
        localStringBuilder.append((char)bKk[i]);
        k = j + 1;
        j = k;
      }
    } while (k < paramInt2);
    int k = localStringBuilder.length();
    paramInt2 = 0;
    paramInt1 = 0;
    label108:
    if (paramInt1 < k)
    {
      if (paramInt1 % 2 != 0)
      {
        j = 1;
        label123:
        if (j == 0) {
          break label540;
        }
        i = (char)(paramInt2 * 30 + localStringBuilder.charAt(paramInt1));
        paramStringBuilder.append(i);
      }
      for (paramInt2 = i;; paramInt2 = localStringBuilder.charAt(paramInt1))
      {
        paramInt1 += 1;
        break label108;
        if (j(i))
        {
          if (i == 32)
          {
            localStringBuilder.append('\032');
            break label81;
          }
          localStringBuilder.append((char)(i - 65));
          break label81;
        }
        if (k(i))
        {
          localStringBuilder.append('\033');
          paramInt3 = 1;
          break;
        }
        if (l(i))
        {
          paramInt3 = 2;
          localStringBuilder.append('\034');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)bKk[i]);
        break label81;
        if (k(i))
        {
          if (i == 32)
          {
            localStringBuilder.append('\032');
            break label81;
          }
          localStringBuilder.append((char)(i - 97));
          break label81;
        }
        if (j(i))
        {
          localStringBuilder.append('\033');
          localStringBuilder.append((char)(i - 65));
          break label81;
        }
        if (l(i))
        {
          paramInt3 = 2;
          localStringBuilder.append('\034');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)bKk[i]);
        break label81;
        if (l(i))
        {
          localStringBuilder.append((char)bKj[i]);
          break label81;
        }
        if (j(i))
        {
          localStringBuilder.append('\034');
          paramInt3 = 0;
          break;
        }
        if (k(i))
        {
          localStringBuilder.append('\033');
          paramInt3 = 1;
          break;
        }
        if ((paramInt1 + j + 1 < paramInt2) && (m(paramCharSequence.charAt(paramInt1 + j + 1))))
        {
          paramInt3 = 3;
          localStringBuilder.append('\031');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)bKk[i]);
        break label81;
        localStringBuilder.append('\035');
        paramInt3 = 0;
        break;
        j = 0;
        break label123;
      }
    }
    label520:
    label540:
    if (k % 2 != 0) {
      paramStringBuilder.append((char)(paramInt2 * 30 + 29));
    }
    AppMethodBeat.o(12397);
    return paramInt3;
  }
  
  private static int a(String paramString, int paramInt, Charset paramCharset)
  {
    AppMethodBeat.i(12402);
    paramCharset = paramCharset.newEncoder();
    int m = paramString.length();
    int j = paramInt;
    while (j < m)
    {
      char c = paramString.charAt(j);
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (i >= 13) {
          break;
        }
        k = i;
        if (!isDigit(c)) {
          break;
        }
        i += 1;
        int n = j + i;
        k = i;
        if (n >= m) {
          break;
        }
        c = paramString.charAt(n);
      }
      if (k >= 13)
      {
        AppMethodBeat.o(12402);
        return j - paramInt;
      }
      c = paramString.charAt(j);
      if (!paramCharset.canEncode(c))
      {
        paramString = new h("Non-encodable character detected: " + c + " (Unicode: " + c + ')');
        AppMethodBeat.o(12402);
        throw paramString;
      }
      j += 1;
    }
    AppMethodBeat.o(12402);
    return j - paramInt;
  }
  
  static String a(String paramString, c paramc, Charset paramCharset)
  {
    AppMethodBeat.i(12396);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    Charset localCharset;
    int i1;
    if (paramCharset == null)
    {
      localCharset = bKl;
      i1 = paramString.length();
      if (paramc != c.bJV) {
        break label242;
      }
      a(paramString, 0, i1, localStringBuilder, 0);
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(12396);
      return paramString;
      localCharset = paramCharset;
      if (bKl.equals(paramCharset)) {
        break;
      }
      com.google.c.b.c localc = com.google.c.b.c.bl(paramCharset.name());
      localCharset = paramCharset;
      if (localc == null) {
        break;
      }
      i = localc.bIq[0];
      if ((i >= 0) && (i < 900))
      {
        localStringBuilder.append('Ο');
        localStringBuilder.append((char)i);
        localCharset = paramCharset;
        break;
      }
      if (i < 810900)
      {
        localStringBuilder.append('Ξ');
        localStringBuilder.append((char)(i / 900 - 1));
        localStringBuilder.append((char)(i % 900));
        localCharset = paramCharset;
        break;
      }
      if (i < 811800)
      {
        localStringBuilder.append('Ν');
        localStringBuilder.append((char)(810900 - i));
        localCharset = paramCharset;
        break;
      }
      paramString = new h("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
      AppMethodBeat.o(12396);
      throw paramString;
      label242:
      if (paramc == c.bJW)
      {
        paramString = paramString.getBytes(localCharset);
        a(paramString, paramString.length, 1, localStringBuilder);
      }
      else
      {
        if (paramc != c.bJX) {
          break label296;
        }
        localStringBuilder.append('Ά');
        a(paramString, 0, i1, localStringBuilder);
      }
    }
    label296:
    int i = 0;
    int j = 0;
    int k = 0;
    label304:
    int m;
    while (j < i1)
    {
      m = f(paramString, j);
      if (m >= 13)
      {
        localStringBuilder.append('Ά');
        k = 2;
        a(paramString, j, m, localStringBuilder);
        i = 0;
        j = m + j;
      }
      else
      {
        int n = g(paramString, j);
        if ((n >= 5) || (m == i1))
        {
          m = k;
          if (k != 0)
          {
            localStringBuilder.append('΄');
            i = 0;
            m = 0;
          }
          i = a(paramString, j, n, localStringBuilder, i);
          j += n;
          k = m;
        }
        else
        {
          n = a(paramString, j, localCharset);
          m = n;
          if (n == 0) {
            m = 1;
          }
          paramc = paramString.substring(j, j + m).getBytes(localCharset);
          if ((paramc.length != 1) || (k != 0)) {
            break label498;
          }
          a(paramc, 1, 0, localStringBuilder);
        }
      }
    }
    for (;;)
    {
      j = m + j;
      break label304;
      break;
      label498:
      a(paramc, paramc.length, k, localStringBuilder);
      i = 0;
      k = 1;
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(12399);
    StringBuilder localStringBuilder = new StringBuilder(paramInt2 / 3 + 1);
    BigInteger localBigInteger2 = BigInteger.valueOf(900L);
    BigInteger localBigInteger3 = BigInteger.valueOf(0L);
    int i = 0;
    while (i < paramInt2)
    {
      localStringBuilder.setLength(0);
      int k = Math.min(44, paramInt2 - i);
      Object localObject = new BigInteger("1" + paramString.substring(paramInt1 + i, paramInt1 + i + k));
      BigInteger localBigInteger1;
      do
      {
        localStringBuilder.append((char)((BigInteger)localObject).mod(localBigInteger2).intValue());
        localBigInteger1 = ((BigInteger)localObject).divide(localBigInteger2);
        localObject = localBigInteger1;
      } while (!localBigInteger1.equals(localBigInteger3));
      int j = localStringBuilder.length() - 1;
      while (j >= 0)
      {
        paramStringBuilder.append(localStringBuilder.charAt(j));
        j -= 1;
      }
      i += k;
    }
    AppMethodBeat.o(12399);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(12398);
    int i;
    char[] arrayOfChar;
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      paramStringBuilder.append('Α');
      i = 0;
      paramInt2 = 0;
      if (paramInt1 >= 6) {
        arrayOfChar = new char[5];
      }
    }
    else
    {
      for (;;)
      {
        i = paramInt2;
        if (paramInt1 + 0 - paramInt2 < 6) {
          break label196;
        }
        long l = 0L;
        i = 0;
        for (;;)
        {
          if (i < 6)
          {
            l = (l << 8) + (paramArrayOfByte[(paramInt2 + i)] & 0xFF);
            i += 1;
            continue;
            if (paramInt1 % 6 == 0)
            {
              paramStringBuilder.append('Μ');
              break;
            }
            paramStringBuilder.append('΅');
            break;
          }
        }
        i = 0;
        while (i < 5)
        {
          arrayOfChar[i] = ((char)(int)(l % 900L));
          l /= 900L;
          i += 1;
        }
        i = 4;
        while (i >= 0)
        {
          paramStringBuilder.append(arrayOfChar[i]);
          i -= 1;
        }
        paramInt2 += 6;
      }
    }
    label196:
    while (i < paramInt1 + 0)
    {
      paramStringBuilder.append((char)(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    AppMethodBeat.o(12398);
  }
  
  private static int f(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(12400);
    int j = 0;
    int k = 0;
    int m = paramCharSequence.length();
    if (paramInt < m)
    {
      char c = paramCharSequence.charAt(paramInt);
      int i = paramInt;
      paramInt = k;
      for (;;)
      {
        j = paramInt;
        if (!isDigit(c)) {
          break;
        }
        j = paramInt;
        if (i >= m) {
          break;
        }
        j = paramInt + 1;
        k = i + 1;
        paramInt = j;
        i = k;
        if (k < m)
        {
          c = paramCharSequence.charAt(k);
          paramInt = j;
          i = k;
        }
      }
    }
    AppMethodBeat.o(12400);
    return j;
  }
  
  private static int g(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(12401);
    int n = paramCharSequence.length();
    int i = paramInt;
    int k;
    int j;
    do
    {
      k = i;
      if (i >= n) {
        break;
      }
      char c = paramCharSequence.charAt(i);
      k = 0;
      j = i;
      while ((k < 13) && (isDigit(c)) && (j < n))
      {
        i = k + 1;
        int m = j + 1;
        j = m;
        k = i;
        if (m < n)
        {
          c = paramCharSequence.charAt(m);
          j = m;
          k = i;
        }
      }
      if (k >= 13)
      {
        AppMethodBeat.o(12401);
        return j - paramInt - k;
      }
      i = j;
    } while (k > 0);
    i = paramCharSequence.charAt(j);
    if ((i == 9) || (i == 10) || (i == 13) || ((i >= 32) && (i <= 126))) {}
    for (i = 1;; i = 0)
    {
      k = j;
      if (i == 0) {
        break label195;
      }
      i = j + 1;
      break;
    }
    label195:
    AppMethodBeat.o(12401);
    return k - paramInt;
  }
  
  private static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static boolean j(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean k(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  private static boolean l(char paramChar)
  {
    return bKj[paramChar] != -1;
  }
  
  private static boolean m(char paramChar)
  {
    return bKk[paramChar] != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.e.a.g
 * JD-Core Version:    0.7.0.1
 */