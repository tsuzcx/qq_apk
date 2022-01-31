package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  private static int M(String paramString, int paramInt)
  {
    AppMethodBeat.i(76326);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(76326);
      return 0;
    }
    AppMethodBeat.o(76326);
    return paramInt;
  }
  
  public static int Vm()
  {
    AppMethodBeat.i(76325);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    int i = arrayOfInt[0];
    AppMethodBeat.o(76325);
    return i;
  }
  
  public static int Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76327);
    int[] arrayOfInt = new int[1];
    int i = M(paramString1, 35633);
    if (i == 0)
    {
      ab.e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
      AppMethodBeat.o(76327);
      return 0;
    }
    int j = M(paramString2, 35632);
    if (j == 0)
    {
      ab.e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
      AppMethodBeat.o(76327);
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      ab.e("MicroMsg.MMSightCameraGLUtil", "link program failed");
      AppMethodBeat.o(76327);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(76327);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.b
 * JD-Core Version:    0.7.0.1
 */