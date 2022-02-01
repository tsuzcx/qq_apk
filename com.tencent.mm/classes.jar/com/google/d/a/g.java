package com.google.d.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] dTZ = new int[0];
  public static final byte[][] dXA = new byte[0][];
  public static final byte[] dXB = new byte[0];
  public static final long[] dXw = new long[0];
  public static final float[] dXx = new float[0];
  public static final double[] dXy = new double[0];
  public static final boolean[] dXz = new boolean[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.jN(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.jN(paramInt);
    while (parama.aac() == paramInt)
    {
      parama.jN(paramInt);
      i += 1;
    }
    parama.lF(j);
    return i;
  }
  
  static int cU(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int lD(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int lE(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.d.a.g
 * JD-Core Version:    0.7.0.1
 */