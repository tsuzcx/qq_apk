package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class m$e
  extends m
{
  float w;
  float x;
  float y;
  float z;
  
  public m$e(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86397);
    if (this.handle < 0)
    {
      AppMethodBeat.o(86397);
      return;
    }
    GLES20.glUniform4f(this.handle, this.x, this.y, this.z, this.w);
    g.checkGlError("Float4fParam setParams");
    AppMethodBeat.o(86397);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86398);
    String str = this.name + "=" + this.x + ", " + this.y + ", " + this.z + ", " + this.w;
    AppMethodBeat.o(86398);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.m.e
 * JD-Core Version:    0.7.0.1
 */