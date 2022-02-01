package androidx.core.graphics;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static final ThreadLocal<double[]> bqt;
  
  static
  {
    AppMethodBeat.i(196298);
    bqt = new ThreadLocal();
    AppMethodBeat.o(196298);
  }
  
  private static float L(float paramFloat1, float paramFloat2)
  {
    float f;
    if (paramFloat1 < 0.0F) {
      f = 0.0F;
    }
    do
    {
      return f;
      f = paramFloat2;
    } while (paramFloat1 > paramFloat2);
    return paramFloat1;
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(196256);
    if (paramArrayOfDouble.length != 3)
    {
      paramArrayOfDouble = new IllegalArgumentException("outXyz must have a length of 3.");
      AppMethodBeat.o(196256);
      throw paramArrayOfDouble;
    }
    double d1 = paramInt1 / 255.0D;
    double d2;
    label78:
    double d3;
    if (d1 < 0.04045D)
    {
      d1 /= 12.92D;
      d2 = paramInt2 / 255.0D;
      if (d2 >= 0.04045D) {
        break label211;
      }
      d2 /= 12.92D;
      d3 = paramInt3 / 255.0D;
      if (d3 >= 0.04045D) {
        break label232;
      }
    }
    label211:
    label232:
    for (d3 /= 12.92D;; d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D))
    {
      paramArrayOfDouble[0] = (100.0D * (0.4124D * d1 + 0.3576D * d2 + 0.1805D * d3));
      paramArrayOfDouble[1] = (100.0D * (0.2126D * d1 + 0.7152D * d2 + 0.0722D * d3));
      paramArrayOfDouble[2] = ((d3 * 0.9505D + (d2 * 0.1192D + d1 * 0.0193D)) * 100.0D);
      AppMethodBeat.o(196256);
      return;
      d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      break;
      d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      break label78;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(196180);
    float f1 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f5 = paramInt3 / 255.0F;
    float f6 = Math.max(f1, Math.max(f3, f5));
    float f7 = Math.min(f1, Math.min(f3, f5));
    float f2 = f6 - f7;
    float f4 = (f6 + f7) / 2.0F;
    if (f6 == f7)
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = f2 * 60.0F % 360.0F;
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      paramArrayOfFloat[0] = L(f2, 360.0F);
      paramArrayOfFloat[1] = L(f1, 1.0F);
      paramArrayOfFloat[2] = L(f4, 1.0F);
      AppMethodBeat.o(196180);
      return;
    }
    if (f6 == f1) {
      f1 = (f3 - f5) / f2 % 6.0F;
    }
    for (;;)
    {
      f3 = f2 / (1.0F - Math.abs(2.0F * f4 - 1.0F));
      f2 = f1;
      f1 = f3;
      break;
      if (f6 == f3) {
        f1 = (f5 - f1) / f2 + 2.0F;
      } else {
        f1 = (f1 - f3) / f2 + 4.0F;
      }
    }
  }
  
  public static int av(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196105);
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = 255 - (255 - i) * (255 - j) / 255;
    paramInt1 = Color.argb(k, f(Color.red(paramInt1), j, Color.red(paramInt2), i, k), f(Color.green(paramInt1), j, Color.green(paramInt2), i, k), f(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
    AppMethodBeat.o(196105);
    return paramInt1;
  }
  
  public static double aw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196152);
    if (Color.alpha(paramInt2) != 255)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
      AppMethodBeat.o(196152);
      throw localIllegalArgumentException;
    }
    int i = paramInt1;
    if (Color.alpha(paramInt1) < 255) {
      i = av(paramInt1, paramInt2);
    }
    double d1 = eg(i) + 0.05D;
    double d2 = eg(paramInt2) + 0.05D;
    d1 = Math.max(d1, d2) / Math.min(d1, d2);
    AppMethodBeat.o(196152);
    return d1;
  }
  
  public static int ax(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196221);
    if ((paramInt2 < 0) || (paramInt2 > 255))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("alpha must be between 0 and 255.");
      AppMethodBeat.o(196221);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(196221);
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  public static void b(int paramInt, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(196237);
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfDouble);
    double d2 = paramArrayOfDouble[0];
    double d3 = paramArrayOfDouble[1];
    double d1 = paramArrayOfDouble[2];
    d2 = q(d2 / 95.046999999999997D);
    d3 = q(d3 / 100.0D);
    d1 = q(d1 / 108.883D);
    paramArrayOfDouble[0] = Math.max(0.0D, 116.0D * d3 - 16.0D);
    paramArrayOfDouble[1] = ((d2 - d3) * 500.0D);
    paramArrayOfDouble[2] = ((d3 - d1) * 200.0D);
    AppMethodBeat.o(196237);
  }
  
  public static int c(int paramInt1, int paramInt2, float paramFloat)
  {
    int k = 255;
    AppMethodBeat.i(196163);
    if (Color.alpha(paramInt2) != 255)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
      AppMethodBeat.o(196163);
      throw localIllegalArgumentException;
    }
    if (aw(ax(paramInt1, 255), paramInt2) < paramFloat)
    {
      AppMethodBeat.o(196163);
      return -1;
    }
    int j = 0;
    int i = 0;
    if ((i <= 10) && (k - j > 1))
    {
      int m = (j + k) / 2;
      if (aw(ax(paramInt1, m), paramInt2) < paramFloat) {
        j = m;
      }
      for (;;)
      {
        i += 1;
        break;
        k = m;
      }
    }
    AppMethodBeat.o(196163);
    return k;
  }
  
  public static void d(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(196196);
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
    AppMethodBeat.o(196196);
  }
  
  private static double eg(int paramInt)
  {
    AppMethodBeat.i(196137);
    double[] arrayOfDouble2 = (double[])bqt.get();
    double[] arrayOfDouble1 = arrayOfDouble2;
    if (arrayOfDouble2 == null)
    {
      arrayOfDouble1 = new double[3];
      bqt.set(arrayOfDouble1);
    }
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), arrayOfDouble1);
    double d = arrayOfDouble1[1] / 100.0D;
    AppMethodBeat.o(196137);
    return d;
  }
  
  private static int eh(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= 255);
    return 255;
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  public static int l(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(196211);
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    f2 *= (1.0F - Math.abs(2.0F * f3 - 1.0F));
    f3 -= 0.5F * f2;
    float f4 = f2 * (1.0F - Math.abs(f1 / 60.0F % 2.0F - 1.0F));
    int i;
    int j;
    int k;
    switch ((int)f1 / 60)
    {
    default: 
      i = 0;
      j = 0;
      k = 0;
    }
    for (;;)
    {
      i = Color.rgb(eh(k), eh(j), eh(i));
      AppMethodBeat.o(196211);
      return i;
      k = Math.round((f2 + f3) * 255.0F);
      j = Math.round((f4 + f3) * 255.0F);
      i = Math.round(255.0F * f3);
      continue;
      k = Math.round((f4 + f3) * 255.0F);
      j = Math.round((f2 + f3) * 255.0F);
      i = Math.round(255.0F * f3);
      continue;
      k = Math.round(255.0F * f3);
      j = Math.round((f2 + f3) * 255.0F);
      i = Math.round((f4 + f3) * 255.0F);
      continue;
      k = Math.round(255.0F * f3);
      j = Math.round((f4 + f3) * 255.0F);
      i = Math.round((f2 + f3) * 255.0F);
      continue;
      k = Math.round((f4 + f3) * 255.0F);
      j = Math.round(255.0F * f3);
      i = Math.round((f2 + f3) * 255.0F);
      continue;
      k = Math.round((f2 + f3) * 255.0F);
      j = Math.round(255.0F * f3);
      i = Math.round((f4 + f3) * 255.0F);
    }
  }
  
  private static double q(double paramDouble)
  {
    AppMethodBeat.i(196288);
    if (paramDouble > 0.008855999999999999D)
    {
      paramDouble = Math.pow(paramDouble, 0.3333333333333333D);
      AppMethodBeat.o(196288);
      return paramDouble;
    }
    paramDouble = (903.29999999999995D * paramDouble + 16.0D) / 116.0D;
    AppMethodBeat.o(196288);
    return paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.graphics.b
 * JD-Core Version:    0.7.0.1
 */