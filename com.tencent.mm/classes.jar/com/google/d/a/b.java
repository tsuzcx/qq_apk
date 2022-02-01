package com.google.d.a;

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
  
  public static int b(int paramInt, e parame)
  {
    paramInt = ko(paramInt);
    int i = parame.getSerializedSize();
    return paramInt + (i + kv(i));
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return ko(paramInt) + (kv(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  private void cE(int paramInt1, int paramInt2)
  {
    lI(g.cU(paramInt1, paramInt2));
  }
  
  public static int cJ(int paramInt1, int paramInt2)
  {
    return ko(paramInt1) + kp(paramInt2);
  }
  
  public static int cK(int paramInt1, int paramInt2)
  {
    return ko(paramInt1) + kv(paramInt2);
  }
  
  public static int dU(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = kv(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  private void dg(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        lH((int)paramLong);
        return;
      }
      lH((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int dh(long paramLong)
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
  
  public static int h(int paramInt, String paramString)
  {
    return ko(paramInt) + dU(paramString);
  }
  
  private static int ko(int paramInt)
  {
    return kv(g.cU(paramInt, 0));
  }
  
  public static int kp(int paramInt)
  {
    if (paramInt >= 0) {
      return kv(paramInt);
    }
    return 10;
  }
  
  public static int kv(int paramInt)
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
  
  private void lH(int paramInt)
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
  
  private void lI(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        lH(paramInt);
        return;
      }
      lH(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int q(int paramInt, long paramLong)
  {
    return ko(paramInt) + dh(paramLong);
  }
  
  public static int r(int paramInt, long paramLong)
  {
    return ko(paramInt) + dh(paramLong);
  }
  
  private void r(byte[] paramArrayOfByte, int paramInt)
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
    cE(paramInt, 2);
    lI(parame.akb());
    parame.a(this);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    cE(paramInt, 2);
    lI(paramArrayOfByte.length);
    r(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    cE(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      lI(paramInt2);
      return;
    }
    dg(paramInt2);
  }
  
  public final void cG(int paramInt1, int paramInt2)
  {
    cE(paramInt1, 0);
    lI(paramInt2);
  }
  
  public final void g(int paramInt, String paramString)
  {
    cE(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    lI(paramString.length);
    r(paramString, paramString.length);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    cE(paramInt, 0);
    dg(paramLong);
  }
  
  public final void t(int paramInt, long paramLong)
  {
    cE(paramInt, 0);
    dg(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.d.a.b
 * JD-Core Version:    0.7.0.1
 */