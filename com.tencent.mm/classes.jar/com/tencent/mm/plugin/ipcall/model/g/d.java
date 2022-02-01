package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  public final void MC() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25519);
    if (paramc != null)
    {
      if (paramc.ypJ == 0) {
        paramc.ypJ = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.dkV, paramc.yqi, paramc.ypJ, paramc.ypK, paramc.ypL);
      bg.azz().a(locali, 0);
      Log.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.dkV, paramc.yqi, Integer.valueOf(paramc.ypJ) });
    }
    AppMethodBeat.o(25519);
  }
  
  public final int[] eaF()
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