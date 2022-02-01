package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends a
{
  public int sDR = 1;
  public boolean sDS = false;
  
  public final void Ca() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25525);
    if (paramc != null)
    {
      ad.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.sBa) });
      paramc = new n(paramc.roomId, paramc.sAY, paramc.sAZ, this.sDR);
      az.aeS().a(paramc, 0);
    }
    AppMethodBeat.o(25525);
  }
  
  public final int[] cHx()
  {
    return new int[] { 723 };
  }
  
  public final int getServiceType()
  {
    return 4;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.h
 * JD-Core Version:    0.7.0.1
 */