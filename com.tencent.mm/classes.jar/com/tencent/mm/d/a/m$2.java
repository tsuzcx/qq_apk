package com.tencent.mm.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;

final class m$2
  implements Runnable
{
  m$2(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(113853);
    if (this.cbW.cbU != null) {
      this.cbW.cbU.cancel();
    }
    AppMethodBeat.o(113853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a.m.2
 * JD-Core Version:    0.7.0.1
 */