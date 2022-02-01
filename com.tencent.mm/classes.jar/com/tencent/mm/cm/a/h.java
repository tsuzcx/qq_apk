package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static int aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(231122);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      new StringBuilder("Compilation\n").append(GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(231122);
      return 0;
    }
    AppMethodBeat.o(231122);
    return paramInt;
  }
  
  public static int bh(Bitmap paramBitmap)
  {
    AppMethodBeat.i(231116);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    int i = arrayOfInt[0];
    AppMethodBeat.o(231116);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.h
 * JD-Core Version:    0.7.0.1
 */