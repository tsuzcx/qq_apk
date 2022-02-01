package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.i;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends a
{
  public final void BE() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25519);
    if (paramc != null)
    {
      if (paramc.tII == 0) {
        paramc.tII = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.dvw, paramc.tJh, paramc.tII, paramc.tIJ, paramc.tIK);
      az.agi().a(locali, 0);
      ac.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.dvw, paramc.tJh, Integer.valueOf(paramc.tII) });
    }
    AppMethodBeat.o(25519);
  }
  
  public final int[] cUI()
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