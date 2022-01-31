package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(86843);
    Looper.myQueue().addIdleHandler(new d.6.1(this));
    AppMethodBeat.o(86843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.6
 * JD-Core Version:    0.7.0.1
 */