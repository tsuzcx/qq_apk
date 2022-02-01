package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCBuild;
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
    AppMethodBeat.i(230416);
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
    AppMethodBeat.o(230416);
  }
  
  public static final int a()
  {
    return k;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230274);
    paramInt1 = a(paramInt1, paramInt2, paramInt3, paramInt4, null);
    AppMethodBeat.o(230274);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IntBuffer paramIntBuffer)
  {
    AppMethodBeat.i(230267);
    int m = c();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, paramIntBuffer);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(230267);
    return m;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(230250);
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, null);
    paramInt1 = paramArrayOfInt[0];
    AppMethodBeat.o(230250);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(230301);
    GLES30.glGenBuffers(1, paramArrayOfInt, 0);
    GLES30.glBindBuffer(35051, paramArrayOfInt[0]);
    GLES30.glBufferData(35051, paramInt1 * paramInt2 * 4, null, 35049);
    GLES30.glBindBuffer(35051, 0);
    paramInt1 = paramArrayOfInt[0];
    AppMethodBeat.o(230301);
    return paramInt1;
  }
  
  public static int a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230285);
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
      AppMethodBeat.o(230285);
      return paramInt;
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(230322);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      TXCLog.w("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(230322);
      return 0;
    }
    AppMethodBeat.o(230322);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230328);
    int[] arrayOfInt = new int[1];
    int m = a(paramString1, 35633);
    if (m == 0)
    {
      TXCLog.w("Load Program", "Vertex Shader Failed");
      AppMethodBeat.o(230328);
      return 0;
    }
    int n = a(paramString2, 35632);
    if (n == 0)
    {
      TXCLog.w("Load Program", "Fragment Shader Failed");
      AppMethodBeat.o(230328);
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
      AppMethodBeat.o(230328);
      return 0;
    }
    GLES20.glDeleteShader(m);
    GLES20.glDeleteShader(n);
    AppMethodBeat.o(230328);
    return i1;
  }
  
  public static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230294);
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
      AppMethodBeat.o(230294);
      return paramInt1;
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6408, 5121, paramByteBuffer);
      arrayOfInt[0] = paramInt3;
    }
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(230258);
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    AppMethodBeat.o(230258);
    return localObject;
  }
  
  public static void a(int paramInt)
  {
    k = paramInt;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230362);
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(230362);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    AppMethodBeat.i(230393);
    GLES20.glFinish();
    if ((paramObject instanceof ByteBuffer))
    {
      ((ByteBuffer)paramObject).position(0);
      GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, (ByteBuffer)paramObject);
      AppMethodBeat.o(230393);
      return;
    }
    GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, ByteBuffer.wrap((byte[])paramObject));
    AppMethodBeat.o(230393);
  }
  
  public static void a(e.a parama, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(230387);
    if (parama == e.a.a)
    {
      a(0, 0, paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(230387);
      return;
    }
    if (paramInt2 % 8 == 0)
    {
      a(0, 0, paramInt1, paramInt2 * 3 / 8, paramObject);
      AppMethodBeat.o(230387);
      return;
    }
    int m = (paramInt2 * 3 + 7) / 8;
    parama = ByteBuffer.allocateDirect(paramInt1 * m * 4);
    a(0, 0, paramInt1, m, parama);
    if ((paramObject instanceof ByteBuffer))
    {
      nativeCopyDataFromByteBufferToByteBuffer(parama, (ByteBuffer)paramObject, paramInt1 * paramInt2 * 3 / 2);
      AppMethodBeat.o(230387);
      return;
    }
    nativeCopyDataFromByteBufferToByteArray(parama, (byte[])paramObject, paramInt1 * paramInt2 * 3 / 2);
    AppMethodBeat.o(230387);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(230334);
    int m = GLES20.glGetError();
    if (m != 0) {
      TXCLog.e("OpenGlUtils", paramString + ": glError 0x" + Integer.toHexString(m));
    }
    AppMethodBeat.o(230334);
  }
  
  public static void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(230378);
    if (paramByteBuffer.isDirect())
    {
      nativeLoadYuv420ByteBufferToTextures(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramArrayOfInt);
      AppMethodBeat.o(230378);
      return;
    }
    nativeLoadYuv420ByteArrayToTextures(paramByteBuffer.array(), paramInt1, paramInt2, paramInt3, paramArrayOfInt);
    AppMethodBeat.o(230378);
  }
  
  public static int b()
  {
    AppMethodBeat.i(230306);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    int m = arrayOfInt[0];
    AppMethodBeat.o(230306);
    return m;
  }
  
  public static void b(int paramInt)
  {
    AppMethodBeat.i(230349);
    if (paramInt != -1) {
      GLES20.glDeleteFramebuffers(1, new int[] { paramInt }, 0);
    }
    AppMethodBeat.o(230349);
  }
  
  public static int c()
  {
    AppMethodBeat.i(230314);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    int m = arrayOfInt[0];
    AppMethodBeat.o(230314);
    return m;
  }
  
  public static void c(int paramInt)
  {
    AppMethodBeat.i(230360);
    if (paramInt != -1) {
      GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    }
    AppMethodBeat.o(230360);
  }
  
  public static int d()
  {
    AppMethodBeat.i(230342);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    int m = arrayOfInt[0];
    AppMethodBeat.o(230342);
    return m;
  }
  
  public static void d(int paramInt)
  {
    AppMethodBeat.i(230369);
    GLES20.glBindFramebuffer(36160, paramInt);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(230369);
  }
  
  public static Object e()
  {
    AppMethodBeat.i(230375);
    if (TXCBuild.VersionInt() >= 17)
    {
      localObject = EGL14.eglGetCurrentContext();
      AppMethodBeat.o(230375);
      return localObject;
    }
    Object localObject = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    AppMethodBeat.o(230375);
    return localObject;
  }
  
  public static native void nativeCopyDataFromByteBufferToByteArray(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt);
  
  public static native void nativeCopyDataFromByteBufferToByteBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt);
  
  private static native void nativeLoadYuv420ByteArrayToTextures(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.TXCOpenGlUtils
 * JD-Core Version:    0.7.0.1
 */