package com.tencent.liteav.basic.opengl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  private final int mJniValue;
  
  static
  {
    AppMethodBeat.i(230302);
    a = new a("RGBA", 0, 0);
    b = new a("I420", 1, 1);
    c = new a("NV21", 2, 2);
    d = new a("NV12", 3, 3);
    e = new a[] { a, b, c, d };
    AppMethodBeat.o(230302);
  }
  
  private e$a(int paramInt)
  {
    this.mJniValue = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.e.a
 * JD-Core Version:    0.7.0.1
 */