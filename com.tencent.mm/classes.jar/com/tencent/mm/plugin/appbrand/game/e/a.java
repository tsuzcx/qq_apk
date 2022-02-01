package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean CF()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qzl, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void CG()
  {
    AppMethodBeat.i(45134);
    d locald = d.bhx();
    long l1 = bt.flT();
    long l2 = locald.jCo.aXc().startTime;
    e.bhz().dM(2002, (int)(l1 - l2));
    e.bhz().dM(3002, locald.knb.intValue());
    e.bhz().dM(3004, locald.kna.intValue());
    e.bhz().dM(4002, locald.knc.intValue());
    e.bhz().dM(3005, locald.knd.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */