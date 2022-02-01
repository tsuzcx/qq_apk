package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.plugin.ipcall.model.b.a
{
  public final void Dg() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25512);
    if (paramc != null)
    {
      ae.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.uXi) });
      paramc = new com.tencent.mm.plugin.ipcall.model.e.a(paramc.roomId, paramc.uXg, paramc.cUB, paramc.uXH, paramc.uXi, paramc.uXh);
      bc.ajj().a(paramc, 0);
    }
    AppMethodBeat.o(25512);
  }
  
  public final int[] dgL()
  {
    return new int[] { 843 };
  }
  
  public final int getServiceType()
  {
    return 3;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.a
 * JD-Core Version:    0.7.0.1
 */