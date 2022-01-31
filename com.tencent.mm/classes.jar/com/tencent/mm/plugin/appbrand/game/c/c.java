package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.luggage.game.c.d;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends d
{
  public final void uE()
  {
    AppMethodBeat.i(143131);
    super.uE();
    long l = bo.yB();
    b.loadLibrary("gamelog_delegate");
    ab.i("MicroMsg.MBLogDelegateRegistryWC", "dl: load gamelog_delegate [%d]ms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(143131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.c
 * JD-Core Version:    0.7.0.1
 */