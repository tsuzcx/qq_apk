package com.tencent.matrix.resource.d.b;

import com.tencent.matrix.resource.d.a.b;
import com.tencent.matrix.resource.d.a.c;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class a
{
  public static Object a(InputStream paramInputStream, c paramc, int paramInt)
  {
    switch (1.fcm[paramc.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return d(paramInputStream, paramInt);
    case 2: 
      if (paramInputStream.read() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf((char)w(paramInputStream));
    case 4: 
      return Float.valueOf(Float.intBitsToFloat(x(paramInputStream)));
    case 5: 
      return Double.valueOf(Double.longBitsToDouble(y(paramInputStream)));
    case 6: 
      return Byte.valueOf((byte)paramInputStream.read());
    case 7: 
      return Short.valueOf(w(paramInputStream));
    case 8: 
      return Integer.valueOf(x(paramInputStream));
    }
    return Long.valueOf(y(paramInputStream));
  }
  
  public static String a(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(paramInputStream, arrayOfByte, paramLong);
    return new String(arrayOfByte, Charset.forName("UTF-8"));
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, long paramLong)
  {
    int i = 0;
    while (i < paramLong)
    {
      int j = paramInputStream.read(paramArrayOfByte, i, (int)(paramLong - i));
      if (j < 0) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public static void a(OutputStream paramOutputStream, b paramb)
  {
    paramOutputStream.write(paramb.fcb);
  }
  
  public static int b(InputStream paramInputStream, c paramc, int paramInt)
  {
    paramInt = paramc.nv(paramInt);
    b(paramInputStream, paramInt);
    return paramInt;
  }
  
  public static void b(InputStream paramInputStream, long paramLong)
  {
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 += l2)
    {
      l2 = paramInputStream.skip(paramLong - l1);
      if (l2 < 0L) {
        throw new EOFException();
      }
    }
  }
  
  public static b d(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    a(paramInputStream, arrayOfByte, paramInt);
    return new b(arrayOfByte);
  }
  
  public static void d(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >>> 8 & 0xFF);
    paramOutputStream.write(paramInt & 0xFF);
  }
  
  public static void d(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write(new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong }, 0, 8);
  }
  
  public static void e(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >>> 24 & 0xFF);
    paramOutputStream.write(paramInt >>> 16 & 0xFF);
    paramOutputStream.write(paramInt >>> 8 & 0xFF);
    paramOutputStream.write(paramInt & 0xFF);
  }
  
  public static void e(OutputStream paramOutputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[4096];
    int i = 0;
    while (i < paramLong >> 12)
    {
      paramOutputStream.write(arrayOfByte);
      i += 1;
    }
    paramOutputStream.write(arrayOfByte, 0, (int)(0xFFF & paramLong));
  }
  
  public static short w(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if ((i | j) < 0) {
      throw new EOFException();
    }
    return (short)(i << 8 | j);
  }
  
  public static int x(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) < 0) {
      throw new EOFException();
    }
    return (i << 24) + (j << 16) + (k << 8) + m;
  }
  
  public static long y(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[8];
    a(paramInputStream, arrayOfByte, 8L);
    long l1 = arrayOfByte[0];
    long l2 = arrayOfByte[1] & 0xFF;
    long l3 = arrayOfByte[2] & 0xFF;
    long l4 = arrayOfByte[3] & 0xFF;
    long l5 = arrayOfByte[4] & 0xFF;
    long l6 = (arrayOfByte[5] & 0xFF) << 16;
    long l7 = (arrayOfByte[6] & 0xFF) << 8;
    return (arrayOfByte[7] & 0xFF) + ((l1 << 56) + (l2 << 48) + (l3 << 40) + (l4 << 32) + (l5 << 24) + l6 + l7);
  }
  
  public static String z(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = paramInputStream.read(); i != 0; i = paramInputStream.read()) {
      localStringBuilder.append((char)i);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.d.b.a
 * JD-Core Version:    0.7.0.1
 */