package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends a
{
  public int nPW = 1;
  public boolean nPX = false;
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(21910);
    if (paramc != null)
    {
      ab.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.nMZ), Integer.valueOf(paramc.nNc) });
      paramc = new n(paramc.nMZ, paramc.nNa, paramc.nNb, this.nPW);
      aw.Rc().a(paramc, 0);
    }
    AppMethodBeat.o(21910);
  }
  
  public final int[] bJz()
  {
    return new int[] { 723 };
  }
  
  public final int getServiceType()
  {
    return 4;
  }
  
  public final void onDestroy() {}
  
  public final void tW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.h
 * JD-Core Version:    0.7.0.1
 */