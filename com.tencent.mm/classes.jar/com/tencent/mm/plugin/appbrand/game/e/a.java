package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean OW()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vGF, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void OX()
  {
    AppMethodBeat.i(45134);
    d locald = d.bOS();
    long l1 = Util.nowMilliSecond();
    long l2 = locald.nAH.bDy().startTime;
    e.bOU().ew(2002, (int)(l1 - l2));
    e.bOU().ew(3002, locald.ooY.intValue());
    e.bOU().ew(3004, locald.ooX.intValue());
    e.bOU().ew(4002, locald.ooZ.intValue());
    e.bOU().ew(3005, locald.opa.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */