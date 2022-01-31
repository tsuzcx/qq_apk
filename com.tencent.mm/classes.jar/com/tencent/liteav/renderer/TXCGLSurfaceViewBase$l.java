package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class TXCGLSurfaceViewBase$l
  extends Writer
{
  private StringBuilder a;
  
  TXCGLSurfaceViewBase$l()
  {
    AppMethodBeat.i(67306);
    this.a = new StringBuilder();
    AppMethodBeat.o(67306);
  }
  
  private void a()
  {
    AppMethodBeat.i(67310);
    if (this.a.length() > 0)
    {
      TXCLog.v("TXCGLSurfaceViewBase", this.a.toString());
      this.a.delete(0, this.a.length());
    }
    AppMethodBeat.o(67310);
  }
  
  public void close()
  {
    AppMethodBeat.i(67307);
    a();
    AppMethodBeat.o(67307);
  }
  
  public void flush()
  {
    AppMethodBeat.i(67308);
    a();
    AppMethodBeat.o(67308);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67309);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      }
      for (;;)
      {
        i += 1;
        break;
        this.a.append(c);
      }
    }
    AppMethodBeat.o(67309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.l
 * JD-Core Version:    0.7.0.1
 */