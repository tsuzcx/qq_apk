package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ai;

final class p$3
  implements av.a
{
  p$3(p paramp) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(150318);
    if ((!g.ajA().aiK()) || (p.aEk() == null))
    {
      ad.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(g.ajA().aiK()), p.aEk() });
      AppMethodBeat.o(150318);
      return false;
    }
    if (((Boolean)g.ajC().ajl().get(90113, Boolean.FALSE)).booleanValue())
    {
      p.aEB();
      p.aEA();
    }
    g.ajC().ajl().set(90113, Boolean.FALSE);
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
 * Qualified Name:     com.tencent.mm.ak.p.3
 * JD-Core Version:    0.7.0.1
 */