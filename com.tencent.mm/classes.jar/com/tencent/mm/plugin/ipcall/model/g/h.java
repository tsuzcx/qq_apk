package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends a
{
  public int uOm = 1;
  public boolean uOn = false;
  
  public final void Dd() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25525);
    if (paramc != null)
    {
      ad.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.uLv) });
      paramc = new n(paramc.roomId, paramc.uLt, paramc.uLu, this.uOm);
      ba.aiU().a(paramc, 0);
    }
    AppMethodBeat.o(25525);
  }
  
  public final int[] ddT()
  {
    return new int[] { 723 };
  }
  
  public final int getServiceType()
  {
    return 4;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.h
 * JD-Core Version:    0.7.0.1
 */