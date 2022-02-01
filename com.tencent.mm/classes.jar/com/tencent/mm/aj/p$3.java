package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;

final class p$3
  implements aw.a
{
  p$3(p paramp) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(150318);
    if ((!g.ajP().aiZ()) || (p.aEA() == null))
    {
      ae.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(g.ajP().aiZ()), p.aEA() });
      AppMethodBeat.o(150318);
      return false;
    }
    if (((Boolean)g.ajR().ajA().get(90113, Boolean.FALSE)).booleanValue())
    {
      p.aER();
      p.aEQ();
    }
    g.ajR().ajA().set(90113, Boolean.FALSE);
    AppMethodBeat.o(150318);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150319);
    String str = super.toString() + "|upAssetsHandler";
    AppMethodBeat.o(150319);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.p.3
 * JD-Core Version:    0.7.0.1
 */