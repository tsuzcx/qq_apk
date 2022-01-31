package com.tencent.liteav.beauty.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

class w$1
  implements Runnable
{
  w$1(w paramw) {}
  
  public void run()
  {
    AppMethodBeat.i(146392);
    synchronized (w.a(this.a))
    {
      w.b(this.a);
      w.a(this.a).notify();
      AppMethodBeat.o(146392);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.w.1
 * JD-Core Version:    0.7.0.1
 */