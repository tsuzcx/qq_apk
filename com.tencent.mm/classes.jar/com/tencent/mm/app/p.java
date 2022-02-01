package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.h;

public final class p
{
  private static p cLy;
  com.tencent.mm.vending.h.d cLA;
  HandlerThread cLz;
  ap handler;
  
  private p(String paramString)
  {
    AppMethodBeat.i(19444);
    this.cLz = new HandlerThread(paramString, 10);
    this.cLz.start();
    this.handler = new ap(this.cLz.getLooper());
    this.cLA = new h(com.tencent.mm.co.d.c(this.handler), paramString);
    AppMethodBeat.o(19444);
  }
  
  public static p KK()
  {
    AppMethodBeat.i(19443);
    if (cLy == null) {
      cLy = new p("initThread");
    }
    p localp = cLy;
    AppMethodBeat.o(19443);
    return localp;
  }
  
  public final void KL()
  {
    AppMethodBeat.i(19445);
    if ((this.cLz == null) || (!this.cLz.isAlive()))
    {
      ad.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      AppMethodBeat.o(19445);
      return;
    }
    int i = this.cLz.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ad.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
        AppMethodBeat.o(19445);
        return;
      }
      Process.setThreadPriority(i, -8);
      ad.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(19445);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ad.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      AppMethodBeat.o(19445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.p
 * JD-Core Version:    0.7.0.1
 */