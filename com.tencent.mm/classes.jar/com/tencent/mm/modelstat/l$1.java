package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah;

final class l$1
  implements Runnable
{
  l$1(l paraml, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(151087);
    long l = bs.eWj();
    ac.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(g.agR().cachePath), this.hXg)), g.agR().cachePath });
    ac.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(g.agR().ghB), this.hXg)), g.agR().ghB });
    ac.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(g.agR().ghB), this.hXg)), g.agR().ghB });
    ac.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(g.agR().ghC), this.hXg)), g.agR().ghC });
    ac.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(ah.GDu), this.hXg)), ah.GDu });
    ac.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(bs.eWj() - l) });
    AppMethodBeat.o(151087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.l.1
 * JD-Core Version:    0.7.0.1
 */