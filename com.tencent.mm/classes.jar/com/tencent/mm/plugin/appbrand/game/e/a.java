package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends com.tencent.luggage.game.d.a
{
  public final boolean ape()
  {
    AppMethodBeat.i(45133);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yWA, false);
    AppMethodBeat.o(45133);
    return bool;
  }
  
  public final void apf()
  {
    AppMethodBeat.i(45134);
    d locald = d.cpg();
    long l1 = Util.nowMilliSecond();
    long l2 = locald.qxC.getInitConfig().startTime;
    e.cpi().fp(2002, (int)(l1 - l2));
    e.cpi().fp(3002, locald.rsG.intValue());
    e.cpi().fp(3004, locald.rsF.intValue());
    e.cpi().fp(4002, locald.rsH.intValue());
    e.cpi().fp(3005, locald.rsI.intValue());
    AppMethodBeat.o(45134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */