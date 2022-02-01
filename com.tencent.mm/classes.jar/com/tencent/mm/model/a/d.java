package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class d
  implements com.tencent.mm.am.g
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.mpN;
    if ((parama == null) || (parama.YFG == null))
    {
      Log.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = w.a(parama.YFG);
    h.baE().ban().B(328193, str);
    parama = g.bDR();
    long l = System.currentTimeMillis();
    try
    {
      parama.Kn(str);
      str = (String)h.baE().ban().d(328197, null);
      if ((Util.isNullOrNil(str)) || ((parama.ooa != null) && (!str.equals(parama.ooa.onX))))
      {
        h.baE().ban().B(328197, parama.ooa.onX);
        h.baE().ban().B(328195, Boolean.FALSE);
        h.baE().ban().B(328194, Boolean.FALSE);
        h.baE().ban().B(328196, Boolean.FALSE);
        Log.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.bDR().bDP()) {
      f.Kp(g.bDR().ooa.onX);
    }
    AppMethodBeat.o(153093);
    return null;
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */