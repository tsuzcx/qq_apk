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
  
  private void aw(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        fJ((int)paramLong);
        return;
      }
      fJ((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int ax(long paramLong)
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
    paramInt = fK(paramInt);
    int i = parame.xS();
    return paramInt + (i + fM(i));
  }
  
  public static int bj(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = fM(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int bx(int paramInt1, int paramInt2)
  {
    return fK(paramInt1) + fI(paramInt2);
  }
  
  public static int by(int paramInt1, int paramInt2)
  {
    return fK(paramInt1) + fM(paramInt2);
  }
  
  private void bz(int paramInt1, int paramInt2)
  {
    fL(g.bA(paramInt1, paramInt2));
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return fK(paramInt) + (fM(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int e(int paramInt, String paramString)
  {
    return fK(paramInt) + bj(paramString);
  }
  
  public static int fI(int paramInt)
  {
    if (paramInt >= 0) {
      return fM(paramInt);
    }
    return 10;
  }
  
  private void fJ(int paramInt)
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
  
  private static int fK(int paramInt)
  {
    return fM(g.bA(paramInt, 0));
  }
  
  private void fL(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        fJ(paramInt);
        return;
      }
      fJ(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int fM(int paramInt)
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
  
  public static int o(int paramInt, long paramLong)
  {
    return fK(paramInt) + ax(paramLong);
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return fK(paramInt) + ax(paramLong);
  }
  
  private void q(byte[] paramArrayOfByte, int paramInt)
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
    bz(paramInt, 2);
    fL(parame.xR());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    bz(paramInt, 2);
    fL(paramArrayOfByte.length);
    q(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void bv(int paramInt1, int paramInt2)
  {
    bz(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      fL(paramInt2);
      return;
    }
    aw(paramInt2);
  }
  
  public final void bw(int paramInt1, int paramInt2)
  {
    bz(paramInt1, 0);
    fL(paramInt2);
  }
  
  public final void d(int paramInt, String paramString)
  {
    bz(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    fL(paramString.length);
    q(paramString, paramString.length);
  }
  
  public final void m(int paramInt, long paramLong)
  {
    bz(paramInt, 0);
    aw(paramLong);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    bz(paramInt, 0);
    aw(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.b
 * JD-Core Version:    0.7.0.1
 */