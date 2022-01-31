package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public byte[] fkn;
  public long fko;
  
  public a()
  {
    AppMethodBeat.i(58084);
    this.fko = -1L;
    if (Yt()) {
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(58083);
          try
          {
            if (a.Yt()) {
              com.tencent.mm.plugin.report.e.qrI.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(58083);
            return;
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bo.l(localException) });
            AppMethodBeat.o(58083);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(58084);
  }
  
  public static boolean Yt()
  {
    AppMethodBeat.i(58085);
    if ((com.tencent.mm.kernel.a.QP()) || (!g.RG()))
    {
      AppMethodBeat.o(58085);
      return false;
    }
    int i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("AndroidUseWorkerAuthCache"), 0);
    g.RM();
    g.RJ();
    int j = i.bQ(com.tencent.mm.kernel.a.getUin(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.dsf();
    g.RM();
    g.RJ();
    ab.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(j), Boolean.valueOf(g.RJ().QU()) });
    if (bool)
    {
      AppMethodBeat.o(58085);
      return true;
    }
    if (i > j)
    {
      AppMethodBeat.o(58085);
      return true;
    }
    AppMethodBeat.o(58085);
    return false;
  }
  
  public static void Yu()
  {
    AppMethodBeat.i(58086);
    if (!Yt())
    {
      AppMethodBeat.o(58086);
      return;
    }
    long l2;
    try
    {
      g.RM();
      a locala = g.RJ().eGV;
      g.RM();
      localObject = g.RK().eHt.ftA.adI();
      l2 = bo.aoy();
      if (localObject == null)
      {
        ab.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(226L, 2L, 1L, false);
        AppMethodBeat.o(58086);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bo.l(localThrowable) });
      AppMethodBeat.o(58086);
      return;
    }
    ab.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((c)localObject).adC()), Integer.valueOf(localThrowable.Ys()) });
    if (!((c)localObject).adC())
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(226L, 3L, 1L, false);
      ab.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      AppMethodBeat.o(58086);
      return;
    }
    localThrowable.fkn = ((c)localObject).adF();
    Object localObject = com.tencent.mm.plugin.report.e.qrI;
    if (localThrowable.Ys() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, l1, 1L, false);
      ab.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bo.hl(l2)), Integer.valueOf(localThrowable.Ys()), Long.valueOf(localThrowable.fko) });
      if (localThrowable.Ys() > 0)
      {
        localObject = com.tencent.mm.plugin.report.e.qrI;
        if (localThrowable.fko <= 5L) {
          break label365;
        }
      }
    }
    label365:
    for (long l1 = 5L;; l1 = localThrowable.fko)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.e.qrI.e(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.fko) });
      localThrowable.fko = -1L;
      AppMethodBeat.o(58086);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public final int Ys()
  {
    if (this.fkn == null) {
      return -1;
    }
    return this.fkn.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */