package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$h
  extends m
{
  int[] value;
  
  public m$h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(86404);
    this.value = new int[0];
    AppMethodBeat.o(86404);
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86405);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86405);
      return;
    }
    GLES20.glUniform1iv(this.handle, this.value.length, this.value, 0);
    g.checkGlError("FloatParam setParams");
    AppMethodBeat.o(86405);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86406);
    String str = this.name + "=" + this.value;
    AppMethodBeat.o(86406);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.m.h
 * JD-Core Version:    0.7.0.1
 */