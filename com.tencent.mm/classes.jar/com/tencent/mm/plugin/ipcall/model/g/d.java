package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends a
{
  public final void Dd() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25519);
    if (paramc != null)
    {
      if (paramc.uLv == 0) {
        paramc.uLv = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.dHz, paramc.uLU, paramc.uLv, paramc.uLw, paramc.uLx);
      ba.aiU().a(locali, 0);
      ad.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.dHz, paramc.uLU, Integer.valueOf(paramc.uLv) });
    }
    AppMethodBeat.o(25519);
  }
  
  public final int[] ddT()
  {
    return new int[] { 991 };
  }
  
  public final int getServiceType()
  {
    return 1;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.d
 * JD-Core Version:    0.7.0.1
 */