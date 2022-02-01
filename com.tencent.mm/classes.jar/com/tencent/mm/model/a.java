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
  public byte[] gLv;
  public long gLw;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.gLw = -1L;
    if (apG()) {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.apG()) {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(132227);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bt.m(localException) });
            AppMethodBeat.o(132227);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(132228);
  }
  
  public static boolean apG()
  {
    AppMethodBeat.i(132229);
    if ((com.tencent.mm.kernel.a.aeC()) || (!g.afw()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("AndroidUseWorkerAuthCache"), 0);
    g.afC();
    g.afz();
    int j = i.cf(com.tencent.mm.kernel.a.getUin(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.eEQ();
    g.afC();
    g.afz();
    ad.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(j), Boolean.valueOf(g.afz().aeI()) });
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
  
  public static void apH()
  {
    AppMethodBeat.i(132230);
    if (!apG())
    {
      AppMethodBeat.o(132230);
      return;
    }
    long l2;
    try
    {
      g.afC();
      a locala = g.afz().gcc;
      g.afC();
      localObject = g.afA().gcy.gVH.avg();
      l2 = bt.eGO();
      if (localObject == null)
      {
        ad.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(226L, 2L, 1L, false);
        AppMethodBeat.o(132230);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bt.m(localThrowable) });
      AppMethodBeat.o(132230);
      return;
    }
    ad.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((c)localObject).ava()), Integer.valueOf(localThrowable.apF()) });
    if (!((c)localObject).ava())
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(226L, 3L, 1L, false);
      ad.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      AppMethodBeat.o(132230);
      return;
    }
    localThrowable.gLv = ((c)localObject).avd();
    Object localObject = com.tencent.mm.plugin.report.e.vIY;
    if (localThrowable.apF() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, l1, 1L, false);
      ad.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bt.vM(l2)), Integer.valueOf(localThrowable.apF()), Long.valueOf(localThrowable.gLw) });
      if (localThrowable.apF() > 0)
      {
        localObject = com.tencent.mm.plugin.report.e.vIY;
        if (localThrowable.gLw <= 5L) {
          break label365;
        }
      }
    }
    label365:
    for (long l1 = 5L;; l1 = localThrowable.gLw)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.e.vIY.f(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.gLw) });
      localThrowable.gLw = -1L;
      AppMethodBeat.o(132230);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public final int apF()
  {
    if (this.gLv == null) {
      return -1;
    }
    return this.gLv.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */