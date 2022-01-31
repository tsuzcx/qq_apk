package com.tencent.mm.bf;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$1
  implements Runnable
{
  public c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(116540);
    Looper.myQueue().addIdleHandler(new c.1.1(this));
    AppMethodBeat.o(116540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bf.c.1
 * JD-Core Version:    0.7.0.1
 */