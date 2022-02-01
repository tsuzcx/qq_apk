package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
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
    s();
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
  
  public float q()
  {
    return this.u;
  }
  
  public float r()
  {
    return this.u;
  }
  
  protected void s()
  {
    AppMethodBeat.i(15099);
    float f = r();
    h localh = (h)this.r.get(0);
    int i = GLES20.glGetUniformLocation(localh.p(), "texelWidthOffset");
    int j = GLES20.glGetUniformLocation(localh.p(), "texelHeightOffset");
    localh.a(i, f / this.e);
    localh.a(j, 0.0F);
    f = q();
    localh = (h)this.r.get(1);
    i = GLES20.glGetUniformLocation(localh.p(), "texelWidthOffset");
    j = GLES20.glGetUniformLocation(localh.p(), "texelHeightOffset");
    localh.a(i, 0.0F);
    localh.a(j, f / this.f);
    AppMethodBeat.o(15099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.v
 * JD-Core Version:    0.7.0.1
 */