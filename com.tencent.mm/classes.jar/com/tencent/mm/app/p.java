package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.h;

public final class p
{
  private static p cTO;
  HandlerThread cTP;
  com.tencent.mm.vending.h.d cTQ;
  ap handler;
  
  private p(String paramString)
  {
    AppMethodBeat.i(19444);
    this.cTP = new HandlerThread(paramString, 10);
    this.cTP.start();
    this.handler = new ap(this.cTP.getLooper());
    this.cTQ = new h(com.tencent.mm.cn.d.c(this.handler), paramString);
    AppMethodBeat.o(19444);
  }
  
  public static p LY()
  {
    AppMethodBeat.i(19443);
    if (cTO == null) {
      cTO = new p("initThread");
    }
    p localp = cTO;
    AppMethodBeat.o(19443);
    return localp;
  }
  
  public final void LZ()
  {
    AppMethodBeat.i(19445);
    if ((this.cTP == null) || (!this.cTP.isAlive()))
    {
      ad.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      AppMethodBeat.o(19445);
      return;
    }
    int i = this.cTP.getThreadId();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.p
 * JD-Core Version:    0.7.0.1
 */