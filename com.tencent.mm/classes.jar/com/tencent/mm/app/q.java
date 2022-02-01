package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.h.h;

public final class q
{
  private static q cUN;
  HandlerThread cUO;
  com.tencent.mm.vending.h.d cUP;
  aq handler;
  
  private q(String paramString)
  {
    AppMethodBeat.i(19444);
    this.cUO = new HandlerThread(paramString, 10);
    this.cUO.start();
    this.handler = new aq(this.cUO.getLooper());
    this.cUP = new h(com.tencent.mm.cm.d.c(this.handler), paramString);
    AppMethodBeat.o(19444);
  }
  
  public static q Mg()
  {
    AppMethodBeat.i(19443);
    if (cUN == null) {
      cUN = new q("initThread");
    }
    q localq = cUN;
    AppMethodBeat.o(19443);
    return localq;
  }
  
  public final void Mh()
  {
    AppMethodBeat.i(19445);
    if ((this.cUO == null) || (!this.cUO.isAlive()))
    {
      ae.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      AppMethodBeat.o(19445);
      return;
    }
    int i = this.cUO.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ae.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
        AppMethodBeat.o(19445);
        return;
      }
      Process.setThreadPriority(i, -8);
      ae.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(19445);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ae.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      AppMethodBeat.o(19445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.q
 * JD-Core Version:    0.7.0.1
 */