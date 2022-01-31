package com.tencent.mm.modelstat;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.io.File;

final class l$1
  implements Runnable
{
  l$1(l paraml, long paramLong) {}
  
  public final void run()
  {
    long l = bk.UY();
    y.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.DP().cachePath), this.eEf)), g.DP().cachePath });
    y.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.DP().dKs), this.eEf)), g.DP().dKs });
    y.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.DP().dKs), this.eEf)), g.DP().dKs });
    y.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.DP().dKt), this.eEf)), g.DP().dKt });
    y.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(ac.dOP), this.eEf)), ac.dOP });
    y.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(bk.UY() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.l.1
 * JD-Core Version:    0.7.0.1
 */