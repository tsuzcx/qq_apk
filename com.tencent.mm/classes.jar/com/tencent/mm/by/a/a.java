package com.tencent.mm.by.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;

public final class a
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int i = paramBitmap.getWidth();
    int k = BackwardSupportUtil.b.b(paramContext, 197.0F);
    int j = k;
    if (k < i) {
      j = i;
    }
    k = (int)(paramArrayOfInt[0] * 0.1D);
    j /= (paramArrayOfInt[0] + k * 2);
    if (j == 0) {
      j = 1;
    }
    for (;;)
    {
      int i5 = k * j;
      int m = j * (paramArrayOfInt[0] + k * 2);
      int n = paramArrayOfInt[1] * j + k * (j * 2);
      k = m;
      if (m < i) {
        k = i;
      }
      m = n;
      if (n < i) {
        m = i;
      }
      paramContext = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      int[] arrayOfInt = new int[k * m];
      n = (k - i) / 2;
      int i2 = 0;
      int i1 = n;
      while ((i1 < k - n) && (i2 < i))
      {
        int i3 = 0;
        int i4 = n;
        while ((i4 < m - n) && (i3 < i))
        {
          arrayOfInt[(i1 * k + i4)] = paramBitmap.getPixel(i3, i2);
          i4 += 1;
          i3 += 1;
        }
        i2 += 1;
        i1 += 1;
      }
      i = 0;
      while (i < paramArrayOfInt[1])
      {
        n = 0;
        while (n < paramArrayOfInt[0])
        {
          if (paramArrayOfByte[(paramArrayOfInt[0] * i + n)] == 1)
          {
            i1 = 0;
            while (i1 < j)
            {
              i2 = 0;
              while (i2 < j)
              {
                if (arrayOfInt[((i * j + i5 + i1) * k + n * j + i5 + i2)] == 0) {
                  arrayOfInt[((i * j + i5 + i1) * k + n * j + i5 + i2)] = -16777216;
                }
                i2 += 1;
              }
              i1 += 1;
            }
          }
          i1 = 0;
          while (i1 < j)
          {
            i2 = 0;
            while (i2 < j)
            {
              if (arrayOfInt[((i * j + i5 + i1) * k + n * j + i5 + i2)] == 0) {
                arrayOfInt[((i * j + i5 + i1) * k + n * j + i5 + i2)] = -1;
              }
              i2 += 1;
            }
            i1 += 1;
          }
          n += 1;
        }
        i += 1;
      }
      paramContext.setPixels(arrayOfInt, 0, k, 0, 0, k, m);
      return paramContext;
    }
  }
  
  public static Bitmap b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[40000];
    int[] arrayOfInt = new int[2];
    int n = QbarNative.a(arrayOfByte, arrayOfInt, paramString, paramInt1, paramInt2, "UTF-8");
    QbarNative.nativeRelease();
    int i;
    int j;
    if (n == 0)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramInt2 = paramContext.widthPixels;
      i = paramContext.heightPixels;
      if (paramInt2 < i)
      {
        paramInt2 = (int)(paramInt2 * 0.8D);
        j = (int)(arrayOfInt[0] * 0.1D);
        if (paramInt1 != 12) {
          break label273;
        }
        paramInt2 /= (arrayOfInt[0] + j * 2);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
        i = paramInt1;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      label113:
      int i1 = j * paramInt2;
      int i2 = paramInt2 * (arrayOfInt[0] + j * 2);
      int i3 = arrayOfInt[1] * paramInt1 + j * (paramInt2 * 2);
      paramContext = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
      paramString = new int[i2 * i3];
      Arrays.fill(paramString, -1);
      i = 0;
      for (;;)
      {
        if (i >= arrayOfInt[1]) {
          break label409;
        }
        j = 0;
        for (;;)
        {
          if (j >= arrayOfInt[0]) {
            break label400;
          }
          int m;
          if (arrayOfByte[(arrayOfInt[0] * i + j)] == 1)
          {
            k = 0;
            for (;;)
            {
              if (k >= paramInt1) {
                break label391;
              }
              m = 0;
              for (;;)
              {
                if (m < paramInt2)
                {
                  paramString[((i * paramInt1 + i1 + k) * i2 + j * paramInt2 + i1 + m)] = -16777216;
                  m += 1;
                  continue;
                  paramInt2 = i;
                  break;
                  label273:
                  if (paramInt1 != 5) {
                    break label505;
                  }
                  paramInt2 /= (arrayOfInt[0] + j * 2);
                  paramInt1 = paramInt2;
                  if (paramInt2 == 0) {
                    paramInt1 = 1;
                  }
                  i = arrayOfInt[0] * paramInt1 / arrayOfInt[1];
                  paramInt2 = paramInt1;
                  paramInt1 = i;
                  break label113;
                }
              }
              k += 1;
            }
          }
          int k = 0;
          while (k < paramInt1)
          {
            m = 0;
            while (m < paramInt2)
            {
              paramString[((i * paramInt1 + i1 + k) * i2 + j * paramInt2 + i1 + m)] = -1;
              m += 1;
            }
            k += 1;
          }
          label391:
          j += 1;
        }
        label400:
        i += 1;
      }
      label409:
      paramContext.setPixels(paramString, 0, i2, 0, 0, i2, i3);
      if (paramContext == null) {
        y.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(n), bk.csb().toString() });
      }
      for (;;)
      {
        return paramContext;
        y.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
      }
      y.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(n), bk.csb().toString() });
      return null;
      label505:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.by.a.a
 * JD-Core Version:    0.7.0.1
 */