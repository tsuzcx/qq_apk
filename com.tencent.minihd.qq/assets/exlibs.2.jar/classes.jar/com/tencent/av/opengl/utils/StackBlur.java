package com.tencent.av.opengl.utils;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class StackBlur
{
  public static void fastBlur(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt < 1) {
      return;
    }
    int i10 = paramBitmap.getWidth();
    int i11 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i10 * i11];
    paramBitmap.getPixels(arrayOfInt1, 0, i10, 0, 0, i10, i11);
    int i15 = i10 - 1;
    int i12 = i11 - 1;
    int i = i10 * i11;
    int i13 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i10, i11)];
    i = i13 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int i7 = 0;
    int i5 = 0;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i13, 3 });
    int i14 = paramInt + 1;
    int i6 = 0;
    int i1;
    int i3;
    int i4;
    int n;
    int i2;
    int k;
    int m;
    int i8;
    int i9;
    int[] arrayOfInt7;
    int i17;
    int i16;
    while (i6 < i11)
    {
      i1 = 0;
      i3 = 0;
      i4 = 0;
      j = 0;
      n = 0;
      i2 = 0;
      i = 0;
      k = 0;
      m = 0;
      i8 = -paramInt;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i15, Math.max(i8, 0)) + i7)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i14 - Math.abs(i8);
        i4 += arrayOfInt7[0] * i9;
        i3 += arrayOfInt7[1] * i9;
        i1 += arrayOfInt7[2] * i9;
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          i += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          n += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
      }
      i9 = paramInt;
      i8 = 0;
      while (i8 < i10)
      {
        arrayOfInt2[i7] = arrayOfInt6[i4];
        arrayOfInt3[i7] = arrayOfInt6[i3];
        arrayOfInt4[i7] = arrayOfInt6[i1];
        arrayOfInt7 = arrayOfInt[((i9 - paramInt + i13) % i13)];
        int i18 = arrayOfInt7[0];
        i17 = arrayOfInt7[1];
        i16 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[i8] = Math.min(i8 + paramInt + 1, i15);
        }
        int i19 = arrayOfInt1[(arrayOfInt5[i8] + i5)];
        arrayOfInt7[0] = ((0xFF0000 & i19) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i19) >> 8);
        arrayOfInt7[2] = (i19 & 0xFF);
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        i += arrayOfInt7[2];
        i4 = i4 - i2 + m;
        i3 = i3 - n + k;
        i1 = i1 - j + i;
        i9 = (i9 + 1) % i13;
        arrayOfInt7 = arrayOfInt[(i9 % i13)];
        i2 = i2 - i18 + arrayOfInt7[0];
        n = n - i17 + arrayOfInt7[1];
        j = j - i16 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        i -= arrayOfInt7[2];
        i7 += 1;
        i8 += 1;
      }
      i5 += i10;
      i6 += 1;
    }
    i = 0;
    while (i < i10)
    {
      i2 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      i1 = 0;
      i3 = 0;
      j = 0;
      m = 0;
      n = 0;
      i6 = -paramInt * i10;
      i7 = -paramInt;
      if (i7 <= paramInt)
      {
        i8 = Math.max(0, i6) + i;
        arrayOfInt7 = arrayOfInt[(i7 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i8];
        arrayOfInt7[1] = arrayOfInt3[i8];
        arrayOfInt7[2] = arrayOfInt4[i8];
        i9 = i14 - Math.abs(i7);
        i5 += arrayOfInt2[i8] * i9;
        i4 += arrayOfInt3[i8] * i9;
        i2 += arrayOfInt4[i8] * i9;
        if (i7 > 0)
        {
          n += arrayOfInt7[0];
          m += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 = i6;
          if (i7 < i12) {
            i8 = i6 + i10;
          }
          i7 += 1;
          i6 = i8;
          break;
          i3 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
      }
      i7 = i;
      i8 = paramInt;
      i6 = 0;
      while (i6 < i11)
      {
        arrayOfInt1[i7] = (0xFF000000 | arrayOfInt6[i5] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i2]);
        arrayOfInt7 = arrayOfInt[((i8 - paramInt + i13) % i13)];
        i16 = arrayOfInt7[0];
        i15 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i6] = (Math.min(i6 + i14, i12) * i10);
        }
        i17 = i + arrayOfInt5[i6];
        arrayOfInt7[0] = arrayOfInt2[i17];
        arrayOfInt7[1] = arrayOfInt3[i17];
        arrayOfInt7[2] = arrayOfInt4[i17];
        n += arrayOfInt7[0];
        m += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i5 = i5 - i3 + n;
        i4 = i4 - i1 + m;
        i2 = i2 - k + j;
        i8 = (i8 + 1) % i13;
        arrayOfInt7 = arrayOfInt[i8];
        i3 = i3 - i16 + arrayOfInt7[0];
        i1 = i1 - i15 + arrayOfInt7[1];
        k = k - i9 + arrayOfInt7[2];
        n -= arrayOfInt7[0];
        m -= arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i7 += i10;
        i6 += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i10, 0, 0, i10, i11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.utils.StackBlur
 * JD-Core Version:    0.7.0.1
 */