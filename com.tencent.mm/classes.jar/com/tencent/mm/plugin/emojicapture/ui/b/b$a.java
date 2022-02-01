package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "allocTexutreMem", "", "texture", "", "width", "height", "bindFrameBuffer", "fbo", "bindRenderBuffer", "buffer", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "genFrameBuffer", "genRenderBuffer", "genTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "plugin-emojicapture_release"})
public final class b$a
{
  private static int Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(831);
    p.h(paramString, "shaderSource");
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ad.e("MicroMsg.EmojiCaptureGLUtil", "loadShader error, infoLog: %s", new Object[] { GLES20.glGetShaderInfoLog(paramInt) });
      AppMethodBeat.o(831);
      return 0;
    }
    AppMethodBeat.o(831);
    return paramInt;
  }
  
  public static void aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(835);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(835);
  }
  
  public static void aug()
  {
    AppMethodBeat.i(834);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(834);
  }
  
  public static int ay(String paramString1, String paramString2)
  {
    AppMethodBeat.i(832);
    p.h(paramString1, "vertexShaderSource");
    p.h(paramString2, "fragmentShaderSource");
    int[] arrayOfInt = new int[1];
    int i = Z(paramString1, 35633);
    if (i == 0)
    {
      ad.e("MicroMsg.EmojiCaptureGLUtil", "load vertex shader failed");
      AppMethodBeat.o(832);
      return 0;
    }
    int j = Z(paramString2, 35632);
    if (j == 0)
    {
      ad.e("MicroMsg.EmojiCaptureGLUtil", "load fragment shader failed");
      AppMethodBeat.o(832);
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      ad.e("MicroMsg.EmojiCaptureGLUtil", "link program failed");
      AppMethodBeat.o(832);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(832);
    return k;
  }
  
  public static int ckC()
  {
    AppMethodBeat.i(833);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ad.e("MicroMsg.EmojiCaptureGLUtil", "gen frame buffer error");
      AppMethodBeat.o(833);
      return 0;
    }
    int i = arrayOfInt[0];
    AppMethodBeat.o(833);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.b.a
 * JD-Core Version:    0.7.0.1
 */