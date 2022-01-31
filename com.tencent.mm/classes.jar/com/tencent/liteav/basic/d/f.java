package com.tencent.liteav.basic.d;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class f
{
  public static FloatBuffer a = a(f);
  public static FloatBuffer b = a(g);
  public static FloatBuffer c = a(h);
  public static FloatBuffer d = a(i);
  public static FloatBuffer e = a(j);
  private static float[] f = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static float[] g = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static float[] h = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private static float[] i = { 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private static float[] j = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private static int k = 2;
  
  public static final int a()
  {
    return k;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IntBuffer paramIntBuffer)
  {
    int m = c();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, paramIntBuffer);
    GLES20.glBindTexture(3553, 0);
    return m;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, null);
    return paramArrayOfInt[0];
  }
  
  public static int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    GLES30.glGenBuffers(1, paramArrayOfInt, 0);
    GLES30.glBindBuffer(35051, paramArrayOfInt[0]);
    GLES30.glBufferData(35051, paramInt1 * paramInt2 * 4, null, 35049);
    GLES30.glBindBuffer(35051, 0);
    return paramArrayOfInt[0];
  }
  
  public static int a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
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
      return arrayOfInt[0];
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      TXCLog.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(paramInt));
      return 0;
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int[] arrayOfInt = new int[1];
    int m = a(paramString1, 35633);
    if (m == 0)
    {
      TXCLog.d("Load Program", "Vertex Shader Failed");
      return 0;
    }
    int n = a(paramString2, 35632);
    if (n == 0)
    {
      TXCLog.d("Load Program", "Fragment Shader Failed");
      return 0;
    }
    int i1 = GLES20.glCreateProgram();
    GLES20.glAttachShader(i1, m);
    GLES20.glAttachShader(i1, n);
    GLES20.glLinkProgram(i1);
    GLES20.glGetProgramiv(i1, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      TXCLog.d("Load Program", "Linking Failed");
      return 0;
    }
    GLES20.glDeleteShader(m);
    GLES20.glDeleteShader(n);
    return i1;
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static void a(int paramInt)
  {
    k = paramInt;
  }
  
  public static int b()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    return arrayOfInt[0];
  }
  
  public static int c()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    return arrayOfInt[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.f
 * JD-Core Version:    0.7.0.1
 */