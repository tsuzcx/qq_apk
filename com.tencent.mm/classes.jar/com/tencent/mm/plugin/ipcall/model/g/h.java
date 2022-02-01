package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends a
{
  public boolean tLA = false;
  public int tLz = 1;
  
  public final void BE() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25525);
    if (paramc != null)
    {
      ac.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.roomId), Integer.valueOf(paramc.tII) });
      paramc = new n(paramc.roomId, paramc.tIG, paramc.tIH, this.tLz);
      az.agi().a(paramc, 0);
    }
    AppMethodBeat.o(25525);
  }
  
  public final int[] cUI()
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