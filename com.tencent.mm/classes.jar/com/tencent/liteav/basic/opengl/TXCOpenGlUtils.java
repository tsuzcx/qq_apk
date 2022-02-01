package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class TXCOpenGlUtils
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
    AppMethodBeat.i(236385);
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
    AppMethodBeat.o(236385);
  }
  
  public static final int a()
  {
    return k;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236347);
    paramInt1 = a(paramInt1, paramInt2, paramInt3, paramInt4, null);
    AppMethodBeat.o(236347);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IntBuffer paramIntBuffer)
  {
    AppMethodBeat.i(236345);
    int m = c();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, paramIntBuffer);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(236345);
    return m;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236340);
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, null);
    paramInt1 = paramArrayOfInt[0];
    AppMethodBeat.o(236340);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236350);
    GLES30.glGenBuffers(1, paramArrayOfInt, 0);
    GLES30.glBindBuffer(35051, paramArrayOfInt[0]);
    GLES30.glBufferData(35051, paramInt1 * paramInt2 * 4, null, 35049);
    GLES30.glBindBuffer(35051, 0);
    paramInt1 = paramArrayOfInt[0];
    AppMethodBeat.o(236350);
    return paramInt1;
  }
  
  public static int a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(236348);
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
      AppMethodBeat.o(236348);
      return paramInt;
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(236357);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      TXCLog.w("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(236357);
      return 0;
    }
    AppMethodBeat.o(236357);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236358);
    int[] arrayOfInt = new int[1];
    int m = a(paramString1, 35633);
    if (m == 0)
    {
      TXCLog.w("Load Program", "Vertex Shader Failed");
      AppMethodBeat.o(236358);
      return 0;
    }
    int n = a(paramString2, 35632);
    if (n == 0)
    {
      TXCLog.w("Load Program", "Fragment Shader Failed");
      AppMethodBeat.o(236358);
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
      AppMethodBeat.o(236358);
      return 0;
    }
    GLES20.glDeleteShader(m);
    GLES20.glDeleteShader(n);
    AppMethodBeat.o(236358);
    return i1;
  }
  
  public static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(236349);
    int[] arrayOfInt = new int[1];
    if (paramInt3 == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, paramByteBuffer);
    }
    for (;;)
    {
      paramInt1 = arrayOfInt[0];
      AppMethodBeat.o(236349);
      return paramInt1;
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6408, 5121, paramByteBuffer);
      arrayOfInt[0] = paramInt3;
    }
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(236342);
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    AppMethodBeat.o(236342);
    return localObject;
  }
  
  public static void a(int paramInt)
  {
    k = paramInt;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236369);
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(236369);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    AppMethodBeat.i(236379);
    GLES20.glFinish();
    if ((paramObject instanceof ByteBuffer))
    {
      ((ByteBuffer)paramObject).position(0);
      GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, (ByteBuffer)paramObject);
      AppMethodBeat.o(236379);
      return;
    }
    GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, ByteBuffer.wrap((byte[])paramObject));
    AppMethodBeat.o(236379);
  }
  
  public static void a(e.a parama, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(236377);
    if (parama == e.a.a)
    {
      a(0, 0, paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(236377);
      return;
    }
    if (paramInt2 % 8 == 0)
    {
      a(0, 0, paramInt1, paramInt2 * 3 / 8, paramObject);
      AppMethodBeat.o(236377);
      return;
    }
    int m = (paramInt2 * 3 + 7) / 8;
    parama = ByteBuffer.allocateDirect(paramInt1 * m * 4);
    a(0, 0, paramInt1, m, parama);
    if ((paramObject instanceof ByteBuffer))
    {
      nativeCopyDataFromByteBufferToByteBuffer(parama, (ByteBuffer)paramObject, paramInt1 * paramInt2 * 3 / 2);
      AppMethodBeat.o(236377);
      return;
    }
    nativeCopyDataFromByteBufferToByteArray(parama, (byte[])paramObject, paramInt1 * paramInt2 * 3 / 2);
    AppMethodBeat.o(236377);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(236360);
    int m = GLES20.glGetError();
    if (m != 0) {
      TXCLog.e("OpenGlUtils", paramString + ": glError 0x" + Integer.toHexString(m));
    }
    AppMethodBeat.o(236360);
  }
  
  public static void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236375);
    if (paramByteBuffer.isDirect())
    {
      nativeLoadYuv420ByteBufferToTextures(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramArrayOfInt);
      AppMethodBeat.o(236375);
      return;
    }
    nativeLoadYuv420ByteArrayToTextures(paramByteBuffer.array(), paramInt1, paramInt2, paramInt3, paramArrayOfInt);
    AppMethodBeat.o(236375);
  }
  
  public static int b()
  {
    AppMethodBeat.i(236353);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    int m = arrayOfInt[0];
    AppMethodBeat.o(236353);
    return m;
  }
  
  public static void b(int paramInt)
  {
    AppMethodBeat.i(236364);
    if (paramInt != -1) {
      GLES20.glDeleteFramebuffers(1, new int[] { paramInt }, 0);
    }
    AppMethodBeat.o(236364);
  }
  
  public static int c()
  {
    AppMethodBeat.i(236355);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    int m = arrayOfInt[0];
    AppMethodBeat.o(236355);
    return m;
  }
  
  public static void c(int paramInt)
  {
    AppMethodBeat.i(236367);
    if (paramInt != -1) {
      GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    }
    AppMethodBeat.o(236367);
  }
  
  public static int d()
  {
    AppMethodBeat.i(236362);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    int m = arrayOfInt[0];
    AppMethodBeat.o(236362);
    return m;
  }
  
  public static void d(int paramInt)
  {
    AppMethodBeat.i(236371);
    GLES20.glBindFramebuffer(36160, paramInt);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(236371);
  }
  
  public static Object e()
  {
    AppMethodBeat.i(236373);
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject = EGL14.eglGetCurrentContext();
      AppMethodBeat.o(236373);
      return localObject;
    }
    Object localObject = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    AppMethodBeat.o(236373);
    return localObject;
  }
  
  public static native void nativeCopyDataFromByteBufferToByteArray(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt);
  
  public static native void nativeCopyDataFromByteBufferToByteBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt);
  
  private static native void nativeLoadYuv420ByteArrayToTextures(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.TXCOpenGlUtils
 * JD-Core Version:    0.7.0.1
 */