package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends j
{
  public boolean a()
  {
    AppMethodBeat.i(15001);
    this.a = NativeLoad.nativeLoadGLProgram(6);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(15001);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.c
 * JD-Core Version:    0.7.0.1
 */