package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

final class c$b$2$1
  implements Runnable
{
  c$b$2$1(c.b.2 param2, c paramc, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(17178);
    Assert.assertTrue(toString() + ", check running. ", this.jzY.jzV.hmf);
    long l1 = bo.aoy();
    this.jzW.aUv();
    long l2 = bo.aoy();
    ab.i(this.jzY.jzV.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(this.jzW.aUC()), Long.valueOf(l2 - this.jzX), Long.valueOf(l2 - l1), this.jzW.jFp.jKw });
    AppMethodBeat.o(17178);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(17177);
    String str = this.jzY.jzV.TAG + ".sendFile";
    AppMethodBeat.o(17177);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.2.1
 * JD-Core Version:    0.7.0.1
 */