package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends a
{
  public final int LW()
  {
    return 1;
  }
  
  public final void b(c paramc)
  {
    if (paramc != null)
    {
      if (paramc.lpG == 0) {
        paramc.lpG = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.bYR, paramc.lqf, paramc.lpG, paramc.lpH, paramc.lpI);
      au.Dk().a(locali, 0);
      y.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.bYR, paramc.lqf, Integer.valueOf(paramc.lpG) });
    }
  }
  
  public final int[] bcs()
  {
    return new int[] { 991 };
  }
  
  public final void onDestroy() {}
  
  public final void pT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.d
 * JD-Core Version:    0.7.0.1
 */