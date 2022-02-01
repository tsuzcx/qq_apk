package com.google.a.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bYn = new int[0];
  public static final long[] cbp = new long[0];
  public static final float[] cbq = new float[0];
  public static final double[] cbr = new double[0];
  public static final boolean[] cbs = new boolean[0];
  public static final byte[][] cbt = new byte[0][];
  public static final byte[] cbu = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.fG(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.fG(paramInt);
    while (parama.yT() == paramInt)
    {
      parama.fG(paramInt);
      i += 1;
    }
    parama.gZ(j);
    return i;
  }
  
  static int bA(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int gX(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int gY(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.a.g
 * JD-Core Version:    0.7.0.1
 */