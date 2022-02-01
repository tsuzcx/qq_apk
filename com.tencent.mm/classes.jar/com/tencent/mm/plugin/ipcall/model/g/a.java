package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends com.tencent.mm.plugin.ipcall.model.b.a
{
  public final void BE() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25512);
    if (paramc != null)
    {
      ac.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.tII) });
      paramc = new com.tencent.mm.plugin.ipcall.model.e.a(paramc.roomId, paramc.tIG, paramc.dvw, paramc.tJh, paramc.tII, paramc.tIH);
      az.agi().a(paramc, 0);
    }
    AppMethodBeat.o(25512);
  }
  
  public final int[] cUI()
  {
    return new int[] { 843 };
  }
  
  public final int getServiceType()
  {
    return 3;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.a
 * JD-Core Version:    0.7.0.1
 */