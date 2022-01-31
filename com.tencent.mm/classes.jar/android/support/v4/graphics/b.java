package android.support.v4.graphics;

import android.graphics.Color;

public final class b
{
  private static final ThreadLocal<double[]> Av = new ThreadLocal();
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
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
      paramArrayOfFloat[0] = s(f2, 360.0F);
      paramArrayOfFloat[1] = s(f1, 1.0F);
      paramArrayOfFloat[2] = s(f4, 1.0F);
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
  
  private static double ae(int paramInt)
  {
    double[] arrayOfDouble2 = (double[])Av.get();
    double[] arrayOfDouble1 = arrayOfDouble2;
    if (arrayOfDouble2 == null)
    {
      arrayOfDouble1 = new double[3];
      Av.set(arrayOfDouble1);
    }
    int i = Color.red(paramInt);
    int j = Color.green(paramInt);
    paramInt = Color.blue(paramInt);
    if (arrayOfDouble1.length != 3) {
      throw new IllegalArgumentException("outXyz must have a length of 3.");
    }
    double d1 = i / 255.0D;
    double d2;
    label111:
    double d3;
    if (d1 < 0.04045D)
    {
      d1 /= 12.92D;
      d2 = j / 255.0D;
      if (d2 >= 0.04045D) {
        break label242;
      }
      d2 /= 12.92D;
      d3 = paramInt / 255.0D;
      if (d3 >= 0.04045D) {
        break label261;
      }
    }
    label261:
    for (d3 /= 12.92D;; d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D))
    {
      arrayOfDouble1[0] = (100.0D * (0.4124D * d1 + 0.3576D * d2 + 0.1805D * d3));
      arrayOfDouble1[1] = (100.0D * (0.2126D * d1 + 0.7152D * d2 + 0.0722D * d3));
      arrayOfDouble1[2] = ((d3 * 0.9505D + (d2 * 0.1192D + d1 * 0.0193D)) * 100.0D);
      return arrayOfDouble1[1] / 100.0D;
      d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      break;
      label242:
      d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      break label111;
    }
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  public static int d(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = 255;
    if (Color.alpha(paramInt2) != 255) {
      throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
    }
    if (o(p(paramInt1, 255), paramInt2) < paramFloat) {
      m = -1;
    }
    int k;
    int j;
    do
    {
      do
      {
        return m;
        k = 0;
        j = 0;
        m = i;
      } while (j > 10);
      m = i;
    } while (i - k <= 1);
    int m = (k + i) / 2;
    if (o(p(paramInt1, m), paramInt2) < paramFloat) {
      k = m;
    }
    for (;;)
    {
      j += 1;
      break;
      i = m;
    }
  }
  
  public static void d(int paramInt, float[] paramArrayOfFloat)
  {
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
  }
  
  public static int n(int paramInt1, int paramInt2)
  {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = 255 - (255 - i) * (255 - j) / 255;
    return Color.argb(k, b(Color.red(paramInt1), j, Color.red(paramInt2), i, k), b(Color.green(paramInt1), j, Color.green(paramInt2), i, k), b(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  private static double o(int paramInt1, int paramInt2)
  {
    if (Color.alpha(paramInt2) != 255) {
      throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
    }
    int i = paramInt1;
    if (Color.alpha(paramInt1) < 255) {
      i = n(paramInt1, paramInt2);
    }
    double d1 = ae(i) + 0.05D;
    double d2 = ae(paramInt2) + 0.05D;
    return Math.max(d1, d2) / Math.min(d1, d2);
  }
  
  public static int p(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 255)) {
      throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  private static float s(float paramFloat1, float paramFloat2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.b
 * JD-Core Version:    0.7.0.1
 */