package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.game.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class b$3
  implements a.a
{
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(143126);
    try
    {
      ab.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramString });
      k.a(paramString, b.aAC());
      AppMethodBeat.o(143126);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ab.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.game.h.b.cJ(ah.getContext());
      AppMethodBeat.o(143126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b.3
 * JD-Core Version:    0.7.0.1
 */