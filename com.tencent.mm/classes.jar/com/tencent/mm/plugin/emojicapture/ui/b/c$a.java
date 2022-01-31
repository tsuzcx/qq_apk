package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.b.j;
import a.l;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "bindFrameBuffer", "", "fbo", "", "texture", "width", "height", "bindRenderBuffer", "buffer", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "plugin-emojicapture_release"})
public final class c$a
{
  private static int M(String paramString, int paramInt)
  {
    AppMethodBeat.i(3148);
    j.q(paramString, "shaderSource");
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("MicroMsg.EmojiCaptureGLUtil", "loadShader error, infoLog: %s", new Object[] { GLES20.glGetShaderInfoLog(paramInt) });
      AppMethodBeat.o(3148);
      return 0;
    }
    AppMethodBeat.o(3148);
    return paramInt;
  }
  
  public static int Vm()
  {
    AppMethodBeat.i(3146);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    int i = arrayOfInt[0];
    AppMethodBeat.o(3146);
    return i;
  }
  
  public static int Vn()
  {
    AppMethodBeat.i(3150);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("MicroMsg.EmojiCaptureGLUtil", "gen frame buffer error");
      AppMethodBeat.o(3150);
      return 0;
    }
    int i = arrayOfInt[0];
    AppMethodBeat.o(3150);
    return i;
  }
  
  public static void Vo()
  {
    AppMethodBeat.i(3151);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(19798);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(3151);
  }
  
  public static int Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3149);
    j.q(paramString1, "vertexShaderSource");
    j.q(paramString2, "fragmentShaderSource");
    int[] arrayOfInt = new int[1];
    int i = M(paramString1, 35633);
    if (i == 0)
    {
      ab.e("MicroMsg.EmojiCaptureGLUtil", "load vertex shader failed");
      AppMethodBeat.o(3149);
      return 0;
    }
    int j = M(paramString2, 35632);
    if (j == 0)
    {
      ab.e("MicroMsg.EmojiCaptureGLUtil", "load fragment shader failed");
      AppMethodBeat.o(3149);
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      ab.e("MicroMsg.EmojiCaptureGLUtil", "link program failed");
      AppMethodBeat.o(3149);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(3149);
    return k;
  }
  
  public static int bpi()
  {
    AppMethodBeat.i(3147);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameteri(36197, 10241, 9729);
    GLES20.glTexParameteri(36197, 10240, 9728);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    GLES20.glBindTexture(36197, 0);
    int i = arrayOfInt[0];
    AppMethodBeat.o(3147);
    return i;
  }
  
  public static void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(3152);
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(3152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c.a
 * JD-Core Version:    0.7.0.1
 */