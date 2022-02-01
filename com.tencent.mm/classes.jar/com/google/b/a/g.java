package com.google.b.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bQP = new int[0];
  public static final long[] bQQ = new long[0];
  public static final float[] bQR = new float[0];
  public static final double[] bQS = new double[0];
  public static final boolean[] bQT = new boolean[0];
  public static final byte[][] bQU = new byte[0][];
  public static final byte[] bQV = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.fF(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.fF(paramInt);
    while (parama.zb() == paramInt)
    {
      parama.fF(paramInt);
      i += 1;
    }
    parama.fI(j);
    return i;
  }
  
  static int bC(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int fQ(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int fR(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.a.g
 * JD-Core Version:    0.7.0.1
 */