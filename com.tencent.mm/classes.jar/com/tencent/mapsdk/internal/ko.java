package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.opengl.GLU;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

public final class ko
{
  private static final String[] a = { "北", "东北", "东", "东南", "南", "西南", "西", "西北" };
  
  private static double a(double paramDouble)
  {
    return paramDouble / 3.141592653589793D * 180.0D;
  }
  
  private static double a(fz paramfz1, fz paramfz2)
  {
    AppMethodBeat.i(222580);
    double d1 = paramfz1.a - paramfz2.a;
    double d2 = paramfz1.c - paramfz2.c;
    d1 = Math.sqrt(Math.pow(d1, 2.0D) + Math.pow(d2, 2.0D));
    AppMethodBeat.o(222580);
    return d1;
  }
  
  private static Bitmap a(GL10 paramGL10, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222480);
    int[] arrayOfInt1 = new int[(paramInt2 + paramInt4) * paramInt3];
    int[] arrayOfInt2 = new int[paramInt3 * paramInt4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    long l1 = System.currentTimeMillis();
    paramGL10.glReadPixels(paramInt1, 0, paramInt3, paramInt2 + paramInt4, 6408, 5121, localIntBuffer);
    long l2 = System.currentTimeMillis();
    kh.a("readPixels 使用的时间:" + (l2 - l1) + "ms");
    l1 = System.currentTimeMillis();
    float f1 = paramInt3 / paramInt3;
    float f2 = paramInt4 / paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt2 < paramInt4)
    {
      int i = 0;
      while (i < paramInt3)
      {
        int j = arrayOfInt1[((int)Math.ceil(i * f1 - 0.5D) + (int)Math.ceil(paramInt2 * f2 - 0.5D) * paramInt3)];
        arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + i)] = (j & 0xFF00FF00 | j << 16 & 0xFF0000 | j >> 16 & 0xFF);
        i += 1;
      }
      paramInt2 += 1;
      paramInt1 += 1;
    }
    paramGL10 = Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.RGB_565);
    kh.a("buffer 转成位图使用的时间:" + (System.currentTimeMillis() - l1) + "ms");
    AppMethodBeat.o(222480);
    return paramGL10;
  }
  
  private static Bitmap a(GL10 paramGL10, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(222496);
    int[] arrayOfInt1 = new int[(paramInt2 + paramInt4) * paramInt3];
    int[] arrayOfInt2 = new int[paramInt5 * paramInt6];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    long l1 = System.currentTimeMillis();
    paramGL10.glReadPixels(paramInt1, 0, paramInt3, paramInt2 + paramInt4, 6408, 5121, localIntBuffer);
    long l2 = System.currentTimeMillis();
    kh.a("readPixels 使用的时间:" + (l2 - l1) + "ms");
    l1 = System.currentTimeMillis();
    float f1 = paramInt3 / paramInt5;
    float f2 = paramInt4 / paramInt6;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt2 < paramInt6)
    {
      paramInt4 = 0;
      while (paramInt4 < paramInt5)
      {
        int i = arrayOfInt1[((int)Math.ceil(paramInt4 * f1 - 0.5D) + (int)Math.ceil(paramInt2 * f2 - 0.5D) * paramInt3)];
        arrayOfInt2[((paramInt6 - paramInt1 - 1) * paramInt5 + paramInt4)] = (i & 0xFF00FF00 | i << 16 & 0xFF0000 | i >> 16 & 0xFF);
        paramInt4 += 1;
      }
      paramInt2 += 1;
      paramInt1 += 1;
    }
    paramGL10 = Bitmap.createBitmap(arrayOfInt2, paramInt5, paramInt6, Bitmap.Config.RGB_565);
    kh.a("buffer 转成位图使用的时间:" + (System.currentTimeMillis() - l1) + "ms");
    AppMethodBeat.o(222496);
    return paramGL10;
  }
  
  private static PointF a(fz paramfz, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(222567);
    double d1 = paramfz.a;
    double d2 = -paramfz.c;
    paramfz = new PointF((float)(d1 + paramDouble1), (float)(d2 + paramDouble2));
    AppMethodBeat.o(222567);
    return paramfz;
  }
  
  private static fy a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(222693);
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    float f5 = paramArrayOfFloat[4];
    float f6 = paramArrayOfFloat[5];
    float f7 = paramArrayOfFloat[6];
    float f8 = paramArrayOfFloat[7];
    float f9 = paramArrayOfFloat[8];
    paramArrayOfFloat = new float[3];
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = new float[3];
    arrayOfFloat1[0] = (f4 - f1);
    arrayOfFloat1[1] = (f5 - f2);
    arrayOfFloat1[2] = (f6 - f3);
    arrayOfFloat2[0] = (f7 - f1);
    arrayOfFloat2[1] = (f8 - f2);
    arrayOfFloat2[2] = (f9 - f3);
    paramArrayOfFloat[0] = (arrayOfFloat1[1] * arrayOfFloat2[2] - arrayOfFloat1[2] * arrayOfFloat2[1]);
    paramArrayOfFloat[1] = (arrayOfFloat1[2] * arrayOfFloat2[0] - arrayOfFloat1[0] * arrayOfFloat2[2]);
    paramArrayOfFloat[2] = (arrayOfFloat1[0] * arrayOfFloat2[1] - arrayOfFloat1[1] * arrayOfFloat2[0]);
    paramArrayOfFloat = new fy(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
    AppMethodBeat.o(222693);
    return paramArrayOfFloat;
  }
  
  private static fz a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(222552);
    fz localfz = new fz((float)(paramDouble1 - paramDouble3), 0.0F, -(float)(paramDouble2 - paramDouble4));
    AppMethodBeat.o(222552);
    return localfz;
  }
  
  private static fz a(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat, float paramFloat4)
  {
    AppMethodBeat.i(222539);
    float[] arrayOfFloat1 = new float[16];
    Matrix.invertM(arrayOfFloat1, 0, paramArrayOfFloat, 0);
    paramArrayOfFloat = new fz(paramFloat1, paramFloat2, paramFloat4);
    float[] arrayOfFloat2 = new float[4];
    Matrix.multiplyMV(arrayOfFloat2, 0, arrayOfFloat1, 0, new float[] { paramArrayOfFloat.a, paramArrayOfFloat.b, paramArrayOfFloat.c, paramArrayOfFloat.d }, 0);
    paramArrayOfFloat = new fz(arrayOfFloat2[0] / arrayOfFloat2[3], arrayOfFloat2[1] / arrayOfFloat2[3], arrayOfFloat2[2] / arrayOfFloat2[3]);
    paramFloat1 = 1.0F;
    if (paramArrayOfFloat.b != 0.0F) {
      paramFloat1 = paramFloat3 / paramArrayOfFloat.b;
    }
    paramArrayOfFloat = new fz(paramArrayOfFloat.a * paramFloat1, paramFloat3, paramFloat1 * paramArrayOfFloat.c);
    AppMethodBeat.o(222539);
    return paramArrayOfFloat;
  }
  
  private static String a(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = paramFloat + 360.0F;
    }
    int i = 0;
    while (i < a.length)
    {
      paramFloat = i * 45 - 22.0F;
      if ((f < 45.0F + paramFloat) && (f >= paramFloat)) {
        return a[i];
      }
      i += 1;
    }
    return a[0];
  }
  
  private static boolean a(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222658);
    float f1 = paramArrayOfFloat1[0];
    float f2 = paramArrayOfFloat1[1];
    float f3 = paramArrayOfFloat1[2];
    float f4 = paramArrayOfFloat1[3];
    float f5 = paramArrayOfFloat1[4];
    float f6 = paramArrayOfFloat1[5];
    float f7 = paramArrayOfFloat1[6];
    float f8 = paramArrayOfFloat1[7];
    float f9 = paramArrayOfFloat1[8];
    Object localObject1 = new float[3];
    Object localObject2 = new float[3];
    float[] arrayOfFloat1 = new float[3];
    localObject2[0] = (f4 - f1);
    localObject2[1] = (f5 - f2);
    localObject2[2] = (f6 - f3);
    arrayOfFloat1[0] = (f7 - f1);
    arrayOfFloat1[1] = (f8 - f2);
    arrayOfFloat1[2] = (f9 - f3);
    localObject1[0] = (localObject2[1] * arrayOfFloat1[2] - localObject2[2] * arrayOfFloat1[1]);
    localObject1[1] = (localObject2[2] * arrayOfFloat1[0] - localObject2[0] * arrayOfFloat1[2]);
    localObject1[2] = (localObject2[0] * arrayOfFloat1[1] - localObject2[1] * arrayOfFloat1[0]);
    localObject2 = new fy(localObject1[0], localObject1[1], localObject1[2]);
    arrayOfFloat1 = new float[16];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    localObject1 = a(paramFloat1, paramFloat2, 0.0F, arrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt);
    paramArrayOfFloat2 = a(paramFloat1, paramFloat2, 1.0F, arrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt);
    int i = 0;
    while (i < 3)
    {
      localObject1[i] /= localObject1[3];
      paramArrayOfFloat2[i] /= paramArrayOfFloat2[3];
      i += 1;
    }
    paramArrayOfFloat2 = new fy(paramArrayOfFloat2[0] - localObject1[0], paramArrayOfFloat2[1] - localObject1[1], paramArrayOfFloat2[2] - localObject1[2]);
    paramArrayOfInt = ((fy)localObject2).a();
    localObject2 = new float[3];
    localObject2[0] = paramArrayOfFloat1[0];
    localObject2[1] = paramArrayOfFloat1[1];
    localObject2[2] = paramArrayOfFloat1[2];
    arrayOfFloat1 = paramArrayOfFloat2.a();
    float[] arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = localObject1[0];
    arrayOfFloat2[1] = localObject1[1];
    arrayOfFloat2[2] = localObject1[2];
    paramArrayOfFloat2 = new float[3];
    f5 = paramArrayOfInt[0];
    f6 = paramArrayOfInt[1];
    f7 = paramArrayOfInt[2];
    f8 = localObject2[0];
    f9 = localObject2[1];
    float f10 = localObject2[2];
    paramFloat1 = arrayOfFloat1[0];
    paramFloat2 = arrayOfFloat1[1];
    f1 = arrayOfFloat1[2];
    f2 = arrayOfFloat2[0];
    f3 = arrayOfFloat2[1];
    f4 = arrayOfFloat2[2];
    float f11 = paramFloat1 * f5 + paramFloat2 * f6 + f1 * f7;
    if (f11 == 0.0F) {
      paramArrayOfFloat2 = null;
    }
    while (paramArrayOfFloat2 == null)
    {
      AppMethodBeat.o(222658);
      return false;
      f5 = (f7 * (f10 - f4) + (f5 * (f8 - f2) + f6 * (f9 - f3))) / f11;
      paramArrayOfFloat2[0] = (paramFloat1 * f5 + f2);
      paramArrayOfFloat2[1] = (paramFloat2 * f5 + f3);
      paramArrayOfFloat2[2] = (f5 * f1 + f4);
    }
    paramArrayOfFloat1 = new fx(paramArrayOfFloat1);
    localObject1 = new fz(paramArrayOfFloat2[0], paramArrayOfFloat2[1], paramArrayOfFloat2[2]);
    paramArrayOfFloat2 = new fx((fz)localObject1, paramArrayOfFloat1.a, paramArrayOfFloat1.b);
    paramArrayOfInt = new fx((fz)localObject1, paramArrayOfFloat1.a, paramArrayOfFloat1.c);
    localObject1 = new fx((fz)localObject1, paramArrayOfFloat1.b, paramArrayOfFloat1.c);
    if (Math.abs(paramArrayOfFloat1.a() - (paramArrayOfFloat2.a() + paramArrayOfInt.a() + ((fx)localObject1).a())) < 0.001D)
    {
      AppMethodBeat.o(222658);
      return true;
    }
    AppMethodBeat.o(222658);
    return false;
  }
  
  private static boolean a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(222708);
    paramArrayOfFloat2 = new fx(paramArrayOfFloat2);
    Object localObject = new fz(paramArrayOfFloat1[0], paramArrayOfFloat1[1], paramArrayOfFloat1[2]);
    paramArrayOfFloat1 = new fx((fz)localObject, paramArrayOfFloat2.a, paramArrayOfFloat2.b);
    fx localfx = new fx((fz)localObject, paramArrayOfFloat2.a, paramArrayOfFloat2.c);
    localObject = new fx((fz)localObject, paramArrayOfFloat2.b, paramArrayOfFloat2.c);
    if (Math.abs(paramArrayOfFloat2.a() - (paramArrayOfFloat1.a() + localfx.a() + ((fx)localObject).a())) < 0.001D)
    {
      AppMethodBeat.o(222708);
      return true;
    }
    AppMethodBeat.o(222708);
    return false;
  }
  
  private static float[] a(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222682);
    float[] arrayOfFloat = new float[4];
    if (GLU.gluUnProject(paramFloat1, paramArrayOfInt[3] - paramFloat2, paramFloat3, paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfInt, 0, arrayOfFloat, 0) != 1)
    {
      paramArrayOfFloat1 = new RuntimeException("unProject fail");
      AppMethodBeat.o(222682);
      throw paramArrayOfFloat1;
    }
    AppMethodBeat.o(222682);
    return arrayOfFloat;
  }
  
  private static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    float f7 = paramArrayOfFloat1[0];
    float f8 = paramArrayOfFloat1[1];
    float f9 = paramArrayOfFloat1[2];
    float f10 = paramArrayOfFloat2[0];
    float f11 = paramArrayOfFloat2[1];
    float f12 = paramArrayOfFloat2[2];
    float f1 = paramArrayOfFloat3[0];
    float f2 = paramArrayOfFloat3[1];
    float f3 = paramArrayOfFloat3[2];
    float f4 = paramArrayOfFloat4[0];
    float f5 = paramArrayOfFloat4[1];
    float f6 = paramArrayOfFloat4[2];
    float f13 = f1 * f7 + f2 * f8 + f3 * f9;
    if (f13 == 0.0F) {
      return null;
    }
    f7 = (f7 * (f10 - f4) + f8 * (f11 - f5) + (f12 - f6) * f9) / f13;
    return new float[] { f1 * f7 + f4, f2 * f7 + f5, f7 * f3 + f6 };
  }
  
  private static double b(double paramDouble)
  {
    return paramDouble / 180.0D * 3.141592653589793D;
  }
  
  private static double b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(222591);
    paramDouble1 = Math.sqrt(Math.pow(paramDouble1 - paramDouble3, 2.0D) + Math.pow(paramDouble2 - paramDouble4, 2.0D));
    AppMethodBeat.o(222591);
    return paramDouble1;
  }
  
  private static float b(fz paramfz1, fz paramfz2)
  {
    AppMethodBeat.i(222610);
    double d1 = paramfz1.a - paramfz2.a;
    double d2 = paramfz1.c - paramfz2.c;
    d1 = Math.sqrt(Math.pow(d1, 2.0D) + Math.pow(d2, 2.0D));
    d2 = Math.asin((paramfz2.a - paramfz1.a) / d1);
    d1 = d2;
    if (paramfz2.c - paramfz1.c < 0.0F) {
      d1 = 3.141592653589793D - d2;
    }
    float f = (float)(d1 / 3.141592653589793D * 180.0D);
    AppMethodBeat.o(222610);
    return f;
  }
  
  private static int b(float paramFloat)
  {
    AppMethodBeat.i(222522);
    int j = (int)Math.ceil(paramFloat);
    int i = 1;
    for (;;)
    {
      int k = 2 << i;
      if (k >= j)
      {
        AppMethodBeat.o(222522);
        return k;
      }
      i += 1;
    }
  }
  
  private static fy b(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222672);
    float[] arrayOfFloat = a(paramFloat1, paramFloat2, 0.0F, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt);
    paramArrayOfFloat1 = a(paramFloat1, paramFloat2, 1.0F, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt);
    int i = 0;
    while (i < 3)
    {
      arrayOfFloat[i] /= arrayOfFloat[3];
      paramArrayOfFloat1[i] /= paramArrayOfFloat1[3];
      i += 1;
    }
    paramArrayOfFloat1 = new fy(paramArrayOfFloat1[0] - arrayOfFloat[0], paramArrayOfFloat1[1] - arrayOfFloat[1], paramArrayOfFloat1[2] - arrayOfFloat[2]);
    AppMethodBeat.o(222672);
    return paramArrayOfFloat1;
  }
  
  private static IntBuffer b(GL10 paramGL10, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222508);
    IntBuffer localIntBuffer = IntBuffer.wrap(new int[paramInt3 * paramInt4]);
    localIntBuffer.position(0);
    paramGL10.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
    AppMethodBeat.o(222508);
    return localIntBuffer;
  }
  
  private static double c(double paramDouble)
  {
    AppMethodBeat.i(222460);
    double d = Math.abs(paramDouble % 360.0D);
    paramDouble = d;
    if (d > 270.0D) {
      paramDouble = 360.0D - d;
    }
    AppMethodBeat.o(222460);
    return paramDouble;
  }
  
  private static double c(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(222621);
    paramDouble1 = paramDouble3 - paramDouble1;
    paramDouble2 = paramDouble4 - paramDouble2;
    paramDouble3 = Math.atan(paramDouble2 / paramDouble1);
    if ((paramDouble1 > 0.0D) && (paramDouble2 > 0.0D)) {
      paramDouble1 = 1.570796326794897D - Math.abs(paramDouble3);
    }
    for (;;)
    {
      paramDouble1 = paramDouble1 * 180.0D / 3.141592653589793D;
      AppMethodBeat.o(222621);
      return paramDouble1;
      if ((paramDouble1 >= 0.0D) && (paramDouble2 <= 0.0D)) {
        paramDouble1 = 1.570796326794897D + Math.abs(paramDouble3);
      } else if ((paramDouble1 <= 0.0D) && (paramDouble2 <= 0.0D)) {
        paramDouble1 = 4.71238898038469D - Math.abs(paramDouble3);
      } else {
        paramDouble1 = 4.71238898038469D + Math.abs(paramDouble3);
      }
    }
  }
  
  private static double d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(222631);
    paramDouble3 = Math.asin((paramDouble3 - paramDouble1) / Math.sqrt(Math.pow(paramDouble1 - paramDouble3, 2.0D) + Math.pow(paramDouble2 - paramDouble4, 2.0D)));
    paramDouble1 = paramDouble3;
    if (paramDouble4 - paramDouble2 < 0.0D) {
      paramDouble1 = 3.141592653589793D - paramDouble3;
    }
    paramDouble1 /= 3.141592653589793D;
    AppMethodBeat.o(222631);
    return paramDouble1 * 180.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ko
 * JD-Core Version:    0.7.0.1
 */