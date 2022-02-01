package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.a;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  extends j
{
  private a r;
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(14968);
    if (this.r == null)
    {
      this.r = new a();
      this.r.a = 0;
      this.r.b = 0;
      this.r.c = this.e;
      this.r.d = this.f;
    }
    GLES20.glViewport(this.r.a, this.r.b, this.r.c, this.r.d);
    paramInt = super.b(paramInt);
    AppMethodBeat.o(14968);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.p
 * JD-Core Version:    0.7.0.1
 */