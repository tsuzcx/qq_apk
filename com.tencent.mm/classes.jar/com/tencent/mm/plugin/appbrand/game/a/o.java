package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSupportMultiInstancesInProcess;", "", "()V", "SUPPORT", "", "()Z", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o rqt;
  
  static
  {
    AppMethodBeat.i(318403);
    rqt = new o();
    AppMethodBeat.o(318403);
  }
  
  public static final boolean coO()
  {
    AppMethodBeat.i(318399);
    if (((c)h.ax(c.class)).a(c.a.zmW, 0) == 1)
    {
      AppMethodBeat.o(318399);
      return true;
    }
    AppMethodBeat.o(318399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.o
 * JD-Core Version:    0.7.0.1
 */