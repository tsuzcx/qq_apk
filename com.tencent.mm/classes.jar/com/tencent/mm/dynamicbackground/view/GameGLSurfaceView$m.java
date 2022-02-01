package com.tencent.mm.dynamicbackground.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import java.io.Writer;

final class GameGLSurfaceView$m
  extends Writer
{
  private StringBuilder mBuilder;
  
  GameGLSurfaceView$m()
  {
    AppMethodBeat.i(103048);
    this.mBuilder = new StringBuilder();
    AppMethodBeat.o(103048);
  }
  
  private void fw()
  {
    AppMethodBeat.i(103052);
    if (this.mBuilder.length() > 0)
    {
      c.v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
      this.mBuilder.delete(0, this.mBuilder.length());
    }
    AppMethodBeat.o(103052);
  }
  
  public final void close()
  {
    AppMethodBeat.i(103049);
    fw();
    AppMethodBeat.o(103049);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(103050);
    fw();
    AppMethodBeat.o(103050);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103051);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        fw();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
    AppMethodBeat.o(103051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.m
 * JD-Core Version:    0.7.0.1
 */