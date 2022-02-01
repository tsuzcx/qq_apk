package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.i;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends a
{
  public final void Dg() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25519);
    if (paramc != null)
    {
      if (paramc.uXi == 0) {
        paramc.uXi = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.cUB, paramc.uXH, paramc.uXi, paramc.uXj, paramc.uXk);
      bc.ajj().a(locali, 0);
      ae.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.cUB, paramc.uXH, Integer.valueOf(paramc.uXi) });
    }
    AppMethodBeat.o(25519);
  }
  
  public final int[] dgL()
  {
    return new int[] { 991 };
  }
  
  public final int getServiceType()
  {
    return 1;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.d
 * JD-Core Version:    0.7.0.1
 */