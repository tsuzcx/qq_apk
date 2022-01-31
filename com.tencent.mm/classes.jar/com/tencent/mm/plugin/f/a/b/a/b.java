package com.tencent.mm.plugin.f.a.b.a;

import com.tencent.mm.plugin.f.a.b.h;
import com.tencent.mm.sdk.platformtools.y;

public class b
  extends a
{
  static final String TAG = b.class.getName();
  public static String hVA = h.hVu;
  public static String hVy = h.hVs;
  public static String hVz = h.hVt;
  private final int hVB = 1;
  private final int hVC = 2;
  private final int hVD = 4;
  private final int hVE = 8;
  private final int hVF = 16;
  b.b hVG = null;
  b.a hVH;
  int hVI;
  
  public b()
  {
    this.hVw = null;
    this.hVx = 2;
    this.hUQ = 8L;
  }
  
  static double J(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00;
    int j = (i >> 12) - 16;
    int k = i & 0xF00;
    paramInt = (paramArrayOfByte[paramInt] & 0xFF) + (0xFF00 & k);
    double d1 = paramInt;
    double d2 = Math.pow(10.0D, j);
    y.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    return d1 * d2;
  }
  
  public final byte[] awy()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */