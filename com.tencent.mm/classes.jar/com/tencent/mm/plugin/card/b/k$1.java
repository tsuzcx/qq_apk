package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class k$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(112683);
    Log.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
    h.aHG().aHp().set(ar.a.VhT, "");
    h.aHG().aHp().set(ar.a.VhZ, Integer.valueOf(0));
    h.aHG().aHp().set(ar.a.VhW, "");
    h.aHG().aHp().set(ar.a.VhX, "");
    h.aHG().aHp().set(ar.a.VhY, "");
    h.aHG().aHp().set(ar.a.Vik, "");
    h.aHG().aHp().set(ar.a.Vil, Boolean.FALSE);
    if (c.aFn().dk(262152, 266256)) {
      c.aFn().D(262152, false);
    }
    if (c.aFn().dj(262152, 266256)) {
      c.aFn().C(262152, false);
    }
    if (c.aFn().a(ar.a.VhN, ar.a.VhP)) {
      c.aFn().a(ar.a.VhN, false);
    }
    if (c.aFn().a(ar.a.VhO, ar.a.VhQ)) {
      c.aFn().a(ar.a.VhO, false);
    }
    Log.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    AppMethodBeat.o(112683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k.1
 * JD-Core Version:    0.7.0.1
 */