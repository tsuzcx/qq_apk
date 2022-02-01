package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.vending.h.h;

public final class p
{
  private static p cIG;
  HandlerThread cIH;
  com.tencent.mm.vending.h.d cII;
  ao handler;
  
  private p(String paramString)
  {
    AppMethodBeat.i(19444);
    this.cIH = new HandlerThread(paramString, 10);
    this.cIH.start();
    this.handler = new ao(this.cIH.getLooper());
    this.cII = new h(com.tencent.mm.cn.d.c(this.handler), paramString);
    AppMethodBeat.o(19444);
  }
  
  public static p Kv()
  {
    AppMethodBeat.i(19443);
    if (cIG == null) {
      cIG = new p("initThread");
    }
    p localp = cIG;
    AppMethodBeat.o(19443);
    return localp;
  }
  
  public final void Kw()
  {
    AppMethodBeat.i(19445);
    if ((this.cIH == null) || (!this.cIH.isAlive()))
    {
      ac.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      AppMethodBeat.o(19445);
      return;
    }
    int i = this.cIH.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ac.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
        AppMethodBeat.o(19445);
        return;
      }
      Process.setThreadPriority(i, -8);
      ac.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(19445);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ac.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      AppMethodBeat.o(19445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.p
 * JD-Core Version:    0.7.0.1
 */