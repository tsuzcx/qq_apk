package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean BC()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pqS, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void BD()
  {
    AppMethodBeat.i(45134);
    d locald = d.aWV();
    long l1 = bt.eGO();
    long l2 = locald.joZ.aNc().startTime;
    e.aWX().dK(2002, (int)(l1 - l2));
    e.aWX().dK(3002, locald.jst.intValue());
    e.aWX().dK(3004, locald.jss.intValue());
    e.aWX().dK(4002, locald.jsu.intValue());
    e.aWX().dK(3005, locald.jsv.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */