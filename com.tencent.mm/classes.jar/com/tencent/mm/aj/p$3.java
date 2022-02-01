package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ao;

final class p$3
  implements MTimerHandler.CallBack
{
  p$3(p paramp) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(150318);
    if ((!g.aAf().azp()) || (p.aYn() == null))
    {
      Log.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(g.aAf().azp()), p.aYn() });
      AppMethodBeat.o(150318);
      return false;
    }
    if (((Boolean)g.aAh().azQ().get(90113, Boolean.FALSE)).booleanValue())
    {
      p.aYF();
      p.aYE();
    }
    g.aAh().azQ().set(90113, Boolean.FALSE);
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