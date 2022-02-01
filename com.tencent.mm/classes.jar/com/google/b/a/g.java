package com.google.b.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bGB = new int[0];
  public static final long[] bGC = new long[0];
  public static final float[] bGD = new float[0];
  public static final double[] bGE = new double[0];
  public static final boolean[] bGF = new boolean[0];
  public static final byte[][] bGG = new byte[0][];
  public static final byte[] bGH = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.fC(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.fC(paramInt);
    while (parama.xE() == paramInt)
    {
      parama.fC(paramInt);
      i += 1;
    }
    parama.fF(j);
    return i;
  }
  
  static int bA(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int fN(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int fO(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.g
 * JD-Core Version:    0.7.0.1
 */