package com.tencent.mm.bf;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$3$1
  implements MessageQueue.IdleHandler
{
  e$3$1(e.3 param3) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(145806);
    this.fRo.fRn.b(new e.3.1.1(this));
    AppMethodBeat.o(145806);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bf.e.3.1
 * JD-Core Version:    0.7.0.1
 */