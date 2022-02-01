package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class k$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(112683);
    Log.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
    g.aAh().azQ().set(ar.a.NTT, "");
    g.aAh().azQ().set(ar.a.NTZ, Integer.valueOf(0));
    g.aAh().azQ().set(ar.a.NTW, "");
    g.aAh().azQ().set(ar.a.NTX, "");
    g.aAh().azQ().set(ar.a.NTY, "");
    g.aAh().azQ().set(ar.a.NUk, "");
    g.aAh().azQ().set(ar.a.NUl, Boolean.FALSE);
    if (c.axV().cP(262152, 266256)) {
      c.axV().B(262152, false);
    }
    if (c.axV().cO(262152, 266256)) {
      c.axV().A(262152, false);
    }
    if (c.axV().a(ar.a.NTN, ar.a.NTP)) {
      c.axV().a(ar.a.NTN, false);
    }
    if (c.axV().a(ar.a.NTO, ar.a.NTQ)) {
      c.axV().a(ar.a.NTO, false);
    }
    Log.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    AppMethodBeat.o(112683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k.1
 * JD-Core Version:    0.7.0.1
 */