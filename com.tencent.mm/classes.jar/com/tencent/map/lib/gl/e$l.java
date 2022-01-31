package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class e$l
  extends Writer
{
  private StringBuilder a;
  
  e$l()
  {
    AppMethodBeat.i(98096);
    this.a = new StringBuilder();
    AppMethodBeat.o(98096);
  }
  
  private void a()
  {
    AppMethodBeat.i(98100);
    if (this.a.length() > 0) {
      this.a.delete(0, this.a.length());
    }
    AppMethodBeat.o(98100);
  }
  
  public void close()
  {
    AppMethodBeat.i(98097);
    a();
    AppMethodBeat.o(98097);
  }
  
  public void flush()
  {
    AppMethodBeat.i(98098);
    a();
    AppMethodBeat.o(98098);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98099);
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
    AppMethodBeat.o(98099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.gl.e.l
 * JD-Core Version:    0.7.0.1
 */