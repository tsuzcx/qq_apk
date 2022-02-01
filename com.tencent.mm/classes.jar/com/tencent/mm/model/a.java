package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.b;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public byte[] iBl;
  public long iBm;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.iBm = -1L;
    if (aSG()) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.aSG()) {
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(226L, 1L, 1L, false);
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
  
  private void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(196995);
    if (aSF() <= 0)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(226L, 11L, 1L, false);
      Log.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", new Object[] { toString() });
      AppMethodBeat.o(196995);
      return;
    }
    int i = parame.am(this.iBl);
    if (i != 0)
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", new Object[] { Integer.valueOf(i) });
      this.iBl = null;
      AppMethodBeat.o(196995);
      return;
    }
    this.iBm = 0L;
    AppMethodBeat.o(196995);
  }
  
  public static boolean aSG()
  {
    AppMethodBeat.i(132229);
    if ((com.tencent.mm.kernel.a.azj()) || (!com.tencent.mm.kernel.g.aAc()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("AndroidUseWorkerAuthCache"), 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    int j = i.ch(com.tencent.mm.kernel.a.getUin(), 100);
    boolean bool = CrashReportFactory.hasDebuger();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    Log.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(j), Boolean.valueOf(com.tencent.mm.kernel.g.aAf().azp()) });
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
  
  public static void aSH()
  {
    AppMethodBeat.i(132230);
    if (!aSG())
    {
      AppMethodBeat.o(132230);
      return;
    }
    long l2;
    try
    {
      com.tencent.mm.kernel.g.aAi();
      a locala = com.tencent.mm.kernel.g.aAf().hpN;
      com.tencent.mm.kernel.g.aAi();
      localObject = com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh();
      l2 = Util.nowMilliSecond();
      if (localObject == null)
      {
        Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(226L, 2L, 1L, false);
        AppMethodBeat.o(132230);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(132230);
      return;
    }
    Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.network.e)localObject).aZb()), Integer.valueOf(localThrowable.aSF()) });
    if (!((com.tencent.mm.network.e)localObject).aZb())
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(226L, 3L, 1L, false);
      Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      AppMethodBeat.o(132230);
      return;
    }
    localThrowable.iBl = ((com.tencent.mm.network.e)localObject).aZe();
    Object localObject = com.tencent.mm.plugin.report.e.Cxv;
    if (localThrowable.aSF() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, l1, 1L, false);
      Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)), Integer.valueOf(localThrowable.aSF()), Long.valueOf(localThrowable.iBm) });
      if (localThrowable.aSF() > 0)
      {
        localObject = com.tencent.mm.plugin.report.e.Cxv;
        if (localThrowable.iBm <= 5L) {
          break label365;
        }
      }
    }
    label365:
    for (long l1 = 5L;; l1 = localThrowable.iBm)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.iBm) });
      localThrowable.iBm = -1L;
      AppMethodBeat.o(132230);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public static void aSI()
  {
    AppMethodBeat.i(196994);
    try
    {
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAf().hpN != null)
      {
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAg().hqi.iMw != null)
        {
          com.tencent.mm.kernel.g.aAi();
          locala = com.tencent.mm.kernel.g.aAf().hpN;
          com.tencent.mm.kernel.g.aAi();
          locala.a(com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh());
          AppMethodBeat.o(196994);
          return;
        }
      }
      com.tencent.mm.kernel.g.aAi();
      a locala = com.tencent.mm.kernel.g.aAf().hpN;
      com.tencent.mm.kernel.g.aAi();
      Log.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", new Object[] { locala, com.tencent.mm.kernel.g.aAg().hqi.iMw });
      AppMethodBeat.o(196994);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(196994);
    }
  }
  
  public final int aSF()
  {
    if (this.iBl == null) {
      return -1;
    }
    return this.iBl.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */