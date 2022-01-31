package com.google.a.a;

public final class g
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bgZ = new int[0];
  public static final long[] bha = new long[0];
  public static final float[] bhb = new float[0];
  public static final double[] bhc = new double[0];
  public static final boolean[] bhd = new boolean[0];
  public static final byte[][] bhe = new byte[0][];
  public static final byte[] bhf = new byte[0];
  
  public static boolean a(a parama, int paramInt)
  {
    return parama.eO(paramInt);
  }
  
  public static final int b(a parama, int paramInt)
  {
    int i = 1;
    int j = parama.getPosition();
    parama.eO(paramInt);
    while (parama.sk() == paramInt)
    {
      parama.eO(paramInt);
      i += 1;
    }
    parama.eR(j);
    return i;
  }
  
  static int bo(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static int eZ(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int fa(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.a.g
 * JD-Core Version:    0.7.0.1
 */