package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;

final class l$1
  implements Runnable
{
  l$1(l paraml, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(78743);
    long l = bo.aoy();
    ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.RL().cachePath), this.fTW)), g.RL().cachePath });
    ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.RL().eHQ), this.fTW)), g.RL().eHQ });
    ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.RL().eHQ), this.fTW)), g.RL().eHQ });
    ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(g.RL().eHR), this.fTW)), g.RL().eHR });
    ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new File(ac.eQv), this.fTW)), ac.eQv });
    ab.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(bo.aoy() - l) });
    AppMethodBeat.o(78743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.l.1
 * JD-Core Version:    0.7.0.1
 */