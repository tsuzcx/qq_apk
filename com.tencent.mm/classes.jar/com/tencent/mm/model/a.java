package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public byte[] lqP;
  public long lqQ;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.lqQ = -1L;
    if (bbF()) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.bbF()) {
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(132227);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { Util.stackTraceToString(localException) });
            AppMethodBeat.o(132227);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(132228);
  }
  
  private void a(e parame)
  {
    AppMethodBeat.i(207959);
    if (bbE() <= 0)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(226L, 11L, 1L, false);
      Log.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", new Object[] { toString() });
      AppMethodBeat.o(207959);
      return;
    }
    int i = parame.aw(this.lqP);
    if (i != 0)
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", new Object[] { Integer.valueOf(i) });
      this.lqP = null;
      AppMethodBeat.o(207959);
      return;
    }
    this.lqQ = 0L;
    AppMethodBeat.o(207959);
  }
  
  public static boolean bbF()
  {
    AppMethodBeat.i(132229);
    if ((b.aGE()) || (!h.aHB()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("AndroidUseWorkerAuthCache"), 0);
    h.aHH();
    h.aHE();
    int j = i.cA(b.getUin(), 100);
    boolean bool = CrashReportFactory.hasDebuger();
    h.aHH();
    h.aHE();
    Log.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(b.getUin()), Integer.valueOf(j), Boolean.valueOf(h.aHE().aGM()) });
    if (bool)
    {
      AppMethodBeat.o(132229);
      return true;
    }
    if (i > j)
    {
      AppMethodBeat.o(132229);
      return true;
    }
    AppMethodBeat.o(132229);
    return false;
  }
  
  public static void bbG()
  {
    AppMethodBeat.i(207957);
    try
    {
      h.aHH();
      if (h.aHE().kbH != null)
      {
        h.aHH();
        if (h.aHF().kcd.lCD != null)
        {
          h.aHH();
          locala = h.aHE().kbH;
          h.aHH();
          locala.a(h.aHF().kcd.lCD.biw());
          AppMethodBeat.o(207957);
          return;
        }
      }
      h.aHH();
      a locala = h.aHE().kbH;
      h.aHH();
      Log.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", new Object[] { locala, h.aHF().kcd.lCD });
      AppMethodBeat.o(207957);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(207957);
    }
  }
  
  public final int bbE()
  {
    if (this.lqP == null) {
      return -1;
    }
    return this.lqP.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */