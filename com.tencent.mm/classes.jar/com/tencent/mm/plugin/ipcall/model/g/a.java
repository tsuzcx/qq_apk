package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.plugin.ipcall.model.b.a
{
  public final void Ca() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25512);
    if (paramc != null)
    {
      ad.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.sBa) });
      paramc = new com.tencent.mm.plugin.ipcall.model.e.a(paramc.roomId, paramc.sAY, paramc.dxK, paramc.sBz, paramc.sBa, paramc.sAZ);
      az.aeS().a(paramc, 0);
    }
    AppMethodBeat.o(25512);
  }
  
  public final int[] cHx()
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