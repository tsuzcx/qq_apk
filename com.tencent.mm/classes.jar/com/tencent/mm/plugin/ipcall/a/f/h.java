package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends a
{
  public int lsB = 1;
  public boolean lsC = false;
  
  public final int LW()
  {
    return 4;
  }
  
  public final void b(c paramc)
  {
    if (paramc != null)
    {
      y.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(paramc.lpD), Integer.valueOf(paramc.lpG) });
      paramc = new n(paramc.lpD, paramc.lpE, paramc.lpF, this.lsB);
      au.Dk().a(paramc, 0);
    }
  }
  
  public final int[] bcs()
  {
    return new int[] { 723 };
  }
  
  public final void onDestroy() {}
  
  public final void pT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.h
 * JD-Core Version:    0.7.0.1
 */