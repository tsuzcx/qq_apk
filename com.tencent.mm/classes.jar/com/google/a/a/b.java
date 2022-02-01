package com.google.a.a;

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
  
  private void aJ(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        hb((int)paramLong);
        return;
      }
      hb((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int aK(long paramLong)
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
    paramInt = fS(paramInt);
    int i = parame.yC();
    return paramInt + (i + fY(i));
  }
  
  public static int bC(int paramInt1, int paramInt2)
  {
    return fS(paramInt1) + fY(paramInt2);
  }
  
  private void br(int paramInt1, int paramInt2)
  {
    hc(g.bA(paramInt1, paramInt2));
  }
  
  public static int bu(int paramInt1, int paramInt2)
  {
    return fS(paramInt1) + fT(paramInt2);
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return fS(paramInt) + (fY(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int cb(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = fY(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int f(int paramInt, String paramString)
  {
    return fS(paramInt) + cb(paramString);
  }
  
  private static int fS(int paramInt)
  {
    return fY(g.bA(paramInt, 0));
  }
  
  public static int fT(int paramInt)
  {
    if (paramInt >= 0) {
      return fY(paramInt);
    }
    return 10;
  }
  
  public static int fY(int paramInt)
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
  
  private void hb(int paramInt)
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
  
  private void hc(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        hb(paramInt);
        return;
      }
      hb(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return fS(paramInt) + aK(paramLong);
  }
  
  public static int r(int paramInt, long paramLong)
  {
    return fS(paramInt) + aK(paramLong);
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
    br(paramInt, 2);
    hc(parame.If());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    br(paramInt, 2);
    hc(paramArrayOfByte.length);
    s(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void bB(int paramInt1, int paramInt2)
  {
    br(paramInt1, 0);
    hc(paramInt2);
  }
  
  public final void bs(int paramInt1, int paramInt2)
  {
    br(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      hc(paramInt2);
      return;
    }
    aJ(paramInt2);
  }
  
  public final void e(int paramInt, String paramString)
  {
    br(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    hc(paramString.length);
    s(paramString, paramString.length);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    br(paramInt, 0);
    aJ(paramLong);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    br(paramInt, 0);
    aJ(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.a.b
 * JD-Core Version:    0.7.0.1
 */