package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.plugin.ipcall.a.a.a
{
  public final int LW()
  {
    return 3;
  }
  
  public final void b(c paramc)
  {
    if (paramc != null)
    {
      y.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.lpD), Integer.valueOf(paramc.lpG) });
      paramc = new com.tencent.mm.plugin.ipcall.a.d.a(paramc.lpD, paramc.lpE, paramc.bYR, paramc.lqf, paramc.lpG, paramc.lpF);
      au.Dk().a(paramc, 0);
    }
  }
  
  public final int[] bcs()
  {
    return new int[] { 843 };
  }
  
  public final void onDestroy() {}
  
  public final void pT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.a
 * JD-Core Version:    0.7.0.1
 */