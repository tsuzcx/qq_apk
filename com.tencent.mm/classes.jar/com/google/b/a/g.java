package com.google.b.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bZR = new int[0];
  public static final long[] ccS = new long[0];
  public static final float[] ccT = new float[0];
  public static final double[] ccU = new double[0];
  public static final boolean[] ccV = new boolean[0];
  public static final byte[][] ccW = new byte[0][];
  public static final byte[] ccX = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.gz(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.gz(paramInt);
    while (parama.Av() == paramInt)
    {
      parama.gz(paramInt);
      i += 1;
    }
    parama.hQ(j);
    return i;
  }
  
  static int bT(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int hO(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int hP(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.a.g
 * JD-Core Version:    0.7.0.1
 */