package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements MessageQueue.IdleHandler
{
  c$1(c paramc) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(14362);
    this.jZR.Kt();
    AppMethodBeat.o(14362);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.1
 * JD-Core Version:    0.7.0.1
 */