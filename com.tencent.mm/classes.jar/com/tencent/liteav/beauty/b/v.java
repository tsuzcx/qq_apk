package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class v
  extends u
{
  protected float u;
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15100);
    super.a(paramInt1, paramInt2);
    t();
    AppMethodBeat.o(15100);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15098);
    if ((super.b()) && (GLES20.glGetError() == 0))
    {
      AppMethodBeat.o(15098);
      return true;
    }
    AppMethodBeat.o(15098);
    return false;
  }
  
  public float r()
  {
    return this.u;
  }
  
  public float s()
  {
    return this.u;
  }
  
  protected void t()
  {
    AppMethodBeat.i(231884);
    float f = s();
    j localj = (j)this.r.get(0);
    int i = GLES20.glGetUniformLocation(localj.q(), "texelWidthOffset");
    int j = GLES20.glGetUniformLocation(localj.q(), "texelHeightOffset");
    localj.a(i, f / this.e);
    localj.a(j, 0.0F);
    f = r();
    localj = (j)this.r.get(1);
    i = GLES20.glGetUniformLocation(localj.q(), "texelWidthOffset");
    j = GLES20.glGetUniformLocation(localj.q(), "texelHeightOffset");
    localj.a(i, 0.0F);
    localj.a(j, f / this.f);
    AppMethodBeat.o(231884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.v
 * JD-Core Version:    0.7.0.1
 */