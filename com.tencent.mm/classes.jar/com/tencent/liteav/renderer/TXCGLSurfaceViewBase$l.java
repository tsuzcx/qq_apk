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
    AppMethodBeat.i(16842);
    this.a = new StringBuilder();
    AppMethodBeat.o(16842);
  }
  
  private void a()
  {
    AppMethodBeat.i(16846);
    if (this.a.length() > 0)
    {
      TXCLog.v("TXCGLSurfaceViewBase", this.a.toString());
      this.a.delete(0, this.a.length());
    }
    AppMethodBeat.o(16846);
  }
  
  public void close()
  {
    AppMethodBeat.i(16843);
    a();
    AppMethodBeat.o(16843);
  }
  
  public void flush()
  {
    AppMethodBeat.i(16844);
    a();
    AppMethodBeat.o(16844);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16845);
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
    AppMethodBeat.o(16845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.l
 * JD-Core Version:    0.7.0.1
 */