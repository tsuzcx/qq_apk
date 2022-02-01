package com.tencent.mm.plugin.cast.d;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/cast/manager/ScreenCastManager$initTcpTransport$2$1", "Lcom/tencent/mm/plugin/cast/transportclient/ConnectListener;", "onConnected", "", "errCode", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "plugin-cast_release"})
public final class a$d
  implements com.tencent.mm.plugin.cast.h.a
{
  a$d(a parama) {}
  
  public final void a(com.tencent.mm.plugin.cast.h.a.b paramb)
  {
    AppMethodBeat.i(190472);
    p.k(paramb, "errCode");
    Log.d("MicroMsg.ScreenCastManager", "onConnected errCode:".concat(String.valueOf(paramb)));
    this.tJB.tJy = com.tencent.mm.plugin.cast.h.a.b.tKs;
    h.ZvG.bc((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189355);
        kotlin.g.a.b localb = this.tJF.tJB.tJz;
        if (localb != null)
        {
          localb.invoke(com.tencent.mm.plugin.cast.h.a.b.tKs);
          AppMethodBeat.o(189355);
          return;
        }
        AppMethodBeat.o(189355);
      }
    });
    AppMethodBeat.o(190472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.d.a.d
 * JD-Core Version:    0.7.0.1
 */