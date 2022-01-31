package com.google.a.a;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b
{
  private final byte[] buffer;
  final int limit;
  int position;
  
  b(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = (paramInt + 0);
  }
  
  private void ao(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        eV((int)paramLong);
        return;
      }
      eV((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int ap(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int b(int paramInt, e parame)
  {
    paramInt = eW(paramInt);
    int i = parame.sy();
    return paramInt + (i + eY(i));
  }
  
  public static int bf(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = eY(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int bl(int paramInt1, int paramInt2)
  {
    return eW(paramInt1) + eU(paramInt2);
  }
  
  public static int bm(int paramInt1, int paramInt2)
  {
    return eW(paramInt1) + eY(paramInt2);
  }
  
  private void bn(int paramInt1, int paramInt2)
  {
    eX(g.bo(paramInt1, paramInt2));
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return eW(paramInt) + (eY(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int eU(int paramInt)
  {
    if (paramInt >= 0) {
      return eY(paramInt);
    }
    return 10;
  }
  
  private void eV(int paramInt)
  {
    int i = (byte)paramInt;
    if (this.position == this.limit) {
      throw new a(this.position, this.limit);
    }
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  private static int eW(int paramInt)
  {
    return eY(g.bo(paramInt, 0));
  }
  
  private void eX(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        eV(paramInt);
        return;
      }
      eV(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int eY(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int f(int paramInt, String paramString)
  {
    return eW(paramInt) + bf(paramString);
  }
  
  private void n(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
      return;
    }
    throw new a(this.position, this.limit);
  }
  
  public static int o(int paramInt, long paramLong)
  {
    return eW(paramInt) + ap(paramLong);
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return eW(paramInt) + ap(paramLong);
  }
  
  public final void a(int paramInt, e parame)
  {
    bn(paramInt, 2);
    eX(parame.sx());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    bn(paramInt, 2);
    eX(paramArrayOfByte.length);
    n(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void bj(int paramInt1, int paramInt2)
  {
    bn(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      eX(paramInt2);
      return;
    }
    ao(paramInt2);
  }
  
  public final void bk(int paramInt1, int paramInt2)
  {
    bn(paramInt1, 0);
    eX(paramInt2);
  }
  
  public final void e(int paramInt, String paramString)
  {
    bn(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    eX(paramString.length);
    n(paramString, paramString.length);
  }
  
  public final void m(int paramInt, long paramLong)
  {
    bn(paramInt, 0);
    ao(paramLong);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    bn(paramInt, 0);
    ao(paramLong);
  }
  
  public static final class a
    extends IOException
  {
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.a.a.b
 * JD-Core Version:    0.7.0.1
 */