package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$d
  extends m
{
  float x;
  float y;
  float z;
  
  public m$d(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86395);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86395);
      return;
    }
    GLES20.glUniform3f(this.handle, this.x, this.y, this.z);
    g.checkGlError("Float3fParam setParams");
    AppMethodBeat.o(86395);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86396);
    String str = this.name + "=" + this.x + ", " + this.y + ", " + this.z;
    AppMethodBeat.o(86396);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.m.d
 * JD-Core Version:    0.7.0.1
 */