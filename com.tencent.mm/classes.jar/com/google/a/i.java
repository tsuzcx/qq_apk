package com.google.a;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class i
  extends f
{
  static final boolean bNy = ch.HS();
  private static final Logger logger = Logger.getLogger(i.class.getName());
  
  public static i C(byte[] paramArrayOfByte)
  {
    return new i.a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int D(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return i + fU(i);
  }
  
  public static int a(int paramInt, ai paramai)
  {
    int i = fS(1);
    paramInt = fO(paramInt);
    int j = fS(3);
    int k = paramai.yC();
    return i * 2 + paramInt + (j + (k + fU(k)));
  }
  
  public static int a(ai paramai)
  {
    int i = paramai.yC();
    return i + fU(i);
  }
  
  public static int aA(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
    {
      j = 1;
      return j;
    }
    if (paramLong < 0L) {
      return 10;
    }
    int j = 2;
    if ((0x0 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
    }
    for (;;)
    {
      int i = j;
      long l = paramLong;
      if ((0xFFE00000 & paramLong) != 0L)
      {
        i = j + 2;
        l = paramLong >>> 14;
      }
      j = i;
      if ((l & 0xFFFFC000) == 0L) {
        break;
      }
      return i + 1;
    }
  }
  
  public static int aB(long paramLong)
  {
    return aA(aC(paramLong));
  }
  
  private static long aC(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int ay(long paramLong)
  {
    return fS(5) + aA(paramLong);
  }
  
  public static int az(long paramLong)
  {
    return aA(paramLong);
  }
  
  public static int b(g paramg)
  {
    int i = paramg.size();
    return i + fU(i);
  }
  
  public static int bu(int paramInt1, int paramInt2)
  {
    return fS(paramInt1) + fT(paramInt2);
  }
  
  public static int bv(int paramInt1, int paramInt2)
  {
    return fS(paramInt1) + fT(paramInt2);
  }
  
  public static int c(int paramInt, aw paramaw)
  {
    return fS(paramInt) + d(paramaw);
  }
  
  public static int c(int paramInt, g paramg)
  {
    paramInt = fS(paramInt);
    int i = paramg.size();
    return paramInt + (i + fU(i));
  }
  
  public static int cb(String paramString)
  {
    try
    {
      i = ci.v(paramString);
      return i + fU(i);
    }
    catch (ci.d locald)
    {
      for (;;)
      {
        int i = paramString.getBytes(ae.UTF_8).length;
      }
    }
  }
  
  public static int d(int paramInt, aw paramaw)
  {
    return fS(1) * 2 + fO(paramInt) + c(3, paramaw);
  }
  
  public static int d(int paramInt, g paramg)
  {
    return fS(1) * 2 + fO(paramInt) + c(3, paramg);
  }
  
  public static int d(aw paramaw)
  {
    int i = paramaw.yC();
    return i + fU(i);
  }
  
  @Deprecated
  public static int e(aw paramaw)
  {
    return paramaw.yC();
  }
  
  @Deprecated
  public static int f(int paramInt, aw paramaw)
  {
    return fS(paramInt) * 2 + paramaw.yC();
  }
  
  public static int f(int paramInt, String paramString)
  {
    return fS(paramInt) + cb(paramString);
  }
  
  private static int fO(int paramInt)
  {
    return fS(2) + fU(paramInt);
  }
  
  public static int fP(int paramInt)
  {
    return fS(paramInt) + 4;
  }
  
  public static int fQ(int paramInt)
  {
    return fS(paramInt) + 8;
  }
  
  public static int fR(int paramInt)
  {
    return fS(paramInt) + 1;
  }
  
  public static int fS(int paramInt)
  {
    return fU(cj.bA(paramInt, 0));
  }
  
  public static int fT(int paramInt)
  {
    if (paramInt >= 0) {
      return fU(paramInt);
    }
    return 10;
  }
  
  public static int fU(int paramInt)
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
  
  public static int fV(int paramInt)
  {
    return fU(fX(paramInt));
  }
  
  public static int fW(int paramInt)
  {
    return fT(paramInt);
  }
  
  private static int fX(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  @Deprecated
  public static int fY(int paramInt)
  {
    return fU(paramInt);
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return fS(paramInt) + aA(paramLong);
  }
  
  public static int zr()
  {
    return fS(6) + 8;
  }
  
  public static int zs()
  {
    return 4;
  }
  
  public static int zt()
  {
    return 4;
  }
  
  public static int zu()
  {
    return 8;
  }
  
  public static int zv()
  {
    return 8;
  }
  
  public static int zw()
  {
    return 4;
  }
  
  public static int zx()
  {
    return 8;
  }
  
  public static int zy()
  {
    return 1;
  }
  
  public abstract void a(int paramInt, aw paramaw);
  
  public abstract void a(int paramInt, g paramg);
  
  public abstract void a(g paramg);
  
  final void a(String paramString, ci.d paramd)
  {
    logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramd);
    paramString = paramString.getBytes(ae.UTF_8);
    try
    {
      fL(paramString.length);
      o(paramString, 0, paramString.length);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new i.b(paramString);
    }
    catch (i.b paramString)
    {
      throw paramString;
    }
  }
  
  public final void ad(float paramFloat)
  {
    fN(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void av(long paramLong);
  
  public final void aw(long paramLong)
  {
    av(aC(paramLong));
  }
  
  public abstract void ax(long paramLong);
  
  public abstract void b(int paramInt, aw paramaw);
  
  public abstract void b(int paramInt, g paramg);
  
  public final void be(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      d((byte)i);
      return;
    }
  }
  
  public abstract void br(int paramInt1, int paramInt2);
  
  public abstract void bs(int paramInt1, int paramInt2);
  
  public abstract void bt(int paramInt1, int paramInt2);
  
  public abstract void c(aw paramaw);
  
  public abstract void ca(String paramString);
  
  public abstract void d(byte paramByte);
  
  @Deprecated
  public final void e(int paramInt, aw paramaw)
  {
    br(paramInt, 3);
    paramaw.a(this);
    br(paramInt, 4);
  }
  
  public abstract void e(int paramInt, String paramString);
  
  public final void f(double paramDouble)
  {
    ax(Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void fK(int paramInt);
  
  public abstract void fL(int paramInt);
  
  public final void fM(int paramInt)
  {
    fL(fX(paramInt));
  }
  
  public abstract void fN(int paramInt);
  
  public abstract void n(int paramInt, long paramLong);
  
  public abstract void o(int paramInt, long paramLong);
  
  public abstract void o(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void r(int paramInt, boolean paramBoolean);
  
  abstract void r(byte[] paramArrayOfByte, int paramInt);
  
  public final void zA()
  {
    if (zz() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public abstract int zz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.i
 * JD-Core Version:    0.7.0.1
 */