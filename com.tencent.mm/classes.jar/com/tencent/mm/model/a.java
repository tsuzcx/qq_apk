package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public byte[] hEi;
  public long hEj;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.hEj = -1L;
    if (azj()) {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.azj()) {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(132227);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bt.n(localException) });
            AppMethodBeat.o(132227);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(132228);
  }
  
  public static boolean azj()
  {
    AppMethodBeat.i(132229);
    if ((com.tencent.mm.kernel.a.aiE()) || (!g.ajx()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("AndroidUseWorkerAuthCache"), 0);
    g.ajD();
    g.ajA();
    int j = i.ce(com.tencent.mm.kernel.a.getUin(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.fjN();
    g.ajD();
    g.ajA();
    ad.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(j), Boolean.valueOf(g.ajA().aiK()) });
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
  
  public static void azk()
  {
    AppMethodBeat.i(132230);
    if (!azj())
    {
      AppMethodBeat.o(132230);
      return;
    }
    long l2;
    try
    {
      g.ajD();
      a locala = g.ajA().gAs;
      g.ajD();
      localObject = g.ajB().gAO.hOv.aFc();
      l2 = bt.flT();
      if (localObject == null)
      {
        ad.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(226L, 2L, 1L, false);
        AppMethodBeat.o(132230);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bt.n(localThrowable) });
      AppMethodBeat.o(132230);
      return;
    }
    ad.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((c)localObject).aEW()), Integer.valueOf(localThrowable.azi()) });
    if (!((c)localObject).aEW())
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(226L, 3L, 1L, false);
      ad.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      AppMethodBeat.o(132230);
      return;
    }
    localThrowable.hEi = ((c)localObject).aEZ();
    Object localObject = com.tencent.mm.plugin.report.e.ygI;
    if (localThrowable.azi() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, l1, 1L, false);
      ad.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bt.Df(l2)), Integer.valueOf(localThrowable.azi()), Long.valueOf(localThrowable.hEj) });
      if (localThrowable.azi() > 0)
      {
        localObject = com.tencent.mm.plugin.report.e.ygI;
        if (localThrowable.hEj <= 5L) {
          break label365;
        }
      }
    }
    label365:
    for (long l1 = 5L;; l1 = localThrowable.hEj)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.e.ygI.f(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.hEj) });
      localThrowable.hEj = -1L;
      AppMethodBeat.o(132230);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public final int azi()
  {
    if (this.hEi == null) {
      return -1;
    }
    return this.hEi.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */