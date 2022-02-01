package com.google.b.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bIT = new int[0];
  public static final long[] bIU = new long[0];
  public static final float[] bIV = new float[0];
  public static final double[] bIW = new double[0];
  public static final boolean[] bIX = new boolean[0];
  public static final byte[][] bIY = new byte[0][];
  public static final byte[] bIZ = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.fQ(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.fQ(paramInt);
    while (parama.xR() == paramInt)
    {
      parama.fQ(paramInt);
      i += 1;
    }
    parama.fT(j);
    return i;
  }
  
  static int bD(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int gb(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int gc(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.g
 * JD-Core Version:    0.7.0.1
 */