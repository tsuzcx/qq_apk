package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public byte[] hlV;
  public long hlW;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.hlW = -1L;
    if (awv()) {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.awv()) {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(132227);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bs.m(localException) });
            AppMethodBeat.o(132227);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(132228);
  }
  
  public static boolean awv()
  {
    AppMethodBeat.i(132229);
    if ((com.tencent.mm.kernel.a.afS()) || (!g.agM()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("AndroidUseWorkerAuthCache"), 0);
    g.agS();
    g.agP();
    int j = i.cc(com.tencent.mm.kernel.a.getUin(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.eUk();
    g.agS();
    g.agP();
    ac.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(j), Boolean.valueOf(g.agP().afY()) });
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
  
  public static void aww()
  {
    AppMethodBeat.i(132230);
    if (!awv())
    {
      AppMethodBeat.o(132230);
      return;
    }
    long l2;
    try
    {
      g.agS();
      a locala = g.agP().ggI;
      g.agS();
      localObject = g.agQ().ghe.hwg.aBZ();
      l2 = bs.eWj();
      if (localObject == null)
      {
        ac.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(226L, 2L, 1L, false);
        AppMethodBeat.o(132230);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bs.m(localThrowable) });
      AppMethodBeat.o(132230);
      return;
    }
    ac.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((c)localObject).aBT()), Integer.valueOf(localThrowable.awu()) });
    if (!((c)localObject).aBT())
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(226L, 3L, 1L, false);
      ac.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      AppMethodBeat.o(132230);
      return;
    }
    localThrowable.hlV = ((c)localObject).aBW();
    Object localObject = com.tencent.mm.plugin.report.e.wTc;
    if (localThrowable.awu() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, l1, 1L, false);
      ac.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bs.Ap(l2)), Integer.valueOf(localThrowable.awu()), Long.valueOf(localThrowable.hlW) });
      if (localThrowable.awu() > 0)
      {
        localObject = com.tencent.mm.plugin.report.e.wTc;
        if (localThrowable.hlW <= 5L) {
          break label365;
        }
      }
    }
    label365:
    for (long l1 = 5L;; l1 = localThrowable.hlW)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.e.wTc.f(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.hlW) });
      localThrowable.hlW = -1L;
      AppMethodBeat.o(132230);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public final int awu()
  {
    if (this.hlV == null) {
      return -1;
    }
    return this.hlV.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */