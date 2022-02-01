package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.luggage.game.b.d;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends d
{
  public final void Cy()
  {
    AppMethodBeat.i(45113);
    super.Cy();
    long l = bt.HI();
    b.loadLibrary("gamelog_delegate");
    ad.i("MicroMsg.MBLogDelegateRegistryWC", "dl: load gamelog_delegate [%d]ms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(45113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.c
 * JD-Core Version:    0.7.0.1
 */