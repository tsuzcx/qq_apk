package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.luggage.game.b.d;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends d
{
  public final void CB()
  {
    AppMethodBeat.i(45113);
    super.CB();
    long l = bu.HQ();
    b.loadLibrary("gamelog_delegate");
    ae.i("MicroMsg.MBLogDelegateRegistryWC", "dl: load gamelog_delegate [%d]ms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(45113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.c
 * JD-Core Version:    0.7.0.1
 */