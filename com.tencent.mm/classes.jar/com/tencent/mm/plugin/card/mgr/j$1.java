package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class j$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(112683);
    Log.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
    h.baE().ban().set(at.a.acJn, "");
    h.baE().ban().set(at.a.acJt, Integer.valueOf(0));
    h.baE().ban().set(at.a.acJq, "");
    h.baE().ban().set(at.a.acJr, "");
    h.baE().ban().set(at.a.acJs, "");
    h.baE().ban().set(at.a.acJE, "");
    h.baE().ban().set(at.a.acJF, Boolean.FALSE);
    if (c.aYo().dW(262152, 266256)) {
      c.aYo().R(262152, false);
    }
    if (c.aYo().dV(262152, 266256)) {
      c.aYo().Q(262152, false);
    }
    if (c.aYo().a(at.a.acJh, at.a.acJj)) {
      c.aYo().a(at.a.acJh, false);
    }
    if (c.aYo().a(at.a.acJi, at.a.acJk)) {
      c.aYo().a(at.a.acJi, false);
    }
    Log.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    AppMethodBeat.o(112683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.j.1
 * JD-Core Version:    0.7.0.1
 */