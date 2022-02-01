package com.google.c.d;

import com.google.c.d;

public abstract class q
  extends n
{
  static final int[] bTU;
  static final int[] bTW = { 1, 1, 1 };
  static final int[] bTX = { 1, 1, 1, 1, 1 };
  static final int[][] bTY;
  static final int[][] bTZ;
  
  static
  {
    bTU = new int[] { 1, 1, 1, 1, 1, 1 };
    bTY = new int[][] { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
    bTZ = new int[20][];
    System.arraycopy(bTY, 0, bTZ, 0, 10);
    int i = 10;
    while (i < 20)
    {
      int[] arrayOfInt1 = bTY[(i - 10)];
      int[] arrayOfInt2 = new int[arrayOfInt1.length];
      int j = 0;
      while (j < arrayOfInt1.length)
      {
        arrayOfInt2[j] = arrayOfInt1[(arrayOfInt1.length - j - 1)];
        j += 1;
      }
      bTZ[i] = arrayOfInt2;
      i += 1;
    }
  }
  
  static boolean u(CharSequence paramCharSequence)
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
          throw d.zr();
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
          throw d.zr();
        }
        j += k;
        i -= 2;
      }
    } while (j % 10 != 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.d.q
 * JD-Core Version:    0.7.0.1
 */