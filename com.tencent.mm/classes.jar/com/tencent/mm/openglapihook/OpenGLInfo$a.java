package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OpenGLInfo$a
{
  static
  {
    AppMethodBeat.i(204091);
    mxE = new a("TEXTURE", 0);
    mxF = new a("BUFFER", 1);
    mxG = new a("FRAME_BUFFERS", 2);
    mxH = new a("RENDER_BUFFERS", 3);
    mxI = new a[] { mxE, mxF, mxG, mxH };
    AppMethodBeat.o(204091);
  }
  
  private OpenGLInfo$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLInfo.a
 * JD-Core Version:    0.7.0.1
 */