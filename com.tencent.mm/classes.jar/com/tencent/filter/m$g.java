package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$g
  extends m
{
  float[] bww;
  
  public m$g(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    AppMethodBeat.i(86401);
    this.bww = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      this.bww[i] = paramArrayOfFloat[i];
      i += 1;
    }
    AppMethodBeat.o(86401);
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86403);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86403);
      return;
    }
    switch (this.bww.length)
    {
    default: 
      GLES20.glUniform1fv(this.handle, this.bww.length, this.bww, 0);
    }
    for (;;)
    {
      g.checkGlError("FloatsParam setParams");
      AppMethodBeat.o(86403);
      return;
      GLES20.glUniform1f(this.handle, this.bww[0]);
      continue;
      GLES20.glUniform2fv(this.handle, 1, this.bww, 0);
      continue;
      GLES20.glUniform3fv(this.handle, 1, this.bww, 0);
      continue;
      GLES20.glUniform4fv(this.handle, 1, this.bww, 0);
      continue;
      GLES20.glUniformMatrix3fv(this.handle, 1, false, this.bww, 0);
      continue;
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bww, 0);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86402);
    String str = this.name + "=" + this.bww.toString();
    AppMethodBeat.o(86402);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.filter.m.g
 * JD-Core Version:    0.7.0.1
 */