package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$f
  extends m
{
  float value;
  
  public m$f(String paramString, float paramFloat)
  {
    super(paramString);
    this.value = paramFloat;
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86399);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86399);
      return;
    }
    GLES20.glUniform1f(this.handle, this.value);
    g.checkGlError("FloatParam setParams");
    AppMethodBeat.o(86399);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86400);
    String str = this.name + "=" + this.value;
    AppMethodBeat.o(86400);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.filter.m.f
 * JD-Core Version:    0.7.0.1
 */