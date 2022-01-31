package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.h.h;

public final class k
{
  private static k bYc;
  HandlerThread bYd;
  com.tencent.mm.vending.h.d bYe;
  ak handler;
  
  private k(String paramString)
  {
    AppMethodBeat.i(15381);
    this.bYd = com.tencent.mm.sdk.g.d.ey(paramString, 10);
    this.bYd.start();
    this.handler = new ak(this.bYd.getLooper());
    this.bYe = new h(com.tencent.mm.cm.d.c(this.handler), paramString);
    AppMethodBeat.o(15381);
  }
  
  public static k Bj()
  {
    AppMethodBeat.i(15380);
    if (bYc == null) {
      bYc = new k("initThread");
    }
    k localk = bYc;
    AppMethodBeat.o(15380);
    return localk;
  }
  
  public final void Bk()
  {
    AppMethodBeat.i(15382);
    if ((this.bYd == null) || (!this.bYd.isAlive()))
    {
      ab.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      AppMethodBeat.o(15382);
      return;
    }
    int i = this.bYd.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ab.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
        AppMethodBeat.o(15382);
        return;
      }
      Process.setThreadPriority(i, -8);
      ab.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(15382);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ab.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      AppMethodBeat.o(15382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.k
 * JD-Core Version:    0.7.0.1
 */