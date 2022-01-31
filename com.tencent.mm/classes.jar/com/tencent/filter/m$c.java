package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$c
  extends m
{
  float[] bww;
  
  public m$c(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    AppMethodBeat.i(86392);
    this.bww = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      this.bww[i] = paramArrayOfFloat[i];
      i += 1;
    }
    AppMethodBeat.o(86392);
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86393);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86393);
      return;
    }
    GLES20.glUniform2fv(this.handle, this.bww.length / 2, this.bww, 0);
    g.checkGlError("Float2sParam setParams");
    AppMethodBeat.o(86393);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86394);
    String str = this.name + "=" + this.bww;
    AppMethodBeat.o(86394);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.m.c
 * JD-Core Version:    0.7.0.1
 */