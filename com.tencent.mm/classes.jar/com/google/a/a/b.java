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
  
  public static int aI(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = dS(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int aN(int paramInt1, int paramInt2)
  {
    return dQ(paramInt1) + dO(paramInt2);
  }
  
  public static int aO(int paramInt1, int paramInt2)
  {
    return dQ(paramInt1) + dS(paramInt2);
  }
  
  private void aP(int paramInt1, int paramInt2)
  {
    dR(g.aQ(paramInt1, paramInt2));
  }
  
  private void ab(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        dP((int)paramLong);
        return;
      }
      dP((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int ac(long paramLong)
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
    paramInt = dQ(paramInt);
    int i = parame.oP();
    return paramInt + (i + dS(i));
  }
  
  public static int c(int paramInt, byte[] paramArrayOfByte)
  {
    return dQ(paramInt) + (dS(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int dO(int paramInt)
  {
    if (paramInt >= 0) {
      return dS(paramInt);
    }
    return 10;
  }
  
  private void dP(int paramInt)
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
  
  private static int dQ(int paramInt)
  {
    return dS(g.aQ(paramInt, 0));
  }
  
  private void dR(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        dP(paramInt);
        return;
      }
      dP(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int dS(int paramInt)
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
  
  public static int e(int paramInt, String paramString)
  {
    return dQ(paramInt) + aI(paramString);
  }
  
  public static int j(int paramInt, long paramLong)
  {
    return dQ(paramInt) + ac(paramLong);
  }
  
  private void j(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (this.limit - this.position >= i)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      this.position = (i + this.position);
      return;
    }
    throw new a(this.position, this.limit);
  }
  
  public static int k(int paramInt, long paramLong)
  {
    return dQ(paramInt) + ac(paramLong);
  }
  
  public final void a(int paramInt, e parame)
  {
    aP(paramInt, 2);
    if (parame.aUI < 0) {
      parame.oP();
    }
    dR(parame.aUI);
    parame.a(this);
  }
  
  public final void aL(int paramInt1, int paramInt2)
  {
    aP(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      dR(paramInt2);
      return;
    }
    ab(paramInt2);
  }
  
  public final void aM(int paramInt1, int paramInt2)
  {
    aP(paramInt1, 0);
    dR(paramInt2);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte)
  {
    aP(paramInt, 2);
    dR(paramArrayOfByte.length);
    j(paramArrayOfByte);
  }
  
  public final void d(int paramInt, String paramString)
  {
    aP(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    dR(paramString.length);
    j(paramString);
  }
  
  public final void h(int paramInt, long paramLong)
  {
    aP(paramInt, 0);
    ab(paramLong);
  }
  
  public final void i(int paramInt, long paramLong)
  {
    aP(paramInt, 0);
    ab(paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.a.a.b
 * JD-Core Version:    0.7.0.1
 */