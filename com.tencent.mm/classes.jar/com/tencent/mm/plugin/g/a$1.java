package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.al.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(nr paramnr1, nr paramnr2, nr paramnr3) {}
  
  public final void run()
  {
    AppMethodBeat.i(79084);
    g.a locala = new g.a();
    long l2 = -1L;
    f.afL();
    long l1 = l2;
    if (f.afN() != null)
    {
      l1 = l2;
      if (this.kDs != null)
      {
        f.afL();
        f.afN().a(this.kDs, this.kDt, this.kDu);
        l1 = locala.Mm();
      }
    }
    ab.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.Mm()), Long.valueOf(l1) });
    AppMethodBeat.o(79084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.1
 * JD-Core Version:    0.7.0.1
 */