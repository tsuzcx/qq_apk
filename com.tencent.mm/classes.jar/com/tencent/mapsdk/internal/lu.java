package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public final class lu
{
  public static final long a = 20L;
  public static int b = 0;
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  
  static
  {
    AppMethodBeat.i(222969);
    long l = Runtime.getRuntime().maxMemory();
    if (l <= 16777216L)
    {
      b = 1;
      AppMethodBeat.o(222969);
      return;
    }
    if (l >= 67108864L)
    {
      b = 2;
      AppMethodBeat.o(222969);
      return;
    }
    b = 0;
    AppMethodBeat.o(222969);
  }
  
  public static double a(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    return (paramDouble2 - paramDouble1) * (paramLong2 / paramLong1) + paramDouble1;
  }
  
  private static int a(float paramFloat)
  {
    AppMethodBeat.i(222961);
    int j = (int)Math.ceil(paramFloat);
    int i = 1;
    for (;;)
    {
      int k = 2 << i;
      if (k >= j)
      {
        AppMethodBeat.o(222961);
        return k;
      }
      i += 1;
    }
  }
  
  private static int a(GL10 paramGL10, Bitmap paramBitmap)
  {
    AppMethodBeat.i(222878);
    int[] arrayOfInt = new int[1];
    paramGL10.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    paramGL10.glBindTexture(3553, i);
    paramGL10.glTexParameterf(3553, 10241, 9729.0F);
    paramGL10.glTexParameterf(3553, 10240, 9729.0F);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    AppMethodBeat.o(222878);
    return i;
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    int k = 2;
    AppMethodBeat.i(222886);
    int n = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i = 2;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      i <<= 1;
    }
    while (j < m) {
      j <<= 1;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(false);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localBitmap.eraseColor(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    AppMethodBeat.o(222886);
    return localBitmap;
  }
  
  private static FloatBuffer a(int paramInt)
  {
    AppMethodBeat.i(222838);
    ByteBuffer.allocate(0);
    try
    {
      Object localObject = ByteBuffer.allocateDirect(paramInt * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).rewind();
      AppMethodBeat.o(222838);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 4);
      }
    }
  }
  
  private static FloatBuffer a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(222828);
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).rewind();
    AppMethodBeat.o(222828);
    return localObject;
  }
  
  private static FloatBuffer a(float[] paramArrayOfFloat, FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(222848);
    int i = paramArrayOfFloat.length;
    FloatBuffer localFloatBuffer;
    if (paramFloatBuffer != null)
    {
      localFloatBuffer = paramFloatBuffer;
      if (paramFloatBuffer.capacity() == i) {}
    }
    else
    {
      localFloatBuffer = a(i);
    }
    localFloatBuffer.put(paramArrayOfFloat);
    localFloatBuffer.rewind();
    AppMethodBeat.o(222848);
    return localFloatBuffer;
  }
  
  private static ShortBuffer a(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(222856);
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfShort.length * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asShortBuffer();
    ((ShortBuffer)localObject).put(paramArrayOfShort);
    ((ShortBuffer)localObject).rewind();
    AppMethodBeat.o(222856);
    return localObject;
  }
  
  private static ShortBuffer a(short[] paramArrayOfShort, ShortBuffer paramShortBuffer)
  {
    AppMethodBeat.i(222870);
    int i = paramArrayOfShort.length;
    ShortBuffer localShortBuffer;
    if (paramShortBuffer != null)
    {
      localShortBuffer = paramShortBuffer;
      if (paramShortBuffer.capacity() == i) {}
    }
    else
    {
      paramShortBuffer = ByteBuffer.allocateDirect(i * 2);
      paramShortBuffer.order(ByteOrder.nativeOrder());
      localShortBuffer = paramShortBuffer.asShortBuffer();
      localShortBuffer.rewind();
    }
    localShortBuffer.put(paramArrayOfShort);
    localShortBuffer.rewind();
    AppMethodBeat.o(222870);
    return localShortBuffer;
  }
  
  private static boolean a()
  {
    return b == 1;
  }
  
  public static double b(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / paramLong1;
    return (paramDouble2 - paramDouble1) * (d1 * d1) + paramDouble1;
  }
  
  private static ShortBuffer b(int paramInt)
  {
    AppMethodBeat.i(222861);
    Object localObject = ByteBuffer.allocateDirect(paramInt * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asShortBuffer();
    ((ShortBuffer)localObject).rewind();
    AppMethodBeat.o(222861);
    return localObject;
  }
  
  public static double c(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / paramLong1 - 1.0D;
    return (paramDouble2 - paramDouble1) * (1.0D - d1 * d1) + paramDouble1;
  }
  
  private static float[] c(int paramInt)
  {
    float f1 = paramInt >> 24 & 0xFF;
    float f2 = paramInt >> 16 & 0xFF;
    float f3 = paramInt >> 8 & 0xFF;
    float f4 = paramInt & 0xFF;
    return new float[] { f2 / 255.0F, f3 / 255.0F, f4 / 255.0F, f1 / 255.0F };
  }
  
  public static double d(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / paramLong1;
    d1 *= d1;
    d1 *= d1;
    return (paramDouble2 - paramDouble1) * (d1 * d1) + paramDouble1;
  }
  
  public static double e(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / paramLong1 - 1.0D;
    d1 *= d1;
    d1 *= d1;
    return (paramDouble2 - paramDouble1) * (1.0D - d1 * d1) + paramDouble1;
  }
  
  private static double f(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / paramLong1;
    return (paramDouble2 - paramDouble1) * (d1 * (d1 * d1 * d1)) + paramDouble1;
  }
  
  private static double g(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / paramLong1 - 1.0D;
    return (paramDouble2 - paramDouble1) * (1.0D - d1 * (d1 * d1 * d1)) + paramDouble1;
  }
  
  private static double h(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / (paramLong1 - 1L);
    d1 *= d1;
    return (paramDouble1 - paramDouble2) * (1.0D - d1 * d1) + paramDouble2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lu
 * JD-Core Version:    0.7.0.1
 */