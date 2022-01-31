package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class b$8
  implements Runnable
{
  b$8(b paramb, String paramString, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(78042);
    g localg = (g)this.fyR.fyM.get(this.Cq);
    if (localg == null)
    {
      ab.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { this.Cq });
      AppMethodBeat.o(78042);
      return;
    }
    if (localg.edF != null) {
      localg.edF.a(this.Cq, this.fyV);
    }
    AppMethodBeat.o(78042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.b.8
 * JD-Core Version:    0.7.0.1
 */