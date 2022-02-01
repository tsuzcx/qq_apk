package com.tencent.liteav.beauty.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b
{
  protected a a;
  private EGLSurface b = EGL11.EGL_NO_SURFACE;
  private int c = -1;
  private int d = -1;
  
  protected b(a parama)
  {
    this.a = parama;
  }
  
  public void a()
  {
    AppMethodBeat.i(15283);
    this.a.a(this.b);
    this.b = EGL11.EGL_NO_SURFACE;
    this.d = -1;
    this.c = -1;
    AppMethodBeat.o(15283);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15282);
    if (this.b != EGL11.EGL_NO_SURFACE)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("surface already created");
      AppMethodBeat.o(15282);
      throw localIllegalStateException;
    }
    this.b = this.a.a(paramInt1, paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    AppMethodBeat.o(15282);
  }
  
  public void b()
  {
    AppMethodBeat.i(15284);
    this.a.b(this.b);
    AppMethodBeat.o(15284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.a.a.b
 * JD-Core Version:    0.7.0.1
 */