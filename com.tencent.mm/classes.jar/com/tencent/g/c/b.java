package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class b
{
  private static void a(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length >> 2;
    int j = i;
    if (i > paramInt) {
      j = paramInt;
    }
    i = 0;
    int k = 0;
    while (i < j)
    {
      int m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 8 & 0xFF));
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] >>> 16 & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
    }
    if ((paramInt > j) && (k < paramArrayOfByte.length))
    {
      paramInt = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      j = 8;
      while ((j <= 24) && (paramInt < paramArrayOfByte.length))
      {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >>> j & 0xFF));
        j += 8;
        paramInt += 1;
      }
    }
  }
  
  private static void b(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int k = paramArrayOfByte.length;
    int i = 0;
    int m;
    for (int j = 0; i < k >> 2; j = m + 1)
    {
      m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = ((paramArrayOfByte[m] & 0xFF) << 8 | n);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
      i += 1;
    }
    if (j < paramArrayOfByte.length)
    {
      k = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      j = 8;
      while (k < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
        k += 1;
        j += 8;
      }
    }
  }
  
  private static byte[] du(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(208295);
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte.length <= 16) {}
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      AppMethodBeat.o(208295);
      return localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        localObject = null;
      }
    }
  }
  
  public static byte[] ion()
  {
    AppMethodBeat.i(208283);
    try
    {
      Object localObject = new StringBuffer();
      int i = 0;
      while (i < "http://pmir.3g.qq.com".length())
      {
        ((StringBuffer)localObject).append((char)("http://pmir.3g.qq.com".charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString().getBytes("UTF-8");
      AppMethodBeat.o(208283);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(208283);
    }
    return null;
  }
  
  public static byte[] p(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(208298);
    byte[] arrayOfByte = du(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0))
    {
      AppMethodBeat.o(208298);
      return paramArrayOfByte1;
    }
    if (paramArrayOfByte1.length % 4 == 0)
    {
      i = (paramArrayOfByte1.length >>> 2) + 1;
      paramArrayOfByte2 = new int[i];
      b(paramArrayOfByte1, paramArrayOfByte2);
      paramArrayOfByte2[(i - 1)] = paramArrayOfByte1.length;
      if (arrayOfByte.length % 4 != 0) {
        break label117;
      }
    }
    label117:
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
      i = (paramArrayOfByte1.length >>> 2) + 2;
      break;
    }
    b(arrayOfByte, paramArrayOfByte1);
    int i1 = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[i1];
    int j = 52 / (i1 + 1) + 6;
    int m;
    for (int k = 0; j > 0; k = m)
    {
      m = k - 1640531527;
      int i2 = m >>> 2 & 0x3;
      int n = 0;
      k = i;
      i = n;
      while (i < i1)
      {
        n = paramArrayOfByte2[(i + 1)];
        int i3 = paramArrayOfByte2[i];
        k = ((k ^ paramArrayOfByte1[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
        paramArrayOfByte2[i] = k;
        i += 1;
      }
      n = paramArrayOfByte2[0];
      i = paramArrayOfByte2[i1] + ((paramArrayOfByte1[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4));
      paramArrayOfByte2[i1] = i;
      j -= 1;
    }
    paramArrayOfByte1 = new byte[paramArrayOfByte2.length << 2];
    a(paramArrayOfByte2, paramArrayOfByte2.length, paramArrayOfByte1);
    AppMethodBeat.o(208298);
    return paramArrayOfByte1;
  }
  
  public static byte[] q(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(208301);
    byte[] arrayOfByte = du(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0))
    {
      AppMethodBeat.o(208301);
      return paramArrayOfByte1;
    }
    if ((paramArrayOfByte1.length % 4 != 0) || (paramArrayOfByte1.length < 8))
    {
      AppMethodBeat.o(208301);
      return null;
    }
    paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
    b(paramArrayOfByte1, paramArrayOfByte2);
    if (arrayOfByte.length % 4 == 0) {}
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
    }
    b(arrayOfByte, paramArrayOfByte1);
    int n = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[0];
    int j = (52 / (n + 1) + 6) * -1640531527;
    while (j != 0)
    {
      int i1 = j >>> 2 & 0x3;
      int m = n;
      int k = i;
      i = m;
      while (i > 0)
      {
        m = paramArrayOfByte2[(i - 1)];
        k = paramArrayOfByte2[i] - ((k ^ j) + (m ^ paramArrayOfByte1[(i & 0x3 ^ i1)]) ^ (m >>> 5 ^ k << 2) + (k >>> 3 ^ m << 4));
        paramArrayOfByte2[i] = k;
        i -= 1;
      }
      m = paramArrayOfByte2[n];
      i = paramArrayOfByte2[0] - ((paramArrayOfByte1[(i & 0x3 ^ i1)] ^ m) + (k ^ j) ^ (m >>> 5 ^ k << 2) + (k >>> 3 ^ m << 4));
      paramArrayOfByte2[0] = i;
      j += 1640531527;
    }
    i = paramArrayOfByte2[n];
    if ((i < 0) || (i > paramArrayOfByte2.length - 1 << 2))
    {
      AppMethodBeat.o(208301);
      return null;
    }
    paramArrayOfByte1 = new byte[i];
    a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
    AppMethodBeat.o(208301);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.b
 * JD-Core Version:    0.7.0.1
 */