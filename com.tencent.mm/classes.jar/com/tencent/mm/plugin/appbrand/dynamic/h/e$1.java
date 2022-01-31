package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  implements Runnable
{
  e$1(Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(10960);
    Looper.myQueue().addIdleHandler(new e.1.1(this));
    AppMethodBeat.o(10960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e.1
 * JD-Core Version:    0.7.0.1
 */