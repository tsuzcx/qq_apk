package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.z;

final class o$3
  implements ap.a
{
  o$3(o paramo) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(77954);
    if ((!g.RJ().QU()) || (o.acQ() == null))
    {
      ab.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(g.RJ().QU()), o.acQ() });
      AppMethodBeat.o(77954);
      return false;
    }
    if (((Boolean)g.RL().Ru().get(90113, Boolean.FALSE)).booleanValue())
    {
      o.adk();
      o.adj();
    }
    g.RL().Ru().set(90113, Boolean.FALSE);
    AppMethodBeat.o(77954);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77955);
    String str = super.toString() + "|upAssetsHandler";
    AppMethodBeat.o(77955);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.o.3
 * JD-Core Version:    0.7.0.1
 */