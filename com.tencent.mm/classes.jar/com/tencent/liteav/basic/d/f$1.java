package com.tencent.liteav.basic.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  implements Runnable
{
  f$1(Handler paramHandler, HandlerThread paramHandlerThread) {}
  
  public final void run()
  {
    AppMethodBeat.i(146568);
    new Handler(Looper.getMainLooper()).post(new f.1.1(this));
    AppMethodBeat.o(146568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.d.f.1
 * JD-Core Version:    0.7.0.1
 */