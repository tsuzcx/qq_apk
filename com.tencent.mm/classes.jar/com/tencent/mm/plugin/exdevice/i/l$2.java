package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.p;

final class l$2
  implements Runnable
{
  l$2(l paraml, long paramLong, int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(19747);
    l.c(this.lJE).a(this.lJF, this.val$errType, this.val$errCode, this.ftO, this.lJG);
    AppMethodBeat.o(19747);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(19748);
    String str = super.toString() + "|onTaskEnd";
    AppMethodBeat.o(19748);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.l.2
 * JD-Core Version:    0.7.0.1
 */