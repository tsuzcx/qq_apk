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
        fM((int)paramLong);
        return;
      }
      fM((int)paramLong & 0x7F | 0x80);
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
    paramInt = fN(paramInt);
    int i = parame.zp();
    return paramInt + (i + fP(i));
  }
  
  public static int bA(int paramInt1, int paramInt2)
  {
    return fN(paramInt1) + fP(paramInt2);
  }
  
  private void bB(int paramInt1, int paramInt2)
  {
    fO(g.bC(paramInt1, paramInt2));
  }
  
  public static int bz(int paramInt1, int paramInt2)
  {
    return fN(paramInt1) + fL(paramInt2);
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return fN(paramInt) + (fP(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int cc(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = fP(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int e(int paramInt, String paramString)
  {
    return fN(paramInt) + cc(paramString);
  }
  
  public static int fL(int paramInt)
  {
    if (paramInt >= 0) {
      return fP(paramInt);
    }
    return 10;
  }
  
  private void fM(int paramInt)
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
  
  private static int fN(int paramInt)
  {
    return fP(g.bC(paramInt, 0));
  }
  
  private void fO(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        fM(paramInt);
        return;
      }
      fM(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int fP(int paramInt)
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
    return fN(paramInt) + ax(paramLong);
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return fN(paramInt) + ax(paramLong);
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
    bB(paramInt, 2);
    fO(parame.zo());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    bB(paramInt, 2);
    fO(paramArrayOfByte.length);
    q(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void bx(int paramInt1, int paramInt2)
  {
    bB(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      fO(paramInt2);
      return;
    }
    aw(paramInt2);
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    bB(paramInt1, 0);
    fO(paramInt2);
  }
  
  public final void d(int paramInt, String paramString)
  {
    bB(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    fO(paramString.length);
    q(paramString, paramString.length);
  }
  
  public final void m(int paramInt, long paramLong)
  {
    bB(paramInt, 0);
    aw(paramLong);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    bB(paramInt, 0);
    aw(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.a.b
 * JD-Core Version:    0.7.0.1
 */