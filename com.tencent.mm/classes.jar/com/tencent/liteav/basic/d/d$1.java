package com.tencent.liteav.basic.d;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

class d$1
  implements Runnable
{
  d$1(d paramd, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2) {}
  
  public void run()
  {
    AppMethodBeat.i(146496);
    try
    {
      d.a(this.i, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      AppMethodBeat.o(146496);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXGLSurfaceRenderThread", "surface-render: render texture error occurred!");
      AppMethodBeat.o(146496);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.d.d.1
 * JD-Core Version:    0.7.0.1
 */