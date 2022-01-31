package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Writer;

final class GLSurfaceView$l
  extends Writer
{
  private StringBuilder mBuilder;
  
  GLSurfaceView$l()
  {
    AppMethodBeat.i(133994);
    this.mBuilder = new StringBuilder();
    AppMethodBeat.o(133994);
  }
  
  private void flushBuilder()
  {
    AppMethodBeat.i(133998);
    if (this.mBuilder.length() > 0)
    {
      ab.v("GLSurfaceView", this.mBuilder.toString());
      this.mBuilder.delete(0, this.mBuilder.length());
    }
    AppMethodBeat.o(133998);
  }
  
  public final void close()
  {
    AppMethodBeat.i(133995);
    flushBuilder();
    AppMethodBeat.o(133995);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(133996);
    flushBuilder();
    AppMethodBeat.o(133996);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133997);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
    AppMethodBeat.o(133997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.l
 * JD-Core Version:    0.7.0.1
 */