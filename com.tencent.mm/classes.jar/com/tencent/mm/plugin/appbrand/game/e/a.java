package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.e.a
{
  public final boolean uM()
  {
    AppMethodBeat.i(143148);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWc, false);
    AppMethodBeat.o(143148);
    return bool;
  }
  
  public final void uN()
  {
    AppMethodBeat.i(143149);
    d locald = d.aAQ();
    long l1 = bo.aoy();
    long l2 = locald.htX.atS().startTime;
    e.aAT().de(2002, (int)(l1 - l2));
    e.aAT().de(3002, locald.huf.intValue());
    e.aAT().de(3004, locald.hue.intValue());
    e.aAT().de(4002, locald.hug.intValue());
    e.aAT().de(3005, locald.huh.intValue());
    AppMethodBeat.o(143149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */