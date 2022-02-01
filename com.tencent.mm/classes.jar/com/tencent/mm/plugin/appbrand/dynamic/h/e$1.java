package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  implements Runnable
{
  e$1(Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(121441);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(121440);
        Looper.myQueue().removeIdleHandler(this);
        e.1.this.val$runnable.run();
        AppMethodBeat.o(121440);
        return false;
      }
    });
    AppMethodBeat.o(121441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e.1
 * JD-Core Version:    0.7.0.1
 */