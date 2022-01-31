package com.tencent.mm.model;

import com.tencent.mm.a.h;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public byte[] dUd;
  public long dUe = -1L;
  
  public a()
  {
    if (Fp()) {
      ai.l(new Runnable()
      {
        public final void run()
        {
          try
          {
            if (a.Fp()) {
              f.nEG.a(226L, 1L, 1L, false);
            }
            return;
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bk.j(localException) });
          }
        }
      }, 5000L);
    }
  }
  
  public static boolean Fp()
  {
    if ((com.tencent.mm.kernel.a.CW()) || (!g.DK())) {
      return false;
    }
    int i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("AndroidUseWorkerAuthCache"), 0);
    g.DQ();
    g.DN();
    int j = h.aT(com.tencent.mm.kernel.a.CK(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.cqk();
    g.DQ();
    g.DN();
    y.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.CK()), Integer.valueOf(j), Boolean.valueOf(g.DN().Dc()) });
    if (bool) {
      return true;
    }
    return i > j;
  }
  
  public static void Fq()
  {
    if (!Fp()) {
      return;
    }
    long l2;
    try
    {
      g.DQ();
      a locala = g.DN().dJw;
      g.DQ();
      localObject = g.DO().dJT.edx.KR();
      l2 = bk.UY();
      if (localObject == null)
      {
        y.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        f.nEG.a(226L, 2L, 1L, false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      y.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bk.j(localThrowable) });
      return;
    }
    y.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((c)localObject).KN()), Integer.valueOf(localThrowable.Fo()) });
    if (!((c)localObject).KN())
    {
      f.nEG.a(226L, 3L, 1L, false);
      y.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      return;
    }
    localThrowable.dUd = ((c)localObject).KQ();
    Object localObject = f.nEG;
    if (localThrowable.Fo() > 0) {}
    for (long l1 = 4L;; l1 = 5L)
    {
      ((f)localObject).a(226L, l1, 1L, false);
      y.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bk.co(l2)), Integer.valueOf(localThrowable.Fo()), Long.valueOf(localThrowable.dUe) });
      if (localThrowable.Fo() <= 0) {
        break;
      }
      localObject = f.nEG;
      if (localThrowable.dUe > 5L) {}
      for (l1 = 5L;; l1 = localThrowable.dUe)
      {
        ((f)localObject).a(226L, 31L - l1, 1L, false);
        f.nEG.f(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.dUe) });
        localThrowable.dUe = -1L;
        return;
      }
    }
  }
  
  public final int Fo()
  {
    if (this.dUd == null) {
      return -1;
    }
    return this.dUd.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */