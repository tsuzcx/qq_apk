package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.plugin.ipcall.a.a.a
{
  public final void b(c paramc)
  {
    AppMethodBeat.i(21897);
    if (paramc != null)
    {
      ab.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.nMZ), Integer.valueOf(paramc.nNc) });
      paramc = new com.tencent.mm.plugin.ipcall.a.d.a(paramc.nMZ, paramc.nNa, paramc.cGY, paramc.nNB, paramc.nNc, paramc.nNb);
      aw.Rc().a(paramc, 0);
    }
    AppMethodBeat.o(21897);
  }
  
  public final int[] bJz()
  {
    return new int[] { 843 };
  }
  
  public final int getServiceType()
  {
    return 3;
  }
  
  public final void onDestroy() {}
  
  public final void tW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.a
 * JD-Core Version:    0.7.0.1
 */