package com.google.android.gms.internal;

public final class zzbxw
{
  static final int zzcuK = zzO(1, 3);
  static final int zzcuL = zzO(1, 4);
  static final int zzcuM = zzO(2, 0);
  static final int zzcuN = zzO(3, 2);
  public static final int[] zzcuO = new int[0];
  public static final long[] zzcuP = new long[0];
  public static final float[] zzcuQ = new float[0];
  public static final double[] zzcuR = new double[0];
  public static final boolean[] zzcuS = new boolean[0];
  public static final String[] zzcuT = new String[0];
  public static final byte[][] zzcuU = new byte[0][];
  public static final byte[] zzcuV = new byte[0];
  
  public static int zzO(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static final int zzb(zzbxl paramzzbxl, int paramInt)
  {
    int i = 1;
    int j = paramzzbxl.getPosition();
    paramzzbxl.zzqX(paramInt);
    while (paramzzbxl.zzaen() == paramInt)
    {
      paramzzbxl.zzqX(paramInt);
      i += 1;
    }
    paramzzbxl.zzrb(j);
    return i;
  }
  
  static int zzrq(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int zzrr(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxw
 * JD-Core Version:    0.7.0.1
 */