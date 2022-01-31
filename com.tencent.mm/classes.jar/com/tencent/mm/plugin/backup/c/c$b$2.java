package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.g.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

final class c$b$2
  implements c.c
{
  c$b$2(c.b paramb) {}
  
  public final void a(com.tencent.mm.plugin.backup.g.c paramc)
  {
    AppMethodBeat.i(17179);
    long l2 = bo.aoy();
    c.a locala = this.jzV.jzL;
    long l3 = paramc.aUC();
    boolean bool3 = this.jzV.hmf;
    long l1 = locala.jzH.get();
    boolean bool1;
    label81:
    long l4;
    if (locala.jzH.get() >= 8388608L)
    {
      bool1 = true;
      if (locala.jzH.get() < 16777216L) {
        break label379;
      }
      bool2 = true;
      ab.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (locala.jzH.get() + l3 >= 8388608L) {
        locala.jzI.close();
      }
      if (locala.jzH.get() >= 16777216L) {
        locala.jzJ.close();
      }
      l4 = bo.aoy();
      if (!locala.jzG.jzy)
      {
        long l5 = locala.jzH.get();
        if (!bool3) {
          break label385;
        }
        l1 = 16777216L;
        label215:
        if (l5 >= l1) {
          break label404;
        }
        locala.jzH.addAndGet(l3);
        l1 = bo.hl(l4);
        l4 = locala.jzH.get();
        if (locala.jzH.get() < 8388608L) {
          break label392;
        }
        bool1 = true;
        label267:
        if (locala.jzH.get() < 16777216L) {
          break label398;
        }
      }
    }
    label385:
    label392:
    label398:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jzV.jzK.offer(new c.b.2.1(this, paramc, l2));
      AppMethodBeat.o(17179);
      return;
      bool1 = false;
      break;
      label379:
      bool2 = false;
      break label81;
      l1 = 8388608L;
      break label215;
      bool1 = false;
      break label267;
    }
    label404:
    if (bool3) {}
    for (ai localai = locala.jzJ;; localai = locala.jzI)
    {
      localai.dta();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.2
 * JD-Core Version:    0.7.0.1
 */