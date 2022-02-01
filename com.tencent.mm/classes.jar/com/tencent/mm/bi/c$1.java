package com.tencent.mm.bi;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c$1
  implements Runnable
{
  public c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(148376);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(148375);
        Log.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
        e.bpn().b(c.1.this.mbH);
        AppMethodBeat.o(148375);
        return false;
      }
    });
    AppMethodBeat.o(148376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bi.c.1
 * JD-Core Version:    0.7.0.1
 */