package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$6$1
  implements MessageQueue.IdleHandler
{
  d$6$1(d.6 param6) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(86842);
    Looper.myLooper().quit();
    AppMethodBeat.o(86842);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.6.1
 * JD-Core Version:    0.7.0.1
 */