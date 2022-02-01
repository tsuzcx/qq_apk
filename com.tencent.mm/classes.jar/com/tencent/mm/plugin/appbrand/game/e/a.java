package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean Me()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((b)g.af(b.class)).a(b.a.rZF, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void Mf()
  {
    AppMethodBeat.i(45134);
    d locald = d.bDu();
    long l1 = Util.nowMilliSecond();
    long l2 = locald.kGW.bsC().startTime;
    e.bDw().dX(2002, (int)(l1 - l2));
    e.bDw().dX(3002, locald.ltZ.intValue());
    e.bDw().dX(3004, locald.ltY.intValue());
    e.bDw().dX(4002, locald.lua.intValue());
    e.bDw().dX(3005, locald.lub.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */