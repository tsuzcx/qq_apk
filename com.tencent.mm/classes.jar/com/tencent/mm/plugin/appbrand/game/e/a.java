package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean Bg()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pUF, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void Bh()
  {
    AppMethodBeat.i(45134);
    d locald = d.bdT();
    long l1 = bs.eWj();
    long l2 = locald.jPl.aTS().startTime;
    e.bdV().dK(2002, (int)(l1 - l2));
    e.bdV().dK(3002, locald.jSN.intValue());
    e.bdV().dK(3004, locald.jSM.intValue());
    e.bdV().dK(4002, locald.jSO.intValue());
    e.bdV().dK(3005, locald.jSP.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */