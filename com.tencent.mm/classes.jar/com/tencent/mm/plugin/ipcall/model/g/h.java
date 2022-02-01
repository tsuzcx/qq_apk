package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends a
{
  public boolean ysA = false;
  public int ysz = 1;
  
  public final void MC() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25525);
    if (paramc != null)
    {
      Log.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.ypJ) });
      paramc = new n(paramc.roomId, paramc.ypH, paramc.ypI, this.ysz);
      bg.azz().a(paramc, 0);
    }
    AppMethodBeat.o(25525);
  }
  
  public final int[] eaF()
  {
    return new int[] { 723 };
  }
  
  public final int getServiceType()
  {
    return 4;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.h
 * JD-Core Version:    0.7.0.1
 */