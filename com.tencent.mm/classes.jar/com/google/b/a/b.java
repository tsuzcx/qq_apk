package com.google.b.a;

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
  
  private void aA(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        fX((int)paramLong);
        return;
      }
      fX((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int aB(long paramLong)
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
    paramInt = fY(paramInt);
    int i = parame.yf();
    return paramInt + (i + ga(i));
  }
  
  public static int bA(int paramInt1, int paramInt2)
  {
    return fY(paramInt1) + fW(paramInt2);
  }
  
  public static int bB(int paramInt1, int paramInt2)
  {
    return fY(paramInt1) + ga(paramInt2);
  }
  
  private void bC(int paramInt1, int paramInt2)
  {
    fZ(g.bD(paramInt1, paramInt2));
  }
  
  public static int bs(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = ga(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return fY(paramInt) + (ga(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int e(int paramInt, String paramString)
  {
    return fY(paramInt) + bs(paramString);
  }
  
  public static int fW(int paramInt)
  {
    if (paramInt >= 0) {
      return ga(paramInt);
    }
    return 10;
  }
  
  private void fX(int paramInt)
  {
    int i = (byte)paramInt;
    if (this.position == this.limit) {
      throw new b.a(this.position, this.limit);
    }
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  private static int fY(int paramInt)
  {
    return ga(g.bD(paramInt, 0));
  }
  
  private void fZ(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        fX(paramInt);
        return;
      }
      fX(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int ga(int paramInt)
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
  
  public static int p(int paramInt, long paramLong)
  {
    return fY(paramInt) + aB(paramLong);
  }
  
  public static int q(int paramInt, long paramLong)
  {
    return fY(paramInt) + aB(paramLong);
  }
  
  private void s(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
      return;
    }
    throw new b.a(this.position, this.limit);
  }
  
  public final void a(int paramInt, e parame)
  {
    bC(paramInt, 2);
    fZ(parame.ye());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    bC(paramInt, 2);
    fZ(paramArrayOfByte.length);
    s(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    bC(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      fZ(paramInt2);
      return;
    }
    aA(paramInt2);
  }
  
  public final void bz(int paramInt1, int paramInt2)
  {
    bC(paramInt1, 0);
    fZ(paramInt2);
  }
  
  public final void d(int paramInt, String paramString)
  {
    bC(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    fZ(paramString.length);
    s(paramString, paramString.length);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    bC(paramInt, 0);
    aA(paramLong);
  }
  
  public final void o(int paramInt, long paramLong)
  {
    bC(paramInt, 0);
    aA(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.b
 * JD-Core Version:    0.7.0.1
 */