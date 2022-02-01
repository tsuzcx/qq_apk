package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends g
{
  public boolean a()
  {
    AppMethodBeat.i(15001);
    NativeLoad.getInstance();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.c
 * JD-Core Version:    0.7.0.1
 */