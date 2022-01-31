package com.google.a.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] aUJ = new int[0];
  public static final long[] aUK = new long[0];
  public static final float[] aUL = new float[0];
  public static final double[] aUM = new double[0];
  public static final boolean[] aUN = new boolean[0];
  public static final byte[][] aUO = new byte[0][];
  public static final byte[] aUP = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.dI(paramInt);
  }
  
  static int aQ(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.dI(paramInt);
    while (parama.oC() == paramInt)
    {
      parama.dI(paramInt);
      i += 1;
    }
    parama.dL(j);
    return i;
  }
  
  static int dT(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int dU(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.a.g
 * JD-Core Version:    0.7.0.1
 */