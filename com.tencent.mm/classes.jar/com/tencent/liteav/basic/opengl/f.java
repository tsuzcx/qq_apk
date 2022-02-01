package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
{
  private final int a;
  private final int b;
  private int c = -1;
  private int d = -1;
  
  public f(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a()
  {
    AppMethodBeat.i(230196);
    this.c = TXCOpenGlUtils.a(null, this.a, this.b, -1);
    this.d = TXCOpenGlUtils.d();
    TXCOpenGlUtils.a(this.c, this.d);
    TXCLog.i("GLFrameBuffer", "create frameBufferId: %d, textureId: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c) });
    AppMethodBeat.o(230196);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void e()
  {
    AppMethodBeat.i(230237);
    TXCLog.i("GLFrameBuffer", "destroy frameBufferId: %d, textureId: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c) });
    TXCOpenGlUtils.c(this.c);
    this.c = -1;
    TXCOpenGlUtils.b(this.d);
    this.d = -1;
    AppMethodBeat.o(230237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.f
 * JD-Core Version:    0.7.0.1
 */