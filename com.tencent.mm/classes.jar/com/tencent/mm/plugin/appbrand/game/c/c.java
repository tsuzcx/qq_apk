package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.luggage.game.b.d;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends d
{
  public final void LX()
  {
    AppMethodBeat.i(45113);
    super.LX();
    long l = Util.currentTicks();
    b.loadLibrary("gamelog_delegate");
    Log.i("MicroMsg.MBLogDelegateRegistryWC", "dl: load gamelog_delegate [%d]ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(45113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.c
 * JD-Core Version:    0.7.0.1
 */