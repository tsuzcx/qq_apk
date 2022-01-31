package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

final class c$b$2$1
  implements Runnable
{
  c$b$2$1(c.b.2 param2, c paramc, long paramLong) {}
  
  public final void run()
  {
    Assert.assertTrue(toString() + ", check running. ", this.hGC.hGz.fSF);
    long l1 = bk.UY();
    this.hGA.auT();
    long l2 = bk.UY();
    y.i(this.hGC.hGz.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(this.hGA.ava()), Long.valueOf(l2 - this.hGB), Long.valueOf(l2 - l1), this.hGA.hLN.hQV });
  }
  
  public final String toString()
  {
    return this.hGC.hGz.TAG + ".sendFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.2.1
 * JD-Core Version:    0.7.0.1
 */