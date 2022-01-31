package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$a
  extends m
{
  float[] bww;
  
  public m$a(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    AppMethodBeat.i(86387);
    this.bww = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      this.bww[i] = paramArrayOfFloat[i];
      i += 1;
    }
    AppMethodBeat.o(86387);
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86388);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86388);
      return;
    }
    GLES20.glUniform1fv(this.handle, this.bww.length, this.bww, 0);
    g.checkGlError("FloatParam setParams");
    AppMethodBeat.o(86388);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86389);
    String str = this.name + "=" + this.bww;
    AppMethodBeat.o(86389);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.m.a
 * JD-Core Version:    0.7.0.1
 */