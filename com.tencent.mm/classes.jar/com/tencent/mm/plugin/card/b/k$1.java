package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.z.a;
import com.tencent.mm.z.c;

final class k$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(112683);
    ad.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
    g.ajC().ajl().set(al.a.Irv, "");
    g.ajC().ajl().set(al.a.IrB, Integer.valueOf(0));
    g.ajC().ajl().set(al.a.Iry, "");
    g.ajC().ajl().set(al.a.Irz, "");
    g.ajC().ajl().set(al.a.IrA, "");
    g.ajC().ajl().set(al.a.IrM, "");
    g.ajC().ajl().set(al.a.IrN, Boolean.FALSE);
    if (c.aht().cJ(262152, 266256)) {
      c.aht().x(262152, false);
    }
    if (c.aht().cI(262152, 266256)) {
      c.aht().w(262152, false);
    }
    if (c.aht().a(al.a.Irp, al.a.Irr)) {
      c.aht().a(al.a.Irp, false);
    }
    if (c.aht().a(al.a.Irq, al.a.Irs)) {
      c.aht().a(al.a.Irq, false);
    }
    ad.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    AppMethodBeat.o(112683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k.1
 * JD-Core Version:    0.7.0.1
 */