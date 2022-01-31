package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.udp.libmmudp.a.a;

final class b$2
  implements a.a
{
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(143125);
    try
    {
      ab.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramString });
      k.a(paramString, b.aAC());
      AppMethodBeat.o(143125);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ab.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.game.h.b.cJ(ah.getContext());
      AppMethodBeat.o(143125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b.2
 * JD-Core Version:    0.7.0.1
 */