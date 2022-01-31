package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

class f$c
  extends t
{
  int r;
  int s;
  float t = 1.5F;
  
  public f$c()
  {
    super(null, null);
  }
  
  void a(float paramFloat)
  {
    AppMethodBeat.i(67048);
    this.t = paramFloat;
    a(this.r, this.t / this.e);
    a(this.s, this.t / this.f);
    AppMethodBeat.o(67048);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67049);
    super.a(paramInt1, paramInt2);
    a(this.t);
    AppMethodBeat.o(67049);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(67046);
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(2);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(67046);
      return bool;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(67047);
    if (super.b())
    {
      this.r = GLES20.glGetUniformLocation(this.a, "texelWidthOffset");
      this.s = GLES20.glGetUniformLocation(this.a, "texelHeightOffset");
      AppMethodBeat.o(67047);
      return true;
    }
    AppMethodBeat.o(67047);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.f.c
 * JD-Core Version:    0.7.0.1
 */