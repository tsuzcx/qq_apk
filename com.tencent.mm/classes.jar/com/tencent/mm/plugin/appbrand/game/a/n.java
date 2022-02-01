package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSupportMultiInstancesInProcess;", "", "()V", "SUPPORT", "", "()Z", "plugin-appbrand-integration_release"})
public final class n
{
  public static final n omJ;
  
  static
  {
    AppMethodBeat.i(282699);
    omJ = new n();
    AppMethodBeat.o(282699);
  }
  
  public static final boolean bOz()
  {
    AppMethodBeat.i(282698);
    if (((b)h.ae(b.class)).a(b.a.vUt, 0) == 1)
    {
      AppMethodBeat.o(282698);
      return true;
    }
    AppMethodBeat.o(282698);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.n
 * JD-Core Version:    0.7.0.1
 */