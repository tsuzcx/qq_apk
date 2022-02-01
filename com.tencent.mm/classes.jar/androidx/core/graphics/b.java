package androidx.core.graphics;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static final ThreadLocal<double[]> Km;
  
  static
  {
    AppMethodBeat.i(250661);
    Km = new ThreadLocal();
    AppMethodBeat.o(250661);
  }
  
  public static int A(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250645);
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = 255 - (255 - i) * (255 - j) / 255;
    paramInt1 = Color.argb(k, e(Color.red(paramInt1), j, Color.red(paramInt2), i, k), e(Color.green(paramInt1), j, Color.green(paramInt2), i, k), e(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
    AppMethodBeat.o(250645);
    return paramInt1;
  }
  
  private static double B(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250649);
    if (Color.alpha(paramInt2) != 255)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
      AppMethodBeat.o(250649);
      throw localIllegalArgumentException;
    }
    int i = paramInt1;
    if (Color.alpha(paramInt1) < 255) {
      i = A(paramInt1, paramInt2);
    }
    double d1 = br(i) + 0.05D;
    double d2 = br(paramInt2) + 0.05D;
    d1 = Math.max(d1, d2) / Math.min(d1, d2);
    AppMethodBeat.o(250649);
    return d1;
  }
  
  public static int C(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250659);
    if ((paramInt2 < 0) || (paramInt2 > 255))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("alpha must be between 0 and 255.");
      AppMethodBeat.o(250659);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(250659);
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(250654);
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
      paramArrayOfFloat[0] = c(f2, 360.0F);
      paramArrayOfFloat[1] = c(f1, 1.0F);
      paramArrayOfFloat[2] = c(f4, 1.0F);
      AppMethodBeat.o(250654);
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
  
  public static int b(int paramInt1, int paramInt2, float paramFloat)
  {
    int k = 255;
    AppMethodBeat.i(250652);
    if (Color.alpha(paramInt2) != 255)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
      AppMethodBeat.o(250652);
      throw localIllegalArgumentException;
    }
    if (B(C(paramInt1, 255), paramInt2) < paramFloat)
    {
      AppMethodBeat.o(250652);
      return -1;
    }
    int j = 0;
    int i = 0;
    if ((i <= 10) && (k - j > 1))
    {
      int m = (j + k) / 2;
      if (B(C(paramInt1, m), paramInt2) < paramFloat) {
        j = m;
      }
      for (;;)
      {
        i += 1;
        break;
        k = m;
      }
    }
    AppMethodBeat.o(250652);
    return k;
  }
  
  private static double br(int paramInt)
  {
    AppMethodBeat.i(250646);
    double[] arrayOfDouble = (double[])Km.get();
    Object localObject = arrayOfDouble;
    if (arrayOfDouble == null)
    {
      localObject = new double[3];
      Km.set(localObject);
    }
    int i = Color.red(paramInt);
    int j = Color.green(paramInt);
    paramInt = Color.blue(paramInt);
    if (localObject.length != 3)
    {
      localObject = new IllegalArgumentException("outXyz must have a length of 3.");
      AppMethodBeat.o(250646);
      throw ((Throwable)localObject);
    }
    double d1 = i / 255.0D;
    double d2;
    label125:
    double d3;
    if (d1 < 0.04045D)
    {
      d1 /= 12.92D;
      d2 = j / 255.0D;
      if (d2 >= 0.04045D) {
        break label263;
      }
      d2 /= 12.92D;
      d3 = paramInt / 255.0D;
      if (d3 >= 0.04045D) {
        break label282;
      }
    }
    label263:
    label282:
    for (d3 /= 12.92D;; d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D))
    {
      localObject[0] = (100.0D * (0.4124D * d1 + 0.3576D * d2 + 0.1805D * d3));
      localObject[1] = (100.0D * (0.2126D * d1 + 0.7152D * d2 + 0.0722D * d3));
      localObject[2] = ((d3 * 0.9505D + (d2 * 0.1192D + d1 * 0.0193D)) * 100.0D);
      d1 = localObject[1] / 100.0D;
      AppMethodBeat.o(250646);
      return d1;
      d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      break;
      d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      break label125;
    }
  }
  
  private static int bs(int paramInt)
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
  
  private static float c(float paramFloat1, float paramFloat2)
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
  
  public static int c(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(250657);
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
      i = Color.rgb(bs(k), bs(j), bs(i));
      AppMethodBeat.o(250657);
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
  
  public static void d(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(250655);
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
    AppMethodBeat.o(250655);
  }
  
  private static int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.b
 * JD-Core Version:    0.7.0.1
 */