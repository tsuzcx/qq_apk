package com.tencent.liteav.screencapture;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$3
  implements Runnable
{
  a$3(a parama, Handler paramHandler, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    AppMethodBeat.i(66766);
    this.c.a.post(new a.3.1(this));
    AppMethodBeat.o(66766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.3
 * JD-Core Version:    0.7.0.1
 */