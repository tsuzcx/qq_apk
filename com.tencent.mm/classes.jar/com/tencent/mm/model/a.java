package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  public byte[] hHa;
  public long hHb;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.hHb = -1L;
    if (azz()) {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.azz()) {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(132227);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bu.o(localException) });
            AppMethodBeat.o(132227);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(132228);
  }
  
  public static void azA()
  {
    AppMethodBeat.i(132230);
    if (!azz())
    {
      AppMethodBeat.o(132230);
      return;
    }
    long l2;
    try
    {
      g.ajS();
      a locala = g.ajP().gCZ;
      g.ajS();
      localObject = g.ajQ().gDv.hRo.aFs();
      l2 = bu.fpO();
      if (localObject == null)
      {
        ae.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(226L, 2L, 1L, false);
        AppMethodBeat.o(132230);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bu.o(localThrowable) });
      AppMethodBeat.o(132230);
      return;
    }
    ae.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((c)localObject).aFm()), Integer.valueOf(localThrowable.azy()) });
    if (!((c)localObject).aFm())
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(226L, 3L, 1L, false);
      ae.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      AppMethodBeat.o(132230);
      return;
    }
    localThrowable.hHa = ((c)localObject).aFp();
    Object localObject = com.tencent.mm.plugin.report.e.ywz;
    if (localThrowable.azy() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, l1, 1L, false);
      ae.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bu.DD(l2)), Integer.valueOf(localThrowable.azy()), Long.valueOf(localThrowable.hHb) });
      if (localThrowable.azy() > 0)
      {
        localObject = com.tencent.mm.plugin.report.e.ywz;
        if (localThrowable.hHb <= 5L) {
          break label365;
        }
      }
    }
    label365:
    for (long l1 = 5L;; l1 = localThrowable.hHb)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.e.ywz.f(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.hHb) });
      localThrowable.hHb = -1L;
      AppMethodBeat.o(132230);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public static boolean azz()
  {
    AppMethodBeat.i(132229);
    if ((com.tencent.mm.kernel.a.aiT()) || (!g.ajM()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = bu.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("AndroidUseWorkerAuthCache"), 0);
    g.ajS();
    g.ajP();
    int j = i.cf(com.tencent.mm.kernel.a.getUin(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.fnF();
    g.ajS();
    g.ajP();
    ae.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(j), Boolean.valueOf(g.ajP().aiZ()) });
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
  
  public final int azy()
  {
    if (this.hHa == null) {
      return -1;
    }
    return this.hHa.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */