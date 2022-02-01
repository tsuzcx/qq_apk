package com.tencent.liteav.basic.d;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class j
{
  public static FloatBuffer a;
  public static FloatBuffer b;
  public static FloatBuffer c;
  public static FloatBuffer d;
  public static FloatBuffer e;
  private static float[] f;
  private static float[] g;
  private static float[] h;
  private static float[] i;
  private static float[] j;
  private static int k;
  
  static
  {
    AppMethodBeat.i(14536);
    f = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    g = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    h = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    i = new float[] { 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    j = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    a = a(f);
    b = a(g);
    c = a(h);
    d = a(i);
    e = a(j);
    k = 2;
    AppMethodBeat.o(14536);
  }
  
  public static final int a()
  {
    return k;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221410);
    paramInt1 = a(paramInt1, paramInt2, paramInt3, paramInt4, null);
    AppMethodBeat.o(221410);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IntBuffer paramIntBuffer)
  {
    AppMethodBeat.i(221409);
    int m = c();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, paramIntBuffer);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(221409);
    return m;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(221407);
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, null);
    paramInt1 = paramArrayOfInt[0];
    AppMethodBeat.o(221407);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(221412);
    GLES30.glGenBuffers(1, paramArrayOfInt, 0);
    GLES30.glBindBuffer(35051, paramArrayOfInt[0]);
    GLES30.glBufferData(35051, paramInt1 * paramInt2 * 4, null, 35049);
    GLES30.glBindBuffer(35051, 0);
    paramInt1 = paramArrayOfInt[0];
    AppMethodBeat.o(221412);
    return paramInt1;
  }
  
  public static int a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221411);
    int[] arrayOfInt = new int[1];
    if (paramInt == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramBitmap.recycle();
      }
      paramInt = arrayOfInt[0];
      AppMethodBeat.o(221411);
      return paramInt;
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(221415);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      TXCLog.w("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(221415);
      return 0;
    }
    AppMethodBeat.o(221415);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221416);
    int[] arrayOfInt = new int[1];
    int m = a(paramString1, 35633);
    if (m == 0)
    {
      TXCLog.w("Load Program", "Vertex Shader Failed");
      AppMethodBeat.o(221416);
      return 0;
    }
    int n = a(paramString2, 35632);
    if (n == 0)
    {
      TXCLog.w("Load Program", "Fragment Shader Failed");
      AppMethodBeat.o(221416);
      return 0;
    }
    int i1 = GLES20.glCreateProgram();
    GLES20.glAttachShader(i1, m);
    GLES20.glAttachShader(i1, n);
    GLES20.glLinkProgram(i1);
    GLES20.glGetProgramiv(i1, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      TXCLog.w("Load Program", "Linking Failed");
      AppMethodBeat.o(221416);
      return 0;
    }
    GLES20.glDeleteShader(m);
    GLES20.glDeleteShader(n);
    AppMethodBeat.o(221416);
    return i1;
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221408);
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    AppMethodBeat.o(221408);
    return localObject;
  }
  
  public static void a(int paramInt)
  {
    k = paramInt;
  }
  
  public static int b()
  {
    AppMethodBeat.i(221413);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    int m = arrayOfInt[0];
    AppMethodBeat.o(221413);
    return m;
  }
  
  public static int c()
  {
    AppMethodBeat.i(221414);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    int m = arrayOfInt[0];
    AppMethodBeat.o(221414);
    return m;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.j
 * JD-Core Version:    0.7.0.1
 */