package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.k.c;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.sdk.platformtools.ab;

final class ah$1
  implements k.c
{
  public final boolean auq()
  {
    AppMethodBeat.i(129159);
    boolean bool = ah.access$100();
    AppMethodBeat.o(129159);
    return bool;
  }
  
  public final boolean yi(String paramString)
  {
    AppMethodBeat.i(129158);
    if (c.Ea(paramString))
    {
      ab.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
      AppMethodBeat.o(129158);
      return true;
    }
    boolean bool = ah.access$000();
    AppMethodBeat.o(129158);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.1
 * JD-Core Version:    0.7.0.1
 */