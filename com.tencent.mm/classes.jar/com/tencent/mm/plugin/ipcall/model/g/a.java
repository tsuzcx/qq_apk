package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.plugin.ipcall.model.b.a
{
  public final void Dd() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25512);
    if (paramc != null)
    {
      ad.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.uLv) });
      paramc = new com.tencent.mm.plugin.ipcall.model.e.a(paramc.roomId, paramc.uLt, paramc.dHz, paramc.uLU, paramc.uLv, paramc.uLu);
      ba.aiU().a(paramc, 0);
    }
    AppMethodBeat.o(25512);
  }
  
  public final int[] ddT()
  {
    return new int[] { 843 };
  }
  
  public final int getServiceType()
  {
    return 3;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.a
 * JD-Core Version:    0.7.0.1
 */