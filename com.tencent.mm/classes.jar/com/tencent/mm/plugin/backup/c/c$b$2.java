package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.g.c.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

final class c$b$2
  implements c.c
{
  c$b$2(c.b paramb) {}
  
  public final void a(com.tencent.mm.plugin.backup.g.c paramc)
  {
    long l2 = bk.UY();
    c.a locala = this.hGz.hGp;
    long l3 = paramc.ava();
    boolean bool3 = this.hGz.fSF;
    long l1 = locala.hGl.get();
    boolean bool1;
    label75:
    long l4;
    if (locala.hGl.get() >= 8388608L)
    {
      bool1 = true;
      if (locala.hGl.get() < 16777216L) {
        break label367;
      }
      bool2 = true;
      y.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (locala.hGl.get() + l3 >= 8388608L) {
        locala.hGm.close();
      }
      if (locala.hGl.get() >= 16777216L) {
        locala.hGn.close();
      }
      l4 = bk.UY();
      if (!locala.hGk.hGc)
      {
        long l5 = locala.hGl.get();
        if (!bool3) {
          break label373;
        }
        l1 = 16777216L;
        label209:
        if (l5 >= l1) {
          break label392;
        }
        locala.hGl.addAndGet(l3);
        l1 = bk.co(l4);
        l4 = locala.hGl.get();
        if (locala.hGl.get() < 8388608L) {
          break label380;
        }
        bool1 = true;
        label261:
        if (locala.hGl.get() < 16777216L) {
          break label386;
        }
      }
    }
    label386:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.hGz.hGo.offer(new c.b.2.1(this, paramc, l2));
      return;
      bool1 = false;
      break;
      label367:
      bool2 = false;
      break label75;
      label373:
      l1 = 8388608L;
      break label209;
      label380:
      bool1 = false;
      break label261;
    }
    label392:
    if (bool3) {}
    for (af localaf = locala.hGn;; localaf = locala.hGm)
    {
      localaf.crb();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.2
 * JD-Core Version:    0.7.0.1
 */