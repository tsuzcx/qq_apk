package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.h;

public final class q
{
  private static q dlh;
  HandlerThread dli;
  MMHandler handler;
  com.tencent.mm.vending.h.d mScheduler;
  
  private q(String paramString)
  {
    AppMethodBeat.i(19444);
    this.dli = new HandlerThread(paramString, 10);
    this.dli.start();
    this.handler = new MMHandler(this.dli.getLooper());
    this.mScheduler = new h(com.tencent.mm.co.d.b(this.handler), paramString);
    AppMethodBeat.o(19444);
  }
  
  public static q Ws()
  {
    AppMethodBeat.i(19443);
    if (dlh == null) {
      dlh = new q("initThread");
    }
    q localq = dlh;
    AppMethodBeat.o(19443);
    return localq;
  }
  
  public final void setHighPriority()
  {
    AppMethodBeat.i(19445);
    if ((this.dli == null) || (!this.dli.isAlive()))
    {
      Log.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      AppMethodBeat.o(19445);
      return;
    }
    int i = this.dli.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        Log.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
        AppMethodBeat.o(19445);
        return;
      }
      Process.setThreadPriority(i, -8);
      Log.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(19445);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      Log.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      AppMethodBeat.o(19445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.q
 * JD-Core Version:    0.7.0.1
 */