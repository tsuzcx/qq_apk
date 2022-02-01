package com.tencent.mm.by.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.qbar.f;
import java.util.Arrays;

public final class a
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, byte[] paramArrayOfByte, int[] paramArrayOfInt, double paramDouble)
  {
    AppMethodBeat.i(168779);
    int i = paramBitmap.getWidth();
    int k = BackwardSupportUtil.b.g(paramContext, 197.0F);
    int j = k;
    if (k < i) {
      j = i;
    }
    k = (int)(paramArrayOfInt[0] * paramDouble);
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
      AppMethodBeat.o(168779);
      return paramContext;
    }
  }
  
  public static Bitmap a(Context paramContext, String paramString, int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(91134);
    byte[] arrayOfByte = new byte[40000];
    int[] arrayOfInt = new int[2];
    paramInt2 = f.a(arrayOfByte, arrayOfInt, paramString, paramInt1, paramInt2, "UTF-8");
    if (paramInt2 == 0)
    {
      paramContext = a(paramContext, arrayOfByte, arrayOfInt, paramInt1, paramDouble);
      if (paramContext == null) {
        ac.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(paramInt2), bs.eWi().toString() });
      }
      for (;;)
      {
        AppMethodBeat.o(91134);
        return paramContext;
        ac.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
      }
    }
    ac.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(paramInt2), bs.eWi().toString() });
    AppMethodBeat.o(91134);
    return null;
  }
  
  private static Bitmap a(Context paramContext, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91137);
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = paramContext.widthPixels;
    int j = paramContext.heightPixels;
    int i1;
    if (i < j)
    {
      i = (int)(i * 0.8D);
      i1 = (int)(paramArrayOfInt[0] * 0.1D);
      i /= (paramArrayOfInt[0] + i1 * 2);
      if (i != 0) {
        break label1675;
      }
      i = 1;
    }
    label1675:
    for (;;)
    {
      int i4 = i1 * i;
      int i5 = i * (paramArrayOfInt[0] + i1 * 2);
      int i6 = paramArrayOfInt[1] * i + i * 2 * i1;
      paramContext = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
      int[] arrayOfInt2 = new int[i5 * i6];
      int i2 = i / 2;
      int i3 = i / 2;
      Canvas localCanvas = new Canvas(paramContext);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Arrays.fill(arrayOfInt2, -1);
      int[] arrayOfInt1 = new int[6];
      arrayOfInt1[0] = (i * 3 + i / 2);
      arrayOfInt1[1] = (i * 3 + i / 2);
      arrayOfInt1[2] = ((paramArrayOfInt[0] - 1 - 3) * i + i / 2);
      arrayOfInt1[3] = (i * 3 + i / 2);
      arrayOfInt1[4] = (i * 3 + i / 2);
      arrayOfInt1[5] = ((paramArrayOfInt[1] - 1 - 3) * i + i / 2);
      j = 0;
      int k;
      int m;
      int n;
      for (;;)
      {
        if (j >= paramArrayOfInt[1]) {
          break label594;
        }
        k = 0;
        for (;;)
        {
          if (k >= paramArrayOfInt[0]) {
            break label585;
          }
          if (paramArrayOfByte[(paramArrayOfInt[0] * j + k)] == 1)
          {
            if (((j >= 0) && (j <= 6) && (k >= 0) && (k <= 6)) || ((j >= 0) && (j <= 6) && (k >= paramArrayOfInt[0] - 7) && (k <= paramArrayOfInt[0] - 1)) || ((j >= paramArrayOfInt[1] - 7) && (j <= paramArrayOfInt[1] - 1) && (k >= 0) && (k <= 6))) {
              m = 0;
            }
            for (;;)
            {
              if (m < i)
              {
                n = 0;
                for (;;)
                {
                  if (n < i)
                  {
                    arrayOfInt2[((j * i + i4 + m) * i5 + k * i + i4 + n)] = -1;
                    n += 1;
                    continue;
                    i = j;
                    break;
                  }
                }
                m += 1;
                continue;
                if (eRL())
                {
                  m = 0;
                  while (m < i)
                  {
                    n = 0;
                    while (n < i)
                    {
                      arrayOfInt2[((j * i + i4 + m) * i5 + k * i + i4 + n)] = -3041484;
                      n += 1;
                    }
                    m += 1;
                  }
                }
                m = 0;
                while (m < i)
                {
                  n = 0;
                  while (n < i)
                  {
                    arrayOfInt2[((j * i + i4 + m) * i5 + k * i + i4 + n)] = -2598591;
                    n += 1;
                  }
                  m += 1;
                }
              }
            }
          }
          k += 1;
        }
        label585:
        j += 1;
      }
      label594:
      paramContext.setPixels(arrayOfInt2, 0, i5, 0, 0, i5, i6);
      j = 0;
      while (j < 3)
      {
        localPaint.setColor(-2598591);
        localPaint.setStyle(Paint.Style.FILL);
        localCanvas.drawCircle(i * i1 + arrayOfInt1[(j * 2)], i * i1 + arrayOfInt1[(j * 2 + 1)], i * 3 + i3, localPaint);
        localPaint.setColor(-1);
        localCanvas.drawCircle(i * i1 + arrayOfInt1[(j * 2)], i * i1 + arrayOfInt1[(j * 2 + 1)], i * 2 + i2, localPaint);
        j += 1;
      }
      j = 0;
      while (j < 3)
      {
        localPaint.setColor(-3041484);
        localPaint.setStyle(Paint.Style.FILL);
        k = arrayOfInt1[(j * 2)];
        m = i * 1 / 4;
        n = arrayOfInt1[(j * 2 + 1)];
        i2 = i * 1 / 4;
        i3 = arrayOfInt1[(j * 2)];
        i4 = i * 1 / 4;
        i5 = arrayOfInt1[(j * 2 + 1)];
        i6 = i * 1 / 4;
        localCanvas.drawRect(i * i1 + k - i - m, i * i1 + n - i - i2, i4 + (i * i1 + i3 + i), i6 + (i * i1 + i5 + i), localPaint);
        j += 1;
      }
      j = 0;
      while (j < 3)
      {
        localPaint.setColor(-1);
        localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        paramArrayOfByte = new Path();
        paramArrayOfByte.moveTo(i * i1 + arrayOfInt1[(j * 2)] - i - i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] - i - i * 1 / 4);
        paramArrayOfByte.quadTo(i * i1 + arrayOfInt1[(j * 2)], i * i1 + arrayOfInt1[(j * 2 + 1)] - i, i * i1 + arrayOfInt1[(j * 2)] + i + i / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] - i - i * 1 / 4);
        paramArrayOfByte.lineTo(i * i1 + arrayOfInt1[(j * 2)] - i - i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] - i - i * 1 / 4);
        paramArrayOfByte.close();
        localCanvas.drawPath(paramArrayOfByte, localPaint);
        paramArrayOfByte.moveTo(i * i1 + arrayOfInt1[(j * 2)] - i - i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] - i - i * 1 / 4);
        paramArrayOfByte.quadTo(i * i1 + arrayOfInt1[(j * 2)] - i, i * i1 + arrayOfInt1[(j * 2 + 1)], i * i1 + arrayOfInt1[(j * 2)] - i - i / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] + i + i * 1 / 4);
        paramArrayOfByte.lineTo(i * i1 + arrayOfInt1[(j * 2)] - i - i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] - i - i * 1 / 4);
        paramArrayOfByte.close();
        localCanvas.drawPath(paramArrayOfByte, localPaint);
        paramArrayOfByte.moveTo(i * i1 + arrayOfInt1[(j * 2)] + i + i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] + i + i * 1 / 4);
        paramArrayOfByte.quadTo(i * i1 + arrayOfInt1[(j * 2)], i * i1 + arrayOfInt1[(j * 2 + 1)] + i, i * i1 + arrayOfInt1[(j * 2)] - i - i / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] + i + i * 1 / 4);
        paramArrayOfByte.lineTo(i * i1 + arrayOfInt1[(j * 2)] + i + i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] + i + i * 1 / 4);
        paramArrayOfByte.close();
        localCanvas.drawPath(paramArrayOfByte, localPaint);
        paramArrayOfByte.moveTo(i * i1 + arrayOfInt1[(j * 2)] + i + i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] + i + i * 1 / 4);
        paramArrayOfByte.quadTo(i * i1 + arrayOfInt1[(j * 2)] + i, i * i1 + arrayOfInt1[(j * 2 + 1)], i * i1 + arrayOfInt1[(j * 2)] + i + i / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] - i - i * 1 / 4);
        paramArrayOfByte.lineTo(i * i1 + arrayOfInt1[(j * 2)] + i + i * 1 / 4, i * i1 + arrayOfInt1[(j * 2 + 1)] + i + i * 1 / 4);
        paramArrayOfByte.close();
        localCanvas.drawPath(paramArrayOfByte, localPaint);
        j += 1;
      }
      AppMethodBeat.o(91137);
      return paramContext;
    }
  }
  
  private static Bitmap a(Context paramContext, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(91135);
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = paramContext.widthPixels;
    int j = paramContext.heightPixels;
    int k;
    if (i < j)
    {
      i = (int)(i * 0.8D);
      k = (int)(paramArrayOfInt[0] * paramDouble);
      if (paramInt != 12) {
        break label253;
      }
      i /= (paramArrayOfInt[0] + k * 2);
      paramInt = i;
      if (i == 0) {
        paramInt = 1;
      }
      j = paramInt;
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      label90:
      int i1 = k * i;
      int i2 = i * (paramArrayOfInt[0] + k * 2);
      int i3 = paramArrayOfInt[1] * paramInt + i * 2 * k;
      paramContext = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
      int[] arrayOfInt = new int[i2 * i3];
      Arrays.fill(arrayOfInt, -1);
      j = 0;
      for (;;)
      {
        if (j >= paramArrayOfInt[1]) {
          break label394;
        }
        k = 0;
        for (;;)
        {
          if (k >= paramArrayOfInt[0]) {
            break label385;
          }
          int n;
          if (paramArrayOfByte[(paramArrayOfInt[0] * j + k)] == 1)
          {
            m = 0;
            for (;;)
            {
              if (m >= paramInt) {
                break label376;
              }
              n = 0;
              for (;;)
              {
                if (n < i)
                {
                  arrayOfInt[((j * paramInt + i1 + m) * i2 + k * i + i1 + n)] = -16777216;
                  n += 1;
                  continue;
                  i = j;
                  break;
                  label253:
                  if (paramInt != 5) {
                    break label416;
                  }
                  i /= (paramArrayOfInt[0] + k * 2);
                  paramInt = i;
                  if (i == 0) {
                    paramInt = 1;
                  }
                  j = paramArrayOfInt[0] * paramInt / paramArrayOfInt[1];
                  i = paramInt;
                  paramInt = j;
                  break label90;
                }
              }
              m += 1;
            }
          }
          int m = 0;
          while (m < paramInt)
          {
            n = 0;
            while (n < i)
            {
              arrayOfInt[((j * paramInt + i1 + m) * i2 + k * i + i1 + n)] = -1;
              n += 1;
            }
            m += 1;
          }
          label376:
          k += 1;
        }
        label385:
        j += 1;
      }
      label394:
      paramContext.setPixels(arrayOfInt, 0, i2, 0, 0, i2, i3);
      AppMethodBeat.o(91135);
      return paramContext;
      label416:
      paramInt = 0;
      i = 0;
    }
  }
  
  public static Bitmap b(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(168778);
    byte[] arrayOfByte = new byte[40000];
    int[] arrayOfInt = new int[2];
    int i = f.a(arrayOfByte, arrayOfInt, paramString, 12, 3, "UTF-8");
    if (i == 0)
    {
      paramContext = a(paramContext, paramBitmap, arrayOfByte, arrayOfInt, 0.0D);
      if (paramContext == null) {
        ac.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(i), bs.eWi().toString() });
      }
      for (;;)
      {
        AppMethodBeat.o(168778);
        return paramContext;
        ac.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
      }
    }
    ac.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(i), bs.eWi().toString() });
    AppMethodBeat.o(168778);
    return null;
  }
  
  public static Bitmap b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91133);
    paramContext = a(paramContext, paramString, paramInt1, paramInt2, 0.1D);
    AppMethodBeat.o(91133);
    return paramContext;
  }
  
  public static Bitmap bU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(91136);
    byte[] arrayOfByte = new byte[40000];
    int[] arrayOfInt = new int[2];
    int i = f.a(arrayOfByte, arrayOfInt, paramString, 12, 1, "UTF-8");
    if (i == 0)
    {
      paramContext = a(paramContext, arrayOfByte, arrayOfInt);
      if (paramContext == null) {
        ac.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(i), bs.eWi().toString() });
      }
      for (;;)
      {
        AppMethodBeat.o(91136);
        return paramContext;
        ac.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
      }
    }
    ac.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(i), bs.eWi().toString() });
    AppMethodBeat.o(91136);
    return null;
  }
  
  private static boolean eRL()
  {
    AppMethodBeat.i(91138);
    boolean[] arrayOfBoolean = new boolean[10];
    arrayOfBoolean[5] = true;
    int i = arrayOfBoolean[((int)(java.lang.Math.random() * 10.0D))];
    AppMethodBeat.o(91138);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.a.a
 * JD-Core Version:    0.7.0.1
 */