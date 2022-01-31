package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  extends g
{
  private a r;
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(146364);
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
    AppMethodBeat.o(146364);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.p
 * JD-Core Version:    0.7.0.1
 */