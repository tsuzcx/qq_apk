package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean CI()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qGr, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void CJ()
  {
    AppMethodBeat.i(45134);
    d locald = d.bif();
    long l1 = bu.fpO();
    long l2 = locald.jFm.aXx().startTime;
    e.bih().dM(2002, (int)(l1 - l2));
    e.bih().dM(3002, locald.kqr.intValue());
    e.bih().dM(3004, locald.kqq.intValue());
    e.bih().dM(4002, locald.kqs.intValue());
    e.bih().dM(3005, locald.kqt.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */