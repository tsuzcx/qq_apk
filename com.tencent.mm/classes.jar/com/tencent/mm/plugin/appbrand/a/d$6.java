package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(134722);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(134721);
        Looper.myLooper().quit();
        AppMethodBeat.o(134721);
        return false;
      }
    });
    AppMethodBeat.o(134722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.d.6
 * JD-Core Version:    0.7.0.1
 */