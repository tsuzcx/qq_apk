package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$16$1
  implements Runnable
{
  o$16$1(o.16 param16, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(135539);
    o.i(this.kMa.kLI);
    o.a(this.kMa.kLI, this.kMa.kLQ, -10086, -5, "join room callback failed: " + this.val$errCode);
    AppMethodBeat.o(135539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.16.1
 * JD-Core Version:    0.7.0.1
 */