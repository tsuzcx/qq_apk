package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$7
  implements Runnable
{
  c$7(c paramc, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(17252);
    if (this.bHS == 11)
    {
      c.a(this.jBL, this.ePW, this.jzn);
      AppMethodBeat.o(17252);
      return;
    }
    if (this.bHS == 6)
    {
      c.b(this.jBL, this.ePW, this.jzn);
      AppMethodBeat.o(17252);
      return;
    }
    if (this.bHS == 13)
    {
      c.H(this.ePW, this.jzn);
      AppMethodBeat.o(17252);
      return;
    }
    if (this.bHS == 15)
    {
      c.c(this.jBL, this.ePW, this.jzn);
      AppMethodBeat.o(17252);
      return;
    }
    if (this.bHS == 8)
    {
      c.a(this.jBL, this.ePW);
      AppMethodBeat.o(17252);
      return;
    }
    AppMethodBeat.o(17252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.7
 * JD-Core Version:    0.7.0.1
 */