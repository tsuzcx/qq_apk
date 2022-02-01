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
  
  private void aN(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        hS((int)paramLong);
        return;
      }
      hS((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int aO(long paramLong)
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
    paramInt = gL(paramInt);
    int i = parame.Ad();
    return paramInt + (i + gR(i));
  }
  
  private void bI(int paramInt1, int paramInt2)
  {
    hT(g.bT(paramInt1, paramInt2));
  }
  
  public static int bM(int paramInt1, int paramInt2)
  {
    return gL(paramInt1) + gM(paramInt2);
  }
  
  public static int bN(int paramInt1, int paramInt2)
  {
    return gL(paramInt1) + gR(paramInt2);
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return gL(paramInt) + (gR(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int cv(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = gR(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int g(int paramInt, String paramString)
  {
    return gL(paramInt) + cv(paramString);
  }
  
  private static int gL(int paramInt)
  {
    return gR(g.bT(paramInt, 0));
  }
  
  public static int gM(int paramInt)
  {
    if (paramInt >= 0) {
      return gR(paramInt);
    }
    return 10;
  }
  
  public static int gR(int paramInt)
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
  
  private void hS(int paramInt)
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
  
  private void hT(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        hS(paramInt);
        return;
      }
      hS(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return gL(paramInt) + aO(paramLong);
  }
  
  public static int q(int paramInt, long paramLong)
  {
    return gL(paramInt) + aO(paramLong);
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
    bI(paramInt, 2);
    hT(parame.JF());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    bI(paramInt, 2);
    hT(paramArrayOfByte.length);
    s(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void bJ(int paramInt1, int paramInt2)
  {
    bI(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      hT(paramInt2);
      return;
    }
    aN(paramInt2);
  }
  
  public final void bK(int paramInt1, int paramInt2)
  {
    bI(paramInt1, 0);
    hT(paramInt2);
  }
  
  public final void f(int paramInt, String paramString)
  {
    bI(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    hT(paramString.length);
    s(paramString, paramString.length);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    bI(paramInt, 0);
    aN(paramLong);
  }
  
  public final void r(int paramInt, long paramLong)
  {
    bI(paramInt, 0);
    aN(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.a.b
 * JD-Core Version:    0.7.0.1
 */