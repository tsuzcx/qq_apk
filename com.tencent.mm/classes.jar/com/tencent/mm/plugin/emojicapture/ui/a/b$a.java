package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.b.g;
import android.opengl.GLES20;
import com.tencent.mm.sdk.platformtools.y;

public final class b$a
{
  public static int YW()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    return arrayOfInt[0];
  }
  
  public static int aKX()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameteri(36197, 10241, 9729);
    GLES20.glTexParameteri(36197, 10240, 9728);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    GLES20.glBindTexture(36197, 0);
    return arrayOfInt[0];
  }
  
  public static int aKY()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      y.e("MicroMsg.EmojiCaptureGLUtil", "gen frame buffer error");
      return 0;
    }
    return arrayOfInt[0];
  }
  
  public static void aKZ()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(19798);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static int aW(String paramString1, String paramString2)
  {
    g.k(paramString1, "vertexShaderSource");
    g.k(paramString2, "fragmentShaderSource");
    int[] arrayOfInt = new int[1];
    int i = ae(paramString1, 35633);
    if (i == 0)
    {
      y.e("MicroMsg.EmojiCaptureGLUtil", "load vertex shader failed");
      return 0;
    }
    int j = ae(paramString2, 35632);
    if (j == 0)
    {
      y.e("MicroMsg.EmojiCaptureGLUtil", "load fragment shader failed");
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      y.e("MicroMsg.EmojiCaptureGLUtil", "link program failed");
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  private static int ae(String paramString, int paramInt)
  {
    g.k(paramString, "shaderSource");
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      y.e("MicroMsg.EmojiCaptureGLUtil", "loadShader error, infoLog: %s", new Object[] { GLES20.glGetShaderInfoLog(paramInt) });
      return 0;
    }
    return paramInt;
  }
  
  public static void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
    GLES20.glBindTexture(3553, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b.a
 * JD-Core Version:    0.7.0.1
 */