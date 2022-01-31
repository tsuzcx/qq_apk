package com.tencent.mm.bf;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1$1
  implements MessageQueue.IdleHandler
{
  c$1$1(c.1 param1) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(116539);
    ab.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
    e.aks().b(this.fQX.fQW);
    AppMethodBeat.o(116539);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bf.c.1.1
 * JD-Core Version:    0.7.0.1
 */