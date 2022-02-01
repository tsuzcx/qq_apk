package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends a
{
  public final void Ca() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25519);
    if (paramc != null)
    {
      if (paramc.sBa == 0) {
        paramc.sBa = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.dxK, paramc.sBz, paramc.sBa, paramc.sBb, paramc.sBc);
      az.aeS().a(locali, 0);
      ad.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.dxK, paramc.sBz, Integer.valueOf(paramc.sBa) });
    }
    AppMethodBeat.o(25519);
  }
  
  public final int[] cHx()
  {
    return new int[] { 991 };
  }
  
  public final int getServiceType()
  {
    return 1;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.d
 * JD-Core Version:    0.7.0.1
 */