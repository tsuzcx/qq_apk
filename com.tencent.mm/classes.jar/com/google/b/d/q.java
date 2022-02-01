package com.google.b.d;

import com.google.b.d;

public abstract class q
  extends n
{
  static final int[] cet;
  static final int[] cev = { 1, 1, 1 };
  static final int[] cew = { 1, 1, 1, 1, 1 };
  static final int[][] cex;
  static final int[][] cey;
  
  static
  {
    cet = new int[] { 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt1 = { 1, 2, 3, 1 };
    int[] arrayOfInt2 = { 1, 1, 1, 4 };
    int[] arrayOfInt3 = { 1, 2, 1, 3 };
    cex = new int[][] { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, arrayOfInt1, arrayOfInt2, { 1, 3, 1, 2 }, arrayOfInt3, { 3, 1, 1, 2 } };
    cey = new int[20][];
    System.arraycopy(cex, 0, cey, 0, 10);
    int i = 10;
    while (i < 20)
    {
      arrayOfInt1 = cex[(i - 10)];
      arrayOfInt2 = new int[arrayOfInt1.length];
      int j = 0;
      while (j < arrayOfInt1.length)
      {
        arrayOfInt2[j] = arrayOfInt1[(arrayOfInt1.length - j - 1)];
        j += 1;
      }
      cey[i] = arrayOfInt2;
      i += 1;
    }
  }
  
  static boolean x(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    if (k == 0) {}
    int j;
    do
    {
      return false;
      int i = k - 2;
      j = 0;
      while (i >= 0)
      {
        int m = paramCharSequence.charAt(i) - '0';
        if ((m < 0) || (m > 9)) {
          throw d.Ih();
        }
        j += m;
        i -= 2;
      }
      j *= 3;
      i = k - 1;
      while (i >= 0)
      {
        k = paramCharSequence.charAt(i) - '0';
        if ((k < 0) || (k > 9)) {
          throw d.Ih();
        }
        j += k;
        i -= 2;
      }
    } while (j % 10 != 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.d.q
 * JD-Core Version:    0.7.0.1
 */