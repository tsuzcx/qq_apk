package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class v
  extends u
{
  protected float u;
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146345);
    super.a(paramInt1, paramInt2);
    s();
    AppMethodBeat.o(146345);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(146343);
    if ((super.b()) && (GLES20.glGetError() == 0))
    {
      AppMethodBeat.o(146343);
      return true;
    }
    AppMethodBeat.o(146343);
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
    AppMethodBeat.i(146344);
    float f = r();
    g localg = (g)this.r.get(0);
    int i = GLES20.glGetUniformLocation(localg.p(), "texelWidthOffset");
    int j = GLES20.glGetUniformLocation(localg.p(), "texelHeightOffset");
    localg.a(i, f / this.e);
    localg.a(j, 0.0F);
    f = q();
    localg = (g)this.r.get(1);
    i = GLES20.glGetUniformLocation(localg.p(), "texelWidthOffset");
    j = GLES20.glGetUniformLocation(localg.p(), "texelHeightOffset");
    localg.a(i, 0.0F);
    localg.a(j, f / this.f);
    AppMethodBeat.o(146344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.v
 * JD-Core Version:    0.7.0.1
 */