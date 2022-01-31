package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicLong;

final class c$b$1
  implements com.tencent.mm.plugin.backup.g.c.b
{
  c$b$1(c.b paramb) {}
  
  public final void e(boolean paramBoolean, String paramString, int paramInt)
  {
    c.a locala = this.hGz.hGp;
    long l1 = paramInt;
    locala.hGl.addAndGet(0L - l1);
    if (locala.hGl.get() < 8388608L) {
      locala.hGm.open();
    }
    if (locala.hGl.get() < 16777216L) {
      locala.hGn.open();
    }
    long l2 = locala.hGl.get();
    boolean bool1;
    if (locala.hGl.get() >= 8388608L)
    {
      bool1 = true;
      if (locala.hGl.get() < 16777216L) {
        break label254;
      }
    }
    label254:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(locala.hGm.ufm), Boolean.valueOf(locala.hGn.ufm) });
      this.hGz.hGk.hGf += paramInt;
      y.i(this.hGz.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.1
 * JD-Core Version:    0.7.0.1
 */